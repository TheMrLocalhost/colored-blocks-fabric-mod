package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import com.mrlocalhost.coloredblocks.item.ModItemGroup;
import com.mrlocalhost.coloredblocks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangGenerator extends FabricLanguageProvider {

    protected ModLangGenerator(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItemGroup.COLORED_BLOCKS_GROUP, "Colored Blocks");

        translationBuilder.add(ModItems.ARTIST_PALETTE, "Artist Palette");
        translationBuilder.add(ModItems.PAINTBRUSH, "Paintbrush");
        translationBuilder.add(ModItems.CLEANING_CLOTH, "Cleaning Cloth");

        translationBuilder.add(ModBlocks.COLORED_STONE_BRICKS, "Colored Stone Bricks");
        translationBuilder.add(ModBlocks.COLORED_WOOD_PLANKS, "Colored Wood Planks");

        translationBuilder.add(ModBlocks.COLORED_STONE_BRICK_STAIRS, "Colored Stone Brick Stairs");
        translationBuilder.add(ModBlocks.COLORED_WOOD_PLANK_STAIRS, "Colored Wood Plank Stairs");

        translationBuilder.add(ModBlocks.COLORED_STONE_BRICK_SLAB, "Colored Stone Brick Slab");
        translationBuilder.add(ModBlocks.COLORED_WOOD_PLANK_SLAB, "Colored Wood Plank Slab");
    }
}
