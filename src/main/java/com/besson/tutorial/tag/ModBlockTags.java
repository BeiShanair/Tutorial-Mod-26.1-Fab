package com.besson.tutorial.tag;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> ORE_TAGS = create("ore_tags");
    public static final TagKey<Block> PICKAXE_AXE_MINEABLE = create("pickaxe_axe_mineable");

    private static TagKey<Block> create(final String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
