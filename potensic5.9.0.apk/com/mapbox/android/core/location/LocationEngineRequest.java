package com.mapbox.android.core.location;

/* loaded from: classes3.dex */
public class LocationEngineRequest {
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 1;
    public static final int PRIORITY_HIGH_ACCURACY = 0;
    public static final int PRIORITY_LOW_POWER = 2;
    public static final int PRIORITY_NO_POWER = 3;
    private final float displacement;
    private final long fastestInterval;
    private final long interval;
    private final long maxWaitTime;
    private final int priority;

    private LocationEngineRequest(Builder builder) {
        this.interval = builder.interval;
        this.priority = builder.priority;
        this.displacement = builder.displacement;
        this.maxWaitTime = builder.maxWaitTime;
        this.fastestInterval = builder.fastestInterval;
    }

    public long getInterval() {
        return this.interval;
    }

    public int getPriority() {
        return this.priority;
    }

    public float getDisplacement() {
        return this.displacement;
    }

    public long getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public long getFastestInterval() {
        return this.fastestInterval;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationEngineRequest locationEngineRequest = (LocationEngineRequest) obj;
        return this.interval == locationEngineRequest.interval && this.priority == locationEngineRequest.priority && Float.compare(locationEngineRequest.displacement, this.displacement) == 0 && this.maxWaitTime == locationEngineRequest.maxWaitTime && this.fastestInterval == locationEngineRequest.fastestInterval;
    }

    public int hashCode() {
        long j = this.interval;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.priority) * 31;
        float f = this.displacement;
        int floatToIntBits = f != 0.0f ? Float.floatToIntBits(f) : 0;
        long j2 = this.maxWaitTime;
        int i2 = (((i + floatToIntBits) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.fastestInterval;
        return i2 + ((int) ((j3 >>> 32) ^ j3));
    }

    public static final class Builder {
        private final long interval;
        private int priority = 0;
        private float displacement = 0.0f;
        private long maxWaitTime = 0;
        private long fastestInterval = 0;

        public Builder(long j) {
            this.interval = j;
        }

        public Builder setPriority(int i) {
            this.priority = i;
            return this;
        }

        public Builder setDisplacement(float f) {
            this.displacement = f;
            return this;
        }

        public Builder setMaxWaitTime(long j) {
            this.maxWaitTime = j;
            return this;
        }

        public Builder setFastestInterval(long j) {
            this.fastestInterval = j;
            return this;
        }

        public LocationEngineRequest build() {
            return new LocationEngineRequest(this);
        }
    }
}