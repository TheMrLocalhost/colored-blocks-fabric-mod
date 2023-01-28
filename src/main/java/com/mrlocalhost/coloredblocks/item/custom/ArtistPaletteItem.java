package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArtistPaletteItem extends Item {
    public ArtistPaletteItem(Settings settings) {super(settings);}
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(ColoredBlocksUtils.stringToText("Equip in off-hand slot to use with paintbrush", Formatting.AQUA));
            tooltip.add(ColoredBlocksUtils.stringToText("Right click dye in main hand to replenish", Formatting.GREEN));
        } else {
            tooltip.add(ColoredBlocksUtils.stringToText((this.getMaxDamage()-stack.getDamage()) + "/" + (this.getMaxDamage() + " uses remaining"), Formatting.DARK_PURPLE));
            tooltip.add(ColoredBlocksUtils.stringToText("Press shift for more info",Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient() || hand == Hand.MAIN_HAND) {
            return TypedActionResult.pass(player.getStackInHand(hand));
        }
        ItemStack dyeStack = player.getMainHandStack();
        ItemStack paletteStack = player.getOffHandStack();
        if (dyeStack == null || paletteStack == null) {
            return TypedActionResult.pass(player.getStackInHand(hand));
        }
        if (!dyeStack.isIn(CustomItemTags.DYES)) {
            return TypedActionResult.pass(player.getStackInHand(hand));
        }
        if (!paletteStack.isDamaged()) {
            ColoredBlocksUtils.sendMessage(player, "Palette is already full");
            return TypedActionResult.pass(player.getStackInHand(hand));
        }
        paletteStack.setDamage(paletteStack.getDamage() - ColoredBlocksConstants.DYE_REPAIR_VALUE);
        if (!player.isCreative()) {
            dyeStack.decrement(1);
        }
        return TypedActionResult.pass(paletteStack);
    }
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }
    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClient()) {
            stack.setDamage(ColoredBlocksConstants.MAX_PALETTE_DAMAGE);
            ColoredBlocksUtils.sendMessage(player, "Bob Ross would be proud");
        }
    }
}
