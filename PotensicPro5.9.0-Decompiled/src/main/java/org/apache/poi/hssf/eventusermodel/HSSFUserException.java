package org.apache.poi.hssf.eventusermodel;

/* loaded from: classes4.dex */
public class HSSFUserException extends Exception {
    private Throwable reason;

    public HSSFUserException() {
    }

    public HSSFUserException(String str) {
        super(str);
    }

    public HSSFUserException(Throwable th) {
        this.reason = th;
    }

    public HSSFUserException(String str, Throwable th) {
        super(str);
        this.reason = th;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
