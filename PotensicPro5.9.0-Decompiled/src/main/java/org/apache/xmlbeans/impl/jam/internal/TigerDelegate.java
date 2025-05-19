package org.apache.xmlbeans.impl.jam.internal;

import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* loaded from: classes5.dex */
public abstract class TigerDelegate {
    private static final String SOME_TIGER_SPECIFIC_JAVADOC_CLASS = "com.sun.javadoc.AnnotationDesc";
    private static final String SOME_TIGER_SPECIFIC_REFLECT_CLASS = "java.lang.annotation.Annotation";
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$jam$internal$TigerDelegate = null;
    private static boolean m14BuildWarningDone = false;
    private static boolean m14RuntimeWarningDone = false;
    protected JamLogger mLogger = null;
    protected ElementContext mContext = null;

    public void init(ElementContext elementContext) {
        this.mContext = elementContext;
        init(elementContext.getLogger());
    }

    public void init(JamLogger jamLogger) {
        this.mLogger = jamLogger;
    }

    protected TigerDelegate() {
    }

    protected JamLogger getLogger() {
        return this.mLogger;
    }

    protected static void issue14BuildWarning(Throwable th, JamLogger jamLogger) {
        if (m14BuildWarningDone) {
            return;
        }
        jamLogger.warning("This build of JAM was not made with JDK 1.5.Even though you are now running under JDK 1.5, JSR175-style annotations will not be available");
        Class cls = class$org$apache$xmlbeans$impl$jam$internal$TigerDelegate;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.jam.internal.TigerDelegate");
            class$org$apache$xmlbeans$impl$jam$internal$TigerDelegate = cls;
        }
        if (jamLogger.isVerbose(cls)) {
            jamLogger.verbose(th);
        }
        m14BuildWarningDone = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected static void issue14RuntimeWarning(Throwable th, JamLogger jamLogger) {
        if (m14RuntimeWarningDone) {
            return;
        }
        jamLogger.warning("You are running under a pre-1.5 JDK.  JSR175-style source annotations will not be available");
        Class cls = class$org$apache$xmlbeans$impl$jam$internal$TigerDelegate;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.jam.internal.TigerDelegate");
            class$org$apache$xmlbeans$impl$jam$internal$TigerDelegate = cls;
        }
        if (jamLogger.isVerbose(cls)) {
            jamLogger.verbose(th);
        }
        m14RuntimeWarningDone = true;
    }

    protected static boolean isTigerJavadocAvailable(JamLogger jamLogger) {
        try {
            Class.forName(SOME_TIGER_SPECIFIC_JAVADOC_CLASS);
            return true;
        } catch (ClassNotFoundException e) {
            issue14RuntimeWarning(e, jamLogger);
            return false;
        }
    }

    protected static boolean isTigerReflectionAvailable(JamLogger jamLogger) {
        try {
            Class.forName(SOME_TIGER_SPECIFIC_REFLECT_CLASS);
            return true;
        } catch (ClassNotFoundException e) {
            issue14RuntimeWarning(e, jamLogger);
            return false;
        }
    }
}
