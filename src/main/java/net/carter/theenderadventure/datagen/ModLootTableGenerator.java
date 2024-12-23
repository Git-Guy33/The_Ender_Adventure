package net.carter.theenderadventure.datagen;

import net.carter.theenderadventure.block.ModBlocks;
import net.carter.theenderadventure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ENDERITE_BLOCK);

        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.ENDER_LAMP);

        addDrop(ModBlocks.ENDERITE_END_ORE, multipleOreDrops(ModBlocks.ENDERITE_END_ORE, ModItems.RAW_ENDERITE, 3, 6));

        addDrop(ModBlocks.PURPUR_BRICKS);
        addDrop(ModBlocks.PURPUR_BRICK_STAIRS);
        addDrop(ModBlocks.PURPUR_BRICK_SLAB, slabDrops(ModBlocks.PURPUR_BRICK_SLAB));
        addDrop(ModBlocks.PURPUR_BRICK_BUTTON);
        addDrop(ModBlocks.PURPUR_BRICK_PRESSURE_PLATE);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
     RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
     return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop,((LeafEntry.Builder<?>)
             ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
             .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
