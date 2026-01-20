package com.besson.tutorial.datagen;

import com.besson.tutorial.block.ModBlocks;
import com.besson.tutorial.block.custom.CornCrop;
import com.besson.tutorial.block.custom.StrawberryCrop;
import com.besson.tutorial.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
//        blockModelGenerators.createTrivialCube(ModBlocks.ICE_ETHER_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.RAW_ICE_ETHER_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.ICE_ETHER_ORE);

        blockModelGenerators.family(ModBlocks.ICE_ETHER_BLOCK)
                .stairs(ModBlocks.ICE_ETHER_STAIRS)
                .slab(ModBlocks.ICE_ETHER_SLAB)
                .button(ModBlocks.ICE_ETHER_BUTTON)
                .pressurePlate(ModBlocks.ICE_ETHER_PRESSURE_PLATE)
                .fence(ModBlocks.ICE_ETHER_FENCE)
                .fenceGate(ModBlocks.ICE_ETHER_FENCE_GATE)
                .wall(ModBlocks.ICE_ETHER_WALL);
        blockModelGenerators.createDoor(ModBlocks.ICE_ETHER_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.ICE_ETHER_TRAPDOOR);

        blockModelGenerators.createCropBlock(ModBlocks.STRAWBERRY_CROP, StrawberryCrop.AGE, 0, 1, 2, 3, 4, 5);

        blockModelGenerators.blockStateOutput
                .accept(MultiVariantGenerator.dispatch(ModBlocks.CORN_CROP)
                                .with(PropertyDispatch.initial(CornCrop.AGE)
                                                .generate(age -> BlockModelGenerators.plainVariant(
                                                        blockModelGenerators.createSuffixedVariant(
                                                                ModBlocks.CORN_CROP, "_stage" + age,
                                                                ModelTemplates.CROSS, TextureMapping::cross)))
                                )
                );
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.ICE_ETHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_ICE_ETHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CARDBOARD, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.CORN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STRAWBERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CHEESE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ANTHRACITE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.PROSPECTOR, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.FIRE_ETHER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FIRE_ETHER_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FIRE_ETHER_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FIRE_ETHER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FIRE_ETHER_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FIRE_ETHER_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.PICKAXE_AXE_ITEM, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PICKAXE_AXE_ITEM2, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.ICE_ETHER_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ICE_ETHER_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ICE_ETHER_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ICE_ETHER_BOOTS, ModelTemplates.FLAT_ITEM);
    }
}
