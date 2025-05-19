package com.baidu.location.indoor;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class k<T> extends ArrayList<T> {
    private int a;

    public k(int i) {
        this.a = 0;
        this.a = i;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        synchronized (this) {
            if (size() == this.a) {
                remove(0);
            }
            add(size(), t);
        }
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        synchronized (this) {
            if (size() <= 3) {
                return;
            }
            int size = size() / 2;
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    return;
                }
                remove(0);
                size = i;
            }
        }
    }
}
