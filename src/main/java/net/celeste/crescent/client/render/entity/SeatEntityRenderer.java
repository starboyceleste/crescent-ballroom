package net.celeste.crescent.client.render.entity;

import net.celeste.crescent.client.render.entity.model.CrescentEntityModelLayers;
import net.celeste.crescent.client.render.entity.model.SeatEntityModel;
import net.celeste.crescent.entity.SeatEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SeatEntityRenderer extends MobEntityRenderer<SeatEntity, SeatEntityModel> {
    public SeatEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SeatEntityModel(context.getPart(CrescentEntityModelLayers.SEAT)), 0f);
    }

    public Identifier getTexture(SeatEntity entity) {
        return new Identifier("minecraft:textures/block/stone.png");
    }

    public SeatEntityRenderer(EntityRendererFactory.Context context, SeatEntityModel entityModel, float f) {
        super(context, entityModel, f);
    }
}
