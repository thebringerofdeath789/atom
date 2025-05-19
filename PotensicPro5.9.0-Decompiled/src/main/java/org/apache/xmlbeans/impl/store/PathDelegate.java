package org.apache.xmlbeans.impl.store;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.common.XPath;

/* loaded from: classes5.dex */
public final class PathDelegate {
    private static HashMap _constructors = new HashMap();
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$util$Map;

    public interface SelectPathInterface {
        List selectPath(Object obj);
    }

    private PathDelegate() {
    }

    private static synchronized void init(String str) {
        boolean z;
        synchronized (PathDelegate.class) {
            if (str == null) {
                str = "org.apache.xmlbeans.impl.xpath.saxon.XBeansXPath";
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
                    Class<?>[] clsArr = new Class[4];
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
                    Class<?> cls4 = class$java$util$Map;
                    if (cls4 == null) {
                        cls4 = class$("java.util.Map");
                        class$java$util$Map = cls4;
                    }
                    clsArr[2] = cls4;
                    Class<?> cls5 = class$java$lang$String;
                    if (cls5 == null) {
                        cls5 = class$("java.lang.String");
                        class$java$lang$String = cls5;
                    }
                    clsArr[3] = cls5;
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

    public static synchronized SelectPathInterface createInstance(String str, String str2, String str3, Map map) {
        synchronized (PathDelegate.class) {
            if (_constructors.get(str) == null) {
                init(str);
            }
            if (_constructors.get(str) == null) {
                return null;
            }
            Constructor constructor = (Constructor) _constructors.get(str);
            try {
                Object obj = map.get(XPath._DEFAULT_ELT_NS);
                if (obj != null) {
                    map.remove(XPath._DEFAULT_ELT_NS);
                }
                return (SelectPathInterface) constructor.newInstance(str2, str3, map, (String) obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
