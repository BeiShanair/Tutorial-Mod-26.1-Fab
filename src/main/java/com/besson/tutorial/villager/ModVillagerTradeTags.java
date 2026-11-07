package com.besson.tutorial.villager;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.VillagerTrade;

public class ModVillagerTradeTags {
    public static final TagKey<VillagerTrade> ICE_ETHER_MASTER_LEVEL_1 = create("ice_ether_master/level_1");
    public static final TagKey<VillagerTrade> ICE_ETHER_MASTER_LEVEL_2 = create("ice_ether_master/level_2");
    private static TagKey<VillagerTrade> create(final String name) {
        return TagKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
