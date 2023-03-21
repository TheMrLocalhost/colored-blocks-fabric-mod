package com.mrlocalhost.coloredblocks.predicate.custom;

import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModPredicates {

    public static void registerModPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.PAINTBRUSH, new Identifier("color"), (itemStack, clientWorld, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            NbtCompound nbtCompound = itemStack.getNbt();
            if (nbtCompound == null || !nbtCompound.contains("color")) {
                return 0.0F;
            }
            int color = nbtCompound.getInt("color");
            return (float)color/(ColoredBlocksConstants.MAX_COLOR_VALUE+1);
        });
    }

}
