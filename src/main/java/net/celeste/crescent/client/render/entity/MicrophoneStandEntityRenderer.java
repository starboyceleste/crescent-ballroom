package net.celeste.crescent.client.render.entity;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.client.render.entity.model.CrescentEntityModelLayers;
import net.celeste.crescent.client.render.entity.model.MicrophoneStandEntityModel;
import net.celeste.crescent.entity.MicrophoneStandEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class MicrophoneStandEntityRenderer extends LivingEntityRenderer<MicrophoneStandEntity, MicrophoneStandEntityModel> {
    public MicrophoneStandEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MicrophoneStandEntityModel(context.getPart(CrescentEntityModelLayers.MICROPHONE_STAND)), 0.2f);
    }

    @Override
    public Identifier getTexture(MicrophoneStandEntity entity) {
        return new Identifier(Crescent.MOD_ID, "textures/entity/microphone_stand/microphone_stand.png");
    }
}
