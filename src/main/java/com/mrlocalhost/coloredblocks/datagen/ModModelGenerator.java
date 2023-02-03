package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.COLORED_STONE_BRICKS;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.COLORED_WOOD_PLANKS;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (int i = 0; i<16; i++) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(COLORED_STONE_BRICKS[i]);
            blockStateModelGenerator.registerCubeAllModelTexturePool(COLORED_WOOD_PLANKS[i]);
        }
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CLEANING_CLOTH, Models.GENERATED);
    }
}
