package net.carter.theenderadventure.block;

import net.carter.theenderadventure.TheEnderAdventure;
import net.carter.theenderadventure.block.custom.EnderLampBlock;
import net.carter.theenderadventure.block.custom.MagicBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


public class ModBlocks {
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.NETHERITE)
                    .strength(50f).requiresTool()));

    public static final Block ENDERITE_END_ORE = registerBlock("enderite_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(75f).requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(25f).requiresTool()));

    public static final Block ENDER_LAMP = registerBlock("ender_lamp",
            new EnderLampBlock(AbstractBlock.Settings.create()
                    .strength(25f).requiresTool().luminance(state -> state.get(EnderLampBlock.CLICKED) ? 15 : 0)));

    public static final Block PURPUR_BRICKS = registerBlock("purpur_bricks",
            new Block(AbstractBlock.Settings.create().strength(5f).requiresTool()));

    public static final Block PURPUR_BRICK_SLAB = registerBlock("purpur_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block PURPUR_BRICK_STAIRS = registerBlock("purpur_brick_stairs",
            new StairsBlock(ModBlocks.PURPUR_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block PURPUR_BRICK_BUTTON = registerBlock("purpur_brick_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.create().requiresTool()));
    public static final Block PURPUR_BRICK_PRESSURE_PLATE = registerBlock("purpur_brick_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool()));
    public static final Block PURPUR_BRICK_FENCE = registerBlock("purpur_brick_fence",
            new FenceBlock(AbstractBlock.Settings.create().requiresTool()));
    public static final Block PURPUR_BRICK_WALL = registerBlock("purpur_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TheEnderAdventure.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TheEnderAdventure.MOD_ID, name),
               new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TheEnderAdventure.LOGGER.info("Registering Mod Blocks For " + TheEnderAdventure.MOD_ID);
    }
}
