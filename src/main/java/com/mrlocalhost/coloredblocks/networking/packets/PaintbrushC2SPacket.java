package com.mrlocalhost.coloredblocks.networking.packets;

import com.mrlocalhost.coloredblocks.item.ModItems;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class PaintbrushC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //Everything here happens only on the server
        ItemStack paintbrush = player.getInventory().getMainHandStack();
        if (paintbrush.getItem() == ModItems.PAINTBRUSH) {
            NbtCompound nbtCompound = paintbrush.getOrCreateNbt();
            nbtCompound.putInt("color", buf.readInt());
        }
    }

}
