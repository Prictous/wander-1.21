package net.ashgrove.wander;

import net.ashgrove.wander.block.ModBlocks;
import net.ashgrove.wander.item.ModItemGroups;
import net.ashgrove.wander.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wander implements ModInitializer {
	public static final String MOD_ID = "wander";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}