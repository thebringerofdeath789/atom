package com.ipotensic.baselib.bean;

/* loaded from: classes2.dex */
public class Gps {
    private boolean isLastLocation = false;
    private double lat = 0.0d;
    private double lng = 0.0d;
    private short accuracy = 0;
    private short direction = 0;
    private short altitude = 0;

    public boolean isLastLocation() {
        return this.isLastLocation;
    }

    public void setLastLocation(boolean z) {
        this.isLastLocation = z;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public short getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(short s) {
        this.accuracy = s;
    }

    public short getDirection() {
        return this.direction;
    }

    public void setDirection(short s) {
        this.direction = s;
    }

    public short getAltitude() {
        return this.altitude;
    }

    public void setAltitude(short s) {
        this.altitude = s;
    }
}
