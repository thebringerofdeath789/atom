package org.apache.xmlbeans;

import java.util.Hashtable;

/* loaded from: classes5.dex */
public class SystemProperties {
    protected static Hashtable propertyH;

    public static String getProperty(String str) {
        if (propertyH == null) {
            try {
                propertyH = System.getProperties();
            } catch (SecurityException unused) {
                propertyH = new Hashtable();
                return null;
            }
        }
        return (String) propertyH.get(str);
    }

    public static String getProperty(String str, String str2) {
        String property = getProperty(str);
        return property == null ? str2 : property;
    }

    public static void setPropertyH(Hashtable hashtable) {
        propertyH = hashtable;
    }
}
