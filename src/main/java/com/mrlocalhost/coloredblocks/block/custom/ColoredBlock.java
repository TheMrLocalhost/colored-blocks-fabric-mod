package com.mrlocalhost.coloredblocks.block.custom;

import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.MAX_RGB_VALUE;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.MIN_RGB_VALUE;

public class ColoredBlock extends Block {

    public static final IntProperty RED = IntProperty.of("red", MIN_RGB_VALUE, MAX_RGB_VALUE);
    public static final IntProperty GREEN = IntProperty.of("green", MIN_RGB_VALUE, MAX_RGB_VALUE);
    public static final IntProperty BLUE = IntProperty.of("blue", MIN_RGB_VALUE, MAX_RGB_VALUE);
    public ColoredBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
            .with(RED, MAX_RGB_VALUE)
            .with(GREEN, MAX_RGB_VALUE)
            .with(BLUE, MAX_RGB_VALUE));
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        String langAppend = "";
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains("red")) {
            langAppend = "Uncolored";
        } else {
            String red = Integer.toHexString(nbt.getInt("red"));
            String green = Integer.toHexString(nbt.getInt("green"));
            String blue = Integer.toHexString(nbt.getInt("blue"));
            langAppend += "#"+(red + green + blue).toUpperCase();
        }
        tooltip.add(Text.literal(langAppend));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(RED);
        builder.add(GREEN);
        builder.add(BLUE);
    }
    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.afterBreak(world, player, pos, state, blockEntity, stack);
    }
    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        PlayerEntity player = ctx.getPlayer();
        if (player == null) { return null; }
        Hand activeHand = player.getActiveHand();
        ItemStack stack = player.getStackInHand(activeHand);
        return ColoredBlocksUtils.colorItemToBlock(this, stack);
    }
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        if (player.isCreative()) { return; }
        ItemStack itemStack = ColoredBlocksUtils.colorBlockToItem(state);
        ItemEntity itemEntity = new ItemEntity(world,(double)pos.getX() + 0.5,(double)pos.getY() + 0.5,(double)pos.getZ() + 0.5,itemStack);
        itemEntity.setToDefaultPickupDelay();
        world.spawnEntity(itemEntity);
    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return ColoredBlocksUtils.colorBlockToItem(state);
    }
}
