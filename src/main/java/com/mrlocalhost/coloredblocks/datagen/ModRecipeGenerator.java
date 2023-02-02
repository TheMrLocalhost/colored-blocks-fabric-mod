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
    private void generateCleanedBlocks(Consumer<RecipeJsonProvider> exporter, Block output, String suffix, TagKey<Item> tag) {
        for (int i=1; i<10; i++) {
            ShapelessRecipeJsonBuilder builder = new ShapelessRecipeJsonBuilder(RecipeCategory.MISC, output, i);
            for (int j=1;j<=i;j++) {builder.input(tag);}
            builder.criterion("cleaned"+suffix+"/cleaned"+suffix+"_"+i,conditionsFromTag(tag));
            builder.offerTo(exporter, new Identifier(ColoredBlocks.MOD_ID+":cleaned"+suffix+"/cleaned"+suffix+"_"+i));
        }
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
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_STONE_BRICKS, "_stone_bricks", CustomItemTags.COLORABLE_STONE_BRICKS);
        generateCleanedBlocks(exporter, Blocks.STONE_BRICKS, "_stone_bricks", CustomItemTags.COLORED_STONE_BRICKS);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_WOOD_PLANKS, "_wood_planks", CustomItemTags.COLORABLE_WOOD_PLANKS);
        generateCleanedBlocks(exporter, Blocks.BIRCH_PLANKS, "_wood_planks", CustomItemTags.COLORED_WOOD_PLANKS);

        generateColoredBlocks(exporter, ColoredBlocksConstants.COLORED_WOOL_BLOCKS, "_wool", CustomItemTags.COLORABLE_WOOL_BLOCKS);
        generateCleanedBlocks(exporter, Blocks.WHITE_WOOL, "_wool", CustomItemTags.COLORED_WOOL_BLOCKS);

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
}
