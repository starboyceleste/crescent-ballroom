package net.celeste.crescent.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@SuppressWarnings("deprecation")
public class CesnaChairBlock extends ChairBlock {
    protected static final VoxelShape OUTLINE_WEST = VoxelShapes.cuboid(0.35f, 0.0f, 0.1f, 1.15f, 1.5f, 0.9f);
    protected static final VoxelShape OUTLINE_SOUTH = VoxelShapes.cuboid(0.1f, 0.0f, -0.15f, 0.9f, 1.5f, 0.65f);
    protected static final VoxelShape OUTLINE_EAST = VoxelShapes.cuboid(-0.15f, 0.0f, 0.1f, 0.65f, 1.5f, 0.9f);
    protected static final VoxelShape OUTLINE_NORTH = VoxelShapes.cuboid(0.1f, 0.0f, 0.35f, 0.9f, 1.5f, 1.15f);

    protected static final VoxelShape COLLISION_WEST = VoxelShapes.union(VoxelShapes.cuboid(0.25f, 0.0f, 0.1f, 1.05f, 0.8f, 0.9f), VoxelShapes.cuboid(0.75f, 0.8f, 0.1f, 0.95f, 1.5f, 0.9f));
    protected static final VoxelShape COLLISION_SOUTH = VoxelShapes.union(VoxelShapes.cuboid(0.1f, 0.0f, -0.05f, 0.9f, 0.8f, 0.65f), VoxelShapes.cuboid(0.1f, 0.8f, 0.05f, 0.9f, 1.5f, 0.25f));
    protected static final VoxelShape COLLISION_EAST = VoxelShapes.union(VoxelShapes.cuboid(-0.05f, 0.0f, 0.1f, 0.65f, 0.8f, 0.9f), VoxelShapes.cuboid(0.05f, 0.8f, 0.1f, 0.25f, 1.5f, 0.9f));
    protected static final VoxelShape COLLISION_NORTH = VoxelShapes.union(VoxelShapes.cuboid(0.1f, 0.0f, 0.35f, 0.9f, 0.8f, 1.05f), VoxelShapes.cuboid(0.1f, 0.8f, 0.75f, 0.9f, 1.5f, 0.95f));

    public CesnaChairBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        return switch (facing) {
            case WEST -> OUTLINE_WEST;
            case SOUTH -> OUTLINE_SOUTH;
            case EAST -> OUTLINE_EAST;
            default -> OUTLINE_NORTH;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        return switch (facing) {
            case WEST -> COLLISION_WEST;
            case SOUTH -> COLLISION_SOUTH;
            case EAST -> COLLISION_EAST;
            default -> COLLISION_NORTH;
        };
    }
}
