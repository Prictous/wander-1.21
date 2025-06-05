package net.ashgrove.wander.item;

import net.ashgrove.wander.Wander;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_ROSE_QUARTZ = registerItem("raw_rose_quartz", new Item(new Item.Settings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Wander.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Wander.LOGGER.info("Registering Items for " + Wander.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_ROSE_QUARTZ);
        });
    }
}
