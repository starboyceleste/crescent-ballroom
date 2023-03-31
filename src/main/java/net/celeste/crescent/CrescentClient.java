package net.celeste.crescent;

import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.fabricmc.api.ClientModInitializer;

public class CrescentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> "crescent".equals(location.getNamespace()));
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRIPOD_MICROPHONE_STAND, RenderLayer.getCutout());
    }
}
