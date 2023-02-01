package com.mrlocalhost.coloredblocks.utils;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static final List<String> COLOR_MAP = new ArrayList<>(){
        {
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
        }
    };
    public static final List<String> BLOCK_SUFFIXES = new ArrayList<>(){
        {
            add("_stone_bricks");
        }
    };
    public static final Map<Block, Item> DYE_MAP = new HashMap<>(){
        {
            put(ModBlocks.RED_STONE_BRICKS, Items.RED_DYE);
            put(ModBlocks.ORANGE_STONE_BRICKS,Items.ORANGE_DYE);
            put(ModBlocks.YELLOW_STONE_BRICKS,Items.YELLOW_DYE);
            put(ModBlocks.LIME_STONE_BRICKS,Items.LIME_DYE);
            put(ModBlocks.GREEN_STONE_BRICKS,Items.GREEN_DYE);
            put(ModBlocks.CYAN_STONE_BRICKS,Items.CYAN_DYE);
            put(ModBlocks.LIGHT_BLUE_STONE_BRICKS,Items.LIGHT_BLUE_DYE);
            put(ModBlocks.BLUE_STONE_BRICKS,Items.BLUE_DYE);
            put(ModBlocks.PURPLE_STONE_BRICKS,Items.PURPLE_DYE);
            put(ModBlocks.MAGENTA_STONE_BRICKS,Items.MAGENTA_DYE);
            put(ModBlocks.PINK_STONE_BRICKS,Items.PINK_DYE);
            put(ModBlocks.BROWN_STONE_BRICKS,Items.BROWN_DYE);
            put(ModBlocks.WHITE_STONE_BRICKS,Items.WHITE_DYE);
            put(ModBlocks.LIGHT_GRAY_STONE_BRICKS,Items.LIGHT_GRAY_DYE);
            put(ModBlocks.GRAY_STONE_BRICKS,Items.GRAY_DYE);
            put(ModBlocks.BLACK_STONE_BRICKS,Items.BLACK_DYE);
        }
    };
}
