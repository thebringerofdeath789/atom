package com.mapbox.mapboxsdk.camera;

import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import com.mapbox.mapboxsdk.C3178R;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.utils.MathUtils;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class CameraPosition implements Parcelable {
    public final double bearing;
    public final double[] padding;
    public final LatLng target;
    public final double tilt;
    public final double zoom;
    public static final CameraPosition DEFAULT = new CameraPosition(new LatLng(), 0.0d, 0.0d, 0.0d, new double[]{0.0d, 0.0d, 0.0d, 0.0d});
    public static final Parcelable.Creator<CameraPosition> CREATOR = new Parcelable.Creator<CameraPosition>() { // from class: com.mapbox.mapboxsdk.camera.CameraPosition.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraPosition createFromParcel(Parcel parcel) {
            double[] dArr;
            double readDouble = parcel.readDouble();
            LatLng latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            double readDouble2 = parcel.readDouble();
            double readDouble3 = parcel.readDouble();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                dArr = new double[readInt];
                for (int i = 0; i < readInt; i++) {
                    dArr[i] = parcel.readDouble();
                }
            } else {
                dArr = null;
            }
            return new CameraPosition(latLng, readDouble3, readDouble2, readDouble, dArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraPosition[] newArray(int i) {
            return new CameraPosition[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    CameraPosition(LatLng latLng, double d, double d2, double d3) {
        this(latLng, d, d2, d3, null);
    }

    CameraPosition(LatLng latLng, double d, double d2, double d3, double[] dArr) {
        this.target = latLng;
        this.bearing = d3;
        this.tilt = d2;
        this.zoom = d;
        this.padding = dArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.bearing);
        parcel.writeParcelable(this.target, i);
        parcel.writeDouble(this.tilt);
        parcel.writeDouble(this.zoom);
        double[] dArr = this.padding;
        if (dArr != null) {
            parcel.writeInt(dArr.length);
            for (double d : this.padding) {
                parcel.writeDouble(d);
            }
            return;
        }
        parcel.writeInt(-1);
    }

    public String toString() {
        return "Target: " + this.target + ", Zoom:" + this.zoom + ", Bearing:" + this.bearing + ", Tilt:" + this.tilt + ", Padding:" + Arrays.toString(this.padding);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        LatLng latLng = this.target;
        return (latLng == null || latLng.equals(cameraPosition.target)) && this.zoom == cameraPosition.zoom && this.tilt == cameraPosition.tilt && this.bearing == cameraPosition.bearing && Arrays.equals(this.padding, cameraPosition.padding);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.bearing);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        LatLng latLng = this.target;
        int hashCode = latLng != null ? latLng.hashCode() : 0;
        long doubleToLongBits2 = Double.doubleToLongBits(this.tilt);
        int i2 = ((i + hashCode) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.zoom);
        return (((i2 * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3))) * 31) + Arrays.hashCode(this.padding);
    }

    public static final class Builder {
        private double bearing;
        private double[] padding;
        private LatLng target;
        private double tilt;
        private double zoom;

        public Builder() {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
        }

        public Builder(CameraPosition cameraPosition) {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
            if (cameraPosition != null) {
                this.bearing = cameraPosition.bearing;
                this.target = cameraPosition.target;
                this.tilt = cameraPosition.tilt;
                this.zoom = cameraPosition.zoom;
                this.padding = cameraPosition.padding;
            }
        }

        public Builder(TypedArray typedArray) {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
            if (typedArray != null) {
                this.bearing = typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraBearing, 0.0f);
                this.target = new LatLng(typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraTargetLat, 0.0f), typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraTargetLng, 0.0f));
                this.tilt = typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraTilt, 0.0f);
                this.zoom = typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraZoom, 0.0f);
            }
        }

        public Builder(CameraUpdateFactory.CameraPositionUpdate cameraPositionUpdate) {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
            if (cameraPositionUpdate != null) {
                this.bearing = cameraPositionUpdate.getBearing();
                this.target = cameraPositionUpdate.getTarget();
                this.tilt = cameraPositionUpdate.getTilt();
                this.zoom = cameraPositionUpdate.getZoom();
                this.padding = cameraPositionUpdate.getPadding();
            }
        }

        public Builder(CameraUpdateFactory.ZoomUpdate zoomUpdate) {
            this.bearing = -1.0d;
            this.target = null;
            this.tilt = -1.0d;
            this.zoom = -1.0d;
            this.padding = null;
            if (zoomUpdate != null) {
                this.zoom = zoomUpdate.getZoom();
            }
        }

        public Builder bearing(double d) {
            while (d >= 360.0d) {
                d -= 360.0d;
            }
            while (d < 0.0d) {
                d += 360.0d;
            }
            this.bearing = d;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public Builder tilt(double d) {
            this.tilt = MathUtils.clamp(d, 0.0d, 60.0d);
            return this;
        }

        public Builder zoom(double d) {
            this.zoom = d;
            return this;
        }

        public Builder padding(double[] dArr) {
            this.padding = dArr;
            return this;
        }

        public Builder padding(double d, double d2, double d3, double d4) {
            this.padding = new double[]{d, d2, d3, d4};
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing, this.padding);
        }
    }
}