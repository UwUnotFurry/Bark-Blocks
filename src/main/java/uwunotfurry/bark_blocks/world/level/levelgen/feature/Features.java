package uwunotfurry.bark_blocks.world.level.levelgen.feature;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FallenTreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.level.levelgen.feature.FallenTreeBarkFeature;

public class Features {
	public static final Feature<FallenTreeConfiguration> FALLEN_TREE_BARK;

	private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String name, F feature) {
		return (F)Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(BarkBlocks.MOD_ID, name), feature);
	}

	public static void onInitialise() {}

	static {
		FALLEN_TREE_BARK = register("fallen_tree_bark", new FallenTreeBarkFeature(FallenTreeConfiguration.CODEC));
	}
}