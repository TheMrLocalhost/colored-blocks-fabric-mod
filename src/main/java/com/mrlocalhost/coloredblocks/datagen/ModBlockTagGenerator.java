package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.*;

public class ModBlockTagGenerator extends FabricTagProvider<Block> {

    private static final TagKey<Block> COLORED_STONE_BRICKS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_bricks"));
    private static final TagKey<Block> COLORABLE_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_stone_bricks"));

    private static final TagKey<Block> COLORED_WOOD_PLANKS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_wood_planks"));
    private static final TagKey<Block> COLORABLE_WOOD_PLANKS_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_wood_planks"));

    private static final TagKey<Block> COLORED_WOOL_BLOCKS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_wool_blocks"));
    private static final TagKey<Block> COLORABLE_WOOL_BLOCKS_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_wool_blocks"));

    private static final TagKey<Block> COLORED_TERRACOTTA_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_terracotta"));
    private static final TagKey<Block> COLORABLE_TERRACOTTA_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_terracotta"));

    private static final TagKey<Block> COLORED_GLAZED_TERRACOTTA_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_glazed_terracotta"));
    private static final TagKey<Block> COLORABLE_GLAZED_TERRACOTTA_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_glazed_terracotta"));

    private static final TagKey<Block> COLORED_CONCRETE_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_concrete"));
    private static final TagKey<Block> COLORABLE_CONCRETE_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_concrete"));

    private static final TagKey<Block> COLORED_STAINED_GLASS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_stained_glass"));
    private static final TagKey<Block> COLORABLE_STAINED_GLASS_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_stained_glass"));

    private static final TagKey<Block> COLORED_CARPET_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_carpet"));
    private static final TagKey<Block> COLORABLE_CARPET_ITEM = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colorable_carpet"));

    private static final TagKey<Block> MINEABLE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft:mineable/pickaxe"));
    private static final TagKey<Block> AXEABLE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft:mineable/axe"));

    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.BLOCK, registryLookupFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (Block block : COLORED_STONE_BRICKS) {
            getOrCreateTagBuilder(COLORED_STONE_BRICKS_BLOCK).add(block);
            getOrCreateTagBuilder(MINEABLE_BLOCKS).add(block);
        }
        for (Block block : COLORED_WOOD_PLANKS) {
            getOrCreateTagBuilder(COLORED_WOOD_PLANKS_BLOCK).add(block);
            getOrCreateTagBuilder(AXEABLE_BLOCKS).add(block);
        }
        for (Block block : COLORED_WOOL_BLOCKS) {
            getOrCreateTagBuilder(COLORED_WOOL_BLOCKS_BLOCK).add(block);
        }
        for (Block block : COLORED_TERRACOTTA) {
            getOrCreateTagBuilder(COLORED_TERRACOTTA_BLOCK).add(block);
        }
        for (Block block : COLORED_GLAZED_TERRACOTTA) {
            getOrCreateTagBuilder(COLORED_GLAZED_TERRACOTTA_BLOCK).add(block);
        }
        for (Block block : COLORED_CONCRETE) {
            getOrCreateTagBuilder(COLORED_CONCRETE_BLOCK).add(block);
        }
        for (Block block : COLORED_STAINED_GLASS) {
            getOrCreateTagBuilder(COLORED_STAINED_GLASS_BLOCK).add(block);
        }
        for (Block block : COLORED_CARPET) {
            getOrCreateTagBuilder(COLORED_CARPET_BLOCK).add(block);
        }
        getOrCreateTagBuilder(COLORABLE_STONE_BRICKS_ITEM)
                .add(Blocks.STONE_BRICKS)
                .addTag(COLORED_STONE_BRICKS_BLOCK);
        getOrCreateTagBuilder(COLORABLE_WOOD_PLANKS_ITEM)
                .add(Blocks.BIRCH_PLANKS)
                .addTag(COLORED_WOOD_PLANKS_BLOCK);
        getOrCreateTagBuilder(COLORABLE_WOOL_BLOCKS_ITEM)
                .add(Blocks.WHITE_WOOL)
                .addTag(COLORED_WOOL_BLOCKS_BLOCK);
        getOrCreateTagBuilder(COLORABLE_TERRACOTTA_ITEM)
                .add(Blocks.TERRACOTTA)
                .addTag(COLORED_TERRACOTTA_BLOCK);
        getOrCreateTagBuilder(COLORABLE_GLAZED_TERRACOTTA_ITEM)
                .add(Blocks.WHITE_GLAZED_TERRACOTTA)
                .addTag(COLORED_GLAZED_TERRACOTTA_BLOCK);
        getOrCreateTagBuilder(COLORABLE_CONCRETE_ITEM)
                .add(Blocks.WHITE_CONCRETE)
                .addTag(COLORED_CONCRETE_BLOCK);
        getOrCreateTagBuilder(COLORABLE_STAINED_GLASS_ITEM)
                .add(Blocks.GLASS)
                .addTag(COLORED_STAINED_GLASS_BLOCK);
        getOrCreateTagBuilder(COLORABLE_CARPET_ITEM)
                .add(Blocks.WHITE_CARPET)
                .addTag(COLORED_CARPET_BLOCK);
    }
}
