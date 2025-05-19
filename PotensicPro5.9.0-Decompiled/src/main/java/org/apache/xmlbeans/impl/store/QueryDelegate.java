package org.apache.xmlbeans.impl.store;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class QueryDelegate {
    private static HashMap _constructors = new HashMap();
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$String;

    public interface QueryInterface {
        List execQuery(Object obj, Map map);
    }

    private QueryDelegate() {
    }

    private static synchronized void init(String str) {
        boolean z;
        synchronized (QueryDelegate.class) {
            if (str == null) {
                str = "org.apache.xmlbeans.impl.xquery.saxon.XBeansXQuery";
            }
            Class<?> cls = null;
            try {
                cls = Class.forName(str);
                z = true;
            } catch (ClassNotFoundException | NoClassDefFoundError unused) {
                z = false;
            }
            if (z) {
                try {
                    Class<?>[] clsArr = new Class[3];
                    Class<?> cls2 = class$java$lang$String;
                    if (cls2 == null) {
                        cls2 = class$("java.lang.String");
                        class$java$lang$String = cls2;
                    }
                    clsArr[0] = cls2;
                    Class<?> cls3 = class$java$lang$String;
                    if (cls3 == null) {
                        cls3 = class$("java.lang.String");
                        class$java$lang$String = cls3;
                    }
                    clsArr[1] = cls3;
                    Class<?> cls4 = class$java$lang$Integer;
                    if (cls4 == null) {
                        cls4 = class$("java.lang.Integer");
                        class$java$lang$Integer = cls4;
                    }
                    clsArr[2] = cls4;
                    _constructors.put(str, cls.getConstructor(clsArr));
                } catch (Exception e) {
                    throw new RuntimeException(e);
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

    public static synchronized QueryInterface createInstance(String str, String str2, String str3, int i) {
        synchronized (QueryDelegate.class) {
            if (_constructors.get(str) == null) {
                init(str);
            }
            if (_constructors.get(str) == null) {
                return null;
            }
            try {
                return (QueryInterface) ((Constructor) _constructors.get(str)).newInstance(str2, str3, new Integer(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
