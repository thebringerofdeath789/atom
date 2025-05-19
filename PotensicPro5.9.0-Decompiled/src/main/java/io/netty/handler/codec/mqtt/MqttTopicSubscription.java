package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttTopicSubscription {
    private final MqttQoS qualityOfService;
    private final String topicFilter;

    public MqttTopicSubscription(String str, MqttQoS mqttQoS) {
        this.topicFilter = str;
        this.qualityOfService = mqttQoS;
    }

    public String topicName() {
        return this.topicFilter;
    }

    public MqttQoS qualityOfService() {
        return this.qualityOfService;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "topicFilter=" + this.topicFilter + ", qualityOfService=" + this.qualityOfService + PropertyUtils.INDEXED_DELIM2;
    }
}
