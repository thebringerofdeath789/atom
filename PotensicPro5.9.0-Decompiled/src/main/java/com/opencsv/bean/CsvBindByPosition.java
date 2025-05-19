package com.opencsv.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Repeatable(CsvBindByPositions.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface CsvBindByPosition {
    String capture() default "";

    String format() default "";

    String locale() default "";

    int position();

    String[] profiles() default {""};

    boolean required() default false;

    String writeLocale() default "";

    boolean writeLocaleEqualsReadLocale() default true;
}
