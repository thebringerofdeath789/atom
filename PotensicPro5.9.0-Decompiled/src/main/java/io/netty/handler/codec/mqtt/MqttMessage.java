package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class MqttMessage {
    private final DecoderResult decoderResult;
    private final MqttFixedHeader mqttFixedHeader;
    private final Object payload;
    private final Object variableHeader;

    public MqttMessage(MqttFixedHeader mqttFixedHeader) {
        this(mqttFixedHeader, null, null);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj) {
        this(mqttFixedHeader, obj, null);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj, Object obj2) {
        this(mqttFixedHeader, obj, obj2, DecoderResult.SUCCESS);
    }

    public MqttMessage(MqttFixedHeader mqttFixedHeader, Object obj, Object obj2, DecoderResult decoderResult) {
        this.mqttFixedHeader = mqttFixedHeader;
        this.variableHeader = obj;
        this.payload = obj2;
        this.decoderResult = decoderResult;
    }

    public MqttFixedHeader fixedHeader() {
        return this.mqttFixedHeader;
    }

    public Object variableHeader() {
        return this.variableHeader;
    }

    public Object payload() {
        return this.payload;
    }

    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "fixedHeader=" + (fixedHeader() != null ? fixedHeader().toString() : "") + ", variableHeader=" + (variableHeader() != null ? this.variableHeader.toString() : "") + ", payload=" + (payload() != null ? this.payload.toString() : "") + PropertyUtils.INDEXED_DELIM2;
    }
}
