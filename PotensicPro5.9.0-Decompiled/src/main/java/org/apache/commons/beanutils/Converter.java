package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public interface Converter {
    <T> T convert(Class<T> cls, Object obj);
}
