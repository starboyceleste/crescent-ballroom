package net.celeste.crescent.entity;

import net.celeste.crescent.Crescent;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypeFilter;
import org.jetbrains.annotations.Nullable;

public class CrescentEntityType<T extends Entity> implements ToggleableFeature, TypeFilter<Entity, T> {

    public static final EntityType<MicrophoneStandEntity> MICROPHONE_STAND = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Crescent.MOD_ID, "microphone_stand"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, MicrophoneStandEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 1.975f))
                    .build()
    );

    public static void init() {
        FabricDefaultAttributeRegistry.register(MICROPHONE_STAND, MicrophoneStandEntity.createLivingAttributes());
    }

    @Override
    public FeatureSet getRequiredFeatures() {
        return null;
    }

    @Nullable
    @Override
    public T downcast(Entity obj) {
        return null;
    }

    @Override
    public Class<? extends Entity> getBaseClass() {
        return null;
    }
}
