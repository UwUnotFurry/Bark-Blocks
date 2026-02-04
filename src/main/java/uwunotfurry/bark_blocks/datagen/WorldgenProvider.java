package uwunotfurry.bark_blocks.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.data.worldgen.features.FallenTreeFeatures;
import uwunotfurry.bark_blocks.data.worldgen.placements.FallenTreePlacements;

public class WorldgenProvider extends FabricDynamicRegistryProvider {
	public WorldgenProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		FallenTreeFeatures.bootstrap(registries, entries);
		FallenTreePlacements.bootstrap(registries, entries);
		FallenTreeFeatures.overrideVanillaBootstrap(registries, entries);
	}

	@Override
	public String getName() {
		return "Bark Blocks Worldgen Provider";
	}
}