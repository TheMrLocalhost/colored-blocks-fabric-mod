package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.block.custom.CustomBlockTags;
import com.mrlocalhost.coloredblocks.item.custom.CustomItemTags;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.DYE_MAP;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        for (Block block : ColoredBlocksConstants.COLORED_STONE_BRICKS) {
            Item coloredBlockItem = block.asItem();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, coloredBlockItem)
                    .pattern("###")
                    .pattern("#D#")
                    .pattern("###")
                    .input('#', Blocks.STONE_BRICKS.asItem())
                    .input('#', CustomItemTags.COLORED_STONE_BRICKS)
                    .input('D', DYE_MAP.get(block))
                    .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(coloredBlockItem)));
        }

    }
}
