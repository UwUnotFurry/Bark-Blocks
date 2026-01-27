package uwunotfurry.bark_blocks.world.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

import uwunotfurry.bark_blocks.world.level.block.Blocks;

public class Items {

	public static Item OAK_BARK			= registerBlock(Blocks.OAK_BARK);
	public static Item SPRUCE_BARK		= registerBlock(Blocks.SPRUCE_BARK);
	public static Item BIRCH_BARK		= registerBlock(Blocks.BIRCH_BARK);
	public static Item JUNGLE_BARK		= registerBlock(Blocks.JUNGLE_BARK);
	public static Item ACACIA_BARK		= registerBlock(Blocks.ACACIA_BARK);
	public static Item DARK_OAK_BARK	= registerBlock(Blocks.DARK_OAK_BARK);
	public static Item MANGROVE_BARK	= registerBlock(Blocks.MANGROVE_BARK);
	public static Item CRIMSON_ANNULUS	= registerBlock(Blocks.CRIMSON_ANNULUS);
	public static Item WARPED_ANNULUS	= registerBlock(Blocks.WARPED_ANNULUS);

	public static void  onInitialise() {
		FuelRegistry.INSTANCE.add(OAK_BARK,			150);
		FuelRegistry.INSTANCE.add(SPRUCE_BARK,		150);
		FuelRegistry.INSTANCE.add(BIRCH_BARK,		150);
		FuelRegistry.INSTANCE.add(JUNGLE_BARK,		150);
		FuelRegistry.INSTANCE.add(ACACIA_BARK,		150);
		FuelRegistry.INSTANCE.add(DARK_OAK_BARK,	150);
		FuelRegistry.INSTANCE.add(MANGROVE_BARK,	150);
	}

	private static Item registerBlock(Block block) {
		BlockItem item =  new BlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
		item.registerBlocks(Item.BY_BLOCK, item);
		return (Item)Registry.register(Registry.ITEM, Registry.BLOCK.getKey(block), item);
	}
}