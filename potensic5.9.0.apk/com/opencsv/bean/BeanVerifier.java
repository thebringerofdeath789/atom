package com.opencsv.bean;

import com.opencsv.exceptions.CsvConstraintViolationException;

/* loaded from: classes3.dex */
public interface BeanVerifier<T> {
    boolean verifyBean(T t) throws CsvConstraintViolationException;
}