package io.netty.handler.codec.stomp;

import io.netty.handler.codec.DecoderResult;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DefaultStompHeadersSubframe implements StompHeadersSubframe {
    protected final StompCommand command;
    protected DecoderResult decoderResult = DecoderResult.SUCCESS;
    protected final StompHeaders headers = new DefaultStompHeaders();

    public DefaultStompHeadersSubframe(StompCommand stompCommand) {
        Objects.requireNonNull(stompCommand, "command");
        this.command = stompCommand;
    }

    @Override // io.netty.handler.codec.stomp.StompHeadersSubframe
    public StompCommand command() {
        return this.command;
    }

    @Override // io.netty.handler.codec.stomp.StompHeadersSubframe
    public StompHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        this.decoderResult = decoderResult;
    }

    public String toString() {
        return "StompFrame{command=" + this.command + ", headers=" + this.headers + '}';
    }
}
