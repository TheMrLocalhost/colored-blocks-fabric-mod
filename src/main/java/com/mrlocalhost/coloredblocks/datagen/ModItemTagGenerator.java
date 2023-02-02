package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;

import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.*;

public class ModItemTagGenerator extends FabricTagProvider<Item> {
    private static final TagKey<Item> COLORED_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_bricks"));
    private static final TagKey<Item> COLORABLE_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_stone_bricks"));

    private static final TagKey<Item> COLORED_WOOD_PLANKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_wood_planks"));
    private static final TagKey<Item> COLORABLE_WOOD_PLANKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_wood_planks"));

    private static final TagKey<Item> COLORED_WOOL_BLOCKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_wool_blocks"));
    private static final TagKey<Item> COLORABLE_WOOL_BLOCKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_wool_blocks"));

    private static final TagKey<Item> DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":dyes"));
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.ITEM, registryLookupFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (int i = 0; i<16; i++) {
            getOrCreateTagBuilder(COLORED_STONE_BRICKS_ITEM).add(COLORED_STONE_BRICKS[i].asItem());
            getOrCreateTagBuilder(COLORED_WOOD_PLANKS_ITEM).add(COLORED_WOOD_PLANKS[i].asItem());
            getOrCreateTagBuilder(COLORED_WOOL_BLOCKS_ITEM).add(COLORED_WOOL_BLOCKS[i].asItem());
            getOrCreateTagBuilder(DYES).add(DYE_ITEMS[i]);
        }
        getOrCreateTagBuilder(COLORABLE_STONE_BRICKS_ITEM)
                .add(Items.STONE_BRICKS)
                .addTag(COLORED_STONE_BRICKS_ITEM);
        getOrCreateTagBuilder(COLORABLE_WOOD_PLANKS_ITEM)
                .add(Items.BIRCH_PLANKS)
                .addTag(COLORED_WOOD_PLANKS_ITEM);
        getOrCreateTagBuilder(COLORABLE_WOOL_BLOCKS_ITEM)
                .add(Items.WHITE_WOOL)
                .addTag(COLORED_WOOL_BLOCKS_ITEM);
    }
}
