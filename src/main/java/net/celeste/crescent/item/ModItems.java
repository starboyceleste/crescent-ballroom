package net.celeste.crescent.item;

import net.celeste.crescent.Crescent;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLUR_BM7B = registerItem("blur_bm7b",
            new Item(new FabricItemSettings()));
    public static final Item BLUR_BM57 = registerItem("blur_bm57",
            new Item(new FabricItemSettings()));
    public static final Item BLUR_BM58 = registerItem("blur_bm58",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Crescent.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.STAGE, BLUR_BM7B);
        addToItemGroup(ModItemGroup.STAGE, BLUR_BM57);
        addToItemGroup(ModItemGroup.STAGE, BLUR_BM58);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Crescent.LOGGER.info("Registering items for " + Crescent.MOD_ID);

        addItemsToItemGroup();
    }
}
