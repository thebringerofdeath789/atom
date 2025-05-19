package io.netty.handler.ssl;

import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes4.dex */
public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    SniCompletionEvent(String str) {
        this.hostname = str;
    }

    SniCompletionEvent(String str, Throwable th) {
        super(th);
        this.hostname = str;
    }

    SniCompletionEvent(Throwable th) {
        this(null, th);
    }

    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable cause = cause();
        if (cause == null) {
            return getClass().getSimpleName() + "(SUCCESS='" + this.hostname + "'\")";
        }
        return getClass().getSimpleName() + PropertyUtils.MAPPED_DELIM + cause + PropertyUtils.MAPPED_DELIM2;
    }
}
