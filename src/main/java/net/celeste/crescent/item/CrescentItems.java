package net.celeste.crescent.item;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.registry.CrescentItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class CrescentItems {
    public static final CrescentItem BLUR_BM7B = register("blur_bm7b", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);
    public static final CrescentItem BLUR_BM57 = register("blur_bm57", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);
    public static final CrescentItem BLUR_BM58 = register("blur_bm58", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);
    public static final CrescentItem GLUE_YETI = register("glue_yeti", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);
    public static final CrescentItem PAPERX_CUBECAST = register("paperx_cubecast", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);
    public static final CrescentItem TRUMANN_M_196 = register("trumann_m_196", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);
    public static final CrescentItem TRUMANN_U_98 = register("trumann_u_98", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);
    public static final CrescentItem VOXEL_VOICE_VE20 = register("voxel_voice_ve20", new CrescentItem(new FabricItemSettings()), CrescentItemGroups.CRESCENT);

    private static CrescentItem register(String name, CrescentItem item, ItemGroup group) {
        if (group != null){
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        }
        return Registry.register(Registries.ITEM, new Identifier(Crescent.MOD_ID, name), item);
    }

    public static void init() {
    }
}
