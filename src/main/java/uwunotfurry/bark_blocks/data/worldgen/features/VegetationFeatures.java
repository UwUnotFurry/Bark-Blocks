package uwunotfurry.bark_blocks.data.worldgen.features;

import com.google.common.collect.ImmutableList;

import java.lang.reflect.*;
import java.util.List;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.data.worldgen.placement.FallenTreeBarkPlacements;

public class VegetationFeatures {

	/*
		Subfeatures and subplacements are new features and placements but act only to modify existing
		features and placements, hence why they are 'sub' and further their being inner to this class
		- which makes these changes.

		The subfeatures and subplacements act as replacements for the original versions of the fallen
		tree features and placements - this is the most surefire way to ensure the relative frequency
		of the bark versions compared to the originals.
	*/

	public static class Subfeatures {
		private static float FALLEN_TREE_REPLACE_CHANCE = 0.2f;

		public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_OAK_TREE_OR_BARK			= createKey("fallen_oak_tree_or_bark");
		public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_JUNGLE_TREE_OR_BARK		= createKey("fallen_jungle_tree_or_bark");
		public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SPRUCE_TREE_OR_BARK		= createKey("fallen_spruce_tree_or_bark");
		public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_BIRCH_TREE_OR_BARK		= createKey("fallen_birch_tree_or_bark");
		public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SUPER_BIRCH_TREE_OR_BARK	= createKey("fallen_super_birch_tree_or_bark");

		public static ResourceKey<ConfiguredFeature<?,?>> createKey(String name) {
			return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
		}

		public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context) {
			HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

			FeatureUtils.register(context, FALLEN_OAK_TREE_OR_BARK,			Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(FallenTreeBarkPlacements.FALLEN_OAK_TREE_BARK),			FALLEN_TREE_REPLACE_CHANCE)), placedFeatures.getOrThrow(TreePlacements.FALLEN_OAK_TREE)));
			FeatureUtils.register(context, FALLEN_JUNGLE_TREE_OR_BARK,		Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(FallenTreeBarkPlacements.FALLEN_JUNGLE_TREE_BARK),		FALLEN_TREE_REPLACE_CHANCE)), placedFeatures.getOrThrow(TreePlacements.FALLEN_JUNGLE_TREE)));
			FeatureUtils.register(context, FALLEN_SPRUCE_TREE_OR_BARK,		Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(FallenTreeBarkPlacements.FALLEN_SPRUCE_TREE_BARK),		FALLEN_TREE_REPLACE_CHANCE)), placedFeatures.getOrThrow(TreePlacements.FALLEN_SPRUCE_TREE)));
			FeatureUtils.register(context, FALLEN_BIRCH_TREE_OR_BARK,		Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(FallenTreeBarkPlacements.FALLEN_BIRCH_TREE_BARK),		FALLEN_TREE_REPLACE_CHANCE)), placedFeatures.getOrThrow(TreePlacements.FALLEN_BIRCH_TREE)));
			FeatureUtils.register(context, FALLEN_SUPER_BIRCH_TREE_OR_BARK,	Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeatures.getOrThrow(FallenTreeBarkPlacements.FALLEN_SUPER_BIRCH_TREE_BARK),	FALLEN_TREE_REPLACE_CHANCE)), placedFeatures.getOrThrow(TreePlacements.FALLEN_SUPER_BIRCH_TREE)));
		}
	}

	public static class Subplacements {

		public static final ResourceKey<PlacedFeature> FALLEN_OAK_TREE_OR_BARK			= createKey("fallen_oak_tree_or_bark");
		public static final ResourceKey<PlacedFeature> FALLEN_JUNGLE_TREE_OR_BARK		= createKey("fallen_jungle_tree_or_bark");
		public static final ResourceKey<PlacedFeature> FALLEN_SPRUCE_TREE_OR_BARK		= createKey("fallen_spruce_tree_or_bark");
		public static final ResourceKey<PlacedFeature> FALLEN_BIRCH_TREE_OR_BARK		= createKey("fallen_birch_tree_or_bark");
		public static final ResourceKey<PlacedFeature> FALLEN_SUPER_BIRCH_TREE_OR_BARK	= createKey("fallen_super_birch_tree_or_bark");

		public static ResourceKey<PlacedFeature> createKey(String name) {
			return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
		}

		public static void bootstrap(BootstrapContext<PlacedFeature> context) {
			HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

			PlacementUtils.register(context, FALLEN_OAK_TREE_OR_BARK,			configuredFeatures.getOrThrow(Subfeatures.FALLEN_OAK_TREE_OR_BARK),			List.of());
			PlacementUtils.register(context, FALLEN_JUNGLE_TREE_OR_BARK,		configuredFeatures.getOrThrow(Subfeatures.FALLEN_JUNGLE_TREE_OR_BARK),		List.of());
			PlacementUtils.register(context, FALLEN_SPRUCE_TREE_OR_BARK,		configuredFeatures.getOrThrow(Subfeatures.FALLEN_SPRUCE_TREE_OR_BARK),		List.of());
			PlacementUtils.register(context, FALLEN_BIRCH_TREE_OR_BARK,			configuredFeatures.getOrThrow(Subfeatures.FALLEN_BIRCH_TREE_OR_BARK),		List.of());
			PlacementUtils.register(context, FALLEN_SUPER_BIRCH_TREE_OR_BARK,	configuredFeatures.getOrThrow(Subfeatures.FALLEN_SUPER_BIRCH_TREE_OR_BARK),	List.of());
		}
	}

	public static void bootstrap(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {

		HolderLookup.RegistryLookup<ConfiguredFeature<?,?>> configuredFeatures = registries.lookupOrThrow(Registries.CONFIGURED_FEATURE);
		HolderLookup.RegistryLookup<PlacedFeature> placedFeatures = registries.lookupOrThrow(Registries.PLACED_FEATURE);

		Holder<PlacedFeature> fallenOakTreeOrBark			= placedFeatures.get(Subplacements.FALLEN_OAK_TREE_OR_BARK).get();
		Holder<PlacedFeature> fallenJungleTreeOrBark		= placedFeatures.get(Subplacements.FALLEN_JUNGLE_TREE_OR_BARK).get();
		Holder<PlacedFeature> fallenSpruceTreeOrBark		= placedFeatures.get(Subplacements.FALLEN_SPRUCE_TREE_OR_BARK).get();
		Holder<PlacedFeature> fallenBirchTreeOrBark			= placedFeatures.get(Subplacements.FALLEN_BIRCH_TREE_OR_BARK).get();
		Holder<PlacedFeature> fallenSuperBirchTreeOrBark	= placedFeatures.get(Subplacements.FALLEN_SUPER_BIRCH_TREE_OR_BARK).get();

		try {
			for (Field keyField : net.minecraft.data.worldgen.features.VegetationFeatures.class.getDeclaredFields()) {
				if (Modifier.isStatic(keyField.getModifiers())) {
					Type keyType = keyField.getGenericType();
					if (keyType instanceof ParameterizedType && ((ParameterizedType)keyType).getRawType() == ResourceKey.class) {
						Type keyParameterType = ((ParameterizedType)keyType).getActualTypeArguments()[0];
						if (keyParameterType instanceof ParameterizedType && ((ParameterizedType)keyParameterType).getRawType() == ConfiguredFeature.class) {

							ConfiguredFeature<?,?> feature = configuredFeatures.get((ResourceKey<ConfiguredFeature<?,?>>)(keyField.get(null))).get().value();
							if (feature.config() instanceof RandomFeatureConfiguration) {
								WeightedPlacedFeature[] randomFeatures = ((RandomFeatureConfiguration)feature.config()).features.toArray(new WeightedPlacedFeature[0]);
								boolean shouldReplace = false;
								for (int index = 0; index < randomFeatures.length; index++) {
									Holder<PlacedFeature> fallenTreeBarkFeature = randomFeatures[index].feature;
									if (fallenTreeBarkFeature.is(TreePlacements.FALLEN_OAK_TREE)) {
										randomFeatures[index] = new WeightedPlacedFeature(fallenOakTreeOrBark, randomFeatures[index].chance);
										shouldReplace = true;
									} else if (fallenTreeBarkFeature.is(TreePlacements.FALLEN_JUNGLE_TREE)) {
										randomFeatures[index] = new WeightedPlacedFeature(fallenJungleTreeOrBark, randomFeatures[index].chance);
										shouldReplace = true;
									} else if (fallenTreeBarkFeature.is(TreePlacements.FALLEN_SPRUCE_TREE)) {
										randomFeatures[index] = new WeightedPlacedFeature(fallenSpruceTreeOrBark, randomFeatures[index].chance);
										shouldReplace = true;
									} else if (fallenTreeBarkFeature.is(TreePlacements.FALLEN_BIRCH_TREE)) {
										randomFeatures[index] = new WeightedPlacedFeature(fallenBirchTreeOrBark, randomFeatures[index].chance);
										shouldReplace = true;
									} else if (fallenTreeBarkFeature.is(TreePlacements.FALLEN_SUPER_BIRCH_TREE)) {
										randomFeatures[index] = new WeightedPlacedFeature(fallenSuperBirchTreeOrBark, randomFeatures[index].chance);
										shouldReplace = true;
									}
								}

								Holder<PlacedFeature> defaultFeature = ((RandomFeatureConfiguration)feature.config()).defaultFeature;
								if (defaultFeature.is(TreePlacements.FALLEN_OAK_TREE)) {
									defaultFeature = fallenOakTreeOrBark;
									shouldReplace = true;
								} else if (defaultFeature.is(TreePlacements.FALLEN_JUNGLE_TREE)) {
									defaultFeature = fallenJungleTreeOrBark;
									shouldReplace = true;
								} else if (defaultFeature.is(TreePlacements.FALLEN_SPRUCE_TREE)) {
									defaultFeature = fallenSpruceTreeOrBark;
									shouldReplace = true;
								} else if (defaultFeature.is(TreePlacements.FALLEN_BIRCH_TREE)) {
									defaultFeature = fallenBirchTreeOrBark;
									shouldReplace = true;
								} else if (defaultFeature.is(TreePlacements.FALLEN_SUPER_BIRCH_TREE)) {
									defaultFeature = fallenSuperBirchTreeOrBark;
									shouldReplace = true;
								}

								if (shouldReplace) {
									entries.add(
										(ResourceKey<ConfiguredFeature<?,?>>)(keyField.get(null)),
										new ConfiguredFeature<>(
											Feature.RANDOM_SELECTOR,
											new RandomFeatureConfiguration(
												ImmutableList.copyOf(randomFeatures),
												defaultFeature
											)
										)
									);
								}
							}
							
						}
					}
				}
			}
		} catch (IllegalAccessException e) {
			BarkBlocks.LOGGER.warn(e.toString());
		}
	}
}