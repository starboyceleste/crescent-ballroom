package net.celeste.crescent.item;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.block.CrescentBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrescentItems {
    public static final Item BLUR_BM57_MICROPHONE = CrescentItems.register("blur_bm57_microphone", new Item(new FabricItemSettings()));
    public static final Item BLUR_BM58_MICROPHONE = CrescentItems.register("blur_bm58_microphone", new Item(new FabricItemSettings()));
    public static final Item BLUR_BM7B_MICROPHONE = CrescentItems.register("blur_bm7b_microphone", new Item(new FabricItemSettings()));
    public static final Item GLUE_YETI_MICROPHONE = CrescentItems.register("glue_yeti_microphone", new Item(new FabricItemSettings()));
    public static final Item PAPERX_CUBECAST_MICROPHONE = CrescentItems.register("paperx_cubecast_microphone", new Item(new FabricItemSettings()));
    public static final Item TRUMANN_M_196_MICROPHONE = CrescentItems.register("trumann_m_196_microphone", new Item(new FabricItemSettings()));
    public static final Item TRUMANN_U_98_MICROPHONE = CrescentItems.register("trumann_u_98_microphone", new Item(new FabricItemSettings()));
    public static final Item VOXEL_VOICE_VE20_MICROPHONE = CrescentItems.register("voxel_voice_ve20_microphone", new Item(new FabricItemSettings()));
    public static final Item MICROPHONE_STAND = CrescentItems.register("microphone_stand", new MicrophoneStandItem(new FabricItemSettings()));
    public static final Item FLORENCE_CESNA_CHAIR = CrescentItems.register(CrescentBlocks.FLORENCE_CESNA_CHAIR);
    public static final Item GREEN_SCREEN = CrescentItems.register(CrescentBlocks.GREEN_SCREEN);

    private static Item register(Block block) {
        return CrescentItems.register(new BlockItem(block, new Item.Settings()));
    }

    private static Item register(BlockItem item) {
        return CrescentItems.register(item.getBlock(), item);
    }

    protected static Item register(Block block, Item item) {
        return CrescentItems.register(Registries.BLOCK.getId(block), item);
    }

    private static Item register(String id, Item item) {
        return CrescentItems.register(new Identifier(Crescent.MOD_ID, id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void init() {
    }
}
