package com.mapbox.mapboxsdk.module.telemetry;

import android.os.Bundle;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class PerformanceEvent extends MapBaseEvent {
    private static final String PERFORMANCE_TRACE = "mobile.performance_trace";
    private final List<PerformanceAttribute<String>> attributes;
    private final List<PerformanceAttribute<Double>> counters;
    private final JsonObject metadata;
    private final String sessionId;

    @Override // com.mapbox.mapboxsdk.module.telemetry.MapBaseEvent
    String getEventName() {
        return PERFORMANCE_TRACE;
    }

    PerformanceEvent(PhoneState phoneState, String str, Bundle bundle) {
        super(phoneState);
        this.sessionId = str;
        this.attributes = initList(bundle.getString("attributes"), new TypeToken<ArrayList<PerformanceAttribute<String>>>() { // from class: com.mapbox.mapboxsdk.module.telemetry.PerformanceEvent.1
        });
        this.counters = initList(bundle.getString("counters"), new TypeToken<ArrayList<PerformanceAttribute<Double>>>() { // from class: com.mapbox.mapboxsdk.module.telemetry.PerformanceEvent.2
        });
        this.metadata = initMetaData(bundle.getString(TtmlNode.TAG_METADATA));
    }

    private <T> ArrayList<PerformanceAttribute<T>> initList(String str, TypeToken typeToken) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        return (ArrayList) new Gson().fromJson(str, typeToken.getType());
    }

    private JsonObject initMetaData(String str) {
        if (str == null) {
            return new JsonObject();
        }
        return (JsonObject) new Gson().fromJson(str, JsonObject.class);
    }

    String getSessionId() {
        return this.sessionId;
    }

    List<PerformanceAttribute<String>> getAttributes() {
        return this.attributes;
    }

    List<PerformanceAttribute<Double>> getCounters() {
        return this.counters;
    }

    JsonObject getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PerformanceEvent performanceEvent = (PerformanceEvent) obj;
        String str = this.sessionId;
        if (str == null ? performanceEvent.sessionId != null : !str.equals(performanceEvent.sessionId)) {
            return false;
        }
        List<PerformanceAttribute<String>> list = this.attributes;
        if (list == null ? performanceEvent.attributes != null : !list.equals(performanceEvent.attributes)) {
            return false;
        }
        List<PerformanceAttribute<Double>> list2 = this.counters;
        if (list2 == null ? performanceEvent.counters != null : !list2.equals(performanceEvent.counters)) {
            return false;
        }
        JsonObject jsonObject = this.metadata;
        JsonObject jsonObject2 = performanceEvent.metadata;
        return jsonObject != null ? jsonObject.equals(jsonObject2) : jsonObject2 == null;
    }

    public int hashCode() {
        String str = this.sessionId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<PerformanceAttribute<String>> list = this.attributes;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<PerformanceAttribute<Double>> list2 = this.counters;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        JsonObject jsonObject = this.metadata;
        return hashCode3 + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public String toString() {
        return "PerformanceEvent{sessionId='" + this.sessionId + "', attributes=" + this.attributes + ", counters=" + this.counters + ", metadata=" + this.metadata + '}';
    }

    static class PerformanceAttribute<T> {
        private final String name;
        private final T value;

        PerformanceAttribute(String str, T t) {
            this.name = str;
            this.value = t;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PerformanceAttribute performanceAttribute = (PerformanceAttribute) obj;
            String str = this.name;
            if (str == null ? performanceAttribute.name != null : !str.equals(performanceAttribute.name)) {
                return false;
            }
            T t = this.value;
            T t2 = performanceAttribute.value;
            return t != null ? t.equals(t2) : t2 == null;
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            T t = this.value;
            return hashCode + (t != null ? t.hashCode() : 0);
        }
    }
}