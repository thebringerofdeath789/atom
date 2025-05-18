package com.opencsv.bean.function;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
/* loaded from: classes3.dex */
public interface AccessorInvoker<T, R> {
    R invoke(T t) throws IllegalAccessException, InvocationTargetException;
}