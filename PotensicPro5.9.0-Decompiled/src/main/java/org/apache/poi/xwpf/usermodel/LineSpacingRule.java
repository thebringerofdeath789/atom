package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public enum LineSpacingRule {
    AUTO(1),
    EXACT(2),
    AT_LEAST(3);

    private static Map<Integer, LineSpacingRule> imap = new HashMap();
    private final int value;

    static {
        for (LineSpacingRule lineSpacingRule : values()) {
            imap.put(new Integer(lineSpacingRule.getValue()), lineSpacingRule);
        }
    }

    LineSpacingRule(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static LineSpacingRule valueOf(int i) {
        LineSpacingRule lineSpacingRule = imap.get(new Integer(i));
        if (lineSpacingRule != null) {
            return lineSpacingRule;
        }
        throw new IllegalArgumentException("Unknown line type: " + i);
    }
}
