package com.besson.tutorial.block;

import com.besson.tutorial.TutorialMod;
import com.besson.tutorial.block.custom.StrawberryCrop;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {
    public static final Block ICE_ETHER_BLOCK = register("ice_ether_block",
            BlockBehaviour.Properties.of().strength(1.0f, 3.0f),true);
    public static final Block RAW_ICE_ETHER_BLOCK = register("raw_ice_ether_block",
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE),true);
    public static final Block ICE_ETHER_ORE = register("ice_ether_ore",
            BlockBehaviour.Properties.of().strength(1.0f, 3.0f).requiresCorrectToolForDrops(),true);

    public static final Block ICE_ETHER_STAIRS = register("ice_ether_stairs",
            p -> new StairBlock(ICE_ETHER_BLOCK.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(ICE_ETHER_BLOCK), true);
    public static final Block ICE_ETHER_SLAB = register("ice_ether_slab", SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(ICE_ETHER_BLOCK), true);
    public static final Block ICE_ETHER_BUTTON = register("ice_ether_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p),
            BlockBehaviour.Properties.ofFullCopy(ICE_ETHER_BLOCK), true);
    public static final Block ICE_ETHER_PRESSURE_PLATE = register("ice_ether_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p),
            BlockBehaviour.Properties.ofFullCopy(ICE_ETHER_BLOCK), true);
    public static final Block ICE_ETHER_FENCE_GATE = register("ice_ether_fence_gate", p -> new FenceGateBlock(WoodType.OAK, p),
            BlockBehaviour.Properties.ofFullCopy(ICE_ETHER_BLOCK), true);
    public static final Block ICE_ETHER_FENCE = register("ice_ether_fence", FenceBlock::new,
            BlockBehaviour.Properties.ofFullCopy(ICE_ETHER_BLOCK), true);
    public static final Block ICE_ETHER_WALL = register("ice_ether_wall", WallBlock::new,
            BlockBehaviour.Properties.ofFullCopy(ICE_ETHER_BLOCK), true);
    public static final Block ICE_ETHER_DOOR = register("ice_ether_door", p -> new DoorBlock(BlockSetType.IRON, p),
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR), true);
    public static final Block ICE_ETHER_TRAPDOOR = register("ice_ether_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR), true);

    public static final Block STRAWBERRY_CROP = register("strawberry_crop", StrawberryCrop::new,
            BlockBehaviour.Properties.of()
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY), false);

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
