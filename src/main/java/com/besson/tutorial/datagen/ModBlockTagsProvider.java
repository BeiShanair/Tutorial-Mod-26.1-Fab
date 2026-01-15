package com.besson.tutorial.datagen;

import com.besson.tutorial.block.ModBlocks;
import com.besson.tutorial.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAW_ICE_ETHER_BLOCK)
                .add(ModBlocks.ICE_ETHER_ORE);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ICE_ETHER_ORE);

        valueLookupBuilder(ModBlockTags.ORE_TAGS)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .add(ModBlocks.ICE_ETHER_ORE);

        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.ICE_ETHER_WALL);
        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.ICE_ETHER_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ICE_ETHER_FENCE_GATE);

        valueLookupBuilder(ModBlockTags.PICKAXE_AXE_MINEABLE)
                .forceAddTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_AXE);
    }
}
