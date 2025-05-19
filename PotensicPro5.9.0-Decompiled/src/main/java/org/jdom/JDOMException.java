package org.jdom;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class JDOMException extends Exception {
    private static final String CVS_ID = "@(#) $RCSfile: JDOMException.java,v $ $Revision: 1.23 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";
    private Throwable cause;

    public JDOMException() {
        super("Error occurred in JDOM application.");
    }

    public JDOMException(String str) {
        super(str);
    }

    public JDOMException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable th) {
        this.cause = th;
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Exception exception;
        String message = super.getMessage();
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th == null) {
                break;
            }
            String message2 = th.getMessage();
            if ((th instanceof SAXException) && (exception = ((SAXException) th).getException()) != null && message2 != null && message2.equals(exception.getMessage())) {
                message2 = null;
            }
            if (message2 != null) {
                message = message != null ? new StringBuffer(String.valueOf(message)).append(": ").append(message2).toString() : message2;
            }
        } while (!(th instanceof JDOMException));
        return message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        super.printStackTrace();
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th == null) {
                return;
            }
            System.err.print("Caused by: ");
            th.printStackTrace();
        } while (!(th instanceof JDOMException));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th == null) {
                return;
            }
            printStream.print("Caused by: ");
            th.printStackTrace(printStream);
        } while (!(th instanceof JDOMException));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th = this;
        do {
            th = getNestedException(th);
            if (th == null) {
                return;
            }
            printWriter.print("Caused by: ");
            th.printStackTrace(printWriter);
        } while (!(th instanceof JDOMException));
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    private static Throwable getNestedException(Throwable th) {
        if (th instanceof JDOMException) {
            return ((JDOMException) th).getCause();
        }
        if (th instanceof SAXException) {
            return ((SAXException) th).getException();
        }
        if (th instanceof SQLException) {
            return ((SQLException) th).getNextException();
        }
        if (th instanceof InvocationTargetException) {
            return ((InvocationTargetException) th).getTargetException();
        }
        if (th instanceof ExceptionInInitializerError) {
            return ((ExceptionInInitializerError) th).getException();
        }
        if (th instanceof RemoteException) {
            return ((RemoteException) th).detail;
        }
        Throwable nestedException = getNestedException(th, "javax.naming.NamingException", "getRootCause");
        if (nestedException != null) {
            return nestedException;
        }
        Throwable nestedException2 = getNestedException(th, "javax.servlet.ServletException", "getRootCause");
        if (nestedException2 != null) {
            return nestedException2;
        }
        return null;
    }

    private static Throwable getNestedException(Throwable th, String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls.isAssignableFrom(th.getClass())) {
                return (Throwable) cls.getMethod(str2, new Class[0]).invoke(th, new Object[0]);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
