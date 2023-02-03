package com.mrlocalhost.coloredblocks.utils;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

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
        for (String suffix: ColoredBlocksConstants.BLOCK_SUFFIXES) {
            strippedName = strippedName.replace(suffix, "");
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
            || blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICK_STAIRS)
            || blockState.isIn(CustomBlockTags.COLORABLE_WOOD_PLANK_STAIRS)
            || blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICK_SLAB)
        );
    }
    public static boolean isSameColor(BlockState blockState, int color) {
        return (getColorOfBlock(blockState) == color);
    }
    public static BlockState cloneStairBlockStateProperties(BlockState sourceBlockState, BlockState newBlockState) {
        return newBlockState
                .with(StairsBlock.FACING, sourceBlockState.get(StairsBlock.FACING))
                .with(StairsBlock.HALF, sourceBlockState.get(StairsBlock.HALF))
                .with(StairsBlock.SHAPE, sourceBlockState.get(StairsBlock.SHAPE))
                .with(StairsBlock.WATERLOGGED, sourceBlockState.get(StairsBlock.WATERLOGGED));
    }
    public static BlockState cloneSlabBlockStateProperties(BlockState sourceBlockState, BlockState newBlockState) {
        return newBlockState
                .with(SlabBlock.TYPE, sourceBlockState.get(SlabBlock.TYPE))
                .with(StairsBlock.WATERLOGGED, sourceBlockState.get(StairsBlock.WATERLOGGED));
    }
    public static TextureMap createStairsTextureMap(String colorPrefix, String sourceTextureSuffix) {
        TextureMap stairsTextureMap = new TextureMap();
        Identifier id = new Identifier(ColoredBlocks.MOD_ID,"block/"+colorPrefix+"_"+sourceTextureSuffix);
        stairsTextureMap.put(TextureKey.TOP, id);
        stairsTextureMap.put(TextureKey.SIDE, id);
        stairsTextureMap.put(TextureKey.BOTTOM, id);
        return stairsTextureMap;
    }
    public static TextureMap createSlabTextureMap(String colorPrefix, String sourceTextureSuffix) {
        TextureMap slabTextureMap = new TextureMap();
        Identifier id = new Identifier(ColoredBlocks.MOD_ID,"block/"+colorPrefix+"_"+sourceTextureSuffix);
        slabTextureMap.put(TextureKey.ALL, id);
        slabTextureMap.put(TextureKey.TOP, id);
        slabTextureMap.put(TextureKey.BOTTOM, id);
        return slabTextureMap;
    }
}
