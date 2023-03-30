package net.celeste.crescent;

import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.celeste.crescent.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class CrescentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> "crescent".equals(location.getNamespace()));
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MICROPHONE_STAND_STAGE_TRIPOD_BOOM_0, RenderLayer.getCutout());
    }
}
