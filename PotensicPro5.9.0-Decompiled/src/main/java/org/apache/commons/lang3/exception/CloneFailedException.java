package org.apache.commons.lang3.exception;

/* loaded from: classes4.dex */
public class CloneFailedException extends RuntimeException {
    private static final long serialVersionUID = 20091223;

    public CloneFailedException(String str) {
        super(str);
    }

    public CloneFailedException(Throwable th) {
        super(th);
    }

    public CloneFailedException(String str, Throwable th) {
        super(str, th);
    }
}
