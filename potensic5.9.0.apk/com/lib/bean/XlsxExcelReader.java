package com.lib.bean;

import com.lib.Config;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* loaded from: classes2.dex */
public class XlsxExcelReader {
    private final List<TranslateItem> cellList = new ArrayList();
    private int key_column;

    public XlsxExcelReader(String str, int i) throws Exception {
        String str2;
        XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(new File(str).getAbsolutePath());
        XSSFSheet sheetAt = xSSFWorkbook.getSheetAt(i);
        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
        int i2 = 0;
        while (i2 < physicalNumberOfRows) {
            TranslateItem translateItem = i2 != 0 ? new TranslateItem() : null;
            int physicalNumberOfCells = sheetAt.getRow(i2).getPhysicalNumberOfCells();
            for (int i3 = 0; i3 < physicalNumberOfCells; i3++) {
                XSSFCell cell = sheetAt.getRow(i2).getCell(i3);
                try {
                    try {
                        str2 = cell.getStringCellValue();
                    } catch (Exception unused) {
                        str2 = cell != null ? cell.getNumericCellValue() + "" : "";
                    }
                } catch (Exception unused2) {
                    str2 = cell.getBooleanCellValue() + "";
                }
                if (i2 == 0) {
                    if (str2.toLowerCase().contains(Config.KEY.toLowerCase())) {
                        this.key_column = i3;
                    } else {
                        for (LanguageWriter languageWriter : Config.LANGUAGE_WRITERS) {
                            if (str2.toLowerCase().contains(languageWriter.getExcelHead().toLowerCase())) {
                                languageWriter.setColumn(i3);
                            }
                        }
                    }
                } else if (i3 == this.key_column) {
                    translateItem.key = str2.toLowerCase();
                } else {
                    for (LanguageWriter languageWriter2 : Config.LANGUAGE_WRITERS) {
                        if (i3 == languageWriter2.getColumn()) {
                            translateItem.content.put(languageWriter2.getType(), str2);
                        }
                    }
                }
            }
            if (translateItem != null && translateItem.key != null && !translateItem.key.isEmpty()) {
                this.cellList.add(translateItem);
            }
            i2++;
        }
        xSSFWorkbook.close();
    }

    public List<TranslateItem> getItems() {
        return this.cellList;
    }
}