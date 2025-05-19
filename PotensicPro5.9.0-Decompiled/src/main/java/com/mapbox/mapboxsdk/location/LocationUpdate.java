package com.mapbox.mapboxsdk.location;

import android.location.Location;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class LocationUpdate {
    private final Long animationDuration;
    private final List<Location> intermediatePoints;
    private final Location location;

    private LocationUpdate(Location location, List<Location> list, Long l) {
        this.location = location;
        this.intermediatePoints = list;
        this.animationDuration = l;
    }

    public Location getLocation() {
        return this.location;
    }

    public List<Location> getIntermediatePoints() {
        return this.intermediatePoints;
    }

    public Long getAnimationDuration() {
        return this.animationDuration;
    }

    public String toString() {
        return "LocationUpdate{location=" + this.location + ", intermediatePoints=" + this.intermediatePoints + ", animationDuration=" + this.animationDuration + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationUpdate locationUpdate = (LocationUpdate) obj;
        if (!this.location.equals(locationUpdate.location) || !this.intermediatePoints.equals(locationUpdate.intermediatePoints)) {
            return false;
        }
        Long l = this.animationDuration;
        if (l != null) {
            return l.equals(locationUpdate.animationDuration);
        }
        return locationUpdate.animationDuration == null;
    }

    public int hashCode() {
        int hashCode = ((this.location.hashCode() * 31) + this.intermediatePoints.hashCode()) * 31;
        Long l = this.animationDuration;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public static class Builder {
        private Long animationDuration;
        private List<Location> intermediatePoints = Collections.emptyList();
        private Location location;

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Builder intermediatePoints(List<Location> list) {
            this.intermediatePoints = list;
            return this;
        }

        public Builder animationDuration(Long l) {
            this.animationDuration = l;
            return this;
        }

        public LocationUpdate build() {
            if (this.location == null) {
                throw new IllegalArgumentException("target location has to be provided when constructing the LocationUpdate");
            }
            return new LocationUpdate(this.location, this.intermediatePoints, this.animationDuration);
        }
    }
}
