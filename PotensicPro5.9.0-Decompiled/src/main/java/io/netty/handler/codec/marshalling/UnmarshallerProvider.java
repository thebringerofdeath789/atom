package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import org.jboss.marshalling.Unmarshaller;

/* loaded from: classes3.dex */
public interface UnmarshallerProvider {
    Unmarshaller getUnmarshaller(ChannelHandlerContext channelHandlerContext) throws Exception;
}
