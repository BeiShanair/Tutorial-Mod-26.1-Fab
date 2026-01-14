package com.besson.tutorial.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(3).saturationModifier(1.0f).build();
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3f).build();
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6f).build();
}
