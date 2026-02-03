package uwunotfurry.bark_blocks.world.level.storage.loot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import uwunotfurry.bark_blocks.BarkBlocks;

public class LootTables {

	public static final ResourceLocation STRIP_OAK 		= register("oak");
	public static final ResourceLocation STRIP_SPRUCE 	= register("spruce");
	public static final ResourceLocation STRIP_BIRCH	= register("birch");
	public static final ResourceLocation STRIP_JUNGLE	= register("jungle");
	public static final ResourceLocation STRIP_ACACIA	= register("acacia");
	public static final ResourceLocation STRIP_DARK_OAK	= register("dark_oak");
	public static final ResourceLocation STRIP_MANGROVE	= register("mangrove");
	public static final ResourceLocation STRIP_CHERRY	= register("cherry");
	public static final ResourceLocation STRIP_CRIMSON	= register("crimson");
	public static final ResourceLocation STRIP_WARPED	= register("warped");

	private static ResourceLocation register(String name) {
		ResourceLocation location = new ResourceLocation(BarkBlocks.MOD_ID, "gameplay/strip/" + name);

		if (BuiltInLootTables.all().contains(location)) {
			throw new IllegalArgumentException(location + " is already a registered built-in loot table");
		}

		return location;
	}

}