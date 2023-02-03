package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.minecraft.block.Block;
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
        if (blockState.isIn(CustomBlockTags.COLORED_STONE_BRICKS)) {
            doCleaningAction(world, blockLocation, Blocks.STONE_BRICKS);
        } else if (blockState.isIn(CustomBlockTags.COLORED_WOOD_PLANKS)) {
            doCleaningAction(world, blockLocation, Blocks.BIRCH_PLANKS);
        } else if (blockState.isIn(CustomBlockTags.COLORED_WOOL_BLOCKS)) {
            doCleaningAction(world, blockLocation, Blocks.WHITE_WOOL);
        } else if (blockState.isIn(CustomBlockTags.COLORED_TERRACOTTA)) {
            doCleaningAction(world, blockLocation, Blocks.TERRACOTTA);
        } else if (blockState.isIn(CustomBlockTags.COLORED_GLAZED_TERRACOTTA)) {
            doCleaningAction(world, blockLocation, Blocks.WHITE_GLAZED_TERRACOTTA);
        } else if (blockState.isIn(CustomBlockTags.COLORED_CONCRETE)) {
            doCleaningAction(world, blockLocation, Blocks.WHITE_CONCRETE);
        } else if (blockState.isIn(CustomBlockTags.COLORED_STAINED_GLASS)) {
            doCleaningAction(world, blockLocation, Blocks.GLASS);
        } else if (blockState.isIn(CustomBlockTags.COLORED_CARPET)) {
            doCleaningAction(world, blockLocation, Blocks.WHITE_CARPET);
        }

        return ActionResult.PASS;
    }
    private void doCleaningAction(World world, BlockPos pos, Block newBlock) {
        BlockState newBlockState = newBlock.getDefaultState();
        world.removeBlock(pos, false);
        world.setBlockState(pos, newBlockState);
    }
}
