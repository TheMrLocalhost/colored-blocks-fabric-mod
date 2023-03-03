package com.mrlocalhost.coloredblocks.block.entity;

import com.mrlocalhost.coloredblocks.ColoredBlocks;
import com.mrlocalhost.coloredblocks.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<ColoredBlockEntity> COLORED_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        COLORED_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(ColoredBlocks.MOD_ID, "colored_block_entity"),
            FabricBlockEntityTypeBuilder.create(ColoredBlockEntity::new,
                ModBlocks.COLORED_STONE_BRICKS,
                ModBlocks.COLORED_WOOD_PLANKS,
                ModBlocks.COLORED_STONE_BRICK_STAIRS,
                ModBlocks.COLORED_WOOD_PLANK_STAIRS,
                ModBlocks.COLORED_STONE_BRICK_SLAB,
                ModBlocks.COLORED_WOOD_PLANK_SLAB
            ).build(null));
    }
}
