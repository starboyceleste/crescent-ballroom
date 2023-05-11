package net.celeste.crescent.data.client;

import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CrescentModels {
    public static final Model CUBE_DISPLAY = block("cube_display", TextureKey.PARTICLE, TextureKey.NORTH, TextureKey.SOUTH, TextureKey.EAST, TextureKey.WEST, TextureKey.UP, TextureKey.DOWN);
    public static final Model CUBE_DISPLAY_ALL = block("cube_display_all", TextureKey.ALL);
    public static final Model TEMPLATE_CESNA = block("template_cesna", TextureKey.TEXTURE);

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("crescent", "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
