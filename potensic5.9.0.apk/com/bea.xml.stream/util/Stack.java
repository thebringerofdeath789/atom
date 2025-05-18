package com.bea.xml.stream.util;

import java.util.AbstractCollection;
import java.util.EmptyStackException;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Stack extends AbstractCollection {
    private int pointer;
    private Object[] values;

    public Stack() {
        this(15);
    }

    public Stack(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.values = new Object[i];
        this.pointer = 0;
    }

    private Stack(Object[] objArr, int i) {
        this.values = objArr;
        this.pointer = i;
    }

    private void resize() {
        int i = this.pointer;
        if (i == 0) {
            this.values = new Object[1];
            return;
        }
        Object[] objArr = new Object[i * 2];
        System.arraycopy(this.values, 0, objArr, 0, i);
        this.values = objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        push(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Object[] objArr = this.values;
        while (true) {
            int i = this.pointer;
            if (i <= 0) {
                return;
            }
            int i2 = i - 1;
            this.pointer = i2;
            objArr[i2] = null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.pointer == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        int i = this.pointer;
        Object[] objArr = new Object[i];
        System.arraycopy(this.values, 0, objArr, 0, i);
        return new ArrayIterator(objArr);
    }

    public Object clone() {
        int i = this.pointer;
        Object[] objArr = new Object[i];
        System.arraycopy(this.values, 0, objArr, 0, i);
        return new Stack(objArr, this.pointer);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.pointer;
    }

    public void push(Object obj) {
        if (this.pointer == this.values.length) {
            resize();
        }
        Object[] objArr = this.values;
        int i = this.pointer;
        this.pointer = i + 1;
        objArr[i] = obj;
    }

    public Object pop() {
        try {
            Object[] objArr = this.values;
            int i = this.pointer - 1;
            this.pointer = i;
            Object obj = objArr[i];
            objArr[i] = null;
            return obj;
        } catch (ArrayIndexOutOfBoundsException unused) {
            if (this.pointer < 0) {
                this.pointer = 0;
            }
            throw new EmptyStackException();
        }
    }

    public Object peek() {
        try {
            return this.values[this.pointer - 1];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new EmptyStackException();
        }
    }
}