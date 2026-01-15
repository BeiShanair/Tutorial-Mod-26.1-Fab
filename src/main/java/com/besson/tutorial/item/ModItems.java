package com.besson.tutorial.item;

import com.besson.tutorial.TutorialMod;
import com.besson.tutorial.item.custom.PickaxeAxeItem;
import com.besson.tutorial.item.custom.ProspectorItem;
import com.besson.tutorial.tag.ModBlockTags;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {
    public static final Item ICE_ETHER = registerItem("ice_ether");
    public static final Item RAW_ICE_ETHER = registerItem("raw_ice_ether");
    public static final Item CARDBOARD = registerItem("material/cardboard");

    public static final Item CORN = registerItem("corn", Item::new, new Item.Properties().food(ModFoods.CORN));
    public static final Item STRAWBERRY = registerItem("strawberry", Item::new, new Item.Properties().food(ModFoods.STRAWBERRY, ModConsumables.STRAWBERRY));
    public static final Item CHEESE = registerItem("cheese", Item::new, new Item.Properties().food(ModFoods.CHEESE, ModConsumables.CHEESE));

    public static final Item ANTHRACITE = registerItem("anthracite");

    public static final Item PROSPECTOR = registerItem("prospector", ProspectorItem::new, new Item.Properties().durability(127));

    public static final Item FIRE_ETHER = registerItem("fire_ether");
    public static final Item FIRE_ETHER_SWORD = registerItem("fire_ether_sword", Item::new,
            new Item.Properties().sword(ModToolMaterials.FIRE_ETHER, 3, -2.4F));
    public static final Item FIRE_ETHER_SHOVEL = registerItem("fire_ether_shovel",
            p -> new ShovelItem(ModToolMaterials.FIRE_ETHER, 1.5F, -3.0F, p));
    public static final Item FIRE_ETHER_AXE = registerItem("fire_ether_axe",
            p -> new AxeItem(ModToolMaterials.FIRE_ETHER, 5.0F, -3.0F, p));
    public static final Item FIRE_ETHER_PICKAXE = registerItem("fire_ether_pickaxe", Item::new,
            new Item.Properties().pickaxe(ModToolMaterials.FIRE_ETHER, 1.0F, -2.8F));
    public static final Item FIRE_ETHER_HOE = registerItem("fire_ether_hoe",
            p -> new HoeItem(ModToolMaterials.FIRE_ETHER, -2, 0.0F, p));

    public static final Item PICKAXE_AXE_ITEM = registerItem("pickaxe_axe_item", Item::new,
            new Item.Properties().tool(ModToolMaterials.FIRE_ETHER, ModBlockTags.PICKAXE_AXE_MINEABLE, 5.0f, -2.4f, 0.0f));
    public static final Item PICKAXE_AXE_ITEM2 = registerItem("pickaxe_axe_item2",
            p -> new PickaxeAxeItem(ModToolMaterials.FIRE_ETHER, 5.0F, -2.4F, p));

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
