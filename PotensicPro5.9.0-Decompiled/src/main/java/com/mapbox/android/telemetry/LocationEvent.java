package com.mapbox.android.telemetry;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.mapbox.android.telemetry.Event;
import com.mapbox.mapboxsdk.style.layers.Property;

/* loaded from: classes3.dex */
public class LocationEvent extends Event implements Parcelable {
    private static final String LOCATION = "location";
    private static final String SOURCE_MAPBOX = "mapbox";

    @SerializedName("horizontalAccuracy")
    private Float accuracy;

    @SerializedName("altitude")
    private Double altitude;

    @SerializedName("applicationState")
    private String applicationState;

    @SerializedName("created")
    private final String created;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final String event;

    @SerializedName("lat")
    private final double latitude;

    @SerializedName("lng")
    private final double longitude;

    @SerializedName("operatingSystem")
    private String operatingSystem;

    @SerializedName("sessionId")
    private final String sessionId;

    @SerializedName(Property.SYMBOL_Z_ORDER_SOURCE)
    private String source;
    private static final String OPERATING_SYSTEM = "Android - " + Build.VERSION.RELEASE;
    public static final Parcelable.Creator<LocationEvent> CREATOR = new Parcelable.Creator<LocationEvent>() { // from class: com.mapbox.android.telemetry.LocationEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationEvent createFromParcel(Parcel parcel) {
            return new LocationEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationEvent[] newArray(int i) {
            return new LocationEvent[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationEvent(String str, double d, double d2, String str2) {
        this.altitude = null;
        this.accuracy = null;
        this.event = LOCATION;
        this.created = TelemetryUtils.obtainCurrentDate();
        this.source = "mapbox";
        this.sessionId = str;
        this.latitude = d;
        this.longitude = d2;
        this.operatingSystem = OPERATING_SYSTEM;
        this.applicationState = str2;
    }

    @Override // com.mapbox.android.telemetry.Event
    Event.Type obtainType() {
        return Event.Type.LOCATION;
    }

    String getEvent() {
        return this.event;
    }

    String getSource() {
        return this.source;
    }

    double getLatitude() {
        return this.latitude;
    }

    double getLongitude() {
        return this.longitude;
    }

    Double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(Double d) {
        this.altitude = d;
    }

    String getOperatingSystem() {
        return this.operatingSystem;
    }

    Float getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(Float f) {
        this.accuracy = f;
    }

    private LocationEvent(Parcel parcel) {
        this.altitude = null;
        this.accuracy = null;
        this.event = parcel.readString();
        this.created = parcel.readString();
        this.source = parcel.readString();
        this.sessionId = parcel.readString();
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.altitude = parcel.readByte() == 0 ? null : Double.valueOf(parcel.readDouble());
        this.operatingSystem = parcel.readString();
        this.applicationState = parcel.readString();
        this.accuracy = parcel.readByte() != 0 ? Float.valueOf(parcel.readFloat()) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.event);
        parcel.writeString(this.created);
        parcel.writeString(this.source);
        parcel.writeString(this.sessionId);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        if (this.altitude == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(this.altitude.doubleValue());
        }
        parcel.writeString(this.operatingSystem);
        parcel.writeString(this.applicationState);
        if (this.accuracy == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(this.accuracy.floatValue());
        }
    }
}
