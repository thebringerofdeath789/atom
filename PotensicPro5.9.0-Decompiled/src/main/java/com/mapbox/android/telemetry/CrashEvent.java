package com.mapbox.android.telemetry;

import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.mapbox.android.telemetry.Event;

/* loaded from: classes3.dex */
public class CrashEvent extends Event {

    @SerializedName("appId")
    private String appId;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("created")
    private final String created;

    @SerializedName("device")
    private String device;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final String event;

    @SerializedName("isSilent")
    private String isSilent;

    @SerializedName("model")
    private String model;

    @SerializedName("osVersion")
    private String osVersion;

    @SerializedName("sdkIdentifier")
    private String sdkIdentifier;

    @SerializedName("sdkVersion")
    private String sdkVersion;

    @SerializedName("stackTrace")
    private String stackTrace;

    @SerializedName("stackTraceHash")
    private String stackTraceHash;

    @SerializedName("threadDetails")
    private String threadDetails;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public CrashEvent(String str, String str2) {
        this.event = str;
        this.created = str2;
    }

    @Override // com.mapbox.android.telemetry.Event
    Event.Type obtainType() {
        return Event.Type.CRASH;
    }

    public String getHash() {
        return this.stackTraceHash;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.event) || TextUtils.isEmpty(this.created) || TextUtils.isEmpty(this.stackTraceHash)) ? false : true;
    }
}
