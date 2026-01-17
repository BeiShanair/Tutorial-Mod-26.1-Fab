package com.besson.tutorial.tag;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> SUGAR_TAG = bind("sugar_tag");
    public static final TagKey<Item> FIRE_ETHER_TOOL_MATERIALS = bind("fire_ether_tool_materials");
    public static final TagKey<Item> ICE_ETHER_ARMOR_MATERIALS = bind("ice_ether_armor_materials");

    private static TagKey<Item> bind(final String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
