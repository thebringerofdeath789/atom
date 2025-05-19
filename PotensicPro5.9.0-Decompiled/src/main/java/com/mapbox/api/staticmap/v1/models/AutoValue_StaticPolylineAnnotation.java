package com.mapbox.api.staticmap.v1.models;

import com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_StaticPolylineAnnotation extends StaticPolylineAnnotation {
    private final String fillColor;
    private final Float fillOpacity;
    private final String polyline;
    private final String strokeColor;
    private final Float strokeOpacity;
    private final Double strokeWidth;

    private AutoValue_StaticPolylineAnnotation(Double d, String str, Float f, String str2, Float f2, String str3) {
        this.strokeWidth = d;
        this.strokeColor = str;
        this.strokeOpacity = f;
        this.fillColor = str2;
        this.fillOpacity = f2;
        this.polyline = str3;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation
    Double strokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation
    String strokeColor() {
        return this.strokeColor;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation
    Float strokeOpacity() {
        return this.strokeOpacity;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation
    String fillColor() {
        return this.fillColor;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation
    Float fillOpacity() {
        return this.fillOpacity;
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation
    String polyline() {
        return this.polyline;
    }

    public String toString() {
        return "StaticPolylineAnnotation{strokeWidth=" + this.strokeWidth + ", strokeColor=" + this.strokeColor + ", strokeOpacity=" + this.strokeOpacity + ", fillColor=" + this.fillColor + ", fillOpacity=" + this.fillOpacity + ", polyline=" + this.polyline + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticPolylineAnnotation)) {
            return false;
        }
        StaticPolylineAnnotation staticPolylineAnnotation = (StaticPolylineAnnotation) obj;
        Double d = this.strokeWidth;
        if (d != null ? d.equals(staticPolylineAnnotation.strokeWidth()) : staticPolylineAnnotation.strokeWidth() == null) {
            String str = this.strokeColor;
            if (str != null ? str.equals(staticPolylineAnnotation.strokeColor()) : staticPolylineAnnotation.strokeColor() == null) {
                Float f = this.strokeOpacity;
                if (f != null ? f.equals(staticPolylineAnnotation.strokeOpacity()) : staticPolylineAnnotation.strokeOpacity() == null) {
                    String str2 = this.fillColor;
                    if (str2 != null ? str2.equals(staticPolylineAnnotation.fillColor()) : staticPolylineAnnotation.fillColor() == null) {
                        Float f2 = this.fillOpacity;
                        if (f2 != null ? f2.equals(staticPolylineAnnotation.fillOpacity()) : staticPolylineAnnotation.fillOpacity() == null) {
                            if (this.polyline.equals(staticPolylineAnnotation.polyline())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Double d = this.strokeWidth;
        int hashCode = ((d == null ? 0 : d.hashCode()) ^ 1000003) * 1000003;
        String str = this.strokeColor;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Float f = this.strokeOpacity;
        int hashCode3 = (hashCode2 ^ (f == null ? 0 : f.hashCode())) * 1000003;
        String str2 = this.fillColor;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Float f2 = this.fillOpacity;
        return ((hashCode4 ^ (f2 != null ? f2.hashCode() : 0)) * 1000003) ^ this.polyline.hashCode();
    }

    @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation
    public StaticPolylineAnnotation.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends StaticPolylineAnnotation.Builder {
        private String fillColor;
        private Float fillOpacity;
        private String polyline;
        private String strokeColor;
        private Float strokeOpacity;
        private Double strokeWidth;

        Builder() {
        }

        private Builder(StaticPolylineAnnotation staticPolylineAnnotation) {
            this.strokeWidth = staticPolylineAnnotation.strokeWidth();
            this.strokeColor = staticPolylineAnnotation.strokeColor();
            this.strokeOpacity = staticPolylineAnnotation.strokeOpacity();
            this.fillColor = staticPolylineAnnotation.fillColor();
            this.fillOpacity = staticPolylineAnnotation.fillOpacity();
            this.polyline = staticPolylineAnnotation.polyline();
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation.Builder
        public StaticPolylineAnnotation.Builder strokeWidth(Double d) {
            this.strokeWidth = d;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation.Builder
        public StaticPolylineAnnotation.Builder strokeColor(String str) {
            this.strokeColor = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation.Builder
        public StaticPolylineAnnotation.Builder strokeOpacity(Float f) {
            this.strokeOpacity = f;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation.Builder
        public StaticPolylineAnnotation.Builder fillColor(String str) {
            this.fillColor = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation.Builder
        public StaticPolylineAnnotation.Builder fillOpacity(Float f) {
            this.fillOpacity = f;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation.Builder
        public StaticPolylineAnnotation.Builder polyline(String str) {
            Objects.requireNonNull(str, "Null polyline");
            this.polyline = str;
            return this;
        }

        @Override // com.mapbox.api.staticmap.v1.models.StaticPolylineAnnotation.Builder
        public StaticPolylineAnnotation build() {
            String str = this.polyline == null ? " polyline" : "";
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_StaticPolylineAnnotation(this.strokeWidth, this.strokeColor, this.strokeOpacity, this.fillColor, this.fillOpacity, this.polyline);
        }
    }
}
