package com.ipotensic.kernel.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes2.dex */
public class FlightRecordBean extends LitePalSupport implements Serializable, Comparable<FlightRecordBean> {
    private String date;
    private long duration;
    private String height;

    /* renamed from: id */
    private int f2183id;
    private List<MultiPointBean> list = new ArrayList();
    private String mileage;
    private int num;
    private String speed;

    public List<MultiPointBean> getList() {
        return this.list;
    }

    public void setList(List<MultiPointBean> list) {
        this.list = list;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public int getId() {
        return this.f2183id;
    }

    public void setId(int i) {
        this.f2183id = i;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getSpeed() {
        return this.speed;
    }

    public void setSpeed(String str) {
        this.speed = str;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public String getMileage() {
        return this.mileage;
    }

    public void setMileage(String str) {
        this.mileage = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public List<MultiPointBean> getMultiPointBeans(int i) {
        return LitePal.where("flightRecordBean_id = ?", String.valueOf(i)).find(MultiPointBean.class);
    }

    @Override // java.lang.Comparable
    public int compareTo(FlightRecordBean flightRecordBean) {
        return flightRecordBean.getId() - this.f2183id;
    }
}