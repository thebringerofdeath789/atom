package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public class ConversionException extends RuntimeException {
    protected Throwable cause;

    public ConversionException(String str) {
        super(str);
        this.cause = null;
    }

    public ConversionException(String str, Throwable th) {
        super(str);
        this.cause = null;
        this.cause = th;
    }

    public ConversionException(Throwable th) {
        super(th.getMessage());
        this.cause = null;
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
