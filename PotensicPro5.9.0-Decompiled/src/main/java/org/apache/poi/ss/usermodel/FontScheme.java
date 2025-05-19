package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public enum FontScheme {
    NONE(1),
    MAJOR(2),
    MINOR(3);

    private static FontScheme[] _table = new FontScheme[4];
    private int value;

    static {
        for (FontScheme fontScheme : values()) {
            _table[fontScheme.getValue()] = fontScheme;
        }
    }

    FontScheme(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static FontScheme valueOf(int i) {
        return _table[i];
    }
}
