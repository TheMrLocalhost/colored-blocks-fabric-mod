package com.mrlocalhost.coloredblocks.datagen;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;
import static com.mrlocalhost.coloredblocks.utils.ColoredBlocksConstants.DYE_MAP;

public class ModItemTagGenerator extends FabricTagProvider<Item> {
    private static final TagKey<Item> COLORED_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colored_stone_bricks"));
    private static final TagKey<Item> COLORABLE_STONE_BRICKS_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":colorable_stone_bricks"));
    private static final TagKey<Item> DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(ColoredBlocks.MOD_ID+":dyes"));
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.ITEM, registryLookupFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (Block block : ColoredBlocksConstants.COLORED_STONE_BRICKS) {
            getOrCreateTagBuilder(COLORED_STONE_BRICKS_ITEM).add(block.asItem());
        }
        getOrCreateTagBuilder(COLORABLE_STONE_BRICKS_ITEM)
                .add(Items.STONE_BRICKS)
                .addTag(COLORED_STONE_BRICKS_ITEM);
        for (Item dye : DYE_MAP.values()) {
            getOrCreateTagBuilder(DYES).add(dye);
        }
    }
}
