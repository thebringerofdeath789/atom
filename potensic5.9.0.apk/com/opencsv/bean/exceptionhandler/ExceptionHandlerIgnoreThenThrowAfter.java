package com.opencsv.bean.exceptionhandler;

import com.opencsv.exceptions.CsvException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ExceptionHandlerIgnoreThenThrowAfter implements CsvExceptionHandler {
    private final AtomicInteger count = new AtomicInteger();
    private final int maxExceptions;

    public ExceptionHandlerIgnoreThenThrowAfter(int i) {
        this.maxExceptions = i;
    }

    @Override // com.opencsv.bean.exceptionhandler.CsvExceptionHandler
    public CsvException handleException(CsvException csvException) throws CsvException {
        if (this.count.incrementAndGet() <= this.maxExceptions) {
            return null;
        }
        throw csvException;
    }
}