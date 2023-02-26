package com.mrlocalhost.coloredblocks.recipe;

import com.google.gson.JsonObject;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import java.util.function.Consumer;

public class ColoredRecipeJsonBuilder extends ShapedRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
    private final RecipeCategory category;
    private final Item output;
    private final int count;
    private final Ingredient blockToColor;
    private final Ingredient dye;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.create();
    private final String colorIndex;

    public ColoredRecipeJsonBuilder(RecipeCategory category, ItemConvertible output, int count, Ingredient blockToColor, Ingredient dye, String colorIndex) {
        super(category, output, count);
        this.category = category;
        this.output = output.asItem();
        this.count = count;
        this.blockToColor = blockToColor;
        this.dye = dye;
        this.colorIndex = colorIndex;
    }
    @Override
    public ColoredRecipeJsonBuilder criterion(String string, CriterionConditions criterionConditions) {
        this.advancementBuilder.criterion(string, criterionConditions);
        return this;
    }
    @Override
    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
        this.advancementBuilder.parent(ROOT).criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId)).rewards(net.minecraft.advancement.AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(CriterionMerger.OR);
        exporter.accept(
            new ColoredRecipeJsonProvider(
                    recipeId, this.output, this.count,
                    this.category, this.blockToColor, this.dye,
                    this.advancementBuilder, recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/"), this.colorIndex
            )
        );
    }
    public static ColoredRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output, int count, Ingredient blockToColor, Ingredient dye, String colorIndex) {
        return new ColoredRecipeJsonBuilder(category, output, count, blockToColor, dye, colorIndex);
    }
    public static class ColoredRecipeJsonProvider implements RecipeJsonProvider  {
        private final Identifier recipeId;
        private final Item output;
        private final int resultCount;
        private final Ingredient blockToColor;
        private final Ingredient dye;
        private final Advancement.Builder advancementBuilder;
        private final Identifier advancementId;
        private final String colorIndex;
        private final RecipeCategory craftingCategory;

        public ColoredRecipeJsonProvider(Identifier recipeId, Item output, int resultCount,
                                         RecipeCategory craftingCategory, Ingredient blockToColor,Ingredient dye,
                                         Advancement.Builder advancementBuilder, Identifier advancementId, String colorIndex) {
            this.craftingCategory = craftingCategory;
            this.recipeId = recipeId;
            this.output = output;
            this.resultCount = resultCount;
            this.blockToColor = blockToColor;
            this.dye = dye;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
            this.colorIndex = colorIndex;
        }
        public void serialize(JsonObject json) {
            json.addProperty("category", getCraftingCategory(this.craftingCategory).asString());
            //key
            JsonObject keyObject = new JsonObject();
            keyObject.add("blockToColor", this.blockToColor.toJson());
            keyObject.add("dye", this.dye.toJson());
            json.add("key", keyObject);
            //result
            JsonObject resultObject = new JsonObject();
            resultObject.addProperty("item", Registries.ITEM.getId(this.output).toString());
            resultObject.addProperty("amount", Math.max(this.resultCount, 1));
            resultObject.addProperty("colorIndex", colorIndex);
            json.add("result", resultObject);
        }
        public RecipeSerializer<?> getSerializer() {
            return ColoredRecipeSerializer.INSTANCE;
        }
        public Identifier getRecipeId() {
            return this.recipeId;
        }
        @Nullable
        public JsonObject toAdvancementJson() {
            return this.advancementBuilder.toJson();
        }
        @Nullable
        public Identifier getAdvancementId() {
            return this.advancementId;
        }
        public static CraftingRecipeCategory getCraftingCategory(RecipeCategory category) {
            return switch (category) {
                case BUILDING_BLOCKS -> CraftingRecipeCategory.BUILDING;
                case TOOLS, COMBAT -> CraftingRecipeCategory.EQUIPMENT;
                case REDSTONE -> CraftingRecipeCategory.REDSTONE;
                default -> CraftingRecipeCategory.MISC;
            };
        }
    }
}
