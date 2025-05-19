package com.google.android.exoplayer2.util;

import android.util.SparseBooleanArray;

/* loaded from: classes.dex */
public final class ExoFlags {
    private final SparseBooleanArray flags;

    public static final class Builder {
        private boolean buildCalled;
        private final SparseBooleanArray flags = new SparseBooleanArray();

        public Builder add(int i) {
            Assertions.checkState(!this.buildCalled);
            this.flags.append(i, true);
            return this;
        }

        public Builder addIf(int i, boolean z) {
            return z ? add(i) : this;
        }

        public Builder addAll(int... iArr) {
            for (int i : iArr) {
                add(i);
            }
            return this;
        }

        public Builder addAll(ExoFlags exoFlags) {
            for (int i = 0; i < exoFlags.size(); i++) {
                add(exoFlags.get(i));
            }
            return this;
        }

        public ExoFlags build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new ExoFlags(this.flags);
        }
    }

    private ExoFlags(SparseBooleanArray sparseBooleanArray) {
        this.flags = sparseBooleanArray;
    }

    public boolean contains(int i) {
        return this.flags.get(i);
    }

    public boolean containsAny(int... iArr) {
        for (int i : iArr) {
            if (contains(i)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.flags.size();
    }

    public int get(int i) {
        Assertions.checkIndex(i, 0, size());
        return this.flags.keyAt(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExoFlags) {
            return this.flags.equals(((ExoFlags) obj).flags);
        }
        return false;
    }

    public int hashCode() {
        return this.flags.hashCode();
    }
}
