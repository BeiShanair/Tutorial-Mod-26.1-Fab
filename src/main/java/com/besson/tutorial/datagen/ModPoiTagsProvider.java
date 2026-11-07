package com.besson.tutorial.datagen;

import com.besson.tutorial.TutorialMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.concurrent.CompletableFuture;

public class ModPoiTagsProvider extends KeyTagProvider<PoiType> {
    public ModPoiTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.POINT_OF_INTEREST_TYPE, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE,
                        Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "ice_ether_poi")));
    }
}
