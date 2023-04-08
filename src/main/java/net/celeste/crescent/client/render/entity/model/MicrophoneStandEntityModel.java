package net.celeste.crescent.client.render.entity.model;

import net.celeste.crescent.entity.MicrophoneStandEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MicrophoneStandEntityModel extends EntityModel<MicrophoneStandEntity> {
    private final ModelPart POLE;
    private final ModelPart ROUND;
    private final ModelPart TRIPOD;
    private final ModelPart BOOM;

    public MicrophoneStandEntityModel(ModelPart root) {
        this.POLE = root.getChild("POLE");
        this.ROUND = root.getChild("ROUND");
        this.TRIPOD = root.getChild("TRIPOD");
        this.BOOM = root.getChild("BOOM");

        this.TRIPOD.visible = true;
        this.ROUND.visible = false;

        this.BOOM.getChild("BLUR_BM57").visible = false;
        this.BOOM.getChild("BLUR_BM58").visible = false;
        this.BOOM.getChild("BLUR_BM7B").visible = true;
        this.BOOM.getChild("GLUE_YETI").visible = false;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData POLE = root.addChild("POLE", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.75F, 0.0F));
        ModelPartData pole_main = POLE.addChild("pole_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.25F, 0.0F));
        pole_main.addChild("pole_main_r1", ModelPartBuilder.create().uv(0, 7).cuboid(0.0F, -8.0F, -1.0F, 0.0F, 16.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
        pole_main.addChild("pole_main_r2", ModelPartBuilder.create().uv(0, 7).cuboid(0.0F, -8.0F, -1.0F, 0.0F, 16.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        ModelPartData pole_sec = POLE.addChild("pole_sec", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        pole_sec.addChild("pole_sec_r1", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, -4.75F, -1.0F, 0.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        pole_sec.addChild("pole_sec_r2", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, -4.75F, -1.0F, 0.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
        ModelPartData pole_cable = POLE.addChild("pole_cable", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.75F, 0.0F));
        pole_cable.addChild("pole_cable_ground", ModelPartBuilder.create().uv(4, 7).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, -0.3491F, 0.0F));
        pole_cable.addChild("pole_cable_south", ModelPartBuilder.create().uv(26, 21).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, -0.3491F, 0.0F));
        pole_cable.addChild("pole_cable_north", ModelPartBuilder.create().uv(20, 26).cuboid(0.0F, -4.0F, -1.25F, 0.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.5F, 0.0F, 0.0F, 0.1745F, 0.0F));
        root.addChild("ROUND", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, 2.25F, -4.0F, 8.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.75F, 0.0F));
        ModelPartData TRIPOD = root.addChild("TRIPOD", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 21.5F, 0.0F));
        TRIPOD.addChild("tripod_leg_r1", ModelPartBuilder.create().uv(4, 0).cuboid(0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 0.0F, -0.3491F, 0.0F, 0.0F));
        TRIPOD.addChild("tripod_support_r1", ModelPartBuilder.create().uv(0, 1).cuboid(0.0F, 0.25F, 0.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
        TRIPOD.addChild("tripod_leg_r2", ModelPartBuilder.create().uv(4, 0).cuboid(0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 0.0F, -0.3491F, -2.0944F, 0.0F));
        TRIPOD.addChild("tripod_support_r2", ModelPartBuilder.create().uv(0, 1).cuboid(0.0F, 0.25F, 0.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, -2.0944F, 0.0F));
        TRIPOD.addChild("tripod_leg_r3", ModelPartBuilder.create().uv(4, 0).cuboid(0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 0.0F, -0.3491F, 2.0944F, 0.0F));
        TRIPOD.addChild("tripod_support_r3", ModelPartBuilder.create().uv(0, 1).cuboid(0.0F, 0.25F, 0.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 2.0944F, 0.0F));
        ModelPartData BOOM = root.addChild("BOOM", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
        BOOM.addChild("boom_pole_r1", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, 0.0F, -8.0F, 2.0F, 0.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        BOOM.addChild("boom_pole_r2", ModelPartBuilder.create().uv(16, 0).cuboid(-1.0F, 0.0F, -8.0F, 2.0F, 0.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
        ModelPartData GLUE_YETI = BOOM.addChild("GLUE_YETI", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -3.5F));
        ModelPartData GLUE_YETI_MOUNT = GLUE_YETI.addChild("GLUE_YETI_MOUNT", ModelPartBuilder.create().uv(16, 19).cuboid(0.0F, -1.25F, -5.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.5F, -4.0F));
        GLUE_YETI_MOUNT.addChild("glue_yeti_shock", ModelPartBuilder.create().uv(2, 30).cuboid(-3.0F, 1.75F, -7.25F, 6.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        GLUE_YETI_MOUNT.addChild("glue_yeti_buttons", ModelPartBuilder.create().uv(8, 27).cuboid(-1.25F, -1.25F, -5.25F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        GLUE_YETI_MOUNT.addChild("glue_yeti_logo", ModelPartBuilder.create().uv(8, 26).cuboid(-1.0F, 1.0F, -5.25F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        GLUE_YETI_MOUNT.addChild("glue_yeti_body", ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, -1.25F, -5.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.25F, -0.25F));
        GLUE_YETI.addChild("GLUE_YETI_CABLE", ModelPartBuilder.create().uv(4, 18).cuboid(0.0F, -1.5F, -1.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -3.0F));
        ModelPartData BLUR_BM7B = BOOM.addChild("BLUR_BM7B", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -3.5F));
        ModelPartData BLUR_BM7B_MOUNT = BLUR_BM7B.addChild("BLUR_BM7B_MOUNT", ModelPartBuilder.create().uv(6, 2).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -4.5F, -0.2618F, 0.0F, 0.0F));
        ModelPartData blur_bm7b_bracket = BLUR_BM7B_MOUNT.addChild("blur_bm7b_bracket", ModelPartBuilder.create().uv(20, 13).cuboid(-1.5F, 1.5F, -1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        blur_bm7b_bracket.addChild("blur_bm7b_body", ModelPartBuilder.create().uv(10, 10).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.25F, -0.25F, 0.6109F, 0.0F, 0.0F));
        BLUR_BM7B.addChild("BLUR_BM7B_CABLE", ModelPartBuilder.create().uv(10, 18).cuboid(-0.5F, 0.0F, 0.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, -3.0F, -0.2618F, 0.0F, 0.0F));
        BLUR_BM7B.addChild("BLUR_BM7B_ARMCABLE", ModelPartBuilder.create().uv(20, 4).cuboid(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -3.0F));
        ModelPartData BLUR_BM57 = BOOM.addChild("BLUR_BM57", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -3.5F));
        ModelPartData BLUR_BM57_MOUNT = BLUR_BM57.addChild("BLUR_BM57_MOUNT", ModelPartBuilder.create().uv(18, 19).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -4.5F, 0.3491F, 0.0F, 0.0F));
        ModelPartData blur_bm57_bracket = BLUR_BM57_MOUNT.addChild("blur_bm57_bracket", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        blur_bm57_bracket.addChild("blur_bm57_bracket_r1", ModelPartBuilder.create().uv(18, 18).cuboid(0.25F, -1.25F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
        blur_bm57_bracket.addChild("blur_bm57_body", ModelPartBuilder.create().uv(12, 19).cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -0.5F));
        BLUR_BM57.addChild("BLUR_BM57_CABLE", ModelPartBuilder.create().uv(18, 15).cuboid(0.0F, -1.5F, -1.75F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -3.0F));
        ModelPartData BLUR_BM58 = BOOM.addChild("BLUR_BM58", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -3.5F));
        ModelPartData BLUR_BM58_MOUNT = BLUR_BM58.addChild("BLUR_BM58_MOUNT", ModelPartBuilder.create().uv(18, 19).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -4.5F, 0.3491F, 0.0F, 0.0F));
        ModelPartData blur_bm58_bracket = BLUR_BM58_MOUNT.addChild("blur_bm58_bracket", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        blur_bm58_bracket.addChild("blur_bm58_bracket_r1", ModelPartBuilder.create().uv(18, 18).cuboid(0.25F, -1.25F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
        blur_bm58_bracket.addChild("blur_bm58_body", ModelPartBuilder.create().uv(22, 16).cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -0.5F));
        BLUR_BM58.addChild("BLUR_BM58_CABLE", ModelPartBuilder.create().uv(18, 15).cuboid(0.0F, -1.5F, -1.75F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, -3.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void animateModel(MicrophoneStandEntity microphoneStandEntity, float f, float g, float h) {
    }

    @Override
    public void setAngles(MicrophoneStandEntity microphoneStandEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.BOOM.pitch = MathHelper.lerp(0.4f, (float) Math.toRadians(microphoneStandEntity.getBoomRotation("current")), (float) Math.toRadians(microphoneStandEntity.getBoomRotation("end")));
        microphoneStandEntity.updateBoomRotation((float) Math.toDegrees(this.BOOM.pitch));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        POLE.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        ROUND.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        TRIPOD.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        BOOM.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}