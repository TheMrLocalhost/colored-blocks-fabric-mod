package com.mrlocalhost.coloredstonebricks;

import com.mrlocalhost.coloredstonebricks.block.ModBlocks;
import com.mrlocalhost.coloredstonebricks.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColoredStoneBricks implements ModInitializer {
	public static final String MOD_ID = "colored_stone_bricks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
