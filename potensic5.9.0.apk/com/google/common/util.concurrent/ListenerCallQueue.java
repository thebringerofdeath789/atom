package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* loaded from: classes2.dex */
final class ListenerCallQueue<L> {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    interface Event<L> {
        void call(L l);
    }

    ListenerCallQueue() {
    }

    public void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue<>(l, executor));
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(obj, AnnotatedPrivateKey.LABEL);
        synchronized (this.listeners) {
            Iterator<PerListenerQueue<L>> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().add(event, obj);
            }
        }
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    private static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final L listener;
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();
        final Queue<Object> labelQueue = Queues.newArrayDeque();

        PerListenerQueue(L l, Executor executor) {
            this.listener = (L) Preconditions.checkNotNull(l);
            this.executor = (Executor) Preconditions.checkNotNull(executor);
        }

        synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        void dispatch() {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.isThreadScheduled) {
                    z = false;
                } else {
                    this.isThreadScheduled = true;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        ListenerCallQueue.logger.log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.logger.log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.listener + org.apache.commons.lang3.StringUtils.SPACE + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        
            r2.call(r9.listener);
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0060  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r9 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L5d
                boolean r2 = r9.isThreadScheduled     // Catch: java.lang.Throwable -> L50
                com.google.common.base.Preconditions.checkState(r2)     // Catch: java.lang.Throwable -> L50
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r9.waitQueue     // Catch: java.lang.Throwable -> L50
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L50
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch: java.lang.Throwable -> L50
                java.util.Queue<java.lang.Object> r3 = r9.labelQueue     // Catch: java.lang.Throwable -> L50
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L50
                if (r2 != 0) goto L1f
                r9.isThreadScheduled = r0     // Catch: java.lang.Throwable -> L50
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = r0
                goto L54
            L1f:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L50
                L r4 = r9.listener     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L5d
                r2.call(r4)     // Catch: java.lang.RuntimeException -> L26 java.lang.Throwable -> L5d
                goto L0
            L26:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.access$000()     // Catch: java.lang.Throwable -> L5d
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5d
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d
                r6.<init>()     // Catch: java.lang.Throwable -> L5d
                java.lang.String r7 = "Exception while executing callback: "
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L5d
                L r7 = r9.listener     // Catch: java.lang.Throwable -> L5d
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L5d
                java.lang.String r7 = " "
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L5d
                java.lang.StringBuilder r3 = r6.append(r3)     // Catch: java.lang.Throwable -> L5d
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5d
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L5d
                goto L0
            L50:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
            L54:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L5b
                throw r1     // Catch: java.lang.Throwable -> L56
            L56:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L5e
            L5b:
                r1 = move-exception
                goto L54
            L5d:
                r2 = move-exception
            L5e:
                if (r1 == 0) goto L68
                monitor-enter(r9)
                r9.isThreadScheduled = r0     // Catch: java.lang.Throwable -> L65
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L65
                goto L68
            L65:
                r0 = move-exception
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L65
                throw r0
            L68:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }
}