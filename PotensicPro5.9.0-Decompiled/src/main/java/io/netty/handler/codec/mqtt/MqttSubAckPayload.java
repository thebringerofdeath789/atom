package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class MqttSubAckPayload {
    private final List<Integer> grantedQoSLevels;

    public MqttSubAckPayload(int... iArr) {
        Objects.requireNonNull(iArr, "grantedQoSLevels");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        this.grantedQoSLevels = Collections.unmodifiableList(arrayList);
    }

    public MqttSubAckPayload(Iterable<Integer> iterable) {
        Integer next;
        Objects.requireNonNull(iterable, "grantedQoSLevels");
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next);
        }
        this.grantedQoSLevels = Collections.unmodifiableList(arrayList);
    }

    public List<Integer> grantedQoSLevels() {
        return this.grantedQoSLevels;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.INDEXED_DELIM + "grantedQoSLevels=" + this.grantedQoSLevels + PropertyUtils.INDEXED_DELIM2;
    }
}
