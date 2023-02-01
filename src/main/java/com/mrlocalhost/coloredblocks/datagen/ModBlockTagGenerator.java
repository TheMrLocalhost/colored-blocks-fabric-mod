package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider<Block> {

    private static final TagKey<Block> COLORED_STONE_BRICKS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_bricks"));
    private static final TagKey<Block> MINEABLE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft:mineable/pickaxe"));

    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.BLOCK, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (Block block : ColoredBlocksConstants.COLORED_STONE_BRICKS) {
            getOrCreateTagBuilder(COLORED_STONE_BRICKS_BLOCK).add(block);
            getOrCreateTagBuilder(MINEABLE_BLOCKS).add(block);
        }
    }
}
