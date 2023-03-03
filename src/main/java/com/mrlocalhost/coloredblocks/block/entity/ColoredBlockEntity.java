package com.mrlocalhost.coloredblocks.block.entity;

import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class ColoredBlockEntity extends BlockEntity {

    private int red = ColoredBlocksConstants.MAX_RGB_VALUE;
    private int green = ColoredBlocksConstants.MAX_RGB_VALUE;
    private int blue = ColoredBlocksConstants.MAX_RGB_VALUE;

    public ColoredBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COLORED_BLOCK_ENTITY, pos, state);
    }
    public int getRed(){return red;}
    public int getGreen(){return green;}
    public int getBlue(){return blue;}
    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("red", red);
        nbt.putInt("green", green);
        nbt.putInt("blue", blue);
        super.writeNbt(nbt);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        red = nbt.getInt("red");
        green = nbt.getInt("green");
        blue = nbt.getInt("blue");
    }
}
