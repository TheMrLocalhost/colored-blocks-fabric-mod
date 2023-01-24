package com.mrlocalhost.coloredstonebricks.item;

import com.mrlocalhost.coloredstonebricks.ColoredStoneBricks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    //public static final Item RED_STONE_BRICKS = registerItem("red_stone_bricks", new Item(new FabricItemSettings()));
    public static final Item RED_STONE_BRICKS = registerItem("red_stone_bricks", new Item(new Item.Settings()));
    //public static final Item CLEANING_CLOTH = registerItem("cleaning_cloth", new Item(new FabricItemSettings()));
    public static final Item CLEANING_CLOTH = registerItem("cleaning_cloth", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.COLORED_STONE_BRICKS_GROUP).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(ColoredStoneBricks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ColoredStoneBricks.LOGGER.debug("Registering Mod Items for " + ColoredStoneBricks.MOD_ID);
    }

}
