package com.opencsv.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Repeatable(CsvDates.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface CsvDate {
    String chronology() default "ISO";

    String[] profiles() default {""};

    String value() default "yyyyMMdd'T'HHmmss";

    String writeChronology() default "ISO";

    boolean writeChronologyEqualsReadChronology() default true;

    String writeFormat() default "yyyyMMdd'T'HHmmss";

    boolean writeFormatEqualsReadFormat() default true;
}