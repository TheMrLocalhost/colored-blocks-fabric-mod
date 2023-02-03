package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.*;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (int i = 0; i<16; i++) {
            String colorPrefix = COLOR_MAP.get(i);
            //Regular blocks
            blockStateModelGenerator.registerCubeAllModelTexturePool(COLORED_STONE_BRICKS[i]);
            blockStateModelGenerator.registerCubeAllModelTexturePool(COLORED_WOOD_PLANKS[i]);
            //Stair blocks
            registerStairs(colorPrefix,blockStateModelGenerator,COLORED_STONE_BRICK_STAIRS[i], "stone_bricks","stone_brick_stairs");
            registerStairs(colorPrefix,blockStateModelGenerator,COLORED_WOOD_PLANK_STAIRS[i], "wood_planks","wood_plank_stairs");
            //Slab blocks
            registerSlabs(colorPrefix,blockStateModelGenerator,COLORED_STONE_BRICK_SLAB[i], "stone_bricks","stone_brick_slab");
            registerSlabs(colorPrefix,blockStateModelGenerator,COLORED_WOOD_PLANK_SLAB[i], "wood_planks","wood_plank_slab");
        }
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CLEANING_CLOTH, Models.GENERATED);
    }
    private static void registerSlabs(String colorName, BlockStateModelGenerator generator, Block block, String sourceTextureSuffix, String slabNaming) {
        //Generate Block States
        BlockStateSupplier stoneBlockStairsSupplier = BlockStateModelGenerator.createSlabBlockState(
                block,
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+slabNaming),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+slabNaming+"_top"),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+sourceTextureSuffix)
        );
        generator.blockStateCollector.accept(stoneBlockStairsSupplier);
        //Generate Models
        TextureMap textureMap = ColoredBlocksUtils.createSlabTextureMap(colorName, sourceTextureSuffix);
        Models.SLAB.upload(block, textureMap, generator.modelCollector);
        Models.SLAB_TOP.upload(block, textureMap, generator.modelCollector);
    }
    private static void registerStairs(String colorName, BlockStateModelGenerator generator, Block block, String sourceTextureSuffix, String stairsNaming) {
        //Generate Block States
        BlockStateSupplier stoneBlockStairsSupplier = BlockStateModelGenerator.createStairsBlockState(
                block,
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+stairsNaming+"_inner"),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+stairsNaming),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+stairsNaming+"_outer")
        );
        generator.blockStateCollector.accept(stoneBlockStairsSupplier);
        //Generate Models
        TextureMap textureMap = ColoredBlocksUtils.createStairsTextureMap(colorName, sourceTextureSuffix);
        Models.STAIRS.upload(block, textureMap, generator.modelCollector);
        Models.INNER_STAIRS.upload(block, textureMap, generator.modelCollector);
        Models.OUTER_STAIRS.upload(block, textureMap, generator.modelCollector);
    }
}
