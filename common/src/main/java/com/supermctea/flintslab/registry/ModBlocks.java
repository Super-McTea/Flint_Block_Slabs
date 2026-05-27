package com.supermctea.flintslab.registry;

import com.supermctea.flintslab.Constants;
import com.supermctea.flintslab.block.FlintBlockSlab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiConsumer;

public class ModBlocks {

    public static final Block FLINT_BLOCK_SLAB = new FlintBlockSlab(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).strength(2.0F, 7.5F));

    public static void register(BiConsumer<Block, ResourceLocation> consumer) {
        Constants.LOG.info("Registering Blocks!");
        consumer.accept(
                FLINT_BLOCK_SLAB, ResourceLocation.tryBuild(Constants.MOD_ID, "flint_block_slab")
        );
    }
}
