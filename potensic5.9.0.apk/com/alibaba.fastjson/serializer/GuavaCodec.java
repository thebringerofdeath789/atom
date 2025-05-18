package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GuavaCodec implements ObjectSerializer, ObjectDeserializer {
    public static GuavaCodec instance = new GuavaCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof Multimap) {
            jSONSerializer.write(((Multimap) obj).asMap());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, com.google.common.collect.ArrayListMultimap] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type != ArrayListMultimap.class) {
            return null;
        }
        ?? r4 = (T) ArrayListMultimap.create();
        for (Map.Entry<String, Object> entry : defaultJSONParser.parseObject().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Collection) {
                r4.putAll(entry.getKey(), (List) value);
            } else {
                r4.put(entry.getKey(), value);
            }
        }
        return r4;
    }
}