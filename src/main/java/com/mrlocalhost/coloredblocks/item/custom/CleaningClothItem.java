package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
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
        if (!blockState.isIn(CustomBlockTags.COLORED_BLOCKS)) {
            return ActionResult.PASS;
        }
        //do cleaning
        doCleaningAction(world, blockLocation, Blocks.STONE_BRICKS);
        return ActionResult.PASS;
    }
    private void doCleaningAction(World world, BlockPos pos, Block newBlock) {
        BlockState newBlockState = newBlock.getDefaultState();
        world.removeBlock(pos, false);
        world.setBlockState(pos, newBlockState);
    }
}
