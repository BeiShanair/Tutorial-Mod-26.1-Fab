package com.besson.tutorial.item.custom;

import com.besson.tutorial.tag.ModBlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.state.BlockState;

public class PickaxeAxeItem extends AxeItem {
    public PickaxeAxeItem(ToolMaterial material, float attackDamageBaseline, float attackSpeedBaseline, Properties properties) {
        super(material, attackDamageBaseline, attackSpeedBaseline, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, BlockState state) {
        return state.is(ModBlockTags.PICKAXE_AXE_MINEABLE) ? 12.0f : 1.0f;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack itemStack, BlockState state) {
        return state.is(ModBlockTags.PICKAXE_AXE_MINEABLE);
    }
}
