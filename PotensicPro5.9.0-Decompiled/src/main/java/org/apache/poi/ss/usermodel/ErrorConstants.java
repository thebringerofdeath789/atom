package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public class ErrorConstants {
    public static final int ERROR_DIV_0 = 7;
    public static final int ERROR_NA = 42;
    public static final int ERROR_NAME = 29;
    public static final int ERROR_NULL = 0;
    public static final int ERROR_NUM = 36;
    public static final int ERROR_REF = 23;
    public static final int ERROR_VALUE = 15;

    public static final boolean isValidCode(int i) {
        return i == 0 || i == 7 || i == 15 || i == 23 || i == 29 || i == 36 || i == 42;
    }

    protected ErrorConstants() {
    }

    public static final String getText(int i) {
        if (i == 0) {
            return "#NULL!";
        }
        if (i == 7) {
            return "#DIV/0!";
        }
        if (i == 15) {
            return "#VALUE!";
        }
        if (i == 23) {
            return "#REF!";
        }
        if (i == 29) {
            return "#NAME?";
        }
        if (i == 36) {
            return "#NUM!";
        }
        if (i == 42) {
            return "#N/A";
        }
        throw new IllegalArgumentException("Bad error code (" + i + ")");
    }
}
