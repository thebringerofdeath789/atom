package org.apache.poi.ss.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;

/* loaded from: classes5.dex */
public class CellReference {
    private static final char ABSOLUTE_REFERENCE_MARKER = '$';
    private static final char SHEET_NAME_DELIMITER = '!';
    private static final char SPECIAL_NAME_DELIMITER = '\'';
    private final int _colIndex;
    private final boolean _isColAbs;
    private final boolean _isRowAbs;
    private final int _rowIndex;
    private final String _sheetName;
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("\\$?([A-Za-z]+)\\$?([0-9]+)");
    private static final Pattern COLUMN_REF_PATTERN = Pattern.compile("\\$?([A-Za-z]+)");
    private static final Pattern ROW_REF_PATTERN = Pattern.compile("\\$?([0-9]+)");
    private static final Pattern NAMED_RANGE_NAME_PATTERN = Pattern.compile("[_A-Za-z][_.A-Za-z0-9]*");

    public enum NameType {
        CELL,
        NAMED_RANGE,
        COLUMN,
        ROW,
        BAD_CELL_OR_NAMED_RANGE
    }

    public CellReference(String str) {
        if (str.endsWith("#REF!")) {
            throw new IllegalArgumentException("Cell reference invalid: " + str);
        }
        String[] separateRefParts = separateRefParts(str);
        boolean z = false;
        this._sheetName = separateRefParts[0];
        String str2 = separateRefParts[1];
        boolean z2 = str2.length() > 0 && str2.charAt(0) == '$';
        this._isColAbs = z2;
        str2 = z2 ? str2.substring(1) : str2;
        if (str2.length() == 0) {
            this._colIndex = -1;
        } else {
            this._colIndex = convertColStringToIndex(str2);
        }
        String str3 = separateRefParts[2];
        if (str3.length() > 0 && str3.charAt(0) == '$') {
            z = true;
        }
        this._isRowAbs = z;
        str3 = z ? str3.substring(1) : str3;
        if (str3.length() == 0) {
            this._rowIndex = -1;
        } else {
            this._rowIndex = Integer.parseInt(str3) - 1;
        }
    }

    public CellReference(int i, int i2) {
        this(i, i2, false, false);
    }

    public CellReference(int i, short s) {
        this(i, s & 65535, false, false);
    }

    public CellReference(Cell cell) {
        this(cell.getRowIndex(), cell.getColumnIndex(), false, false);
    }

    public CellReference(int i, int i2, boolean z, boolean z2) {
        this(null, i, i2, z, z2);
    }

    public CellReference(String str, int i, int i2, boolean z, boolean z2) {
        if (i < -1) {
            throw new IllegalArgumentException("row index may not be negative, but had " + i);
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("column index may not be negative, but had " + i2);
        }
        this._sheetName = str;
        this._rowIndex = i;
        this._colIndex = i2;
        this._isRowAbs = z;
        this._isColAbs = z2;
    }

    public int getRow() {
        return this._rowIndex;
    }

    public short getCol() {
        return (short) this._colIndex;
    }

    public boolean isRowAbsolute() {
        return this._isRowAbs;
    }

    public boolean isColAbsolute() {
        return this._isColAbs;
    }

    public String getSheetName() {
        return this._sheetName;
    }

    public static boolean isPartAbsolute(String str) {
        return str.charAt(0) == '$';
    }

    public static int convertColStringToIndex(String str) {
        char[] charArray = str.toUpperCase().toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (c != '$') {
                i = (i * 26) + (c - 'A') + 1;
            } else if (i2 != 0) {
                throw new IllegalArgumentException("Bad col ref format '" + str + "'");
            }
        }
        return i - 1;
    }

    public static NameType classifyCellReference(String str, SpreadsheetVersion spreadsheetVersion) {
        int length = str.length();
        if (length < 1) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
        char charAt = str.charAt(0);
        if (charAt != '$' && charAt != '.' && charAt != '_' && !Character.isLetter(charAt) && !Character.isDigit(charAt)) {
            throw new IllegalArgumentException("Invalid first char (" + charAt + ") of cell reference or named range.  Letter expected");
        }
        if (!Character.isDigit(str.charAt(length - 1))) {
            return validateNamedRangeName(str, spreadsheetVersion);
        }
        Matcher matcher = CELL_REF_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return validateNamedRangeName(str, spreadsheetVersion);
        }
        if (cellReferenceIsWithinRange(matcher.group(1), matcher.group(2), spreadsheetVersion)) {
            return NameType.CELL;
        }
        if (str.indexOf(36) >= 0) {
            return NameType.BAD_CELL_OR_NAMED_RANGE;
        }
        return NameType.NAMED_RANGE;
    }

    private static NameType validateNamedRangeName(String str, SpreadsheetVersion spreadsheetVersion) {
        Matcher matcher = COLUMN_REF_PATTERN.matcher(str);
        if (matcher.matches() && isColumnWithnRange(matcher.group(1), spreadsheetVersion)) {
            return NameType.COLUMN;
        }
        Matcher matcher2 = ROW_REF_PATTERN.matcher(str);
        if (matcher2.matches() && isRowWithnRange(matcher2.group(1), spreadsheetVersion)) {
            return NameType.ROW;
        }
        if (!NAMED_RANGE_NAME_PATTERN.matcher(str).matches()) {
            return NameType.BAD_CELL_OR_NAMED_RANGE;
        }
        return NameType.NAMED_RANGE;
    }

    public static boolean cellReferenceIsWithinRange(String str, String str2, SpreadsheetVersion spreadsheetVersion) {
        if (isColumnWithnRange(str, spreadsheetVersion)) {
            return isRowWithnRange(str2, spreadsheetVersion);
        }
        return false;
    }

    public static boolean isColumnWithnRange(String str, SpreadsheetVersion spreadsheetVersion) {
        String lastColumnName = spreadsheetVersion.getLastColumnName();
        int length = lastColumnName.length();
        int length2 = str.length();
        if (length2 > length) {
            return false;
        }
        return length2 != length || str.toUpperCase().compareTo(lastColumnName) <= 0;
    }

    public static boolean isRowWithnRange(String str, SpreadsheetVersion spreadsheetVersion) {
        int parseInt = Integer.parseInt(str);
        if (parseInt >= 0) {
            return parseInt != 0 && parseInt <= spreadsheetVersion.getMaxRows();
        }
        throw new IllegalStateException("Invalid rowStr '" + str + "'.");
    }

    private static String[] separateRefParts(String str) {
        int lastIndexOf = str.lastIndexOf(33);
        String parseSheetName = parseSheetName(str, lastIndexOf);
        int i = lastIndexOf + 1;
        int length = str.length();
        int i2 = str.charAt(i) == '$' ? i + 1 : i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (Character.isDigit(charAt) || charAt == '$') {
                break;
            }
            i2++;
        }
        return new String[]{parseSheetName, str.substring(i, i2), str.substring(i2)};
    }

    private static String parseSheetName(String str, int i) {
        if (i < 0) {
            return null;
        }
        if (!(str.charAt(0) == '\'')) {
            return str.substring(0, i);
        }
        int i2 = i - 1;
        if (str.charAt(i2) != '\'') {
            throw new RuntimeException("Mismatched quotes: (" + str + ")");
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        int i3 = 1;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt != '\'') {
                stringBuffer.append(charAt);
            } else {
                if (i3 < i2) {
                    i3++;
                    if (str.charAt(i3) == '\'') {
                        stringBuffer.append(charAt);
                    }
                }
                throw new RuntimeException("Bad sheet name quote escaping: (" + str + ")");
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    public static String convertNumToColString(int i) {
        int i2 = i + 1;
        StringBuilder sb = new StringBuilder(2);
        while (i2 > 0) {
            int i3 = i2 % 26;
            if (i3 == 0) {
                i3 = 26;
            }
            i2 = (i2 - i3) / 26;
            sb.insert(0, (char) (i3 + 64));
        }
        return sb.toString();
    }

    public String formatAsString() {
        StringBuffer stringBuffer = new StringBuffer(32);
        String str = this._sheetName;
        if (str != null) {
            SheetNameFormatter.appendFormat(stringBuffer, str);
            stringBuffer.append(SHEET_NAME_DELIMITER);
        }
        appendCellReference(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(formatAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public String[] getCellRefParts() {
        return new String[]{this._sheetName, Integer.toString(this._rowIndex + 1), convertNumToColString(this._colIndex)};
    }

    void appendCellReference(StringBuffer stringBuffer) {
        if (this._colIndex != -1) {
            if (this._isColAbs) {
                stringBuffer.append('$');
            }
            stringBuffer.append(convertNumToColString(this._colIndex));
        }
        if (this._rowIndex != -1) {
            if (this._isRowAbs) {
                stringBuffer.append('$');
            }
            stringBuffer.append(this._rowIndex + 1);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CellReference)) {
            return false;
        }
        CellReference cellReference = (CellReference) obj;
        return this._rowIndex == cellReference._rowIndex && this._colIndex == cellReference._colIndex && this._isRowAbs == cellReference._isRowAbs && this._isColAbs == cellReference._isColAbs;
    }

    public int hashCode() {
        return ((((((527 + this._rowIndex) * 31) + this._colIndex) * 31) + (this._isRowAbs ? 1 : 0)) * 31) + (this._isColAbs ? 1 : 0);
    }
}
