package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COLORED_STONE_BRICKS);
        //blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COLORED_WOOD_PLANKS);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CLEANING_CLOTH, Models.GENERATED);
    }
//    private static void registerSlabs(String colorName, BlockStateModelGenerator generator, Block block, String sourceTextureSuffix, String slabNaming) {
//        //Generate Block States
//        BlockStateSupplier stoneBlockStairsSupplier = BlockStateModelGenerator.createSlabBlockState(
//                block,
//                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+slabNaming),
//                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+slabNaming+"_top"),
//                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+sourceTextureSuffix)
//        );
//        generator.blockStateCollector.accept(stoneBlockStairsSupplier);
//        //Generate Models
//        TextureMap textureMap = ColoredBlocksUtils.createSlabTextureMap(colorName, sourceTextureSuffix);
//        Models.SLAB.upload(block, textureMap, generator.modelCollector);
//        Models.SLAB_TOP.upload(block, textureMap, generator.modelCollector);
//    }
//    private static void registerStairs(String colorName, BlockStateModelGenerator generator, Block block, String sourceTextureSuffix, String stairsNaming) {
//        //Generate Block States
//        BlockStateSupplier stoneBlockStairsSupplier = BlockStateModelGenerator.createStairsBlockState(
//                block,
//                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+stairsNaming+"_inner"),
//                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+stairsNaming),
//                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorName+"_"+stairsNaming+"_outer")
//        );
//        generator.blockStateCollector.accept(stoneBlockStairsSupplier);
//        //Generate Models
//        TextureMap textureMap = ColoredBlocksUtils.createStairsTextureMap(colorName, sourceTextureSuffix);
//        Models.STAIRS.upload(block, textureMap, generator.modelCollector);
//        Models.INNER_STAIRS.upload(block, textureMap, generator.modelCollector);
//        Models.OUTER_STAIRS.upload(block, textureMap, generator.modelCollector);
//    }
}
