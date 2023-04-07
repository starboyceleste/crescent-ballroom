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
    private static final Float DEFAULT_BOOM_ROTATION = 0.0f;
    private float boomRotation = DEFAULT_BOOM_ROTATION;

    public MicrophoneStandEntity(EntityType<? extends MicrophoneStandEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if ((player.getStackInHand(hand).isEmpty()) && (player.isSneaking())) {
            if (this.boomRotation < 60) {
                this.setBoomRotation(this.boomRotation + 15);
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
