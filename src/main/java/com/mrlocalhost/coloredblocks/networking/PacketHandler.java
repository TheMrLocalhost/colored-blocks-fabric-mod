package com.mrlocalhost.coloredblocks.networking;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.networking.packets.PaintbrushC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class PacketHandler {

    public static final Identifier PAINTBRUSH_COLOR_ID = new Identifier(ColoredBlocks.MOD_ID, "paintbrush_color");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(PAINTBRUSH_COLOR_ID, PaintbrushC2SPacket::receive);
    }

}
