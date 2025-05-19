package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableIntBinaryOperator<E extends Throwable> {
    int applyAsInt(int i, int i2) throws Throwable;
}
