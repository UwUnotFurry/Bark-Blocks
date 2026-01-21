package uwunotfurry.bark_blocks.world.level.block;

import java.util.function.Function;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.level.block.HollowRotatedPillarBlock;

public class Blocks {

	public static final Block OAK_BARK = register(
		"oak_bark",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.OAK_LOG)
		)
	);
	public static final Block SPRUCE_BARK = register(
		"spruce_bark",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.SPRUCE_LOG)
		)
	);
	public static final Block BIRCH_BARK = register(
		"birch_bark",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.BIRCH_LOG)
		)
	);
	public static final Block JUNGLE_BARK = register(
		"jungle_bark",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.JUNGLE_LOG)
		)
	);
	public static final Block ACACIA_BARK = register(
		"acacia_bark",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.ACACIA_LOG)
		)
	);
	public static final Block DARK_OAK_BARK = register(
		"dark_oak_bark",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.DARK_OAK_LOG)
		)
	);
	public static final Block CRIMSON_ANNULUS = register(
		"crimson_annulus",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.CRIMSON_STEM)
		)
	);
	public static final Block WARPED_ANNULUS = register(
		"warped_annulus",
		new HollowRotatedPillarBlock(Block.Properties.copy(
			net.minecraft.world.level.block.Blocks.WARPED_STEM)
		)
	);

	public static void onInitialise() {
		FlammableBlockRegistry.getDefaultInstance().add(OAK_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(SPRUCE_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(BIRCH_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(JUNGLE_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ACACIA_BARK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(DARK_OAK_BARK, 30, 60);
	}

	private static Block register(String name, Block block) {
		return (Block)Registry.register(Registry.BLOCK, new ResourceLocation(BarkBlocks.MOD_ID, name), block);
	}
}