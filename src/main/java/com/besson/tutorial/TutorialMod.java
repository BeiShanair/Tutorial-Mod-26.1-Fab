package com.besson.tutorial;

import com.besson.tutorial.block.ModBlocks;
import com.besson.tutorial.item.ModCreativeModeTabs;
import com.besson.tutorial.item.ModItems;
import com.besson.tutorial.util.ModArmorEffects;
import com.besson.tutorial.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorial";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.register();
		ModBlocks.register();
		ModCreativeModeTabs.register();

		ModVillagers.registerVillagers();

		FuelValueEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.ANTHRACITE, 1600);
			builder.add(ModItems.CARDBOARD, 300);
		});

		ModArmorEffects.register();

		LOGGER.info("Hello Fabric world!");
	}
}