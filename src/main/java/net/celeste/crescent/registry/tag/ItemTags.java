package net.celeste.crescent.registry.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ItemTags {
    public static final TagKey<Item> MICROPHONE = ItemTags.of("microphone");

    private ItemTags() {
    }

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
    }
}
