package com.mrlocalhost.coloredblocks.utils;

import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ColoredBlocksUtils {

    public static Text stringToText(String message, Formatting format) {
        return Text.literal(message).formatted(format);
    }
    public static void sendMessage(PlayerEntity player, String message) {
        player.sendMessage(Text.literal(message));
    }
    public static String getColorName(int value) {
        return ColoredBlocksConstants.COLOR_NAMES[value];
    }
    public static int getColorOfBlock(BlockState blockState) {
        return getColorOfBlock(blockState.getBlock());
    }
    public static int getColorOfBlock(Block block) {
        String blockName = Registries.BLOCK.getId(block).getPath();
        String colorName = stripColorOffName(blockName);
        return ColoredBlocksConstants.COLOR_MAP.indexOf(colorName);
    }
    private static String stripColorOffName(String name) {
        String strippedName = name;
        System.out.println("Original name: "+strippedName);
        for (String suffix: ColoredBlocksConstants.BLOCK_SUFFIXES) {
            strippedName = strippedName.replace(suffix, "");
            System.out.println("Stripped off '"+suffix+"': "+strippedName);
        }
        return strippedName;
    }
    public static boolean isColorable(BlockState blockState) {
        return (
               blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICKS)
            || blockState.isIn(CustomBlockTags.COLORABLE_WOOD_PLANKS)
            || blockState.isIn(CustomBlockTags.COLORABLE_WOOL_BLOCKS)
            || blockState.isIn(CustomBlockTags.COLORABLE_TERRACOTTA)
            || blockState.isIn(CustomBlockTags.COLORABLE_GLAZED_TERRACOTTA)
            || blockState.isIn(CustomBlockTags.COLORABLE_CONCRETE)
            || blockState.isIn(CustomBlockTags.COLORABLE_STAINED_GLASS)
            || blockState.isIn(CustomBlockTags.COLORABLE_CARPET)
        );
    }
    public static boolean isSameColor(BlockState blockState, int color) {
        return (getColorOfBlock(blockState) == color);
    }
}
