package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes4.dex */
public abstract class SslCompletionEvent {
    private final Throwable cause;

    SslCompletionEvent() {
        this.cause = null;
    }

    SslCompletionEvent(Throwable th) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(th, "cause");
    }

    public final boolean isSuccess() {
        return this.cause == null;
    }

    public final Throwable cause() {
        return this.cause;
    }

    public String toString() {
        Throwable cause = cause();
        if (cause == null) {
            return getClass().getSimpleName() + "(SUCCESS)";
        }
        return getClass().getSimpleName() + PropertyUtils.MAPPED_DELIM + cause + PropertyUtils.MAPPED_DELIM2;
    }
}
