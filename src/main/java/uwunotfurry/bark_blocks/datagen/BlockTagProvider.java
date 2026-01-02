package uwunotfurry.bark_blocks.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import uwunotfurry.bark_blocks.world.level.block.Blocks;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public BlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
			.add(Blocks.OAK_BARK)
			.add(Blocks.SPRUCE_BARK)
			.add(Blocks.BIRCH_BARK)
			.add(Blocks.JUNGLE_BARK)
			.add(Blocks.ACACIA_BARK)
			.add(Blocks.DARK_OAK_BARK)
			.add(Blocks.MANGROVE_BARK)
			.add(Blocks.CHERRY_BARK)
			.add(Blocks.PALE_OAK_BARK)
			.add(Blocks.CRIMSON_ANNULUS)
			.add(Blocks.WARPED_ANNULUS)
		;
	}
}