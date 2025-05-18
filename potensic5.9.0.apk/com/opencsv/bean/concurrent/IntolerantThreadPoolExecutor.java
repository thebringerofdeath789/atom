package com.opencsv.bean.concurrent;

import com.opencsv.ICSVParser;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import p000.C$r8$backportedMethods$utility$String$2$joinArray;

/* loaded from: classes3.dex */
class IntolerantThreadPoolExecutor<T> extends ThreadPoolExecutor implements Spliterator<T> {
    protected AccumulateCsvResults<T> accumulateThread;
    protected final Locale errorLocale;
    protected final SortedSet<Long> expectedRecords;
    private final boolean orderedResults;
    protected final BlockingQueue<OrderedObject<T>> resultQueue;
    private ConcurrentNavigableMap<Long, T> resultantBeansMap;
    private Throwable terminalException;
    private ListValuedMap<Long, CsvException> thrownExceptionsMap;
    protected final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue;

    IntolerantThreadPoolExecutor(boolean z, Locale locale) {
        super(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
        this.resultQueue = new LinkedBlockingQueue();
        this.thrownExceptionsQueue = new LinkedBlockingQueue();
        this.resultantBeansMap = null;
        this.thrownExceptionsMap = null;
        this.accumulateThread = null;
        this.expectedRecords = new ConcurrentSkipListSet();
        this.orderedResults = z;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    public void prepare() {
        prestartAllCoreThreads();
        if (this.orderedResults) {
            this.resultantBeansMap = new ConcurrentSkipListMap();
            this.thrownExceptionsMap = new ArrayListValuedHashMap();
            AccumulateCsvResults<T> accumulateCsvResults = new AccumulateCsvResults<>(this.resultQueue, this.thrownExceptionsQueue, this.expectedRecords, this.resultantBeansMap, this.thrownExceptionsMap);
            this.accumulateThread = accumulateCsvResults;
            accumulateCsvResults.start();
        }
    }

    public void complete() throws InterruptedException {
        shutdown();
        awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        AccumulateCsvResults<T> accumulateCsvResults = this.accumulateThread;
        if (accumulateCsvResults != null) {
            accumulateCsvResults.setMustStop(true);
            this.accumulateThread.join();
        }
        if (this.terminalException != null) {
            throw new RejectedExecutionException();
        }
    }

    public List<CsvException> getCapturedExceptions() {
        if (this.thrownExceptionsMap == null) {
            return (List) this.thrownExceptionsQueue.stream().filter(new Predicate() { // from class: com.opencsv.bean.concurrent.-$$Lambda$IntolerantThreadPoolExecutor$IAojVaEAKFFlYKlcqxDRy_m5ptw
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean nonNull;
                    nonNull = Objects.nonNull((OrderedObject) obj);
                    return nonNull;
                }
            }).map(new Function() { // from class: com.opencsv.bean.concurrent.-$$Lambda$-uQO2AWRjvAkm8PIHVeFLuIUUXo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return (CsvException) ((OrderedObject) obj).getElement();
                }
            }).collect(Collectors.toList());
        }
        final LinkedList linkedList = new LinkedList();
        synchronized (this.thrownExceptionsMap) {
            this.thrownExceptionsMap.keySet().stream().sorted().forEach(new Consumer() { // from class: com.opencsv.bean.concurrent.-$$Lambda$IntolerantThreadPoolExecutor$0CNokchnBVD6OP9fkz6511mXCzA
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    IntolerantThreadPoolExecutor.this.lambda$getCapturedExceptions$0$IntolerantThreadPoolExecutor(linkedList, (Long) obj);
                }
            });
        }
        return linkedList;
    }

    public /* synthetic */ void lambda$getCapturedExceptions$0$IntolerantThreadPoolExecutor(List list, Long l) {
        list.addAll(this.thrownExceptionsMap.get((ListValuedMap<Long, CsvException>) l));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        AccumulateCsvResults<T> accumulateCsvResults = this.accumulateThread;
        if (accumulateCsvResults != null) {
            accumulateCsvResults.setMustStop(true);
            try {
                this.accumulateThread.join();
            } catch (InterruptedException unused) {
            }
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th != null) {
            if (th.getCause() != null) {
                this.terminalException = th.getCause();
            } else {
                this.terminalException = th;
            }
            shutdownNow();
        }
    }

    public Throwable getTerminalException() {
        return this.terminalException;
    }

    protected void checkExceptions() {
        Throwable th = this.terminalException;
        if (th != null) {
            if (th instanceof CsvException) {
                CsvException csvException = (CsvException) th;
                throw new RuntimeException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("parsing.error.linenumber"), Long.valueOf(csvException.getLineNumber()), C$r8$backportedMethods$utility$String$2$joinArray.join(",", ArrayUtils.nullToEmpty(csvException.getLine()))), csvException);
            }
            throw new RuntimeException(this.terminalException);
        }
    }

    private boolean isConversionComplete() {
        AccumulateCsvResults<T> accumulateCsvResults;
        return isTerminated() && ((accumulateCsvResults = this.accumulateThread) == null || !accumulateCsvResults.isAlive());
    }

    private boolean areMoreResultsAvailable() {
        checkExceptions();
        boolean z = false;
        while (!z && !isConversionComplete()) {
            if (this.accumulateThread == null) {
                if (this.resultQueue.isEmpty()) {
                    Thread.yield();
                }
                z = true;
            } else {
                if (this.resultantBeansMap.isEmpty()) {
                    Thread.yield();
                }
                z = true;
            }
            checkExceptions();
        }
        if (this.accumulateThread == null) {
            if (this.resultQueue.isEmpty()) {
                return false;
            }
        } else if (this.resultantBeansMap.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean tryAdvance(Consumer<? super T> consumer) {
        T t = null;
        if (areMoreResultsAvailable()) {
            if (this.accumulateThread == null) {
                OrderedObject<T> poll = this.resultQueue.poll();
                if (poll != null) {
                    t = (Object) poll.getElement();
                }
            } else {
                Map.Entry<Long, T> pollFirstEntry = this.resultantBeansMap.pollFirstEntry();
                if (pollFirstEntry != null) {
                    t = pollFirstEntry.getValue();
                }
            }
            if (t != null) {
                consumer.accept(t);
            }
        }
        return t != null;
    }

    public Spliterator<T> trySplit() {
        ArrayList arrayList;
        if (!areMoreResultsAvailable()) {
            return null;
        }
        if (isConversionComplete()) {
            if (this.accumulateThread == null) {
                return this.resultQueue.stream().map(new Function() { // from class: com.opencsv.bean.concurrent.-$$Lambda$DftGRW3RCXD5pdH0C43qGoWmqPY
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((OrderedObject) obj).getElement();
                    }
                }).spliterator();
            }
            return this.resultantBeansMap.values().spliterator();
        }
        int i = 0;
        if (this.accumulateThread == null) {
            int size = this.resultQueue.size();
            arrayList = new ArrayList(size);
            while (i < size) {
                OrderedObject<T> poll = this.resultQueue.poll();
                if (poll != null) {
                    arrayList.add(poll.getElement());
                }
                i++;
            }
        } else {
            int size2 = this.resultantBeansMap.size();
            arrayList = new ArrayList(size2);
            while (i < size2) {
                Map.Entry<Long, T> pollFirstEntry = this.resultantBeansMap.pollFirstEntry();
                if (pollFirstEntry != null) {
                    arrayList.add(pollFirstEntry.getValue());
                }
                i++;
            }
        }
        return arrayList.spliterator();
    }

    public long estimateSize() {
        return this.accumulateThread == null ? this.resultQueue.size() : this.resultantBeansMap.size();
    }

    public int characteristics() {
        return this.accumulateThread != null ? 4368 : 4352;
    }
}