package com.besson.tutorial.item;

import com.besson.tutorial.TutorialMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item ICE_ETHER = registerItem("ice_ether");
    public static final Item RAW_ICE_ETHER = registerItem("raw_ice_ether");
    public static final Item CARDBOARD = registerItem("material/cardboard");

    public static final Item CORN = registerItem("corn", Item::new, new Item.Properties().food(ModFoods.CORN));
    public static final Item STRAWBERRY = registerItem("strawberry", Item::new, new Item.Properties().food(ModFoods.STRAWBERRY, ModConsumables.STRAWBERRY));
    public static final Item CHEESE = registerItem("cheese", Item::new, new Item.Properties().food(ModFoods.CHEESE, ModConsumables.CHEESE));

    public static final Item ANTHRACITE = registerItem("anthracite");

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
        Item item = (Item)itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(name, itemFactory, new Item.Properties());
    }

    private static Item registerItem(final String name) {
        return registerItem(name, Item::new, new Item.Properties());
    }

    public static void register() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(fabricCreativeModeTabOutput -> {
                    fabricCreativeModeTabOutput.accept(ICE_ETHER);
                    fabricCreativeModeTabOutput.accept(RAW_ICE_ETHER);
                    fabricCreativeModeTabOutput.accept(CARDBOARD);
                });
    }
}
