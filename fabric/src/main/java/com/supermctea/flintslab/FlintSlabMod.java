package com.supermctea.flintslab;

import com.supermctea.flintslab.block.FlintBlockSlab;
import com.supermctea.flintslab.registry.ModBlocks;
import com.supermctea.flintslab.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FlintSlabMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();

        // Register Blocks
        bind(BuiltInRegistries.BLOCK, ModBlocks::register);

        // Register Items
        bindItems(BuiltInRegistries.ITEM, ModItems::register);
    }

    /** Adapted from <a href="https://github.com/VazkiiMods/Botania">Botania</a> */
    private static <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
//        eventBus.addListener((RegisterEvent event) -> {
//            if (registry.equals(event.getRegistryKey())) {
//                source.accept((t, rl) -> event.register(registry, rl, () -> t));
//            }
//        });

        source.accept((t, rl) -> Registry.register(registry, rl, t));
    }

    private static void bindItems(Registry<Item> registry, Consumer<BiConsumer<Item, ResourceLocation>> source) {
        bind(registry, source);
        source.accept((t, rl) -> registerToCreativeMenu(t));
    }

    public static <T> void registerToCreativeMenu(Item source) {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            content.addAfter(Items.INFESTED_DEEPSLATE, source);
        });
    }
}
