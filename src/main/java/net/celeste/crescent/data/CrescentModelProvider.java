package net.celeste.crescent.data;

import net.celeste.crescent.block.CrescentBlocks;
import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class CrescentModelProvider extends FabricModelProvider {
    public CrescentModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(CrescentBlocks.FLORENCE_CESNA_CHAIR, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(CrescentBlocks.FLORENCE_CESNA_CHAIR))).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(CrescentItems.BLUR_BM7B_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.BLUR_BM57_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.BLUR_BM58_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.GLUE_YETI_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.PAPERX_CUBECAST_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.TRUMANN_M_196_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.TRUMANN_U_98_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.VOXEL_VOICE_VE20_MICROPHONE, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.MICROPHONE_STAND, Models.GENERATED);
    }
}
