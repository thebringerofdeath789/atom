package org.apache.poi.ss.format;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class CellFormatCondition {
    private static final int EQ = 4;
    private static final int GE = 3;
    private static final int GT = 2;
    private static final int LE = 1;
    private static final int LT = 0;
    private static final int NE = 5;
    private static final Map<String, Integer> TESTS;

    public abstract boolean pass(double d);

    static {
        HashMap hashMap = new HashMap();
        TESTS = hashMap;
        hashMap.put("<", 0);
        hashMap.put("<=", 1);
        hashMap.put(">", 2);
        hashMap.put(">=", 3);
        hashMap.put("=", 4);
        hashMap.put("==", 4);
        hashMap.put("!=", 5);
        hashMap.put("<>", 5);
    }

    public static CellFormatCondition getInstance(String str, String str2) {
        Map<String, Integer> map = TESTS;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown test: " + str);
        }
        int intValue = map.get(str).intValue();
        final double parseDouble = Double.parseDouble(str2);
        if (intValue == 0) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.1
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d) {
                    return d < parseDouble;
                }
            };
        }
        if (intValue == 1) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.2
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d) {
                    return d <= parseDouble;
                }
            };
        }
        if (intValue == 2) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.3
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d) {
                    return d > parseDouble;
                }
            };
        }
        if (intValue == 3) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.4
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d) {
                    return d >= parseDouble;
                }
            };
        }
        if (intValue == 4) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.5
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d) {
                    return d == parseDouble;
                }
            };
        }
        if (intValue == 5) {
            return new CellFormatCondition() { // from class: org.apache.poi.ss.format.CellFormatCondition.6
                @Override // org.apache.poi.ss.format.CellFormatCondition
                public boolean pass(double d) {
                    return d != parseDouble;
                }
            };
        }
        throw new IllegalArgumentException("Cannot create for test number " + intValue + "(\"" + str + "\")");
    }
}
