package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public interface MutableDynaClass extends DynaClass {
    void add(String str);

    void add(String str, Class<?> cls);

    void add(String str, Class<?> cls, boolean z, boolean z2);

    boolean isRestricted();

    void remove(String str);

    void setRestricted(boolean z);
}
