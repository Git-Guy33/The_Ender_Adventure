package net.carter.theenderadventure.item;

import net.carter.theenderadventure.TheEnderAdventure;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> ENDERITE_ARMOR_MATERIAL = registerArmorMaterial("enderite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), typeIntegerEnumMap -> {
                        typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 4);
                        typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 8);
                        typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 10);
                        typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 4);
                        typeIntegerEnumMap.put(ArmorItem.Type.BODY, 12);
                    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ENDERITE),
                    List.of(new ArmorMaterial.Layer(Identifier.of(TheEnderAdventure.MOD_ID, "enderite"))), 0, 0));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(TheEnderAdventure.MOD_ID, name), material.get());
    }
}
