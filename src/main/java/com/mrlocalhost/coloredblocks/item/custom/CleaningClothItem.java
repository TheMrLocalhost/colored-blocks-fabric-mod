package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CleaningClothItem extends Item {
    public CleaningClothItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        //If not server, holding shift, or use called with offHand
        if (Screen.hasShiftDown() || world.isClient() || context.getHand() != Hand.MAIN_HAND) {
            return ActionResult.PASS;
        }
        ItemStack cleaningClothStack = player.getMainHandStack();
        //If hand stacks gets nulled
        if (cleaningClothStack == null) {
            return ActionResult.PASS;
        }
        BlockPos blockLocation = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockLocation);
        //if colored block
        if (!ColoredBlocksConstants.COLORABLE_BLOCKS.contains(blockState.getBlock())) {
            return ActionResult.PASS;
        }
        //do cleaning
        BlockState newBlockState;
        if (blockState.isIn(CustomBlockTags.COLORED_STONE_BRICKS)) {
            newBlockState = Blocks.STONE_BRICKS.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_WOOD_PLANKS)) {
            newBlockState = Blocks.BIRCH_PLANKS.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_WOOL_BLOCKS)) {
            newBlockState = Blocks.WHITE_WOOL.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_TERRACOTTA)) {
            newBlockState = Blocks.TERRACOTTA.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_GLAZED_TERRACOTTA)) {
            newBlockState = Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_CONCRETE)) {
            newBlockState = Blocks.WHITE_CONCRETE.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_STAINED_GLASS)) {
            newBlockState = Blocks.GLASS.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_CARPET)) {
            newBlockState = Blocks.WHITE_CARPET.getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORED_STONE_BRICK_STAIRS)) {
            newBlockState = ColoredBlocksUtils.cloneStairBlockStateProperties(blockState,
                Blocks.STONE_BRICK_STAIRS.getDefaultState());
        } else if (blockState.isIn(CustomBlockTags.COLORED_WOOD_PLANK_STAIRS)) {
            newBlockState = ColoredBlocksUtils.cloneStairBlockStateProperties(blockState,
                Blocks.BIRCH_STAIRS.getDefaultState());
        } else if (blockState.isIn(CustomBlockTags.COLORED_STONE_BRICK_SLAB)) {
            newBlockState = ColoredBlocksUtils.cloneSlabBlockStateProperties(blockState,
                    Blocks.STONE_BRICK_SLAB.getDefaultState());
        } else {
            return ActionResult.PASS;
        }
        world.removeBlock(blockLocation, false);
        world.setBlockState(blockLocation, newBlockState);
        return ActionResult.PASS;
    }
}
