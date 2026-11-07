package com.besson.tutorial.villager;

import com.besson.tutorial.TutorialMod;
import com.besson.tutorial.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;

import java.util.function.Predicate;

public class ModVillagers {
    public static final ResourceKey<VillagerProfession> ICE_ETHER_MASTER = createKey("ice_ether_master");
    public static final ResourceKey<PoiType> ICE_ETHER_POI = of("ice_ether_poi");
    public static final PoiType ICE_ETHER_POI_TYPE = registerPoiType("ice_ether_poi", ModBlocks.ICE_ETHER_BLOCK);
    
    public static PoiType registerPoiType(String name, Block block) {
        return PoiHelper.register(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name), 1, 1, block);
    }
    
    private static VillagerProfession register(
            final ResourceKey<VillagerProfession> name,
            final Predicate<Holder<PoiType>> heldJobSite,
            final Predicate<Holder<PoiType>> acquirableJobSite,
            final ImmutableSet<Item> requestedItems,
            final ImmutableSet<Block> secondaryPoi,
            @Nullable final SoundEvent workSound,
            final Int2ObjectMap<ResourceKey<TradeSet>> trades
    ) {
        return Registry.register(
                BuiltInRegistries.VILLAGER_PROFESSION,
                name,
                new VillagerProfession(
                        Component.translatable("entity." + name.identifier().getNamespace() + ".villager." + name.identifier().getPath()),
                        heldJobSite,
                        acquirableJobSite,
                        requestedItems,
                        secondaryPoi,
                        workSound,
                        trades
                )
        );
    }

    private static ResourceKey<VillagerProfession> createKey(final String name) {
        return ResourceKey.create(Registries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    private static ResourceKey<PoiType> of(final String name) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
    
    public static void registerVillagers() {
        register(ICE_ETHER_MASTER, 
                p -> p.is(ICE_ETHER_POI), p -> p.is(ICE_ETHER_POI),
                ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER,
                Int2ObjectMap.ofEntries(
                        Int2ObjectMap.entry(1, ModTradeSets.ICE_ETHER_MASTER_LEVEL_1),
                        Int2ObjectMap.entry(2, ModTradeSets.ICE_ETHER_MASTER_LEVEL_2)
                ));
    }
}
