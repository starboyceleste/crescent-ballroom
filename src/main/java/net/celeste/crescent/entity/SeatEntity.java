package net.celeste.crescent.entity;

import com.google.common.collect.Lists;
import net.celeste.crescent.block.AbstractSeatableBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;

public class SeatEntity extends Entity {
    public SeatEntity(EntityType<? extends SeatEntity> type, World world) {
        super(type, world);
        this.noClip = true;
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public void tick() {
        if (!this.hasPassengers()) {
            if (!this.world.isClient){
                this.discard();
            }
        }
        else if (this.world.getBlockState(this.getBlockPos()).getBlock() instanceof AbstractSeatableBlock) {
            super.tick();
            this.setVelocity(Vec3d.ZERO);
        }
        else {
            if (!this.world.isClient){
                this.removeAllPassengers();
                this.discard();
            }
        }
    }

    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        return super.interactAt(player, hitPos, hand);
    }


    @Override
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        double e;
        Vec3d vec3d = SeatEntity.getPassengerDismountOffset(this.getWidth() * MathHelper.SQUARE_ROOT_OF_TWO, passenger.getWidth(), passenger.getYaw());
        double d = this.getX() + vec3d.x;
        BlockPos blockPos = new BlockPos(d, this.getBoundingBox().maxY, e = this.getZ() + vec3d.z);
        BlockPos blockPos2 = blockPos.down();
        double g;
        ArrayList<Vec3d> list = Lists.newArrayList();
        double f = this.world.getDismountHeight(blockPos);
        if (Dismounting.canDismountInBlock(f)) {
            list.add(new Vec3d(d, (double)blockPos.getY() + f, e));
        }
        if (Dismounting.canDismountInBlock(g = this.world.getDismountHeight(blockPos2))) {
            list.add(new Vec3d(d, (double)blockPos2.getY() + g, e));
        }
        for (EntityPose entityPose : passenger.getPoses()) {
            for (Vec3d vec3d2 : list) {
                if (!Dismounting.canPlaceEntityAt(this.world, vec3d2, passenger, entityPose)) continue;
                passenger.setPose(entityPose);
                return vec3d2;
            }
        }
        return super.updatePassengerForDismount(passenger);
    }

    @Override
    public boolean isAlive() {
        return !this.isRemoved();
    }
    @Override
    public boolean isPushedByFluids() {
        return false;
    }
    @Override
    public boolean canBeRiddenInWater() { return true; }
    @Override
    public boolean hasNoGravity() { return true; }
    @Override
    public boolean isSilent() { return true; }
    @Override
    public boolean isInvisible() { return true; }
    @Override
    public boolean isInvulnerable() { return true; }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
    }
}
