package net.celeste.crescent.client.render.entity;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.client.render.entity.model.CrescentEntityModelLayers;
import net.celeste.crescent.client.render.entity.model.MicrophoneStandEntityModel;
import net.celeste.crescent.entity.MicrophoneStandEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class MicrophoneStandEntityRenderer extends LivingEntityRenderer<MicrophoneStandEntity, MicrophoneStandEntityModel> {
    public MicrophoneStandEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MicrophoneStandEntityModel(context.getPart(CrescentEntityModelLayers.MICROPHONE_STAND)), 0.2f);
    }

    @Override
    public Identifier getTexture(MicrophoneStandEntity microphoneStandEntity) {
        return new Identifier(Crescent.MOD_ID, "textures/entity/microphone_stand/microphone_stand.png");
    }

    @Override
    protected void setupTransforms(MicrophoneStandEntity microphoneStandEntity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - bodyYaw));
        float i = (float)(microphoneStandEntity.world.getTime() - microphoneStandEntity.lastShakeTime) + tickDelta;
        float shakeTime = 5.0f;
        if (i < shakeTime) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.sin((float) (i / (5 / Math.PI) * Math.PI)) * 2.0f));
        }
    }

    @Override
    protected boolean hasLabel(MicrophoneStandEntity microphoneStandEntity) {
        return (microphoneStandEntity.world.getTime() - microphoneStandEntity.lastShakeTime < 10);
    }
}
