package org.apache.poi.ss.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* loaded from: classes5.dex */
public final class RegionUtil {
    private RegionUtil() {
    }

    private static final class CellPropertySetter {
        private final String _propertyName;
        private final Short _propertyValue;
        private final Workbook _workbook;

        public CellPropertySetter(Workbook workbook, String str, int i) {
            this._workbook = workbook;
            this._propertyName = str;
            this._propertyValue = Short.valueOf((short) i);
        }

        public void setProperty(Row row, int i) {
            CellUtil.setCellStyleProperty(CellUtil.getCell(row, i), this._workbook, this._propertyName, this._propertyValue);
        }
    }

    public static void setBorderLeft(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.BORDER_LEFT, i);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            cellPropertySetter.setProperty(CellUtil.getRow(firstRow, sheet), firstColumn);
        }
    }

    public static void setLeftBorderColor(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.LEFT_BORDER_COLOR, i);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            cellPropertySetter.setProperty(CellUtil.getRow(firstRow, sheet), firstColumn);
        }
    }

    public static void setBorderRight(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.BORDER_RIGHT, i);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            cellPropertySetter.setProperty(CellUtil.getRow(firstRow, sheet), lastColumn);
        }
    }

    public static void setRightBorderColor(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.RIGHT_BORDER_COLOR, i);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            cellPropertySetter.setProperty(CellUtil.getRow(firstRow, sheet), lastColumn);
        }
    }

    public static void setBorderBottom(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastColumn = cellRangeAddress.getLastColumn();
        int lastRow = cellRangeAddress.getLastRow();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.BORDER_BOTTOM, i);
        Row row = CellUtil.getRow(lastRow, sheet);
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            cellPropertySetter.setProperty(row, firstColumn);
        }
    }

    public static void setBottomBorderColor(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastColumn = cellRangeAddress.getLastColumn();
        int lastRow = cellRangeAddress.getLastRow();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.BOTTOM_BORDER_COLOR, i);
        Row row = CellUtil.getRow(lastRow, sheet);
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            cellPropertySetter.setProperty(row, firstColumn);
        }
    }

    public static void setBorderTop(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastColumn = cellRangeAddress.getLastColumn();
        int firstRow = cellRangeAddress.getFirstRow();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.BORDER_TOP, i);
        Row row = CellUtil.getRow(firstRow, sheet);
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            cellPropertySetter.setProperty(row, firstColumn);
        }
    }

    public static void setTopBorderColor(int i, CellRangeAddress cellRangeAddress, Sheet sheet, Workbook workbook) {
        int lastColumn = cellRangeAddress.getLastColumn();
        int firstRow = cellRangeAddress.getFirstRow();
        CellPropertySetter cellPropertySetter = new CellPropertySetter(workbook, CellUtil.TOP_BORDER_COLOR, i);
        Row row = CellUtil.getRow(firstRow, sheet);
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            cellPropertySetter.setProperty(row, firstColumn);
        }
    }
}
