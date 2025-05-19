package com.opencsv.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apache.commons.collections4.MultiValuedMap;

@Target({ElementType.FIELD})
@Documented
@Repeatable(CsvBindAndJoinByNames.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface CsvBindAndJoinByName {
    String capture() default "";

    String column() default "";

    Class<? extends AbstractCsvConverter> converter() default AbstractCsvConverter.class;

    Class<?> elementType();

    String format() default "";

    String locale() default "";

    Class<? extends MultiValuedMap> mapType() default MultiValuedMap.class;

    String[] profiles() default {""};

    boolean required() default false;

    String writeLocale() default "";

    boolean writeLocaleEqualsReadLocale() default true;
}
