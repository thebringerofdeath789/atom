package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class ArrayHeaderRedisMessage implements RedisMessage {
    private final long length;

    public ArrayHeaderRedisMessage(long j) {
        if (j < -1) {
            throw new RedisCodecException("length: " + j + " (expected: >= -1)");
        }
        this.length = j;
    }

    public final long length() {
        return this.length;
    }

    public boolean isNull() {
        return this.length == -1;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "length=" + this.length + PropertyUtils.INDEXED_DELIM2;
    }
}
