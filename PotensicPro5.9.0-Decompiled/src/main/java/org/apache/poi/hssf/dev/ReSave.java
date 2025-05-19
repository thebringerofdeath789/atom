package org.apache.poi.hssf.dev;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/* loaded from: classes4.dex */
public class ReSave {
    public static void main(String[] strArr) throws Exception {
        boolean z = false;
        for (String str : strArr) {
            if (str.equals("-dg")) {
                z = true;
            } else {
                System.out.print("reading " + str + "...");
                HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(new FileInputStream(str));
                try {
                    System.out.println("done");
                    for (int i = 0; i < hSSFWorkbook.getNumberOfSheets(); i++) {
                        HSSFSheet sheetAt = hSSFWorkbook.getSheetAt(i);
                        if (z) {
                            sheetAt.getDrawingPatriarch();
                        }
                    }
                    String replace = str.replace(".xls", "-saved.xls");
                    System.out.print("saving to " + replace + "...");
                    FileOutputStream fileOutputStream = new FileOutputStream(replace);
                    try {
                        hSSFWorkbook.write(fileOutputStream);
                        fileOutputStream.close();
                        System.out.println("done");
                    } finally {
                    }
                } finally {
                    hSSFWorkbook.close();
                }
            }
        }
    }
}
