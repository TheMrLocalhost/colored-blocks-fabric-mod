package com.mrlocalhost.coloredblocks.predicate.custom;

import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class ModPredicates {

    public static void registerModPredicates() {
        registerPredicate(ModItems.PAINTBRUSH, "color");
    }

    private static void registerPredicate(Item item, String predicate) {
        ModelPredicateProviderRegistry.register(item, new Identifier(predicate), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            NbtCompound nbtCompound = itemStack.getNbt();
            if (nbtCompound == null || !nbtCompound.contains(predicate)) {
                return 0.0F;
            }
            int color = nbtCompound.getInt(predicate);
            return (float)color/(ColoredBlocksConstants.MAX_COLOR_VALUE+1);
        });
    }

}
