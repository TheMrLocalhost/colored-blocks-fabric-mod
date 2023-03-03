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

//        translationBuilder.add(ModBlocks.RED_STONE_BRICK_SLAB,"Red Stone Brick Slab");
//        translationBuilder.add(ModBlocks.ORANGE_STONE_BRICK_SLAB,"Orange Stone Brick Slab");
//        translationBuilder.add(ModBlocks.YELLOW_STONE_BRICK_SLAB,"Yellow Stone Brick Slab");
//        translationBuilder.add(ModBlocks.LIME_STONE_BRICK_SLAB,"Lime Stone Brick Slab");
//        translationBuilder.add(ModBlocks.GREEN_STONE_BRICK_SLAB,"Green Stone Brick Slab");
//        translationBuilder.add(ModBlocks.CYAN_STONE_BRICK_SLAB,"Cyan Stone Brick Slab");
//        translationBuilder.add(ModBlocks.LIGHT_BLUE_STONE_BRICK_SLAB,"Light Blue Stone Brick Slab");
//        translationBuilder.add(ModBlocks.BLUE_STONE_BRICK_SLAB,"Blue Stone Brick Slab");
//        translationBuilder.add(ModBlocks.PURPLE_STONE_BRICK_SLAB,"Purple Stone Brick Slab");
//        translationBuilder.add(ModBlocks.MAGENTA_STONE_BRICK_SLAB,"Magenta Stone Brick Slab");
//        translationBuilder.add(ModBlocks.PINK_STONE_BRICK_SLAB,"Pink Stone Brick Slab");
//        translationBuilder.add(ModBlocks.BROWN_STONE_BRICK_SLAB,"Brown Stone Brick Slab");
//        translationBuilder.add(ModBlocks.WHITE_STONE_BRICK_SLAB,"White Stone Brick Slab");
//        translationBuilder.add(ModBlocks.LIGHT_GRAY_STONE_BRICK_SLAB,"Light Gray Stone Brick Slab");
//        translationBuilder.add(ModBlocks.GRAY_STONE_BRICK_SLAB,"Gray Stone Brick Slab");
//        translationBuilder.add(ModBlocks.BLACK_STONE_BRICK_SLAB,"Black Stone Brick Slab");
//
//        translationBuilder.add(ModBlocks.RED_WOOD_PLANK_SLAB,"Red Wood Plank Slab");
//        translationBuilder.add(ModBlocks.ORANGE_WOOD_PLANK_SLAB,"Orange Wood Plank Slab");
//        translationBuilder.add(ModBlocks.YELLOW_WOOD_PLANK_SLAB,"Yellow Wood Plank Slab");
//        translationBuilder.add(ModBlocks.LIME_WOOD_PLANK_SLAB,"Lime Wood Plank Slab");
//        translationBuilder.add(ModBlocks.GREEN_WOOD_PLANK_SLAB,"Green Wood Plank Slab");
//        translationBuilder.add(ModBlocks.CYAN_WOOD_PLANK_SLAB,"Cyan Wood Plank Slab");
//        translationBuilder.add(ModBlocks.LIGHT_BLUE_WOOD_PLANK_SLAB,"Light Blue Wood Plank Slab");
//        translationBuilder.add(ModBlocks.BLUE_WOOD_PLANK_SLAB,"Blue Wood Plank Slab");
//        translationBuilder.add(ModBlocks.PURPLE_WOOD_PLANK_SLAB,"Purple Wood Plank Slab");
//        translationBuilder.add(ModBlocks.MAGENTA_WOOD_PLANK_SLAB,"Magenta Wood Plank Slab");
//        translationBuilder.add(ModBlocks.PINK_WOOD_PLANK_SLAB,"Pink Wood Plank Slab");
//        translationBuilder.add(ModBlocks.BROWN_WOOD_PLANK_SLAB,"Brown Wood Plank Slab");
//        translationBuilder.add(ModBlocks.WHITE_WOOD_PLANK_SLAB,"White Wood Plank Slab");
//        translationBuilder.add(ModBlocks.LIGHT_GRAY_WOOD_PLANK_SLAB,"Light Gray Wood Plank Slab");
//        translationBuilder.add(ModBlocks.GRAY_WOOD_PLANK_SLAB,"Gray Wood Plank Slab");
//        translationBuilder.add(ModBlocks.BLACK_WOOD_PLANK_SLAB,"Black Wood Plank Slab");
    }
}
