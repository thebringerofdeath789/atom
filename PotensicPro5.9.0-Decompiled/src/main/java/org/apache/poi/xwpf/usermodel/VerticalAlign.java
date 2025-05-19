package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum VerticalAlign {
    BASELINE(1),
    SUPERSCRIPT(2),
    SUBSCRIPT(3);

    private static Map<Integer, VerticalAlign> imap = new HashMap();
    private final int value;

    static {
        for (VerticalAlign verticalAlign : values()) {
            imap.put(new Integer(verticalAlign.getValue()), verticalAlign);
        }
    }

    VerticalAlign(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static VerticalAlign valueOf(int i) {
        VerticalAlign verticalAlign = imap.get(new Integer(i));
        if (verticalAlign != null) {
            return verticalAlign;
        }
        throw new IllegalArgumentException("Unknown vertical alignment: " + i);
    }
}
