package uwunotfurry.bark_blocks.data.worldgen.features;

import java.util.List;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.FallenTreeFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FallenTreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.data.worldgen.placements.FallenTreePlacements;
import uwunotfurry.bark_blocks.world.level.block.Blocks;
import uwunotfurry.bark_blocks.world.level.levelgen.feature.FallenTreeBarkFeature;
import uwunotfurry.bark_blocks.world.level.levelgen.feature.Features;

public class FallenTreeFeatures {
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_OAK_TREE_BARK;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SPRUCE_TREE_BARK;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_BIRCH_TREE_BARK;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SUPER_BIRCH_TREE_BARK;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_JUNGLE_TREE_BARK;

	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_OAK_TREE_ORIGINAL;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SPRUCE_TREE_ORIGINAL;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_BIRCH_TREE_ORIGINAL;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SUPER_BIRCH_TREE_ORIGINAL;
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_JUNGLE_TREE_ORIGINAL;

	public static ResourceKey<ConfiguredFeature<?,?>> createKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
	}

	static {
		FALLEN_OAK_TREE_BARK				= createKey("fallen_oak_tree_bark");
		FALLEN_SPRUCE_TREE_BARK				= createKey("fallen_spruce_tree_bark");
		FALLEN_BIRCH_TREE_BARK				= createKey("fallen_birch_tree_bark");
		FALLEN_SUPER_BIRCH_TREE_BARK		= createKey("fallen_super_birch_tree_bark");
		FALLEN_JUNGLE_TREE_BARK				= createKey("fallen_jungle_tree_bark");

		FALLEN_OAK_TREE_ORIGINAL			= createKey("fallen_oak_tree_original");
		FALLEN_SPRUCE_TREE_ORIGINAL			= createKey("fallen_spruce_tree_original");
		FALLEN_BIRCH_TREE_ORIGINAL			= createKey("fallen_birch_tree_original");
		FALLEN_SUPER_BIRCH_TREE_ORIGINAL	= createKey("fallen_super_birch_tree_original");
		FALLEN_JUNGLE_TREE_ORIGINAL			= createKey("fallen_jungle_tree_original");
	}

	public static void bootstrap(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {

		HolderLookup.RegistryLookup<ConfiguredFeature<?,?>> configuredFeatures = registries.lookupOrThrow(Registries.CONFIGURED_FEATURE);

		ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature> fallenOakConfiguration			= (ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature>)configuredFeatures.get(TreeFeatures.FALLEN_OAK_TREE			).get().value();
		ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature> fallenSpruceConfiguration		= (ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature>)configuredFeatures.get(TreeFeatures.FALLEN_SPRUCE_TREE		).get().value();
		ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature> fallenBirchConfiguration		= (ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature>)configuredFeatures.get(TreeFeatures.FALLEN_BIRCH_TREE		).get().value();
		ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature> fallenSuperBirchConfiguration	= (ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature>)configuredFeatures.get(TreeFeatures.FALLEN_SUPER_BIRCH_TREE	).get().value();
		ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature> fallenJungleConfiguration		= (ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature>)configuredFeatures.get(TreeFeatures.FALLEN_JUNGLE_TREE		).get().value();


		entries.add(FALLEN_OAK_TREE_ORIGINAL,			fallenOakConfiguration);
		entries.add(FALLEN_OAK_TREE_BARK,				modifyToBark(Blocks.OAK_BARK, fallenOakConfiguration));

		entries.add(FALLEN_SPRUCE_TREE_ORIGINAL,		fallenSpruceConfiguration);
		entries.add(FALLEN_SPRUCE_TREE_BARK,			modifyToBark(Blocks.SPRUCE_BARK, fallenSpruceConfiguration));

		entries.add(FALLEN_BIRCH_TREE_ORIGINAL,			fallenBirchConfiguration);
		entries.add(FALLEN_BIRCH_TREE_BARK,				modifyToBark(Blocks.BIRCH_BARK, fallenBirchConfiguration));

		entries.add(FALLEN_SUPER_BIRCH_TREE_ORIGINAL,	fallenSuperBirchConfiguration);
		entries.add(FALLEN_SUPER_BIRCH_TREE_BARK,		modifyToBark(Blocks.BIRCH_BARK, fallenSuperBirchConfiguration));

		entries.add(FALLEN_JUNGLE_TREE_ORIGINAL,		fallenJungleConfiguration);
		entries.add(FALLEN_JUNGLE_TREE_BARK,			modifyToBark(Blocks.JUNGLE_BARK, fallenJungleConfiguration));
	}

	public static void overrideVanillaBootstrap(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {

		HolderLookup.RegistryLookup<PlacedFeature> placedFeatures = registries.lookupOrThrow(Registries.PLACED_FEATURE);

		Holder<PlacedFeature> fallenOakBarkPlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_OAK_TREE_BARK				).get();
		Holder<PlacedFeature> fallenSpruceBarkPlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_SPRUCE_TREE_BARK			).get();
		Holder<PlacedFeature> fallenBirchBarkPlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_BIRCH_TREE_BARK			).get();
		Holder<PlacedFeature> fallenSuperBarkBirchPlacement	= placedFeatures.get(FallenTreePlacements.FALLEN_SUPER_BIRCH_TREE_BARK		).get();
		Holder<PlacedFeature> fallenJungleBarkPlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_JUNGLE_TREE_BARK			).get();

		Holder<PlacedFeature> fallenOakTreePlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_OAK_TREE_ORIGINAL			).get();
		Holder<PlacedFeature> fallenSpruceTreePlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_SPRUCE_TREE_ORIGINAL		).get();
		Holder<PlacedFeature> fallenBirchTreePlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_BIRCH_TREE_ORIGINAL		).get();
		Holder<PlacedFeature> fallenSuperBirchTreePlacement	= placedFeatures.get(FallenTreePlacements.FALLEN_SUPER_BIRCH_TREE_ORIGINAL	).get();
		Holder<PlacedFeature> fallenJungleTreePlacement		= placedFeatures.get(FallenTreePlacements.FALLEN_JUNGLE_TREE_ORIGINAL		).get();

		entries.add(TreeFeatures.FALLEN_OAK_TREE,			fallenTreeWithBarkVariant(fallenOakBarkPlacement,		fallenOakTreePlacement));
		entries.add(TreeFeatures.FALLEN_SPRUCE_TREE,		fallenTreeWithBarkVariant(fallenSpruceBarkPlacement,	fallenSpruceTreePlacement));
		entries.add(TreeFeatures.FALLEN_BIRCH_TREE,			fallenTreeWithBarkVariant(fallenBirchBarkPlacement,		fallenBirchTreePlacement));
		entries.add(TreeFeatures.FALLEN_SUPER_BIRCH_TREE,	fallenTreeWithBarkVariant(fallenSuperBarkBirchPlacement,fallenSuperBirchTreePlacement));
		entries.add(TreeFeatures.FALLEN_JUNGLE_TREE,		fallenTreeWithBarkVariant(fallenJungleBarkPlacement,	fallenJungleTreePlacement));
	}

	public static ConfiguredFeature<FallenTreeConfiguration,FallenTreeBarkFeature> modifyToBark(Block bark, ConfiguredFeature<FallenTreeConfiguration,FallenTreeFeature> configured) {
		return new ConfiguredFeature(
			Features.FALLEN_TREE_BARK,
			new FallenTreeConfiguration.FallenTreeConfigurationBuilder(
				BlockStateProvider.simple(bark),
				configured.config().logLength
			).stumpDecorators(
				configured.config().stumpDecorators
			).logDecorators(
				configured.config().logDecorators
			).build()
		);
	}

	public static ConfiguredFeature<?,?> fallenTreeWithBarkVariant(Holder<PlacedFeature> bark, Holder<PlacedFeature> original) {
		return new ConfiguredFeature(
			Feature.RANDOM_SELECTOR,
			new RandomFeatureConfiguration(
				List.of(
					new WeightedPlacedFeature(bark, 0.2f)
				),
				original
			)
		);
	}
}