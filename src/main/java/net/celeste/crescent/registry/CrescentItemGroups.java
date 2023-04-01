package net.celeste.crescent.registry;

import net.celeste.crescent.Crescent;
import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CrescentItemGroups {
    public static final ItemGroup CRESCENT = FabricItemGroup.builder(new Identifier(Crescent.MOD_ID, "crescent"))
            .displayName(Text.translatable("itemgroup.crescent"))
            .icon(() -> new ItemStack(CrescentItems.BLUR_BM7B)).build();
}
