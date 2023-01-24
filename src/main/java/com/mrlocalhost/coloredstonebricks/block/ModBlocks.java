package com.mrlocalhost.coloredstonebricks.block;

import com.mrlocalhost.coloredstonebricks.ColoredStoneBricks;
import com.mrlocalhost.coloredstonebricks.item.ModItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RED_STONE_BRICKS = registerBlock("red_stone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredStoneBricks.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.COLORED_STONE_BRICKS_GROUP).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(ColoredStoneBricks.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ColoredStoneBricks.LOGGER.debug("Registering ModBlocks for " + ColoredStoneBricks.MOD_ID);
    }

}
