package net.celeste.crescent.data.lang;

import net.celeste.crescent.block.CrescentBlocks;
import net.celeste.crescent.item.CrescentItemGroups;
import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class CrescentSpanishLanguageProvider extends FabricLanguageProvider {
    public CrescentSpanishLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "es_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(CrescentItems.BLUR_BM57_MICROPHONE, "Blur BM57 Micrófono");
        translationBuilder.add(CrescentItems.BLUR_BM58_MICROPHONE, "Blur BM58 Micrófono");
        translationBuilder.add(CrescentItems.BLUR_BM7B_MICROPHONE, "Blur BM7B Micrófono");
        translationBuilder.add(CrescentItems.GLUE_YETI_MICROPHONE, "Glue Yeti Micrófono");
        translationBuilder.add(CrescentItems.PAPERX_CUBECAST_MICROPHONE, "PaperX CubeCast Micrófono");
        translationBuilder.add(CrescentItems.TRUMANN_M_196_MICROPHONE, "Trumann M 196 Micrófono");
        translationBuilder.add(CrescentItems.TRUMANN_U_98_MICROPHONE, "Trumann U 98 Micrófono");
        translationBuilder.add(CrescentItems.VOXEL_VOICE_VE20_MICROPHONE, "Voxel-Voice VE20 Micrófono");
        translationBuilder.add(CrescentItems.MICROPHONE_STAND, "Soporte de brazo para micrófono");
        translationBuilder.add(CrescentBlocks.FLORENCE_CESNA_CHAIR, "Florencia Cesna Silla");
        translationBuilder.add(CrescentItemGroups.CRESCENT, "Crescent");
    }
}
