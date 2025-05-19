package org.jdom.input;

/* loaded from: classes5.dex */
class TextBuffer {
    private static final String CVS_ID = "@(#) $RCSfile: TextBuffer.java,v $ $Revision: 1.8 $ $Date: 2004/02/06 09:28:31 $ $Name: jdom_1_0 $";
    private char[] array = new char[4096];
    private int arraySize = 0;
    private String prefixString;

    TextBuffer() {
    }

    void append(char[] cArr, int i, int i2) {
        if (this.prefixString == null) {
            this.prefixString = new String(cArr, i, i2);
            return;
        }
        ensureCapacity(this.arraySize + i2);
        System.arraycopy(cArr, i, this.array, this.arraySize, i2);
        this.arraySize += i2;
    }

    int size() {
        String str = this.prefixString;
        if (str == null) {
            return 0;
        }
        return str.length() + this.arraySize;
    }

    void clear() {
        this.arraySize = 0;
        this.prefixString = null;
    }

    public String toString() {
        String str = this.prefixString;
        return str == null ? "" : this.arraySize == 0 ? str : new StringBuffer(this.prefixString.length() + this.arraySize).append(this.prefixString).append(this.array, 0, this.arraySize).toString();
    }

    private void ensureCapacity(int i) {
        char[] cArr = this.array;
        int length = cArr.length;
        if (i > length) {
            int i2 = length;
            while (i > i2) {
                i2 += length / 2;
            }
            char[] cArr2 = new char[i2];
            this.array = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.arraySize);
        }
    }
}
