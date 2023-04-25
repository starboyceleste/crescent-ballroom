package net.celeste.crescent.entity;

import net.celeste.crescent.Crescent;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrescentEntityType {

    public static final EntityType<MicrophoneStandEntity> MICROPHONE_STAND = Registry.register(Registries.ENTITY_TYPE, new Identifier(Crescent.MOD_ID, "microphone_stand"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, MicrophoneStandEntity::new).dimensions(EntityDimensions.fixed(0.5f, 1.975f)).build());
    public static final EntityType<SeatEntity> SEAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(Crescent.MOD_ID, "seat"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, SeatEntity::new).dimensions(EntityDimensions.fixed(0.0F, 0.0F)).disableSummon().build());
    //    public static final EntityType<SeatEntity> SEAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(Crescent.MOD_ID, "seat"), FabricEntityTypeBuilder.<SeatEntity>create(SpawnGroup.MISC, SeatEntity::new).dimensions(EntityDimensions.fixed(0.0F, 0.0F)).build();

    public static void init() {
        FabricDefaultAttributeRegistry.register(MICROPHONE_STAND, MicrophoneStandEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SEAT, SeatEntity.createAttributes());
    }
}
