package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public enum PrintOrientation {
    DEFAULT(1),
    PORTRAIT(2),
    LANDSCAPE(3);

    private static PrintOrientation[] _table = new PrintOrientation[4];
    private int orientation;

    static {
        for (PrintOrientation printOrientation : values()) {
            _table[printOrientation.getValue()] = printOrientation;
        }
    }

    PrintOrientation(int i) {
        this.orientation = i;
    }

    public int getValue() {
        return this.orientation;
    }

    public static PrintOrientation valueOf(int i) {
        return _table[i];
    }
}
