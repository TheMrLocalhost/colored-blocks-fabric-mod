package com.mrlocalhost.coloredblocks.block.custom;

import com.mrlocalhost.coloredblocks.block.entity.ColoredBlockEntity;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class ColoredSlabBlock extends SlabBlock implements ColoredBlockInterface {

    public ColoredSlabBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState());
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
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        PlayerEntity player = ctx.getPlayer();
        if (player == null) { return null; }
        Hand activeHand = player.getActiveHand();
        ItemStack stack = player.getStackInHand(activeHand);
        return ColoredBlocksUtils.colorItemToBlock(this, stack);
    }
    /* BLOCK ENTITY SECTION */
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ColoredBlockEntity(pos, state);
    }
}
