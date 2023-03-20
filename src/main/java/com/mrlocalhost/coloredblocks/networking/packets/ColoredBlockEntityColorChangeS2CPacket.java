package com.mrlocalhost.coloredblocks.networking.packets;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.entity.ColoredBlockEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class ColoredBlockEntityColorChangeS2CPacket {

    public static void receive(MinecraftClient minecraftClient, ClientPlayNetworkHandler clientPlayNetworkHandler,
                            PacketByteBuf packetByteBuf, PacketSender packetSender) {
        //Everything here happens only on the client
        ColoredBlocks.LOGGER.info("client receive method called!");
        ClientWorld world = minecraftClient.world;
        if (world == null) return;
        ColoredBlocks.LOGGER.info("world not null");
        int[] ints = packetByteBuf.readIntArray();
        BlockPos pos = new BlockPos(ints[1], ints[2], ints[3]);
        int color = ints[0];
        ColoredBlocks.LOGGER.info("client entity pos: "+pos.toShortString());
        ColoredBlocks.LOGGER.info("client color: "+color);
        ColoredBlockEntity entity = (ColoredBlockEntity) world.getBlockEntity(pos);
        if (entity == null) return;
        ColoredBlocks.LOGGER.info("entity not null");
        entity.readRGB(color);
        entity.markDirty();
        ClientPlayerEntity player = minecraftClient.player;
        if (player == null) return;
        ColoredBlocks.LOGGER.info("player not null");
        player.sendMessage(Text.literal("C: new client color: "+color));
    }
}
