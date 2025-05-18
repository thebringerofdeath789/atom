package com.ipotensic.kernel.maps.bean;

import kotlin.Metadata;

/* compiled from: CommonLatLng.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/ipotensic/kernel/maps/bean/CommonLatLng;", "", "lat", "", "lng", "(DD)V", "getLat", "()D", "setLat", "(D)V", "getLng", "setLng", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isValid", "toString", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class CommonLatLng {
    private double lat;
    private double lng;

    public static /* synthetic */ CommonLatLng copy$default(CommonLatLng commonLatLng, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = commonLatLng.lat;
        }
        if ((i & 2) != 0) {
            d2 = commonLatLng.lng;
        }
        return commonLatLng.copy(d, d2);
    }

    /* renamed from: component1, reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* renamed from: component2, reason: from getter */
    public final double getLng() {
        return this.lng;
    }

    public final CommonLatLng copy(double lat, double lng) {
        return new CommonLatLng(lat, lng);
    }

    public String toString() {
        return "CommonLatLng(lat=" + this.lat + ", lng=" + this.lng + ")";
    }

    public CommonLatLng(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final void setLng(double d) {
        this.lng = d;
    }

    public final boolean isValid() {
        return (this.lat == 0.0d || this.lng == 0.0d) ? false : true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonLatLng)) {
            return false;
        }
        CommonLatLng commonLatLng = (CommonLatLng) other;
        return this.lat == commonLatLng.lat && this.lng == commonLatLng.lng;
    }

    public int hashCode() {
        return (Double.hashCode(this.lat) * 31) + Double.hashCode(this.lng);
    }
}