package uwunotfurry.bark_blocks.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import uwunotfurry.bark_blocks.data.worldgen.features.VegetationFeatures;

public class RegistryProvider extends FabricDynamicRegistryProvider {
	public RegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE));
		entries.addAll(registries.lookupOrThrow(Registries.PLACED_FEATURE));

		VegetationFeatures.bootstrap(registries, entries);
	}

	@Override
	public String getName() {
		return "Bark Blocks Dynamic Registery Provider";
	}
}