package com.google.common.util.concurrent.internal;

/* loaded from: classes2.dex */
public abstract class InternalFutureFailureAccess {
    protected abstract Throwable tryInternalFastPathGetFailure();

    protected InternalFutureFailureAccess() {
    }
}
