package com.besson.tutorial.item;

import com.besson.tutorial.tag.ModItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial FIRE_ETHER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031, 12.0f, 4.0f, 30,
            ModItemTags.FIRE_ETHER_TOOL_MATERIALS);
}
