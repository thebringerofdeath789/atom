package jxl.biff;

import common.Logger;
import jxl.biff.formula.ExternalSheet;

/* loaded from: classes4.dex */
public final class CellReferenceHelper {
    static /* synthetic */ Class class$jxl$biff$CellReferenceHelper = null;
    private static final char fixedInd = '$';
    private static Logger logger = null;
    private static final char sheetInd = '!';

    static {
        Class cls = class$jxl$biff$CellReferenceHelper;
        if (cls == null) {
            cls = class$("jxl.biff.CellReferenceHelper");
            class$jxl$biff$CellReferenceHelper = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private CellReferenceHelper() {
    }

    public static void getCellReference(int i, int i2, StringBuffer stringBuffer) {
        getColumnReference(i, stringBuffer);
        stringBuffer.append(Integer.toString(i2 + 1));
    }

    public static void getCellReference(int i, boolean z, int i2, boolean z2, StringBuffer stringBuffer) {
        if (z) {
            stringBuffer.append('$');
        }
        getColumnReference(i, stringBuffer);
        if (z2) {
            stringBuffer.append('$');
        }
        stringBuffer.append(Integer.toString(i2 + 1));
    }

    public static String getColumnReference(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        getColumnReference(i, stringBuffer);
        return stringBuffer.toString();
    }

    public static void getColumnReference(int i, StringBuffer stringBuffer) {
        int i2 = i % 26;
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i3 = i / 26; i3 != 0; i3 /= 26) {
            stringBuffer2.append((char) (i2 + 65));
            i2 = (i3 % 26) - 1;
        }
        stringBuffer2.append((char) (i2 + 65));
        for (int length = stringBuffer2.length() - 1; length >= 0; length--) {
            stringBuffer.append(stringBuffer2.charAt(length));
        }
    }

    public static void getCellReference(int i, int i2, int i3, ExternalSheet externalSheet, StringBuffer stringBuffer) {
        stringBuffer.append(StringHelper.replace(externalSheet.getExternalSheetName(i), "'", "''"));
        stringBuffer.append(sheetInd);
        getCellReference(i2, i3, stringBuffer);
    }

    public static void getCellReference(int i, int i2, boolean z, int i3, boolean z2, ExternalSheet externalSheet, StringBuffer stringBuffer) {
        stringBuffer.append(externalSheet.getExternalSheetName(i));
        stringBuffer.append(sheetInd);
        getCellReference(i2, z, i3, z2, stringBuffer);
    }

    public static String getCellReference(int i, int i2, int i3, ExternalSheet externalSheet) {
        StringBuffer stringBuffer = new StringBuffer();
        getCellReference(i, i2, i3, externalSheet, stringBuffer);
        return stringBuffer.toString();
    }

    public static String getCellReference(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        getCellReference(i, i2, stringBuffer);
        return stringBuffer.toString();
    }

    public static int getColumn(String str) {
        int numberIndex = getNumberIndex(str);
        String upperCase = str.toUpperCase();
        int lastIndexOf = str.lastIndexOf(33) + 1;
        if (str.charAt(lastIndexOf) == '$') {
            lastIndexOf++;
        }
        if (str.charAt(numberIndex - 1) == '$') {
            numberIndex--;
        }
        int i = 0;
        for (int i2 = lastIndexOf; i2 < numberIndex; i2++) {
            if (i2 != lastIndexOf) {
                i = (i + 1) * 26;
            }
            i += upperCase.charAt(i2) - 'A';
        }
        return i;
    }

    public static int getRow(String str) {
        try {
            return Integer.parseInt(str.substring(getNumberIndex(str))) - 1;
        } catch (NumberFormatException e) {
            logger.warn(e, e);
            return 65535;
        }
    }

    private static int getNumberIndex(String str) {
        int lastIndexOf = str.lastIndexOf(33) + 1;
        boolean z = false;
        while (!z && lastIndexOf < str.length()) {
            char charAt = str.charAt(lastIndexOf);
            if (charAt < '0' || charAt > '9') {
                lastIndexOf++;
            } else {
                z = true;
            }
        }
        return lastIndexOf;
    }

    public static boolean isColumnRelative(String str) {
        return str.charAt(0) != '$';
    }

    public static boolean isRowRelative(String str) {
        return str.charAt(getNumberIndex(str) - 1) != '$';
    }

    public static String getSheet(String str) {
        int lastIndexOf = str.lastIndexOf(33);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }
}
