package com.mrlocalhost.coloredblocks.block.custom;

import com.mrlocalhost.coloredblocks.block.entity.ColoredBlockEntity;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.MAX_RGB_VALUE;

public class ColoredBlock extends BlockWithEntity implements ColoredBlockInterface {
    private NbtCompound rgbValues;
    public ColoredBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState());
        rgbValues = ColoredBlocksUtils.rgbColorsToNbt(MAX_RGB_VALUE, MAX_RGB_VALUE, MAX_RGB_VALUE);
    }
    public void updateRGB(int red, int green, int blue) {
        rgbValues = ColoredBlocksUtils.rgbColorsToNbt(
                Math.min(red,MAX_RGB_VALUE),
                Math.min(green,MAX_RGB_VALUE),
                Math.min(blue,MAX_RGB_VALUE)
        );
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        if (player.isCreative()) { return; }
        ColoredBlockEntity entity = (ColoredBlockEntity) world.getBlockEntity(pos);
        if (entity == null) { return; }
        ItemStack itemStack = ColoredBlocksUtils.colorEntityMaptoItem(entity, state);
        entity.markRemoved();
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
        rgbValues = ColoredBlocksUtils.colorItemToNbt(stack);
        return this.getDefaultState();
    }

    /* BLOCK ENTITY SECTION */

    @Nullable
    @Override
    public ColoredBlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        ColoredBlockEntity coloredBlockEntity = new ColoredBlockEntity(pos, state);
        coloredBlockEntity.readNbt(
            ColoredBlocksUtils.rgbColorsToNbt(
                rgbValues.getInt("red"),
                rgbValues.getInt("green"),
                rgbValues.getInt("blue")
            )
        );
        return coloredBlockEntity;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
