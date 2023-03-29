package net.celeste.crescent;

import net.celeste.crescent.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crescent implements ModInitializer {
	public static final String MOD_ID = "crescent";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialized.");
		ModItems.registerModItems();
	}
}