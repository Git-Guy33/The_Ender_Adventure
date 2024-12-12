package net.carter.theenderadventure.item;

import net.carter.theenderadventure.TheEnderAdventure;
import net.carter.theenderadventure.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ENDERITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheEnderAdventure.MOD_ID, "enderite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.enderite"))
                    .icon(() -> new ItemStack(ModItems.ENDERITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ENDERITE);
                        entries.add(ModItems.RAW_ENDERITE);
                        entries.add(ModItems.VEILBERRY);
                        entries.add(ModItems.MAGIC_CHISEL);
                    }).build());

    public static final ItemGroup ENDERITE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheEnderAdventure.MOD_ID, "enderite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.enderite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ENDERITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ENDERITE_BLOCK);

                        entries.add(ModBlocks.ENDERITE_END_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                    }).build());

    public static void registerItemGroups() {
        TheEnderAdventure.LOGGER.info("Registering item Groups For " + TheEnderAdventure.MOD_ID);
    }
}
