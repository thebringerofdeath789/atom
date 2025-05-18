package com.opencsv.bean.function;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
/* loaded from: classes3.dex */
public interface AssignmentInvoker<T, U> {
    void invoke(T t, U u) throws IllegalAccessException, InvocationTargetException;
}