package com.mrlocalhost.coloredblocks.block.custom;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CustomBlockTags {

    public static final TagKey<Block> COLORABLE_STONE_BRICKS = of("colored_blocks:colorable_stone_bricks");
    public static final TagKey<Block> COLORED_STONE_BRICKS = of("colored_blocks:colored_stone_bricks");

    public static final TagKey<Block> COLORED_WOOD_PLANKS = of("colored_blocks:colored_wood_planks");
    public static final TagKey<Block> COLORABLE_WOOD_PLANKS = of("colored_blocks:colorable_wood_planks");

    public static final TagKey<Block> COLORED_WOOL_BLOCKS = of("colored_blocks:colored_wool_blocks");
    public static final TagKey<Block> COLORABLE_WOOL_BLOCKS = of("colored_blocks:colorable_wool_blocks");

    public static final TagKey<Block> COLORED_TERRACOTTA = of("colored_blocks:colored_terracotta");
    public static final TagKey<Block> COLORABLE_TERRACOTTA = of("colored_blocks:colorable_terracotta");

    public static final TagKey<Block> COLORED_GLAZED_TERRACOTTA = of("colored_blocks:colored_glazed_terracotta");
    public static final TagKey<Block> COLORABLE_GLAZED_TERRACOTTA = of("colored_blocks:colorable_glazed_terracotta");

    public static final TagKey<Block> COLORED_CONCRETE = of("colored_blocks:colored_concrete");
    public static final TagKey<Block> COLORABLE_CONCRETE = of("colored_blocks:colorable_concrete");

    public static final TagKey<Block> COLORED_STAINED_GLASS = of("colored_blocks:colored_stained_glass");
    public static final TagKey<Block> COLORABLE_STAINED_GLASS = of("colored_blocks:colorable_stained_glass");

    public static final TagKey<Block> COLORED_CARPET = of("colored_blocks:colored_carpet");
    public static final TagKey<Block> COLORABLE_CARPET = of("colored_blocks:colorable_carpet");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id));
    }

}
