package aavax.xml.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/* loaded from: classes.dex */
class FactoryFinder {
    static /* synthetic */ Class class$javax$xml$stream$FactoryFinder = null;
    private static boolean debug = false;

    FactoryFinder() {
    }

    static {
        try {
            debug = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }

    private static void debugPrintln(String str) {
        if (debug) {
            System.err.println(new StringBuffer().append("STREAM: ").append(str).toString());
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static ClassLoader findClassLoader() throws FactoryConfigurationError {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Class cls = class$javax$xml$stream$FactoryFinder;
            if (cls == null) {
                cls = class$("aavax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = cls;
            }
            return ((ClassLoaderFinder) Class.forName(stringBuffer.append(cls.getName()).append("$ClassLoaderFinderConcrete").toString()).newInstance()).getContextClassLoader();
        } catch (ClassNotFoundException unused) {
            Class cls2 = class$javax$xml$stream$FactoryFinder;
            if (cls2 == null) {
                cls2 = class$("aavax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = cls2;
            }
            return cls2.getClassLoader();
        } catch (Exception e) {
            throw new FactoryConfigurationError(e.toString(), e);
        } catch (LinkageError unused2) {
            Class cls3 = class$javax$xml$stream$FactoryFinder;
            if (cls3 == null) {
                cls3 = class$("aavax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = cls3;
            }
            return cls3.getClassLoader();
        }
    }

    private static Object newInstance(String str, ClassLoader classLoader) throws FactoryConfigurationError {
        Class<?> loadClass;
        try {
            if (classLoader == null) {
                loadClass = Class.forName(str);
            } else {
                loadClass = classLoader.loadClass(str);
            }
            return loadClass.newInstance();
        } catch (ClassNotFoundException e) {
            throw new FactoryConfigurationError(new StringBuffer().append("Provider ").append(str).append(" not found").toString(), e);
        } catch (Exception e2) {
            throw new FactoryConfigurationError(new StringBuffer().append("Provider ").append(str).append(" could not be instantiated: ").append(e2).toString(), e2);
        }
    }

    static Object find(String str) throws FactoryConfigurationError {
        return find(str, null);
    }

    static Object find(String str, String str2) throws FactoryConfigurationError {
        return find(str, str2, findClassLoader());
    }

    static Object find(String str, String str2, ClassLoader classLoader) throws FactoryConfigurationError {
        InputStream resourceAsStream;
        try {
            String property = System.getProperty(str);
            if (property != null) {
                debugPrintln(new StringBuffer().append("found system property").append(property).toString());
                return newInstance(property, classLoader);
            }
        } catch (SecurityException unused) {
        }
        try {
            File file = new File(new StringBuffer().append(System.getProperty("java.home")).append(File.separator).append("lib").append(File.separator).append("jaxp.properties").toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property2 = properties.getProperty(str);
                if (property2 != null && property2.length() > 0) {
                    debugPrintln(new StringBuffer().append("found java.home property ").append(property2).toString());
                    return newInstance(property2, classLoader);
                }
            }
        } catch (Exception e) {
            if (debug) {
                e.printStackTrace();
            }
        }
        String stringBuffer = new StringBuffer().append("META-INF/services/").append(str).toString();
        try {
            if (classLoader == null) {
                resourceAsStream = ClassLoader.getSystemResourceAsStream(stringBuffer);
            } else {
                resourceAsStream = classLoader.getResourceAsStream(stringBuffer);
            }
            if (resourceAsStream != null) {
                debugPrintln(new StringBuffer().append("found ").append(stringBuffer).toString());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine != null && !"".equals(readLine)) {
                    debugPrintln(new StringBuffer().append("loaded from services: ").append(readLine).toString());
                    return newInstance(readLine, classLoader);
                }
            }
        } catch (Exception e2) {
            if (debug) {
                e2.printStackTrace();
            }
        }
        if (str2 == null) {
            throw new FactoryConfigurationError(new StringBuffer().append("Provider for ").append(str).append(" cannot be found").toString(), (Exception) null);
        }
        debugPrintln(new StringBuffer().append("loaded from fallback value: ").append(str2).toString());
        return newInstance(str2, classLoader);
    }

    private static abstract class ClassLoaderFinder {
        abstract ClassLoader getContextClassLoader();

        private ClassLoaderFinder() {
        }
    }

    static class ClassLoaderFinderConcrete extends ClassLoaderFinder {
        ClassLoaderFinderConcrete() {
            super();
        }

        @Override // aavax.xml.stream.FactoryFinder.ClassLoaderFinder
        ClassLoader getContextClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }
}
