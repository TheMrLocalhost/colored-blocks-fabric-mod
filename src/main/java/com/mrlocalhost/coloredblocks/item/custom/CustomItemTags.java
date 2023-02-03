package com.mrlocalhost.coloredblocks.item.custom;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CustomItemTags {

    public static final TagKey<Item> DYES = of("colored_blocks:dyes");

    public static final TagKey<Item> COLORED_STONE_BRICKS = of("colored_blocks:colored_stone_bricks");
    public static final TagKey<Item> COLORABLE_STONE_BRICKS = of("colored_blocks:colorable_stone_bricks");

    public static final TagKey<Item> COLORED_WOOD_PLANKS = of("colored_blocks:colored_wood_planks");
    public static final TagKey<Item> COLORABLE_WOOD_PLANKS = of("colored_blocks:colorable_wood_planks");

    public static final TagKey<Item> COLORED_WOOL_BLOCKS = of("colored_blocks:colored_wool_blocks");
    public static final TagKey<Item> COLORABLE_WOOL_BLOCKS = of("colored_blocks:colorable_wool_blocks");

    public static final TagKey<Item> COLORED_TERRACOTTA = of("colored_blocks:colored_terracotta");
    public static final TagKey<Item> COLORABLE_TERRACOTTA = of("colored_blocks:colorable_terracotta");

    public static final TagKey<Item> COLORED_GLAZED_TERRACOTTA = of("colored_blocks:colored_glazed_terracotta");
    public static final TagKey<Item> COLORABLE_GLAZED_TERRACOTTA = of("colored_blocks:colorable_glazed_terracotta");

    public static final TagKey<Item> COLORED_CONCRETE = of("colored_blocks:colored_concrete");
    public static final TagKey<Item> COLORABLE_CONCRETE = of("colored_blocks:colorable_concrete");

    public static final TagKey<Item> COLORED_STAINED_GLASS = of("colored_blocks:colored_stained_glass");
    public static final TagKey<Item> COLORABLE_STAINED_GLASS = of("colored_blocks:colorable_stained_glass");

    public static final TagKey<Item> COLORED_CARPET = of("colored_blocks:colored_carpet");
    public static final TagKey<Item> COLORABLE_CARPET = of("colored_blocks:colorable_carpet");

    public static final TagKey<Item> COLORED_STONE_BRICK_STAIRS = of("colored_blocks:colored_stone_brick_stairs");
    public static final TagKey<Item> COLORABLE_STONE_BRICK_STAIRS = of("colored_blocks:colorable_stone_brick_stairs");

    public static final TagKey<Item> COLORED_WOOD_PLANK_STAIRS = of("colored_blocks:colored_wood_plank_stairs");
    public static final TagKey<Item> COLORABLE_WOOD_PLANK_STAIRS = of("colored_blocks:colorable_wood_plank_stairs");

    public static final TagKey<Item> COLORED_STONE_BRICK_SLAB = of("colored_blocks:colored_stone_brick_slab");
    public static final TagKey<Item> COLORABLE_STONE_BRICK_SLAB = of("colored_blocks:colorable_stone_brick_slab");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
    }

}
