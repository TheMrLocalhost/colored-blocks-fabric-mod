package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.ModBlocks;
import com.mrlocalhost.coloredblocks.block.model.ColoredBlockModels;
import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        registerColoredBlock(blockStateModelGenerator, ModBlocks.COLORED_STONE_BRICKS, "colored_stone_bricks");
        registerColoredBlock(blockStateModelGenerator, ModBlocks.COLORED_WOOD_PLANKS, "colored_wood_planks");

        registerColoredStairs(blockStateModelGenerator, ModBlocks.COLORED_STONE_BRICK_STAIRS, "colored_stone_bricks", "colored_stone_brick_stairs");
        registerColoredStairs(blockStateModelGenerator, ModBlocks.COLORED_WOOD_PLANK_STAIRS, "colored_wood_planks", "colored_wood_plank_stairs");

        registerColoredSlabs(blockStateModelGenerator, ModBlocks.COLORED_STONE_BRICK_SLAB, "colored_stone_bricks", "colored_stone_brick_slab");
        registerColoredSlabs(blockStateModelGenerator, ModBlocks.COLORED_WOOD_PLANK_SLAB, "colored_wood_planks", "colored_wood_plank_slab");
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CLEANING_CLOTH, Models.GENERATED);
    }
    private static void registerColoredBlock(BlockStateModelGenerator generator, Block block, String blockName) {
        BlockStateSupplier supplier = BlockStateModelGenerator.createSingletonBlockState(
                block,
                new Identifier(ColoredBlocks.MOD_ID, "block/"+blockName)
        );
        generator.blockStateCollector.accept(supplier);
        TextureMap textureMap = ColoredBlocksUtils.createColoredBlockTextureMap(block, blockName);
        ColoredBlockModels.COLORED_BLOCK.upload(block, textureMap, generator.modelCollector);
    }
    private static void registerColoredSlabs(BlockStateModelGenerator generator, Block block, String sourceBlockNaming ,String slabNaming) {
        //Generate Block States
        BlockStateSupplier stoneBlockStairsSupplier = BlockStateModelGenerator.createSlabBlockState(
                block,
                new Identifier(ColoredBlocks.MOD_ID, "block/"+slabNaming),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+slabNaming+"_top"),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+sourceBlockNaming)
        );
        generator.blockStateCollector.accept(stoneBlockStairsSupplier);
        //Generate Models
        TextureMap textureMap = ColoredBlocksUtils.createSlabTextureMap(sourceBlockNaming);
        ColoredBlockModels.COLORED_SLAB.upload(block, textureMap, generator.modelCollector);
        ColoredBlockModels.COLORED_SLAB_TOP.upload(block, textureMap, generator.modelCollector);
    }
    private static void registerColoredStairs(BlockStateModelGenerator generator, Block block, String sourceBlockNaming, String stairsNaming) {
        //Generate Block States
        BlockStateSupplier stoneBlockStairsSupplier = BlockStateModelGenerator.createStairsBlockState(
                block,
                new Identifier(ColoredBlocks.MOD_ID, "block/"+stairsNaming+"_inner"),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+stairsNaming),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+stairsNaming+"_outer")
        );
        generator.blockStateCollector.accept(stoneBlockStairsSupplier);
        //Generate Models
        TextureMap textureMap = ColoredBlocksUtils.createStairsTextureMap(sourceBlockNaming);
        ColoredBlockModels.COLORED_STAIRS.upload(block, textureMap, generator.modelCollector);
        ColoredBlockModels.COLORED_STAIRS_INNER.upload(block, textureMap, generator.modelCollector);
        ColoredBlockModels.COLORED_STAIRS_OUTER.upload(block, textureMap, generator.modelCollector);
    }
}
