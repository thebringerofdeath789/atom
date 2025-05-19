package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: classes4.dex */
final class LinkedArrayQueueUtil {
    private LinkedArrayQueueUtil() {
    }

    static int length(Object[] objArr) {
        return objArr.length;
    }

    static long modifiedCalcElementOffset(long j, long j2) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j & j2) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }

    static long nextArrayOffset(Object[] objArr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((length(objArr) - 1) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
