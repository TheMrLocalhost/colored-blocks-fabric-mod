package com.mrlocalhost.coloredblocks.block.custom;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CustomBlockTags {

    public static final TagKey<Block> COLORED_STONE_BRICKS = of("colored_blocks:colored_stone_bricks");
    public static final TagKey<Block> COLORED_WOOD_PLANKS = of("colored_blocks:colored_wood_planks");

    public static final TagKey<Block> COLORABLE_STONE_BRICKS = of("colored_blocks:colorable_stone_bricks");
    public static final TagKey<Block> COLORABLE_WOOD_PLANKS = of("colored_blocks:colorable_wood_planks");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }

}
