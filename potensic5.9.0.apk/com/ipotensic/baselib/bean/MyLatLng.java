package com.ipotensic.baselib.bean;

import kotlin.Metadata;

/* compiled from: MyLatLng.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m2338d2 = {"Lcom/ipotensic/baselib/bean/MyLatLng;", "", "lat", "", "lng", "(DD)V", "getLat", "()D", "setLat", "(D)V", "getLng", "setLng", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "BaseLib_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final /* data */ class MyLatLng {
    private double lat;
    private double lng;

    public static /* synthetic */ MyLatLng copy$default(MyLatLng myLatLng, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = myLatLng.lat;
        }
        if ((i & 2) != 0) {
            d2 = myLatLng.lng;
        }
        return myLatLng.copy(d, d2);
    }

    /* renamed from: component1, reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* renamed from: component2, reason: from getter */
    public final double getLng() {
        return this.lng;
    }

    public final MyLatLng copy(double lat, double lng) {
        return new MyLatLng(lat, lng);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyLatLng)) {
            return false;
        }
        MyLatLng myLatLng = (MyLatLng) other;
        return Double.compare(this.lat, myLatLng.lat) == 0 && Double.compare(this.lng, myLatLng.lng) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.lat);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.lng);
        return i + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public String toString() {
        return "MyLatLng(lat=" + this.lat + ", lng=" + this.lng + ")";
    }

    public MyLatLng(double d, double d2) {
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
}