package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

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
    }

}
