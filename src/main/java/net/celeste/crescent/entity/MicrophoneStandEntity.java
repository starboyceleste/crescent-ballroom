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

import java.text.DecimalFormat;


public class MicrophoneStandEntity extends LivingEntity {
    private static final Float boom_rotation_default = -10.0f;
    private static final Float boom_rotation_range = 120.0f;
    private static final Float boom_rotation_steps = 9.0f;
    private static final Float boom_rotation_step_degree = boom_rotation_range / (boom_rotation_steps - 1);
    private float boom_rotation = boom_rotation_default;
    private float boom_rotation_start = boom_rotation_default;
    private float boom_rotation_end = boom_rotation_default;
    public int reset = 0;
    public int last_reset_time = 0;
    DecimalFormat df = new DecimalFormat("#.#");

    public MicrophoneStandEntity(EntityType<? extends MicrophoneStandEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (boom_rotation != boom_rotation_end) {
            this.setCustomName(Text.of(df.format(boom_rotation) + " [" + df.format(Math.abs(boom_rotation_end - boom_rotation)) + "]"));
        } else {
            this.setCustomName(Text.of(String.valueOf(df.format(boom_rotation))));
        }
        if (reset > 0) {
            this.last_reset_time ++;
            if (this.last_reset_time > 1) {
                setBoomRotation(this.boom_rotation_end - boom_rotation_step_degree);
                this.last_reset_time = 0;
                reset --;
            }
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if ((player.getStackInHand(hand).isEmpty()) && (player.isSneaking()) && (reset == 0)) {
            if (this.boom_rotation_end < boom_rotation_default + boom_rotation_range / 2) {
                setBoomRotation(this.boom_rotation_end + boom_rotation_step_degree);
            } else {
                this.jump();
                reset = (int) (boom_rotation_steps - 1);
            }
        }
        return ActionResult.SUCCESS;
    }

    public void setBoomRotation(float rotation) {
        this.playSound(SoundEvents.ENTITY_FISHING_BOBBER_RETRIEVE, 1.0f, 0.5f);
        this.boom_rotation_start = this.boom_rotation_end;
        this.boom_rotation_end = rotation;
    }

    public void updateBoomRotation(float rotation){
        this.boom_rotation = rotation;
    }

    public Float getBoomRotation(String when) {
        return switch (when) {
            case "start" -> this.boom_rotation_start;
            case "current" -> this.boom_rotation;
            case "end" -> this.boom_rotation_end;
            default -> boom_rotation_default;
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
