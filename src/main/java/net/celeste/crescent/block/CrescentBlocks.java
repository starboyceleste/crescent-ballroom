package net.celeste.crescent.block;

import net.celeste.crescent.Crescent;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class CrescentBlocks {
    public static final Block FLORENCE_CESNA_CHAIR = register("florence_cesna_chair", new CesnaChairBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(3.0f).sounds(BlockSoundGroup.WOOD)));

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Crescent.MOD_ID, id), block);
    }

    public static void init() {
    }
}
