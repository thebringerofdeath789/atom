package com.mapbox.mapboxsdk.module.telemetry;

import android.os.Parcel;
import com.mapbox.android.telemetry.Event;

/* loaded from: classes3.dex */
abstract class MapBaseEvent extends Event {
    private final String created;
    private final String event = getEventName();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    abstract String getEventName();

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    MapBaseEvent(PhoneState phoneState) {
        this.created = phoneState.getCreated();
    }

    String getEvent() {
        return this.event;
    }

    String getCreated() {
        return this.created;
    }
}