package com.opencsv.bean.exceptionhandler;

import com.opencsv.exceptions.CsvException;

/* loaded from: classes3.dex */
public final class ExceptionHandlerIgnore implements CsvExceptionHandler {
    @Override // com.opencsv.bean.exceptionhandler.CsvExceptionHandler
    public CsvException handleException(CsvException csvException) {
        return null;
    }
}