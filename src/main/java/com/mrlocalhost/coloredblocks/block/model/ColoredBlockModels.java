package com.mrlocalhost.coloredblocks.block.model;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;
import java.util.Optional;

public class ColoredBlockModels extends Models {
    public static final Model COLORED_BLOCK;
    public static final Model COLORED_STAIRS;
    public static final Model COLORED_STAIRS_INNER;
    public static final Model COLORED_STAIRS_OUTER;
    public static final Model COLORED_SLAB;
    public static final Model COLORED_SLAB_TOP;

    static {
        COLORED_BLOCK = block("colored_block", TextureKey.ALL);

        COLORED_STAIRS = block("colored_stairs", TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);
        COLORED_STAIRS_INNER = block("colored_stairs_inner", "_inner", TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);
        COLORED_STAIRS_OUTER = block("colored_stairs_outer", "_outer", TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);

        COLORED_SLAB = block("colored_slab", TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);
        COLORED_SLAB_TOP = block("colored_slab_top", "_top", TextureKey.BOTTOM, TextureKey.TOP, TextureKey.SIDE);
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(ColoredBlocks.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(ColoredBlocks.MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
}
