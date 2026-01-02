package uwunotfurry.bark_blocks.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;

import java.util.Optional;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

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
		@Local BlockPos pos,
		@Local Player player,
		@Local ItemStack axe
	) {
		BlockState state = level.getBlockState(pos);
		Block block = state.getBlock();

		if (AxeInteractLootMap.contains(block) && level instanceof ServerLevel) {
			Block.dropFromBlockInteractLootTable(
				(ServerLevel)level,
				AxeInteractLootMap.get(block),
				state,
				null,
				axe,
				player,
				(_level, stack) -> {
					Block.popResourceFromFace(_level, pos, context.getClickedFace(), stack);
				}
			);
		}
	}
}