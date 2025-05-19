package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttConnAckVariableHeader {
    private final MqttConnectReturnCode connectReturnCode;
    private final boolean sessionPresent;

    public MqttConnAckVariableHeader(MqttConnectReturnCode mqttConnectReturnCode, boolean z) {
        this.connectReturnCode = mqttConnectReturnCode;
        this.sessionPresent = z;
    }

    public MqttConnectReturnCode connectReturnCode() {
        return this.connectReturnCode;
    }

    public boolean isSessionPresent() {
        return this.sessionPresent;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "connectReturnCode=" + this.connectReturnCode + ", sessionPresent=" + this.sessionPresent + PropertyUtils.INDEXED_DELIM2;
    }
}
