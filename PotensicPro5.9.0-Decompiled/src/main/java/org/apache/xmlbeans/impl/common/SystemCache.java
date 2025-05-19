package org.apache.xmlbeans.impl.common;

import java.lang.ref.SoftReference;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;

/* loaded from: classes5.dex */
public class SystemCache {
    private static SystemCache INSTANCE;
    private ThreadLocal tl_saxLoaders = new ThreadLocal();

    public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
    }

    public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
        return null;
    }

    static {
        Object newInstance;
        INSTANCE = new SystemCache();
        String property = SystemProperties.getProperty("xmlbean.systemcacheimpl");
        if (property != null) {
            try {
                newInstance = Class.forName(property).newInstance();
                if (!(newInstance instanceof SystemCache)) {
                    throw new ClassCastException(new StringBuffer().append("Value for system property \"xmlbean.systemcacheimpl\" points to a class (").append(property).append(") which does not derive from SystemCache").toString());
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(new StringBuffer().append("Cache class ").append(property).append(" specified by \"xmlbean.systemcacheimpl\" was not found.").toString(), e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(new StringBuffer().append("Could not instantiate class ").append(property).append(" as specified by \"xmlbean.systemcacheimpl\".").append(" A public empty constructor may be missing.").toString(), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(new StringBuffer().append("Could not instantiate class ").append(property).append(" as specified by \"xmlbean.systemcacheimpl\".").append(" An empty constructor may be missing.").toString(), e3);
            }
        } else {
            newInstance = null;
        }
        if (newInstance != null) {
            INSTANCE = (SystemCache) newInstance;
        }
    }

    public static final synchronized void set(SystemCache systemCache) {
        synchronized (SystemCache.class) {
            INSTANCE = systemCache;
        }
    }

    public static final SystemCache get() {
        return INSTANCE;
    }

    public Object getSaxLoader() {
        SoftReference softReference = (SoftReference) this.tl_saxLoaders.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void setSaxLoader(Object obj) {
        this.tl_saxLoaders.set(new SoftReference(obj));
    }
}
