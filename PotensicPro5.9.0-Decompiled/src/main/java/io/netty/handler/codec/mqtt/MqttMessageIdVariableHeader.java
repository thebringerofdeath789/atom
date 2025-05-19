package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttMessageIdVariableHeader {
    private final int messageId;

    public static MqttMessageIdVariableHeader from(int i) {
        if (i < 1 || i > 65535) {
            throw new IllegalArgumentException("messageId: " + i + " (expected: 1 ~ 65535)");
        }
        return new MqttMessageIdVariableHeader(i);
    }

    private MqttMessageIdVariableHeader(int i) {
        this.messageId = i;
    }

    public int messageId() {
        return this.messageId;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "messageId=" + this.messageId + PropertyUtils.INDEXED_DELIM2;
    }
}
