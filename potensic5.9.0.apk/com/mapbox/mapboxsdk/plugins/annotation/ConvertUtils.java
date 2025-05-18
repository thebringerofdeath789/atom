package com.mapbox.mapboxsdk.plugins.annotation;

import com.google.gson.JsonArray;

/* loaded from: classes3.dex */
class ConvertUtils {
    ConvertUtils() {
    }

    static JsonArray convertArray(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        JsonArray jsonArray = new JsonArray();
        for (Float f : fArr) {
            jsonArray.add(f);
        }
        return jsonArray;
    }

    static JsonArray convertArray(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JsonArray jsonArray = new JsonArray();
        for (String str : strArr) {
            jsonArray.add(str);
        }
        return jsonArray;
    }

    static Float[] toFloatArray(JsonArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        Float[] fArr = new Float[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            fArr[i] = Float.valueOf(jsonArray.get(i).getAsFloat());
        }
        return fArr;
    }

    static String[] toStringArray(JsonArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }
        String[] strArr = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            strArr[i] = jsonArray.get(i).getAsString();
        }
        return strArr;
    }
}