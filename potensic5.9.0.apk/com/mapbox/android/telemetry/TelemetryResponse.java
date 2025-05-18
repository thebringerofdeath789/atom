package com.mapbox.android.telemetry;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
class TelemetryResponse {

    @SerializedName("message")
    private final String message;

    TelemetryResponse(String str) {
        this.message = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.message;
        String str2 = ((TelemetryResponse) obj).message;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.message;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}