package com.mapbox.android.telemetry;

import android.util.Log;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
class EventsQueue {
    private static final String LOG_TAG = "EventsQueue";
    static final int SIZE_LIMIT = 180;
    private final FullQueueCallback callback;
    private final ExecutorService executorService;
    private final ConcurrentQueue<Event> queue;

    EventsQueue(ConcurrentQueue<Event> concurrentQueue, FullQueueCallback fullQueueCallback, ExecutorService executorService) {
        this.queue = concurrentQueue;
        this.callback = fullQueueCallback;
        this.executorService = executorService;
    }

    static synchronized EventsQueue create(FullQueueCallback fullQueueCallback, ExecutorService executorService) {
        EventsQueue eventsQueue;
        synchronized (EventsQueue.class) {
            if (fullQueueCallback == null || executorService == null) {
                throw new IllegalArgumentException("Callback or executor can't be null");
            }
            eventsQueue = new EventsQueue(new ConcurrentQueue(), fullQueueCallback, executorService);
        }
        return eventsQueue;
    }

    boolean isEmpty() {
        return this.queue.size() == 0;
    }

    int size() {
        return this.queue.size();
    }

    boolean push(Event event) {
        boolean add;
        synchronized (this) {
            if (this.queue.size() >= 180) {
                dispatchCallback(this.queue.flush());
            }
            add = this.queue.add(event);
        }
        return add;
    }

    List<Event> flush() {
        List<Event> flush;
        synchronized (this) {
            flush = this.queue.flush();
        }
        return flush;
    }

    private void dispatchCallback(final List<Event> list) {
        try {
            this.executorService.execute(new Runnable() { // from class: com.mapbox.android.telemetry.EventsQueue.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        EventsQueue.this.callback.onFullQueue(list);
                    } catch (Throwable th) {
                        Log.e(EventsQueue.LOG_TAG, th.toString());
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            Log.e(LOG_TAG, e.toString());
        }
    }
}
