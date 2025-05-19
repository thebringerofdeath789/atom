package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.xmlbeans.SystemProperties;

/* loaded from: classes5.dex */
public class XBeanDebug {
    public static final int TRACE_SCHEMA_LOADING = 1;
    static PrintStream _err = null;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$XBeanDebug = null;
    public static final String defaultProp = "";
    public static final String traceProp = "org.apache.xmlbeans.impl.debug";
    private static int _enabled = initializeBitsFromProperty();
    private static int _indent = 0;
    private static String _indentspace = "                                                                                ";

    private static int initializeBitsFromProperty() {
        return SystemProperties.getProperty(traceProp, "").indexOf("TRACE_SCHEMA_LOADING") >= 0 ? 1 : 0;
    }

    public static void enable(int i) {
        _enabled = i | _enabled;
    }

    public static void disable(int i) {
        _enabled = (~i) & _enabled;
    }

    public static void trace(int i, String str, int i2) {
        if (test(i)) {
            Class cls = class$org$apache$xmlbeans$impl$common$XBeanDebug;
            if (cls == null) {
                cls = class$("org.apache.xmlbeans.impl.common.XBeanDebug");
                class$org$apache$xmlbeans$impl$common$XBeanDebug = cls;
            }
            synchronized (cls) {
                if (i2 < 0) {
                    _indent += i2;
                }
                int i3 = _indent;
                System.err.print(new StringBuffer().append(Thread.currentThread().getName()).append(": ").append(i3 < 0 ? "" : i3 > _indentspace.length() ? _indentspace : _indentspace.substring(0, _indent)).append(str).append("\n").toString());
                if (i2 > 0) {
                    _indent += i2;
                }
            }
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static boolean test(int i) {
        return (i & _enabled) != 0;
    }

    public static String log(String str) {
        log(str, null);
        return str;
    }

    public static String logStackTrace(String str) {
        log(str, new Throwable());
        return str;
    }

    private static synchronized String log(String str, Throwable th) {
        synchronized (XBeanDebug.class) {
            if (_err == null) {
                try {
                    File createTempFile = File.createTempFile("xmlbeandebug", ".log");
                    _err = new PrintStream(new FileOutputStream(createTempFile));
                    System.err.println(new StringBuffer().append("Diagnostic XML Bean debug log file created: ").append(createTempFile).toString());
                } catch (IOException unused) {
                    _err = System.err;
                }
            }
            _err.println(str);
            if (th != null) {
                th.printStackTrace(_err);
            }
        }
        return str;
    }

    public static Throwable logException(Throwable th) {
        log(th.getMessage(), th);
        return th;
    }
}
