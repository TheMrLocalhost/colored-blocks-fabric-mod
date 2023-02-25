package com.mrlocalhost.coloredblocks;

import com.mrlocalhost.coloredblocks.block.ModBlocks;
import com.mrlocalhost.coloredblocks.color.ColorProviders;
import com.mrlocalhost.coloredblocks.item.ModItems;
import com.mrlocalhost.coloredblocks.networking.PacketHandler;
import com.mrlocalhost.coloredblocks.predicate.custom.ModPredicates;
import com.mrlocalhost.coloredblocks.recipe.ColoredRecipeSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColoredBlocks implements ModInitializer {
	public static final String MOD_ID = "colored_blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModPredicates.registerModPredicates();
		PacketHandler.registerC2SPackets();
		ColorProviders.registerColorProviders();
		Registry.register(Registries.RECIPE_SERIALIZER, ColoredRecipeSerializer.ID, ColoredRecipeSerializer.INSTANCE);
	}
}
