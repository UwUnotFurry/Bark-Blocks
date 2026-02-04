package uwunotfurry.bark_blocks.world.level.block;

import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.level.block.HollowRotatedPillarBlock;

public class Blocks {

	public static final Block OAK_BARK = register(
		"oak_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.OAK_LOG)
	);
	public static final Block SPRUCE_BARK = register(
		"spruce_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.SPRUCE_LOG)
	);
	public static final Block BIRCH_BARK = register(
		"birch_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.BIRCH_LOG)
	);
	public static final Block JUNGLE_BARK = register(
		"jungle_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.JUNGLE_LOG)
	);
	public static final Block ACACIA_BARK = register(
		"acacia_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.ACACIA_LOG)
	);
	public static final Block DARK_OAK_BARK = register(
		"dark_oak_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.DARK_OAK_LOG)
	);
	public static final Block MANGROVE_BARK = register(
		"mangrove_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.MANGROVE_LOG)
	);
	public static final Block CHERRY_BARK = register(
		"cherry_bark",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CHERRY_LOG)
	);
	public static final Block CRIMSON_ANNULUS = register(
		"crimson_annulus",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRIMSON_STEM)
	);
	public static final Block WARPED_ANNULUS = register(
		"warped_annulus",
		HollowRotatedPillarBlock::new,
		Block.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.WARPED_STEM)
	);

	public static void onInitialise() {
		FlammableBlockRegistry.getDefaultInstance().add(OAK_BARK,		30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_BARK,	30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(BIRCH_BARK,		30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_BARK,	30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ACACIA_BARK,	30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_BARK,	30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(MANGROVE_BARK,	30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(CHERRY_BARK,	30, 60);

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(OAK_BARK,		150);
			builder.add(SPRUCE_BARK,	150);
			builder.add(BIRCH_BARK,		150);
			builder.add(JUNGLE_BARK,	150);
			builder.add(ACACIA_BARK,	150);
			builder.add(DARK_OAK_BARK,	150);
			builder.add(MANGROVE_BARK,	150);
			builder.add(CHERRY_BARK,	150);
		});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
			content.addAfter(Items.OAK_WOOD,		OAK_BARK);
			content.addAfter(Items.SPRUCE_WOOD,		SPRUCE_BARK);
			content.addAfter(Items.BIRCH_WOOD,		BIRCH_BARK);
			content.addAfter(Items.JUNGLE_WOOD,		JUNGLE_BARK);
			content.addAfter(Items.ACACIA_WOOD,		ACACIA_BARK);
			content.addAfter(Items.DARK_OAK_WOOD,	DARK_OAK_BARK);
			content.addAfter(Items.MANGROVE_WOOD,	MANGROVE_BARK);
			content.addAfter(Items.CHERRY_WOOD,		CHERRY_BARK);
			content.addAfter(Items.CRIMSON_HYPHAE,	CRIMSON_ANNULUS);
			content.addAfter(Items.WARPED_HYPHAE,	WARPED_ANNULUS);
		});
	}

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		Block block = net.minecraft.world.level.block.Blocks.register(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BarkBlocks.MOD_ID, name)), blockFactory, properties);
		Items.registerBlock(block);
		return block;
	}
}