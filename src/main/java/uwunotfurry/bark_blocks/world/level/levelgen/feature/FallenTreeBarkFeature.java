package uwunotfurry.bark_blocks.world.level.levelgen.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FallenTreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FallenTreeConfiguration;

public class FallenTreeBarkFeature extends FallenTreeFeature {

	public FallenTreeBarkFeature(final Codec<FallenTreeConfiguration> codec) {
		super(codec);
	}

	@Override
	protected void placeStump(FallenTreeConfiguration config, WorldGenLevel level, RandomSource random, BlockPos.MutableBlockPos stumpPos) {}
}