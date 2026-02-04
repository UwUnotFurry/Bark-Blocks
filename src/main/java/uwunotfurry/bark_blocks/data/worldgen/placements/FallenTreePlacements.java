package uwunotfurry.bark_blocks.data.worldgen.placements;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import uwunotfurry.bark_blocks.BarkBlocks;
import uwunotfurry.bark_blocks.data.worldgen.features.FallenTreeFeatures;

public class FallenTreePlacements {
	public static final ResourceKey<PlacedFeature> FALLEN_OAK_TREE_BARK;
	public static final ResourceKey<PlacedFeature> FALLEN_SPRUCE_TREE_BARK;
	public static final ResourceKey<PlacedFeature> FALLEN_BIRCH_TREE_BARK;
	public static final ResourceKey<PlacedFeature> FALLEN_SUPER_BIRCH_TREE_BARK;
	public static final ResourceKey<PlacedFeature> FALLEN_JUNGLE_TREE_BARK;

	public static final ResourceKey<PlacedFeature> FALLEN_OAK_TREE_ORIGINAL;
	public static final ResourceKey<PlacedFeature> FALLEN_SPRUCE_TREE_ORIGINAL;
	public static final ResourceKey<PlacedFeature> FALLEN_BIRCH_TREE_ORIGINAL;
	public static final ResourceKey<PlacedFeature> FALLEN_SUPER_BIRCH_TREE_ORIGINAL;
	public static final ResourceKey<PlacedFeature> FALLEN_JUNGLE_TREE_ORIGINAL;

	public static ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(BarkBlocks.MOD_ID, name));
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

		HolderLookup.RegistryLookup<PlacedFeature> placedFeatures = registries.lookupOrThrow(Registries.PLACED_FEATURE);
		HolderLookup.RegistryLookup<ConfiguredFeature<?,?>> configuredFeatures = registries.lookupOrThrow(Registries.CONFIGURED_FEATURE);

		PlacedFeature fallenOakPlacement		= placedFeatures.get(TreePlacements.FALLEN_OAK_TREE			).get().value();
		PlacedFeature fallenSprucePlacement		= placedFeatures.get(TreePlacements.FALLEN_SPRUCE_TREE		).get().value();
		PlacedFeature fallenBirchPlacement		= placedFeatures.get(TreePlacements.FALLEN_BIRCH_TREE		).get().value();
		PlacedFeature fallenSuperBirchPlacement	= placedFeatures.get(TreePlacements.FALLEN_SUPER_BIRCH_TREE	).get().value();
		PlacedFeature fallenJunglePlacement		= placedFeatures.get(TreePlacements.FALLEN_JUNGLE_TREE		).get().value();

		Holder<ConfiguredFeature<?,?>> fallenOakBarkConfiguration			= configuredFeatures.get(FallenTreeFeatures.FALLEN_OAK_TREE_BARK				).get();
		Holder<ConfiguredFeature<?,?>> fallenSpruceBarkConfiguration		= configuredFeatures.get(FallenTreeFeatures.FALLEN_SPRUCE_TREE_BARK				).get();
		Holder<ConfiguredFeature<?,?>> fallenBirchBarkConfiguration			= configuredFeatures.get(FallenTreeFeatures.FALLEN_BIRCH_TREE_BARK				).get();
		Holder<ConfiguredFeature<?,?>> fallenSuperBirchBarkConfiguration	= configuredFeatures.get(FallenTreeFeatures.FALLEN_SUPER_BIRCH_TREE_BARK		).get();
		Holder<ConfiguredFeature<?,?>> fallenJungleBarkConfiguration		= configuredFeatures.get(FallenTreeFeatures.FALLEN_JUNGLE_TREE_BARK				).get();

		Holder<ConfiguredFeature<?,?>> fallenOakTreeConfiguration			= configuredFeatures.get(FallenTreeFeatures.FALLEN_OAK_TREE_ORIGINAL			).get();
		Holder<ConfiguredFeature<?,?>> fallenSpruceTreeConfiguration		= configuredFeatures.get(FallenTreeFeatures.FALLEN_SPRUCE_TREE_ORIGINAL			).get();
		Holder<ConfiguredFeature<?,?>> fallenBirchTreeConfiguration			= configuredFeatures.get(FallenTreeFeatures.FALLEN_BIRCH_TREE_ORIGINAL			).get();
		Holder<ConfiguredFeature<?,?>> fallenSuperBirchTreeConfiguration	= configuredFeatures.get(FallenTreeFeatures.FALLEN_SUPER_BIRCH_TREE_ORIGINAL	).get();
		Holder<ConfiguredFeature<?,?>> fallenJungleTreeConfiguration		= configuredFeatures.get(FallenTreeFeatures.FALLEN_JUNGLE_TREE_ORIGINAL			).get();

		entries.add(FALLEN_OAK_TREE_ORIGINAL,			new PlacedFeature(fallenOakTreeConfiguration,			fallenOakPlacement.placement()));
		entries.add(FALLEN_OAK_TREE_BARK,				new PlacedFeature(fallenOakBarkConfiguration,			fallenOakPlacement.placement()));

		entries.add(FALLEN_SPRUCE_TREE_ORIGINAL,		new PlacedFeature(fallenSpruceTreeConfiguration,		fallenSprucePlacement.placement()));
		entries.add(FALLEN_SPRUCE_TREE_BARK,			new PlacedFeature(fallenSpruceBarkConfiguration,		fallenSprucePlacement.placement()));

		entries.add(FALLEN_BIRCH_TREE_ORIGINAL,			new PlacedFeature(fallenBirchTreeConfiguration,			fallenBirchPlacement.placement()));
		entries.add(FALLEN_BIRCH_TREE_BARK,				new PlacedFeature(fallenBirchBarkConfiguration,			fallenBirchPlacement.placement()));

		entries.add(FALLEN_SUPER_BIRCH_TREE_ORIGINAL,	new PlacedFeature(fallenSuperBirchTreeConfiguration,	fallenSuperBirchPlacement.placement()));
		entries.add(FALLEN_SUPER_BIRCH_TREE_BARK,		new PlacedFeature(fallenSuperBirchBarkConfiguration,	fallenSuperBirchPlacement.placement()));

		entries.add(FALLEN_JUNGLE_TREE_ORIGINAL,		new PlacedFeature(fallenJungleTreeConfiguration,		fallenJunglePlacement.placement()));
		entries.add(FALLEN_JUNGLE_TREE_BARK,			new PlacedFeature(fallenJungleBarkConfiguration,		fallenJunglePlacement.placement()));
	}
}