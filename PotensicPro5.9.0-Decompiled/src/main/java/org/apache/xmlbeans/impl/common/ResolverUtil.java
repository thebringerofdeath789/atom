package org.apache.xmlbeans.impl.common;

import org.apache.xmlbeans.SystemProperties;
import org.xml.sax.EntityResolver;

/* loaded from: classes5.dex */
public class ResolverUtil {
    private static EntityResolver _entityResolver;
    static /* synthetic */ Class class$java$lang$String;

    static {
        try {
            String property = SystemProperties.getProperty("xmlbean.entityResolver");
            if (property != null) {
                _entityResolver = (EntityResolver) Class.forName(property).newInstance();
            }
        } catch (Exception unused) {
            _entityResolver = null;
        }
    }

    public static EntityResolver getGlobalEntityResolver() {
        return _entityResolver;
    }

    public static EntityResolver resolverForCatalog(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("org.apache.xml.resolver.CatalogManager");
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?>[] clsArr = new Class[1];
            Class<?> cls2 = class$java$lang$String;
            if (cls2 == null) {
                cls2 = class$("java.lang.String");
                class$java$lang$String = cls2;
            }
            clsArr[0] = cls2;
            cls.getMethod("setCatalogFiles", clsArr).invoke(newInstance, str);
            return (EntityResolver) Class.forName("org.apache.xml.resolver.tools.CatalogResolver").getConstructor(cls).newInstance(newInstance);
        } catch (Exception unused) {
            return null;
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
