package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.bean.FlightNotes;
import com.logan.flight.data.FlightRevData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FlightRecorder {
    private int id;
    private Long startTime = null;
    private Long endTime = null;
    private Double distance = null;
    private Double speed = null;
    private Double height = null;
    private ArrayList<Integer> speedList = new ArrayList<>();

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void start() {
        DDLog.e("\u5f00\u59cb\u8bb0\u5f55\u98de\u884c\u8bb0\u5f55");
        this.startTime = Long.valueOf(System.currentTimeMillis());
    }

    public boolean finishAndSave() {
        DDLog.e("\u7ed3\u675f\u4fdd\u5b58\u98de\u884c\u8bb0\u5f55");
        this.endTime = Long.valueOf(System.currentTimeMillis());
        return saveNote();
    }

    public void refresh() {
        setDistance(FlightRevData.get().getFlightRevFlightInfoData().getHorizontalDistance());
        setHeight(FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance());
        setSpeed(FlightRevData.get().getFlightRevFlightInfoData().getHorizontalSpeed(), FlightRevData.get().getFlightRevFlightInfoData().getVerticalSpeed());
    }

    public void setDistance(double d) {
        Double d2 = this.distance;
        if (d2 == null || d > d2.doubleValue()) {
            this.distance = Double.valueOf(d);
        }
    }

    public void setSpeed(double d, double d2) {
        Double d3 = this.speed;
        if (d3 == null) {
            this.speed = Double.valueOf(d);
        } else {
            this.speed = Double.valueOf(Math.max(d3.doubleValue(), d));
        }
    }

    public void setHeight(double d) {
        Double d2 = this.height;
        if (d2 == null || d > d2.doubleValue()) {
            this.height = Double.valueOf(d);
        }
    }

    private boolean saveNote() {
        Long l;
        DDLog.w("\u98de\u884c\u8bb0\u5f55\u4fdd\u5b58\u524d:" + toString());
        if (this.startTime == null || (l = this.endTime) == null || this.distance == null || this.height == null) {
            DDLog.w("\u98de\u884c\u8bb0\u5f55\u5b58\u50a8 something is null");
            return false;
        }
        if (l.longValue() < this.startTime.longValue()) {
            DDLog.w("\u98de\u884c\u8bb0\u5f55\u5b58\u50a8 time is null");
            return false;
        }
        FlightNotes flightNotes = new FlightNotes();
        flightNotes.setStartTime(this.startTime.longValue());
        flightNotes.setDuration((this.endTime.longValue() - this.startTime.longValue()) + 1000);
        flightNotes.setDistance(this.distance.doubleValue());
        flightNotes.setHeight(this.height.doubleValue());
        flightNotes.setSpeed(this.speed.doubleValue());
        boolean save = flightNotes.save();
        DDLog.w("\u98de\u884c\u8bb0\u5f55\u5b58\u50a8\u6210\u529f\uff1a" + save);
        release();
        return save;
    }

    private void release() {
        this.speedList.clear();
        this.speedList = null;
    }

    public String toString() {
        return "FlightRecorder{id=" + this.id + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", distance=" + this.distance + ", speed=" + this.speed + ", height=" + this.height + ", speedList.size=" + this.speedList.size() + '}';
    }
}