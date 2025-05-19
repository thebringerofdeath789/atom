package io.netty.handler.ssl;

/* loaded from: classes4.dex */
public final class SslHandshakeCompletionEvent extends SslCompletionEvent {
    public static final SslHandshakeCompletionEvent SUCCESS = new SslHandshakeCompletionEvent();

    private SslHandshakeCompletionEvent() {
    }

    public SslHandshakeCompletionEvent(Throwable th) {
        super(th);
    }
}
