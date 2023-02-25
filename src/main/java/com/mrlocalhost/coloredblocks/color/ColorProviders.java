package com.mrlocalhost.coloredblocks.color;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.nbt.NbtCompound;

public class ColorProviders {

    public static void registerColorProviders() {
        registerColorProviders(ModBlocks.COLORED_STONE_BRICKS);
        registerColorProviders(ModBlocks.COLORED_WOOD_PLANKS);
    }
    private static void registerColorProviders(Block block) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            int red = state.get(ColoredBlock.RED);
            int green = state.get(ColoredBlock.GREEN);
            int blue = state.get(ColoredBlock.BLUE);
            return red*16<<16|green*16<<8|blue*16;
        }, block);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            NbtCompound nbt = stack.getOrCreateNbt();
            int red = nbt.getInt("red");
            int green = nbt.getInt("green");
            int blue = nbt.getInt("blue");
            return red*16<<16|green*16<<8|blue*16;
        }, block);
    }
}
