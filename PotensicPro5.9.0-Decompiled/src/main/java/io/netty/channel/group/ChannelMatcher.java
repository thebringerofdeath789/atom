package io.netty.channel.group;

import io.netty.channel.Channel;

/* loaded from: classes3.dex */
public interface ChannelMatcher {
    boolean matches(Channel channel);
}
