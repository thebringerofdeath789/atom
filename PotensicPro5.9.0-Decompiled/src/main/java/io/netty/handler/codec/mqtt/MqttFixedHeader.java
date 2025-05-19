package io.netty.handler.codec.mqtt;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttFixedHeader {
    private final boolean isDup;
    private final boolean isRetain;
    private final MqttMessageType messageType;
    private final MqttQoS qosLevel;
    private final int remainingLength;

    public MqttFixedHeader(MqttMessageType mqttMessageType, boolean z, MqttQoS mqttQoS, boolean z2, int i) {
        this.messageType = (MqttMessageType) ObjectUtil.checkNotNull(mqttMessageType, "messageType");
        this.isDup = z;
        this.qosLevel = (MqttQoS) ObjectUtil.checkNotNull(mqttQoS, "qosLevel");
        this.isRetain = z2;
        this.remainingLength = i;
    }

    public MqttMessageType messageType() {
        return this.messageType;
    }

    public boolean isDup() {
        return this.isDup;
    }

    public MqttQoS qosLevel() {
        return this.qosLevel;
    }

    public boolean isRetain() {
        return this.isRetain;
    }

    public int remainingLength() {
        return this.remainingLength;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "messageType=" + this.messageType + ", isDup=" + this.isDup + ", qosLevel=" + this.qosLevel + ", isRetain=" + this.isRetain + ", remainingLength=" + this.remainingLength + PropertyUtils.INDEXED_DELIM2;
    }
}
