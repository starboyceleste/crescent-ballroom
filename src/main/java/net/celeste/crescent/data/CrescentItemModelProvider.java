package net.celeste.crescent.data;

import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class CrescentItemModelProvider extends FabricModelProvider {
    public CrescentItemModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
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
