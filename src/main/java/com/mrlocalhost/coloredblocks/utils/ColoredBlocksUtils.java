package com.mrlocalhost.coloredblocks.utils;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import com.mrlocalhost.coloredblocks.block.entity.ColoredBlockEntity;
import net.minecraft.block.*;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class ColoredBlocksUtils {
    private static final int AND_R = 0xF00;
    private static final int AND_G = 0x0F0;
    private static final int AND_B = 0x00F;
    private static final int SHF_R = 8;
    private static final int SHF_G = 4;
    private static final float MAX_F = 15.0F;
    public static Text stringToText(String message) {
        return Text.literal(message);
    }
    public static Text stringToText(String message, Formatting format) {
        return Text.literal(message).formatted(format);
    }
    public static Text stringToText(String message, Style style) {
        return Text.literal(message).setStyle(style);
    }
    public static void sendMessage(PlayerEntity player, String message) {
        player.sendMessage(Text.literal(message));
    }
    public static String getColorName(int value) {
        return ColoredBlocksConstants.COLOR_NAMES[value];
    }
    public static int getIndexOfColor(String color) {
        return ColoredBlocksConstants.COLOR_MAP.indexOf(color);
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
            || blockState.isIn(CustomBlockTags.COLORABLE_WOOD_PLANK_SLAB)
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
    public static TextureMap createColoredBlockTextureMap(Block block, String blockName) {
        TextureMap coloredBlockTextureMap = new TextureMap();
        Identifier id = new Identifier(ColoredBlocks.MOD_ID, "block/"+blockName);
        coloredBlockTextureMap.put(TextureKey.ALL, id);
        return coloredBlockTextureMap;
    }
    public static TextureMap createStairsTextureMap(String sourceTextureSuffix) {
        TextureMap stairsTextureMap = new TextureMap();
        Identifier id = new Identifier(ColoredBlocks.MOD_ID,"block/"+sourceTextureSuffix);
        stairsTextureMap.put(TextureKey.TOP, id);
        stairsTextureMap.put(TextureKey.SIDE, id);
        stairsTextureMap.put(TextureKey.BOTTOM, id);
        return stairsTextureMap;
    }
    public static TextureMap createSlabTextureMap(String sourceTextureSuffix) {
        TextureMap slabTextureMap = new TextureMap();
        Identifier id = new Identifier(ColoredBlocks.MOD_ID,"block/"+sourceTextureSuffix);
        slabTextureMap.put(TextureKey.ALL, id);
        slabTextureMap.put(TextureKey.TOP, id);
        slabTextureMap.put(TextureKey.BOTTOM, id);
        return slabTextureMap;
    }
    public static int stripRedIntFromHex(int hexIndex) {
        return (ColoredBlocksConstants.HEX_COLOR_VALUES[hexIndex] & AND_R) >> SHF_R;
    }
    public static float stripRedFloatFromHex(int hexIndex) {
        return (float)((ColoredBlocksConstants.HEX_COLOR_VALUES[hexIndex] & AND_R) >> SHF_R ) / MAX_F;
    }
    public static int stripGreenIntFromHex(int hexIndex) {
        return (ColoredBlocksConstants.HEX_COLOR_VALUES[hexIndex] & AND_G) >> SHF_G;
    }
    public static float stripGreenFloatFromHex(int hexIndex) {
        return (float)((ColoredBlocksConstants.HEX_COLOR_VALUES[hexIndex] & AND_G) >> SHF_G) / MAX_F;
    }
    public static int stripBlueIntFromHex(int hexIndex) {
        return ColoredBlocksConstants.HEX_COLOR_VALUES[hexIndex] & AND_B;
    }
    public static float stripBlueFloatFromHex(int hexIndex) {
        return (float)(ColoredBlocksConstants.HEX_COLOR_VALUES[hexIndex] & AND_B) / MAX_F;
    }
    public static BlockState changeBlockColor(Block baseBlock, int newColorValue) {
        return baseBlock.getDefaultState();
    }

    public static ItemStack colorEntityMaptoItem(ColoredBlockEntity entity, BlockState state) {
        ItemStack itemStack = new ItemStack(state.getBlock(), 1);
        NbtCompound nbt = itemStack.getOrCreateNbt();
        entity.writeNbt(nbt);
        return itemStack;
    }
    public static BlockState colorItemToBlock(Block blockToPlace, ItemStack itemstack) {
        return blockToPlace.getDefaultState();
    }
    public static ItemStack colorBlockToItem(BlockState state) {
        ItemStack itemStack = new ItemStack(state.getBlock(), 1);
        NbtCompound nbt = itemStack.getOrCreateNbt();
        nbt.putInt("red", ColoredBlocksConstants.MAX_COLOR_VALUE);
        nbt.putInt("green", ColoredBlocksConstants.MAX_COLOR_VALUE);
        nbt.putInt("blue", ColoredBlocksConstants.MAX_COLOR_VALUE);
        return itemStack;
    }
    public static ItemStack createBlockItem(Block block, int colorIndex) {
        ItemStack stack = block.asItem().getDefaultStack();
        NbtCompound nbt = stack.getOrCreateNbt();
        ColoredBlocksConstants.RGB_VALUES rgb = ColoredBlocksConstants.RGB_VALUES.byIndex(colorIndex);
        nbt.putInt("red", rgb.r());
        nbt.putInt("green", rgb.g());
        nbt.putInt("blue", rgb.b());
        return stack;
    }
    public static NbtCompound colorItemToNbt(ItemStack stack) {
        NbtCompound stackNbt = stack.getOrCreateNbt();
        return ColoredBlocksUtils.rgbColorsToNbt(
            stackNbt.getInt("red"),
            stackNbt.getInt("green"),
            stackNbt.getInt("blue")
        );
    }
    public static NbtCompound rgbColorsToNbt(int red, int green, int blue) {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("red", red);
        nbt.putInt("green", green);
        nbt.putInt("blue", blue);
        return nbt;
    }

    public static int getRedFromHex(int hexColorValue) {
        return (hexColorValue & AND_R) >> SHF_R;
    }
    public static int getGreenFromHex(int hexColorValue) {
        return (hexColorValue & AND_G) >> SHF_G;
    }
    public static int getBlueFromHex(int hexColorValue) {
        return hexColorValue & AND_B;
    }
}
