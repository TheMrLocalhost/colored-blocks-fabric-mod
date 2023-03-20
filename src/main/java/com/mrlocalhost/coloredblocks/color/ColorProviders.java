package com.mrlocalhost.coloredblocks.color;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import com.mrlocalhost.coloredblocks.block.entity.ColoredBlockEntity;
import com.mrlocalhost.coloredblocks.block.entity.ModBlockEntities;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.nbt.NbtCompound;
import java.util.Optional;

public class ColorProviders {

    public static void registerColorProviders() {
        registerColorProviders(ModBlocks.COLORED_STONE_BRICKS);
        registerColorProviders(ModBlocks.COLORED_WOOD_PLANKS);
        registerColorProviders(ModBlocks.COLORED_STONE_BRICK_STAIRS);
        registerColorProviders(ModBlocks.COLORED_WOOD_PLANK_STAIRS);
        registerColorProviders(ModBlocks.COLORED_STONE_BRICK_SLAB);
        registerColorProviders(ModBlocks.COLORED_WOOD_PLANK_SLAB);
    }
    private static void registerColorProviders(Block block) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (!state.hasBlockEntity()) { return 0xFF0000; }
            if (view == null) { return 0x00FF00; }
            Optional<ColoredBlockEntity> optionalEntity = view.getBlockEntity(pos, ModBlockEntities.COLORED_BLOCK_ENTITY);
            if (optionalEntity.isEmpty()) { return 0x0000FF; }
            ColoredBlockEntity entity = optionalEntity.get();
            NbtCompound nbt = new NbtCompound();
            entity.writeNbt(nbt);
            int red = nbt.getInt("red");
            int green = nbt.getInt("green");
            int blue = nbt.getInt("blue");
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
