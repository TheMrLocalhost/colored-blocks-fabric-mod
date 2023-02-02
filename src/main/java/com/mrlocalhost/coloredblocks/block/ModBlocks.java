package com.mrlocalhost.coloredblocks.block;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import com.mrlocalhost.coloredblocks.item.ModItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModBlocks {
    private static Block registerBlock(String name) {
        Block block = new ColoredBlock(FabricBlockSettings
                .of(Material.STONE)
                .drops(new Identifier(ColoredBlocks.MOD_ID, name))
                .requiresTool()
                .strength(1.5F)
                .resistance(6.0F));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredBlocks.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.COLORED_BLOCKS_GROUP).register(entries -> entries.add(block));
        Registry.register(Registries.ITEM, new Identifier(ColoredBlocks.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        ColoredBlocks.LOGGER.debug("Registering ModBlocks for " + ColoredBlocks.MOD_ID);
    }
    public static final Block RED_STONE_BRICKS = registerBlock("red_stone_bricks");
    public static final Block ORANGE_STONE_BRICKS = registerBlock("orange_stone_bricks");
    public static final Block YELLOW_STONE_BRICKS = registerBlock("yellow_stone_bricks");
    public static final Block LIME_STONE_BRICKS = registerBlock("lime_stone_bricks");
    public static final Block GREEN_STONE_BRICKS = registerBlock("green_stone_bricks");
    public static final Block CYAN_STONE_BRICKS = registerBlock("cyan_stone_bricks");
    public static final Block LIGHT_BLUE_STONE_BRICKS = registerBlock("light_blue_stone_bricks");
    public static final Block BLUE_STONE_BRICKS = registerBlock("blue_stone_bricks");
    public static final Block PURPLE_STONE_BRICKS = registerBlock("purple_stone_bricks");
    public static final Block MAGENTA_STONE_BRICKS = registerBlock("magenta_stone_bricks");
    public static final Block PINK_STONE_BRICKS = registerBlock("pink_stone_bricks");
    public static final Block BROWN_STONE_BRICKS = registerBlock("brown_stone_bricks");
    public static final Block WHITE_STONE_BRICKS = registerBlock("white_stone_bricks");
    public static final Block LIGHT_GRAY_STONE_BRICKS = registerBlock("light_gray_stone_bricks");
    public static final Block GRAY_STONE_BRICKS = registerBlock("gray_stone_bricks");
    public static final Block BLACK_STONE_BRICKS = registerBlock("black_stone_bricks");

    public static final Block RED_WOOD_PLANKS = registerBlock("red_wood_planks");
    public static final Block ORANGE_WOOD_PLANKS = registerBlock("orange_wood_planks");
    public static final Block YELLOW_WOOD_PLANKS = registerBlock("yellow_wood_planks");
    public static final Block LIME_WOOD_PLANKS = registerBlock("lime_wood_planks");
    public static final Block GREEN_WOOD_PLANKS = registerBlock("green_wood_planks");
    public static final Block CYAN_WOOD_PLANKS = registerBlock("cyan_wood_planks");
    public static final Block LIGHT_BLUE_WOOD_PLANKS = registerBlock("light_blue_wood_planks");
    public static final Block BLUE_WOOD_PLANKS = registerBlock("blue_wood_planks");
    public static final Block PURPLE_WOOD_PLANKS = registerBlock("purple_wood_planks");
    public static final Block MAGENTA_WOOD_PLANKS = registerBlock("magenta_wood_planks");
    public static final Block PINK_WOOD_PLANKS = registerBlock("pink_wood_planks");
    public static final Block BROWN_WOOD_PLANKS = registerBlock("brown_wood_planks");
    public static final Block WHITE_WOOD_PLANKS = registerBlock("white_wood_planks");
    public static final Block LIGHT_GRAY_WOOD_PLANKS = registerBlock("light_gray_wood_planks");
    public static final Block GRAY_WOOD_PLANKS = registerBlock("gray_wood_planks");
    public static final Block BLACK_WOOD_PLANKS = registerBlock("black_wood_planks");
}
