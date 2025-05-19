package io.netty.handler.codec.http2;

import io.netty.channel.Channel;

/* loaded from: classes3.dex */
public interface Http2StreamChannel extends Channel {
    Http2FrameStream stream();
}
