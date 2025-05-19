package com.mapbox.mapboxsdk.maps;

import java.util.Date;

/* loaded from: classes3.dex */
public final class ObservableEvent {
    private final Date begin;
    private final Value data;
    private final Date end;
    private final String type;

    public ObservableEvent(String str, Date date, Date date2, Value value) {
        this.type = str;
        this.begin = date;
        this.end = date2;
        this.data = value;
    }

    public String getType() {
        return this.type;
    }

    public Date getBegin() {
        return this.begin;
    }

    public Date getEnd() {
        return this.end;
    }

    public Value getData() {
        return this.data;
    }

    public String toString() {
        return "[type: " + this.type + ", begin: " + this.begin.toString() + ", end: " + this.end.toString() + ", data: " + this.data.getContents() + "]";
    }
}
