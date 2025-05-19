package com.opencsv.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Repeatable(CsvBindByNames.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface CsvBindByName {
    String capture() default "";

    String column() default "";

    String format() default "";

    String locale() default "";

    String[] profiles() default {""};

    boolean required() default false;

    String writeLocale() default "";

    boolean writeLocaleEqualsReadLocale() default true;
}
