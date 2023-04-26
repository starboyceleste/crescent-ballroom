package net.celeste.crescent.entity;

import net.celeste.crescent.block.AbstractSeatableBlock;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SeatEntity extends MobEntity {
    public SeatEntity(EntityType<? extends SeatEntity> type, World world) {
        super(type, world);
        this.noClip = true;
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
        }
        else {
            if (!this.world.isClient){
                this.removeAllPassengers();
                this.discard();
            }
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        this.setVelocity(Vec3d.ZERO);
    }

    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        return super.interactAt(player, hitPos, hand);
    }


    @Override
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        Direction direction = this.getMovementDirection();
        if (direction.getAxis() != Direction.Axis.Y) {
            int[][] is = Dismounting.getDismountOffsets(direction);
            BlockPos blockPos = this.getBlockPos();
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            for (EntityPose entityPose : passenger.getPoses()) {
                Box box = passenger.getBoundingBox(entityPose);

                for (int[] js : is) {
                    mutable.set(blockPos.getX() + js[0], blockPos.getY() + 0.3, blockPos.getZ() + js[1]);
                    double d = this.world.getDismountHeight(mutable);
                    if (Dismounting.canDismountInBlock(d)) {
                        Vec3d vec3d = Vec3d.ofCenter(mutable, d);
                        if (Dismounting.canPlaceEntityAt(this.world, passenger, box.offset(vec3d))) {
                            passenger.setPose(entityPose);
                            return vec3d;
                        }
                    }
                }
            }
        }
        return super.updatePassengerForDismount(passenger);
    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 0);
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
    public boolean isAiDisabled () { return true; }
    @Override
    public boolean hasNoDrag() { return true; }
}
