package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;

/* loaded from: classes4.dex */
public final class DefaultMapEntry extends AbstractMapEntry {
    public DefaultMapEntry(Object obj, Object obj2) {
        super(obj, obj2);
    }

    public DefaultMapEntry(KeyValue keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultMapEntry(Map.Entry entry) {
        super(entry.getKey(), entry.getValue());
    }
}
