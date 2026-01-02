package uwunotfurry.bark_blocks.world.level.block;

import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.level.block.HollowRotatedPillarBlock;

public class Blocks {

	public static final Block OAK_BARK = register(
		"oak_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.OAK_LOG)
	);
	public static final Block SPRUCE_BARK = register(
		"spruce_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.SPRUCE_LOG)
	);
	public static final Block BIRCH_BARK = register(
		"birch_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.BIRCH_LOG)
	);
	public static final Block JUNGLE_BARK = register(
		"jungle_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.JUNGLE_LOG)
	);
	public static final Block ACACIA_BARK = register(
		"acacia_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.ACACIA_LOG)
	);
	public static final Block DARK_OAK_BARK = register(
		"dark_oak_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.DARK_OAK_LOG)
	);
	public static final Block MANGROVE_BARK = register(
		"mangrove_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.MANGROVE_LOG)
	);
	public static final Block CHERRY_BARK = register(
		"cherry_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CHERRY_LOG)
	);
	public static final Block PALE_OAK_BARK = register(
		"pale_oak_bark",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.PALE_OAK_LOG)
	);
	public static final Block CRIMSON_ANNULUS = register(
		"crimson_annulus",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRIMSON_STEM)
	);
	public static final Block WARPED_ANNULUS = register(
		"warped_annulus",
		HollowRotatedPillarBlock::new,
		BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.WARPED_STEM)
	);

	public static void onInitialise() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(itemGroup -> {
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.OAK_WOOD, OAK_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.SPRUCE_WOOD, SPRUCE_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.BIRCH_WOOD, BIRCH_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.JUNGLE_WOOD, JUNGLE_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.ACACIA_WOOD, ACACIA_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.DARK_OAK_WOOD, DARK_OAK_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.MANGROVE_WOOD, MANGROVE_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.CHERRY_WOOD, CHERRY_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.PALE_OAK_WOOD, PALE_OAK_BARK);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.CRIMSON_HYPHAE, CRIMSON_ANNULUS);
			itemGroup.addAfter(net.minecraft.world.level.block.Blocks.WARPED_HYPHAE, WARPED_ANNULUS);
		});

		FlammableBlockRegistry.getDefaultInstance().add(OAK_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(BIRCH_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ACACIA_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(CHERRY_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(PALE_OAK_BARK, 30, 60);

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(OAK_BARK,		150);
			builder.add(SPRUCE_BARK,	150);
			builder.add(BIRCH_BARK,		150);
			builder.add(JUNGLE_BARK,	150);
			builder.add(ACACIA_BARK,	150);
			builder.add(DARK_OAK_BARK,	150);
			builder.add(MANGROVE_BARK,	150);
			builder.add(CHERRY_BARK,	150);
			builder.add(PALE_OAK_BARK,	150);
		});
	}

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings) {
		ResourceKey<Block> blockKey = keyOfBlock(name);
		Block block = blockFactory.apply(settings.setId(blockKey));

		ResourceKey<Item> itemKey = keyOfItem(name);
		BlockItem item = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());

		Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
	}
}