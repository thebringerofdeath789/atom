package com.xml2xls;

import com.lib.bean.ExcelWriter;
import com.lib.bean.XmlCell;
import com.lib.bean.XmlReader;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public class Test {
    public static void main(String[] strArr) throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\apktool\\PotensicPro_V5.2.0 BR\\res\\values\\strings.xml");
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\apktool\\PotensicPro_V5.2.0 BR\\res\\values\\test.xls");
        List<XmlCell> cells = new XmlReader(file.getAbsolutePath()).getCells();
        ExcelWriter excelWriter = new ExcelWriter(file2);
        excelWriter.write(cells);
        excelWriter.close();
    }
}
