package org.apache.xmlbeans.impl.jam.internal.javadoc;

import com.sun.javadoc.RootDoc;

/* loaded from: classes5.dex */
public class JavadocResults {
    private static final JavadocResults INSTANCE = new JavadocResults();
    static /* synthetic */ Class class$com$sun$javadoc$RootDoc;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$jam$internal$javadoc$JavadocResults;
    private ThreadLocal mRootsPerThread = new ThreadLocal();

    public static void prepare() {
        Thread currentThread = Thread.currentThread();
        Class cls = class$org$apache$xmlbeans$impl$jam$internal$javadoc$JavadocResults;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocResults");
            class$org$apache$xmlbeans$impl$jam$internal$javadoc$JavadocResults = cls;
        }
        currentThread.setContextClassLoader(cls.getClassLoader());
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void setRoot(RootDoc rootDoc) {
        try {
            Object holder = getHolder();
            Class<?> cls = holder.getClass();
            Class<?>[] clsArr = new Class[1];
            Class<?> cls2 = class$com$sun$javadoc$RootDoc;
            if (cls2 == null) {
                cls2 = class$("com.sun.javadoc.RootDoc");
                class$com$sun$javadoc$RootDoc = cls2;
            }
            clsArr[0] = cls2;
            cls.getMethod("_setRoot", clsArr).invoke(holder, rootDoc);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public static RootDoc getRoot() {
        try {
            Object holder = getHolder();
            return (RootDoc) holder.getClass().getMethod("_getRoot", new Class[0]).invoke(holder, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public void _setRoot(RootDoc rootDoc) {
        this.mRootsPerThread.set(rootDoc);
    }

    public RootDoc _getRoot() {
        return (RootDoc) this.mRootsPerThread.get();
    }

    public static JavadocResults getInstance() {
        return INSTANCE;
    }

    private static Object getHolder() throws Exception {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class cls = class$org$apache$xmlbeans$impl$jam$internal$javadoc$JavadocResults;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocResults");
            class$org$apache$xmlbeans$impl$jam$internal$javadoc$JavadocResults = cls;
        }
        return contextClassLoader.loadClass(cls.getName()).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    }
}
