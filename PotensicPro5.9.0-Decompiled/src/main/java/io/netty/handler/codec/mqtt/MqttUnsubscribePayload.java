package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class MqttUnsubscribePayload {
    private final List<String> topics;

    public MqttUnsubscribePayload(List<String> list) {
        this.topics = Collections.unmodifiableList(list);
    }

    public List<String> topics() {
        return this.topics;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(StringUtil.simpleClassName(this)).append(PropertyUtils.INDEXED_DELIM);
        for (int i = 0; i < this.topics.size() - 1; i++) {
            append.append("topicName = ").append(this.topics.get(i)).append(", ");
        }
        append.append("topicName = ").append(this.topics.get(r2.size() - 1)).append(PropertyUtils.INDEXED_DELIM2);
        return append.toString();
    }
}
