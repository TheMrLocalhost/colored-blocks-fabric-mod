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

    public static final Block RED_STONE_BRICKS = registerBlock("red_stone_bricks");
    public static final Block ORANGE_STONE_BRICKS = registerBlock("orange_stone_bricks");
    public static final Block YELLOW_STONE_BRICKS = registerBlock("yellow_stone_bricks");
    public static final Block LIME_STONE_BRICKS = registerBlock("lime_stone_bricks");

    private static Block registerBlock(String name) {
        Block block = new Block(FabricBlockSettings
                .of(Material.STONE)
                .drops(new Identifier(ColoredStoneBricks.MOD_ID, name))
                .requiresTool()
                .strength(1.5F)
                .resistance(6.0F));
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
