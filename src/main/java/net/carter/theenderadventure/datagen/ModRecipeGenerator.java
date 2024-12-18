package net.carter.theenderadventure.datagen;

import net.carter.theenderadventure.TheEnderAdventure;
import net.carter.theenderadventure.block.ModBlocks;
import net.carter.theenderadventure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> ENDERITE_SMELTABLES = List.of(ModItems.RAW_ENDERITE, ModBlocks.ENDERITE_END_ORE);

        offerSmelting(exporter, ENDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERITE, 0.2f, 200, "enderite");
        offerBlasting(exporter, ENDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERITE, 0.2f, 100, "enderite");
        
        offerReversibleCompactingRecipes(exporter,RecipeCategory.BUILDING_BLOCKS, ModItems.ENDERITE, RecipeCategory.DECORATIONS , ModBlocks.ENDERITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_ENDERITE)
                .pattern("SSS")
                .pattern("SES")
                .pattern("SSS")
                .input('S', Blocks.END_STONE)
                .input('E', ModItems.ENDERITE)
                .criterion(hasItem(Blocks.END_STONE), conditionsFromItem(Blocks.END_STONE))
                .criterion(hasItem(ModItems.ENDERITE), conditionsFromItem(ModItems.ENDERITE))
                .offerTo(exporter);

        offerSmithingTrimRecipe(exporter, ModItems.LOST_SMITHING_TEMPLATE, Identifier.of(TheEnderAdventure.MOD_ID, "lost"));
    }
}
