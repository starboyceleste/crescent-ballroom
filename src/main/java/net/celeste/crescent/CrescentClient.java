package net.celeste.crescent;

import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.celeste.crescent.client.render.entity.model.CrescentEntityModelLayers;
import net.fabricmc.api.ClientModInitializer;

public class CrescentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Crescent.LOGGER.info("Initialized client mod.");
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> "crescent".equals(location.getNamespace()));
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIPOD_MICROPHONE_STAND, RenderLayer.getCutout());
        CrescentEntityModelLayers.init();
    }
}
