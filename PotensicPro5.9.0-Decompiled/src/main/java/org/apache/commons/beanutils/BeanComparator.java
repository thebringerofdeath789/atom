package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import org.apache.commons.collections.comparators.ComparableComparator;

/* loaded from: classes4.dex */
public class BeanComparator<T> implements Comparator<T>, Serializable {
    private final Comparator<?> comparator;
    private String property;

    public BeanComparator() {
        this(null);
    }

    public BeanComparator(String str) {
        this(str, ComparableComparator.getInstance());
    }

    public BeanComparator(String str, Comparator<?> comparator) {
        setProperty(str);
        if (comparator != null) {
            this.comparator = comparator;
        } else {
            this.comparator = ComparableComparator.getInstance();
        }
    }

    public void setProperty(String str) {
        this.property = str;
    }

    public String getProperty() {
        return this.property;
    }

    public Comparator<?> getComparator() {
        return this.comparator;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        String str = this.property;
        if (str == null) {
            return internalCompare(t, t2);
        }
        try {
            return internalCompare(PropertyUtils.getProperty(t, str), PropertyUtils.getProperty(t2, this.property));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("IllegalAccessException: " + e.toString());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("NoSuchMethodException: " + e2.toString());
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("InvocationTargetException: " + e3.toString());
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BeanComparator)) {
            return false;
        }
        BeanComparator beanComparator = (BeanComparator) obj;
        if (!this.comparator.equals(beanComparator.comparator)) {
            return false;
        }
        String str = this.property;
        return str != null ? str.equals(beanComparator.property) : beanComparator.property == null;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    private int internalCompare(Object obj, Object obj2) {
        return this.comparator.compare(obj, obj2);
    }
}
