package org.apache.commons.text.lookup;

/* loaded from: classes4.dex */
final class IllegalArgumentExceptions {
    static IllegalArgumentException format(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr));
    }

    static IllegalArgumentException format(Throwable th, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr), th);
    }

    private IllegalArgumentExceptions() {
    }
}
