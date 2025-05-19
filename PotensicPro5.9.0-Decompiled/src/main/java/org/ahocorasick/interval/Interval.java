package org.ahocorasick.interval;

/* loaded from: classes4.dex */
public class Interval implements Intervalable {
    private int end;
    private int start;

    public Interval(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Override // org.ahocorasick.interval.Intervalable
    public int getStart() {
        return this.start;
    }

    @Override // org.ahocorasick.interval.Intervalable
    public int getEnd() {
        return this.end;
    }

    @Override // org.ahocorasick.interval.Intervalable
    public int size() {
        return (this.end - this.start) + 1;
    }

    public boolean overlapsWith(Interval interval) {
        return this.start <= interval.getEnd() && this.end >= interval.getStart();
    }

    public boolean overlapsWith(int i) {
        return this.start <= i && i <= this.end;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Intervalable)) {
            return false;
        }
        Intervalable intervalable = (Intervalable) obj;
        return this.start == intervalable.getStart() && this.end == intervalable.getEnd();
    }

    public int hashCode() {
        return (this.start % 100) + (this.end % 100);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof Intervalable)) {
            return -1;
        }
        Intervalable intervalable = (Intervalable) obj;
        int start = this.start - intervalable.getStart();
        return start != 0 ? start : this.end - intervalable.getEnd();
    }

    public String toString() {
        return this.start + ":" + this.end;
    }
}
