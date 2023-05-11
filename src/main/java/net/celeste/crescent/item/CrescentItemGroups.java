package net.celeste.crescent.item;

import net.celeste.crescent.Crescent;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CrescentItemGroups extends ItemGroups {
    public static final ItemGroup CRESCENT = FabricItemGroup.builder(new Identifier(Crescent.MOD_ID, "crescent"))
            .icon(() -> new ItemStack(CrescentItems.BLUR_BM7B_MICROPHONE))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(CrescentItems.BLUR_BM57_MICROPHONE);
                entries.add(CrescentItems.BLUR_BM58_MICROPHONE);
                entries.add(CrescentItems.BLUR_BM7B_MICROPHONE);
                entries.add(CrescentItems.GLUE_YETI_MICROPHONE);
                entries.add(CrescentItems.PAPERX_CUBECAST_MICROPHONE);
                entries.add(CrescentItems.TRUMANN_M_196_MICROPHONE);
                entries.add(CrescentItems.TRUMANN_U_98_MICROPHONE);
                entries.add(CrescentItems.VOXEL_VOICE_VE20_MICROPHONE);
                entries.add(CrescentItems.MICROPHONE_STAND);
                entries.add(CrescentItems.FLORENCE_CESNA_CHAIR);
                entries.add(CrescentItems.BLUE_SCREEN);
                entries.add(CrescentItems.GREEN_SCREEN);
                entries.add(CrescentItems.RED_SCREEN);
            }).build();

    public static void init() {
    }
}
