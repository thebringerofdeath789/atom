package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class ComparatorChain implements Comparator, Serializable {
    private static final long serialVersionUID = -721644942746081630L;
    protected List comparatorChain;
    protected boolean isLocked;
    protected BitSet orderingBits;

    public ComparatorChain() {
        this(new ArrayList(), new BitSet());
    }

    public ComparatorChain(Comparator comparator) {
        this(comparator, false);
    }

    public ComparatorChain(Comparator comparator, boolean z) {
        this.comparatorChain = null;
        this.orderingBits = null;
        this.isLocked = false;
        ArrayList arrayList = new ArrayList();
        this.comparatorChain = arrayList;
        arrayList.add(comparator);
        BitSet bitSet = new BitSet(1);
        this.orderingBits = bitSet;
        if (z) {
            bitSet.set(0);
        }
    }

    public ComparatorChain(List list) {
        this(list, new BitSet(list.size()));
    }

    public ComparatorChain(List list, BitSet bitSet) {
        this.comparatorChain = null;
        this.orderingBits = null;
        this.isLocked = false;
        this.comparatorChain = list;
        this.orderingBits = bitSet;
    }

    public void addComparator(Comparator comparator) {
        addComparator(comparator, false);
    }

    public void addComparator(Comparator comparator, boolean z) {
        checkLocked();
        this.comparatorChain.add(comparator);
        if (z) {
            this.orderingBits.set(this.comparatorChain.size() - 1);
        }
    }

    public void setComparator(int i, Comparator comparator) throws IndexOutOfBoundsException {
        setComparator(i, comparator, false);
    }

    public void setComparator(int i, Comparator comparator, boolean z) {
        checkLocked();
        this.comparatorChain.set(i, comparator);
        if (z) {
            this.orderingBits.set(i);
        } else {
            this.orderingBits.clear(i);
        }
    }

    public void setForwardSort(int i) {
        checkLocked();
        this.orderingBits.clear(i);
    }

    public void setReverseSort(int i) {
        checkLocked();
        this.orderingBits.set(i);
    }

    public int size() {
        return this.comparatorChain.size();
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    private void checkChainIntegrity() {
        if (this.comparatorChain.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) throws UnsupportedOperationException {
        if (!this.isLocked) {
            checkChainIntegrity();
            this.isLocked = true;
        }
        Iterator it = this.comparatorChain.iterator();
        int i = 0;
        while (it.hasNext()) {
            int compare = ((Comparator) it.next()).compare(obj, obj2);
            if (compare != 0) {
                if (!this.orderingBits.get(i)) {
                    return compare;
                }
                if (Integer.MIN_VALUE == compare) {
                    return Integer.MAX_VALUE;
                }
                return compare * (-1);
            }
            i++;
        }
        return 0;
    }

    public int hashCode() {
        List list = this.comparatorChain;
        int hashCode = list != null ? 0 ^ list.hashCode() : 0;
        BitSet bitSet = this.orderingBits;
        return bitSet != null ? hashCode ^ bitSet.hashCode() : hashCode;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ComparatorChain comparatorChain = (ComparatorChain) obj;
        BitSet bitSet = this.orderingBits;
        if (bitSet != null ? bitSet.equals(comparatorChain.orderingBits) : comparatorChain.orderingBits == null) {
            List list = this.comparatorChain;
            List list2 = comparatorChain.comparatorChain;
            if (list == null) {
                if (list2 == null) {
                    return true;
                }
            } else if (list.equals(list2)) {
                return true;
            }
        }
        return false;
    }
}
