package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.EmptyStackException;

/* loaded from: classes4.dex */
public class ArrayStack extends ArrayList implements Buffer {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public ArrayStack(int i) {
        super(i);
    }

    public boolean empty() {
        return isEmpty();
    }

    public Object peek() throws EmptyStackException {
        int size = size();
        if (size <= 0) {
            throw new EmptyStackException();
        }
        return get(size - 1);
    }

    public Object peek(int i) throws EmptyStackException {
        int size = (size() - i) - 1;
        if (size < 0) {
            throw new EmptyStackException();
        }
        return get(size);
    }

    public Object pop() throws EmptyStackException {
        int size = size();
        if (size <= 0) {
            throw new EmptyStackException();
        }
        return remove(size - 1);
    }

    public Object push(Object obj) {
        add(obj);
        return obj;
    }

    public int search(Object obj) {
        int i = 1;
        int size = size() - 1;
        while (size >= 0) {
            Object obj2 = get(size);
            if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                return i;
            }
            size--;
            i++;
        }
        return -1;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        int size = size();
        if (size == 0) {
            throw new BufferUnderflowException();
        }
        return get(size - 1);
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        int size = size();
        if (size == 0) {
            throw new BufferUnderflowException();
        }
        return remove(size - 1);
    }
}
