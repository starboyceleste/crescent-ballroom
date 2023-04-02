package net.celeste.crescent;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.celeste.crescent.block.CrescentBlocks.CrescentBlocks;
import static net.celeste.crescent.item.CrescentItemGroups.CrescentItemGroups;
import static net.celeste.crescent.item.CrescentItems.CrescentItems;

public class Crescent implements ModInitializer {
	public static final String MOD_ID = "crescent";
	public static final String NAME = "Crescent Ballroom";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialized mod.");
		CrescentItems();
		CrescentBlocks();
		CrescentItemGroups();
	}
}