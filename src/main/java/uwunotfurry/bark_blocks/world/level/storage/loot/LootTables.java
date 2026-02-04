package uwunotfurry.bark_blocks.world.level.storage.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

import uwunotfurry.bark_blocks.BarkBlocks;

public class LootTables {

	public static final ResourceKey<LootTable> STRIP_OAK 		= register("oak");
	public static final ResourceKey<LootTable> STRIP_SPRUCE 	= register("spruce");
	public static final ResourceKey<LootTable> STRIP_BIRCH		= register("birch");
	public static final ResourceKey<LootTable> STRIP_JUNGLE		= register("jungle");
	public static final ResourceKey<LootTable> STRIP_ACACIA		= register("acacia");
	public static final ResourceKey<LootTable> STRIP_DARK_OAK	= register("dark_oak");
	public static final ResourceKey<LootTable> STRIP_MANGROVE	= register("mangrove");
	public static final ResourceKey<LootTable> STRIP_CHERRY		= register("cherry");
	public static final ResourceKey<LootTable> STRIP_PALE_OAK	= register("pale_oak");
	public static final ResourceKey<LootTable> STRIP_CRIMSON	= register("crimson");
	public static final ResourceKey<LootTable> STRIP_WARPED		= register("warped");

	private static ResourceKey<LootTable> register(String name) {
		ResourceKey<LootTable> key = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(BarkBlocks.MOD_ID, "gameplay/strip/" + name));

		if (BuiltInLootTables.all().contains(key)) {
			throw new IllegalArgumentException(key + " is already a registered built-in loot table");
		}

		return key;
	}

}