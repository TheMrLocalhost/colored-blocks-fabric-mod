package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.item.ModItems;
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
            //Regular blocks
            blockStateModelGenerator.registerCubeAllModelTexturePool(COLORED_STONE_BRICKS[i]);
            blockStateModelGenerator.registerCubeAllModelTexturePool(COLORED_WOOD_PLANKS[i]);
            //Stair blocks
            registerStairs(i,blockStateModelGenerator,COLORED_STONE_BRICK_STAIRS[i], "stone_bricks","stone_brick_stairs");
            registerStairs(i,blockStateModelGenerator,COLORED_WOOD_PLANK_STAIRS[i], "wood_planks","wood_plank_stairs");
        }
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CLEANING_CLOTH, Models.GENERATED);
    }
    private static void registerStairs(int colorIdx, BlockStateModelGenerator generator, Block block, String sourceTextureSuffix, String stairsNaming) {
        String colorPrefix = COLOR_MAP.get(colorIdx);
        //Generate Block States
        BlockStateSupplier stoneBlockStairsSupplier = BlockStateModelGenerator.createStairsBlockState(
                block,
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorPrefix+"_"+stairsNaming+"_inner"),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorPrefix+"_"+stairsNaming),
                new Identifier(ColoredBlocks.MOD_ID, "block/"+colorPrefix+"_"+stairsNaming+"_outer")
        );
        generator.blockStateCollector.accept(stoneBlockStairsSupplier);
        //Generate Models
        TextureMap textureMap = createStairsTextureMap(COLOR_MAP.get(colorIdx), sourceTextureSuffix);
        Models.STAIRS.upload(block, textureMap, generator.modelCollector);
        Models.INNER_STAIRS.upload(block, textureMap, generator.modelCollector);
        Models.OUTER_STAIRS.upload(block, textureMap, generator.modelCollector);
    }
    private static TextureMap createStairsTextureMap(String colorPrefix, String sourceTextureSuffix) {
        TextureMap stairsTextureMap = new TextureMap();
        Identifier id = new Identifier(ColoredBlocks.MOD_ID,"block/"+colorPrefix+"_"+sourceTextureSuffix);
        stairsTextureMap.put(TextureKey.TOP, id);
        stairsTextureMap.put(TextureKey.SIDE, id);
        stairsTextureMap.put(TextureKey.BOTTOM, id);
        return stairsTextureMap;
    }
}
