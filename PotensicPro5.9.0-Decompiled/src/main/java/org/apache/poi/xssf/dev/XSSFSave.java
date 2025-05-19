package org.apache.poi.xssf.dev;

import java.io.FileOutputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* loaded from: classes5.dex */
public final class XSSFSave {
    public static void main(String[] strArr) throws Exception {
        for (int i = 0; i < strArr.length; i++) {
            OPCPackage open = OPCPackage.open(strArr[i]);
            XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(open);
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[i].substring(0, strArr[i].lastIndexOf(46)) + "-save.xls" + (xSSFWorkbook.isMacroEnabled() ? "m" : "x"));
            xSSFWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            open.close();
        }
    }
}
