package com.lib.bean;

import java.io.File;
import java.io.IOException;
import java.util.List;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/* loaded from: classes2.dex */
public class ExcelWriter {
    private WritableWorkbook book;
    private WritableSheet sheet;

    public ExcelWriter(File file) throws IOException {
        WritableWorkbook createWorkbook = Workbook.createWorkbook(file);
        this.book = createWorkbook;
        this.sheet = createWorkbook.createSheet("page1", 0);
    }

    public void write(List<XmlCell> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            XmlCell xmlCell = list.get(i);
            this.sheet.addCell(new Label(0, i, xmlCell.getKey()));
            this.sheet.addCell(new Label(1, i, xmlCell.getValue()));
        }
    }

    public void close() throws Exception {
        this.book.write();
        this.book.close();
    }

    public void WriteInExcel() throws Exception {
        this.sheet.addCell(new Label(0, 0, "测试"));
    }
}
