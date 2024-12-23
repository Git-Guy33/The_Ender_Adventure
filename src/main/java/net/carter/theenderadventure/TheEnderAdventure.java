package net.carter.theenderadventure;

import net.carter.theenderadventure.block.ModBlocks;
import net.carter.theenderadventure.item.ModItemGroups;
import net.carter.theenderadventure.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheEnderAdventure implements ModInitializer {
	public static final String MOD_ID = "the-ender-adventure";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.STAR_CORE, 1200);
	}
}