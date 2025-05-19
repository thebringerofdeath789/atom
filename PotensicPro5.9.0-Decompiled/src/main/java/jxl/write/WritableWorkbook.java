package jxl.write;

import java.io.File;
import java.io.IOException;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;

/* loaded from: classes4.dex */
public abstract class WritableWorkbook {
    public static final WritableFont ARIAL_10_PT;
    public static final WritableCellFormat HIDDEN_STYLE;
    public static final WritableFont HYPERLINK_FONT;
    public static final WritableCellFormat HYPERLINK_STYLE;
    public static final WritableCellFormat NORMAL_STYLE;

    public abstract void addNameArea(String str, WritableSheet writableSheet, int i, int i2, int i3, int i4);

    public abstract void close() throws IOException, WriteException;

    public void copy(Workbook workbook) {
    }

    public abstract void copySheet(int i, String str, int i2);

    public abstract void copySheet(String str, String str2, int i);

    public abstract WritableSheet createSheet(String str, int i);

    public abstract Range[] findByName(String str);

    public abstract WritableCell findCellByName(String str);

    public abstract int getNumberOfSheets();

    public abstract String[] getRangeNames();

    public abstract WritableSheet getSheet(int i) throws IndexOutOfBoundsException;

    public abstract WritableSheet getSheet(String str);

    public abstract String[] getSheetNames();

    public abstract WritableSheet[] getSheets();

    public abstract WritableCell getWritableCell(String str);

    public abstract WritableSheet importSheet(String str, int i, Sheet sheet);

    public abstract WritableSheet moveSheet(int i, int i2);

    public abstract void removeRangeName(String str);

    public abstract void removeSheet(int i);

    public abstract void setColourRGB(jxl.format.Colour colour, int i, int i2, int i3);

    public abstract void setOutputFile(File file) throws IOException;

    public abstract void setProtected(boolean z);

    public abstract void write() throws IOException;

    static {
        WritableFont writableFont = new WritableFont(WritableFont.ARIAL);
        ARIAL_10_PT = writableFont;
        WritableFont writableFont2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.SINGLE, jxl.format.Colour.BLUE);
        HYPERLINK_FONT = writableFont2;
        NORMAL_STYLE = new WritableCellFormat(writableFont, NumberFormats.DEFAULT);
        HYPERLINK_STYLE = new WritableCellFormat(writableFont2);
        HIDDEN_STYLE = new WritableCellFormat(new DateFormat(";;;"));
    }

    protected WritableWorkbook() {
    }
}
