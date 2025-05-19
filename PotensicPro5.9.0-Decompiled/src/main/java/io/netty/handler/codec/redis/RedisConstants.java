package io.netty.handler.codec.redis;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes3.dex */
final class RedisConstants {
    static final int EOL_LENGTH = 2;
    static final int LONG_MAX_LENGTH = 20;
    static final int NULL_LENGTH = 2;
    static final int NULL_VALUE = -1;
    static final int POSITIVE_LONG_MAX_LENGTH = 19;
    static final int REDIS_MESSAGE_MAX_LENGTH = 536870912;
    static final int TYPE_LENGTH = 1;
    static final short NULL_SHORT = RedisCodecUtil.makeShort(NameUtil.HYPHEN, '1');
    static final short EOL_SHORT = RedisCodecUtil.makeShort('\r', '\n');

    private RedisConstants() {
    }
}
