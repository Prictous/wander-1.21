package net.ashgrove.wander.block;

import com.mojang.serialization.MapCodec;
import net.ashgrove.wander.Wander;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ModBlocks {


    public static final Block SOFT_GRASS_BLOCK = registerBlock("soft_grass_block",
            new ModSpreadableBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_GREEN)
                    .ticksRandomly()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.GRASS)
            ) {
                @Override
                protected MapCodec<? extends SpreadableBlock> getCodec() {
                    return null;
                }
            });
    public static final Block LOAMY_DIRT_BLOCK = registerBlock("loamy_dirt_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BROWN)
                    .strength(0.4f)
                    .sounds(BlockSoundGroup.GRAVEL)
            ));
    public static final Block ROSE_QUARTZ_BLOCK = registerBlock("rose_quartz_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PINK)
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.STONE)
            ));
    public static final Block RAW_NETHER_ROSE_QUARTZ_ORE = registerBlock("raw_nether_rose_quartz_ore",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PINK)
                    .strength(0.3f)
                    .sounds(BlockSoundGroup.STONE)
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
