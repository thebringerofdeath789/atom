package org.apache.commons.logging;

/* loaded from: classes4.dex */
public class LogConfigurationException extends RuntimeException {
    private static final long serialVersionUID = 8486587136871052495L;
    protected Throwable cause;

    public LogConfigurationException() {
        this.cause = null;
    }

    public LogConfigurationException(String str) {
        super(str);
        this.cause = null;
    }

    public LogConfigurationException(Throwable th) {
        this(th == null ? null : th.toString(), th);
    }

    public LogConfigurationException(String str, Throwable th) {
        super(new StringBuffer().append(str).append(" (Caused by ").append(th).append(")").toString());
        this.cause = null;
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
