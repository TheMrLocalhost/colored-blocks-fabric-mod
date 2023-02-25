package com.mrlocalhost.coloredblocks.recipe;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class ColoringRecipe extends ShapedRecipe implements CraftingRecipe {

    private final Ingredient dye;
    private final Ingredient blockToColor;
    private final ItemStack result;
    private final Identifier id;

    public ColoringRecipe(Identifier id, ItemStack result, Ingredient dye, Ingredient blockToColor) {
        super(id, "Colored Blocks", CraftingRecipeCategory.MISC,
                3, 3, DefaultedList.copyOf(Ingredient.EMPTY,
                        new Ingredient[]{
                                blockToColor,blockToColor,blockToColor,blockToColor,
                                dye,
                                blockToColor,blockToColor,blockToColor,blockToColor}),
                result);
        this.id = id;
        this.dye = dye;
        this.blockToColor = blockToColor;
        this.result = result;
    }
    public Ingredient getDye() { return this.dye; }
    public Ingredient getBlockToColor() { return this.blockToColor; }
    @Override
    public ItemStack getOutput() { return this.result; }
    @Override
    public Identifier getId() { return this.id; }
    @Override
    public ItemStack craft(CraftingInventory inventory) {
        return this.getOutput().copy();
    }
    @Override
    public boolean fits(int width, int height) { return true;}//(width==3&&height==3) ? true : false; }
    @Override
    public RecipeType<?> getType() { return Type.INSTANCE; }
    @Override
    public boolean matches(CraftingInventory inv, World world) {
        if (world.isClient()) {
            ColoredBlocks.LOGGER.info("Client match ignored");
            return false;
        }
        ColoredBlocks.LOGGER.info("Attempting match..." + inv.getStack(0));
//        if (inv.size() != 9) return false;
//        for (int i=0; i<9; i++){
//            System.out.println("item "+i+": "+inv.getStack(i).toString());
//            if (i==4) continue; //center item
//            if (!blockToColor.test(inv.getStack(i))) {
//                return false;
//            }
//        }

        return dye.test(inv.getStack(1));
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return ColoringRecipeSerializer.INSTANCE;
    }
    public static class Type implements RecipeType<ColoringRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final Identifier ID = new Identifier(ColoredBlocks.MOD_ID,"colored_block_crafting");
    }
}
