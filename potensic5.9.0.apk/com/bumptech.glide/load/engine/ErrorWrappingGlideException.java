package com.bumptech.glide.load.engine;

import java.util.Objects;

/* loaded from: classes.dex */
public class ErrorWrappingGlideException extends Exception {
    public ErrorWrappingGlideException(Error error) {
        super(error);
        Objects.requireNonNull(error, "The causing error must not be null");
    }

    @Override // java.lang.Throwable
    public Error getCause() {
        return (Error) super.getCause();
    }
}