package com.supermctea.flintslab.registry;

import com.supermctea.flintslab.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

public class ModItems {

    public static final Item FLINT_BLOCK_SLAB = new BlockItem(ModBlocks.FLINT_BLOCK_SLAB, new Item.Properties());

    public static void register(BiConsumer<Item, ResourceLocation> consumer) {
        Constants.LOG.info("Registering Items!");
        consumer.accept(
                FLINT_BLOCK_SLAB, BuiltInRegistries.BLOCK.getKey(ModBlocks.FLINT_BLOCK_SLAB)
        );
    }
}
