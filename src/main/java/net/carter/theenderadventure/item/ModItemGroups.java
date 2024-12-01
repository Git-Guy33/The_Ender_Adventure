package net.carter.theenderadventure.item;

import net.carter.theenderadventure.TheEnderAdventure;
import net.carter.theenderadventure.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup THE_ENDER_ADVENTURE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheEnderAdventure.MOD_ID, "enderite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.enderite"))
                    .icon(() -> new ItemStack(ModItems.ENDERITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ENDERITE);
                        entries.add(ModItems.RAW_ENDERITE);

                    }).build());

    public static final ItemGroup THE_ENDER_ADVENTURE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheEnderAdventure.MOD_ID, "enderite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.enderite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ENDERITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ENDERITE_BLOCK);


                    }).build());

    public static void registerItemGroups() {
        TheEnderAdventure.LOGGER.info("Registering Item Groups For " + TheEnderAdventure.MOD_ID);
    }
}
