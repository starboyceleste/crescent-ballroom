package net.celeste.crescent.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;


public class MicrophoneStandEntity extends LivingEntity {
    private static final Float DEFAULT_BOOM_ROTATION = 20.0f;
    public static final TrackedData<Float> TRACKER_BOOM_ROTATION = DataTracker.registerData(MicrophoneStandEntity.class, TrackedDataHandlerRegistry.FLOAT);
    private float boomRotation = DEFAULT_BOOM_ROTATION;

    public MicrophoneStandEntity(EntityType<? extends MicrophoneStandEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand).isEmpty()) {
            if (player.isSneaking()) {
                if (this.boomRotation < 60) {
                    this.setBoomRotation(this.boomRotation + 10);
                }
                else {
                    this.setBoomRotation(this.boomRotation * -1);
                }
            }
        }
        return ActionResult.CONSUME;
    }

    public Float getBoomRotation() {
        return this.boomRotation;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
//        NbtList nbtList = new NbtList();
//        for (ItemStack itemStack : this.armorItems) {
//            NbtCompound nbtCompound = new NbtCompound();
//            if (!itemStack.isEmpty()) {
//                itemStack.writeNbt(nbtCompound);
//            }
//            nbtList.add(nbtCompound);
//        }
//        nbt.put("ArmorItems", nbtList);
        nbt.putFloat("BoomRotation", this.boomRotation);
        nbt.putBoolean("Invisible", this.isInvisible());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.setBoomRotation(nbt.getFloat("BoomRotation"));
        this.setInvisible(nbt.getBoolean("Invisible"));
    }

    public void setBoomRotation(Float angle) {
        this.boomRotation = angle;
        this.dataTracker.set(TRACKER_BOOM_ROTATION, angle);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TRACKER_BOOM_ROTATION, DEFAULT_BOOM_ROTATION);
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
