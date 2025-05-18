package com.mapbox.mapboxsdk.log;

import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class Logger {
    public static final int DEBUG = 3;
    private static final LoggerDefinition DEFAULT;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int NONE = 99;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static int logLevel;
    private static volatile LoggerDefinition logger;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    static {
        LoggerDefinition loggerDefinition = new LoggerDefinition() { // from class: com.mapbox.mapboxsdk.log.Logger.1
            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: v */
            public void mo1770v(String str, String str2) {
                Log.v(str, str2);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: v */
            public void mo1771v(String str, String str2, Throwable th) {
                Log.v(str, str2, th);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: d */
            public void mo1764d(String str, String str2) {
                Log.d(str, str2);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: d */
            public void mo1765d(String str, String str2, Throwable th) {
                Log.d(str, str2, th);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: i */
            public void mo1768i(String str, String str2) {
                Log.i(str, str2);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: i */
            public void mo1769i(String str, String str2, Throwable th) {
                Log.i(str, str2, th);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: w */
            public void mo1772w(String str, String str2) {
                Log.w(str, str2);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: w */
            public void mo1773w(String str, String str2, Throwable th) {
                Log.w(str, str2, th);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: e */
            public void mo1766e(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // com.mapbox.mapboxsdk.log.LoggerDefinition
            /* renamed from: e */
            public void mo1767e(String str, String str2, Throwable th) {
                Log.e(str, str2, th);
            }
        };
        DEFAULT = loggerDefinition;
        logger = loggerDefinition;
    }

    public static void setVerbosity(int i) {
        logLevel = i;
    }

    public static void setLoggerDefinition(LoggerDefinition loggerDefinition) {
        logger = loggerDefinition;
    }

    /* renamed from: v */
    public static void m1760v(String str, String str2) {
        if (logLevel <= 2) {
            logger.mo1770v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m1761v(String str, String str2, Throwable th) {
        if (logLevel <= 2) {
            logger.mo1771v(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m1754d(String str, String str2) {
        if (logLevel <= 3) {
            logger.mo1764d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m1755d(String str, String str2, Throwable th) {
        if (logLevel <= 3) {
            logger.mo1765d(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m1758i(String str, String str2) {
        if (logLevel <= 4) {
            logger.mo1768i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m1759i(String str, String str2, Throwable th) {
        if (logLevel <= 4) {
            logger.mo1769i(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m1762w(String str, String str2) {
        if (logLevel <= 5) {
            logger.mo1772w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m1763w(String str, String str2, Throwable th) {
        if (logLevel <= 5) {
            logger.mo1773w(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m1756e(String str, String str2) {
        if (logLevel <= 6) {
            logger.mo1766e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m1757e(String str, String str2, Throwable th) {
        if (logLevel <= 6) {
            logger.mo1767e(str, str2, th);
        }
    }

    public static void log(int i, String str, String str2) {
        if (i == 2) {
            m1760v(str, str2);
            return;
        }
        if (i == 3) {
            m1754d(str, str2);
            return;
        }
        if (i == 4) {
            m1758i(str, str2);
        } else if (i == 5) {
            m1762w(str, str2);
        } else {
            if (i == 6) {
                m1756e(str, str2);
                return;
            }
            throw new UnsupportedOperationException();
        }
    }
}