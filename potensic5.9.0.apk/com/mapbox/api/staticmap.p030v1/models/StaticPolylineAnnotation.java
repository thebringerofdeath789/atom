package com.mapbox.api.staticmap.p030v1.models;

import com.mapbox.api.staticmap.p030v1.models.AutoValue_StaticPolylineAnnotation;
import com.mapbox.core.utils.ColorUtils;

/* loaded from: classes3.dex */
public abstract class StaticPolylineAnnotation {
    abstract String fillColor();

    abstract Float fillOpacity();

    abstract String polyline();

    abstract String strokeColor();

    abstract Float strokeOpacity();

    abstract Double strokeWidth();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_StaticPolylineAnnotation.Builder();
    }

    public String url() {
        StringBuilder sb = new StringBuilder();
        sb.append("path");
        if (strokeWidth() != null) {
            sb.append("-").append(strokeWidth());
        }
        if (strokeColor() != null) {
            sb.append("+").append(strokeColor());
        }
        if (strokeOpacity() != null) {
            sb.append("-").append(strokeOpacity());
        }
        if (fillColor() != null) {
            sb.append("+").append(fillColor());
        }
        if (fillOpacity() != null) {
            sb.append("-").append(fillOpacity());
        }
        sb.append("(").append(polyline()).append(")");
        return sb.toString();
    }

    public static abstract class Builder {
        public abstract StaticPolylineAnnotation build();

        public abstract Builder fillColor(String str);

        public abstract Builder fillOpacity(Float f);

        public abstract Builder polyline(String str);

        public abstract Builder strokeColor(String str);

        public abstract Builder strokeOpacity(Float f);

        public abstract Builder strokeWidth(Double d);

        public Builder strokeColor(int i, int i2, int i3) {
            return strokeColor(ColorUtils.toHexString(i, i2, i3));
        }

        public Builder fillColor(int i, int i2, int i3) {
            return fillColor(ColorUtils.toHexString(i, i2, i3));
        }
    }
}