package uwunotfurry.bark_blocks.data.worldgen.placement;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.data.worldgen.features.FallenTreeBarkFeatures;

public class FallenTreeBarkPlacements {

	public static final ResourceKey<PlacedFeature> FALLEN_OAK_TREE_BARK			= createKey("fallen_oak_tree_bark");
	public static final ResourceKey<PlacedFeature> FALLEN_JUNGLE_TREE_BARK		= createKey("fallen_jungle_tree_bark");
	public static final ResourceKey<PlacedFeature> FALLEN_SPRUCE_TREE_BARK		= createKey("fallen_spruce_tree_bark");
	public static final ResourceKey<PlacedFeature> FALLEN_BIRCH_TREE_BARK		= createKey("fallen_birch_tree_bark");
	public static final ResourceKey<PlacedFeature> FALLEN_SUPER_BIRCH_TREE_BARK	= createKey("fallen_super_birch_tree_bark");

	private static ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
	}

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {

		HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(context, FALLEN_OAK_TREE_BARK,			configuredFeatures.getOrThrow(FallenTreeBarkFeatures.FALLEN_OAK_TREE_BARK),			PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		PlacementUtils.register(context, FALLEN_JUNGLE_TREE_BARK,		configuredFeatures.getOrThrow(FallenTreeBarkFeatures.FALLEN_JUNGLE_TREE_BARK),		PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
		PlacementUtils.register(context, FALLEN_SPRUCE_TREE_BARK,		configuredFeatures.getOrThrow(FallenTreeBarkFeatures.FALLEN_SPRUCE_TREE_BARK),		PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
		PlacementUtils.register(context, FALLEN_BIRCH_TREE_BARK,		configuredFeatures.getOrThrow(FallenTreeBarkFeatures.FALLEN_BIRCH_TREE_BARK),		PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
		PlacementUtils.register(context, FALLEN_SUPER_BIRCH_TREE_BARK,	configuredFeatures.getOrThrow(FallenTreeBarkFeatures.FALLEN_SUPER_BIRCH_TREE_BARK),	PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
	}
}