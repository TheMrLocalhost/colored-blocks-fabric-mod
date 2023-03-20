package com.mrlocalhost.coloredblocks.block.custom;

import com.mrlocalhost.coloredblocks.block.entity.ColoredBlockEntity;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.MAX_RGB_VALUE;

public class ColoredSlabBlock extends SlabBlock implements ColoredBlockInterface, BlockEntityProvider {
    private NbtCompound rgbValues;
    public ColoredSlabBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState());
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
        return super.getPlacementState(ctx);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        ColoredBlockInterface.appendTooltip(stack, world, tooltip, options);
    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        //TODO FIX (just gives white variant)
        return ColoredBlockInterface.getPickStack(world, pos, state);
    }
    /* BLOCK ENTITY SECTION */
    @Nullable
    @Override
    public ColoredBlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        ColoredBlockEntity coloredBlockEntity = new ColoredBlockEntity(pos, state);
        coloredBlockEntity.readNbt(
            ColoredBlocksUtils.rgbColorsToNbt(
                (rgbValues != null) ? rgbValues.getInt("red") : MAX_RGB_VALUE,
                (rgbValues != null) ? rgbValues.getInt("green") : MAX_RGB_VALUE,
                (rgbValues != null) ? rgbValues.getInt("blue") : MAX_RGB_VALUE
            )
        );
        return coloredBlockEntity;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
