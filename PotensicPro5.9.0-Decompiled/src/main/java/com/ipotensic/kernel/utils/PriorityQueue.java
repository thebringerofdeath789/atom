package com.ipotensic.kernel.utils;

/* loaded from: classes2.dex */
public class PriorityQueue {
    private int maxSize;
    private int nItems = 0;
    private int[] queArray;

    public PriorityQueue(int i) {
        this.maxSize = i;
        this.queArray = new int[i];
    }

    public void insert(int i) {
        int i2 = this.nItems;
        if (i2 == 0) {
            int[] iArr = this.queArray;
            this.nItems = i2 + 1;
            iArr[i2] = i;
            return;
        }
        int i3 = i2 - 1;
        while (i3 >= 0) {
            int[] iArr2 = this.queArray;
            if (i <= iArr2[i3]) {
                break;
            }
            iArr2[i3 + 1] = iArr2[i3];
            i3--;
        }
        this.queArray[i3 + 1] = i;
        this.nItems++;
    }

    public int remove() {
        int[] iArr = this.queArray;
        int i = this.nItems - 1;
        this.nItems = i;
        return iArr[i];
    }

    public int peekMin() {
        int i = this.nItems;
        if (i == 0) {
            return -1;
        }
        return this.queArray[i - 1];
    }

    public boolean isEmpty() {
        return this.nItems == 0;
    }

    public boolean isFull() {
        return this.nItems == this.maxSize;
    }

    public void setNItems() {
        this.nItems = 0;
    }

    public int getItems() {
        return this.nItems;
    }

    public int getPeekMax() {
        return this.queArray[0];
    }

    public int getPeek(int i) {
        return this.queArray[i];
    }
}
