package com.mapbox.mapboxsdk.module.telemetry;

import android.os.Parcel;

/* loaded from: classes3.dex */
public class OfflineDownloadStartEvent extends MapBaseEvent {
    private static final String EVENT_NAME = "map.offlineDownload.start";
    private final Double maxZoom;
    private final Double minZoom;
    private final String shapeForOfflineRegion;
    private String styleURL;

    @Override // com.mapbox.mapboxsdk.module.telemetry.MapBaseEvent
    String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.mapbox.mapboxsdk.module.telemetry.MapBaseEvent, android.os.Parcelable
    public /* bridge */ /* synthetic */ int describeContents() {
        return super.describeContents();
    }

    @Override // com.mapbox.mapboxsdk.module.telemetry.MapBaseEvent, android.os.Parcelable
    public /* bridge */ /* synthetic */ void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    OfflineDownloadStartEvent(PhoneState phoneState, String str, Double d, Double d2) {
        super(phoneState);
        this.shapeForOfflineRegion = str;
        this.minZoom = d;
        this.maxZoom = d2;
    }

    Double getMinZoom() {
        return this.minZoom;
    }

    Double getMaxZoom() {
        return this.maxZoom;
    }

    String getShapeForOfflineRegion() {
        return this.shapeForOfflineRegion;
    }

    String getStyleURL() {
        return this.styleURL;
    }

    void setStyleURL(String str) {
        this.styleURL = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OfflineDownloadStartEvent offlineDownloadStartEvent = (OfflineDownloadStartEvent) obj;
        Double d = this.minZoom;
        if (d == null ? offlineDownloadStartEvent.minZoom != null : !d.equals(offlineDownloadStartEvent.minZoom)) {
            return false;
        }
        Double d2 = this.maxZoom;
        if (d2 == null ? offlineDownloadStartEvent.maxZoom != null : !d2.equals(offlineDownloadStartEvent.maxZoom)) {
            return false;
        }
        String str = this.shapeForOfflineRegion;
        if (str == null ? offlineDownloadStartEvent.shapeForOfflineRegion != null : !str.equals(offlineDownloadStartEvent.shapeForOfflineRegion)) {
            return false;
        }
        String str2 = this.styleURL;
        String str3 = offlineDownloadStartEvent.styleURL;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        Double d = this.minZoom;
        int hashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.maxZoom;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str = this.shapeForOfflineRegion;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.styleURL;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "OfflineDownloadStartEvent{, minZoom=" + this.minZoom + ", maxZoom=" + this.maxZoom + ", shapeForOfflineRegion='" + this.shapeForOfflineRegion + "', styleURL='" + this.styleURL + "'}";
    }
}
