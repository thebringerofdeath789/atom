package org.w3c.dom.events;

/* loaded from: classes6.dex */
public interface EventTarget {
    void addEventListener(String str, EventListener eventListener, boolean z);

    boolean dispatchEvent(Event event) throws EventException;

    void removeEventListener(String str, EventListener eventListener, boolean z);
}
