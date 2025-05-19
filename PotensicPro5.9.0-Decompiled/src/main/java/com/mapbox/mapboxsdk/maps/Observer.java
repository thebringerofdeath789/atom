package com.mapbox.mapboxsdk.maps;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class Observer {
    private static AtomicInteger idCounter = new AtomicInteger(0);
    private final int id = idCounter.incrementAndGet();

    public abstract void notify(ObservableEvent observableEvent);

    public int getId() {
        return this.id;
    }
}
