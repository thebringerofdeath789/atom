package org.apache.commons.beanutils;

import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class ContextClassLoaderLocal<T> {
    private T globalValue;
    private final Map<ClassLoader, T> valueByClassLoader = new WeakHashMap();
    private boolean globalValueInitialized = false;

    protected T initialValue() {
        return null;
    }

    public synchronized T get() {
        this.valueByClassLoader.isEmpty();
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                T t = this.valueByClassLoader.get(contextClassLoader);
                if (t == null && !this.valueByClassLoader.containsKey(contextClassLoader)) {
                    t = initialValue();
                    this.valueByClassLoader.put(contextClassLoader, t);
                }
                return t;
            }
        } catch (SecurityException unused) {
        }
        if (!this.globalValueInitialized) {
            this.globalValue = initialValue();
            this.globalValueInitialized = true;
        }
        return this.globalValue;
    }

    public synchronized void set(T t) {
        this.valueByClassLoader.isEmpty();
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                this.valueByClassLoader.put(contextClassLoader, t);
                return;
            }
        } catch (SecurityException unused) {
        }
        this.globalValue = t;
        this.globalValueInitialized = true;
    }

    public synchronized void unset() {
        try {
            unset(Thread.currentThread().getContextClassLoader());
        } catch (SecurityException unused) {
        }
    }

    public synchronized void unset(ClassLoader classLoader) {
        this.valueByClassLoader.remove(classLoader);
    }
}
