package com.mapbox.android.telemetry;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
class ConcurrentQueue<T> {
    private static final String TAG = "ConcurrentQueue";
    private final Queue<T> queue = new ConcurrentLinkedQueue();

    ConcurrentQueue() {
    }

    boolean add(T t) {
        try {
            return this.queue.add(t);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    T remove() {
        return this.queue.remove();
    }

    List<T> flush() {
        ArrayList arrayList = new ArrayList(this.queue.size());
        try {
            arrayList.addAll(this.queue);
            this.queue.clear();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return arrayList;
    }

    int size() {
        return this.queue.size();
    }

    Queue<T> obtainQueue() {
        return this.queue;
    }
}
