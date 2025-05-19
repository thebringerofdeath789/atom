package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum BreakType {
    PAGE(1),
    COLUMN(2),
    TEXT_WRAPPING(3);

    private static Map<Integer, BreakType> imap = new HashMap();
    private final int value;

    static {
        for (BreakType breakType : values()) {
            imap.put(new Integer(breakType.getValue()), breakType);
        }
    }

    BreakType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BreakType valueOf(int i) {
        BreakType breakType = imap.get(new Integer(i));
        if (breakType != null) {
            return breakType;
        }
        throw new IllegalArgumentException("Unknown break type: " + i);
    }
}
