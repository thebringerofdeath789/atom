package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public enum PageOrder {
    DOWN_THEN_OVER(1),
    OVER_THEN_DOWN(2);

    private static PageOrder[] _table = new PageOrder[3];
    private int order;

    static {
        for (PageOrder pageOrder : values()) {
            _table[pageOrder.getValue()] = pageOrder;
        }
    }

    PageOrder(int i) {
        this.order = i;
    }

    public int getValue() {
        return this.order;
    }

    public static PageOrder valueOf(int i) {
        return _table[i];
    }
}
