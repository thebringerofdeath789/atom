package org.apache.poi.hssf.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellUtil;

/* loaded from: classes5.dex */
public final class HSSFCellUtil {
    private HSSFCellUtil() {
    }

    public static HSSFRow getRow(int i, HSSFSheet hSSFSheet) {
        return (HSSFRow) CellUtil.getRow(i, hSSFSheet);
    }

    public static HSSFCell getCell(HSSFRow hSSFRow, int i) {
        return (HSSFCell) CellUtil.getCell(hSSFRow, i);
    }

    public static HSSFCell createCell(HSSFRow hSSFRow, int i, String str, HSSFCellStyle hSSFCellStyle) {
        return (HSSFCell) CellUtil.createCell(hSSFRow, i, str, hSSFCellStyle);
    }

    public static HSSFCell createCell(HSSFRow hSSFRow, int i, String str) {
        return createCell(hSSFRow, i, str, null);
    }

    public static void setAlignment(HSSFCell hSSFCell, HSSFWorkbook hSSFWorkbook, short s) {
        CellUtil.setAlignment(hSSFCell, hSSFWorkbook, s);
    }

    public static void setFont(HSSFCell hSSFCell, HSSFWorkbook hSSFWorkbook, HSSFFont hSSFFont) {
        CellUtil.setFont(hSSFCell, hSSFWorkbook, hSSFFont);
    }

    public static void setCellStyleProperty(HSSFCell hSSFCell, HSSFWorkbook hSSFWorkbook, String str, Object obj) {
        CellUtil.setCellStyleProperty(hSSFCell, hSSFWorkbook, str, obj);
    }

    public static HSSFCell translateUnicodeValues(HSSFCell hSSFCell) {
        CellUtil.translateUnicodeValues(hSSFCell);
        return hSSFCell;
    }
}
