package com.mapbox.android.telemetry;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.mapbox.android.telemetry.Event;

/* loaded from: classes3.dex */
public class AppUserTurnstile extends Event implements Parcelable {
    private static final String APPLICATION_CONTEXT_CANT_BE_NULL = "Create a MapboxTelemetry instance before calling this method.";
    private static final String APP_USER_TURNSTILE = "appUserTurnstile";

    @SerializedName("created")
    private final String created;

    @SerializedName("device")
    private final String device;

    @SerializedName("enabled.telemetry")
    private final boolean enabledTelemetry;

    @SerializedName(NotificationCompat.CATEGORY_EVENT)
    private final String event;

    @SerializedName("model")
    private final String model;

    @SerializedName("operatingSystem")
    private final String operatingSystem;

    @SerializedName("sdkIdentifier")
    private final String sdkIdentifier;

    @SerializedName("sdkVersion")
    private final String sdkVersion;

    @SerializedName("skuId")
    private String skuId;

    @SerializedName("userId")
    private final String userId;
    private static final String OPERATING_SYSTEM = "Android - " + Build.VERSION.RELEASE;
    public static final Parcelable.Creator<AppUserTurnstile> CREATOR = new Parcelable.Creator<AppUserTurnstile>() { // from class: com.mapbox.android.telemetry.AppUserTurnstile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppUserTurnstile createFromParcel(Parcel parcel) {
            return new AppUserTurnstile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppUserTurnstile[] newArray(int i) {
            return new AppUserTurnstile[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppUserTurnstile(String str, String str2) {
        this(str, str2, true);
    }

    AppUserTurnstile(String str, String str2, boolean z) {
        checkApplicationContext();
        this.event = APP_USER_TURNSTILE;
        this.created = TelemetryUtils.obtainCurrentDate();
        this.userId = TelemetryUtils.retrieveVendorId();
        this.enabledTelemetry = TelemetryEnabler.TELEMETRY_STATES.get(new TelemetryEnabler(z).obtainTelemetryState()).booleanValue();
        this.device = Build.DEVICE;
        this.sdkIdentifier = str;
        this.sdkVersion = str2;
        this.model = Build.MODEL;
        this.operatingSystem = OPERATING_SYSTEM;
    }

    public String getSkuId() {
        return this.skuId;
    }

    public void setSkuId(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.skuId = str;
    }

    @Override // com.mapbox.android.telemetry.Event
    Event.Type obtainType() {
        return Event.Type.TURNSTILE;
    }

    private AppUserTurnstile(Parcel parcel) {
        this.event = parcel.readString();
        this.created = parcel.readString();
        this.userId = parcel.readString();
        this.enabledTelemetry = parcel.readByte() != 0;
        this.device = parcel.readString();
        this.sdkIdentifier = parcel.readString();
        this.sdkVersion = parcel.readString();
        this.model = parcel.readString();
        this.operatingSystem = parcel.readString();
        this.skuId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.event);
        parcel.writeString(this.created);
        parcel.writeString(this.userId);
        parcel.writeByte(this.enabledTelemetry ? (byte) 1 : (byte) 0);
        parcel.writeString(this.device);
        parcel.writeString(this.sdkIdentifier);
        parcel.writeString(this.sdkVersion);
        parcel.writeString(this.model);
        parcel.writeString(this.operatingSystem);
        parcel.writeString(this.skuId);
    }

    private void checkApplicationContext() {
        if (MapboxTelemetry.applicationContext == null) {
            throw new IllegalStateException(APPLICATION_CONTEXT_CANT_BE_NULL);
        }
    }
}