package com.supermctea.flintslab;

import com.supermctea.flintslab.block.FlintBlockSlab;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FlintSlabMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();

        Block flint_block_slab = Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.tryBuild(Constants.MOD_ID, "flint_block_slab"),
                new FlintBlockSlab(BlockBehaviour.Properties.of()));

        Registry.register(
                BuiltInRegistries.ITEM,
                BuiltInRegistries.BLOCK.getKey(flint_block_slab),
                new BlockItem(flint_block_slab, new Item.Properties()));
    }
}
