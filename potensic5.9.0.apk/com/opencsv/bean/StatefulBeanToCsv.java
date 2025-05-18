package com.opencsv.bean;

import com.opencsv.CSVWriter;
import com.opencsv.ICSVParser;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.concurrent.BeanExecutor;
import com.opencsv.bean.concurrent.ProcessCsvBean;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerThrow;
import com.opencsv.bean.util.OpencsvUtils;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvRuntimeException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Consumer;
import java.util.function.ToLongFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class StatefulBeanToCsv<T> {
    private static final char NO_CHARACTER = 0;
    private final boolean applyQuotesToAll;
    private List<CsvException> capturedExceptions;
    private ICSVWriter csvwriter;
    private Locale errorLocale;
    private final char escapechar;
    private final CsvExceptionHandler exceptionHandler;
    private BeanExecutor<T> executor;
    private boolean headerWritten;
    private final MultiValuedMap<Class<?>, Field> ignoredFields;
    private final String lineEnd;
    private int lineNumber;
    private MappingStrategy<T> mappingStrategy;
    private boolean orderedResults;
    private final String profile;
    private final char quotechar;
    private final char separator;
    private final Writer writer;

    StatefulBeanToCsv(char c, String str, MappingStrategy<T> mappingStrategy, char c2, char c3, CsvExceptionHandler csvExceptionHandler, Writer writer, boolean z, MultiValuedMap<Class<?>, Field> multiValuedMap, String str2) {
        this.lineNumber = 0;
        this.headerWritten = false;
        this.capturedExceptions = new ArrayList();
        this.orderedResults = true;
        this.executor = null;
        this.errorLocale = Locale.getDefault();
        this.escapechar = c;
        this.lineEnd = str;
        this.mappingStrategy = mappingStrategy;
        this.quotechar = c2;
        this.separator = c3;
        this.exceptionHandler = csvExceptionHandler;
        this.writer = writer;
        this.applyQuotesToAll = z;
        this.ignoredFields = multiValuedMap;
        this.profile = StringUtils.defaultString(str2);
    }

    public StatefulBeanToCsv(MappingStrategy<T> mappingStrategy, CsvExceptionHandler csvExceptionHandler, boolean z, ICSVWriter iCSVWriter, MultiValuedMap<Class<?>, Field> multiValuedMap, String str) {
        this.lineNumber = 0;
        this.headerWritten = false;
        this.capturedExceptions = new ArrayList();
        this.orderedResults = true;
        this.executor = null;
        this.errorLocale = Locale.getDefault();
        this.mappingStrategy = mappingStrategy;
        this.exceptionHandler = csvExceptionHandler;
        this.applyQuotesToAll = z;
        this.csvwriter = iCSVWriter;
        this.escapechar = (char) 0;
        this.lineEnd = "";
        this.quotechar = (char) 0;
        this.separator = (char) 0;
        this.writer = null;
        this.ignoredFields = multiValuedMap;
        this.profile = StringUtils.defaultString(str);
    }

    private void beforeFirstWrite(T t) throws CsvRequiredFieldEmptyException {
        if (this.mappingStrategy == null) {
            this.mappingStrategy = OpencsvUtils.determineMappingStrategy(t.getClass(), this.errorLocale, this.profile);
        }
        if (!this.ignoredFields.isEmpty()) {
            this.mappingStrategy.ignoreFields(this.ignoredFields);
        }
        if (this.csvwriter == null) {
            this.csvwriter = new CSVWriter(this.writer, this.separator, this.quotechar, this.escapechar, this.lineEnd);
        }
        String[] generateHeader = this.mappingStrategy.generateHeader(t);
        if (generateHeader.length > 0) {
            this.csvwriter.writeNext(generateHeader, this.applyQuotesToAll);
        }
        this.headerWritten = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void write(T t) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        if (t != null) {
            if (!this.headerWritten) {
                beforeFirstWrite(t);
            }
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            int i = this.lineNumber + 1;
            this.lineNumber = i;
            try {
                new ProcessCsvBean(i, this.mappingStrategy, t, arrayBlockingQueue, linkedBlockingQueue, new TreeSet(), this.exceptionHandler).run();
                if (!linkedBlockingQueue.isEmpty()) {
                    for (OrderedObject orderedObject = (OrderedObject) linkedBlockingQueue.poll(); orderedObject != null && orderedObject.getElement() != null; orderedObject = (OrderedObject) linkedBlockingQueue.poll()) {
                        this.capturedExceptions.add(orderedObject.getElement());
                    }
                    return;
                }
                OrderedObject orderedObject2 = (OrderedObject) arrayBlockingQueue.poll();
                if (orderedObject2 == null || orderedObject2.getElement() == null) {
                    return;
                }
                this.csvwriter.writeNext((String[]) orderedObject2.getElement(), this.applyQuotesToAll);
            } catch (RuntimeException e) {
                if (e.getCause() != null) {
                    if (e.getCause() instanceof CsvRuntimeException) {
                        throw ((CsvRuntimeException) e.getCause());
                    }
                    if (e.getCause() instanceof CsvDataTypeMismatchException) {
                        throw ((CsvDataTypeMismatchException) e.getCause());
                    }
                    if (e.getCause() instanceof CsvRequiredFieldEmptyException) {
                        throw ((CsvRequiredFieldEmptyException) e.getCause());
                    }
                }
                throw e;
            }
        }
    }

    private void submitAllLines(Iterator<T> it) throws InterruptedException {
        while (it.hasNext()) {
            T next = it.next();
            if (next != null) {
                BeanExecutor<T> beanExecutor = this.executor;
                int i = this.lineNumber + 1;
                this.lineNumber = i;
                beanExecutor.submitBean(i, this.mappingStrategy, next, this.exceptionHandler);
            }
        }
        this.executor.complete();
    }

    public void write(List<T> list) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        if (CollectionUtils.isNotEmpty(list)) {
            write((Iterator) list.iterator());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void write(Iterator<T> it) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        PeekingIterator peekingIterator = new PeekingIterator(it);
        Object peek = peekingIterator.peek();
        if (peekingIterator.hasNext()) {
            if (!this.headerWritten) {
                beforeFirstWrite(peek);
            }
            BeanExecutor<T> beanExecutor = new BeanExecutor<>(this.orderedResults, this.errorLocale);
            this.executor = beanExecutor;
            beanExecutor.prepare();
            try {
                try {
                    submitAllLines(peekingIterator);
                    this.capturedExceptions.addAll(this.executor.getCapturedExceptions());
                    StreamSupport.stream(this.executor, false).forEach(new Consumer() { // from class: com.opencsv.bean.-$$Lambda$StatefulBeanToCsv$-qsn7DFRPQ2Sy6nCIlDjnA2wne4
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            StatefulBeanToCsv.this.lambda$write$0$StatefulBeanToCsv((String[]) obj);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    if (this.executor.getTerminalException() instanceof RuntimeException) {
                        throw ((RuntimeException) this.executor.getTerminalException());
                    }
                    if (this.executor.getTerminalException() instanceof CsvDataTypeMismatchException) {
                        throw ((CsvDataTypeMismatchException) this.executor.getTerminalException());
                    }
                    if (this.executor.getTerminalException() instanceof CsvRequiredFieldEmptyException) {
                        throw ((CsvRequiredFieldEmptyException) this.executor.getTerminalException());
                    }
                    throw new RuntimeException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("error.writing.beans"), this.executor.getTerminalException());
                } catch (Exception e) {
                    this.executor.shutdownNow();
                    if (this.executor.getTerminalException() instanceof RuntimeException) {
                        throw ((RuntimeException) this.executor.getTerminalException());
                    }
                    throw new RuntimeException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("error.writing.beans"), e);
                }
            } catch (Throwable th) {
                this.capturedExceptions.addAll(this.executor.getCapturedExceptions());
                throw th;
            }
        }
    }

    public /* synthetic */ void lambda$write$0$StatefulBeanToCsv(String[] strArr) {
        this.csvwriter.writeNext(strArr, this.applyQuotesToAll);
    }

    public void write(Stream<T> stream) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        write((Iterator) stream.iterator());
    }

    public void setOrderedResults(boolean z) {
        this.orderedResults = z;
    }

    @Deprecated
    public boolean isThrowExceptions() {
        return this.exceptionHandler instanceof ExceptionHandlerThrow;
    }

    public List<CsvException> getCapturedExceptions() {
        List<CsvException> list = this.capturedExceptions;
        this.capturedExceptions = new ArrayList();
        list.sort(Comparator.comparingLong(new ToLongFunction() { // from class: com.opencsv.bean.-$$Lambda$1v59Zr66OpSeN3KsTGPiSQxrJSA
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((CsvException) obj).getLineNumber();
            }
        }));
        return list;
    }

    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }
}