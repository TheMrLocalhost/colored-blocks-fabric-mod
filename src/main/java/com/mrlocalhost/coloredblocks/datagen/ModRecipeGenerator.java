package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.item.custom.CustomItemTags;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import java.util.function.Consumer;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.COLOR_MAP;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.DYE_ITEMS;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksUtils.getColorOfBlock;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_STONE_BRICKS, "_stone_bricks", CustomItemTags.COLORABLE_STONE_BRICKS);
        generateCleanedBlocks(exporter, Blocks.STONE_BRICKS, "_stone_bricks", CustomItemTags.COLORED_STONE_BRICKS);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_WOOD_PLANKS, "_wood_planks", CustomItemTags.COLORABLE_WOOD_PLANKS);
        generateCleanedBlocks(exporter, Blocks.BIRCH_PLANKS, "_wood_planks", CustomItemTags.COLORED_WOOD_PLANKS);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_WOOL_BLOCKS, "_wool", CustomItemTags.COLORABLE_WOOL_BLOCKS);
        generateCleanedBlocks(exporter, Blocks.WHITE_WOOL, "_wool", CustomItemTags.COLORED_WOOL_BLOCKS);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_TERRACOTTA, "_terracotta", CustomItemTags.COLORABLE_TERRACOTTA);
        generateCleanedBlocks(exporter, Blocks.TERRACOTTA, "_terracotta", CustomItemTags.COLORED_TERRACOTTA);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_GLAZED_TERRACOTTA, "_glazed_terracotta", CustomItemTags.COLORABLE_GLAZED_TERRACOTTA);
        generateCleanedBlocks(exporter, Blocks.WHITE_GLAZED_TERRACOTTA, "_glazed_terracotta", CustomItemTags.COLORED_GLAZED_TERRACOTTA);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_CONCRETE, "_concrete", CustomItemTags.COLORABLE_CONCRETE);
        generateCleanedBlocks(exporter, Blocks.WHITE_CONCRETE, "_concrete", CustomItemTags.COLORED_CONCRETE);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_STAINED_GLASS, "_stained_glass", CustomItemTags.COLORABLE_STAINED_GLASS);
        generateCleanedBlocks(exporter, Blocks.GLASS, "_stained_glass", CustomItemTags.COLORED_STAINED_GLASS);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_CARPET, "_carpet", CustomItemTags.COLORABLE_CARPET);
        generateCleanedBlocks(exporter, Blocks.WHITE_CARPET, "_carpet", CustomItemTags.COLORED_CARPET);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_STONE_BRICK_STAIRS, "_stone_brick_stairs", CustomItemTags.COLORABLE_STONE_BRICK_STAIRS);
        generateCleanedBlocks(exporter, Blocks.STONE_BRICK_STAIRS, "_stone_brick_stairs", CustomItemTags.COLORED_STONE_BRICK_STAIRS);
        generateStairsRecipe(exporter, ColoredBlocksConstants.COLORED_STONE_BRICKS, ColoredBlocksConstants.COLORED_STONE_BRICK_STAIRS, "_stone_bricks");

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_WOOD_PLANK_STAIRS, "_wood_plank_stairs", CustomItemTags.COLORABLE_WOOD_PLANK_STAIRS);
        generateCleanedBlocks(exporter, Blocks.BIRCH_STAIRS, "_wood_plank_stairs", CustomItemTags.COLORED_WOOD_PLANK_STAIRS);
        generateStairsRecipe(exporter,ColoredBlocksConstants.COLORED_WOOD_PLANKS, ColoredBlocksConstants.COLORED_WOOD_PLANK_STAIRS, "_wood_planks");

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_STONE_BRICK_SLAB, "_stone_brick_slab", CustomItemTags.COLORABLE_STONE_BRICK_SLAB);
        generateCleanedBlocks(exporter, Blocks.STONE_BRICK_SLAB, "_stone_brick_slab", CustomItemTags.COLORED_STONE_BRICK_SLAB);
        generateSlabRecipe(exporter, ColoredBlocksConstants.COLORED_STONE_BRICKS, ColoredBlocksConstants.COLORED_STONE_BRICK_SLAB, "_stone_bricks");

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_WOOD_PLANK_SLAB, "_wood_plank_slab", CustomItemTags.COLORABLE_WOOD_PLANK_SLAB);
        generateCleanedBlocks(exporter, Blocks.BIRCH_SLAB, "_wood_plank_slab", CustomItemTags.COLORED_WOOD_PLANK_SLAB);
        generateSlabRecipe(exporter, ColoredBlocksConstants.COLORED_WOOD_PLANKS, ColoredBlocksConstants.COLORED_WOOD_PLANK_SLAB, "_wood_planks");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLEANING_CLOTH, 1)
                .pattern("TTT").pattern("TWT").pattern("TTT")
                .input('T', Items.PAPER).input('W', ItemTags.WOOL)
                .criterion("has_paper_for_cleaning_cloth",conditionsFromItem(Items.PAPER))
                .criterion("has_any_wool_for_cleaning_cloth",conditionsFromTag(ItemTags.WOOL))
                .offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":cleaning_cloth"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ARTIST_PALETTE, 1)
                .pattern("TTT").pattern("TTT").pattern("TTT")
                .input('T', ItemTags.WOODEN_PRESSURE_PLATES)
                .criterion("has_any_pressure_plate_for_artist_palette",conditionsFromTag(ItemTags.WOODEN_PRESSURE_PLATES))
                .offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":artist_palette"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PAINTBRUSH, 1)
                .pattern("  X").pattern(" # ").pattern("#  ")
                .input('X', ItemTags.WOOL).input('#', Items.STICK)
                .criterion("has_stick_for_paintbrush",conditionsFromItem(Items.STICK))
                .criterion("has_any_wool_for_paintbrush",conditionsFromTag(ItemTags.WOOL))
                .offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":paintbrush"));
    }
    private void generateStairsRecipe(Consumer<RecipeJsonProvider> exporter, Block[] input, Block[] output, String suffix) {
        for (int i = 0;i<16;i++) {
            String colorName = COLOR_MAP.get(i);
            Block outputBlock = output[i];
            Block inputBlock = input[i];
            String blockName = colorName+suffix+"_stairs";
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, outputBlock, 4)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .input('S', inputBlock)
                .criterion("block_for_"+blockName,conditionsFromItem(inputBlock))
                .offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":colored"+suffix+"_stairs/"+blockName));
        }
    }
    private void generateSlabRecipe(Consumer<RecipeJsonProvider> exporter, Block[] input, Block[] output, String suffix) {
        for (int i = 0;i<16;i++) {
            String colorName = COLOR_MAP.get(i);
            Block outputBlock = output[i];
            Block inputBlock = input[i];
            String blockName = colorName+suffix+"_slab";
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, outputBlock, 6)
                .pattern("SSS")
                .input('S', inputBlock)
                .criterion("block_for_"+blockName,conditionsFromItem(inputBlock))
                .offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":colored"+suffix+"_slab/"+blockName));
        }
    }
    private void generateCleanedBlocks(Consumer<RecipeJsonProvider> exporter, Block output, String suffix, TagKey<Item> tag) {
        ShapelessRecipeJsonBuilder builder = new ShapelessRecipeJsonBuilder(RecipeCategory.MISC, output, 1);
        builder.input(tag);
        builder.criterion("cleaned"+suffix+"/cleaned"+suffix,conditionsFromTag(tag));
        builder.offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":cleaned"+suffix+"/cleaned"+suffix));
    }
    private void generateColoredBlocks(Consumer<RecipeJsonProvider> exporter, Block[] blocks, String suffix, TagKey<Item> tag) {
        for (int i = 0; i<16; i++) {
            String blockName = COLOR_MAP.get(getColorOfBlock(blocks[i]))+suffix;
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, blocks[i], 8)
                    .pattern("TTT").pattern("TDT").pattern("TTT")
                    .input('T', tag).input('D', DYE_ITEMS[i])
                    .criterion("dye_for_"+blockName,conditionsFromTag(CustomItemTags.DYES))
                    .criterion("colored"+suffix+"/"+blockName,conditionsFromTag(tag))
                    .offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":colored"+suffix+"/"+blockName));
        }
    }
}
