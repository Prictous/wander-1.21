package net.ashgrove.wander;

import net.ashgrove.wander.block.ModBlocks;
import net.ashgrove.wander.item.ModItemGroups;
import net.ashgrove.wander.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
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
		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.QUARTZ_BLOCK)
				.lightWithItem(Items.ENDER_EYE)
				.destDimID(Identifier.of("wander:test_dimension"))
				.tintColor(70,129,224)
				.registerPortal();
	}
}