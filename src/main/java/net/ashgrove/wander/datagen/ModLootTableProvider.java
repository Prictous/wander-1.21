package net.ashgrove.wander.datagen;

import net.ashgrove.wander.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
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
    }
}
