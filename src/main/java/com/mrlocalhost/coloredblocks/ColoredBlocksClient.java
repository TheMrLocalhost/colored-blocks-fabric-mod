package com.mrlocalhost.coloredblocks;

import com.mrlocalhost.coloredblocks.networking.PacketHandler;
import net.fabricmc.api.ClientModInitializer;

public class ColoredBlocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PacketHandler.registerS2CPackets();
    }
}
