package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum BreakClear {
    NONE(1),
    LEFT(2),
    RIGHT(3),
    ALL(4);

    private static Map<Integer, BreakClear> imap = new HashMap();
    private final int value;

    static {
        for (BreakClear breakClear : values()) {
            imap.put(new Integer(breakClear.getValue()), breakClear);
        }
    }

    BreakClear(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BreakClear valueOf(int i) {
        BreakClear breakClear = imap.get(new Integer(i));
        if (breakClear != null) {
            return breakClear;
        }
        throw new IllegalArgumentException("Unknown break clear type: " + i);
    }
}
