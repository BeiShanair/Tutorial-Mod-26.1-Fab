package com.besson.tutorial.datagen;

import com.besson.tutorial.block.ModBlocks;
import com.besson.tutorial.block.custom.CornCrop;
import com.besson.tutorial.block.custom.StrawberryCrop;
import com.besson.tutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTablesProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTablesProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.ICE_ETHER_BLOCK);
        dropSelf(ModBlocks.RAW_ICE_ETHER_BLOCK);
        add(ModBlocks.ICE_ETHER_ORE, createCopperOreLikeDrops(ModBlocks.ICE_ETHER_ORE, ModItems.RAW_ICE_ETHER));

        dropSelf(ModBlocks.ICE_ETHER_STAIRS);
        add(ModBlocks.ICE_ETHER_SLAB, createSlabItemTable(ModBlocks.ICE_ETHER_SLAB));
        dropSelf(ModBlocks.ICE_ETHER_BUTTON);
        dropSelf(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
        dropSelf(ModBlocks.ICE_ETHER_FENCE);
        dropSelf(ModBlocks.ICE_ETHER_FENCE_GATE);
        dropSelf(ModBlocks.ICE_ETHER_WALL);
        add(ModBlocks.ICE_ETHER_DOOR, createDoorTable(ModBlocks.ICE_ETHER_DOOR));
        dropSelf(ModBlocks.ICE_ETHER_TRAPDOOR);

        LootItemCondition.Builder isStrawberryMaxAge = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCrop.AGE, 5));
        add(ModBlocks.STRAWBERRY_CROP, createCropDrops(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, isStrawberryMaxAge));

        LootItemCondition.Builder isCornMaxAge = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CORN_CROP)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCrop.AGE, 8));
        add(ModBlocks.CORN_CROP, createCropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN, isCornMaxAge));
    }

    public LootTable.Builder createCopperOreLikeDrops(final Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
