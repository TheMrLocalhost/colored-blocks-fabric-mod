package com.mrlocalhost.coloredblocks.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ModScreens {

    public static void openColorWheelScreen(PlayerEntity player, ItemStack paintBrush) {
        MinecraftClient.getInstance().setScreen(new ColorWheelScreen(player, paintBrush));
    }

}
