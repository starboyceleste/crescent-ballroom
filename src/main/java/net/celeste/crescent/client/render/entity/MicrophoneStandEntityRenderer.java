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
    protected void setupTransforms(MicrophoneStandEntity microphoneStandEntity, MatrixStack matrixStack, float f, float g, float h) {
        if (microphoneStandEntity.reset > 0) {
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.sin(microphoneStandEntity.reset / 1.5f * (float)Math.PI) * 3.0f));
        }
    }

//    @Override
//    protected boolean hasLabel(MicrophoneStandEntity microphoneStandEntity) {
//        float f;
//        double d = this.dispatcher.getSquaredDistanceToCamera(microphoneStandEntity);
//        float f2 = f = microphoneStandEntity.isInSneakingPose() ? 32.0f : 64.0f;
//        if (d >= (double)(f * f)) {
//            return false;
//        }
//        return microphoneStandEntity.isCustomNameVisible();
//    }
}
