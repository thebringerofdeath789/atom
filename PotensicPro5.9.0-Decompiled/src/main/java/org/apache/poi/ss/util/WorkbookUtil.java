package org.apache.poi.ss.util;

/* loaded from: classes5.dex */
public class WorkbookUtil {
    public static final String createSafeSheetName(String str) {
        return createSafeSheetName(str, ' ');
    }

    public static final String createSafeSheetName(String str, char c) {
        if (str == null) {
            return "null";
        }
        if (str.length() < 1) {
            return "empty";
        }
        int min = Math.min(31, str.length());
        StringBuilder sb = new StringBuilder(str.substring(0, min));
        for (int i = 0; i < min; i++) {
            char charAt = sb.charAt(i);
            if (charAt != 0 && charAt != 3) {
                if (charAt != '\'') {
                    if (charAt != '*' && charAt != '/' && charAt != ':' && charAt != '?') {
                        switch (charAt) {
                        }
                    }
                } else if (i == 0 || i == min - 1) {
                    sb.setCharAt(i, c);
                }
            }
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }

    public static void validateSheetName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        int length = str.length();
        if (length < 1 || length > 31) {
            throw new IllegalArgumentException("sheetName '" + str + "' is invalid - character count MUST be greater than or equal to 1 and less than or equal to 31");
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '*' && charAt != '/' && charAt != ':' && charAt != '?') {
                switch (charAt) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                }
            }
            throw new IllegalArgumentException("Invalid char (" + charAt + ") found at index (" + i + ") in sheet name '" + str + "'");
        }
        if (str.charAt(0) == '\'' || str.charAt(length - 1) == '\'') {
            throw new IllegalArgumentException("Invalid sheet name '" + str + "'. Sheet names must not begin or end with (').");
        }
    }

    public static void validateSheetState(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Ivalid sheet state : " + i + "\nSheet state must beone of the Workbook.SHEET_STATE_* constants");
        }
    }
}
