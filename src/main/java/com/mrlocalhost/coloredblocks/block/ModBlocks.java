package com.mrlocalhost.coloredblocks.block;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import com.mrlocalhost.coloredblocks.block.custom.ColoredSlabBlock;
import com.mrlocalhost.coloredblocks.block.custom.ColoredStairsBlock;
import com.mrlocalhost.coloredblocks.item.ModItemGroup;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static void registerModBlocks() {
        ColoredBlocks.LOGGER.debug("Registering ModBlocks for " + ColoredBlocks.MOD_ID);
    }
    public static final ColoredBlock COLORED_STONE_BRICKS =
        registerColoredBlock(
            "colored_stone_bricks",
            Material.STONE
        );
    public static final ColoredBlock COLORED_WOOD_PLANKS =
        registerColoredBlock(
            "colored_wood_planks",
            Material.WOOD
        );
    public static final ColoredSlabBlock COLORED_STONE_BRICK_SLAB =
        registerColoredSlabBlock(
            "colored_stone_brick_slab",
            Material.STONE
        );
    public static final ColoredSlabBlock COLORED_WOOD_PLANK_SLAB =
        registerColoredSlabBlock(
            "colored_wood_plank_slab",
            Material.WOOD
        );
    public static final ColoredStairsBlock COLORED_STONE_BRICK_STAIRS =
        registerColoredStairsBlock(
            COLORED_STONE_BRICKS.getDefaultState(),
            "colored_stone_brick_stairs",
            Material.STONE
        );
    public static final ColoredStairsBlock COLORED_WOOD_PLANK_STAIRS =
        registerColoredStairsBlock(
            COLORED_WOOD_PLANKS.getDefaultState(),
            "colored_wood_plank_stairs",
            Material.WOOD
        );
    private static ColoredBlock registerColoredBlock(String name, Material material) {
        ColoredBlock block = new ColoredBlock(FabricBlockSettings
            .of(material)
            .drops(new Identifier(ColoredBlocks.MOD_ID, name))
            .requiresTool()
            .strength(1.5F)
            .resistance(6.0F));
        registerColoredBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredBlocks.MOD_ID, name), block);
    }
    private static ColoredStairsBlock registerColoredStairsBlock(BlockState blockState, String name, Material material) {
        ColoredStairsBlock block = new ColoredStairsBlock(blockState, FabricBlockSettings
            .of(material)
            .drops(new Identifier(ColoredBlocks.MOD_ID, name))
            .requiresTool()
            .strength(1.5F)
            .resistance(6.0F));
        registerColoredBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredBlocks.MOD_ID, name), block);
    }
    private static ColoredSlabBlock registerColoredSlabBlock(String name, Material material) {
        ColoredSlabBlock block = new ColoredSlabBlock(FabricBlockSettings
            .of(material)
            .drops(new Identifier(ColoredBlocks.MOD_ID, name))
            .requiresTool()
            .strength(1.5F)
            .resistance(6.0F));
        registerColoredBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ColoredBlocks.MOD_ID, name), block);
    }
    private static void registerColoredBlockItem(String name, Block block) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.COLORED_BLOCKS_GROUP).register(entries -> {
            for (int i = 0; i < 16; i++) {
                ItemStack stack = ColoredBlocksUtils.createBlockItem(block, i);
                entries.add(stack);
            }
        });
        Registry.register(Registries.ITEM, new Identifier(ColoredBlocks.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }
}
