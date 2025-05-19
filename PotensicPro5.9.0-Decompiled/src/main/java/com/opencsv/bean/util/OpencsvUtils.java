package com.opencsv.bean.util;

import com.opencsv.ICSVParser;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

/* loaded from: classes3.dex */
public final class OpencsvUtils {
    private OpencsvUtils() {
    }

    public static <T> MappingStrategy<T> determineMappingStrategy(Class<? extends T> cls, Locale locale, String str) {
        MappingStrategy<T> columnPositionMappingStrategy = Stream.of((Object[]) FieldUtils.getAllFields(cls)).anyMatch(new Predicate() { // from class: com.opencsv.bean.util.-$$Lambda$OpencsvUtils$NEiXddCSoEx9RMn3YXvRSxPkkUM
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return OpencsvUtils.lambda$determineMappingStrategy$0((Field) obj);
            }
        }) ? new ColumnPositionMappingStrategy<>() : new HeaderColumnNameMappingStrategy<>();
        columnPositionMappingStrategy.setErrorLocale(locale);
        columnPositionMappingStrategy.setProfile(str);
        columnPositionMappingStrategy.setType(cls);
        return columnPositionMappingStrategy;
    }

    static /* synthetic */ boolean lambda$determineMappingStrategy$0(Field field) {
        return field.isAnnotationPresent(CsvBindByPosition.class) || field.isAnnotationPresent(CsvBindAndSplitByPosition.class) || field.isAnnotationPresent(CsvBindAndJoinByPosition.class) || field.isAnnotationPresent(CsvCustomBindByPosition.class);
    }

    public static <E> void queueRefuseToAcceptDefeat(BlockingQueue<E> blockingQueue, E e) {
        boolean z = true;
        while (z) {
            try {
                blockingQueue.put(e);
                z = false;
            } catch (InterruptedException unused) {
            }
        }
    }

    public static synchronized void handleException(CsvException csvException, long j, CsvExceptionHandler csvExceptionHandler, BlockingQueue<OrderedObject<CsvException>> blockingQueue) {
        List singletonList;
        synchronized (OpencsvUtils.class) {
            csvException.setLineNumber(j);
            CsvException e = null;
            if (csvException instanceof CsvChainedException) {
                singletonList = Collections.unmodifiableList(((CsvChainedException) csvException).getExceptionChain());
            } else {
                singletonList = Collections.singletonList(csvException);
            }
            Iterator it = singletonList.iterator();
            while (it.hasNext()) {
                try {
                    try {
                        e = csvExceptionHandler.handleException((CsvException) it.next());
                        if (e != null) {
                            queueRefuseToAcceptDefeat(blockingQueue, new OrderedObject(j, e));
                        }
                    } catch (CsvException e2) {
                        e = e2;
                        throw new RuntimeException(e);
                    }
                } finally {
                }
            }
        }
    }

    public static Pattern compilePatternAtLeastOneGroup(String str, int i, Class<?> cls, Locale locale) throws CsvBadConverterException {
        Pattern compilePattern = compilePattern(str, i, cls, locale);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        if (compilePattern == null || compilePattern.matcher("").groupCount() >= 1) {
            return compilePattern;
        }
        throw new CsvBadConverterException(cls, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("regex.without.capture.group"), str));
    }

    public static Pattern compilePattern(String str, int i, Class<?> cls, Locale locale) throws CsvBadConverterException {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        if (!StringUtils.isNotEmpty(str)) {
            return null;
        }
        try {
            return Pattern.compile(str, i);
        } catch (PatternSyntaxException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(cls, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("invalid.regex"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    public static void verifyFormatString(String str, Class<?> cls, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        try {
            if (StringUtils.isNotEmpty(str)) {
                String.format(str, StringUtils.SPACE);
            }
        } catch (IllegalFormatException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(cls, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("invalid.one.parameter.format.string"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }
}
