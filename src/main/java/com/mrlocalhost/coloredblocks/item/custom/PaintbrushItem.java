package com.mrlocalhost.coloredblocks.item.custom;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.ModBlocks;
import com.mrlocalhost.coloredblocks.block.custom.ColoredBlock;
import com.mrlocalhost.coloredblocks.block.custom.ColoredStairsBlock;
import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import com.mrlocalhost.coloredblocks.block.entity.ColoredBlockEntity;
import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.networking.PacketHandler;
import com.mrlocalhost.coloredblocks.screen.ModScreens;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.HEX_COLOR_VALUES;

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
            tooltip.add(ColoredBlocksUtils.stringToText("Sneak right click to change colors!",Formatting.GREEN));
        } else {
            tooltip.add(ColoredBlocksUtils.stringToText("Color: "+ColoredBlocksUtils.getColorName(getPaintbrushColor(stack)),Formatting.WHITE));
            tooltip.add(ColoredBlocksUtils.stringToText("Press shift for more info",Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World indestinctWorld = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (player == null) {
            return ActionResult.FAIL;
        }
        //If client, sneaking, or use called with offHand
        if (indestinctWorld.isClient() || player.isSneaking() || context.getHand() != Hand.MAIN_HAND) {
            return ActionResult.PASS;
        }
        ServerWorld world = (ServerWorld) context.getWorld();
        ItemStack paintBrushStack = player.getMainHandStack();
        ItemStack paletteStack = player.getOffHandStack();
        //If one of the hand stacks gets nulled
        if (paintBrushStack == null || paletteStack == null) {
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
        boolean didPaint = doPaintAction(world, player, blockLocation, blockState, paintbrushColor);
        //Do palette damage if not creative
        if (didPaint && !player.isCreative()) {
            doDamagePaletteAction(paletteStack);
        }
        return ActionResult.PASS;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient() && hand == Hand.MAIN_HAND && user.isSneaking()) {
            ModScreens.openColorWheelScreen(user, user.getMainHandStack());
        }
        return TypedActionResult.consume(user.getStackInHand(hand));
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
    private boolean doPaintAction(ServerWorld world, PlayerEntity player, BlockPos pos, BlockState blockState, int color) {
        BlockState newBlockState;
        if (player.isSneaking()) {
            return false;
        } else if (
                   blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICKS)
                || blockState.isIn(CustomBlockTags.COLORABLE_STONE_BRICK_STAIRS)
                || blockState.isIn(CustomBlockTags.COLORED_STONE_BRICK_SLAB)

                || blockState.isIn(CustomBlockTags.COLORABLE_WOOD_PLANKS)
                || blockState.isIn(CustomBlockTags.COLORED_WOOD_PLANK_STAIRS)
                || blockState.isIn(CustomBlockTags.COLORED_WOOD_PLANK_SLAB)
            ) {
            ColoredBlockEntity entity = (ColoredBlockEntity) world.getBlockEntity(pos);
            if (entity == null) return false;
            entity.readRGB(color);
            entity.markDirty();
            PacketByteBuf bufData = PacketByteBufs.create();
            bufData.writeIntArray(new int[]{color, pos.getX(), pos.getY(), pos.getZ()});
            player.sendMessage(Text.literal("S: Attempting to sync entity data to client. new: "+color));
            player.sendMessage(Text.literal("server entity pos: "+pos.toShortString()));
            for (ServerPlayerEntity serverPlayerEntity : world.getPlayers()) {
                ServerPlayNetworking.send(serverPlayerEntity, PacketHandler.COLORED_BLOCK_ENTITY_COLOR_CHANGER_ID, bufData);
            }
            return true;
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
        } else {
            return false;
        }
        world.removeBlock(pos, false);
        world.setBlockState(pos, newBlockState);
        return true;
    }
}
