package com.mapbox.android.telemetry;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.mapbox.android.telemetry.Event;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class VisionEvent extends Event implements Parcelable {
    public static final Parcelable.Creator<VisionEvent> CREATOR = new Parcelable.Creator<VisionEvent>() { // from class: com.mapbox.android.telemetry.VisionEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VisionEvent createFromParcel(Parcel parcel) {
            return new VisionEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VisionEvent[] newArray(int i) {
            return new VisionEvent[i];
        }
    };
    private static final String VIS_GENERAL = "vision.general";

    @SerializedName("contents")
    private HashMap<String, Object> contents;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final String event;

    @SerializedName("name")
    private String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    VisionEvent() {
        this.name = "";
        this.contents = new HashMap<>();
        this.event = VIS_GENERAL;
    }

    @Override // com.mapbox.android.telemetry.Event
    Event.Type obtainType() {
        return Event.Type.VIS_GENERAL;
    }

    public void setContents(HashMap<String, Object> hashMap) {
        this.contents = hashMap;
    }

    public void setName(String str) {
        this.name = str;
    }

    public HashMap<String, Object> getContents() {
        return this.contents;
    }

    private VisionEvent(Parcel parcel) {
        this.name = "";
        this.contents = new HashMap<>();
        this.event = parcel.readString();
        this.name = parcel.readString();
        this.contents = (HashMap) parcel.readSerializable();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.event);
        parcel.writeString(this.name);
        parcel.writeSerializable(this.contents);
    }
}
