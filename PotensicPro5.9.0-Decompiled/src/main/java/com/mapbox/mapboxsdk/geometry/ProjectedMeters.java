package com.mapbox.mapboxsdk.geometry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ProjectedMeters implements Parcelable {
    public static final Parcelable.Creator<ProjectedMeters> CREATOR = new Parcelable.Creator<ProjectedMeters>() { // from class: com.mapbox.mapboxsdk.geometry.ProjectedMeters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectedMeters createFromParcel(Parcel parcel) {
            return new ProjectedMeters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProjectedMeters[] newArray(int i) {
            return new ProjectedMeters[i];
        }
    };
    private double easting;
    private double northing;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ProjectedMeters(double d, double d2) {
        this.northing = d;
        this.easting = d2;
    }

    public ProjectedMeters(ProjectedMeters projectedMeters) {
        this.northing = projectedMeters.northing;
        this.easting = projectedMeters.easting;
    }

    private ProjectedMeters(Parcel parcel) {
        this.northing = parcel.readDouble();
        this.easting = parcel.readDouble();
    }

    public double getNorthing() {
        return this.northing;
    }

    public double getEasting() {
        return this.easting;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProjectedMeters projectedMeters = (ProjectedMeters) obj;
        return Double.compare(projectedMeters.easting, this.easting) == 0 && Double.compare(projectedMeters.northing, this.northing) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.easting);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.northing);
        return (i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return "ProjectedMeters [northing=" + this.northing + ", easting=" + this.easting + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.northing);
        parcel.writeDouble(this.easting);
    }
}
