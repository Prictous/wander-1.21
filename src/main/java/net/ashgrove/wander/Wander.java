package net.ashgrove.wander;

import net.ashgrove.wander.block.ModBlocks;
import net.ashgrove.wander.item.ModItemGroups;
import net.ashgrove.wander.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wander implements ModInitializer {
	public static final String MOD_ID = "wander";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<PlacedFeature> CUSTOM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("wander","raw_nether_rose_quartz_ore"));

	@Override
	public void onInitialize() {
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, CUSTOM_ORE_PLACED_KEY);
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.ROSE_QUARTZ_BLOCK)
				.lightWithItem(Items.ENDER_EYE)
				.destDimID(Identifier.of("wander:test_dimension"))
				.tintColor(70,129,224)
				.registerPortal();

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if(!world.isClient()){
				BlockState state = world.getBlockState(hitResult.getBlockPos());
            	/* Manual spectator check is necessary because AttackBlockCallbacks
                fire before the spectator check */
				if (state.isToolRequired() && !player.isSpectator() &&
						player.getStackInHand(hand).isOf(ModItems.RAW_ROSE_QUARTZ)) {
					if(state.getBlock() == Blocks.QUARTZ_BLOCK){
						Wander.LOGGER.info("test");
						world.setBlockState(hitResult.getBlockPos(), ModBlocks.ROSE_QUARTZ_BLOCK.getDefaultState());

						player.getStackInHand(hand).decrement(1);
					}
				}
			}

			return ActionResult.PASS;
		});
	}
}