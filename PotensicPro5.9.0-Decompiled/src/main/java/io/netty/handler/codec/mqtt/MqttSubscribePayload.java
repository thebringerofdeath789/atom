package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttSubscribePayload {
    private final List<MqttTopicSubscription> topicSubscriptions;

    public MqttSubscribePayload(List<MqttTopicSubscription> list) {
        this.topicSubscriptions = Collections.unmodifiableList(list);
    }

    public List<MqttTopicSubscription> topicSubscriptions() {
        return this.topicSubscriptions;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(StringUtil.simpleClassName(this)).append(PropertyUtils.INDEXED_DELIM);
        for (int i = 0; i < this.topicSubscriptions.size() - 1; i++) {
            append.append(this.topicSubscriptions.get(i)).append(", ");
        }
        append.append(this.topicSubscriptions.get(r1.size() - 1));
        append.append(PropertyUtils.INDEXED_DELIM2);
        return append.toString();
    }
}
