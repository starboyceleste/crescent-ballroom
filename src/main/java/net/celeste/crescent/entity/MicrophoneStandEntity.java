package net.celeste.crescent.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;


public class MicrophoneStandEntity extends LivingEntity {
    private static final Float BOOM_ROTATION_DEFAULT = -10.0f;
    private static final Float BOOM_ROTATION_RANGE = 120.0f;
    private static final Float BOOM_ROTATION_STEPS = 9.0f;
    private static final Float BOOM_ROTATION_STEP_DEGREE = BOOM_ROTATION_RANGE / (BOOM_ROTATION_STEPS - 1);
    private float boomRotation = BOOM_ROTATION_DEFAULT;
    private float boomRotationStart = BOOM_ROTATION_DEFAULT;
    private float boomRotationEnd = BOOM_ROTATION_DEFAULT;
    public int resetSteps = 0;
    private int lastResetTicks = 0;
    public int lastInteractTicks = 0;

    public MicrophoneStandEntity(EntityType<? extends MicrophoneStandEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.resetSteps > 0) {
            this.lastResetTicks++;
            if (this.lastResetTicks > 1) {
                setBoomRotation(this.boomRotationEnd - BOOM_ROTATION_STEP_DEGREE);
                this.lastResetTicks = 0;
                this.resetSteps --;
            }
        }
        this.lastInteractTicks ++;
        this.setCustomName(Text.of((Math.round(boomRotation)) + "°"));
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        this.lastInteractTicks = 0;
        if ((player.getStackInHand(hand).isEmpty()) && (player.isSneaking()) && (this.resetSteps == 0)) {
            if (this.boomRotationEnd < BOOM_ROTATION_DEFAULT + BOOM_ROTATION_RANGE / 2) {
                setBoomRotation(this.boomRotationEnd + BOOM_ROTATION_STEP_DEGREE);
            } else {
                this.jump();
                this.resetSteps = (int) (BOOM_ROTATION_STEPS - 1);
            }
        }
        return ActionResult.SUCCESS;
    }

    public void setBoomRotation(float rotation) {
        this.playSound(SoundEvents.ENTITY_FISHING_BOBBER_RETRIEVE, 1.0f, 0.5f);
        this.boomRotationStart = this.boomRotationEnd;
        this.boomRotationEnd = rotation;
    }

    public void updateBoomRotation(float rotation){
        this.boomRotation = rotation;
    }

    public Float getBoomRotation(String when) {
        return switch (when) {
            case "start" -> this.boomRotationStart;
            case "current" -> this.boomRotation;
            case "end" -> this.boomRotationEnd;
            default -> BOOM_ROTATION_DEFAULT;
        };
    }

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
