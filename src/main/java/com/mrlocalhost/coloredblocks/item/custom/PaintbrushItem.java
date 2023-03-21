package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.screen.ModScreens;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class PaintbrushItem extends Item {
    public PaintbrushItem(Settings settings) {
        super(settings);
        NbtCompound nbtCompound = this.getDefaultStack().getOrCreateNbt();
        nbtCompound.putInt("color", ColoredBlocksConstants.MIN_COLOR_VALUE);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(ColoredBlocksUtils.stringToText("Right click on colorable blocks to use!",Formatting.AQUA));
            tooltip.add(ColoredBlocksUtils.stringToText("Shift right click to change colors!",Formatting.GREEN));
        } else {
            tooltip.add(ColoredBlocksUtils.stringToText("Color: "+ColoredBlocksUtils.getColorName(getPaintbrushColor(stack)),Formatting.WHITE));
            tooltip.add(ColoredBlocksUtils.stringToText("Press shift for more info",Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        //If not server, holding shift, or use called with offHand
        if (world.isClient()
                || context.getHand() != Hand.MAIN_HAND) {
            return ActionResult.PASS;

        }
        ItemStack paintBrushStack = player.getMainHandStack();
        ItemStack paletteStack = player.getOffHandStack();
        //If one of the hand stacks gets nulled
        if (paintBrushStack == null || paletteStack == null || (world.isClient() && Screen.hasShiftDown())) {
            return ActionResult.PASS;
        }
        //If not holding artist palette in offHand
        if (paletteStack.getItem() != ModItems.ARTIST_PALETTE) {
            ColoredBlocksUtils.sendMessage(player, "Please hold an artist palette in your off-hand.");
            return ActionResult.PASS;
        }
        //If out of dye
        if (paletteStack.getDamage() >= paletteStack.getMaxDamage() && !player.isCreative()) {
            ColoredBlocksUtils.sendMessage(player, "Please add more dye to your palette.");
            return ActionResult.PASS;
        }
        int paintbrushColor = getPaintbrushColor(paintBrushStack);
        String paintColorName = ColoredBlocksUtils.getColorName(paintbrushColor);
        BlockPos blockLocation = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockLocation);
        //Can't be colored
        if (!ColoredBlocksUtils.isColorable(blockState)) {
            return ActionResult.PASS;
        }
        //If colored block and same color as desired
        if (ColoredBlocksUtils.isColorable(blockState) && ColoredBlocksUtils.isSameColor(blockState, paintbrushColor)) {
            ColoredBlocksUtils.sendMessage(player, "This block is already "+paintColorName);
            return ActionResult.PASS;
        }
        //Do coloring
        boolean didPaint = doPaintAction(world, blockLocation, blockState, paintbrushColor);
        //Do palette damage if not creative
        if (didPaint && !player.isCreative()) {
            doDamagePaletteAction(paletteStack);
        }
        return ActionResult.PASS;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient() && hand == Hand.MAIN_HAND && Screen.hasShiftDown()) {
            ModScreens.openColorWheelScreen(user, user.getMainHandStack());
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }
    private int getPaintbrushColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        return nbtCompound.getInt("color");
    }
    private void doDamagePaletteAction(ItemStack palette) {
        palette.setDamage(palette.getDamage() + 1);
    }
    private boolean doPaintAction(World world, BlockPos pos, BlockState blockState, int color) {
        BlockState newBlockState;
        if (blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICKS)) {
            newBlockState = ColoredBlocksConstants.COLORED_STONE_BRICKS[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_WOOD_PLANKS)) {
            newBlockState = ColoredBlocksConstants.COLORED_WOOD_PLANKS[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_WOOL_BLOCKS)) {
            newBlockState = ColoredBlocksConstants.COLORED_WOOL_BLOCKS[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_TERRACOTTA)) {
            newBlockState = ColoredBlocksConstants.COLORED_TERRACOTTA[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_GLAZED_TERRACOTTA)) {
            newBlockState = ColoredBlocksConstants.COLORED_GLAZED_TERRACOTTA[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_CONCRETE)) {
            newBlockState = ColoredBlocksConstants.COLORED_CONCRETE[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_STAINED_GLASS)) {
            newBlockState = ColoredBlocksConstants.COLORED_STAINED_GLASS[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_CARPET)) {
            newBlockState = ColoredBlocksConstants.COLORED_CARPET[color].getDefaultState();
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICK_STAIRS)) {
            newBlockState = ColoredBlocksUtils.cloneStairBlockStateProperties(blockState,
                ColoredBlocksConstants.COLORED_STONE_BRICK_STAIRS[color].getDefaultState());
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_WOOD_PLANK_STAIRS)) {
            newBlockState = ColoredBlocksUtils.cloneStairBlockStateProperties(blockState,
                ColoredBlocksConstants.COLORED_WOOD_PLANK_STAIRS[color].getDefaultState());
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICK_SLAB)) {
            newBlockState = ColoredBlocksUtils.cloneSlabBlockStateProperties(blockState,
                    ColoredBlocksConstants.COLORED_STONE_BRICK_SLAB[color].getDefaultState());
        } else if (blockState.isIn(CustomBlockTags.COLORABLE_WOOD_PLANK_SLAB)) {
            newBlockState = ColoredBlocksUtils.cloneSlabBlockStateProperties(blockState,
                    ColoredBlocksConstants.COLORED_WOOD_PLANK_SLAB[color].getDefaultState());
        } else {
            return false;
        }
        world.removeBlock(pos, false);
        world.setBlockState(pos, newBlockState);
        return true;
    }
}
