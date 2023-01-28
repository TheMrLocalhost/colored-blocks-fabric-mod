package com.mrlocalhost.coloredblocks.block.custom;

import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ColoredBlock extends Block {
    public static final IntProperty COLOR = IntProperty.of("color", ColoredBlocksConstants.minColorValue, ColoredBlocksConstants.maxColorValue);
    public ColoredBlock(Settings settings, int defaultState) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(COLOR, defaultState));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Block currentBlock = state.getBlock();
        int color = state.get(COLOR);
        Block blockByProperty = ColoredBlocksConstants.COLORED_STONE_BRICKS[color];
        if (currentBlock != blockByProperty) {
            BlockState newBlockState = blockByProperty.getDefaultState().with(COLOR, color);
            world.removeBlock(pos, false);
            world.setBlockState(pos, newBlockState);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
