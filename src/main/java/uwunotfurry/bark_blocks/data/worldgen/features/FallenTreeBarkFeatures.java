package uwunotfurry.bark_blocks.data.worldgen.features;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.world.level.levelgen.feature.Features;
import uwunotfurry.bark_blocks.world.level.block.Blocks;

public class FallenTreeBarkFeatures {

	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_OAK_TREE_BARK			= createKey("fallen_oak_tree_bark");
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_JUNGLE_TREE_BARK			= createKey("fallen_jungle_tree_bark");
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SPRUCE_TREE_BARK			= createKey("fallen_spruce_tree_bark");
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_BIRCH_TREE_BARK			= createKey("fallen_birch_tree_bark");
	public static final ResourceKey<ConfiguredFeature<?,?>> FALLEN_SUPER_BIRCH_TREE_BARK	= createKey("fallen_super_birch_tree_bark");

	private static ResourceKey<ConfiguredFeature<?,?>> createKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
	}

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context) {
		FeatureUtils.register(context, FALLEN_OAK_TREE_BARK,			Features.FALLEN_TREE_BARK, TreeFeatures.createFallenTrees(Blocks.OAK_BARK,		4, 7 ).stumpDecorators(ImmutableList.of(TrunkVineDecorator.INSTANCE)).build()); 
		FeatureUtils.register(context, FALLEN_JUNGLE_TREE_BARK,			Features.FALLEN_TREE_BARK, TreeFeatures.createFallenTrees(Blocks.JUNGLE_BARK,	4, 11).stumpDecorators(ImmutableList.of(TrunkVineDecorator.INSTANCE)).build());
		FeatureUtils.register(context, FALLEN_SPRUCE_TREE_BARK,			Features.FALLEN_TREE_BARK, TreeFeatures.createFallenTrees(Blocks.SPRUCE_BARK,	6, 10).build());
		FeatureUtils.register(context, FALLEN_BIRCH_TREE_BARK,			Features.FALLEN_TREE_BARK, TreeFeatures.createFallenTrees(Blocks.BIRCH_BARK,	5, 8 ).build());
		FeatureUtils.register(context, FALLEN_SUPER_BIRCH_TREE_BARK,	Features.FALLEN_TREE_BARK, TreeFeatures.createFallenTrees(Blocks.BIRCH_BARK,	5, 15).build());
	}
}