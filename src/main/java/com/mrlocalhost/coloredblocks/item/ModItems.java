package com.mrlocalhost.coloredblocks.item;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.item.custom.ArtistPaletteItem;
import com.mrlocalhost.coloredblocks.item.custom.PaintbrushItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModItems {
    public static final Item ARTIST_PALETTE = registerItem("artist_palette", new ArtistPaletteItem(new Item.Settings()
            .maxCount(1)
            .maxDamage(16)));
    public static final Item PAINTBRUSH = registerItem("paintbrush", new PaintbrushItem(new Item.Settings()
            .maxCount(1)));
    public static final Item CLEANING_CLOTH = registerItem("cleaning_cloth", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.COLORED_BLOCKS_GROUP).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(ColoredBlocks.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ColoredBlocks.LOGGER.debug("Registering Mod Items for " + ColoredBlocks.MOD_ID);
    }
}
