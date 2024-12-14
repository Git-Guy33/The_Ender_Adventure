package net.carter.theenderadventure.block;

import net.carter.theenderadventure.TheEnderAdventure;
import net.carter.theenderadventure.block.custom.MagicBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
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

    public static final Block PURPUR_BRICKS = registerBlock("purpur_bricks",
            new Block(AbstractBlock.Settings.create().strength(5f).requiresTool()));

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
