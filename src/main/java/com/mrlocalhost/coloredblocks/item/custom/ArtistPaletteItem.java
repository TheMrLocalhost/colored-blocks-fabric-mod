package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
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

public class ArtistPaletteItem extends Item {
    public ArtistPaletteItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(ColoredBlocksUtils.stringToText("Right click on colorable blocks to use!",Formatting.AQUA));
            tooltip.add(ColoredBlocksUtils.stringToText("Shift right click to access color GUI!",Formatting.GREEN));
        } else {
            int damageRemaining = this.getMaxDamage()-stack.getDamage();
            tooltip.add(ColoredBlocksUtils.stringToText("Color: "+ColoredBlocksUtils.getColorName(getPaletteColor(stack)),Formatting.WHITE));
            tooltip.add(ColoredBlocksUtils.stringToText(damageRemaining+"/"+(this.getMaxDamage()+" uses remaining"),Formatting.DARK_PURPLE));
            tooltip.add(ColoredBlocksUtils.stringToText("Press shift for more info",Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // TODO add right click "use durability" and recolor targeted block

        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (!world.isClient() && context.getHand() == Hand.MAIN_HAND && !Screen.hasShiftDown()) { //Server side and mainHand only

            ItemStack mainHandStack = player.getMainHandStack();
            ItemStack offHandStack = player.getOffHandStack();
            if (mainHandStack == null || offHandStack == null) {
                return ActionResult.PASS;
            }
            Item offHandItem = offHandStack.getItem();
            BlockPos blockPos = context.getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();

            if (offHandItem == ModItems.PAINTBRUSH) {
                ItemStack palette = player.getMainHandStack();
                if (palette.getDamage() >= palette.getMaxDamage()) {
                    ColoredBlocksUtils.sendMessage(player, "Please add more dye to your palette.");
                } else {
                    //Can be colored and isn't already the same color
                    if (blockState.isIn(CustomBlockTags.COLORED_BLOCKS)
                            && blockState.get(ColoredBlock.COLOR) != getPaletteColor(mainHandStack)) {
                        int paletteColor = getPaletteColor(mainHandStack);
                        world.setBlockState(blockPos, blockState.with(ColoredBlock.COLOR, paletteColor));
                        palette.setDamage(palette.getDamage() + 1);
                        ColoredBlocksUtils.sendMessage(player, "Palette damage: " + palette.getDamage());
                        ColoredBlocksUtils.sendMessage(player, "Painted " + block.getName() + " at " + blockPos.toShortString());
                    } else {
                        ColoredBlocksUtils.sendMessage(player, "Tried coloring an invalid block");
                    }
                }
            } else { // else if (offHand != ModItems.PAINTBRUSH) {
                ColoredBlocksUtils.sendMessage(player, "Please hold a paintbrush in your off-hand.");
            }
        }

        return ActionResult.PASS;
    }

    private int getPaletteColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        return nbtCompound.getInt("color");

    }
    private void changePaletteColor(ItemStack stack, int color) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putInt("color", color);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // TODO add shift right click to open a GUI to select dye color
        if (!world.isClient() && hand == Hand.MAIN_HAND && Screen.hasShiftDown()) {
            ItemStack mainHandStack = user.getMainHandStack();
            int currentColor = getPaletteColor(mainHandStack);
            int nextColor = (currentColor != ColoredBlocksConstants.maxColorValue) ? currentColor + 1 : ColoredBlocksConstants.minColorValue;
            changePaletteColor(mainHandStack, nextColor);
            ColoredBlocksUtils.sendMessage(user, "New color: "+ColoredBlocksUtils.getColorName(getPaletteColor(mainHandStack)));
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }
    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClient()) {
            ColoredBlocksUtils.sendMessage(player, "Bob Ross would be proud");
        }
    }
}
