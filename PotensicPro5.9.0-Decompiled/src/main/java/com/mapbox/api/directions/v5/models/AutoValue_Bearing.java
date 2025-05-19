package com.mapbox.api.directions.v5.models;

import com.mapbox.api.directions.v5.models.Bearing;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Bearing extends Bearing {
    private final double angle;
    private final double degrees;
    private final Map<String, SerializableJsonElement> unrecognized;

    private AutoValue_Bearing(Map<String, SerializableJsonElement> map, double d, double d2) {
        this.unrecognized = map;
        this.angle = d;
        this.degrees = d2;
    }

    @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
    Map<String, SerializableJsonElement> unrecognized() {
        return this.unrecognized;
    }

    @Override // com.mapbox.api.directions.v5.models.Bearing
    public double angle() {
        return this.angle;
    }

    @Override // com.mapbox.api.directions.v5.models.Bearing
    public double degrees() {
        return this.degrees;
    }

    public String toString() {
        return "Bearing{unrecognized=" + this.unrecognized + ", angle=" + this.angle + ", degrees=" + this.degrees + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bearing)) {
            return false;
        }
        Bearing bearing = (Bearing) obj;
        Map<String, SerializableJsonElement> map = this.unrecognized;
        if (map != null ? map.equals(bearing.unrecognized()) : bearing.unrecognized() == null) {
            if (Double.doubleToLongBits(this.angle) == Double.doubleToLongBits(bearing.angle()) && Double.doubleToLongBits(this.degrees) == Double.doubleToLongBits(bearing.degrees())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Map<String, SerializableJsonElement> map = this.unrecognized;
        return (((((map == null ? 0 : map.hashCode()) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.angle) >>> 32) ^ Double.doubleToLongBits(this.angle)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.degrees) >>> 32) ^ Double.doubleToLongBits(this.degrees)));
    }

    @Override // com.mapbox.api.directions.v5.models.Bearing
    public Bearing.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends Bearing.Builder {
        private Double angle;
        private Double degrees;
        private Map<String, SerializableJsonElement> unrecognized;

        @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
        /* bridge */ /* synthetic */ Bearing.Builder unrecognized(Map map) {
            return unrecognized((Map<String, SerializableJsonElement>) map);
        }

        Builder() {
        }

        private Builder(Bearing bearing) {
            this.unrecognized = bearing.unrecognized();
            this.angle = Double.valueOf(bearing.angle());
            this.degrees = Double.valueOf(bearing.degrees());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
        Bearing.Builder unrecognized(Map<String, SerializableJsonElement> map) {
            this.unrecognized = map;
            return this;
        }

        @Override // com.mapbox.api.directions.v5.models.Bearing.Builder
        public Bearing.Builder angle(double d) {
            this.angle = Double.valueOf(d);
            return this;
        }

        @Override // com.mapbox.api.directions.v5.models.Bearing.Builder
        public Bearing.Builder degrees(double d) {
            this.degrees = Double.valueOf(d);
            return this;
        }

        @Override // com.mapbox.api.directions.v5.models.Bearing.Builder
        public Bearing build() {
            String str = this.angle == null ? " angle" : "";
            if (this.degrees == null) {
                str = str + " degrees";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_Bearing(this.unrecognized, this.angle.doubleValue(), this.degrees.doubleValue());
        }
    }
}
