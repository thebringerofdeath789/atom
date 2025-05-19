package com.mapbox.api.staticmap.v1.models;

import com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation;
import com.mapbox.geojson.Point;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_StaticMarkerAnnotation extends StaticMarkerAnnotation {
    private final String color;
    private final String iconUrl;
    private final String label;
    private final Point lnglat;
    private final String name;

    private AutoValue_StaticMarkerAnnotation(String str, String str2, String str3, Point point, String str4) {
        this.name = str;
        this.label = str2;
        this.color = str3;
        this.lnglat = point;
        this.iconUrl = str4;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation
    String name() {
        return this.name;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation
    String label() {
        return this.label;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation
    String color() {
        return this.color;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation
    Point lnglat() {
        return this.lnglat;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation
    String iconUrl() {
        return this.iconUrl;
    }

    public String toString() {
        return "StaticMarkerAnnotation{name=" + this.name + ", label=" + this.label + ", color=" + this.color + ", lnglat=" + this.lnglat + ", iconUrl=" + this.iconUrl + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticMarkerAnnotation)) {
            return false;
        }
        StaticMarkerAnnotation staticMarkerAnnotation = (StaticMarkerAnnotation) obj;
        String str = this.name;
        if (str != null ? str.equals(staticMarkerAnnotation.name()) : staticMarkerAnnotation.name() == null) {
            String str2 = this.label;
            if (str2 != null ? str2.equals(staticMarkerAnnotation.label()) : staticMarkerAnnotation.label() == null) {
                String str3 = this.color;
                if (str3 != null ? str3.equals(staticMarkerAnnotation.color()) : staticMarkerAnnotation.color() == null) {
                    Point point = this.lnglat;
                    if (point != null ? point.equals(staticMarkerAnnotation.lnglat()) : staticMarkerAnnotation.lnglat() == null) {
                        String str4 = this.iconUrl;
                        if (str4 == null) {
                            if (staticMarkerAnnotation.iconUrl() == null) {
                                return true;
                            }
                        } else if (str4.equals(staticMarkerAnnotation.iconUrl())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.label;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.color;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Point point = this.lnglat;
        int hashCode4 = (hashCode3 ^ (point == null ? 0 : point.hashCode())) * 1000003;
        String str4 = this.iconUrl;
        return hashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation
    public StaticMarkerAnnotation.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends StaticMarkerAnnotation.Builder {
        private String color;
        private String iconUrl;
        private String label;
        private Point lnglat;
        private String name;

        Builder() {
        }

        private Builder(StaticMarkerAnnotation staticMarkerAnnotation) {
            this.name = staticMarkerAnnotation.name();
            this.label = staticMarkerAnnotation.label();
            this.color = staticMarkerAnnotation.color();
            this.lnglat = staticMarkerAnnotation.lnglat();
            this.iconUrl = staticMarkerAnnotation.iconUrl();
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation.Builder
        public StaticMarkerAnnotation.Builder name(String str) {
            this.name = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation.Builder
        public StaticMarkerAnnotation.Builder label(String str) {
            this.label = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation.Builder
        public StaticMarkerAnnotation.Builder color(String str) {
            this.color = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation.Builder
        public StaticMarkerAnnotation.Builder lnglat(Point point) {
            this.lnglat = point;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation.Builder
        public StaticMarkerAnnotation.Builder iconUrl(String str) {
            this.iconUrl = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticMarkerAnnotation.Builder
        StaticMarkerAnnotation autoBuild() {
            return new AutoValue_StaticMarkerAnnotation(this.name, this.label, this.color, this.lnglat, this.iconUrl);
        }
    }
}
