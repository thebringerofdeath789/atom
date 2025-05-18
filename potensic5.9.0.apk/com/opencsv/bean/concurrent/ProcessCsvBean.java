package com.opencsv.bean.concurrent;

import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import com.opencsv.exceptions.CsvRuntimeException;
import java.util.SortedSet;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes3.dex */
public class ProcessCsvBean<T> implements Runnable {
    private final T bean;
    private final CsvExceptionHandler exceptionHandler;
    private final SortedSet<Long> expectedRecords;
    private final long lineNumber;
    private final MappingStrategy<T> mappingStrategy;
    private final BlockingQueue<OrderedObject<String[]>> resultantLineQueue;
    private final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue;

    public ProcessCsvBean(long j, MappingStrategy<T> mappingStrategy, T t, BlockingQueue<OrderedObject<String[]>> blockingQueue, BlockingQueue<OrderedObject<CsvException>> blockingQueue2, SortedSet<Long> sortedSet, CsvExceptionHandler csvExceptionHandler) {
        this.lineNumber = j;
        this.mappingStrategy = mappingStrategy;
        this.bean = t;
        this.resultantLineQueue = blockingQueue;
        this.thrownExceptionsQueue = blockingQueue2;
        this.expectedRecords = sortedSet;
        this.exceptionHandler = csvExceptionHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            OpencsvUtils.queueRefuseToAcceptDefeat(this.resultantLineQueue, new OrderedObject(this.lineNumber, this.mappingStrategy.transmuteBean(this.bean)));
        } catch (CsvChainedException e) {
            e = e;
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            OpencsvUtils.handleException(e, this.lineNumber, this.exceptionHandler, this.thrownExceptionsQueue);
        } catch (CsvFieldAssignmentException e2) {
            e = e2;
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            OpencsvUtils.handleException(e, this.lineNumber, this.exceptionHandler, this.thrownExceptionsQueue);
        } catch (CsvRuntimeException e3) {
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            throw e3;
        } catch (Exception e4) {
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            throw new RuntimeException(e4);
        }
    }
}