package net.celeste.crescent.data.client;

import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;

public class CrescentTexturedModel {
    public static final TexturedModel.Factory TEMPLATE_CESNA = TexturedModel.makeFactory(TextureMap::texture, CrescentModels.TEMPLATE_CESNA);
    public static final TexturedModel.Factory CUBE_DISPLAY_ALL = TexturedModel.makeFactory(TextureMap::all, CrescentModels.CUBE_DISPLAY_ALL);
}
