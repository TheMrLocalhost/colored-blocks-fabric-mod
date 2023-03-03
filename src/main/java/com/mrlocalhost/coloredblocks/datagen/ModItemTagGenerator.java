package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.ModBlocks;
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
    //Regular Blocks
    private static final TagKey<Item> COLORED_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_bricks"));
    private static final TagKey<Item> COLORABLE_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_stone_bricks"));
    private static final TagKey<Item> COLORED_WOOD_PLANKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_wood_planks"));
    private static final TagKey<Item> COLORABLE_WOOD_PLANKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_wood_planks"));
    private static final TagKey<Item> COLORED_WOOL_BLOCKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_wool_blocks"));
    private static final TagKey<Item> COLORABLE_WOOL_BLOCKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_wool_blocks"));
    private static final TagKey<Item> COLORED_TERRACOTTA_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_terracotta"));
    private static final TagKey<Item> COLORABLE_TERRACOTTA_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_terracotta"));
    private static final TagKey<Item> COLORED_GLAZED_TERRACOTTA_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_glazed_terracotta"));
    private static final TagKey<Item> COLORABLE_GLAZED_TERRACOTTA_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_glazed_terracotta"));
    private static final TagKey<Item> COLORED_CONCRETE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_concrete"));
    private static final TagKey<Item> COLORABLE_CONCRETE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_concrete"));
    private static final TagKey<Item> COLORED_STAINED_GLASS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_stained_glass"));
    private static final TagKey<Item> COLORABLE_STAINED_GLASS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_stained_glass"));
    private static final TagKey<Item> COLORED_CARPET_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_carpet"));
    private static final TagKey<Item> COLORABLE_CARPET_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_carpet"));
//    //Stair Blocks
    private static final TagKey<Item> COLORED_STONE_BRICK_STAIRS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_brick_stairs"));
    private static final TagKey<Item> COLORABLE_STONE_BRICK_STAIRS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_stone_brick_stairs"));
    private static final TagKey<Item> COLORED_WOOD_PLANK_STAIRS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_wood_plank_stairs"));
    private static final TagKey<Item> COLORABLE_WOOD_PLANK_STAIRS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_wood_plank_stairs"));
//    //Stair Blocks
    private static final TagKey<Item> COLORED_STONE_BRICK_SLAB_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_brick_slab"));
    private static final TagKey<Item> COLORABLE_STONE_BRICK_SLAB_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_stone_brick_slab"));
    private static final TagKey<Item> COLORED_WOOD_PLANK_SLAB_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_wood_plank_slab"));
    private static final TagKey<Item> COLORABLE_WOOD_PLANK_SLAB_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_wood_plank_slab"));

    private static final TagKey<Item> DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":dyes"));
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.ITEM, registryLookupFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(COLORED_STONE_BRICKS_ITEM).add(ModBlocks.COLORED_STONE_BRICKS.asItem());
        getOrCreateTagBuilder(COLORED_STONE_BRICK_STAIRS_ITEM).add(ModBlocks.COLORED_STONE_BRICKS.asItem());
        getOrCreateTagBuilder(COLORED_STONE_BRICK_SLAB_ITEM).add(ModBlocks.COLORED_STONE_BRICKS.asItem());

        getOrCreateTagBuilder(COLORED_WOOD_PLANKS_ITEM).add(ModBlocks.COLORED_WOOD_PLANKS.asItem());
        getOrCreateTagBuilder(COLORED_WOOD_PLANK_STAIRS_ITEM).add(ModBlocks.COLORED_WOOD_PLANKS.asItem());
        getOrCreateTagBuilder(COLORED_WOOD_PLANK_SLAB_ITEM).add(ModBlocks.COLORED_WOOD_PLANKS.asItem());

        for (int i = 0; i<16; i++) {
            getOrCreateTagBuilder(COLORED_WOOL_BLOCKS_ITEM).add(COLORED_WOOL_BLOCKS[i].asItem());
            getOrCreateTagBuilder(COLORED_TERRACOTTA_ITEM).add(COLORED_TERRACOTTA[i].asItem());
            getOrCreateTagBuilder(COLORED_GLAZED_TERRACOTTA_ITEM).add(COLORED_GLAZED_TERRACOTTA[i].asItem());
            getOrCreateTagBuilder(COLORED_CONCRETE_ITEM).add(COLORED_CONCRETE[i].asItem());
            getOrCreateTagBuilder(COLORED_STAINED_GLASS_ITEM).add(COLORED_STAINED_GLASS[i].asItem());
            getOrCreateTagBuilder(COLORED_CARPET_ITEM).add(COLORED_CARPET[i].asItem());
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
        getOrCreateTagBuilder(COLORABLE_TERRACOTTA_ITEM)
                .add(Items.TERRACOTTA)
                .addTag(COLORED_TERRACOTTA_ITEM);
        getOrCreateTagBuilder(COLORABLE_GLAZED_TERRACOTTA_ITEM)
                .add(Items.WHITE_GLAZED_TERRACOTTA)
                .addTag(COLORED_GLAZED_TERRACOTTA_ITEM);
        getOrCreateTagBuilder(COLORABLE_CONCRETE_ITEM)
                .add(Items.WHITE_CONCRETE)
                .addTag(COLORED_CONCRETE_ITEM);
        getOrCreateTagBuilder(COLORABLE_STAINED_GLASS_ITEM)
                .add(Items.GLASS)
                .addTag(COLORED_STAINED_GLASS_ITEM);
        getOrCreateTagBuilder(COLORABLE_CARPET_ITEM)
                .add(Items.WHITE_CARPET)
                .addTag(COLORED_CARPET_ITEM);
        getOrCreateTagBuilder(COLORABLE_STONE_BRICK_STAIRS_ITEM)
                .add(Items.STONE_BRICK_STAIRS)
                .addTag(COLORED_STONE_BRICK_STAIRS_ITEM);
        getOrCreateTagBuilder(COLORABLE_WOOD_PLANK_STAIRS_ITEM)
                .add(Items.BIRCH_STAIRS)
                .addTag(COLORED_WOOD_PLANK_STAIRS_ITEM);
        getOrCreateTagBuilder(COLORABLE_STONE_BRICK_SLAB_ITEM)
                .add(Items.STONE_BRICK_SLAB)
                .addTag(COLORED_STONE_BRICK_SLAB_ITEM);
        getOrCreateTagBuilder(COLORABLE_WOOD_PLANK_SLAB_ITEM)
                .add(Items.BIRCH_SLAB)
                .addTag(COLORED_WOOD_PLANK_SLAB_ITEM);
    }
}
