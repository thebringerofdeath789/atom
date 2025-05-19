package org.apache.commons.lang3.builder;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface Diffable<T> {
    DiffResult<T> diff(T t);
}
