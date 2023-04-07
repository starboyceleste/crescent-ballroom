package net.celeste.crescent.client.render.entity.model;

import net.celeste.crescent.entity.MicrophoneStandEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MicrophoneStandEntityModel extends EntityModel<MicrophoneStandEntity> {
	private final ModelPart POLE;
	private final ModelPart pole_main;
	private final ModelPart pole_main_r1;
	private final ModelPart pole_main_r2;
	private final ModelPart pole_sec;
	private final ModelPart pole_sec_r1;
	private final ModelPart pole_sec_r2;
	private final ModelPart pole_cable;
	private final ModelPart pole_cable_ground;
	private final ModelPart pole_cable_south;
	private final ModelPart pole_cable_north;
	private final ModelPart ROUND;
	private final ModelPart TRIPOD;
	private final ModelPart tripod_support_r1;
	private final ModelPart tripod_leg_r1;
	private final ModelPart tripod_support_r2;
	private final ModelPart tripod_leg_r2;
	private final ModelPart tripod_support_r3;
	private final ModelPart tripod_leg_r3;
	private final ModelPart BOOM;
	private final ModelPart boom_pole_r1;
	private final ModelPart boom_pole_r2;
	private final ModelPart GLUE_YETI;
	private final ModelPart GLUE_YETI_MOUNT;
	private final ModelPart glue_yeti_shock;
	private final ModelPart glue_yeti_body;
	private final ModelPart glue_yeti_buttons;
	private final ModelPart glue_yeti_logo;
	private final ModelPart GLUE_YETI_CABLE;
	private final ModelPart BLUR_BM7B;
	private final ModelPart BLUR_BM7B_MOUNT;
	private final ModelPart blur_bm7b_bracket;
	private final ModelPart blur_bm7b_body;
	private final ModelPart BLUR_BM7B_CABLE;
	private final ModelPart BLUR_BM7B_ARMCABLE;
	private final ModelPart BLUR_BM57;
	private final ModelPart BLUR_BM57_MOUNT;
	private final ModelPart blur_bm57_bracket;
	private final ModelPart blur_bm57_bracket_r1;
	private final ModelPart blur_bm57_body;
	private final ModelPart BLUR_BM57_CABLE;
	private final ModelPart BLUR_BM58;
	private final ModelPart BLUR_BM58_MOUNT;
	private final ModelPart blur_bm58_bracket;
	private final ModelPart blur_bm58_bracket_r1;
	private final ModelPart blur_bm58_body;
	private final ModelPart BLUR_BM58_CABLE;
	public MicrophoneStandEntityModel(ModelPart root) {
		this.POLE = root.getChild("POLE");
			this.pole_main = this.POLE.getChild("pole_main");
				this.pole_main_r1 = pole_main.getChild("pole_main_r1");
				this.pole_main_r2 = pole_main.getChild("pole_main_r2");
			this.pole_sec = this.POLE.getChild("pole_sec");
				this.pole_sec_r1 = this.pole_sec.getChild("pole_sec_r1");
				this.pole_sec_r2 = this.pole_sec.getChild("pole_sec_r2");
			this.pole_cable = this.POLE.getChild("pole_cable");
				this.pole_cable_ground = this.pole_cable.getChild("pole_cable_ground");
				this.pole_cable_south = this.pole_cable.getChild("pole_cable_south");
				this.pole_cable_north = this.pole_cable.getChild("pole_cable_north");

		this.ROUND = root.getChild("ROUND");

		this.TRIPOD = root.getChild("TRIPOD");
			this.tripod_support_r1 = this.TRIPOD.getChild("tripod_support_r1");
			this.tripod_leg_r1 = this.TRIPOD.getChild("tripod_leg_r1");
			this.tripod_support_r2 = this.TRIPOD.getChild("tripod_support_r2");
			this.tripod_leg_r2 = this.TRIPOD.getChild("tripod_leg_r2");
			this.tripod_support_r3 = this.TRIPOD.getChild("tripod_support_r3");
			this.tripod_leg_r3 = this.TRIPOD.getChild("tripod_leg_r3");

		this.BOOM = root.getChild("BOOM");
			this.boom_pole_r1 = this.BOOM.getChild("boom_pole_r1");
			this.boom_pole_r2 = this.BOOM.getChild("boom_pole_r2");

			this.GLUE_YETI = this.BOOM.getChild("GLUE_YETI");
				this.GLUE_YETI_MOUNT = this.GLUE_YETI.getChild("GLUE_YETI_MOUNT");
					this.glue_yeti_shock = this.GLUE_YETI_MOUNT.getChild("glue_yeti_shock");
					this.glue_yeti_body = this.GLUE_YETI_MOUNT.getChild("glue_yeti_body");
					this.glue_yeti_buttons = this.GLUE_YETI_MOUNT.getChild("glue_yeti_buttons");
					this.glue_yeti_logo = this.GLUE_YETI_MOUNT.getChild("glue_yeti_logo");
				this.GLUE_YETI_CABLE = this.GLUE_YETI.getChild("GLUE_YETI_CABLE");

			this.BLUR_BM7B = this.BOOM.getChild("BLUR_BM7B");
				this.BLUR_BM7B_MOUNT = this.BLUR_BM7B.getChild("BLUR_BM7B_MOUNT");
					this.blur_bm7b_bracket = this.BLUR_BM7B_MOUNT.getChild("blur_bm7b_bracket");
						this.blur_bm7b_body = this.blur_bm7b_bracket.getChild("blur_bm7b_body");
				this.BLUR_BM7B_CABLE = this.BLUR_BM7B.getChild("BLUR_BM7B_CABLE");
				this.BLUR_BM7B_ARMCABLE = this.BLUR_BM7B.getChild("BLUR_BM7B_ARMCABLE");

			this.BLUR_BM57 = this.BOOM.getChild("BLUR_BM57");
				this.BLUR_BM57_MOUNT = this.BLUR_BM57.getChild("BLUR_BM57_MOUNT");
					this.blur_bm57_bracket = this.BLUR_BM57_MOUNT.getChild("blur_bm57_bracket");
						this.blur_bm57_bracket_r1 = this.blur_bm57_bracket.getChild("blur_bm57_bracket_r1"); // Unresolved parent (bracket -> bracket_r1) because this part needs to be rotated 45 degrees. Results in a nicer rotation for the BM57 body.
							this.blur_bm57_body = this.blur_bm57_bracket.getChild("blur_bm57_body");
				this.BLUR_BM57_CABLE = this.BLUR_BM57.getChild("BLUR_BM57_CABLE");

			this.BLUR_BM58 = this.BOOM.getChild("BLUR_BM58");
				this.BLUR_BM58_MOUNT = this.BLUR_BM58.getChild("BLUR_BM58_MOUNT");
					this.blur_bm58_bracket = this.BLUR_BM58_MOUNT.getChild("blur_bm58_bracket");
						this.blur_bm58_bracket_r1 = this.blur_bm58_bracket.getChild("blur_bm58_bracket_r1");  // See BM57 bracket part.
							this.blur_bm58_body = this.blur_bm58_bracket.getChild("blur_bm58_body");
				this.BLUR_BM58_CABLE = this.BLUR_BM58.getChild("BLUR_BM58_CABLE");

		this.TRIPOD.visible = true;
		this.ROUND.visible = false;
		this.BLUR_BM57.visible = false;
		this.BLUR_BM58.visible = false;
		this.BLUR_BM7B.visible = true;
		this.GLUE_YETI.visible = false;
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
		this.BOOM.pitch = MathHelper.lerp(0.1f, this.BOOM.pitch, ((float)Math.PI / 180) * microphoneStandEntity.getBoomRotation());
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		POLE.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		ROUND.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		TRIPOD.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		BOOM.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}