package com.mapbox.api.directions.v5.utils;

import com.google.gson.JsonElement;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class UnrecognizedPropertiesUtils {
    public static Map<String, JsonElement> fromSerializableProperties(Map<String, SerializableJsonElement> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            hashMap.put(str, map.get(str).getElement());
        }
        return hashMap;
    }

    public static Map<String, SerializableJsonElement> toSerializableProperties(Map<String, JsonElement> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JsonElement> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new SerializableJsonElement(entry.getValue()));
        }
        return hashMap;
    }
}
