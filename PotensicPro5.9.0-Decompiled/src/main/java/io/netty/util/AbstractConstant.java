package io.netty.util;

import io.netty.util.AbstractConstant;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();
    private final int id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    protected AbstractConstant(int i, String str) {
        this.id = i;
        this.name = str;
    }

    @Override // io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    @Override // io.netty.util.Constant
    public final int id() {
        return this.id;
    }

    public final String toString() {
        return name();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.lang.Comparable
    public final int compareTo(T t) {
        if (this == t) {
            return 0;
        }
        int hashCode = hashCode() - t.hashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        long j = this.uniquifier;
        long j2 = t.uniquifier;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
