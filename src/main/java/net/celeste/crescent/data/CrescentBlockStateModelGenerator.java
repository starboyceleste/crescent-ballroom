package net.celeste.crescent.data;

import net.celeste.crescent.block.CrescentBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class CrescentBlockStateModelGenerator extends FabricModelProvider {
    public CrescentBlockStateModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(CrescentBlocks.FLORENCE_CESNA_CHAIR, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(CrescentBlocks.FLORENCE_CESNA_CHAIR))).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
