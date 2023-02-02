package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RED_STONE_BRICKS);
        addDrop(ModBlocks.RED_STONE_BRICKS);
        addDrop(ModBlocks.ORANGE_STONE_BRICKS);
        addDrop(ModBlocks.YELLOW_STONE_BRICKS);
        addDrop(ModBlocks.LIME_STONE_BRICKS);
        addDrop(ModBlocks.GREEN_STONE_BRICKS);
        addDrop(ModBlocks.CYAN_STONE_BRICKS);
        addDrop(ModBlocks.LIGHT_BLUE_STONE_BRICKS);
        addDrop(ModBlocks.BLUE_STONE_BRICKS);
        addDrop(ModBlocks.PURPLE_STONE_BRICKS);
        addDrop(ModBlocks.MAGENTA_STONE_BRICKS);
        addDrop(ModBlocks.PINK_STONE_BRICKS);
        addDrop(ModBlocks.BROWN_STONE_BRICKS);
        addDrop(ModBlocks.WHITE_STONE_BRICKS);
        addDrop(ModBlocks.LIGHT_GRAY_STONE_BRICKS);
        addDrop(ModBlocks.GRAY_STONE_BRICKS);
        addDrop(ModBlocks.BLACK_STONE_BRICKS);

        addDrop(ModBlocks.RED_WOOD_PLANKS);
        addDrop(ModBlocks.RED_WOOD_PLANKS);
        addDrop(ModBlocks.ORANGE_WOOD_PLANKS);
        addDrop(ModBlocks.YELLOW_WOOD_PLANKS);
        addDrop(ModBlocks.LIME_WOOD_PLANKS);
        addDrop(ModBlocks.GREEN_WOOD_PLANKS);
        addDrop(ModBlocks.CYAN_WOOD_PLANKS);
        addDrop(ModBlocks.LIGHT_BLUE_WOOD_PLANKS);
        addDrop(ModBlocks.BLUE_WOOD_PLANKS);
        addDrop(ModBlocks.PURPLE_WOOD_PLANKS);
        addDrop(ModBlocks.MAGENTA_WOOD_PLANKS);
        addDrop(ModBlocks.PINK_WOOD_PLANKS);
        addDrop(ModBlocks.BROWN_WOOD_PLANKS);
        addDrop(ModBlocks.WHITE_WOOD_PLANKS);
        addDrop(ModBlocks.LIGHT_GRAY_WOOD_PLANKS);
        addDrop(ModBlocks.GRAY_WOOD_PLANKS);
        addDrop(ModBlocks.BLACK_WOOD_PLANKS);
    }

}
