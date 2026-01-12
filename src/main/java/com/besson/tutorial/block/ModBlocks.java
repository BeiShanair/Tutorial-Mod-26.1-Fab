package com.besson.tutorial.block;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block ICE_ETHER_BLOCK = register("ice_ether_block",
            BlockBehaviour.Properties.of().strength(1.0f, 3.0f),true);
    public static final Block RAW_ICE_ETHER_BLOCK = register("raw_ice_ether_block",
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE),true);
    public static final Block ICE_ETHER_ORE = register("ice_ether_ore",
            BlockBehaviour.Properties.of().strength(1.0f, 3.0f).requiresCorrectToolForDrops(),true);

    public static Block register(final String name, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        ResourceKey<Block> id = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
        Block block = (Block)factory.apply(properties.setId(id));

        if (shouldRegisterItem) {
            registerBlockItem(name, block);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static Block register(final String name, final BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        return register(name, Block::new, properties, shouldRegisterItem);
    }

    private static void registerBlockItem(String name, Block block) {
        ResourceKey<Item> id = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(id).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, id, blockItem);
    }

    public static void register() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
    }
}
