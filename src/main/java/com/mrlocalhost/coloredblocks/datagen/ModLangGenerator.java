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

        translationBuilder.add(ModBlocks.RED_STONE_BRICKS,"Red Stone Bricks");
        translationBuilder.add(ModBlocks.ORANGE_STONE_BRICKS,"Orange Stone Bricks");
        translationBuilder.add(ModBlocks.YELLOW_STONE_BRICKS,"Yellow Stone Bricks");
        translationBuilder.add(ModBlocks.LIME_STONE_BRICKS,"Lime Stone Bricks");
        translationBuilder.add(ModBlocks.GREEN_STONE_BRICKS,"Green Stone Bricks");
        translationBuilder.add(ModBlocks.CYAN_STONE_BRICKS,"Cyan Stone Bricks");
        translationBuilder.add(ModBlocks.LIGHT_BLUE_STONE_BRICKS,"Light Blue Stone Bricks");
        translationBuilder.add(ModBlocks.BLUE_STONE_BRICKS,"Blue Stone Bricks");
        translationBuilder.add(ModBlocks.PURPLE_STONE_BRICKS,"Purple Stone Bricks");
        translationBuilder.add(ModBlocks.MAGENTA_STONE_BRICKS,"Magenta Stone Bricks");
        translationBuilder.add(ModBlocks.PINK_STONE_BRICKS,"Pink Stone Bricks");
        translationBuilder.add(ModBlocks.BROWN_STONE_BRICKS,"Brown Stone Bricks");
        translationBuilder.add(ModBlocks.WHITE_STONE_BRICKS,"White Stone Bricks");
        translationBuilder.add(ModBlocks.LIGHT_GRAY_STONE_BRICKS,"Light Gray Stone Bricks");
        translationBuilder.add(ModBlocks.GRAY_STONE_BRICKS,"Gray Stone Bricks");
        translationBuilder.add(ModBlocks.BLACK_STONE_BRICKS,"Black Stone Bricks");

    }
}
