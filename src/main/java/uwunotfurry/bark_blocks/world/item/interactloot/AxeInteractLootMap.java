package uwunotfurry.bark_blocks.world.item.interactloot;

import java.util.Map;
import java.util.IdentityHashMap;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.level.storage.loot.LootTables;

public class AxeInteractLootMap {

	private static final Map<Block, ResourceLocation> Block2LootMap = new IdentityHashMap<>(12);

	public static void add(Block block, ResourceLocation loot) {
		Block2LootMap.put(block, loot);
	}
	public static ResourceLocation get(Block block) {
		return Block2LootMap.get(block);
	}
	public static boolean contains(Block block) {
		return Block2LootMap.containsKey(block);
	}

	static {
		add(Blocks.OAK_LOG,  LootTables.STRIP_OAK);
		add(Blocks.OAK_WOOD, LootTables.STRIP_OAK);

		add(Blocks.SPRUCE_LOG,  LootTables.STRIP_SPRUCE);
		add(Blocks.SPRUCE_WOOD, LootTables.STRIP_SPRUCE);

		add(Blocks.BIRCH_LOG,  LootTables.STRIP_BIRCH);
		add(Blocks.BIRCH_WOOD, LootTables.STRIP_BIRCH);

		add(Blocks.JUNGLE_LOG,  LootTables.STRIP_JUNGLE);
		add(Blocks.JUNGLE_WOOD, LootTables.STRIP_JUNGLE);

		add(Blocks.ACACIA_LOG,  LootTables.STRIP_ACACIA);
		add(Blocks.ACACIA_WOOD, LootTables.STRIP_ACACIA);

		add(Blocks.DARK_OAK_LOG,  LootTables.STRIP_DARK_OAK);
		add(Blocks.DARK_OAK_WOOD, LootTables.STRIP_DARK_OAK);

		add(Blocks.MANGROVE_LOG,  LootTables.STRIP_MANGROVE);
		add(Blocks.MANGROVE_WOOD, LootTables.STRIP_MANGROVE);

		add(Blocks.CHERRY_LOG,  LootTables.STRIP_CHERRY);
		add(Blocks.CHERRY_WOOD, LootTables.STRIP_CHERRY);

		add(Blocks.CRIMSON_STEM,   LootTables.STRIP_CRIMSON);
		add(Blocks.CRIMSON_HYPHAE, LootTables.STRIP_CRIMSON);

		add(Blocks.WARPED_STEM,   LootTables.STRIP_WARPED);
		add(Blocks.WARPED_HYPHAE, LootTables.STRIP_WARPED);
	}
}