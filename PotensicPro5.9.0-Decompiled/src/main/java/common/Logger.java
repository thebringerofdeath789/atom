package common;

import common.log.LoggerName;
import common.log.SimpleLogger;
import java.security.AccessControlException;

/* loaded from: classes3.dex */
public abstract class Logger {
    private static Logger logger;

    public abstract void debug(Object obj);

    public abstract void debug(Object obj, Throwable th);

    public abstract void error(Object obj);

    public abstract void error(Object obj, Throwable th);

    public abstract void fatal(Object obj);

    public abstract void fatal(Object obj, Throwable th);

    protected abstract Logger getLoggerImpl(Class cls);

    public abstract void info(Object obj);

    public abstract void info(Object obj, Throwable th);

    public void setSuppressWarnings(boolean z) {
    }

    public abstract void warn(Object obj);

    public abstract void warn(Object obj, Throwable th);

    public static final Logger getLogger(Class cls) {
        if (logger == null) {
            initializeLogger();
        }
        return logger.getLoggerImpl(cls);
    }

    private static synchronized void initializeLogger() {
        synchronized (Logger.class) {
            if (logger != null) {
                return;
            }
            String str = LoggerName.NAME;
            try {
                try {
                    try {
                        try {
                            str = System.getProperty("logger");
                            if (str == null) {
                                str = LoggerName.NAME;
                            }
                            logger = (Logger) Class.forName(str).newInstance();
                        } catch (InstantiationException unused) {
                            SimpleLogger simpleLogger = new SimpleLogger();
                            logger = simpleLogger;
                            simpleLogger.warn(new StringBuffer().append("Could not instantiate logger ").append(str).append(" using default").toString());
                        }
                    } catch (ClassNotFoundException unused2) {
                        SimpleLogger simpleLogger2 = new SimpleLogger();
                        logger = simpleLogger2;
                        simpleLogger2.warn(new StringBuffer().append("Could not instantiate logger ").append(str).append(" using default").toString());
                    }
                } catch (AccessControlException unused3) {
                    SimpleLogger simpleLogger3 = new SimpleLogger();
                    logger = simpleLogger3;
                    simpleLogger3.warn(new StringBuffer().append("Could not instantiate logger ").append(str).append(" using default").toString());
                }
            } catch (IllegalAccessException unused4) {
                SimpleLogger simpleLogger4 = new SimpleLogger();
                logger = simpleLogger4;
                simpleLogger4.warn(new StringBuffer().append("Could not instantiate logger ").append(str).append(" using default").toString());
            }
        }
    }

    protected Logger() {
    }
}
