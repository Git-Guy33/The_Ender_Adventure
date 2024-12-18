package net.carter.theenderadventure.datagen;

import net.carter.theenderadventure.block.ModBlocks;
import net.carter.theenderadventure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERITE_END_ORE);

        BlockStateModelGenerator.BlockTexturePool purpur_bricksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PURPUR_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        purpur_bricksTexturePool.stairs(ModBlocks.PURPUR_BRICK_STAIRS);
        purpur_bricksTexturePool.slab(ModBlocks.PURPUR_BRICK_SLAB);
        purpur_bricksTexturePool.button(ModBlocks.PURPUR_BRICK_BUTTON);
        purpur_bricksTexturePool.pressurePlate(ModBlocks.PURPUR_BRICK_PRESSURE_PLATE);
        purpur_bricksTexturePool.wall(ModBlocks.PURPUR_BRICK_WALL);
        purpur_bricksTexturePool.fence(ModBlocks.PURPUR_BRICK_FENCE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ENDERITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAGIC_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEILBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.STAR_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_BOOTS));

        itemModelGenerator.register(ModItems.LOST_SMITHING_TEMPLATE, Models.GENERATED);
    }
}