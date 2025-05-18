package com.opencsv.bean.concurrent;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.concurrent.BlockingQueue;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public class ProcessCsvLine<T> implements Runnable {
    private final CsvExceptionHandler exceptionHandler;
    private final SortedSet<Long> expectedRecords;
    private final CsvToBeanFilter filter;
    private final String[] line;
    private final long lineNumber;
    private final MappingStrategy<? extends T> mapper;
    private final BlockingQueue<OrderedObject<T>> resultantBeanQueue;
    private final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue;
    private final List<BeanVerifier<T>> verifiers;

    public ProcessCsvLine(long j, MappingStrategy<? extends T> mappingStrategy, CsvToBeanFilter csvToBeanFilter, List<BeanVerifier<T>> list, String[] strArr, BlockingQueue<OrderedObject<T>> blockingQueue, BlockingQueue<OrderedObject<CsvException>> blockingQueue2, SortedSet<Long> sortedSet, CsvExceptionHandler csvExceptionHandler) {
        this.lineNumber = j;
        this.mapper = mappingStrategy;
        this.filter = csvToBeanFilter;
        this.verifiers = (List) ObjectUtils.defaultIfNull(new ArrayList(list), Collections.emptyList());
        this.line = (String[]) ArrayUtils.clone(strArr);
        this.resultantBeanQueue = blockingQueue;
        this.thrownExceptionsQueue = blockingQueue2;
        this.expectedRecords = sortedSet;
        this.exceptionHandler = csvExceptionHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CsvToBeanFilter csvToBeanFilter = this.filter;
            if (csvToBeanFilter != null && !csvToBeanFilter.allowLine(this.line)) {
                this.expectedRecords.remove(Long.valueOf(this.lineNumber));
                return;
            }
            T processLine = processLine();
            ListIterator<BeanVerifier<T>> listIterator = this.verifiers.listIterator();
            boolean z = true;
            while (z && listIterator.hasNext()) {
                z = listIterator.next().verifyBean(processLine);
            }
            if (z) {
                OpencsvUtils.queueRefuseToAcceptDefeat(this.resultantBeanQueue, new OrderedObject(this.lineNumber, processLine));
            } else {
                this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            }
        } catch (CsvException e) {
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            e.setLine(this.line);
            OpencsvUtils.handleException(e, this.lineNumber, this.exceptionHandler, this.thrownExceptionsQueue);
        } catch (Exception e2) {
            this.expectedRecords.remove(Long.valueOf(this.lineNumber));
            throw new RuntimeException(e2);
        }
    }

    private T processLine() throws CsvBeanIntrospectionException, CsvBadConverterException, CsvFieldAssignmentException, CsvChainedException {
        return this.mapper.populateNewBean(this.line);
    }
}