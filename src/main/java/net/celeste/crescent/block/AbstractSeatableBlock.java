package net.celeste.crescent.block;

import net.celeste.crescent.entity.CrescentEntityType;
import net.celeste.crescent.entity.SeatEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSeatableBlock extends HorizontalFacingBlock {
    public float height;

    protected AbstractSeatableBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));

        this.height = 0.5f;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing().getOpposite());
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.contains(Properties.WATERLOGGED)) {
            if (state.get(Properties.WATERLOGGED))
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.CONSUME;
        }

        if (player.isSpectator() || player.isSneaking()) {
            return ActionResult.FAIL;
        }

        List<SeatEntity> active = world.getEntitiesByClass(SeatEntity.class, new Box(pos), Entity::hasPassengers);
        List<Entity> hasPassenger = new ArrayList<>();
        active.forEach(chairEntity -> hasPassenger.add(chairEntity.getFirstPassenger()));
        if (!active.isEmpty() && hasPassenger.stream().anyMatch(Entity::isPlayer)) {
            return ActionResult.FAIL;
        }
        else if (!active.isEmpty()) {
            hasPassenger.forEach(Entity::stopRiding);
            return ActionResult.SUCCESS;
        }
        else if (sitEntity(world, pos, state, player) == ActionResult.SUCCESS) {
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    public ActionResult sitEntity(World world, BlockPos pos, BlockState state, Entity entityToSit) {
        float yaw = state.get(FACING).asRotation();
        SeatEntity seatEntity = CrescentEntityType.SEAT.create(world);
        if (seatEntity != null) {
            seatEntity.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + this.height, pos.getZ() + 0.5, yaw, 0);
        }
        seatEntity.setHeadYaw(yaw);
        seatEntity.setYaw(yaw);
        seatEntity.setBodyYaw(yaw);
        if (world.spawnEntity(seatEntity)) {
            entityToSit.startRiding(seatEntity, true);
            entityToSit.setYaw(yaw);
            entityToSit.setHeadYaw(yaw);
            seatEntity.setYaw(yaw);
            seatEntity.setBodyYaw(yaw);
            seatEntity.setHeadYaw(yaw);

            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        List<SeatEntity> active = world.getEntitiesByClass(SeatEntity.class, new Box(pos), Entity::hasPassengers);
        if (!active.isEmpty())
            return;

        if (entity instanceof PlayerEntity || entity instanceof IronGolemEntity || entity instanceof AbstractMinecartEntity || entity.hasVehicle() || !(entity instanceof LivingEntity)) {
            return;
        }
        sitEntity(world, pos, state, entity);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
