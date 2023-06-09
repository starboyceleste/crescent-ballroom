package net.celeste.crescent.data.lang;

import net.celeste.crescent.block.CrescentBlocks;
import net.celeste.crescent.item.CrescentItemGroups;
import net.celeste.crescent.item.CrescentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class CrescentEnglishLanguageProvider extends FabricLanguageProvider {
    public CrescentEnglishLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(CrescentItems.BLUR_BM57_MICROPHONE, "Blur BM57 Microphone");
        translationBuilder.add(CrescentItems.BLUR_BM58_MICROPHONE, "Blur BM58 Microphone");
        translationBuilder.add(CrescentItems.BLUR_BM7B_MICROPHONE, "Blur BM7B Microphone");
        translationBuilder.add(CrescentItems.GLUE_YETI_MICROPHONE, "Glue Yeti Microphone");
        translationBuilder.add(CrescentItems.PAPERX_CUBECAST_MICROPHONE, "PaperX CubeCast Microphone");
        translationBuilder.add(CrescentItems.TRUMANN_M_196_MICROPHONE, "Trumann M 196 Microphone");
        translationBuilder.add(CrescentItems.TRUMANN_U_98_MICROPHONE, "Trumann U 98 Microphone");
        translationBuilder.add(CrescentItems.VOXEL_VOICE_VE20_MICROPHONE, "Voxel-Voice VE20 Microphone");
        translationBuilder.add(CrescentItems.MICROPHONE_STAND, "Microphone Stand with Boom Arm");
        translationBuilder.add(CrescentBlocks.FLORENCE_CESNA_CHAIR, "Florence Cesna Chair");
        translationBuilder.add(CrescentBlocks.CAMBRIDGE_CESNA_CHAIR, "Cambridge Cesna Chair");
        translationBuilder.add(CrescentBlocks.BLUE_SCREEN, "Blue Screen Block");
        translationBuilder.add(CrescentBlocks.GREEN_SCREEN, "Green Screen Block");
        translationBuilder.add(CrescentBlocks.RED_SCREEN, "Red Screen Block");
        translationBuilder.add(CrescentItemGroups.CRESCENT, "Crescent");
    }
}
