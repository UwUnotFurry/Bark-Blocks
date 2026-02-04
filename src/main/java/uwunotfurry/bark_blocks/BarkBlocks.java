package uwunotfurry.bark_blocks;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uwunotfurry.bark_blocks.world.level.block.Blocks;
import uwunotfurry.bark_blocks.world.level.levelgen.feature.Features;

public class BarkBlocks implements ModInitializer {
	public static final String MOD_ID = "bark-blocks";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BarkBlocks.LOGGER.info("Bark Blocks (C) 2026 by UwUnotFurry is licensed under CC BY-NC-ND 4.0. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/");

		Blocks.onInitialise();
		Features.onInitialise();
	}
}