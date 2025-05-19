package javax.xml.transform;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class TransformerException extends Exception {
    Throwable containedException;
    SourceLocator locator;

    public TransformerException(String str) {
        super(str);
        this.containedException = null;
        this.locator = null;
    }

    public TransformerException(String str, Throwable th) {
        super((str == null || str.length() == 0) ? th.toString() : str);
        this.containedException = th;
        this.locator = null;
    }

    public TransformerException(String str, SourceLocator sourceLocator) {
        super(str);
        this.containedException = null;
        this.locator = sourceLocator;
    }

    public TransformerException(String str, SourceLocator sourceLocator, Throwable th) {
        super(str);
        this.containedException = th;
        this.locator = sourceLocator;
    }

    public TransformerException(Throwable th) {
        super(th.toString());
        this.containedException = th;
        this.locator = null;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        Throwable th = this.containedException;
        if (th == this) {
            return null;
        }
        return th;
    }

    public Throwable getException() {
        return this.containedException;
    }

    public String getLocationAsString() {
        if (this.locator == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String systemId = this.locator.getSystemId();
        int lineNumber = this.locator.getLineNumber();
        int columnNumber = this.locator.getColumnNumber();
        if (systemId != null) {
            stringBuffer.append("; SystemID: ");
            stringBuffer.append(systemId);
        }
        if (lineNumber != 0) {
            stringBuffer.append("; Line#: ");
            stringBuffer.append(lineNumber);
        }
        if (columnNumber != 0) {
            stringBuffer.append("; Column#: ");
            stringBuffer.append(columnNumber);
        }
        return stringBuffer.toString();
    }

    public SourceLocator getLocator() {
        return this.locator;
    }

    public String getMessageAndLocation() {
        StringBuffer stringBuffer = new StringBuffer();
        String message = super.getMessage();
        if (message != null) {
            stringBuffer.append(message);
        }
        SourceLocator sourceLocator = this.locator;
        if (sourceLocator != null) {
            String systemId = sourceLocator.getSystemId();
            int lineNumber = this.locator.getLineNumber();
            int columnNumber = this.locator.getColumnNumber();
            if (systemId != null) {
                stringBuffer.append("; SystemID: ");
                stringBuffer.append(systemId);
            }
            if (lineNumber != 0) {
                stringBuffer.append("; Line#: ");
                stringBuffer.append(lineNumber);
            }
            if (columnNumber != 0) {
                stringBuffer.append("; Column#: ");
                stringBuffer.append(columnNumber);
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public synchronized Throwable initCause(Throwable th) {
        if (this.containedException != null) {
            throw new IllegalStateException("Can't overwrite cause");
        }
        if (th == this) {
            throw new IllegalArgumentException("Self-causation not permitted");
        }
        this.containedException = th;
        return this;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(new PrintWriter((OutputStream) System.err, true));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new PrintWriter(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        String locationAsString;
        if (printWriter == null) {
            printWriter = new PrintWriter((OutputStream) System.err, true);
        }
        try {
            String locationAsString2 = getLocationAsString();
            if (locationAsString2 != null) {
                printWriter.println(locationAsString2);
            }
            super.printStackTrace(printWriter);
        } catch (Throwable unused) {
        }
        Throwable exception = getException();
        for (int i = 0; i < 10 && exception != null; i++) {
            printWriter.println("---------");
            try {
                if ((exception instanceof TransformerException) && (locationAsString = ((TransformerException) exception).getLocationAsString()) != null) {
                    printWriter.println(locationAsString);
                }
                exception.printStackTrace(printWriter);
            } catch (Throwable unused2) {
                printWriter.println("Could not print stack trace...");
            }
            Throwable th = null;
            try {
                Method method = exception.getClass().getMethod("getException", null);
                if (method == null) {
                    continue;
                } else {
                    Throwable th2 = (Throwable) method.invoke(exception, null);
                    if (exception == th2) {
                        break;
                    } else {
                        th = th2;
                    }
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused3) {
            }
            exception = th;
        }
        printWriter.flush();
    }

    public void setLocator(SourceLocator sourceLocator) {
        this.locator = sourceLocator;
    }
}
