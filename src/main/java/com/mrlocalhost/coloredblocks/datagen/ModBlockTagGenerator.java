package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider<Block> {

    private static final TagKey<Block> COLORED_STONE_BRICKS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_bricks"));
    private static final TagKey<Block> COLORED_WOOD_PLANKS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_wood_planks"));

    private static final TagKey<Block> COLORABLE_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_stone_bricks"));
    private static final TagKey<Block> COLORABLE_WOOD_PLANKS_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_wood_planks"));

    private static final TagKey<Block> MINEABLE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft:mineable/pickaxe"));
    private static final TagKey<Block> AXEABLE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft:mineable/axe"));

    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.BLOCK, registryLookupFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (Block block : ColoredBlocksConstants.COLORED_STONE_BRICKS) {
            getOrCreateTagBuilder(COLORED_STONE_BRICKS_BLOCK).add(block);
            getOrCreateTagBuilder(MINEABLE_BLOCKS).add(block);
        }
        for (Block block : ColoredBlocksConstants.COLORED_WOOD_PLANKS) {
            getOrCreateTagBuilder(COLORED_WOOD_PLANKS_BLOCK).add(block);
            getOrCreateTagBuilder(AXEABLE_BLOCKS).add(block);
        }
        getOrCreateTagBuilder(COLORABLE_STONE_BRICKS_ITEM)
                .add(Blocks.STONE_BRICKS)
                .addTag(COLORED_STONE_BRICKS_BLOCK);
        getOrCreateTagBuilder(COLORABLE_WOOD_PLANKS_ITEM)
                .add(Blocks.BIRCH_PLANKS)
                .addTag(COLORED_WOOD_PLANKS_BLOCK);
    }
}
