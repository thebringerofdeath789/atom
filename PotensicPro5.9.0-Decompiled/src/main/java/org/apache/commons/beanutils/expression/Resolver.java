package org.apache.commons.beanutils.expression;

/* loaded from: classes4.dex */
public interface Resolver {
    int getIndex(String str);

    String getKey(String str);

    String getProperty(String str);

    boolean hasNested(String str);

    boolean isIndexed(String str);

    boolean isMapped(String str);

    String next(String str);

    String remove(String str);
}
