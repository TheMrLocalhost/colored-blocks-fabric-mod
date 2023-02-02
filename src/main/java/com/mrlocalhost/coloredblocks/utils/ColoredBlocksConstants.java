package com.mrlocalhost.coloredblocks.utils;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import java.util.ArrayList;
import java.util.List;

public class ColoredBlocksConstants {
    public static final int DYE_REPAIR_VALUE = 8;
    public static final  int MAX_PALETTE_DAMAGE = 512;
    public static final int MIN_COLOR_VALUE = 0;
    public static final int MAX_COLOR_VALUE = 15;
    public static final String[] COLOR_NAMES = new String[]{
        "Red","Orange","Yellow","Lime",
        "Green","Cyan","Light Blue","Blue",
        "Purple","Magenta","Pink","Brown",
        "White","Light Gray","Gray","Black"
    };
    public static final Block[] COLORED_STONE_BRICKS = new Block[]{
        ModBlocks.RED_STONE_BRICKS,
        ModBlocks.ORANGE_STONE_BRICKS,
        ModBlocks.YELLOW_STONE_BRICKS,
        ModBlocks.LIME_STONE_BRICKS,
        ModBlocks.GREEN_STONE_BRICKS,
        ModBlocks.CYAN_STONE_BRICKS,
        ModBlocks.LIGHT_BLUE_STONE_BRICKS,
        ModBlocks.BLUE_STONE_BRICKS,
        ModBlocks.PURPLE_STONE_BRICKS,
        ModBlocks.MAGENTA_STONE_BRICKS,
        ModBlocks.PINK_STONE_BRICKS,
        ModBlocks.BROWN_STONE_BRICKS,
        ModBlocks.WHITE_STONE_BRICKS,
        ModBlocks.LIGHT_GRAY_STONE_BRICKS,
        ModBlocks.GRAY_STONE_BRICKS,
        ModBlocks.BLACK_STONE_BRICKS
    };
    public static final Block[] COLORED_WOOD_PLANKS = new Block[]{
        ModBlocks.RED_WOOD_PLANKS,
        ModBlocks.ORANGE_WOOD_PLANKS,
        ModBlocks.YELLOW_WOOD_PLANKS,
        ModBlocks.LIME_WOOD_PLANKS,
        ModBlocks.GREEN_WOOD_PLANKS,
        ModBlocks.CYAN_WOOD_PLANKS,
        ModBlocks.LIGHT_BLUE_WOOD_PLANKS,
        ModBlocks.BLUE_WOOD_PLANKS,
        ModBlocks.PURPLE_WOOD_PLANKS,
        ModBlocks.MAGENTA_WOOD_PLANKS,
        ModBlocks.PINK_WOOD_PLANKS,
        ModBlocks.BROWN_WOOD_PLANKS,
        ModBlocks.WHITE_WOOD_PLANKS,
        ModBlocks.LIGHT_GRAY_WOOD_PLANKS,
        ModBlocks.GRAY_WOOD_PLANKS,
        ModBlocks.BLACK_WOOD_PLANKS
    };
    public static final Block[] COLORED_WOOL_BLOCKS = new Block[]{
        Blocks.RED_WOOL,
        Blocks.ORANGE_WOOL,
        Blocks.YELLOW_WOOL,
        Blocks.LIME_WOOL,
        Blocks.GREEN_WOOL,
        Blocks.CYAN_WOOL,
        Blocks.LIGHT_BLUE_WOOL,
        Blocks.BLUE_WOOL,
        Blocks.PURPLE_WOOL,
        Blocks.MAGENTA_WOOL,
        Blocks.PINK_WOOL,
        Blocks.BROWN_WOOL,
        Blocks.WHITE_WOOL,
        Blocks.LIGHT_GRAY_WOOL,
        Blocks.GRAY_WOOL,
        Blocks.BLACK_WOOL,
    };
    public static final List<String> COLOR_MAP = new ArrayList<>(){{
        add("red");
        add("orange");
        add("yellow");
        add("lime");
        add("green");
        add("cyan");
        add("light_blue");
        add("blue");
        add("purple");
        add("magenta");
        add("pink");
        add("brown");
        add("white");
        add("light_gray");
        add("gray");
        add("black");
    }};
    public static final List<String> BLOCK_SUFFIXES = new ArrayList<>(){{
        add("_stone_bricks");
        add("_wood_planks");
        add("_wool");
    }};
    public static final List<Block> COLORABLE_BLOCKS = new ArrayList<>(){{
        for (int i = 0; i<16; i++) {
            add(COLORED_STONE_BRICKS[i]);
            add(COLORED_WOOD_PLANKS[i]);
            add(COLORED_WOOL_BLOCKS[i]);
        }
    }};
    public static final Item[] DYE_ITEMS = new Item[]{
        Items.RED_DYE,
        Items.ORANGE_DYE,
        Items.YELLOW_DYE,
        Items.LIME_DYE,
        Items.GREEN_DYE,
        Items.CYAN_DYE,
        Items.LIGHT_BLUE_DYE,
        Items.BLUE_DYE,
        Items.PURPLE_DYE,
        Items.MAGENTA_DYE,
        Items.PINK_DYE,
        Items.BROWN_DYE,
        Items.WHITE_DYE,
        Items.LIGHT_GRAY_DYE,
        Items.GRAY_DYE,
        Items.BLACK_DYE,
    };
}
