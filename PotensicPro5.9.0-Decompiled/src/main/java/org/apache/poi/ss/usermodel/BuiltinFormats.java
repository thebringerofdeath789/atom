package org.apache.poi.ss.usermodel;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class BuiltinFormats {
    public static final int FIRST_USER_DEFINED_FORMAT_INDEX = 164;
    private static final String[] _formats;

    static {
        ArrayList arrayList = new ArrayList();
        putFormat(arrayList, 0, "General");
        putFormat(arrayList, 1, SessionDescription.SUPPORTED_SDP_VERSION);
        putFormat(arrayList, 2, "0.00");
        putFormat(arrayList, 3, "#,##0");
        putFormat(arrayList, 4, "#,##0.00");
        putFormat(arrayList, 5, "\"$\"#,##0_);(\"$\"#,##0)");
        putFormat(arrayList, 6, "\"$\"#,##0_);[Red](\"$\"#,##0)");
        putFormat(arrayList, 7, "\"$\"#,##0.00_);(\"$\"#,##0.00)");
        putFormat(arrayList, 8, "\"$\"#,##0.00_);[Red](\"$\"#,##0.00)");
        putFormat(arrayList, 9, "0%");
        putFormat(arrayList, 10, "0.00%");
        putFormat(arrayList, 11, "0.00E+00");
        putFormat(arrayList, 12, "# ?/?");
        putFormat(arrayList, 13, "# ??/??");
        putFormat(arrayList, 14, "m/d/yy");
        putFormat(arrayList, 15, "d-mmm-yy");
        putFormat(arrayList, 16, "d-mmm");
        putFormat(arrayList, 17, "mmm-yy");
        putFormat(arrayList, 18, "h:mm AM/PM");
        putFormat(arrayList, 19, "h:mm:ss AM/PM");
        putFormat(arrayList, 20, "h:mm");
        putFormat(arrayList, 21, "h:mm:ss");
        putFormat(arrayList, 22, "m/d/yy h:mm");
        for (int i = 23; i <= 36; i++) {
            putFormat(arrayList, i, "reserved-0x" + Integer.toHexString(i));
        }
        putFormat(arrayList, 37, "#,##0_);(#,##0)");
        putFormat(arrayList, 38, "#,##0_);[Red](#,##0)");
        putFormat(arrayList, 39, "#,##0.00_);(#,##0.00)");
        putFormat(arrayList, 40, "#,##0.00_);[Red](#,##0.00)");
        putFormat(arrayList, 41, "_(\"$\"* #,##0_);_(\"$\"* (#,##0);_(\"$\"* \"-\"_);_(@_)");
        putFormat(arrayList, 42, "_(* #,##0_);_(* (#,##0);_(* \"-\"_);_(@_)");
        putFormat(arrayList, 43, "_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);_(@_)");
        putFormat(arrayList, 44, "_(\"$\"* #,##0.00_);_(\"$\"* (#,##0.00);_(\"$\"* \"-\"??_);_(@_)");
        putFormat(arrayList, 45, "mm:ss");
        putFormat(arrayList, 46, "[h]:mm:ss");
        putFormat(arrayList, 47, "mm:ss.0");
        putFormat(arrayList, 48, "##0.0E+0");
        putFormat(arrayList, 49, "@");
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        _formats = strArr;
    }

    private static void putFormat(List<String> list, int i, String str) {
        if (list.size() != i) {
            throw new IllegalStateException("index " + i + " is wrong");
        }
        list.add(str);
    }

    public static Map<Integer, String> getBuiltinFormats() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (true) {
            String[] strArr = _formats;
            if (i >= strArr.length) {
                return linkedHashMap;
            }
            linkedHashMap.put(Integer.valueOf(i), strArr[i]);
            i++;
        }
    }

    public static String[] getAll() {
        return (String[]) _formats.clone();
    }

    public static String getBuiltinFormat(int i) {
        if (i < 0) {
            return null;
        }
        String[] strArr = _formats;
        if (i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public static int getBuiltinFormat(String str) {
        if (str.equalsIgnoreCase("TEXT")) {
            str = "@";
        }
        int i = 0;
        while (true) {
            String[] strArr = _formats;
            if (i >= strArr.length) {
                return -1;
            }
            if (str.equals(strArr[i])) {
                return i;
            }
            i++;
        }
    }
}
