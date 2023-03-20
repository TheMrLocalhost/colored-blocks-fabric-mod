package com.mrlocalhost.coloredblocks.item;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup COLORED_BLOCKS_GROUP = FabricItemGroupBuilder.build(
        new Identifier(ColoredBlocks.MOD_ID, "colored_blocks_group"), () -> new ItemStack(ModItems.ARTIST_PALETTE));
}
