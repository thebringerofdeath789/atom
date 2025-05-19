package com.opencsv.bean.concurrent;

import com.opencsv.CSVReader;
import com.opencsv.bean.BeanVerifier;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class CompleteFileReader<T> extends SingleLineReader implements Runnable {
    private final CsvExceptionHandler exceptionHandler;
    private LineExecutor<T> executor;
    private final CsvToBeanFilter filter;
    private long lineProcessed;
    private final MappingStrategy<? extends T> mappingStrategy;
    private Throwable terminalException;
    private final List<BeanVerifier<T>> verifiers;

    public CompleteFileReader(CSVReader cSVReader, CsvToBeanFilter csvToBeanFilter, boolean z, MappingStrategy<? extends T> mappingStrategy, CsvExceptionHandler csvExceptionHandler, List<BeanVerifier<T>> list) {
        super(cSVReader, z);
        this.filter = csvToBeanFilter;
        this.mappingStrategy = mappingStrategy;
        this.exceptionHandler = csvExceptionHandler;
        this.verifiers = (List) ObjectUtils.defaultIfNull(list, Collections.emptyList());
    }

    public Throwable getTerminalException() {
        return this.terminalException;
    }

    public long getLineProcessed() {
        return this.lineProcessed;
    }

    public void setExecutor(LineExecutor<T> lineExecutor) {
        if (this.executor == null) {
            this.executor = lineExecutor;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (readNextLine() != null) {
            try {
                long linesRead = this.csvReader.getLinesRead();
                this.lineProcessed = linesRead;
                this.executor.submitLine(linesRead, this.mappingStrategy, this.filter, this.verifiers, this.line, this.exceptionHandler);
            } catch (Exception e) {
                this.terminalException = e;
                return;
            }
        }
        this.executor.complete();
    }
}
