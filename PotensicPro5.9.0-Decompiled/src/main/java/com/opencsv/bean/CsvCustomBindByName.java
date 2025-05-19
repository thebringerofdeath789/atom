package com.opencsv.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Repeatable(CsvCustomBindByNames.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface CsvCustomBindByName {
    String column() default "";

    Class<? extends AbstractBeanField> converter();

    String[] profiles() default {""};

    boolean required() default false;
}
