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

                        entries.add(ModItems.STAR_CORE);

                        entries.add(ModItems.ENDERITE_AXE);
                        entries.add(ModItems.ENDERITE_HOE);
                        entries.add(ModItems.ENDERITE_PICKAXE);
                        entries.add(ModItems.ENDERITE_SHOVEL);
                        entries.add(ModItems.ENDERITE_SWORD);

                        entries.add(ModItems.ENDERITE_HELMET);
                        entries.add(ModItems.ENDERITE_CHESTPLATE);
                        entries.add(ModItems.ENDERITE_LEGGINGS);
                        entries.add(ModItems.ENDERITE_BOOTS);

                        entries.add(ModItems.LOST_SMITHING_TEMPLATE);

                    }).build());

    public static final ItemGroup ENDERITE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheEnderAdventure.MOD_ID, "enderite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.enderite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ENDERITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ENDERITE_BLOCK);

                        entries.add(ModBlocks.PURPUR_BRICKS);
                        entries.add(ModBlocks.PURPUR_BRICK_SLAB);
                        entries.add(ModBlocks.PURPUR_BRICK_STAIRS);
                        entries.add(ModBlocks.PURPUR_BRICK_PRESSURE_PLATE);
                        entries.add(ModBlocks.PURPUR_BRICK_BUTTON);
                        entries.add(ModBlocks.PURPUR_BRICK_FENCE);
                        entries.add(ModBlocks.PURPUR_BRICK_WALL);

                        entries.add(ModBlocks.ENDERITE_END_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                        entries.add(ModBlocks.ENDER_LAMP);



                    }).build());

    public static void registerItemGroups() {
        TheEnderAdventure.LOGGER.info("Registering item Groups For " + TheEnderAdventure.MOD_ID);
    }
}
