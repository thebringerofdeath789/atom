package org.apache.poi.ss.formula;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellReference;

/* loaded from: classes5.dex */
public final class SheetNameFormatter {
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("([A-Za-z]+)([0-9]+)");
    private static final char DELIMITER = '\'';

    private SheetNameFormatter() {
    }

    public static String format(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() + 2);
        appendFormat(stringBuffer, str);
        return stringBuffer.toString();
    }

    public static void appendFormat(StringBuffer stringBuffer, String str) {
        if (needsDelimiting(str)) {
            stringBuffer.append(DELIMITER);
            appendAndEscape(stringBuffer, str);
            stringBuffer.append(DELIMITER);
            return;
        }
        stringBuffer.append(str);
    }

    public static void appendFormat(StringBuffer stringBuffer, String str, String str2) {
        if (needsDelimiting(str) || needsDelimiting(str2)) {
            stringBuffer.append(DELIMITER);
            stringBuffer.append(PropertyUtils.INDEXED_DELIM);
            appendAndEscape(stringBuffer, str.replace(PropertyUtils.INDEXED_DELIM, PropertyUtils.MAPPED_DELIM).replace(PropertyUtils.INDEXED_DELIM2, PropertyUtils.MAPPED_DELIM2));
            stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
            appendAndEscape(stringBuffer, str2);
            stringBuffer.append(DELIMITER);
            return;
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        stringBuffer.append(str);
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        stringBuffer.append(str2);
    }

    private static void appendAndEscape(StringBuffer stringBuffer, String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'') {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append(charAt);
        }
    }

    private static boolean needsDelimiting(String str) {
        int length = str.length();
        if (length < 1) {
            throw new RuntimeException("Zero length string is an invalid sheet name");
        }
        if (Character.isDigit(str.charAt(0))) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (isSpecialChar(str.charAt(i))) {
                return true;
            }
        }
        return (Character.isLetter(str.charAt(0)) && Character.isDigit(str.charAt(length - 1)) && nameLooksLikePlainCellReference(str)) || nameLooksLikeBooleanLiteral(str);
    }

    private static boolean nameLooksLikeBooleanLiteral(String str) {
        char charAt = str.charAt(0);
        if (charAt != 'F') {
            if (charAt != 'T') {
                if (charAt != 'f') {
                    if (charAt != 't') {
                        return false;
                    }
                }
            }
            return "TRUE".equalsIgnoreCase(str);
        }
        return "FALSE".equalsIgnoreCase(str);
    }

    static boolean isSpecialChar(char c) {
        if (Character.isLetterOrDigit(c)) {
            return false;
        }
        if (c == '\t' || c == '\n' || c == '\r') {
            throw new RuntimeException("Illegal character (0x" + Integer.toHexString(c) + ") found in sheet name");
        }
        return (c == '.' || c == '_') ? false : true;
    }

    static boolean cellReferenceIsWithinRange(String str, String str2) {
        return CellReference.cellReferenceIsWithinRange(str, str2, SpreadsheetVersion.EXCEL97);
    }

    static boolean nameLooksLikePlainCellReference(String str) {
        Matcher matcher = CELL_REF_PATTERN.matcher(str);
        if (matcher.matches()) {
            return cellReferenceIsWithinRange(matcher.group(1), matcher.group(2));
        }
        return false;
    }
}
