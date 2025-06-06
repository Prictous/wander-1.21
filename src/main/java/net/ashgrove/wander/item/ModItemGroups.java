package net.ashgrove.wander.item;

import net.ashgrove.wander.Wander;
import net.ashgrove.wander.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup WANDER_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Wander.MOD_ID, "wander_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RAW_ROSE_QUARTZ))
                    .displayName(Text.translatable("itemgroup.wander.wander_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_ROSE_QUARTZ);
                        entries.add(ModBlocks.SOFT_GRASS_BLOCK);
                        entries.add(ModBlocks.LOAMY_DIRT_BLOCK);
                        entries.add(ModBlocks.ROSE_QUARTZ_BLOCK);
                        entries.add(ModBlocks.RAW_NETHER_ROSE_QUARTZ_ORE);
                    }).build());

    public static void registerItemGroups() {
        Wander.LOGGER.info("Registering Item Groups for " + Wander.MOD_ID);
    }
}
