package org.xml.sax.helpers;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes6.dex */
class NewInstance {
    static /* synthetic */ Class class$java$lang$Thread;
    static /* synthetic */ Class class$org$xml$sax$helpers$NewInstance;

    NewInstance() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static ClassLoader getClassLoader() {
        try {
            Class cls = class$java$lang$Thread;
            if (cls == null) {
                cls = class$("java.lang.Thread");
                class$java$lang$Thread = cls;
            }
            try {
                return (ClassLoader) cls.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
            } catch (IllegalAccessException e) {
                throw new UnknownError(e.getMessage());
            } catch (InvocationTargetException e2) {
                throw new UnknownError(e2.getMessage());
            }
        } catch (NoSuchMethodException unused) {
            Class cls2 = class$org$xml$sax$helpers$NewInstance;
            if (cls2 == null) {
                cls2 = class$("org.xml.sax.helpers.NewInstance");
                class$org$xml$sax$helpers$NewInstance = cls2;
            }
            return cls2.getClassLoader();
        }
    }

    static Object newInstance(ClassLoader classLoader, String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
    }
}
