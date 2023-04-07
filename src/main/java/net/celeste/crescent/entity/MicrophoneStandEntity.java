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
    private static final Float boom_rotation_default = -10f;
    private static final Float boom_rotation_range = 120f;
    private static final Float boom_rotation_steps = 9f;
    private static final Float boom_rotation_step_degree = boom_rotation_range / (boom_rotation_steps - 1.0f);
    private float boom_rotation = boom_rotation_default;

    public MicrophoneStandEntity(EntityType<? extends MicrophoneStandEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if ((player.getStackInHand(hand).isEmpty()) && (player.isSneaking())) {
            if (this.boom_rotation < (boom_rotation_default + (boom_rotation_range / 2.0f))) {
                this.setBoomRotation(this.boom_rotation + boom_rotation_step_degree);
            }
            else {
                this.setBoomRotation(this.boom_rotation * -1);
            }
        }
        return ActionResult.CONSUME;
    }

    public Float getBoomRotation() {
        return this.boom_rotation;
    }
    public void setBoomRotation(Float angle) { this.boom_rotation = angle; }

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
