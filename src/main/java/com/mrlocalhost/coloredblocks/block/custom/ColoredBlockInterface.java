package com.mrlocalhost.coloredblocks.block.custom;

import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public interface ColoredBlockInterface extends BlockEntityProvider {

    default void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        String langAppend = "";
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains("red")) {
            langAppend = "Uncolored";
        } else {
            String red = Integer.toHexString(nbt.getInt("red"));
            String green = Integer.toHexString(nbt.getInt("green"));
            String blue = Integer.toHexString(nbt.getInt("blue"));
            langAppend += "#"+(red + green + blue).toUpperCase();
        }
        tooltip.add(Text.literal(langAppend));
    }
    default ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return ColoredBlocksUtils.colorBlockToItem(state);
    }

}
