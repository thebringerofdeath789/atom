package com.mapbox.turf.models;

import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class LineIntersectsResult {
    private final Double horizontalIntersection;
    private final boolean onLine1;
    private final boolean onLine2;
    private final Double verticalIntersection;

    private LineIntersectsResult(Double d, Double d2, boolean z, boolean z2) {
        this.horizontalIntersection = d;
        this.verticalIntersection = d2;
        this.onLine1 = z;
        this.onLine2 = z2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Double horizontalIntersection() {
        return this.horizontalIntersection;
    }

    public Double verticalIntersection() {
        return this.verticalIntersection;
    }

    public boolean onLine1() {
        return this.onLine1;
    }

    public boolean onLine2() {
        return this.onLine2;
    }

    public String toString() {
        return "LineIntersectsResult{horizontalIntersection=" + this.horizontalIntersection + ", verticalIntersection=" + this.verticalIntersection + ", onLine1=" + this.onLine1 + ", onLine2=" + this.onLine2 + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LineIntersectsResult)) {
            return false;
        }
        LineIntersectsResult lineIntersectsResult = (LineIntersectsResult) obj;
        Double d = this.horizontalIntersection;
        if (d != null ? d.equals(lineIntersectsResult.horizontalIntersection()) : lineIntersectsResult.horizontalIntersection() == null) {
            Double d2 = this.verticalIntersection;
            if (d2 != null ? d2.equals(lineIntersectsResult.verticalIntersection()) : lineIntersectsResult.verticalIntersection() == null) {
                if (this.onLine1 == lineIntersectsResult.onLine1() && this.onLine2 == lineIntersectsResult.onLine2()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Double d = this.horizontalIntersection;
        int hashCode = ((d == null ? 0 : d.hashCode()) ^ 1000003) * 1000003;
        Double d2 = this.verticalIntersection;
        return ((((hashCode ^ (d2 != null ? d2.hashCode() : 0)) * 1000003) ^ (this.onLine1 ? 1231 : 1237)) * 1000003) ^ (this.onLine2 ? 1231 : 1237);
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Double horizontalIntersection;
        private Boolean onLine1;
        private Boolean onLine2;
        private Double verticalIntersection;

        Builder() {
            this.onLine1 = false;
            this.onLine2 = false;
        }

        private Builder(LineIntersectsResult lineIntersectsResult) {
            this.onLine1 = false;
            this.onLine2 = false;
            this.horizontalIntersection = lineIntersectsResult.horizontalIntersection();
            this.verticalIntersection = lineIntersectsResult.verticalIntersection();
            this.onLine1 = Boolean.valueOf(lineIntersectsResult.onLine1());
            this.onLine2 = Boolean.valueOf(lineIntersectsResult.onLine2());
        }

        public Builder horizontalIntersection(Double d) {
            this.horizontalIntersection = d;
            return this;
        }

        public Builder verticalIntersection(Double d) {
            this.verticalIntersection = d;
            return this;
        }

        public Builder onLine1(boolean z) {
            this.onLine1 = Boolean.valueOf(z);
            return this;
        }

        public Builder onLine2(boolean z) {
            this.onLine2 = Boolean.valueOf(z);
            return this;
        }

        public LineIntersectsResult build() {
            String str = this.onLine1 == null ? " onLine1" : "";
            if (this.onLine2 == null) {
                str = str + " onLine2";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new LineIntersectsResult(this.horizontalIntersection, this.verticalIntersection, this.onLine1.booleanValue(), this.onLine2.booleanValue());
        }
    }
}