package net.ashgrove.wander.datagen;

import net.ashgrove.wander.block.ModBlocks;
import net.ashgrove.wander.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SOFT_GRASS_BLOCK, dropsWithSilkTouch(ModBlocks.SOFT_GRASS_BLOCK));
        addDrop(ModBlocks.LOAMY_DIRT_BLOCK);
        addDrop(ModBlocks.ROSE_QUARTZ_BLOCK);
        addDrop(ModBlocks.RAW_NETHER_ROSE_QUARTZ_ORE, oreDrops(ModBlocks.RAW_NETHER_ROSE_QUARTZ_ORE, ModItems.RAW_ROSE_QUARTZ));
    }
}
