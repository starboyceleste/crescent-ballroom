package net.celeste.crescent.item;

import net.celeste.crescent.Crescent;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrescentItems {
    public static final CrescentItem BLUR_BM57_MICROPHONE = register("blur_bm57_microphone", new CrescentItem(new FabricItemSettings()));
    public static final CrescentItem BLUR_BM58_MICROPHONE = register("blur_bm58_microphone", new CrescentItem(new FabricItemSettings()));
    public static final CrescentItem BLUR_BM7B_MICROPHONE = register("blur_bm7b_microphone", new CrescentItem(new FabricItemSettings()));
    public static final CrescentItem GLUE_YETI_MICROPHONE = register("glue_yeti_microphone", new CrescentItem(new FabricItemSettings()));
    public static final CrescentItem PAPERX_CUBECAST_MICROPHONE = register("paperx_cubecast_microphone", new CrescentItem(new FabricItemSettings()));
    public static final CrescentItem TRUMANN_M_196_MICROPHONE = register("trumann_m_196_microphone", new CrescentItem(new FabricItemSettings()));
    public static final CrescentItem TRUMANN_U_98_MICROPHONE = register("trumann_u_98_microphone", new CrescentItem(new FabricItemSettings()));
    public static final CrescentItem VOXEL_VOICE_VE20_MICROPHONE = register("voxel_voice_ve20_microphone", new CrescentItem(new FabricItemSettings()));

    private static CrescentItem register(String id, CrescentItem item) {
        return Registry.register(Registries.ITEM, new Identifier(Crescent.MOD_ID, id), item);
    }

    public static void init(){}
}
