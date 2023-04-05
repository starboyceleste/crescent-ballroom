package net.celeste.crescent;

import net.celeste.crescent.block.CrescentBlocks;
import net.celeste.crescent.entity.CrescentEntityType;
import net.celeste.crescent.item.CrescentItemGroups;
import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crescent implements ModInitializer {
	public static final String MOD_ID = "crescent";
	public static final String NAME = "Crescent Ballroom";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialized mod.");
		CrescentItems.init();
		CrescentBlocks.init();
		CrescentItemGroups.init();
		CrescentEntityType.init();
	}
}