package org.apache.xmlbeans.impl.piccolo.util;

/* loaded from: classes5.dex */
public class StringStack {
    private int pos = -1;
    private String[] stack;

    public StringStack(int i) {
        this.stack = new String[i];
    }

    public String pop() {
        int i = this.pos;
        if (i < 0) {
            return null;
        }
        String[] strArr = this.stack;
        this.pos = i - 1;
        return strArr[i];
    }

    public void push(String str) {
        int i = this.pos;
        int i2 = i + 1;
        String[] strArr = this.stack;
        if (i2 < strArr.length) {
            int i3 = i + 1;
            this.pos = i3;
            strArr[i3] = str;
        } else {
            setSize(strArr.length * 2);
            String[] strArr2 = this.stack;
            int i4 = this.pos + 1;
            this.pos = i4;
            strArr2[i4] = str;
        }
    }

    public void setSize(int i) {
        String[] strArr = this.stack;
        if (i != strArr.length) {
            String[] strArr2 = new String[i];
            System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i));
            this.stack = strArr2;
        }
    }

    public void clear() {
        this.pos = -1;
    }

    public int size() {
        return this.pos + 1;
    }
}
