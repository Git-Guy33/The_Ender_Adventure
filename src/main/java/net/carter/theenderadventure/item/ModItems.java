package net.carter.theenderadventure.item;

import net.carter.theenderadventure.TheEnderAdventure;
import net.carter.theenderadventure.item.custom.MagicChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
