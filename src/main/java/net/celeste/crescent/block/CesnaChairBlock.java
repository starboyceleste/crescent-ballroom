package net.celeste.crescent.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

@SuppressWarnings("deprecation")
public class CesnaChairBlock extends AbstractSeatableBlock {
    public CesnaChairBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        this.height = 0.6f;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        super.appendProperties(stateManager);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        return switch (facing) {
            case WEST -> VoxelShapes.cuboid(0.35f, 0.0f, 0.1f, 1.15f, 1.5f, 0.9f);
            case SOUTH -> VoxelShapes.cuboid(0.1f, 0.0f, -0.15f, 0.9f, 1.5f, 0.65f);
            case EAST -> VoxelShapes.cuboid(-0.15f, 0.0f, 0.1f, 0.65f, 1.5f, 0.9f);
            default -> VoxelShapes.cuboid(0.1f, 0.0f, 0.35f, 0.9f, 1.5f, 1.15f);
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        return switch (facing) {
            case WEST -> VoxelShapes.union(VoxelShapes.cuboid(0.25f, 0.0f, 0.1f, 1.05f, 0.8f, 0.9f), VoxelShapes.cuboid(0.75f, 0.8f, 0.1f, 0.95f, 1.5f, 0.9f));
            case SOUTH -> VoxelShapes.union(VoxelShapes.cuboid(0.1f, 0.0f, -0.05f, 0.9f, 0.8f, 0.65f), VoxelShapes.cuboid(0.1f, 0.8f, 0.05f, 0.9f, 1.5f, 0.25f));
            case EAST -> VoxelShapes.union(VoxelShapes.cuboid(-0.05f, 0.0f, 0.1f, 0.65f, 0.8f, 0.9f), VoxelShapes.cuboid(0.05f, 0.8f, 0.1f, 0.25f, 1.5f, 0.9f));
            default -> VoxelShapes.union(VoxelShapes.cuboid(0.1f, 0.0f, 0.35f, 0.9f, 0.8f, 1.05f), VoxelShapes.cuboid(0.1f, 0.8f, 0.75f, 0.9f, 1.5f, 0.95f));
        };
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(HorizontalFacingBlock.FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
