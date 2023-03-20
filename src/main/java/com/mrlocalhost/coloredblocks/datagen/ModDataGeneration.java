package com.mrlocalhost.coloredblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        fabricDataGenerator.addProvider(ModLootTableGenerator::new);
        fabricDataGenerator.addProvider(ModRecipeGenerator::new);
        fabricDataGenerator.addProvider(ModModelGenerator::new);
        fabricDataGenerator.addProvider(ModItemTagGenerator::new);
        fabricDataGenerator.addProvider(ModBlockTagGenerator::new);
        fabricDataGenerator.addProvider(ModLangGenerator::new);
    }
}
