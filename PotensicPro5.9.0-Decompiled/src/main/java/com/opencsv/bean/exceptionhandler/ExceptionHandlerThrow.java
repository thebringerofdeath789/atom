package com.opencsv.bean.exceptionhandler;

import com.opencsv.exceptions.CsvException;

/* loaded from: classes3.dex */
public final class ExceptionHandlerThrow implements CsvExceptionHandler {
    @Override // com.opencsv.bean.exceptionhandler.CsvExceptionHandler
    public CsvException handleException(CsvException csvException) throws CsvException {
        throw csvException;
    }
}
