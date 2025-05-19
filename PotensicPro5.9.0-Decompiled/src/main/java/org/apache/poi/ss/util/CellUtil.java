package org.apache.poi.ss.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* loaded from: classes5.dex */
public final class CellUtil {
    public static final String ALIGNMENT = "alignment";
    public static final String BORDER_BOTTOM = "borderBottom";
    public static final String BORDER_LEFT = "borderLeft";
    public static final String BORDER_RIGHT = "borderRight";
    public static final String BORDER_TOP = "borderTop";
    public static final String BOTTOM_BORDER_COLOR = "bottomBorderColor";
    public static final String DATA_FORMAT = "dataFormat";
    public static final String FILL_BACKGROUND_COLOR = "fillBackgroundColor";
    public static final String FILL_FOREGROUND_COLOR = "fillForegroundColor";
    public static final String FILL_PATTERN = "fillPattern";
    public static final String FONT = "font";
    public static final String HIDDEN = "hidden";
    public static final String INDENTION = "indention";
    public static final String LEFT_BORDER_COLOR = "leftBorderColor";
    public static final String LOCKED = "locked";
    public static final String RIGHT_BORDER_COLOR = "rightBorderColor";
    public static final String ROTATION = "rotation";
    public static final String TOP_BORDER_COLOR = "topBorderColor";
    public static final String VERTICAL_ALIGNMENT = "verticalAlignment";
    public static final String WRAP_TEXT = "wrapText";
    private static UnicodeMapping[] unicodeMappings = {um("alpha", "α"), um("beta", "β"), um("gamma", "γ"), um("delta", "δ"), um("epsilon", "ε"), um("zeta", "ζ"), um("eta", "η"), um("theta", "θ"), um("iota", "ι"), um("kappa", "κ"), um("lambda", "λ"), um("mu", "μ"), um("nu", "ν"), um("xi", "ξ"), um("omicron", "ο")};

    private static final class UnicodeMapping {
        public final String entityName;
        public final String resolvedValue;

        public UnicodeMapping(String str, String str2) {
            this.entityName = "&" + str + ";";
            this.resolvedValue = str2;
        }
    }

    private CellUtil() {
    }

    public static Row getRow(int i, Sheet sheet) {
        Row row = sheet.getRow(i);
        return row == null ? sheet.createRow(i) : row;
    }

    public static Cell getCell(Row row, int i) {
        Cell cell = row.getCell(i);
        return cell == null ? row.createCell(i) : cell;
    }

    public static Cell createCell(Row row, int i, String str, CellStyle cellStyle) {
        Cell cell = getCell(row, i);
        cell.setCellValue(cell.getRow().getSheet().getWorkbook().getCreationHelper().createRichTextString(str));
        if (cellStyle != null) {
            cell.setCellStyle(cellStyle);
        }
        return cell;
    }

    public static Cell createCell(Row row, int i, String str) {
        return createCell(row, i, str, null);
    }

    public static void setAlignment(Cell cell, Workbook workbook, short s) {
        setCellStyleProperty(cell, workbook, ALIGNMENT, Short.valueOf(s));
    }

    public static void setFont(Cell cell, Workbook workbook, Font font) {
        setCellStyleProperty(cell, workbook, FONT, Short.valueOf(font.getIndex()));
    }

    public static void setCellStyleProperty(Cell cell, Workbook workbook, String str, Object obj) {
        CellStyle cellStyle;
        Map<String, Object> formatProperties = getFormatProperties(cell.getCellStyle());
        formatProperties.put(str, obj);
        short numCellStyles = workbook.getNumCellStyles();
        short s = 0;
        while (true) {
            if (s >= numCellStyles) {
                cellStyle = null;
                break;
            }
            cellStyle = workbook.getCellStyleAt(s);
            if (getFormatProperties(cellStyle).equals(formatProperties)) {
                break;
            } else {
                s = (short) (s + 1);
            }
        }
        if (cellStyle == null) {
            cellStyle = workbook.createCellStyle();
            setFormatProperties(cellStyle, workbook, formatProperties);
        }
        cell.setCellStyle(cellStyle);
    }

    private static Map<String, Object> getFormatProperties(CellStyle cellStyle) {
        HashMap hashMap = new HashMap();
        putShort(hashMap, ALIGNMENT, cellStyle.getAlignment());
        putShort(hashMap, BORDER_BOTTOM, cellStyle.getBorderBottom());
        putShort(hashMap, BORDER_LEFT, cellStyle.getBorderLeft());
        putShort(hashMap, BORDER_RIGHT, cellStyle.getBorderRight());
        putShort(hashMap, BORDER_TOP, cellStyle.getBorderTop());
        putShort(hashMap, BOTTOM_BORDER_COLOR, cellStyle.getBottomBorderColor());
        putShort(hashMap, DATA_FORMAT, cellStyle.getDataFormat());
        putShort(hashMap, FILL_BACKGROUND_COLOR, cellStyle.getFillBackgroundColor());
        putShort(hashMap, FILL_FOREGROUND_COLOR, cellStyle.getFillForegroundColor());
        putShort(hashMap, FILL_PATTERN, cellStyle.getFillPattern());
        putShort(hashMap, FONT, cellStyle.getFontIndex());
        putBoolean(hashMap, HIDDEN, cellStyle.getHidden());
        putShort(hashMap, INDENTION, cellStyle.getIndention());
        putShort(hashMap, LEFT_BORDER_COLOR, cellStyle.getLeftBorderColor());
        putBoolean(hashMap, LOCKED, cellStyle.getLocked());
        putShort(hashMap, RIGHT_BORDER_COLOR, cellStyle.getRightBorderColor());
        putShort(hashMap, ROTATION, cellStyle.getRotation());
        putShort(hashMap, TOP_BORDER_COLOR, cellStyle.getTopBorderColor());
        putShort(hashMap, VERTICAL_ALIGNMENT, cellStyle.getVerticalAlignment());
        putBoolean(hashMap, WRAP_TEXT, cellStyle.getWrapText());
        return hashMap;
    }

    private static void setFormatProperties(CellStyle cellStyle, Workbook workbook, Map<String, Object> map) {
        cellStyle.setAlignment(getShort(map, ALIGNMENT));
        cellStyle.setBorderBottom(getShort(map, BORDER_BOTTOM));
        cellStyle.setBorderLeft(getShort(map, BORDER_LEFT));
        cellStyle.setBorderRight(getShort(map, BORDER_RIGHT));
        cellStyle.setBorderTop(getShort(map, BORDER_TOP));
        cellStyle.setBottomBorderColor(getShort(map, BOTTOM_BORDER_COLOR));
        cellStyle.setDataFormat(getShort(map, DATA_FORMAT));
        cellStyle.setFillBackgroundColor(getShort(map, FILL_BACKGROUND_COLOR));
        cellStyle.setFillForegroundColor(getShort(map, FILL_FOREGROUND_COLOR));
        cellStyle.setFillPattern(getShort(map, FILL_PATTERN));
        cellStyle.setFont(workbook.getFontAt(getShort(map, FONT)));
        cellStyle.setHidden(getBoolean(map, HIDDEN));
        cellStyle.setIndention(getShort(map, INDENTION));
        cellStyle.setLeftBorderColor(getShort(map, LEFT_BORDER_COLOR));
        cellStyle.setLocked(getBoolean(map, LOCKED));
        cellStyle.setRightBorderColor(getShort(map, RIGHT_BORDER_COLOR));
        cellStyle.setRotation(getShort(map, ROTATION));
        cellStyle.setTopBorderColor(getShort(map, TOP_BORDER_COLOR));
        cellStyle.setVerticalAlignment(getShort(map, VERTICAL_ALIGNMENT));
        cellStyle.setWrapText(getBoolean(map, WRAP_TEXT));
    }

    private static short getShort(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Short) {
            return ((Short) obj).shortValue();
        }
        return (short) 0;
    }

    private static boolean getBoolean(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private static void putShort(Map<String, Object> map, String str, short s) {
        map.put(str, Short.valueOf(s));
    }

    private static void putBoolean(Map<String, Object> map, String str, boolean z) {
        map.put(str, Boolean.valueOf(z));
    }

    public static Cell translateUnicodeValues(Cell cell) {
        String string = cell.getRichStringCellValue().getString();
        String lowerCase = string.toLowerCase();
        int i = 0;
        boolean z = false;
        while (true) {
            UnicodeMapping[] unicodeMappingArr = unicodeMappings;
            if (i >= unicodeMappingArr.length) {
                break;
            }
            UnicodeMapping unicodeMapping = unicodeMappingArr[i];
            String str = unicodeMapping.entityName;
            if (lowerCase.indexOf(str) != -1) {
                string = string.replaceAll(str, unicodeMapping.resolvedValue);
                z = true;
            }
            i++;
        }
        if (z) {
            cell.setCellValue(cell.getRow().getSheet().getWorkbook().getCreationHelper().createRichTextString(string));
        }
        return cell;
    }

    private static UnicodeMapping um(String str, String str2) {
        return new UnicodeMapping(str, str2);
    }
}
