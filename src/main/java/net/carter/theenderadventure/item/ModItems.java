package net.carter.theenderadventure.item;

import net.carter.theenderadventure.TheEnderAdventure;
import net.carter.theenderadventure.item.custom.MagicChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item ENDERITE = registerItem("enderite", new Item(new Item.Settings()));
    public static final Item RAW_ENDERITE = registerItem("raw_enderite", new Item(new Item.Settings()));

    public static final Item MAGIC_CHISEL = registerItem("magic_chisel", new MagicChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item VEILBERRY = registerItem("veilberry", new Item(new Item.Settings().food(ModFoodComponents.VEILBERRY)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.the-ender-adventure.veilberry.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STAR_CORE = registerItem("star_core", new Item(new Item.Settings()));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword",
            new SwordItem(ModToolMaterials.ENDERITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 6, -2.5f))));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
            new PickaxeItem(ModToolMaterials.ENDERITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 1, -3f))));
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel",
            new ShovelItem(ModToolMaterials.ENDERITE,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 1f, -3f))));
    public static final Item ENDERITE_AXE = registerItem("enderite_axe",
            new AxeItem(ModToolMaterials.ENDERITE,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 8, -2.5f))));
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe",
            new HoeItem(ModToolMaterials.ENDERITE,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 0, -3f))));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet",
            new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(7))));
    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate",
            new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings",
            new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots",
            new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

    public static final Item LOST_SMITHING_TEMPLATE = registerItem("lost_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(TheEnderAdventure.MOD_ID, "lost"), FeatureFlags.VANILLA));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheEnderAdventure.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(ENDERITE);
        entries.add(RAW_ENDERITE);
    }

    public static void registerModItems() {
        TheEnderAdventure.LOGGER.info("Registering Mod Items For " + TheEnderAdventure.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
