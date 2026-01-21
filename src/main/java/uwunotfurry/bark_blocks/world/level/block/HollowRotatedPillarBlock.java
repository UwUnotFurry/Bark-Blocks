package uwunotfurry.bark_blocks.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HollowRotatedPillarBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public static final VoxelShape SHAPE_X = Shapes.join(Shapes.block(), Shapes.box(0f, 0.125f, 0.125f, 1f, 0.875f, 0.875f), BooleanOp.ONLY_FIRST);
	public static final VoxelShape SHAPE_Y = Shapes.join(Shapes.block(), Shapes.box(0.125f, 0f, 0.125f, 0.875f, 1f, 0.875f), BooleanOp.ONLY_FIRST);
	public static final VoxelShape SHAPE_Z = Shapes.join(Shapes.block(), Shapes.box(0.125f, 0.125f, 0f, 0.875f, 0.875f, 1f), BooleanOp.ONLY_FIRST);

	public HollowRotatedPillarBlock(Block.Properties properties) {
		super(properties);
		registerDefaultState(
			defaultBlockState()
				.setValue(WATERLOGGED, false)
		);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
		builder.add(WATERLOGGED);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		switch((Direction.Axis)state.getValue(AXIS)) {
			case X:
				return SHAPE_X;
			default:
			case Y:
				return SHAPE_Y;
			case Z:
				return SHAPE_Z;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context)
			.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER)
		;
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
}