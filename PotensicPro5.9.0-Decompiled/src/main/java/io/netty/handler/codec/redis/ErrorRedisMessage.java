package io.netty.handler.codec.redis;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class ErrorRedisMessage extends AbstractStringRedisMessage {
    public ErrorRedisMessage(String str) {
        super(str);
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "content=" + content() + PropertyUtils.INDEXED_DELIM2;
    }
}
