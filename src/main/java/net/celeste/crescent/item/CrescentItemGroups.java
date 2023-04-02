package net.celeste.crescent.item;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CrescentItemGroups {
    public static final ItemGroup CRESCENT = FabricItemGroup.builder(new Identifier(Crescent.MOD_ID, "crescent"))
            .displayName(Text.translatable("itemgroup.crescent"))
            .icon(() -> new ItemStack(CrescentItems.BLUR_BM7B))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(CrescentItems.BLUR_BM57);
                entries.add(CrescentItems.BLUR_BM58);
                entries.add(CrescentItems.BLUR_BM7B);
                entries.add(CrescentItems.GLUE_YETI);
                entries.add(CrescentItems.PAPERX_CUBECAST);
                entries.add(CrescentItems.TRUMANN_M_196);
                entries.add(CrescentItems.TRUMANN_U_98);
                entries.add(CrescentItems.VOXEL_VOICE_VE20);
            })
            .build();

    public static void CrescentItemGroups(){}
}
