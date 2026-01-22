package uwunotfurry.bark_blocks.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;

import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.Vec3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.item.interactloot.AxeInteractLootMap;

@Mixin(AxeItem.class)
public class AxeItemMixin {

	@Inject(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"))
	private void dropAxeUseOnLoot(
		CallbackInfoReturnable __,
		@Local UseOnContext context,
		@Local Level level,
		@Local BlockPos pos
	) {
		BlockState state = level.getBlockState(pos);
		Block block = state.getBlock();

		if (AxeInteractLootMap.contains(block) && level instanceof ServerLevel) {
			LootTable lootTable = ((ServerLevel)level).getServer().getLootTables().get(AxeInteractLootMap.get(block));
			LootContext lootContext = (new LootContext.Builder((ServerLevel)level))
				.withRandom(level.random)
				.withParameter(LootContextParams.TOOL, context.getItemInHand())
				.withParameter(LootContextParams.BLOCK_STATE, state)
				.withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
				.create(LootContextParamSets.BLOCK)
			;
			for (ItemStack items : lootTable.getRandomItems(lootContext)) {
				Block.popResourceFromFace(level, pos, context.getClickedFace(), items);
			}
		}
	}
}