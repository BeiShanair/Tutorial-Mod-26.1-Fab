package com.besson.tutorial.datagen;

import com.besson.tutorial.block.ModBlocks;
import com.besson.tutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final List<ItemLike> ICE_ETHER_LIST = List.of(ModItems.RAW_ICE_ETHER, ModBlocks.ICE_ETHER_ORE);

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                oreSmelting(ICE_ETHER_LIST, RecipeCategory.MISC, ModItems.ICE_ETHER, 0.7f, 200, "ice_ether");
                oreBlasting(ICE_ETHER_LIST, RecipeCategory.MISC, ModItems.ICE_ETHER, 0.7f, 100, "ice_ether");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.ICE_ETHER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_BLOCK);

                simpleCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new,
                        600, ModItems.RAW_ICE_ETHER, ModItems.ICE_ETHER, 0.35f);

                shaped(RecipeCategory.MISC, Items.SUGAR, 3)
                        .pattern("###")
                        .define('#', Items.BEETROOT)
                        .unlockedBy("has_item", has(Items.BEETROOT))
                        .save(recipeOutput);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_ORE)
                        .requires(ModItems.RAW_ICE_ETHER)
                        .requires(Items.STONE)
                        .unlockedBy("has_item", has(ModItems.RAW_ICE_ETHER))
                        .unlockedBy("has_item_stone", has(Items.STONE))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "recipe gen";
    }
}
