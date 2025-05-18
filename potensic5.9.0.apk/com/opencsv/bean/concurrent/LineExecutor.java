package com.opencsv.bean.concurrent;

import com.opencsv.ICSVParser;
import com.opencsv.bean.BeanVerifier;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.exceptions.CsvMalformedLineException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Spliterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
public class LineExecutor<T> extends IntolerantThreadPoolExecutor<T> {
    private final CompleteFileReader<T> completeFileReader;

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ int characteristics() {
        return super.characteristics();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public /* bridge */ /* synthetic */ void complete() throws InterruptedException {
        super.complete();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ long estimateSize() {
        return super.estimateSize();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public /* bridge */ /* synthetic */ List getCapturedExceptions() {
        return super.getCapturedExceptions();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public /* bridge */ /* synthetic */ Throwable getTerminalException() {
        return super.getTerminalException();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ List shutdownNow() {
        return super.shutdownNow();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return super.tryAdvance(consumer);
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        return super.trySplit();
    }

    public LineExecutor(boolean z, Locale locale, CompleteFileReader<T> completeFileReader) {
        super(z, locale);
        this.completeFileReader = completeFileReader;
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public void prepare() {
        Thread thread = new Thread(this.completeFileReader);
        this.completeFileReader.setExecutor(this);
        super.prepare();
        thread.start();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    protected void checkExceptions() {
        Throwable terminalException = this.completeFileReader.getTerminalException();
        if (terminalException != null && !(terminalException instanceof RejectedExecutionException)) {
            shutdownNow();
            if (terminalException instanceof CsvMalformedLineException) {
                CsvMalformedLineException csvMalformedLineException = (CsvMalformedLineException) terminalException;
                throw new RuntimeException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("parsing.error.full"), Long.valueOf(csvMalformedLineException.getLineNumber()), csvMalformedLineException.getContext()), csvMalformedLineException);
            }
            throw new RuntimeException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("parsing.error.full"), Long.valueOf(this.completeFileReader.getLineProcessed()), Arrays.toString(this.completeFileReader.getLine())), terminalException);
        }
        super.checkExceptions();
    }

    public void submitLine(long j, MappingStrategy<? extends T> mappingStrategy, CsvToBeanFilter csvToBeanFilter, List<BeanVerifier<T>> list, String[] strArr, CsvExceptionHandler csvExceptionHandler) {
        if (this.accumulateThread != null) {
            this.expectedRecords.add(Long.valueOf(j));
        }
        try {
            execute(new ProcessCsvLine(j, mappingStrategy, csvToBeanFilter, list, strArr, this.resultQueue, this.thrownExceptionsQueue, this.expectedRecords, csvExceptionHandler));
        } catch (Exception e) {
            if (this.accumulateThread != null) {
                this.expectedRecords.remove(Long.valueOf(j));
                this.accumulateThread.setMustStop(true);
            }
            throw e;
        }
    }
}