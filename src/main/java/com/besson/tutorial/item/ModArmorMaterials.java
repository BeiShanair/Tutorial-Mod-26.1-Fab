package com.besson.tutorial.item;

import com.besson.tutorial.TutorialMod;
import com.besson.tutorial.tag.ModItemTags;
import com.google.common.collect.Maps;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial ICE_ETHER = new ArmorMaterial(
            37, makeDefense(3, 6, 8, 3, 11), 10,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 0.0f, 0.1f, ModItemTags.ICE_ETHER_ARMOR_MATERIALS,
            createId("ice_ether"));

    static Map<ArmorType, Integer> makeDefense(final int boots, final int legs, final int chest, final int helm, final int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }

    static ResourceKey<EquipmentAsset> createId(final String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
