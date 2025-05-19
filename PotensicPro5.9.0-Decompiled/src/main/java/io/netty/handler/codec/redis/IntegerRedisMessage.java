package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class IntegerRedisMessage implements RedisMessage {
    private final long value;

    public IntegerRedisMessage(long j) {
        this.value = j;
    }

    public long value() {
        return this.value;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "value=" + this.value + PropertyUtils.INDEXED_DELIM2;
    }
}
