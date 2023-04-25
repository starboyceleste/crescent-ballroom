package net.celeste.crescent.registry.tag;

import net.celeste.crescent.Crescent;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CrescentItemTags {
    public static final TagKey<Item> MICROPHONE = CrescentItemTags.of("microphone");
    public static final TagKey<Item> FURNITURE = CrescentItemTags.of("furniture");

    private CrescentItemTags() {
    }

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Crescent.MOD_ID, id));
    }
}
