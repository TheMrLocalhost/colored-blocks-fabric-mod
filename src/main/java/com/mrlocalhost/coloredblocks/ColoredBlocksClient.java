package com.mrlocalhost.coloredblocks;

import com.mrlocalhost.coloredblocks.predicate.custom.ModPredicates;
import net.fabricmc.api.ClientModInitializer;

public class ColoredBlocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModPredicates.registerModPredicates();
    }
}
