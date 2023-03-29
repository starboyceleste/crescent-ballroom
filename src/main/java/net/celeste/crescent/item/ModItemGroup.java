package net.celeste.crescent.item;

import net.celeste.crescent.Crescent;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup STAGE;

    public static void registerItemGroups() {
        STAGE = FabricItemGroup.builder(new Identifier(Crescent.MOD_ID, "stage"))
                .displayName(Text.literal("Stage"))
                .icon(() -> new ItemStack(Items.SEA_LANTERN)).build();
    }
}
