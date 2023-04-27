package net.celeste.crescent.client.render.entity.model;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.client.render.entity.MicrophoneStandEntityRenderer;
import net.celeste.crescent.client.render.entity.SeatEntityRenderer;
import net.celeste.crescent.entity.CrescentEntityType;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class CrescentEntityModelLayers {
    public static final EntityModelLayer MICROPHONE_STAND = new EntityModelLayer(new Identifier(Crescent.MOD_ID, "microphone_stand"), "main");

    public static void init() {
        EntityRendererRegistry.register(CrescentEntityType.MICROPHONE_STAND, MicrophoneStandEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MICROPHONE_STAND, MicrophoneStandEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(CrescentEntityType.SEAT, SeatEntityRenderer::new);
    }
}
