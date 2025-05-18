package com.ipotensic.baselib.notchtools.helper;

import com.ipotensic.baselib.DDLog;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class SystemProperties {
    private static final String TAG = "SystemProperties";
    private static Method getStringProperty;
    private static SystemProperties sSystemProperties;

    public static SystemProperties getInstance() {
        if (sSystemProperties == null) {
            synchronized (SystemProperties.class) {
                if (sSystemProperties == null) {
                    sSystemProperties = new SystemProperties();
                }
            }
        }
        return sSystemProperties;
    }

    private SystemProperties() {
        getStringProperty = getMethod(getClass("android.os.SystemProperties"));
    }

    private Class getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            DDLog.m1685e(TAG, e.getMessage());
            try {
                return ClassLoader.getSystemClassLoader().loadClass(str);
            } catch (ClassNotFoundException e2) {
                DDLog.m1685e(TAG, e2.getMessage());
                return null;
            }
        }
    }

    private Method getMethod(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("get", String.class);
        } catch (Exception e) {
            DDLog.m1685e(TAG, e.getMessage());
            return null;
        }
    }

    public final String get(String str) {
        if (str == null) {
            return "";
        }
        try {
            Method method = getStringProperty;
            String str2 = (String) (method != null ? method.invoke(null, str) : null);
            if (str2 != null) {
                return str2.trim();
            }
        } catch (Exception unused) {
        }
        return "";
    }
}