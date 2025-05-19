package org.apache.poi.extractor;

import java.io.File;
import org.apache.poi.POITextExtractor;

/* loaded from: classes4.dex */
public class CommandLineTextExtractor {
    public static final String DIVIDER = "=======================";

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("   CommandLineTextExtractor <filename> [filename] [filename]");
            System.exit(1);
        }
        for (String str : strArr) {
            System.out.println(DIVIDER);
            File file = new File(str);
            System.out.println(file);
            POITextExtractor createExtractor = ExtractorFactory.createExtractor(file);
            POITextExtractor metadataTextExtractor = createExtractor.getMetadataTextExtractor();
            System.out.println("   =======================");
            System.out.println(metadataTextExtractor.getText());
            System.out.println("   =======================");
            System.out.println(createExtractor.getText());
            System.out.println(DIVIDER);
        }
    }
}
