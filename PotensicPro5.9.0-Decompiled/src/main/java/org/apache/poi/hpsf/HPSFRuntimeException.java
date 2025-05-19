package org.apache.poi.hpsf;

/* loaded from: classes4.dex */
public class HPSFRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -7804271670232727159L;
    private Throwable reason;

    public HPSFRuntimeException() {
    }

    public HPSFRuntimeException(String str) {
        super(str);
    }

    public HPSFRuntimeException(Throwable th) {
        this.reason = th;
    }

    public HPSFRuntimeException(String str, Throwable th) {
        super(str);
        this.reason = th;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
