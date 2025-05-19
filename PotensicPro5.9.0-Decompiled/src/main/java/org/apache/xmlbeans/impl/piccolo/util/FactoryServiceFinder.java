package org.apache.xmlbeans.impl.piccolo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

/* loaded from: classes5.dex */
public class FactoryServiceFinder {
    static final String SERVICE = "META-INF/services/";

    public static String findService(String str) throws IOException {
        return new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(new StringBuffer().append(SERVICE).append(str).toString()), "UTF-8")).readLine();
    }

    public static Enumeration findServices(String str) throws IOException {
        return new FactoryEnumeration(ClassLoader.getSystemClassLoader().getResources(str));
    }

    private static class FactoryEnumeration implements Enumeration {
        Enumeration enumValue;
        Object next = null;

        FactoryEnumeration(Enumeration enumeration) {
            this.enumValue = enumeration;
            nextElement();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.next != null;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            Object obj = this.next;
            while (true) {
                try {
                    break;
                } catch (IOException unused) {
                }
            }
            if (this.enumValue.hasMoreElements()) {
                this.next = new BufferedReader(new InputStreamReader(((URL) this.enumValue.nextElement()).openStream())).readLine();
            } else {
                this.next = null;
            }
            return obj;
        }
    }
}
