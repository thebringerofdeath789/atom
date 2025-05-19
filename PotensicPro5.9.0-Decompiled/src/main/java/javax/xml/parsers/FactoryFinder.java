package javax.xml.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/* loaded from: classes4.dex */
class FactoryFinder {
    static /* synthetic */ Class class$java$lang$Thread = null;
    static /* synthetic */ Class class$javax$xml$parsers$FactoryFinder = null;
    private static final boolean debug = false;

    static class ConfigurationError extends Error {
        private Exception exception;

        ConfigurationError(String str, Exception exc) {
            super(str);
            this.exception = exc;
        }

        Exception getException() {
            return this.exception;
        }
    }

    FactoryFinder() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static void debugPrintln(String str) {
    }

    static Object find(String str, String str2) throws ConfigurationError {
        BufferedReader bufferedReader;
        debugPrintln("debug is on");
        ClassLoader findClassLoader = findClassLoader();
        try {
            String property = System.getProperty(str);
            if (property != null) {
                debugPrintln(new StringBuffer().append("found system property ").append(property).toString());
                return newInstance(property, findClassLoader);
            }
        } catch (SecurityException unused) {
        }
        try {
            File file = new File(new StringBuffer().append(System.getProperty("java.home")).append(File.separator).append("lib").append(File.separator).append("jaxp.properties").toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property2 = properties.getProperty(str);
                debugPrintln(new StringBuffer().append("found java.home property ").append(property2).toString());
                return newInstance(property2, findClassLoader);
            }
        } catch (Exception unused2) {
        }
        String stringBuffer = new StringBuffer().append("META-INF/services/").append(str).toString();
        try {
            InputStream systemResourceAsStream = findClassLoader == null ? ClassLoader.getSystemResourceAsStream(stringBuffer) : findClassLoader.getResourceAsStream(stringBuffer);
            if (systemResourceAsStream != null) {
                debugPrintln(new StringBuffer().append("found ").append(stringBuffer).toString());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(systemResourceAsStream, "UTF-8"));
                } catch (UnsupportedEncodingException unused3) {
                    bufferedReader = new BufferedReader(new InputStreamReader(systemResourceAsStream));
                }
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine != null && !"".equals(readLine)) {
                    debugPrintln(new StringBuffer().append("loaded from services: ").append(readLine).toString());
                    return newInstance(readLine, findClassLoader);
                }
            }
        } catch (Exception unused4) {
        }
        if (str2 == null) {
            throw new ConfigurationError(new StringBuffer().append("Provider for ").append(str).append(" cannot be found").toString(), null);
        }
        debugPrintln(new StringBuffer().append("loaded from fallback value: ").append(str2).toString());
        return newInstance(str2, findClassLoader);
    }

    private static ClassLoader findClassLoader() throws ConfigurationError {
        try {
            Class cls = class$java$lang$Thread;
            if (cls == null) {
                cls = class$("java.lang.Thread");
                class$java$lang$Thread = cls;
            }
            try {
                return (ClassLoader) cls.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
            } catch (IllegalAccessException e) {
                throw new ConfigurationError("Unexpected IllegalAccessException", e);
            } catch (InvocationTargetException e2) {
                throw new ConfigurationError("Unexpected InvocationTargetException", e2);
            }
        } catch (NoSuchMethodException unused) {
            debugPrintln("assuming JDK 1.1");
            Class cls2 = class$javax$xml$parsers$FactoryFinder;
            if (cls2 == null) {
                cls2 = class$("javax.xml.parsers.FactoryFinder");
                class$javax$xml$parsers$FactoryFinder = cls2;
            }
            return cls2.getClassLoader();
        }
    }

    private static Object newInstance(String str, ClassLoader classLoader) throws ConfigurationError {
        try {
            return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
        } catch (ClassNotFoundException e) {
            throw new ConfigurationError(new StringBuffer().append("Provider ").append(str).append(" not found").toString(), e);
        } catch (Exception e2) {
            throw new ConfigurationError(new StringBuffer().append("Provider ").append(str).append(" could not be instantiated: ").append(e2).toString(), e2);
        }
    }
}
