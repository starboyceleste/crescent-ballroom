package net.celeste.crescent.data;

import net.celeste.crescent.block.CrescentBlocks;
import net.celeste.crescent.data.client.CrescentTexturedModel;
import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class CrescentModelGenerator extends FabricModelProvider {
    public CrescentModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        registerCesna(blockStateModelGenerator, CrescentBlocks.CAMBRIDGE_CESNA_CHAIR);
        registerCesna(blockStateModelGenerator, CrescentBlocks.FLORENCE_CESNA_CHAIR);
        registerCesna(blockStateModelGenerator, CrescentBlocks.WASHINGTON_CESNA_CHAIR);
        registerScreen(blockStateModelGenerator, CrescentBlocks.BLUE_SCREEN);
        registerScreen(blockStateModelGenerator, CrescentBlocks.GREEN_SCREEN);
        registerScreen(blockStateModelGenerator, CrescentBlocks.RED_SCREEN);
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

    public final void registerCesna(BlockStateModelGenerator blockStateModelGenerator, Block cesna) {
        Identifier identifier = CrescentTexturedModel.TEMPLATE_CESNA.upload(cesna, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(cesna, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    public final void registerScreen(BlockStateModelGenerator blockStateModelGenerator, Block screen) {
        Identifier identifier = CrescentTexturedModel.CUBE_DISPLAY_ALL.upload(screen, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(screen, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)));
    }

}
