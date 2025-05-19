package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public final class MapTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = 862391807045468939L;
    private final Map iMap;

    public static Transformer getInstance(Map map) {
        if (map == null) {
            return ConstantTransformer.NULL_INSTANCE;
        }
        return new MapTransformer(map);
    }

    private MapTransformer(Map map) {
        this.iMap = map;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        return this.iMap.get(obj);
    }

    public Map getMap() {
        return this.iMap;
    }
}
