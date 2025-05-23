package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableDoubleSupplier<E extends Throwable> {
    double getAsDouble() throws Throwable;
}
