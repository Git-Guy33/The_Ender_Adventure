package net.carter.theenderadventure.datagen;

import net.carter.theenderadventure.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ENDERITE_BLOCK,
                        ModBlocks.ENDERITE_END_ORE,
                        ModBlocks.PURPUR_BRICK_WALL,
                        ModBlocks.PURPUR_BRICKS,
                        ModBlocks.PURPUR_BRICK_BUTTON,
                        ModBlocks.PURPUR_BRICK_FENCE,
                        ModBlocks.PURPUR_BRICK_BUTTON,
                        ModBlocks.PURPUR_BRICK_STAIRS,
                        ModBlocks.PURPUR_BRICK_PRESSURE_PLATE,
                        ModBlocks.PURPUR_BRICK_SLAB,
                        ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ENDERITE_BLOCK,
                        ModBlocks.ENDERITE_END_ORE,
                        ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PURPUR_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PURPUR_BRICK_FENCE);
    }
}
