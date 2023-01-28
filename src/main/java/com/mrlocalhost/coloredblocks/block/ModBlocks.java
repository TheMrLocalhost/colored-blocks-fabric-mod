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
    public static final Block RED_STONE_BRICKS = registerBlock("red_stone_bricks", ColoredBlocksConstants.COLOR_RED);
    public static final Block ORANGE_STONE_BRICKS = registerBlock("orange_stone_bricks", ColoredBlocksConstants.COLOR_ORANGE);
    public static final Block YELLOW_STONE_BRICKS = registerBlock("yellow_stone_bricks", ColoredBlocksConstants.COLOR_YELLOW);
    public static final Block LIME_STONE_BRICKS = registerBlock("lime_stone_bricks", ColoredBlocksConstants.COLOR_LIME);
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
}
