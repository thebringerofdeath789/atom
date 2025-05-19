package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum ParagraphAlignment {
    LEFT(1),
    CENTER(2),
    RIGHT(3),
    BOTH(4),
    MEDIUM_KASHIDA(5),
    DISTRIBUTE(6),
    NUM_TAB(7),
    HIGH_KASHIDA(8),
    LOW_KASHIDA(9),
    THAI_DISTRIBUTE(10);

    private static Map<Integer, ParagraphAlignment> imap = new HashMap();
    private final int value;

    static {
        for (ParagraphAlignment paragraphAlignment : values()) {
            imap.put(new Integer(paragraphAlignment.getValue()), paragraphAlignment);
        }
    }

    ParagraphAlignment(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static ParagraphAlignment valueOf(int i) {
        ParagraphAlignment paragraphAlignment = imap.get(new Integer(i));
        if (paragraphAlignment != null) {
            return paragraphAlignment;
        }
        throw new IllegalArgumentException("Unknown paragraph alignment: " + i);
    }
}
