package org.apache.xmlbeans.impl.soap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.xmlbeans.SystemProperties;

/* loaded from: classes5.dex */
class FactoryFinder {
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$soap$FactoryFinder;

    FactoryFinder() {
    }

    private static Object newInstance(String str) throws SOAPException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Class<?> cls = null;
            try {
                if (contextClassLoader == null) {
                    try {
                        cls = Class.forName(str);
                    } catch (ClassNotFoundException e) {
                        throw new SOAPException(new StringBuffer().append("Provider ").append(str).append(" not found").toString(), e);
                    }
                } else {
                    try {
                        cls = contextClassLoader.loadClass(str);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (cls == null) {
                    Class cls2 = class$org$apache$xmlbeans$impl$soap$FactoryFinder;
                    if (cls2 == null) {
                        cls2 = class$("org.apache.xmlbeans.impl.soap.FactoryFinder");
                        class$org$apache$xmlbeans$impl$soap$FactoryFinder = cls2;
                    }
                    cls = cls2.getClassLoader().loadClass(str);
                }
                return cls.newInstance();
            } catch (Exception e2) {
                throw new SOAPException(new StringBuffer().append("Provider ").append(str).append(" could not be instantiated: ").append(e2).toString(), e2);
            }
        } catch (Exception e3) {
            throw new SOAPException(e3.toString(), e3);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    static Object find(String str, String str2) throws SOAPException {
        try {
            String property = SystemProperties.getProperty(str);
            if (property != null) {
                return newInstance(property);
            }
        } catch (SecurityException unused) {
        }
        try {
            File file = new File(new StringBuffer().append(SystemProperties.getProperty("java.home")).append(File.separator).append("lib").append(File.separator).append("jaxm.properties").toString());
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                return newInstance(properties.getProperty(str));
            }
        } catch (Exception unused2) {
        }
        try {
            InputStream resource = getResource(new StringBuffer().append("META-INF/services/").append(str).toString());
            if (resource != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource, "UTF-8"));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine != null && !"".equals(readLine)) {
                    return newInstance(readLine);
                }
            }
        } catch (Exception unused3) {
        }
        if (str2 == null) {
            throw new SOAPException(new StringBuffer().append("Provider for ").append(str).append(" cannot be found").toString(), null);
        }
        return newInstance(str2);
    }

    private static InputStream getResource(String str) {
        ClassLoader classLoader;
        InputStream resourceAsStream;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            classLoader = null;
        }
        if (classLoader == null) {
            resourceAsStream = ClassLoader.getSystemResourceAsStream(str);
        } else {
            resourceAsStream = classLoader.getResourceAsStream(str);
        }
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        Class cls = class$org$apache$xmlbeans$impl$soap$FactoryFinder;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.soap.FactoryFinder");
            class$org$apache$xmlbeans$impl$soap$FactoryFinder = cls;
        }
        return cls.getClassLoader().getResourceAsStream(str);
    }
}
