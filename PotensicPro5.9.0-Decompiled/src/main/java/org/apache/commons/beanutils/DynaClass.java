package org.apache.commons.beanutils;

/* loaded from: classes4.dex */
public interface DynaClass {
    DynaProperty[] getDynaProperties();

    DynaProperty getDynaProperty(String str);

    String getName();

    DynaBean newInstance() throws IllegalAccessException, InstantiationException;
}
