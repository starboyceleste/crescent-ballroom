package net.celeste.crescent.client.render.entity.model;

import net.celeste.crescent.entity.SeatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

public class SeatEntityModel extends AnimalModel<SeatEntity> {
    private final ModelPart base;

    public SeatEntityModel(ModelPart modelPart) {
        this.base = modelPart.getChild(EntityModelPartNames.CUBE);
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of();
    }

    @Override
    public void setAngles(SeatEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0, 0).cuboid(0F, 0F, 0F, 0F, 0F, 0F), ModelTransform.pivot(0F, 0F, 0F));
        return TexturedModelData.of(modelData, 16, 16);

    }
}
