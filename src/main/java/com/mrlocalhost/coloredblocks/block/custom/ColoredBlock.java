package com.mrlocalhost.coloredblocks.block.custom;

import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class ColoredBlock extends Block {


    public static final IntProperty COLOR = IntProperty.of("color", ColoredBlocksConstants.minColorValue, ColoredBlocksConstants.maxColorValue);

    public ColoredBlock(Settings settings, int defaultState) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(COLOR, defaultState));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }
}
