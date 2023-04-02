package net.celeste.crescent.data;

import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class CrescentItemModelGenerator extends FabricModelProvider {
    public CrescentItemModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(CrescentItems.BLUR_BM7B, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.BLUR_BM57, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.BLUR_BM58, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.GLUE_YETI, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.PAPERX_CUBECAST, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.TRUMANN_M_196, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.TRUMANN_U_98, Models.GENERATED);
        itemModelGenerator.register(CrescentItems.VOXEL_VOICE_VE20, Models.GENERATED);
    }
}
