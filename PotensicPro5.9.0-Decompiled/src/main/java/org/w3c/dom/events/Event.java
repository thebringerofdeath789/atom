package org.w3c.dom.events;

/* loaded from: classes6.dex */
public interface Event {
    public static final short AT_TARGET = 2;
    public static final short BUBBLING_PHASE = 3;
    public static final short CAPTURING_PHASE = 1;

    boolean getBubbles();

    boolean getCancelable();

    EventTarget getCurrentTarget();

    short getEventPhase();

    EventTarget getTarget();

    long getTimeStamp();

    String getType();

    void initEvent(String str, boolean z, boolean z2);

    void preventDefault();

    void stopPropagation();
}
