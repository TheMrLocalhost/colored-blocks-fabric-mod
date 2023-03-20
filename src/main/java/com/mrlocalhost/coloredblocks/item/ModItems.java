package com.mrlocalhost.coloredblocks.item;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.item.custom.ArtistPaletteItem;
import com.mrlocalhost.coloredblocks.item.custom.CleaningClothItem;
import com.mrlocalhost.coloredblocks.item.custom.PaintbrushItem;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ARTIST_PALETTE = registerItem("artist_palette", new ArtistPaletteItem(new FabricItemSettings()
            .group(ModItemGroup.COLORED_BLOCKS_GROUP)
            .maxCount(1)
            .maxDamage(ColoredBlocksConstants.MAX_PALETTE_DAMAGE)
            .fireproof()));
    public static final Item PAINTBRUSH = registerItem("paintbrush", new PaintbrushItem(new FabricItemSettings()
            .group(ModItemGroup.COLORED_BLOCKS_GROUP)
            .maxCount(1)));
    public static final Item CLEANING_CLOTH = registerItem("cleaning_cloth", new CleaningClothItem(new FabricItemSettings()
            .group(ModItemGroup.COLORED_BLOCKS_GROUP)
            .maxCount(1)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ColoredBlocks.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ColoredBlocks.LOGGER.debug("Registering Mod Items for " + ColoredBlocks.MOD_ID);
    }
}
