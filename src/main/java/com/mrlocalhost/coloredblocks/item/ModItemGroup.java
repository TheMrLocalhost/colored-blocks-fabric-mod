package com.mrlocalhost.coloredblocks.item;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup COLORED_BLOCKS_GROUP = FabricItemGroup.builder(
            new Identifier(ColoredBlocks.MOD_ID, "colored_blocks_group"))
            .icon(() -> new ItemStack(ModBlocks.RED_STONE_BRICKS.asItem()))
            .build();
}
