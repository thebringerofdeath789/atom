package com.ipotensic.kernel.bean;

import android.text.TextUtils;
import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes2.dex */
public class FlightLog extends LitePalSupport implements Serializable, Comparable<FlightLog> {

    /* renamed from: id */
    private int f2181id;
    private boolean isUpload;
    private String name;
    private final long NULL = -1;
    private long length = -1;

    public int getId() {
        return this.f2181id;
    }

    public void setId(int i) {
        this.f2181id = i;
    }

    public boolean isUpload() {
        return this.isUpload;
    }

    public void setUpload(boolean z) {
        this.isUpload = z;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(FlightLog flightLog) {
        return flightLog.getId() - this.f2181id;
    }

    @Override // org.litepal.crud.LitePalSupport
    public boolean save() {
        if (this.length == -1 || TextUtils.isEmpty(this.name)) {
            return false;
        }
        return super.save();
    }
}