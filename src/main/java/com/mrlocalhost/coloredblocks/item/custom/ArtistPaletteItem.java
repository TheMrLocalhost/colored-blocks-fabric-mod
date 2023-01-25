package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArtistPaletteItem extends Item {
    public ArtistPaletteItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // TODO add right click "use durability" and recolor targeted block

        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (!world.isClient()) { //Server

            Item mainHand = player.getMainHandStack().getItem();
            Item offHand = player.getOffHandStack().getItem();
            BlockPos blockPos = context.getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();
            //player.sendMessage(Text.literal("mainHand: " + mainHand.getName()));
            //player.sendMessage(Text.literal("offHand: " + offHand.getName()));
            //player.sendMessage(Text.literal("blockPos: " + blockPos.toShortString()));
            //player.sendMessage(Text.literal("block: " + b.getName()));

            if (mainHand == ModItems.ARTIST_PALETTE && offHand == Items.STICK) {
                ItemStack palette = player.getMainHandStack();
                if (palette.getDamage() >= palette.getMaxDamage()) {
                    player.sendMessage(Text.literal("Please add more dye to your palette."));
                } else {
                    palette.setDamage(palette.getDamage() + 1);
                    player.sendMessage(Text.literal("Palette damage: " + palette.getDamage()));
                    player.sendMessage(Text.literal("Painted " + block.getName() + " at " + blockPos.toShortString()));
                }
            }


        }

        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // TODO add shift right click to open a GUI to select dye color
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isIn(ItemTags.DYES);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClient()) {
            player.sendMessage(Text.literal("Bob Ross would be proud"));
        }

    }

}
