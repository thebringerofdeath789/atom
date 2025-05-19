package io.netty.channel;

import java.io.Serializable;

/* loaded from: classes3.dex */
public interface ChannelId extends Serializable, Comparable<ChannelId> {
    String asLongText();

    String asShortText();
}
