package net.celeste.crescent.client.render.entity.model;

import net.celeste.crescent.entity.SeatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SeatEntityModel extends EntityModel<SeatEntity> {

    public SeatEntityModel(ModelPart root) {
    }

    @Override
    public void setAngles(SeatEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        root.addChild("null", ModelPartBuilder.create().uv(0, 0).cuboid(0F, 0F, 0F, 0F, 0F, 0F), ModelTransform.pivot(0F, 0F, 0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
    }
}
