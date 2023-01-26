package com.mrlocalhost.coloredblocks.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;

public class ColoredBlock extends Block {

    public static final int minColorValue = 0;
    public static final int maxColorValue = 3;
    public static final IntProperty COLOR = IntProperty.of("color", 0, 3);

    public ColoredBlock(Settings settings, int defaultState) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(COLOR, defaultState));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }
}
