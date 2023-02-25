package com.mrlocalhost.coloredblocks.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class ColoringRecipeSerializer implements RecipeSerializer<ColoringRecipe> {
    private ColoringRecipeSerializer(){}
    public static final ColoringRecipeSerializer INSTANCE = new ColoringRecipeSerializer();
    public static final Identifier ID = (ColoringRecipe.Type.ID);
    @Override
    public ColoringRecipe read(Identifier id, JsonObject json) {
        ColoringRecipeJsonFormat recipeJson = new Gson().fromJson(json, ColoringRecipeJsonFormat.class);
        Ingredient dye = Ingredient.fromJson(recipeJson.key.get("dye"));
        Ingredient blockToColor = Ingredient.fromJson(recipeJson.key.get("blockToColor"));
        String outputString = recipeJson.result.get("output").getAsString();
        Item outputItem = Registries.ITEM.get(new Identifier(outputString));
        int amount = recipeJson.result.get("amount").getAsInt();
        ItemStack output = new ItemStack(outputItem, amount);
        int nbtRed = recipeJson.result.get("nbtRed").getAsInt();
        int nbtGreen = recipeJson.result.get("nbtGreen").getAsInt();
        int nbtBlue = recipeJson.result.get("nbtBlue").getAsInt();
        NbtCompound nbt = output.getOrCreateNbt();
        nbt.putInt("red", nbtRed);
        nbt.putInt("green", nbtGreen);
        nbt.putInt("blue", nbtBlue);
        ColoredBlocks.LOGGER.info("read recipe for: {}",output.getItem().getName());
        return new ColoringRecipe(id, output, dye, blockToColor);
    }
    @Override
    public ColoringRecipe read(Identifier id, PacketByteBuf buf) {
        //Ingredient dye = Ingredient.fromPacket(buf);
        //Ingredient blockToColor = Ingredient.fromPacket(buf);
        //ItemStack output = buf.readItemStack();
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
        Ingredient dyeIngredient = null;
        Ingredient blockToColor = null;
        //ItemStack dyeStack = null;
        for (int i = 0; i < inputs.size(); i++) {
            Ingredient ingredient = Ingredient.fromPacket(buf);
            if (ingredient.test(Items.RED_DYE.getDefaultStack())) {
                dyeIngredient = ingredient;
            } else if (ingredient.test(ModBlocks.COLORED_STONE_BRICKS.asItem().getDefaultStack())) {
                blockToColor = ingredient;
            }
            inputs.set(i, ingredient);
        }
        ItemStack output = buf.readItemStack();
        NbtCompound nbtOut = output.getOrCreateNbt();
        //TODO undo manual set to red every time
        nbtOut.putInt("red", 10);
        nbtOut.putInt("green", 0);
        nbtOut.putInt("blue", 2);
        ColoredBlocks.LOGGER.info("KAZ F called read function");
        return new ColoringRecipe(id, output, dyeIngredient, blockToColor);
    }
    @Override
    public void write(PacketByteBuf buf, ColoringRecipe recipe) {
        ColoredBlocks.LOGGER.info("KAZ F called write function");
        //recipe.getDye().write(buf);
        //recipe.getBlockToColor().write(buf);
        //buf.writeItemStack(recipe.getOutput());

        buf.writeInt(recipe.getIngredients().size());
        for (Ingredient ingredient: recipe.getIngredients()) {
            ingredient.write(buf);
        }
        buf.writeItemStack(recipe.getOutput());
    }
}
