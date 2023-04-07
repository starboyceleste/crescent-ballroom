package net.celeste.crescent.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;


public class MicrophoneStandEntity extends LivingEntity {
    private static final int DEFAULT_BOOM_ROTATION = -10;
    private static final int rotation_range = 120;
    private static final int rotation_steps = 9;
    private static final Float rotation_step_degree = Float.valueOf(rotation_range / (rotation_steps - 1));
    private float boomRotation = DEFAULT_BOOM_ROTATION;

    public MicrophoneStandEntity(EntityType<? extends MicrophoneStandEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if ((player.getStackInHand(hand).isEmpty()) && (player.isSneaking())) {
            if (this.boomRotation < (DEFAULT_BOOM_ROTATION + (rotation_range / 2))) {
                this.setBoomRotation(this.boomRotation + rotation_step_degree);
            }
            else {
                this.setBoomRotation(this.boomRotation * -1);
            }
        }
        return ActionResult.CONSUME;
    }

    public Float getBoomRotation() {
        return this.boomRotation;
    }
    public void setBoomRotation(Float angle) { this.boomRotation = angle; }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return DefaultedList.ofSize(4, ItemStack.EMPTY);
    }
    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }
    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
    }
    @Override
    public Arm getMainArm() {
        return null;
    }
}
