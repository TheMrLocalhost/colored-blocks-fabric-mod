package com.mrlocalhost.coloredblocks.block;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import com.mrlocalhost.coloredblocks.block.custom.ColoredSlabBlock;
import com.mrlocalhost.coloredblocks.block.custom.ColoredStairsBlock;
import com.mrlocalhost.coloredblocks.item.ModItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModBlocks {
    public static void registerModBlocks() {
        ColoredBlocks.LOGGER.debug("Registering ModBlocks for " + ColoredBlocks.MOD_ID);
    }
    public static final Block RED_STONE_BRICKS = registerBlock("red_stone_bricks", Material.STONE);
    public static final Block ORANGE_STONE_BRICKS = registerBlock("orange_stone_bricks", Material.STONE);
    public static final Block YELLOW_STONE_BRICKS = registerBlock("yellow_stone_bricks", Material.STONE);
    public static final Block LIME_STONE_BRICKS = registerBlock("lime_stone_bricks", Material.STONE);
    public static final Block GREEN_STONE_BRICKS = registerBlock("green_stone_bricks", Material.STONE);
    public static final Block CYAN_STONE_BRICKS = registerBlock("cyan_stone_bricks", Material.STONE);
    public static final Block LIGHT_BLUE_STONE_BRICKS = registerBlock("light_blue_stone_bricks", Material.STONE);
    public static final Block BLUE_STONE_BRICKS = registerBlock("blue_stone_bricks", Material.STONE);
    public static final Block PURPLE_STONE_BRICKS = registerBlock("purple_stone_bricks", Material.STONE);
    public static final Block MAGENTA_STONE_BRICKS = registerBlock("magenta_stone_bricks", Material.STONE);
    public static final Block PINK_STONE_BRICKS = registerBlock("pink_stone_bricks", Material.STONE);
    public static final Block BROWN_STONE_BRICKS = registerBlock("brown_stone_bricks", Material.STONE);
    public static final Block WHITE_STONE_BRICKS = registerBlock("white_stone_bricks", Material.STONE);
    public static final Block LIGHT_GRAY_STONE_BRICKS = registerBlock("light_gray_stone_bricks", Material.STONE);
    public static final Block GRAY_STONE_BRICKS = registerBlock("gray_stone_bricks", Material.STONE);
    public static final Block BLACK_STONE_BRICKS = registerBlock("black_stone_bricks", Material.STONE);

    public static final Block RED_WOOD_PLANKS = registerBlock("red_wood_planks", Material.WOOD);
    public static final Block ORANGE_WOOD_PLANKS = registerBlock("orange_wood_planks", Material.WOOD);
    public static final Block YELLOW_WOOD_PLANKS = registerBlock("yellow_wood_planks", Material.WOOD);
    public static final Block LIME_WOOD_PLANKS = registerBlock("lime_wood_planks", Material.WOOD);
    public static final Block GREEN_WOOD_PLANKS = registerBlock("green_wood_planks", Material.WOOD);
    public static final Block CYAN_WOOD_PLANKS = registerBlock("cyan_wood_planks", Material.WOOD);
    public static final Block LIGHT_BLUE_WOOD_PLANKS = registerBlock("light_blue_wood_planks", Material.WOOD);
    public static final Block BLUE_WOOD_PLANKS = registerBlock("blue_wood_planks", Material.WOOD);
    public static final Block PURPLE_WOOD_PLANKS = registerBlock("purple_wood_planks", Material.WOOD);
    public static final Block MAGENTA_WOOD_PLANKS = registerBlock("magenta_wood_planks", Material.WOOD);
    public static final Block PINK_WOOD_PLANKS = registerBlock("pink_wood_planks", Material.WOOD);
    public static final Block BROWN_WOOD_PLANKS = registerBlock("brown_wood_planks", Material.WOOD);
    public static final Block WHITE_WOOD_PLANKS = registerBlock("white_wood_planks", Material.WOOD);
    public static final Block LIGHT_GRAY_WOOD_PLANKS = registerBlock("light_gray_wood_planks", Material.WOOD);
    public static final Block GRAY_WOOD_PLANKS = registerBlock("gray_wood_planks", Material.WOOD);
    public static final Block BLACK_WOOD_PLANKS = registerBlock("black_wood_planks", Material.WOOD);

    public static final Block RED_STONE_BRICK_STAIRS = registerStairsBlock(RED_STONE_BRICKS.getDefaultState(), "red_stone_brick_stairs", Material.STONE);
    public static final Block ORANGE_STONE_BRICK_STAIRS = registerStairsBlock(ORANGE_STONE_BRICKS.getDefaultState(), "orange_stone_brick_stairs", Material.STONE);
    public static final Block YELLOW_STONE_BRICK_STAIRS = registerStairsBlock(YELLOW_STONE_BRICKS.getDefaultState(), "yellow_stone_brick_stairs", Material.STONE);
    public static final Block LIME_STONE_BRICK_STAIRS = registerStairsBlock(LIME_STONE_BRICKS.getDefaultState(), "lime_stone_brick_stairs", Material.STONE);
    public static final Block GREEN_STONE_BRICK_STAIRS = registerStairsBlock(GREEN_STONE_BRICKS.getDefaultState(), "green_stone_brick_stairs", Material.STONE);
    public static final Block CYAN_STONE_BRICK_STAIRS = registerStairsBlock(CYAN_STONE_BRICKS.getDefaultState(), "cyan_stone_brick_stairs", Material.STONE);
    public static final Block LIGHT_BLUE_STONE_BRICK_STAIRS = registerStairsBlock(LIGHT_BLUE_STONE_BRICKS.getDefaultState(), "light_blue_stone_brick_stairs", Material.STONE);
    public static final Block BLUE_STONE_BRICK_STAIRS = registerStairsBlock(BLUE_STONE_BRICKS.getDefaultState(), "blue_stone_brick_stairs", Material.STONE);
    public static final Block PURPLE_STONE_BRICK_STAIRS = registerStairsBlock(PURPLE_STONE_BRICKS.getDefaultState(), "purple_stone_brick_stairs", Material.STONE);
    public static final Block MAGENTA_STONE_BRICK_STAIRS = registerStairsBlock(MAGENTA_STONE_BRICKS.getDefaultState(), "magenta_stone_brick_stairs", Material.STONE);
    public static final Block PINK_STONE_BRICK_STAIRS = registerStairsBlock(PINK_STONE_BRICKS.getDefaultState(), "pink_stone_brick_stairs", Material.STONE);
    public static final Block BROWN_STONE_BRICK_STAIRS = registerStairsBlock(BROWN_STONE_BRICKS.getDefaultState(), "brown_stone_brick_stairs", Material.STONE);
    public static final Block WHITE_STONE_BRICK_STAIRS = registerStairsBlock(WHITE_STONE_BRICKS.getDefaultState(), "white_stone_brick_stairs", Material.STONE);
    public static final Block LIGHT_GRAY_STONE_BRICK_STAIRS = registerStairsBlock(LIGHT_GRAY_STONE_BRICKS.getDefaultState(), "light_gray_stone_brick_stairs", Material.STONE);
    public static final Block GRAY_STONE_BRICK_STAIRS = registerStairsBlock(GRAY_STONE_BRICKS.getDefaultState(), "gray_stone_brick_stairs", Material.STONE);
    public static final Block BLACK_STONE_BRICK_STAIRS = registerStairsBlock(BLACK_STONE_BRICKS.getDefaultState(), "black_stone_brick_stairs", Material.STONE);

    public static final Block RED_WOOD_PLANK_STAIRS = registerStairsBlock(RED_WOOD_PLANKS.getDefaultState(), "red_wood_plank_stairs", Material.WOOD);
    public static final Block ORANGE_WOOD_PLANK_STAIRS = registerStairsBlock(ORANGE_WOOD_PLANKS.getDefaultState(), "orange_wood_plank_stairs", Material.WOOD);
    public static final Block YELLOW_WOOD_PLANK_STAIRS = registerStairsBlock(YELLOW_WOOD_PLANKS.getDefaultState(), "yellow_wood_plank_stairs", Material.WOOD);
    public static final Block LIME_WOOD_PLANK_STAIRS = registerStairsBlock(LIME_WOOD_PLANKS.getDefaultState(), "lime_wood_plank_stairs", Material.WOOD);
    public static final Block GREEN_WOOD_PLANK_STAIRS = registerStairsBlock(GREEN_WOOD_PLANKS.getDefaultState(), "green_wood_plank_stairs", Material.WOOD);
    public static final Block CYAN_WOOD_PLANK_STAIRS = registerStairsBlock(CYAN_WOOD_PLANKS.getDefaultState(), "cyan_wood_plank_stairs", Material.WOOD);
    public static final Block LIGHT_BLUE_WOOD_PLANK_STAIRS = registerStairsBlock(LIGHT_BLUE_WOOD_PLANKS.getDefaultState(), "light_blue_wood_plank_stairs", Material.WOOD);
    public static final Block BLUE_WOOD_PLANK_STAIRS = registerStairsBlock(BLUE_WOOD_PLANKS.getDefaultState(), "blue_wood_plank_stairs", Material.WOOD);
    public static final Block PURPLE_WOOD_PLANK_STAIRS = registerStairsBlock(PURPLE_WOOD_PLANKS.getDefaultState(), "purple_wood_plank_stairs", Material.WOOD);
    public static final Block MAGENTA_WOOD_PLANK_STAIRS = registerStairsBlock(MAGENTA_WOOD_PLANKS.getDefaultState(), "magenta_wood_plank_stairs", Material.WOOD);
    public static final Block PINK_WOOD_PLANK_STAIRS = registerStairsBlock(PINK_WOOD_PLANKS.getDefaultState(), "pink_wood_plank_stairs", Material.WOOD);
    public static final Block BROWN_WOOD_PLANK_STAIRS = registerStairsBlock(BROWN_WOOD_PLANKS.getDefaultState(), "brown_wood_plank_stairs", Material.WOOD);
    public static final Block WHITE_WOOD_PLANK_STAIRS = registerStairsBlock(WHITE_WOOD_PLANKS.getDefaultState(), "white_wood_plank_stairs", Material.WOOD);
    public static final Block LIGHT_GRAY_WOOD_PLANK_STAIRS = registerStairsBlock(LIGHT_GRAY_WOOD_PLANKS.getDefaultState(), "light_gray_wood_plank_stairs", Material.WOOD);
    public static final Block GRAY_WOOD_PLANK_STAIRS = registerStairsBlock(GRAY_WOOD_PLANKS.getDefaultState(), "gray_wood_plank_stairs", Material.WOOD);
    public static final Block BLACK_WOOD_PLANK_STAIRS = registerStairsBlock(BLACK_WOOD_PLANKS.getDefaultState(), "black_wood_plank_stairs", Material.WOOD);

    public static final Block RED_STONE_BRICK_SLAB = registerSlabBlock("red_stone_brick_slab", Material.STONE);
    public static final Block ORANGE_STONE_BRICK_SLAB = registerSlabBlock("orange_stone_brick_slab", Material.STONE);
    public static final Block YELLOW_STONE_BRICK_SLAB = registerSlabBlock("yellow_stone_brick_slab", Material.STONE);
    public static final Block LIME_STONE_BRICK_SLAB = registerSlabBlock("lime_stone_brick_slab", Material.STONE);
    public static final Block GREEN_STONE_BRICK_SLAB = registerSlabBlock("green_stone_brick_slab", Material.STONE);
    public static final Block CYAN_STONE_BRICK_SLAB = registerSlabBlock("cyan_stone_brick_slab", Material.STONE);
    public static final Block LIGHT_BLUE_STONE_BRICK_SLAB = registerSlabBlock("light_blue_stone_brick_slab", Material.STONE);
    public static final Block BLUE_STONE_BRICK_SLAB = registerSlabBlock("blue_stone_brick_slab", Material.STONE);
    public static final Block PURPLE_STONE_BRICK_SLAB = registerSlabBlock("purple_stone_brick_slab", Material.STONE);
    public static final Block MAGENTA_STONE_BRICK_SLAB = registerSlabBlock( "magenta_stone_brick_slab", Material.STONE);
    public static final Block PINK_STONE_BRICK_SLAB = registerSlabBlock("pink_stone_brick_slab", Material.STONE);
    public static final Block BROWN_STONE_BRICK_SLAB = registerSlabBlock("brown_stone_brick_slab", Material.STONE);
    public static final Block WHITE_STONE_BRICK_SLAB = registerSlabBlock("white_stone_brick_slab", Material.STONE);
    public static final Block LIGHT_GRAY_STONE_BRICK_SLAB = registerSlabBlock("light_gray_stone_brick_slab", Material.STONE);
    public static final Block GRAY_STONE_BRICK_SLAB = registerSlabBlock("gray_stone_brick_slab", Material.STONE);
    public static final Block BLACK_STONE_BRICK_SLAB = registerSlabBlock("black_stone_brick_slab", Material.STONE);

    public static final Block RED_WOOD_PLANK_SLAB = registerSlabBlock("red_wood_plank_slab", Material.WOOD);
    public static final Block ORANGE_WOOD_PLANK_SLAB = registerSlabBlock("orange_wood_plank_slab", Material.WOOD);
    public static final Block YELLOW_WOOD_PLANK_SLAB = registerSlabBlock("yellow_wood_plank_slab", Material.WOOD);
    public static final Block LIME_WOOD_PLANK_SLAB = registerSlabBlock("lime_wood_plank_slab", Material.WOOD);
    public static final Block GREEN_WOOD_PLANK_SLAB = registerSlabBlock("green_wood_plank_slab", Material.WOOD);
    public static final Block CYAN_WOOD_PLANK_SLAB = registerSlabBlock("cyan_wood_plank_slab", Material.WOOD);
    public static final Block LIGHT_BLUE_WOOD_PLANK_SLAB = registerSlabBlock("light_blue_wood_plank_slab", Material.WOOD);
    public static final Block BLUE_WOOD_PLANK_SLAB = registerSlabBlock("blue_wood_plank_slab", Material.WOOD);
    public static final Block PURPLE_WOOD_PLANK_SLAB = registerSlabBlock("purple_wood_plank_slab", Material.WOOD);
    public static final Block MAGENTA_WOOD_PLANK_SLAB = registerSlabBlock( "magenta_wood_plank_slab", Material.WOOD);
    public static final Block PINK_WOOD_PLANK_SLAB = registerSlabBlock("pink_wood_plank_slab", Material.WOOD);
    public static final Block BROWN_WOOD_PLANK_SLAB = registerSlabBlock("brown_wood_plank_slab", Material.WOOD);
    public static final Block WHITE_WOOD_PLANK_SLAB = registerSlabBlock("white_wood_plank_slab", Material.WOOD);
    public static final Block LIGHT_GRAY_WOOD_PLANK_SLAB = registerSlabBlock("light_gray_wood_plank_slab", Material.WOOD);
    public static final Block GRAY_WOOD_PLANK_SLAB = registerSlabBlock("gray_wood_plank_slab", Material.WOOD);
    public static final Block BLACK_WOOD_PLANK_SLAB = registerSlabBlock("black_wood_plank_slab", Material.WOOD);

    private static Block registerSlabBlock(String name, Material material) {
        Block block = new ColoredSlabBlock(FabricBlockSettings
                .of(material)
                .drops(new Identifier(ColoredBlocks.MOD_ID, name))
                .requiresTool()
                .strength(1.5F)
                .resistance(6.0F));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredBlocks.MOD_ID, name), block);
    }
    private static Block registerStairsBlock(BlockState blockState, String name, Material material) {
        Block block = new ColoredStairsBlock(blockState, FabricBlockSettings
                .of(material)
                .drops(new Identifier(ColoredBlocks.MOD_ID, name))
                .requiresTool()
                .strength(1.5F)
                .resistance(6.0F));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredBlocks.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Material material) {
        Block block = new ColoredBlock(FabricBlockSettings
                .of(material)
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
}
