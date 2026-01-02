package uwunotfurry.bark_blocks.datagen;

import java.lang.reflect.*;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.data.worldgen.features.FallenTreeBarkFeatures;
import uwunotfurry.bark_blocks.data.worldgen.features.VegetationFeatures;
import uwunotfurry.bark_blocks.data.worldgen.placement.FallenTreeBarkPlacements;

public class BarkBlocksDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModelProvider::new);
		pack.addProvider(BlockLootTableProvider::new);
		pack.addProvider(SimpleLootTableProvider::new);
		pack.addProvider(RegistryProvider::new);
		pack.addProvider(BlockTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder builder) {
		builder.add(Registries.CONFIGURED_FEATURE,	FallenTreeBarkFeatures::bootstrap);
		builder.add(Registries.PLACED_FEATURE,		FallenTreeBarkPlacements::bootstrap);
		builder.add(Registries.CONFIGURED_FEATURE,	VegetationFeatures.Subfeatures::bootstrap);
		builder.add(Registries.PLACED_FEATURE,		VegetationFeatures.Subplacements::bootstrap);
	}
}