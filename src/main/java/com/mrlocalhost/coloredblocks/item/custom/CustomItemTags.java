package com.mrlocalhost.coloredblocks.item.custom;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CustomItemTags {

    public static final TagKey<Item> DYES = of("colored_blocks:dyes");

    public static final TagKey<Item> COLORED_STONE_BRICKS = of("colored_blocks:colored_stone_bricks");
    public static final TagKey<Item> COLORED_WOOD_PLANKS = of("colored_blocks:colored_wood_planks");

    public static final TagKey<Item> COLORABLE_STONE_BRICKS = of("colored_blocks:colorable_stone_bricks");
    public static final TagKey<Item> COLORABLE_WOOD_PLANKS = of("colored_blocks:colorable_wood_planks");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
    }

}
