package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public enum PrintCellComments {
    NONE(1),
    AS_DISPLAYED(2),
    AT_END(3);

    private static PrintCellComments[] _table = new PrintCellComments[4];
    private int comments;

    static {
        for (PrintCellComments printCellComments : values()) {
            _table[printCellComments.getValue()] = printCellComments;
        }
    }

    PrintCellComments(int i) {
        this.comments = i;
    }

    public int getValue() {
        return this.comments;
    }

    public static PrintCellComments valueOf(int i) {
        return _table[i];
    }
}
