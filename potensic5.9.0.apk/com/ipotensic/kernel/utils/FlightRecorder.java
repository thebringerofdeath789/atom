package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.bean.FlightNotes;
import com.logan.flight.data.FlightRevData;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FlightRecorder {

    /* renamed from: id */
    private int f2241id;
    private Long startTime = null;
    private Long endTime = null;
    private Double distance = null;
    private Double speed = null;
    private Double height = null;
    private ArrayList<Integer> speedList = new ArrayList<>();

    public int getId() {
        return this.f2241id;
    }

    public void setId(int i) {
        this.f2241id = i;
    }

    public void start() {
        DDLog.m1684e("开始记录飞行记录");
        this.startTime = Long.valueOf(System.currentTimeMillis());
    }

    public boolean finishAndSave() {
        DDLog.m1684e("结束保存飞行记录");
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
        DDLog.m1691w("飞行记录保存前:" + toString());
        if (this.startTime == null || (l = this.endTime) == null || this.distance == null || this.height == null) {
            DDLog.m1691w("飞行记录存储 something is null");
            return false;
        }
        if (l.longValue() < this.startTime.longValue()) {
            DDLog.m1691w("飞行记录存储 time is null");
            return false;
        }
        FlightNotes flightNotes = new FlightNotes();
        flightNotes.setStartTime(this.startTime.longValue());
        flightNotes.setDuration((this.endTime.longValue() - this.startTime.longValue()) + 1000);
        flightNotes.setDistance(this.distance.doubleValue());
        flightNotes.setHeight(this.height.doubleValue());
        flightNotes.setSpeed(this.speed.doubleValue());
        boolean save = flightNotes.save();
        DDLog.m1691w("飞行记录存储成功：" + save);
        release();
        return save;
    }

    private void release() {
        this.speedList.clear();
        this.speedList = null;
    }

    public String toString() {
        return "FlightRecorder{id=" + this.f2241id + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", distance=" + this.distance + ", speed=" + this.speed + ", height=" + this.height + ", speedList.size=" + this.speedList.size() + '}';
    }
}