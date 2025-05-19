package org.apache.commons.collections;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public class BufferUnderflowException extends NoSuchElementException {
    private final Throwable throwable;

    public BufferUnderflowException() {
        this.throwable = null;
    }

    public BufferUnderflowException(String str) {
        this(str, null);
    }

    public BufferUnderflowException(String str, Throwable th) {
        super(str);
        this.throwable = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.throwable;
    }
}
