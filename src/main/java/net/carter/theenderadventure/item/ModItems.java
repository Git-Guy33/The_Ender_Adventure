package net.carter.theenderadventure.item;

import net.carter.theenderadventure.TheEnderAdventure;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ENDERITE = registerItem("enderite", new Item(new Item.Settings()));
    public static final Item RAW_ENDERITE = registerItem("raw_enderite", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
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
