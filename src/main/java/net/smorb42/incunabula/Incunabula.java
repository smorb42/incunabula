package net.smorb42.incunabula;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import net.smorb42.incunabula.blocks.ModBlocks;
import net.smorb42.incunabula.blocks.VatCoreBlock;
import net.smorb42.incunabula.blocks.tile.VatCoreTile;
import net.smorb42.incunabula.items.ModItems;
import net.smorb42.incunabula.util.ModModelPredicateProvider;
import net.smorb42.incunabula.world.feature.ModConfiguredFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Incunabula implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "incunabula";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static BlockEntityType<VatCoreTile> VAT_CORE_TILE;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModConfiguredFeatures.registerConfiguredFeatures();

		VAT_CORE_TILE = Registry.register(Registry.BLOCK_ENTITY_TYPE, "incunabula:vat_core_tile",
				FabricBlockEntityTypeBuilder.create(VatCoreTile::new, ModBlocks.VAT_CORE).build(null));


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Incunabula loaded");
	}
}
