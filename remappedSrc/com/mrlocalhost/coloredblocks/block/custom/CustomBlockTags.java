package com.mrlocalhost.coloredblocks.block.custom;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CustomBlockTags {

    public static final TagKey<Block> COLORED_BLOCKS = of("colored_blocks:colored_stone_bricks");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }

}
