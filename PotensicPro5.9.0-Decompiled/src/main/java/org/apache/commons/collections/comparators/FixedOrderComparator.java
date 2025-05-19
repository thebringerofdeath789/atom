package org.apache.commons.collections.comparators;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class FixedOrderComparator implements Comparator {
    public static final int UNKNOWN_AFTER = 1;
    public static final int UNKNOWN_BEFORE = 0;
    public static final int UNKNOWN_THROW_EXCEPTION = 2;
    private final Map map = new HashMap();
    private int counter = 0;
    private boolean isLocked = false;
    private int unknownObjectBehavior = 2;

    public FixedOrderComparator() {
    }

    public FixedOrderComparator(Object[] objArr) {
        if (objArr == null) {
            throw new IllegalArgumentException("The list of items must not be null");
        }
        for (Object obj : objArr) {
            add(obj);
        }
    }

    public FixedOrderComparator(List list) {
        if (list == null) {
            throw new IllegalArgumentException("The list of items must not be null");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    protected void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    public int getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public void setUnknownObjectBehavior(int i) {
        checkLocked();
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalArgumentException("Unrecognised value for unknown behaviour flag");
        }
        this.unknownObjectBehavior = i;
    }

    public boolean add(Object obj) {
        checkLocked();
        Map map = this.map;
        int i = this.counter;
        this.counter = i + 1;
        return map.put(obj, new Integer(i)) == null;
    }

    public boolean addAsEqual(Object obj, Object obj2) {
        checkLocked();
        Integer num = (Integer) this.map.get(obj);
        if (num != null) {
            return this.map.put(obj2, num) == null;
        }
        throw new IllegalArgumentException(new StringBuffer().append(obj).append(" not known to ").append(this).toString());
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        this.isLocked = true;
        Integer num = (Integer) this.map.get(obj);
        Integer num2 = (Integer) this.map.get(obj2);
        if (num == null || num2 == null) {
            int i = this.unknownObjectBehavior;
            if (i == 0) {
                if (num == null) {
                    return num2 == null ? 0 : -1;
                }
                return 1;
            }
            if (i == 1) {
                if (num == null) {
                    return num2 == null ? 0 : 1;
                }
                return -1;
            }
            if (i == 2) {
                if (num != null) {
                    obj = obj2;
                }
                throw new IllegalArgumentException(new StringBuffer().append("Attempting to compare unknown object ").append(obj).toString());
            }
            throw new UnsupportedOperationException(new StringBuffer().append("Unknown unknownObjectBehavior: ").append(this.unknownObjectBehavior).toString());
        }
        return num.compareTo(num2);
    }
}
