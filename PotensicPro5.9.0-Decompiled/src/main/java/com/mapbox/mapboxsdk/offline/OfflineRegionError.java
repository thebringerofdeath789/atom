package com.mapbox.mapboxsdk.offline;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class OfflineRegionError {
    public static final String REASON_CONNECTION = "REASON_CONNECTION";
    public static final String REASON_NOT_FOUND = "REASON_NOT_FOUND";
    public static final String REASON_OTHER = "REASON_OTHER";
    public static final String REASON_SERVER = "REASON_SERVER";
    public static final String REASON_SUCCESS = "REASON_SUCCESS";
    private final String message;
    private final String reason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorReason {
    }

    private OfflineRegionError(String str, String str2) {
        this.reason = str;
        this.message = str2;
    }

    public String getReason() {
        return this.reason;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OfflineRegionError offlineRegionError = (OfflineRegionError) obj;
        if (this.reason.equals(offlineRegionError.reason)) {
            return this.message.equals(offlineRegionError.message);
        }
        return false;
    }

    public int hashCode() {
        return (this.reason.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        return "OfflineRegionError{reason='" + this.reason + "', message='" + this.message + "'}";
    }
}
