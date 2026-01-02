package uwunotfurry.bark_blocks.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

import net.minecraft.core.HolderLookup;

import uwunotfurry.bark_blocks.world.level.block.Blocks;

public class BlockLootTableProvider extends FabricBlockLootTableProvider {

	protected BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		dropSelf(Blocks.OAK_BARK);
		dropSelf(Blocks.SPRUCE_BARK);
		dropSelf(Blocks.BIRCH_BARK);
		dropSelf(Blocks.JUNGLE_BARK);
		dropSelf(Blocks.ACACIA_BARK);
		dropSelf(Blocks.DARK_OAK_BARK);
		dropSelf(Blocks.MANGROVE_BARK);
		dropSelf(Blocks.CHERRY_BARK);
		dropSelf(Blocks.PALE_OAK_BARK);
		dropSelf(Blocks.CRIMSON_ANNULUS);
		dropSelf(Blocks.WARPED_ANNULUS);
	}
}