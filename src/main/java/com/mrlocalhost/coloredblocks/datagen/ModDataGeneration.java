package com.mrlocalhost.coloredblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        //TODO reimplement after custom recipes work
        //pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModItemTagGenerator::new);
        pack.addProvider(ModBlockTagGenerator::new);
        pack.addProvider(ModLangGenerator::new);
    }
}
