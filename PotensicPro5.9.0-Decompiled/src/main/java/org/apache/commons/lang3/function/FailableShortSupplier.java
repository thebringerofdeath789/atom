package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableShortSupplier<E extends Throwable> {
    short getAsShort() throws Throwable;
}
