package net.celeste.crescent.entity;

import net.celeste.crescent.item.CrescentItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

import java.util.List;

public class MicrophoneStandEntity extends LivingEntity {
    private static final TrackedData<String> TYPE = DataTracker.registerData(MicrophoneStandEntity.class, TrackedDataHandlerRegistry.STRING);
    private static final List<String> TYPES = List.of("stage_tripod", "stage_round", "boom_tripod", "boom_round", "desk_tripod", "desk_round", "overhead", "studio");
    private static final TrackedData<String> MICROPHONE = DataTracker.registerData(MicrophoneStandEntity.class, TrackedDataHandlerRegistry.STRING);
    private static final List<Item> MICROPHONES = List.of(CrescentItems.BLUR_BM7B, CrescentItems.BLUR_BM57, CrescentItems.BLUR_BM58, CrescentItems.GLUE_YETI, CrescentItems.PAPERX_CUBECAST, CrescentItems.TRUMANN_U_98, CrescentItems.TRUMANN_M_196, CrescentItems.VOXEL_VOICE_VE20);

    protected MicrophoneStandEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return null;
    }
}
