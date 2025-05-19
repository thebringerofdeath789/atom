package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes4.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    public static final Triple<?, ?, ?>[] EMPTY_ARRAY = new TripleAdapter[0];
    private static final long serialVersionUID = 1;

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    private static final class TripleAdapter<L, M, R> extends Triple<L, M, R> {
        private static final long serialVersionUID = 1;

        @Override // org.apache.commons.lang3.tuple.Triple
        public L getLeft() {
            return null;
        }

        @Override // org.apache.commons.lang3.tuple.Triple
        public M getMiddle() {
            return null;
        }

        @Override // org.apache.commons.lang3.tuple.Triple
        public R getRight() {
            return null;
        }

        private TripleAdapter() {
        }

        @Override // org.apache.commons.lang3.tuple.Triple, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Triple) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, M, R> Triple<L, M, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, M, R> Triple<L, M, R> of(L l, M m, R r) {
        return new ImmutableTriple(l, m, r);
    }

    @Override // java.lang.Comparable
    public int compareTo(Triple<L, M, R> triple) {
        return new CompareToBuilder().append(getLeft(), triple.getLeft()).append(getMiddle(), triple.getMiddle()).append(getRight(), triple.getRight()).toComparison();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return Objects.equals(getLeft(), triple.getLeft()) && Objects.equals(getMiddle(), triple.getMiddle()) && Objects.equals(getRight(), triple.getRight());
    }

    public int hashCode() {
        return (Objects.hashCode(getLeft()) ^ Objects.hashCode(getMiddle())) ^ Objects.hashCode(getRight());
    }

    public String toString() {
        return "(" + getLeft() + "," + getMiddle() + "," + getRight() + ")";
    }

    public String toString(String str) {
        return String.format(str, getLeft(), getMiddle(), getRight());
    }
}
