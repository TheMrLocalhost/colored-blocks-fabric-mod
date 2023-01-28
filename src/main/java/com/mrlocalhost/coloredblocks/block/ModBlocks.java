package com.mrlocalhost.coloredblocks.block;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import com.mrlocalhost.coloredblocks.item.ModItemGroup;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
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
    private static Block registerBlock(String name, int defaultState) {
        Block block = new ColoredBlock(FabricBlockSettings
                .of(Material.STONE)
                .drops(new Identifier(ColoredBlocks.MOD_ID, name))
                .requiresTool()
                .strength(1.5F)
                .resistance(6.0F),
                defaultState);
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
    public static final Block RED_STONE_BRICKS = registerBlock("red_stone_bricks", ColoredBlocksConstants.COLOR_RED);
    public static final Block ORANGE_STONE_BRICKS = registerBlock("orange_stone_bricks", ColoredBlocksConstants.COLOR_ORANGE);
    public static final Block YELLOW_STONE_BRICKS = registerBlock("yellow_stone_bricks", ColoredBlocksConstants.COLOR_YELLOW);
    public static final Block LIME_STONE_BRICKS = registerBlock("lime_stone_bricks", ColoredBlocksConstants.COLOR_LIME);
    public static final Block GREEN_STONE_BRICKS = registerBlock("green_stone_bricks", ColoredBlocksConstants.COLOR_GREEN);
    public static final Block CYAN_STONE_BRICKS = registerBlock("cyan_stone_bricks", ColoredBlocksConstants.COLOR_CYAN);
    public static final Block LIGHT_BLUE_STONE_BRICKS = registerBlock("light_blue_stone_bricks", ColoredBlocksConstants.COLOR_LIGHT_BLUE);
    public static final Block BLUE_STONE_BRICKS = registerBlock("blue_stone_bricks", ColoredBlocksConstants.COLOR_BLUE);
    public static final Block PURPLE_STONE_BRICKS = registerBlock("purple_stone_bricks", ColoredBlocksConstants.COLOR_PURPLE);
    public static final Block MAGENTA_STONE_BRICKS = registerBlock("magenta_stone_bricks", ColoredBlocksConstants.COLOR_MAGENTA);
    public static final Block PINK_STONE_BRICKS = registerBlock("pink_stone_bricks", ColoredBlocksConstants.COLOR_PINK);
    public static final Block BROWN_STONE_BRICKS = registerBlock("brown_stone_bricks", ColoredBlocksConstants.COLOR_BROWN);
    public static final Block WHITE_STONE_BRICKS = registerBlock("white_stone_bricks", ColoredBlocksConstants.COLOR_WHITE);
    public static final Block LIGHT_GRAY_STONE_BRICKS = registerBlock("light_gray_stone_bricks", ColoredBlocksConstants.COLOR_LIGHT_GRAY);
    public static final Block GRAY_STONE_BRICKS = registerBlock("gray_stone_bricks", ColoredBlocksConstants.COLOR_GRAY);
    public static final Block BLACK_STONE_BRICKS = registerBlock("black_stone_bricks", ColoredBlocksConstants.COLOR_BLACK);
}
