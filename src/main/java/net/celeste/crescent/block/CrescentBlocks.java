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
    public static final Block CAMBRIDGE_CESNA_CHAIR = register("cambridge_cesna_chair", new CesnaChairBlock(FabricBlockSettings.of(Material.WOOD, MapColor.DEEPSLATE_GRAY).strength(3.0f).sounds(BlockSoundGroup.WOOD)));
    public static final Block FLORENCE_CESNA_CHAIR = register("florence_cesna_chair", new CesnaChairBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(3.0f).sounds(BlockSoundGroup.WOOD)));
    public static final Block WASHINGTON_CESNA_CHAIR = register("washington_cesna_chair", new CesnaChairBlock(FabricBlockSettings.of(Material.WOOD, MapColor.TERRACOTTA_WHITE).strength(3.0f).sounds(BlockSoundGroup.WOOD)));
    public static final Block BLUE_SCREEN = register("blue_screen", new Block(FabricBlockSettings.of(Material.WOOL, MapColor.BLUE).strength(3.0f).sounds(BlockSoundGroup.WOOL)));
    public static final Block GREEN_SCREEN = register("green_screen", new Block(FabricBlockSettings.of(Material.WOOL, MapColor.LIME).strength(3.0f).sounds(BlockSoundGroup.WOOL)));
    public static final Block RED_SCREEN = register("red_screen", new Block(FabricBlockSettings.of(Material.WOOL, MapColor.RED).strength(3.0f).sounds(BlockSoundGroup.WOOL)));

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Crescent.MOD_ID, id), block);
    }

    public static void init() {
    }
}
