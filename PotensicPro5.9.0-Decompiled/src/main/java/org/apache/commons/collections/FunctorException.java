package org.apache.commons.collections;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes4.dex */
public class FunctorException extends RuntimeException {
    private static final boolean JDK_SUPPORTS_NESTED;
    static /* synthetic */ Class class$java$lang$Throwable;
    private final Throwable rootCause;

    static {
        boolean z = false;
        try {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            cls.getDeclaredMethod("getCause", new Class[0]);
            z = true;
        } catch (NoSuchMethodException unused) {
        }
        JDK_SUPPORTS_NESTED = z;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public FunctorException() {
        this.rootCause = null;
    }

    public FunctorException(String str) {
        super(str);
        this.rootCause = null;
    }

    public FunctorException(Throwable th) {
        super(th == null ? null : th.getMessage());
        this.rootCause = th;
    }

    public FunctorException(String str, Throwable th) {
        super(str);
        this.rootCause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.rootCause;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            super.printStackTrace(printWriter);
            if (this.rootCause != null && !JDK_SUPPORTS_NESTED) {
                printWriter.print("Caused by: ");
                this.rootCause.printStackTrace(printWriter);
            }
        }
    }
}
