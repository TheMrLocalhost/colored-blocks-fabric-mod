package com.mrlocalhost.coloredblocks.utils;

import net.minecraft.entity.player.PlayerEntity;
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

}
