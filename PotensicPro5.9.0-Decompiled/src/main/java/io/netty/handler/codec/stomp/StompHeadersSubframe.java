package io.netty.handler.codec.stomp;

/* loaded from: classes3.dex */
public interface StompHeadersSubframe extends StompSubframe {
    StompCommand command();

    StompHeaders headers();
}
