package net.smorb42.incunabula;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.smorb42.incunabula.blocks.ModBlocks;
import net.smorb42.incunabula.util.ModModelPredicateProvider;

public class IncunabulaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VAT_BLOCK, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VAT_CORE, RenderLayer.getCutout());
    // Replace `RenderLayer.getCutout()` with `RenderLayer.getTranslucent()` if you have a translucent texture.
        ModModelPredicateProvider.registerModModels();
    }
}
