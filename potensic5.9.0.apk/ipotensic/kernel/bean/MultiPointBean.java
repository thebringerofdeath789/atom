package com.ipotensic.kernel.bean;

import org.litepal.crud.LitePalSupport;

/* loaded from: classes2.dex */
public class MultiPointBean extends LitePalSupport {
    private FlightRecordBean flightRecordBean;
    private int flightRecordBean_id;
    private int id;
    private double lat;
    private double lng;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getFlightRecordBean_id() {
        return this.flightRecordBean_id;
    }

    public void setFlightRecordBean_id(int i) {
        this.flightRecordBean_id = i;
    }

    public FlightRecordBean getFlightRecordBean() {
        return this.flightRecordBean;
    }

    public void setFlightRecordBean(FlightRecordBean flightRecordBean) {
        this.flightRecordBean = flightRecordBean;
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
}