package com.opencsv.bean.concurrent;

import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvException;
import java.util.SortedSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.collections4.ListValuedMap;

/* loaded from: classes3.dex */
class AccumulateCsvResults<T> extends Thread {
    private final SortedSet<Long> expectedRecords;
    private boolean mustStop = false;
    private final ConcurrentMap<Long, T> resultantBeanMap;
    private final BlockingQueue<OrderedObject<T>> resultantBeansQueue;
    private final ListValuedMap<Long, CsvException> thrownExceptionsMap;
    private final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue;

    AccumulateCsvResults(BlockingQueue<OrderedObject<T>> blockingQueue, BlockingQueue<OrderedObject<CsvException>> blockingQueue2, SortedSet<Long> sortedSet, ConcurrentMap<Long, T> concurrentMap, ListValuedMap<Long, CsvException> listValuedMap) {
        this.resultantBeansQueue = blockingQueue;
        this.thrownExceptionsQueue = blockingQueue2;
        this.expectedRecords = sortedSet;
        this.resultantBeanMap = concurrentMap;
        this.thrownExceptionsMap = listValuedMap;
    }

    private synchronized boolean isMustStop() {
        return this.mustStop;
    }

    synchronized void setMustStop(boolean z) {
        this.mustStop = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x003c, code lost:
    
        r0 = null;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r5 = this;
        L0:
            boolean r0 = r5.isMustStop()
            if (r0 == 0) goto L18
            java.util.concurrent.BlockingQueue<com.opencsv.bean.util.OrderedObject<T>> r0 = r5.resultantBeansQueue
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L18
            java.util.concurrent.BlockingQueue<com.opencsv.bean.util.OrderedObject<com.opencsv.exceptions.CsvException>> r0 = r5.thrownExceptionsQueue
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L17
            goto L18
        L17:
            return
        L18:
            java.util.SortedSet<java.lang.Long> r0 = r5.expectedRecords
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L3b
            java.util.concurrent.BlockingQueue<com.opencsv.bean.util.OrderedObject<T>> r0 = r5.resultantBeansQueue
            java.util.stream.Stream r0 = r0.stream()
            com.opencsv.bean.concurrent.-$$Lambda$AccumulateCsvResults$Vfr0yN5t6BZA8LQDKh5dUvhvXdA r2 = new com.opencsv.bean.concurrent.-$$Lambda$AccumulateCsvResults$Vfr0yN5t6BZA8LQDKh5dUvhvXdA
            r2.<init>()
            java.util.stream.Stream r0 = r0.filter(r2)
            java.util.Optional r0 = r0.findAny()
            java.lang.Object r0 = r0.orElse(r1)
            com.opencsv.bean.util.OrderedObject r0 = (com.opencsv.bean.util.OrderedObject) r0
            goto L3c
        L3b:
            r0 = r1
        L3c:
            if (r0 == 0) goto L7f
            java.util.concurrent.BlockingQueue<com.opencsv.bean.util.OrderedObject<T>> r2 = r5.resultantBeansQueue
            r2.remove(r0)
            java.util.SortedSet<java.lang.Long> r2 = r5.expectedRecords
            java.lang.Object r3 = r2.first()
            r2.remove(r3)
            java.util.concurrent.ConcurrentMap<java.lang.Long, T> r2 = r5.resultantBeanMap
            long r3 = r0.getOrdinal()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r0 = r0.getElement()
            r2.put(r3, r0)
            java.util.SortedSet<java.lang.Long> r0 = r5.expectedRecords
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L3b
            java.util.concurrent.BlockingQueue<com.opencsv.bean.util.OrderedObject<T>> r0 = r5.resultantBeansQueue
            java.util.stream.Stream r0 = r0.stream()
            com.opencsv.bean.concurrent.-$$Lambda$AccumulateCsvResults$dg7ahL1e-7xeI7a4T5RrumeJItY r2 = new com.opencsv.bean.concurrent.-$$Lambda$AccumulateCsvResults$dg7ahL1e-7xeI7a4T5RrumeJItY
            r2.<init>()
            java.util.stream.Stream r0 = r0.filter(r2)
            java.util.Optional r0 = r0.findAny()
            java.lang.Object r0 = r0.orElse(r1)
            com.opencsv.bean.util.OrderedObject r0 = (com.opencsv.bean.util.OrderedObject) r0
            goto L3c
        L7f:
            java.util.concurrent.BlockingQueue<com.opencsv.bean.util.OrderedObject<com.opencsv.exceptions.CsvException>> r0 = r5.thrownExceptionsQueue
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Laa
            java.util.concurrent.BlockingQueue<com.opencsv.bean.util.OrderedObject<com.opencsv.exceptions.CsvException>> r0 = r5.thrownExceptionsQueue
            java.lang.Object r0 = r0.poll()
            com.opencsv.bean.util.OrderedObject r0 = (com.opencsv.bean.util.OrderedObject) r0
            if (r0 == 0) goto L7f
            org.apache.commons.collections4.ListValuedMap<java.lang.Long, com.opencsv.exceptions.CsvException> r1 = r5.thrownExceptionsMap
            monitor-enter(r1)
            org.apache.commons.collections4.ListValuedMap<java.lang.Long, com.opencsv.exceptions.CsvException> r2 = r5.thrownExceptionsMap     // Catch: java.lang.Throwable -> La7
            long r3 = r0.getOrdinal()     // Catch: java.lang.Throwable -> La7
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.Object r0 = r0.getElement()     // Catch: java.lang.Throwable -> La7
            r2.put(r3, r0)     // Catch: java.lang.Throwable -> La7
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La7
            goto L7f
        La7:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> La7
            throw r0
        Laa:
            java.lang.Thread.yield()
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opencsv.bean.concurrent.AccumulateCsvResults.run():void");
    }

    public /* synthetic */ boolean lambda$run$0$AccumulateCsvResults(OrderedObject orderedObject) {
        return this.expectedRecords.first().equals(Long.valueOf(orderedObject.getOrdinal()));
    }

    public /* synthetic */ boolean lambda$run$1$AccumulateCsvResults(OrderedObject orderedObject) {
        return this.expectedRecords.first().equals(Long.valueOf(orderedObject.getOrdinal()));
    }
}
