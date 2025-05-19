package com.ipotensic.baselib.dispatcher;

/* loaded from: classes2.dex */
public class Event {
    public int arg1;
    public int arg2;
    public EventID id;
    public Object obj;

    public Event(EventID eventID) {
        this.id = eventID;
    }
}
