package net.celeste.crescent.block;

import net.celeste.crescent.Crescent;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrescentBlocks {
    public static final Block EXAMPLE_BLOCK = register("example_block", new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.STONE_GRAY).requiresTool().strength(1.5f, 6.0f)));

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Crescent.MOD_ID, id), block);
    }

    public static void init(){}
}
