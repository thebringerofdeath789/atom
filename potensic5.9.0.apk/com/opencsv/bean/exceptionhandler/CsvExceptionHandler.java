package com.opencsv.bean.exceptionhandler;

import com.opencsv.exceptions.CsvException;

@FunctionalInterface
/* loaded from: classes3.dex */
public interface CsvExceptionHandler {
    CsvException handleException(CsvException csvException) throws CsvException;
}