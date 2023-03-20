package com.mrlocalhost.coloredblocks.networking;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.networking.packets.ColoredBlockEntityColorChangeS2CPacket;
import com.mrlocalhost.coloredblocks.networking.packets.PaintbrushC2SPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class PacketHandler {

    public static final Identifier PAINTBRUSH_COLOR_ID = new Identifier(ColoredBlocks.MOD_ID, "paintbrush_color");
    public static final Identifier COLORED_BLOCK_ENTITY_COLOR_CHANGER_ID = new Identifier(ColoredBlocks.MOD_ID, "colored_block_entity_color_changer");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(PAINTBRUSH_COLOR_ID, PaintbrushC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(COLORED_BLOCK_ENTITY_COLOR_CHANGER_ID, ColoredBlockEntityColorChangeS2CPacket::receive);
    }

}
