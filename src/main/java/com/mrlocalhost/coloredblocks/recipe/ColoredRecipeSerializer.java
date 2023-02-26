package com.mrlocalhost.coloredblocks.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class ColoredRecipeSerializer implements RecipeSerializer<ShapedRecipe> {

    public static final ColoredRecipeSerializer INSTANCE = new ColoredRecipeSerializer();
    public static final String ID = ColoredBlocks.MOD_ID+":colored_block_crafting";
    @Override
    public ShapedRecipe read(Identifier id, JsonObject json) {
        ColoringRecipeJsonFormat recipeJson = new Gson().fromJson(json, ColoringRecipeJsonFormat.class);
        Ingredient dye = Ingredient.fromJson(recipeJson.key.get("dye"));
        Ingredient blockToColor = Ingredient.fromJson(recipeJson.key.get("blockToColor"));
        String outputString = recipeJson.result.get("item").getAsString();
        Item outputItem = Registries.ITEM.get(new Identifier(outputString));
        int amount = recipeJson.result.get("amount").getAsInt();
        ItemStack output = new ItemStack(outputItem, amount);
        String colorString = recipeJson.result.get("colorIndex").getAsString();
        int colorIndex = ColoredBlocksConstants.COLOR_MAP.indexOf(colorString);
        ColoredBlocksConstants.RGB_VALUES rgb = ColoredBlocksConstants.RGB_VALUES.byIndex(colorIndex);
        int nbtRed = rgb.r();
        int nbtGreen = rgb.g();
        int nbtBlue = rgb.b();
        NbtCompound nbt = output.getOrCreateNbt();
        nbt.putInt("red", nbtRed);
        nbt.putInt("green", nbtGreen);
        nbt.putInt("blue", nbtBlue);
        return new ShapedRecipe(
            id,
            "Colored Blocks",
            CraftingRecipeCategory.valueOf(recipeJson.category.getAsString().toUpperCase()),
            3, 3,
            DefaultedList.copyOf(Ingredient.EMPTY,
                blockToColor,blockToColor,blockToColor,
                blockToColor,    dye,     blockToColor,
                blockToColor,blockToColor,blockToColor
            ),
            output
        );
    }
    @Override
    public ShapedRecipe read(Identifier id, PacketByteBuf buf) {
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
        inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));
        ItemStack output = buf.readItemStack();
        return new ShapedRecipe(id, "Colored Blocks", CraftingRecipeCategory.MISC, 3, 3, inputs, output);
    }
    @Override
    public void write(PacketByteBuf buf, ShapedRecipe recipe) {
        buf.writeInt(recipe.getIngredients().size());
        recipe.getIngredients().forEach((ingredient) -> ingredient.write(buf));
        buf.writeItemStack(recipe.getOutput());
    }
}
