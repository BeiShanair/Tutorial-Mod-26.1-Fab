package com.besson.tutorial.datagen;

import com.besson.tutorial.villager.ModCustomTrades;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.concurrent.CompletableFuture;

public class ModVillagerTradeTagsProvider extends KeyTagProvider<VillagerTrade> {
    public ModVillagerTradeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.VILLAGER_TRADE, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(VillagerTradeTags.FARMER_LEVEL_1)
                .add(ModCustomTrades.FARMER_1_EMERALD_STRAWBERRY);
        tag(VillagerTradeTags.FARMER_LEVEL_2)
                .add(ModCustomTrades.FARMER_2_CORN_EMERALD);
        tag(VillagerTradeTags.TOOLSMITH_LEVEL_2)
                .add(ModCustomTrades.TOOLSMITH_2_EMERALD_PICKAXE_AXE);
    }
}
