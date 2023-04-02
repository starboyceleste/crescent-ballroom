package net.celeste.crescent;

import net.celeste.crescent.data.CrescentItemModelGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CrescentDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		Crescent.LOGGER.info("Initialized data generator.");
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(CrescentItemModelGenerator::new);
	}
}
