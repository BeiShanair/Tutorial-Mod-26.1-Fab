package com.besson.tutorial.villager;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;

import java.util.Optional;

public class ModTradeSets {
    public static final ResourceKey<TradeSet> ICE_ETHER_MASTER_LEVEL_1 = resourceKey("ice_ether_master/level_1");
    public static final ResourceKey<TradeSet> ICE_ETHER_MASTER_LEVEL_2 = resourceKey("ice_ether_master/level_2");

    public static void bootstrap(BootstrapContext<TradeSet> context) {
        register(context, ICE_ETHER_MASTER_LEVEL_1, ModVillagerTradeTags.ICE_ETHER_MASTER_LEVEL_1);
        register(context, ICE_ETHER_MASTER_LEVEL_2, ModVillagerTradeTags.ICE_ETHER_MASTER_LEVEL_2);
    }
    
    public static ResourceKey<TradeSet> resourceKey(final String path) {
        return ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, path));
    }

    public static Holder.Reference<TradeSet> register(
            final BootstrapContext<TradeSet> context, final ResourceKey<TradeSet> resourceKey,
            final TagKey<VillagerTrade> tradeTag
    ) {
        return register(context, resourceKey, tradeTag, ConstantValue.exactly(2.0F));
    }

    public static Holder.Reference<TradeSet> register(
            final BootstrapContext<TradeSet> context, final ResourceKey<TradeSet> resourceKey,
            final TagKey<VillagerTrade> tradeTag, final NumberProvider numberProvider
    ) {
        return context.register(
                resourceKey,
                new TradeSet(
                        context.lookup(Registries.VILLAGER_TRADE).getOrThrow(tradeTag),
                        numberProvider, false, Optional.of(resourceKey.identifier().withPrefix("trade_set/"))
                )
        );
    }
    
}
