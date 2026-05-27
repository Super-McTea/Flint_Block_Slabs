package com.supermctea.flintslab;

import com.supermctea.flintslab.registry.ModBlocks;
import com.supermctea.flintslab.registry.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class FlintSlabMod {

    public static IEventBus eventBus;
    
    public FlintSlabMod(FMLJavaModLoadingContext context) {

        eventBus = context.getModEventBus();
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();

        // Register Blocks
        bind(Registries.BLOCK, ModBlocks::register);

        // Register Items
        bindItems(Registries.ITEM, ModItems::register);
        // Add Items To Creative Tab
        buildCreativeTab();
    }

    /** Adapted from <a href="https://github.com/VazkiiMods/Botania">Botania</a> */
    private static <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        eventBus.addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }

    private static final Set<Item> itemsToAddToCreativeTab = new LinkedHashSet<>();

    private static void bindItems(ResourceKey<Registry<Item>> registry, Consumer<BiConsumer<Item, ResourceLocation>> source) {
        eventBus.addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> {
                    itemsToAddToCreativeTab.add(t);
                    event.register(registry, rl, () -> t);
                });

            }
        });
    }

    private static void buildCreativeTab() {
        eventBus.addListener((BuildCreativeModeTabContentsEvent event) -> {
            if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
                for (Item item : itemsToAddToCreativeTab) {
                    event.accept(item);
                }
            }
        });
    }
}