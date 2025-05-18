package com.mapbox.api.staticmap.p030v1.models;

import com.mapbox.api.staticmap.p030v1.StaticMapCriteria;
import com.mapbox.api.staticmap.p030v1.models.AutoValue_StaticMarkerAnnotation;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.ColorUtils;
import com.mapbox.core.utils.TextUtils;
import com.mapbox.geojson.Point;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class StaticMarkerAnnotation {
    abstract String color();

    abstract String iconUrl();

    abstract String label();

    abstract Point lnglat();

    abstract String name();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_StaticMarkerAnnotation.Builder().name(StaticMapCriteria.MEDIUM_PIN);
    }

    public String url() {
        String name;
        if (iconUrl() != null) {
            return String.format(Locale.US, "url-%s(%f,%f)", iconUrl(), Double.valueOf(lnglat().longitude()), Double.valueOf(lnglat().latitude()));
        }
        if (color() != null && !TextUtils.isEmpty(label())) {
            name = String.format(Locale.US, "%s-%s+%s", name(), label(), color());
        } else if (!TextUtils.isEmpty(label())) {
            name = String.format(Locale.US, "%s-%s", name(), label());
        } else if (color() != null) {
            name = String.format(Locale.US, "%s+%s", name(), color());
        } else {
            name = name();
        }
        return String.format(Locale.US, "%s(%f,%f)", name, Double.valueOf(lnglat().longitude()), Double.valueOf(lnglat().latitude()));
    }

    public static abstract class Builder {
        abstract StaticMarkerAnnotation autoBuild();

        public abstract Builder color(String str);

        public abstract Builder iconUrl(String str);

        public abstract Builder label(String str);

        public abstract Builder lnglat(Point point);

        public abstract Builder name(String str);

        public Builder color(int i, int i2, int i3) {
            return color(ColorUtils.toHexString(i, i2, i3));
        }

        public StaticMarkerAnnotation build() {
            StaticMarkerAnnotation autoBuild = autoBuild();
            if (autoBuild.lnglat() != null) {
                return autoBuild;
            }
            throw new ServicesException("A Static map marker requires a defined longitude and latitude coordinate.");
        }
    }
}