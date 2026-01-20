package com.besson.tutorial;

import com.besson.tutorial.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ChunkSectionLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ChunkSectionLayerMap.putBlock(ModBlocks.ICE_ETHER_DOOR, ChunkSectionLayer.CUTOUT);
        ChunkSectionLayerMap.putBlock(ModBlocks.ICE_ETHER_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        ChunkSectionLayerMap.putBlock(ModBlocks.STRAWBERRY_CROP, ChunkSectionLayer.CUTOUT);
        ChunkSectionLayerMap.putBlock(ModBlocks.CORN_CROP, ChunkSectionLayer.CUTOUT);
    }
}
