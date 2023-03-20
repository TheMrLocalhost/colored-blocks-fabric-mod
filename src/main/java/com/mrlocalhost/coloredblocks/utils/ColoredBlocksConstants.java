package com.mrlocalhost.coloredblocks.utils;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils.*;

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
    public static final int[] HEX_COLOR_VALUES = new int[]{
            0xAA0D0D, //Red
            0xFF7519, //Orange
            0xFFCC2F, //Yellow
            0x80FF00, //Lime
            0x547F00, //Green
            0x0D8282, //Cyan
            0x89C1FF, //Light Blue
            0x2639AF, //Blue
            0x7D00B7, //Purple
            0xBF3BB8, //Magenta
            0xFF99CA, //Pink
            0x7C5235, //Brown
            0xFFFFFF, //White
            0xA8ADAD, //Light Gray
            0x4B5050, //Gray
            0x161616, //Black
    };
    public enum RGB_SHADER_VALUES {
        RED(0, stripRedFloatFromHex(0), stripGreenFloatFromHex(0), stripBlueFloatFromHex(0)),
        ORANGE(1, stripRedFloatFromHex(1), stripGreenFloatFromHex(1), stripBlueFloatFromHex(1)),
        YELLOW(2, stripRedFloatFromHex(2), stripGreenFloatFromHex(2), stripBlueFloatFromHex(2)),
        LIME(3, stripRedFloatFromHex(3), stripGreenFloatFromHex(3), stripBlueFloatFromHex(3)),
        GREEN(4, stripRedFloatFromHex(4), stripGreenFloatFromHex(4), stripBlueFloatFromHex(4)),
        CYAN(5, stripRedFloatFromHex(5), stripGreenFloatFromHex(5), stripBlueFloatFromHex(5)),
        LIGHT_BLUE(6, stripRedFloatFromHex(6), stripGreenFloatFromHex(6), stripBlueFloatFromHex(6)),
        BLUE(7, stripRedFloatFromHex(7), stripGreenFloatFromHex(7), stripBlueFloatFromHex(7)),
        PURPLE(8, stripRedFloatFromHex(8), stripGreenFloatFromHex(8), stripBlueFloatFromHex(8)),
        MAGENTA(9, stripRedFloatFromHex(9), stripGreenFloatFromHex(9), stripBlueFloatFromHex(9)),
        PINK(10, stripRedFloatFromHex(10), stripGreenFloatFromHex(10), stripBlueFloatFromHex(10)),
        BROWN(11, stripRedFloatFromHex(11), stripGreenFloatFromHex(11), stripBlueFloatFromHex(11)),
        WHITE(12, stripRedFloatFromHex(12), stripGreenFloatFromHex(12), stripBlueFloatFromHex(12)),
        LIGHT_GRAY(13, stripRedFloatFromHex(13), stripGreenFloatFromHex(13), stripBlueFloatFromHex(13)),
        GRAY(14, stripRedFloatFromHex(14), stripGreenFloatFromHex(14), stripBlueFloatFromHex(14)),
        BLACK(15, stripRedFloatFromHex(15), stripGreenFloatFromHex(15), stripBlueFloatFromHex(15));
        private final float r, g, b;
        RGB_SHADER_VALUES(int index, float r, float g, float b) {
            this.r=r;this.g=g;this.b=b;}
        public float r() { return this.r;}
        public float g() { return this.g;}
        public float b() { return this.b;}
        private static final List<RGB_SHADER_VALUES> BY_VALUE = Arrays.stream(values()).toList();
        public static RGB_SHADER_VALUES byIndex(int index) {
            return BY_VALUE.get(index);
        }
    }
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
        Blocks.BLACK_WOOL
    };
    public static final Block[] COLORED_TERRACOTTA = new Block[]{
        Blocks.RED_TERRACOTTA,
        Blocks.ORANGE_TERRACOTTA,
        Blocks.YELLOW_TERRACOTTA,
        Blocks.LIME_TERRACOTTA,
        Blocks.GREEN_TERRACOTTA,
        Blocks.CYAN_TERRACOTTA,
        Blocks.LIGHT_BLUE_TERRACOTTA,
        Blocks.BLUE_TERRACOTTA,
        Blocks.PURPLE_TERRACOTTA,
        Blocks.MAGENTA_TERRACOTTA,
        Blocks.PINK_TERRACOTTA,
        Blocks.BROWN_TERRACOTTA,
        Blocks.WHITE_TERRACOTTA,
        Blocks.LIGHT_GRAY_TERRACOTTA,
        Blocks.GRAY_TERRACOTTA,
        Blocks.BLACK_TERRACOTTA
    };
    public static final Block[] COLORED_GLAZED_TERRACOTTA = new Block[]{
        Blocks.RED_GLAZED_TERRACOTTA,
        Blocks.ORANGE_GLAZED_TERRACOTTA,
        Blocks.YELLOW_GLAZED_TERRACOTTA,
        Blocks.LIME_GLAZED_TERRACOTTA,
        Blocks.GREEN_GLAZED_TERRACOTTA,
        Blocks.CYAN_GLAZED_TERRACOTTA,
        Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA,
        Blocks.BLUE_GLAZED_TERRACOTTA,
        Blocks.PURPLE_GLAZED_TERRACOTTA,
        Blocks.MAGENTA_GLAZED_TERRACOTTA,
        Blocks.PINK_GLAZED_TERRACOTTA,
        Blocks.BROWN_GLAZED_TERRACOTTA,
        Blocks.WHITE_GLAZED_TERRACOTTA,
        Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
        Blocks.GRAY_GLAZED_TERRACOTTA,
        Blocks.BLACK_GLAZED_TERRACOTTA
    };
    public static final Block[] COLORED_CONCRETE = new Block[]{
        Blocks.RED_CONCRETE,
        Blocks.ORANGE_CONCRETE,
        Blocks.YELLOW_CONCRETE,
        Blocks.LIME_CONCRETE,
        Blocks.GREEN_CONCRETE,
        Blocks.CYAN_CONCRETE,
        Blocks.LIGHT_BLUE_CONCRETE,
        Blocks.BLUE_CONCRETE,
        Blocks.PURPLE_CONCRETE,
        Blocks.MAGENTA_CONCRETE,
        Blocks.PINK_CONCRETE,
        Blocks.BROWN_CONCRETE,
        Blocks.WHITE_CONCRETE,
        Blocks.LIGHT_GRAY_CONCRETE,
        Blocks.GRAY_CONCRETE,
        Blocks.BLACK_CONCRETE
    };
    public static final Block[] COLORED_STAINED_GLASS = new Block[]{
        Blocks.RED_STAINED_GLASS,
        Blocks.ORANGE_STAINED_GLASS,
        Blocks.YELLOW_STAINED_GLASS,
        Blocks.LIME_STAINED_GLASS,
        Blocks.GREEN_STAINED_GLASS,
        Blocks.CYAN_STAINED_GLASS,
        Blocks.LIGHT_BLUE_STAINED_GLASS,
        Blocks.BLUE_STAINED_GLASS,
        Blocks.PURPLE_STAINED_GLASS,
        Blocks.MAGENTA_STAINED_GLASS,
        Blocks.PINK_STAINED_GLASS,
        Blocks.BROWN_STAINED_GLASS,
        Blocks.WHITE_STAINED_GLASS,
        Blocks.LIGHT_GRAY_STAINED_GLASS,
        Blocks.GRAY_STAINED_GLASS,
        Blocks.BLACK_STAINED_GLASS
    };
    public static final Block[] COLORED_CARPET = new Block[]{
        Blocks.RED_CARPET,
        Blocks.ORANGE_CARPET,
        Blocks.YELLOW_CARPET,
        Blocks.LIME_CARPET,
        Blocks.GREEN_CARPET,
        Blocks.CYAN_CARPET,
        Blocks.LIGHT_BLUE_CARPET,
        Blocks.BLUE_CARPET,
        Blocks.PURPLE_CARPET,
        Blocks.MAGENTA_CARPET,
        Blocks.PINK_CARPET,
        Blocks.BROWN_CARPET,
        Blocks.WHITE_CARPET,
        Blocks.LIGHT_GRAY_CARPET,
        Blocks.GRAY_CARPET,
        Blocks.BLACK_CARPET
    };
    public static final Block[] COLORED_STONE_BRICK_STAIRS = new Block[]{
        ModBlocks.RED_STONE_BRICK_STAIRS,
        ModBlocks.ORANGE_STONE_BRICK_STAIRS,
        ModBlocks.YELLOW_STONE_BRICK_STAIRS,
        ModBlocks.LIME_STONE_BRICK_STAIRS,
        ModBlocks.GREEN_STONE_BRICK_STAIRS,
        ModBlocks.CYAN_STONE_BRICK_STAIRS,
        ModBlocks.LIGHT_BLUE_STONE_BRICK_STAIRS,
        ModBlocks.BLUE_STONE_BRICK_STAIRS,
        ModBlocks.PURPLE_STONE_BRICK_STAIRS,
        ModBlocks.MAGENTA_STONE_BRICK_STAIRS,
        ModBlocks.PINK_STONE_BRICK_STAIRS,
        ModBlocks.BROWN_STONE_BRICK_STAIRS,
        ModBlocks.WHITE_STONE_BRICK_STAIRS,
        ModBlocks.LIGHT_GRAY_STONE_BRICK_STAIRS,
        ModBlocks.GRAY_STONE_BRICK_STAIRS,
        ModBlocks.BLACK_STONE_BRICK_STAIRS
    };
    public static final Block[] COLORED_WOOD_PLANK_STAIRS = new Block[]{
        ModBlocks.RED_WOOD_PLANK_STAIRS,
        ModBlocks.ORANGE_WOOD_PLANK_STAIRS,
        ModBlocks.YELLOW_WOOD_PLANK_STAIRS,
        ModBlocks.LIME_WOOD_PLANK_STAIRS,
        ModBlocks.GREEN_WOOD_PLANK_STAIRS,
        ModBlocks.CYAN_WOOD_PLANK_STAIRS,
        ModBlocks.LIGHT_BLUE_WOOD_PLANK_STAIRS,
        ModBlocks.BLUE_WOOD_PLANK_STAIRS,
        ModBlocks.PURPLE_WOOD_PLANK_STAIRS,
        ModBlocks.MAGENTA_WOOD_PLANK_STAIRS,
        ModBlocks.PINK_WOOD_PLANK_STAIRS,
        ModBlocks.BROWN_WOOD_PLANK_STAIRS,
        ModBlocks.WHITE_WOOD_PLANK_STAIRS,
        ModBlocks.LIGHT_GRAY_WOOD_PLANK_STAIRS,
        ModBlocks.GRAY_WOOD_PLANK_STAIRS,
        ModBlocks.BLACK_WOOD_PLANK_STAIRS
    };
    public static final Block[] COLORED_STONE_BRICK_SLAB = new Block[]{
        ModBlocks.RED_STONE_BRICK_SLAB,
        ModBlocks.ORANGE_STONE_BRICK_SLAB,
        ModBlocks.YELLOW_STONE_BRICK_SLAB,
        ModBlocks.LIME_STONE_BRICK_SLAB,
        ModBlocks.GREEN_STONE_BRICK_SLAB,
        ModBlocks.CYAN_STONE_BRICK_SLAB,
        ModBlocks.LIGHT_BLUE_STONE_BRICK_SLAB,
        ModBlocks.BLUE_STONE_BRICK_SLAB,
        ModBlocks.PURPLE_STONE_BRICK_SLAB,
        ModBlocks.MAGENTA_STONE_BRICK_SLAB,
        ModBlocks.PINK_STONE_BRICK_SLAB,
        ModBlocks.BROWN_STONE_BRICK_SLAB,
        ModBlocks.WHITE_STONE_BRICK_SLAB,
        ModBlocks.LIGHT_GRAY_STONE_BRICK_SLAB,
        ModBlocks.GRAY_STONE_BRICK_SLAB,
        ModBlocks.BLACK_STONE_BRICK_SLAB
    };
    public static final Block[] COLORED_WOOD_PLANK_SLAB = new Block[]{
        ModBlocks.RED_WOOD_PLANK_SLAB,
        ModBlocks.ORANGE_WOOD_PLANK_SLAB,
        ModBlocks.YELLOW_WOOD_PLANK_SLAB,
        ModBlocks.LIME_WOOD_PLANK_SLAB,
        ModBlocks.GREEN_WOOD_PLANK_SLAB,
        ModBlocks.CYAN_WOOD_PLANK_SLAB,
        ModBlocks.LIGHT_BLUE_WOOD_PLANK_SLAB,
        ModBlocks.BLUE_WOOD_PLANK_SLAB,
        ModBlocks.PURPLE_WOOD_PLANK_SLAB,
        ModBlocks.MAGENTA_WOOD_PLANK_SLAB,
        ModBlocks.PINK_WOOD_PLANK_SLAB,
        ModBlocks.BROWN_WOOD_PLANK_SLAB,
        ModBlocks.WHITE_WOOD_PLANK_SLAB,
        ModBlocks.LIGHT_GRAY_WOOD_PLANK_SLAB,
        ModBlocks.GRAY_WOOD_PLANK_SLAB,
        ModBlocks.BLACK_WOOD_PLANK_SLAB,
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
        add("_stone_brick_slab");
        add("_wood_plank_slab");
        add("_stone_brick_stairs");
        add("_wood_plank_stairs");
        add("_stone_bricks");
        add("_wood_planks");
        add("_wool");
        add("_glazed_terracotta"); //must be first to prevent "_terracotta" from leaving "_glazed"
        add("_terracotta");
        add("_concrete");
        add("_stained_glass");
        add("_carpet");
    }};
    public static final List<Block> COLORABLE_BLOCKS = new ArrayList<>(){{
        for (int i = 0; i<16; i++) {
            add(COLORED_STONE_BRICKS[i]);
            add(COLORED_WOOD_PLANKS[i]);
            add(COLORED_WOOL_BLOCKS[i]);
            add(COLORED_TERRACOTTA[i]);
            add(COLORED_GLAZED_TERRACOTTA[i]);
            add(COLORED_CONCRETE[i]);
            add(COLORED_STAINED_GLASS[i]);
            add(COLORED_CARPET[i]);
            add(COLORED_STONE_BRICK_STAIRS[i]);
            add(COLORED_WOOD_PLANK_STAIRS[i]);
            add(COLORED_STONE_BRICK_SLAB[i]);
            add(COLORED_WOOD_PLANK_SLAB[i]);
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
