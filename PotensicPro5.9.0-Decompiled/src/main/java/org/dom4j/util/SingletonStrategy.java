package org.dom4j.util;

/* loaded from: classes5.dex */
public interface SingletonStrategy {
    Object instance();

    void reset();

    void setSingletonClassName(String str);
}
