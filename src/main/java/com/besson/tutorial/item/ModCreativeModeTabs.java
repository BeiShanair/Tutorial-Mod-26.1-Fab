package com.besson.tutorial.item;

import com.besson.tutorial.TutorialMod;
import com.besson.tutorial.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> TUTORIAL_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "tutorial"));

    public static final CreativeModeTab TUTORIAL = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.ICE_ETHER))
            .title(Component.translatable("itemGroup.tutorial"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ICE_ETHER);
                output.accept(ModItems.RAW_ICE_ETHER);
                output.accept(ModItems.CARDBOARD);

                output.accept(ModItems.CORN);
                output.accept(ModItems.STRAWBERRY);
                output.accept(ModItems.CHEESE);

                output.accept(ModItems.ANTHRACITE);

                output.accept(ModItems.PROSPECTOR);

                output.accept(ModBlocks.ICE_ETHER_STAIRS);
                output.accept(ModBlocks.ICE_ETHER_SLAB);
                output.accept(ModBlocks.ICE_ETHER_FENCE);
                output.accept(ModBlocks.ICE_ETHER_FENCE_GATE);
                output.accept(ModBlocks.ICE_ETHER_WALL);
                output.accept(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
                output.accept(ModBlocks.ICE_ETHER_BUTTON);
                output.accept(ModBlocks.ICE_ETHER_DOOR);
                output.accept(ModBlocks.ICE_ETHER_TRAPDOOR);

                output.accept(Items.DIAMOND);
            }).build();

    public static final ResourceKey<CreativeModeTab> TUTORIAL_TAB2 = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "tutorial2"));

    public static final CreativeModeTab TUTORIAL2 = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.ICE_ETHER))
            .title(Component.translatable("itemGroup.tutorial2"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ICE_ETHER);
                output.accept(ModItems.RAW_ICE_ETHER);
                output.accept(ModItems.CARDBOARD);

                output.accept(ModBlocks.ICE_ETHER_BLOCK);
                output.accept(ModBlocks.RAW_ICE_ETHER_BLOCK);
                output.accept(ModBlocks.ICE_ETHER_ORE);

                output.accept(Items.DIAMOND);
            }).build();

    public static void register() {
        TutorialMod.LOGGER.info("Registering Custom Creative Mode Tab for " + TutorialMod.MOD_ID);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TUTORIAL_TAB, TUTORIAL);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TUTORIAL_TAB2, TUTORIAL2);
    }
}
