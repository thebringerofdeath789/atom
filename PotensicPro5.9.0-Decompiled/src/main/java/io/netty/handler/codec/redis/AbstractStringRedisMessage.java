package io.netty.handler.codec.redis;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public abstract class AbstractStringRedisMessage implements RedisMessage {
    private final String content;

    AbstractStringRedisMessage(String str) {
        this.content = (String) ObjectUtil.checkNotNull(str, "content");
    }

    public final String content() {
        return this.content;
    }
}
