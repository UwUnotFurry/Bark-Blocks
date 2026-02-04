package uwunotfurry.bark_blocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.data.worldgen.features.FallenTreeFeatures;
import uwunotfurry.bark_blocks.data.worldgen.placements.FallenTreePlacements;

public class BarkBlocksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(WorldgenProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder builder) {
		builder.add(Registries.CONFIGURED_FEATURE, context -> {
			context.register(FallenTreeFeatures.FALLEN_OAK_TREE_BARK,				null);
			context.register(FallenTreeFeatures.FALLEN_SPRUCE_TREE_BARK,			null);
			context.register(FallenTreeFeatures.FALLEN_BIRCH_TREE_BARK,				null);
			context.register(FallenTreeFeatures.FALLEN_SUPER_BIRCH_TREE_BARK,		null);
			context.register(FallenTreeFeatures.FALLEN_JUNGLE_TREE_BARK,			null);

			context.register(FallenTreeFeatures.FALLEN_OAK_TREE_ORIGINAL,			null);
			context.register(FallenTreeFeatures.FALLEN_SPRUCE_TREE_ORIGINAL,		null);
			context.register(FallenTreeFeatures.FALLEN_BIRCH_TREE_ORIGINAL,			null);
			context.register(FallenTreeFeatures.FALLEN_SUPER_BIRCH_TREE_ORIGINAL,	null);
			context.register(FallenTreeFeatures.FALLEN_JUNGLE_TREE_ORIGINAL,		null);
		});

		builder.add(Registries.PLACED_FEATURE, context -> {
			context.register(FallenTreePlacements.FALLEN_OAK_TREE_BARK,				null);
			context.register(FallenTreePlacements.FALLEN_SPRUCE_TREE_BARK,			null);
			context.register(FallenTreePlacements.FALLEN_BIRCH_TREE_BARK,			null);
			context.register(FallenTreePlacements.FALLEN_SUPER_BIRCH_TREE_BARK,		null);
			context.register(FallenTreePlacements.FALLEN_JUNGLE_TREE_BARK,			null);

			context.register(FallenTreePlacements.FALLEN_OAK_TREE_ORIGINAL,			null);
			context.register(FallenTreePlacements.FALLEN_SPRUCE_TREE_ORIGINAL,		null);
			context.register(FallenTreePlacements.FALLEN_BIRCH_TREE_ORIGINAL,		null);
			context.register(FallenTreePlacements.FALLEN_SUPER_BIRCH_TREE_ORIGINAL,	null);
			context.register(FallenTreePlacements.FALLEN_JUNGLE_TREE_ORIGINAL,		null);
		});
	}
}
