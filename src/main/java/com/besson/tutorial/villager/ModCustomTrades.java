package com.besson.tutorial.villager;

import com.besson.tutorial.TutorialMod;
import com.besson.tutorial.item.ModItems;
import net.minecraft.advancements.criterion.DataComponentMatchers;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.predicates.DataComponentPredicates;
import net.minecraft.core.component.predicates.EnchantmentsPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.functions.DiscardItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.FilteredFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Optional;

public class ModCustomTrades {
    public static final ResourceKey<VillagerTrade> FARMER_1_EMERALD_STRAWBERRY = resourceKey("farmer/1/emerald_strawberry");
    public static final ResourceKey<VillagerTrade> FARMER_2_CORN_EMERALD = resourceKey("farmer/2/corn_emerald");
    public static final ResourceKey<VillagerTrade> TOOLSMITH_2_EMERALD_PICKAXE_AXE = resourceKey("toolsmith/2/emerald_pickaxe_axe");

    public static ResourceKey<VillagerTrade> resourceKey(final String path) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, path));
    }

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        HolderGetter<Item> items = context.lookup(Registries.ITEM);
        Optional<HolderSet<Enchantment>> enchantmentsForTradedEquipment = context.lookup(Registries.ENCHANTMENT)
                .get(EnchantmentTags.ON_TRADED_EQUIPMENT)
                .map(named -> named);
        
        register(context, FARMER_1_EMERALD_STRAWBERRY, new VillagerTrade(
                new TradeCost(Items.EMERALD, 2),
                new ItemStackTemplate(ModItems.STRAWBERRY, 15),
                16, 5, 0.5f, Optional.empty(), List.of()));
        register(context, FARMER_2_CORN_EMERALD, new VillagerTrade(
                new TradeCost(ModItems.CORN, 10),
                new ItemStackTemplate(Items.EMERALD, 5),
                16, 5, 0.5f, Optional.empty(), List.of()));
        
        register(context, TOOLSMITH_2_EMERALD_PICKAXE_AXE, new VillagerTrade(
                new TradeCost(Items.EMERALD, 10),
                new ItemStackTemplate(ModItems.PICKAXE_AXE_ITEM, 1),
                16, 5, 0.5f, Optional.empty(),
                enchantedItem(items, enchantmentsForTradedEquipment, ModItems.PICKAXE_AXE_ITEM)));
    }
    
    public static List<LootItemFunction> enchantedItem(final HolderGetter<Item> items, final Optional<HolderSet<Enchantment>> options, final Item expectedItem) {
        return List.of(
                new EnchantWithLevelsFunction.Builder(UniformGenerator.between(5.0F, 19.0F)).withOptions(options).includeAdditionalCostComponent().build(),
                FilteredFunction.filtered(
                                new ItemPredicate.Builder()
                                        .of(items, expectedItem)
                                        .withComponents(
                                                DataComponentMatchers.Builder.components()
                                                        .partial(
                                                                DataComponentPredicates.ENCHANTMENTS, EnchantmentsPredicate.enchantments(List.of(new EnchantmentPredicate(Optional.empty(), MinMaxBounds.Ints.ANY)))
                                                        )
                                                        .build()
                                        )
                                        .build()
                        )
                        .onFail(Optional.of(DiscardItem.discardItem().build()))
                        .build()
        );
    }
    
    public static Holder.Reference<VillagerTrade> register(
            final BootstrapContext<VillagerTrade> context, final ResourceKey<VillagerTrade> resourceKey, final VillagerTrade villagerTrade
    ) {
        return context.register(resourceKey, villagerTrade);
    }
}
