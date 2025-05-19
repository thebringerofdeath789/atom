package org.ahocorasick.trie;

import org.ahocorasick.interval.Interval;
import org.ahocorasick.interval.Intervalable;

/* loaded from: classes4.dex */
public class Emit extends Interval implements Intervalable {
    private final String keyword;

    public Emit(int i, int i2, String str) {
        super(i, i2);
        this.keyword = str;
    }

    public String getKeyword() {
        return this.keyword;
    }

    @Override // org.ahocorasick.interval.Interval
    public String toString() {
        return super.toString() + "=" + this.keyword;
    }
}
