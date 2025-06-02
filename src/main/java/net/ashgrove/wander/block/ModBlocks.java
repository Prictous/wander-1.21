package net.ashgrove.wander.block;

import net.ashgrove.wander.Wander;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {


    public static final Block SOFT_GRASS_BLOCK = registerBlock("soft_grass_block",
          new GrassBlock(AbstractBlock.Settings.create()
                  .mapColor(MapColor.TERRACOTTA_GREEN)
                  .ticksRandomly()
                  .strength(0.5f)
                  .requiresTool()
                  .sounds(BlockSoundGroup.GRASS)
                  ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Wander.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Wander.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Wander.LOGGER.info("Registering Mod Blocks for " + Wander.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(SOFT_GRASS_BLOCK);
        });
    }
}
