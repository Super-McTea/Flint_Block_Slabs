package com.supermctea.flintslab;

import com.supermctea.flintslab.block.FlintBlockSlab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(Constants.MOD_ID)
public class FlintSlabMod {

    public static IEventBus eventBus;
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    
    public FlintSlabMod(FMLJavaModLoadingContext context) {

        eventBus = context.getModEventBus();

        BLOCKS.register("flint_block_slab", () -> new FlintBlockSlab(BlockBehaviour.Properties.of()));

        BLOCKS.register(eventBus);
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
        
    }
}