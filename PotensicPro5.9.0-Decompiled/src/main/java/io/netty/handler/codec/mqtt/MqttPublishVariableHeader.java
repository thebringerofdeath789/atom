package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttPublishVariableHeader {
    private final int packetId;
    private final String topicName;

    public MqttPublishVariableHeader(String str, int i) {
        this.topicName = str;
        this.packetId = i;
    }

    public String topicName() {
        return this.topicName;
    }

    @Deprecated
    public int messageId() {
        return this.packetId;
    }

    public int packetId() {
        return this.packetId;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "topicName=" + this.topicName + ", packetId=" + this.packetId + PropertyUtils.INDEXED_DELIM2;
    }
}
