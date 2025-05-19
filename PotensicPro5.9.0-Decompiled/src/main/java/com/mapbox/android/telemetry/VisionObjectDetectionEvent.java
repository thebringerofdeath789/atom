package com.mapbox.android.telemetry;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.mapbox.android.telemetry.Event;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes3.dex */
public class VisionObjectDetectionEvent extends Event implements Parcelable {
    public static final Parcelable.Creator<VisionObjectDetectionEvent> CREATOR = new Parcelable.Creator<VisionObjectDetectionEvent>() { // from class: com.mapbox.android.telemetry.VisionObjectDetectionEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VisionObjectDetectionEvent createFromParcel(Parcel parcel) {
            return new VisionObjectDetectionEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VisionObjectDetectionEvent[] newArray(int i) {
            return new VisionObjectDetectionEvent[i];
        }
    };
    static final String VIS_OBJECT_DETECTION = "vision.objectDetection";

    @SerializedName(JamXmlElements.CLASS)
    private String clazz;

    @SerializedName("created")
    private final String created;

    @SerializedName("distance_from_camera")
    private Double distance_from_camera;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final String event;

    @SerializedName("object_lat")
    private Double object_lat;

    @SerializedName("object_lon")
    private Double object_lon;

    @SerializedName("object_pos_height")
    private Double object_pos_height;

    @SerializedName("object_size_height")
    private Double object_size_height;

    @SerializedName("object_size_width")
    private Double object_size_width;

    @SerializedName("sign_value")
    private String sign_value;

    @SerializedName("vehicle_lat")
    private Double vehicle_lat;

    @SerializedName("vehicle_lon")
    private Double vehicle_lon;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VisionObjectDetectionEvent(String str) {
        this.event = VIS_OBJECT_DETECTION;
        this.created = str;
        this.object_lat = null;
        this.object_lon = null;
        this.vehicle_lat = null;
        this.vehicle_lon = null;
        this.clazz = null;
        this.sign_value = null;
        this.object_size_height = null;
        this.object_size_width = null;
        this.object_pos_height = null;
        this.distance_from_camera = null;
    }

    public String getEvent() {
        return this.event;
    }

    public String getCreated() {
        return this.created;
    }

    public double getObjectLatitude() {
        return this.object_lat.doubleValue();
    }

    public void setObjectLatitude(double d) {
        this.object_lat = Double.valueOf(d);
    }

    public double getObjectLongitude() {
        return this.object_lon.doubleValue();
    }

    public void setObjectLongitude(double d) {
        this.object_lon = Double.valueOf(d);
    }

    public double getVehicleLatitude() {
        return this.vehicle_lat.doubleValue();
    }

    public void setVehicleLatitude(double d) {
        this.vehicle_lat = Double.valueOf(d);
    }

    public double getVehicleLongitude() {
        return this.vehicle_lon.doubleValue();
    }

    public void setVehicleLongitude(double d) {
        this.vehicle_lon = Double.valueOf(d);
    }

    public String getClazz() {
        return this.clazz;
    }

    public void setClazz(String str) {
        this.clazz = str;
    }

    public String getSignValue() {
        return this.sign_value;
    }

    public void setSignValue(String str) {
        this.sign_value = str;
    }

    public double getObjectSizeWidth() {
        return this.object_size_width.doubleValue();
    }

    public void setObjectSizeWidth(double d) {
        this.object_size_width = Double.valueOf(d);
    }

    public double getObjectSizeHeight() {
        return this.object_size_height.doubleValue();
    }

    public void setObjectSizeHeight(double d) {
        this.object_size_height = Double.valueOf(d);
    }

    public double getObjectPositionHeight() {
        return this.object_pos_height.doubleValue();
    }

    public void setObjectPositionHeight(double d) {
        this.object_pos_height = Double.valueOf(d);
    }

    public double getDistanceFromCamera() {
        return this.distance_from_camera.doubleValue();
    }

    public void setDistanceFromCamera(double d) {
        this.distance_from_camera = Double.valueOf(d);
    }

    @Override // com.mapbox.android.telemetry.Event
    Event.Type obtainType() {
        return Event.Type.VIS_OBJ_DETECTION;
    }

    private VisionObjectDetectionEvent(Parcel parcel) {
        this.event = parcel.readString();
        this.created = parcel.readString();
        this.object_lat = readDoubleIfNotNull(parcel);
        this.object_lon = readDoubleIfNotNull(parcel);
        this.vehicle_lat = readDoubleIfNotNull(parcel);
        this.vehicle_lon = readDoubleIfNotNull(parcel);
        this.clazz = readStringIfNotNull(parcel);
        this.sign_value = readStringIfNotNull(parcel);
        this.object_size_width = readDoubleIfNotNull(parcel);
        this.object_size_height = readDoubleIfNotNull(parcel);
        this.object_pos_height = readDoubleIfNotNull(parcel);
        this.distance_from_camera = readDoubleIfNotNull(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.event);
        parcel.writeString(this.created);
        writeDoubleIfNotNull(parcel, this.object_lat);
        writeDoubleIfNotNull(parcel, this.object_lon);
        writeDoubleIfNotNull(parcel, this.vehicle_lat);
        writeDoubleIfNotNull(parcel, this.vehicle_lon);
        writeStringIfNotNull(parcel, this.clazz);
        writeStringIfNotNull(parcel, this.sign_value);
        writeDoubleIfNotNull(parcel, this.object_size_width);
        writeDoubleIfNotNull(parcel, this.object_size_height);
        writeDoubleIfNotNull(parcel, this.object_pos_height);
        writeDoubleIfNotNull(parcel, this.distance_from_camera);
    }

    private static void writeDoubleIfNotNull(Parcel parcel, Double d) {
        parcel.writeByte((byte) (d != null ? 1 : 0));
        if (d != null) {
            parcel.writeDouble(d.doubleValue());
        }
    }

    private static void writeStringIfNotNull(Parcel parcel, String str) {
        parcel.writeByte((byte) (str != null ? 1 : 0));
        if (str != null) {
            parcel.writeString(str);
        }
    }

    private static Double readDoubleIfNotNull(Parcel parcel) {
        if (parcel.readByte() == 0) {
            return null;
        }
        return Double.valueOf(parcel.readDouble());
    }

    private static String readStringIfNotNull(Parcel parcel) {
        if (parcel.readByte() == 0) {
            return null;
        }
        return parcel.readString();
    }
}
