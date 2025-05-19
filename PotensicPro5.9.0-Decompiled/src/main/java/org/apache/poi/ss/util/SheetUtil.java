package org.apache.poi.ss.util;

import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* loaded from: classes5.dex */
public class SheetUtil {
    private static final char defaultChar = '0';
    private static final double fontHeightMultiple = 2.0d;
    private static final FormulaEvaluator dummyEvaluator = new FormulaEvaluator() { // from class: org.apache.poi.ss.util.SheetUtil.1
        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void clearAllCachedResultValues() {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public CellValue evaluate(Cell cell) {
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void evaluateAll() {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public Cell evaluateInCell(Cell cell) {
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifyDeleteCell(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifySetFormula(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifyUpdateCell(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setDebugEvaluationOutputForNextEval(boolean z) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setIgnoreMissingWorkbooks(boolean z) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public int evaluateFormulaCell(Cell cell) {
            return cell.getCachedFormulaResultType();
        }
    };
    private static final FontRenderContext fontRenderContext = new FontRenderContext((AffineTransform) null, true, true);

    public static double getCellWidth(Cell cell, int i, DataFormatter dataFormatter, boolean z) {
        String[] strArr;
        double max;
        Sheet sheet = cell.getSheet();
        Workbook workbook = sheet.getWorkbook();
        Row row = cell.getRow();
        int columnIndex = cell.getColumnIndex();
        int i2 = 0;
        Cell cell2 = cell;
        int i3 = 1;
        for (int i4 = 0; i4 < sheet.getNumMergedRegions(); i4++) {
            CellRangeAddress mergedRegion = sheet.getMergedRegion(i4);
            if (containsCell(mergedRegion, row.getRowNum(), columnIndex)) {
                if (!z) {
                    return -1.0d;
                }
                cell2 = row.getCell(mergedRegion.getFirstColumn());
                i3 = (mergedRegion.getLastColumn() + 1) - mergedRegion.getFirstColumn();
            }
        }
        CellStyle cellStyle = cell2.getCellStyle();
        int cellType = cell2.getCellType();
        if (cellType == 2) {
            cellType = cell2.getCachedFormulaResultType();
        }
        Font fontAt = workbook.getFontAt(cellStyle.getFontIndex());
        double d = fontHeightMultiple;
        if (cellType != 1) {
            String str = null;
            if (cellType == 0) {
                try {
                    str = dataFormatter.formatCellValue(cell2, dummyEvaluator);
                } catch (Exception unused) {
                    str = String.valueOf(cell2.getNumericCellValue());
                }
            } else if (cellType == 4) {
                str = String.valueOf(cell2.getBooleanCellValue()).toUpperCase();
            }
            if (str == null) {
                return -1.0d;
            }
            String str2 = str + defaultChar;
            AttributedString attributedString = new AttributedString(str2);
            copyAttributes(fontAt, attributedString, 0, str2.length());
            TextLayout textLayout = new TextLayout(attributedString.getIterator(), fontRenderContext);
            if (cellStyle.getRotation() != 0) {
                AffineTransform affineTransform = new AffineTransform();
                affineTransform.concatenate(AffineTransform.getRotateInstance(((cellStyle.getRotation() * fontHeightMultiple) * 3.141592653589793d) / 360.0d));
                affineTransform.concatenate(AffineTransform.getScaleInstance(1.0d, fontHeightMultiple));
                return Math.max(-1.0d, ((textLayout.getOutline(affineTransform).getBounds().getWidth() / i3) / i) + cell2.getCellStyle().getIndention());
            }
            return Math.max(-1.0d, ((textLayout.getBounds().getWidth() / i3) / i) + cell2.getCellStyle().getIndention());
        }
        RichTextString richStringCellValue = cell2.getRichStringCellValue();
        String[] split = richStringCellValue.getString().split("\\n");
        int i5 = 0;
        double d2 = -1.0d;
        while (i5 < split.length) {
            String str3 = split[i5] + defaultChar;
            AttributedString attributedString2 = new AttributedString(str3);
            copyAttributes(fontAt, attributedString2, i2, str3.length());
            richStringCellValue.numFormattingRuns();
            TextLayout textLayout2 = new TextLayout(attributedString2.getIterator(), fontRenderContext);
            if (cellStyle.getRotation() != 0) {
                AffineTransform affineTransform2 = new AffineTransform();
                strArr = split;
                affineTransform2.concatenate(AffineTransform.getRotateInstance(((cellStyle.getRotation() * d) * 3.141592653589793d) / 360.0d));
                affineTransform2.concatenate(AffineTransform.getScaleInstance(1.0d, d));
                max = Math.max(d2, ((textLayout2.getOutline(affineTransform2).getBounds().getWidth() / i3) / i) + cell2.getCellStyle().getIndention());
            } else {
                strArr = split;
                max = Math.max(d2, ((textLayout2.getBounds().getWidth() / i3) / i) + cell2.getCellStyle().getIndention());
            }
            i5++;
            d2 = max;
            i2 = 0;
            d = fontHeightMultiple;
            split = strArr;
        }
        return d2;
    }

    public static double getColumnWidth(Sheet sheet, int i, boolean z) {
        Workbook workbook = sheet.getWorkbook();
        DataFormatter dataFormatter = new DataFormatter();
        Font fontAt = workbook.getFontAt((short) 0);
        AttributedString attributedString = new AttributedString(String.valueOf(defaultChar));
        copyAttributes(fontAt, attributedString, 0, 1);
        int advance = (int) new TextLayout(attributedString.getIterator(), fontRenderContext).getAdvance();
        Iterator<Row> it = sheet.iterator();
        double d = -1.0d;
        while (it.hasNext()) {
            Cell cell = it.next().getCell(i);
            if (cell != null) {
                d = Math.max(d, getCellWidth(cell, advance, dataFormatter, z));
            }
        }
        return d;
    }

    public static double getColumnWidth(Sheet sheet, int i, boolean z, int i2, int i3) {
        Cell cell;
        Workbook workbook = sheet.getWorkbook();
        DataFormatter dataFormatter = new DataFormatter();
        Font fontAt = workbook.getFontAt((short) 0);
        AttributedString attributedString = new AttributedString(String.valueOf(defaultChar));
        copyAttributes(fontAt, attributedString, 0, 1);
        int advance = (int) new TextLayout(attributedString.getIterator(), fontRenderContext).getAdvance();
        double d = -1.0d;
        while (i2 <= i3) {
            Row row = sheet.getRow(i2);
            if (row != null && (cell = row.getCell(i)) != null) {
                d = Math.max(d, getCellWidth(cell, advance, dataFormatter, z));
            }
            i2++;
        }
        return d;
    }

    private static void copyAttributes(Font font, AttributedString attributedString, int i, int i2) {
        attributedString.addAttribute(TextAttribute.FAMILY, font.getFontName(), i, i2);
        attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(font.getFontHeightInPoints()));
        if (font.getBoldweight() == 700) {
            attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, i, i2);
        }
        if (font.getItalic()) {
            attributedString.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, i, i2);
        }
        if (font.getUnderline() == 1) {
            attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, i, i2);
        }
    }

    public static boolean containsCell(CellRangeAddress cellRangeAddress, int i, int i2) {
        return cellRangeAddress.getFirstRow() <= i && cellRangeAddress.getLastRow() >= i && cellRangeAddress.getFirstColumn() <= i2 && cellRangeAddress.getLastColumn() >= i2;
    }

    public static Cell getCellWithMerges(Sheet sheet, int i, int i2) {
        Row row;
        Cell cell;
        Row row2 = sheet.getRow(i);
        if (row2 != null && (cell = row2.getCell(i2)) != null) {
            return cell;
        }
        for (int i3 = 0; i3 < sheet.getNumMergedRegions(); i3++) {
            CellRangeAddress mergedRegion = sheet.getMergedRegion(i3);
            if (mergedRegion.isInRange(i, i2) && (row = sheet.getRow(mergedRegion.getFirstRow())) != null) {
                return row.getCell(mergedRegion.getFirstColumn());
            }
        }
        return null;
    }
}
