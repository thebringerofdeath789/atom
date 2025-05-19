package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableDoubleBinaryOperator<E extends Throwable> {
    double applyAsDouble(double d, double d2) throws Throwable;
}
