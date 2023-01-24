package com.mrlocalhost.coloredstonebricks.item;

import com.mrlocalhost.coloredstonebricks.ColoredStoneBricks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup COLORED_STONE_BRICKS_GROUP = FabricItemGroup.builder(
            new Identifier(ColoredStoneBricks.MOD_ID, "colored_stone_bricks_group"))
            .icon(() -> new ItemStack(ModItems.RED_STONE_BRICKS))
            .build();
}
