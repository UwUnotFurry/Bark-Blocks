package uwunotfurry.bark_blocks.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;

import net.minecraft.advancements.criterion.DataComponentMatchers;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.predicates.DataComponentPredicates;
import net.minecraft.core.component.predicates.EnchantmentsPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import uwunotfurry.bark_blocks.world.level.block.Blocks;
import uwunotfurry.bark_blocks.world.level.storage.loot.LootTables;

public class SimpleLootTableProvider extends SimpleFabricLootTableProvider {

	private final HolderLookup.Provider registries;

	public SimpleLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(output, registryLookup, LootContextParamSets.BLOCK_INTERACT);
		try {
			registries = registryLookup.get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void generate(BiConsumer<ResourceKey<LootTable>, 	LootTable.Builder> lootTableBiConsumer) {
		lootTableBiConsumer.accept(LootTables.STRIP_OAK, 		requireSilkTouchForBark(Blocks.OAK_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_SPRUCE,		requireSilkTouchForBark(Blocks.SPRUCE_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_BIRCH,		requireSilkTouchForBark(Blocks.BIRCH_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_JUNGLE,		requireSilkTouchForBark(Blocks.JUNGLE_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_ACACIA,		requireSilkTouchForBark(Blocks.ACACIA_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_DARK_OAK,	requireSilkTouchForBark(Blocks.DARK_OAK_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_MANGROVE,	requireSilkTouchForBark(Blocks.MANGROVE_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_CHERRY,		requireSilkTouchForBark(Blocks.CHERRY_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_PALE_OAK,	requireSilkTouchForBark(Blocks.PALE_OAK_BARK));
		lootTableBiConsumer.accept(LootTables.STRIP_CRIMSON,	requireSilkTouchForBark(Blocks.CRIMSON_ANNULUS));
		lootTableBiConsumer.accept(LootTables.STRIP_WARPED,		requireSilkTouchForBark(Blocks.WARPED_ANNULUS));
	}

	public LootTable.Builder requireSilkTouchForBark(ItemLike bark) {
		return LootTable.lootTable()
			.withPool(LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1.0f))
				.add(LootItem.lootTableItem(bark)
					.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
				)
				.when(
					MatchTool.toolMatches(
						ItemPredicate.Builder.item()
							.withComponents(
								DataComponentMatchers.Builder.components()
									.partial(
										DataComponentPredicates.ENCHANTMENTS,
										EnchantmentsPredicate.enchantments(List.of(
											new EnchantmentPredicate(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(
												Enchantments.SILK_TOUCH),
												MinMaxBounds.Ints.atLeast(1)
											)
										))
									).build()
							)
					)
				)
			)
		;
	}
}