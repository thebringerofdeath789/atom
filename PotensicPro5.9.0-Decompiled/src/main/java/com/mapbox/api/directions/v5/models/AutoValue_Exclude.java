package com.mapbox.api.directions.v5.models;

import com.mapbox.api.directions.v5.models.Exclude;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import com.mapbox.geojson.Point;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Exclude extends Exclude {
    private final List<String> criteria;
    private final List<Point> points;
    private final Map<String, SerializableJsonElement> unrecognized;

    private AutoValue_Exclude(Map<String, SerializableJsonElement> map, List<String> list, List<Point> list2) {
        this.unrecognized = map;
        this.criteria = list;
        this.points = list2;
    }

    @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
    Map<String, SerializableJsonElement> unrecognized() {
        return this.unrecognized;
    }

    @Override // com.mapbox.api.directions.v5.models.Exclude
    public List<String> criteria() {
        return this.criteria;
    }

    @Override // com.mapbox.api.directions.v5.models.Exclude
    public List<Point> points() {
        return this.points;
    }

    public String toString() {
        return "Exclude{unrecognized=" + this.unrecognized + ", criteria=" + this.criteria + ", points=" + this.points + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Exclude)) {
            return false;
        }
        Exclude exclude = (Exclude) obj;
        Map<String, SerializableJsonElement> map = this.unrecognized;
        if (map != null ? map.equals(exclude.unrecognized()) : exclude.unrecognized() == null) {
            List<String> list = this.criteria;
            if (list != null ? list.equals(exclude.criteria()) : exclude.criteria() == null) {
                List<Point> list2 = this.points;
                if (list2 == null) {
                    if (exclude.points() == null) {
                        return true;
                    }
                } else if (list2.equals(exclude.points())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Map<String, SerializableJsonElement> map = this.unrecognized;
        int hashCode = ((map == null ? 0 : map.hashCode()) ^ 1000003) * 1000003;
        List<String> list = this.criteria;
        int hashCode2 = (hashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<Point> list2 = this.points;
        return hashCode2 ^ (list2 != null ? list2.hashCode() : 0);
    }

    static final class Builder extends Exclude.Builder {
        private List<String> criteria;
        private List<Point> points;
        private Map<String, SerializableJsonElement> unrecognized;

        @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
        /* bridge */ /* synthetic */ Exclude.Builder unrecognized(Map map) {
            return unrecognized2((Map<String, SerializableJsonElement>) map);
        }

        Builder() {
        }

        @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
        /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
        Exclude.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
            this.unrecognized = map;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.models.Exclude.Builder
        public Exclude.Builder criteria(List<String> list) {
            this.criteria = list;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.models.Exclude.Builder
        public Exclude.Builder points(List<Point> list) {
            this.points = list;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.models.Exclude.Builder
        public Exclude build() {
            return new AutoValue_Exclude(this.unrecognized, this.criteria, this.points);
        }
    }
}
