package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum TextAlignment {
    TOP(1),
    CENTER(2),
    BASELINE(3),
    BOTTOM(4),
    AUTO(5);

    private static Map<Integer, TextAlignment> imap = new HashMap();
    private final int value;

    static {
        for (TextAlignment textAlignment : values()) {
            imap.put(new Integer(textAlignment.getValue()), textAlignment);
        }
    }

    TextAlignment(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static TextAlignment valueOf(int i) {
        TextAlignment textAlignment = imap.get(new Integer(i));
        if (textAlignment != null) {
            return textAlignment;
        }
        throw new IllegalArgumentException("Unknown text alignment: " + i);
    }
}
