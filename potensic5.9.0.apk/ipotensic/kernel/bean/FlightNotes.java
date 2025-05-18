package com.ipotensic.kernel.bean;

import com.ipotensic.baselib.DDLog;
import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes2.dex */
public class FlightNotes extends LitePalSupport implements Serializable, Comparable<FlightNotes> {
    private int id;
    private final long NULL = -1;
    private long startTime = -1;
    private long duration = -1;
    private double distance = -1.0d;
    private double speed = -1.0d;
    private double height = -1.0d;

    public long getStartTime() {
        return this.startTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double d) {
        this.height = d;
    }

    @Override // org.litepal.crud.LitePalSupport
    public boolean save() {
        if (this.startTime != -1 && this.duration != -1 && this.distance != -1.0d && this.speed != -1.0d && this.height != -1.0d) {
            return super.save();
        }
        DDLog.e("\u98de\u884c\u8bb0\u5f55 save failed , some thing is null");
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(FlightNotes flightNotes) {
        return flightNotes.id - this.id;
    }
}