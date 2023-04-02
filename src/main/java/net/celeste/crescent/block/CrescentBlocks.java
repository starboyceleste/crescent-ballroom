package net.celeste.crescent.block;

import net.celeste.crescent.Crescent;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrescentBlocks {
    public static final CrescentBlock EXAMPLE_BLOCK = register("example_block", new CrescentBlock(AbstractBlock.Settings.of(Material.STONE, MapColor.STONE_GRAY).requiresTool().strength(1.5f, 6.0f)));

    private static CrescentBlock register(String id, CrescentBlock block) {
        return Registry.register(Registries.BLOCK, new Identifier(Crescent.MOD_ID, id), block);
    }

    public static void CrescentBlocks(){}
}
