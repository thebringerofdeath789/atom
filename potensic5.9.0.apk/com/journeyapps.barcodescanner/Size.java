package com.journeyapps.barcodescanner;

/* loaded from: classes2.dex */
public class Size implements Comparable<Size> {
    public final int height;
    public final int width;

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public Size rotate() {
        return new Size(this.height, this.width);
    }

    public Size scale(int i, int i2) {
        return new Size((this.width * i) / i2, (this.height * i) / i2);
    }

    public Size scaleFit(Size size) {
        if (this.width * size.height >= size.width * this.height) {
            int i = size.width;
            return new Size(i, (this.height * i) / this.width);
        }
        int i2 = this.width;
        int i3 = size.height;
        return new Size((i2 * i3) / this.height, i3);
    }

    public Size scaleCrop(Size size) {
        if (this.width * size.height <= size.width * this.height) {
            int i = size.width;
            return new Size(i, (this.height * i) / this.width);
        }
        int i2 = this.width;
        int i3 = size.height;
        return new Size((i2 * i3) / this.height, i3);
    }

    public boolean fitsIn(Size size) {
        return this.width <= size.width && this.height <= size.height;
    }

    @Override // java.lang.Comparable
    public int compareTo(Size size) {
        int i = this.height * this.width;
        int i2 = size.height * size.width;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Size size = (Size) obj;
        return this.width == size.width && this.height == size.height;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }
}