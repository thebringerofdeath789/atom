package io.netty.handler.codec;

import io.netty.util.Signal;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
public class DecoderResult {
    protected static final Signal SIGNAL_SUCCESS;
    protected static final Signal SIGNAL_UNFINISHED;
    public static final DecoderResult SUCCESS;
    public static final DecoderResult UNFINISHED;
    private final Throwable cause;

    static {
        Signal valueOf = Signal.valueOf(DecoderResult.class, "UNFINISHED");
        SIGNAL_UNFINISHED = valueOf;
        Signal valueOf2 = Signal.valueOf(DecoderResult.class, "SUCCESS");
        SIGNAL_SUCCESS = valueOf2;
        UNFINISHED = new DecoderResult(valueOf);
        SUCCESS = new DecoderResult(valueOf2);
    }

    public static DecoderResult failure(Throwable th) {
        Objects.requireNonNull(th, "cause");
        return new DecoderResult(th);
    }

    protected DecoderResult(Throwable th) {
        Objects.requireNonNull(th, "cause");
        this.cause = th;
    }

    public boolean isFinished() {
        return this.cause != SIGNAL_UNFINISHED;
    }

    public boolean isSuccess() {
        return this.cause == SIGNAL_SUCCESS;
    }

    public boolean isFailure() {
        Throwable th = this.cause;
        return (th == SIGNAL_SUCCESS || th == SIGNAL_UNFINISHED) ? false : true;
    }

    public Throwable cause() {
        if (isFailure()) {
            return this.cause;
        }
        return null;
    }

    public String toString() {
        if (!isFinished()) {
            return "unfinished";
        }
        if (isSuccess()) {
            return "success";
        }
        String th = cause().toString();
        return new StringBuilder(th.length() + 17).append("failure(").append(th).append(PropertyUtils.MAPPED_DELIM2).toString();
    }
}
