package org.apache.poi.util;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes5.dex */
public class DrawingDump {
    public static void main(String[] strArr) throws IOException {
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(strArr[0])));
        try {
            System.out.println("Drawing group:");
            hSSFWorkbook.dumpDrawingGroupRecords(true);
            for (int i = 1; i <= hSSFWorkbook.getNumberOfSheets(); i++) {
                System.out.println("Sheet " + i + ":");
                hSSFWorkbook.getSheetAt(i - 1).dumpDrawingRecords(true);
            }
        } finally {
            hSSFWorkbook.close();
        }
    }
}
