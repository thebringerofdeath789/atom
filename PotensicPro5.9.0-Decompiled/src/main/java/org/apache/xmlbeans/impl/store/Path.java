package org.apache.xmlbeans.impl.store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.XPath;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.PathDelegate;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public abstract class Path {
    public static final String PATH_DELEGATE_INTERFACE = "PATH_DELEGATE_INTERFACE";
    private static final int USE_DELEGATE = 4;
    private static final int USE_XBEAN = 1;
    private static final int USE_XDK = 16;
    private static final int USE_XQRL = 2;
    private static final int USE_XQRL2002 = 8;
    private static String _delIntfName = null;
    public static String _forceXqrl2002ForXpathXQuery = "use xqrl-2002 for xpath";
    public static String _useDelegateForXpath = "use delegate for xpath";
    public static String _useXbeanForXpath = "use xbean for xpath";
    public static String _useXdkForXpath = "use xdk for xpath";
    public static String _useXqrlForXpath = "use xqrl for xpath";
    private static Method _xdkCompilePath;
    private static Method _xqrl2002CompilePath;
    private static Method _xqrlCompilePath;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Path;
    protected final String _pathKey;
    private static Map _xbeanPathCache = new WeakHashMap();
    private static Map _xdkPathCache = new WeakHashMap();
    private static Map _xqrlPathCache = new WeakHashMap();
    private static Map _xqrl2002PathCache = new WeakHashMap();
    private static boolean _xdkAvailable = true;
    private static boolean _xqrlAvailable = true;
    private static boolean _xqrl2002Available = true;

    interface PathEngine {
        boolean next(Cur cur);

        void release();
    }

    abstract PathEngine execute(Cur cur, XmlOptions xmlOptions);

    static {
        Class cls = class$org$apache$xmlbeans$impl$store$Path;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.store.Path");
            class$org$apache$xmlbeans$impl$store$Path = cls;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cls.getClassLoader().getResourceAsStream("META-INF/services/org.apache.xmlbeans.impl.store.PathDelegate.SelectPathInterface")));
            _delIntfName = bufferedReader.readLine().trim();
            bufferedReader.close();
        } catch (Exception unused) {
            _delIntfName = null;
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    Path(String str) {
        this._pathKey = str;
    }

    static String getCurrentNodeVar(XmlOptions xmlOptions) {
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        if (!maskNull.hasOption(XmlOptions.XQUERY_CURRENT_NODE_VAR)) {
            return "this";
        }
        String str = (String) maskNull.get(XmlOptions.XQUERY_CURRENT_NODE_VAR);
        if (str.startsWith("$")) {
            throw new IllegalArgumentException("Omit the '$' prefix for the current node variable");
        }
        return str;
    }

    public static Path getCompiledPath(String str, XmlOptions xmlOptions) {
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        return getCompiledPath(str, maskNull.hasOption(_useDelegateForXpath) ? 4 : maskNull.hasOption(_useXqrlForXpath) ? 2 : maskNull.hasOption(_useXdkForXpath) ? 16 : maskNull.hasOption(_useXbeanForXpath) ? 1 : maskNull.hasOption(_forceXqrl2002ForXpathXQuery) ? 8 : 23, getCurrentNodeVar(maskNull), maskNull.hasOption(PATH_DELEGATE_INTERFACE) ? (String) maskNull.get(PATH_DELEGATE_INTERFACE) : _delIntfName);
    }

    static synchronized Path getCompiledPath(String str, int i, String str2, String str3) {
        HashMap hashMap;
        synchronized (Path.class) {
            int i2 = i & 4;
            if (i2 != 0) {
                try {
                    hashMap = new HashMap();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                hashMap = null;
            }
            int i3 = i & 1;
            WeakReference weakReference = i3 != 0 ? (WeakReference) _xbeanPathCache.get(str) : null;
            if (weakReference == null && (i & 2) != 0) {
                weakReference = (WeakReference) _xqrlPathCache.get(str);
            }
            if (weakReference == null && (i & 16) != 0) {
                weakReference = (WeakReference) _xdkPathCache.get(str);
            }
            if (weakReference == null && (i & 8) != 0) {
                weakReference = (WeakReference) _xqrl2002PathCache.get(str);
            }
            Path path = weakReference != null ? (Path) weakReference.get() : null;
            if (path != null) {
                return path;
            }
            if (i3 != 0) {
                path = getCompiledPathXbean(str, str2, hashMap);
            }
            if (path == null && (i & 2) != 0) {
                path = getCompiledPathXqrl(str, str2);
            }
            if (path == null && (i & 16) != 0) {
                path = getCompiledPathXdk(str, str2);
            }
            if (path == null && i2 != 0) {
                path = getCompiledPathDelegate(str, str2, hashMap, str3);
            }
            if (path == null && (i & 8) != 0) {
                path = getCompiledPathXqrl2002(str, str2);
            }
            if (path != null) {
                return path;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (i3 != 0) {
                stringBuffer.append(" Trying XBeans path engine...");
            }
            if ((i & 2) != 0) {
                stringBuffer.append(" Trying XQRL...");
            }
            if ((i & 16) != 0) {
                stringBuffer.append(" Trying XDK...");
            }
            if (i2 != 0) {
                stringBuffer.append(" Trying delegated path engine...");
            }
            if ((i & 8) != 0) {
                stringBuffer.append(" Trying XQRL2002...");
            }
            throw new RuntimeException(new StringBuffer().append(stringBuffer.toString()).append(" FAILED on ").append(str).toString());
        }
    }

    private static synchronized Path getCompiledPathXdk(String str, String str2) {
        Path createXdkCompiledPath;
        synchronized (Path.class) {
            createXdkCompiledPath = createXdkCompiledPath(str, str2);
            if (createXdkCompiledPath != null) {
                _xdkPathCache.put(createXdkCompiledPath._pathKey, new WeakReference(createXdkCompiledPath));
            }
        }
        return createXdkCompiledPath;
    }

    private static synchronized Path getCompiledPathXqrl(String str, String str2) {
        Path createXqrlCompiledPath;
        synchronized (Path.class) {
            createXqrlCompiledPath = createXqrlCompiledPath(str, str2);
            if (createXqrlCompiledPath != null) {
                _xqrlPathCache.put(createXqrlCompiledPath._pathKey, new WeakReference(createXqrlCompiledPath));
            }
        }
        return createXqrlCompiledPath;
    }

    private static synchronized Path getCompiledPathXqrl2002(String str, String str2) {
        Path createXqrl2002CompiledPath;
        synchronized (Path.class) {
            createXqrl2002CompiledPath = createXqrl2002CompiledPath(str, str2);
            if (createXqrl2002CompiledPath != null) {
                _xqrl2002PathCache.put(createXqrl2002CompiledPath._pathKey, new WeakReference(createXqrl2002CompiledPath));
            }
        }
        return createXqrl2002CompiledPath;
    }

    private static synchronized Path getCompiledPathXbean(String str, String str2, Map map) {
        Path create;
        synchronized (Path.class) {
            create = XbeanPath.create(str, str2, map);
            if (create != null) {
                _xbeanPathCache.put(create._pathKey, new WeakReference(create));
            }
        }
        return create;
    }

    private static synchronized Path getCompiledPathDelegate(String str, String str2, Map map, String str3) {
        Path create;
        synchronized (Path.class) {
            if (map == null) {
                map = new HashMap();
            }
            try {
                XPath.compileXPath(str, str2, map);
            } catch (XPath.XPathCompileException unused) {
            }
            int intValue = map.get(XPath._NS_BOUNDARY) == null ? 0 : ((Integer) map.get(XPath._NS_BOUNDARY)).intValue();
            map.remove(XPath._NS_BOUNDARY);
            create = DelegatePathImpl.create(str3, str.substring(intValue), str2, map);
        }
        return create;
    }

    public static synchronized String compilePath(String str, XmlOptions xmlOptions) {
        String str2;
        synchronized (Path.class) {
            str2 = getCompiledPath(str, xmlOptions)._pathKey;
        }
        return str2;
    }

    private static final class XbeanPath extends Path {
        private final XPath _compiledPath;
        private final String _currentVar;
        public Map namespaces;

        static Path create(String str, String str2, Map map) {
            try {
                return new XbeanPath(str, str2, XPath.compileXPath(str, str2, map));
            } catch (XPath.XPathCompileException unused) {
                return null;
            }
        }

        private XbeanPath(String str, String str2, XPath xPath) {
            super(str);
            this._currentVar = str2;
            this._compiledPath = xPath;
        }

        @Override // org.apache.xmlbeans.impl.store.Path
        PathEngine execute(Cur cur, XmlOptions xmlOptions) {
            XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
            String str = maskNull.hasOption(Path.PATH_DELEGATE_INTERFACE) ? (String) maskNull.get(Path.PATH_DELEGATE_INTERFACE) : Path._delIntfName;
            if (!cur.isContainer() || this._compiledPath.sawDeepDot()) {
                return getCompiledPath(this._pathKey, 22, this._currentVar, str).execute(cur, maskNull);
            }
            return new XbeanPathEngine(this._compiledPath, cur);
        }
    }

    private static Path createXdkCompiledPath(String str, String str2) {
        if (!_xdkAvailable) {
            return null;
        }
        if (_xdkCompilePath == null) {
            try {
                Class<?> cls = Class.forName("org.apache.xmlbeans.impl.store.OXQXBXqrlImpl");
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
                Class<?> cls4 = class$java$lang$Boolean;
                if (cls4 == null) {
                    cls4 = class$("java.lang.Boolean");
                    class$java$lang$Boolean = cls4;
                }
                clsArr[2] = cls4;
                _xdkCompilePath = cls.getDeclaredMethod("compilePath", clsArr);
            } catch (ClassNotFoundException unused) {
                _xdkAvailable = false;
                return null;
            } catch (Exception e) {
                _xdkAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xdkCompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Path createXqrlCompiledPath(String str, String str2) {
        if (!_xqrlAvailable) {
            return null;
        }
        if (_xqrlCompilePath == null) {
            try {
                Class<?> cls = Class.forName("org.apache.xmlbeans.impl.store.XqrlImpl");
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
                Class<?> cls4 = class$java$lang$Boolean;
                if (cls4 == null) {
                    cls4 = class$("java.lang.Boolean");
                    class$java$lang$Boolean = cls4;
                }
                clsArr[2] = cls4;
                _xqrlCompilePath = cls.getDeclaredMethod("compilePath", clsArr);
            } catch (ClassNotFoundException unused) {
                _xqrlAvailable = false;
                return null;
            } catch (Exception e) {
                _xqrlAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xqrlCompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Path createXqrl2002CompiledPath(String str, String str2) {
        if (!_xqrl2002Available) {
            return null;
        }
        if (_xqrl2002CompilePath == null) {
            try {
                Class<?> cls = Class.forName("org.apache.xmlbeans.impl.store.Xqrl2002Impl");
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
                Class<?> cls4 = class$java$lang$Boolean;
                if (cls4 == null) {
                    cls4 = class$("java.lang.Boolean");
                    class$java$lang$Boolean = cls4;
                }
                clsArr[2] = cls4;
                _xqrl2002CompilePath = cls.getDeclaredMethod("compilePath", clsArr);
            } catch (ClassNotFoundException unused) {
                _xqrl2002Available = false;
                return null;
            } catch (Exception e) {
                _xqrl2002Available = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xqrl2002CompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static final class XbeanPathEngine extends XPath.ExecutionContext implements PathEngine {
        static final /* synthetic */ boolean $assertionsDisabled;
        private Cur _cur;
        private final long _version;

        static {
            if (Path.class$org$apache$xmlbeans$impl$store$Path == null) {
                Path.class$org$apache$xmlbeans$impl$store$Path = Path.class$("org.apache.xmlbeans.impl.store.Path");
            } else {
                Class cls = Path.class$org$apache$xmlbeans$impl$store$Path;
            }
            $assertionsDisabled = true;
        }

        XbeanPathEngine(XPath xPath, Cur cur) {
            if (!$assertionsDisabled && !cur.isContainer()) {
                throw new AssertionError();
            }
            this._version = cur._locale.version();
            Cur weakCur = cur.weakCur(this);
            this._cur = weakCur;
            weakCur.push();
            init(xPath);
            int start = start();
            if ((start & 1) != 0) {
                cur.addToSelection();
            }
            doAttrs(start, cur);
            if ((start & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
                release();
            }
        }

        private void advance(Cur cur) {
            if (!$assertionsDisabled && this._cur == null) {
                throw new AssertionError();
            }
            if (this._cur.isFinish()) {
                if (this._cur.isAtEndOfLastPush()) {
                    release();
                    return;
                } else {
                    end();
                    this._cur.next();
                    return;
                }
            }
            if (this._cur.isElem()) {
                int element = element(this._cur.getName());
                if ((element & 1) != 0) {
                    cur.addToSelection(this._cur);
                }
                doAttrs(element, cur);
                if ((element & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
                    end();
                    this._cur.skip();
                    return;
                }
                return;
            }
            do {
                this._cur.next();
            } while (!this._cur.isContainerOrFinish());
        }

        private void doAttrs(int i, Cur cur) {
            if (!$assertionsDisabled && !this._cur.isContainer()) {
                throw new AssertionError();
            }
            if ((i & 4) == 0 || !this._cur.toFirstAttr()) {
                return;
            }
            do {
                if (attr(this._cur.getName())) {
                    cur.addToSelection(this._cur);
                }
            } while (this._cur.toNextAttr());
            this._cur.toParent();
        }

        @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
        public boolean next(Cur cur) {
            Cur cur2 = this._cur;
            if (cur2 != null && this._version != cur2._locale.version()) {
                throw new ConcurrentModificationException("Document changed during select");
            }
            int selectionCount = cur.selectionCount();
            while (this._cur != null) {
                advance(cur);
                if (selectionCount != cur.selectionCount()) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
        public void release() {
            Cur cur = this._cur;
            if (cur != null) {
                cur.release();
                this._cur = null;
            }
        }
    }

    private static final class DelegatePathImpl extends Path {
        static final /* synthetic */ boolean $assertionsDisabled;
        private PathDelegate.SelectPathInterface _xpathImpl;

        static {
            if (Path.class$org$apache$xmlbeans$impl$store$Path == null) {
                Path.class$org$apache$xmlbeans$impl$store$Path = Path.class$("org.apache.xmlbeans.impl.store.Path");
            } else {
                Class cls = Path.class$org$apache$xmlbeans$impl$store$Path;
            }
            $assertionsDisabled = true;
        }

        static Path create(String str, String str2, String str3, Map map) {
            if (!$assertionsDisabled && str3.startsWith("$")) {
                throw new AssertionError();
            }
            PathDelegate.SelectPathInterface createInstance = PathDelegate.createInstance(str, str2, str3, map);
            if (createInstance == null) {
                return null;
            }
            return new DelegatePathImpl(createInstance, str2);
        }

        private DelegatePathImpl(PathDelegate.SelectPathInterface selectPathInterface, String str) {
            super(str);
            this._xpathImpl = selectPathInterface;
        }

        @Override // org.apache.xmlbeans.impl.store.Path
        protected PathEngine execute(Cur cur, XmlOptions xmlOptions) {
            return new DelegatePathEngine(this._xpathImpl, cur);
        }

        private static class DelegatePathEngine extends XPath.ExecutionContext implements PathEngine {
            static final /* synthetic */ boolean $assertionsDisabled;
            private Cur _cur;
            private PathDelegate.SelectPathInterface _engine;
            private boolean _firstCall = true;
            private long _version;

            static {
                if (Path.class$org$apache$xmlbeans$impl$store$Path == null) {
                    Path.class$org$apache$xmlbeans$impl$store$Path = Path.class$("org.apache.xmlbeans.impl.store.Path");
                } else {
                    Class cls = Path.class$org$apache$xmlbeans$impl$store$Path;
                }
                $assertionsDisabled = true;
            }

            DelegatePathEngine(PathDelegate.SelectPathInterface selectPathInterface, Cur cur) {
                this._engine = selectPathInterface;
                this._version = cur._locale.version();
                this._cur = cur.weakCur(this);
            }

            @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
            public boolean next(Cur cur) {
                Cur tempCur;
                if (!this._firstCall) {
                    return false;
                }
                this._firstCall = false;
                Cur cur2 = this._cur;
                if (cur2 != null && this._version != cur2._locale.version()) {
                    throw new ConcurrentModificationException("Document changed during select");
                }
                List selectPath = this._engine.selectPath(this._cur.getDom());
                for (int i = 0; i < selectPath.size(); i++) {
                    Object obj = selectPath.get(i);
                    if (!(obj instanceof Node)) {
                        String obj2 = selectPath.get(i).toString();
                        try {
                            tempCur = cur._locale.load("<xml-fragment/>").tempCur();
                            tempCur.setValue(obj2);
                            Locale.autoTypeDocument(tempCur, getType(obj), null);
                            tempCur.next();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        if (!$assertionsDisabled && !(obj instanceof DomImpl.Dom)) {
                            throw new AssertionError("New object created in XPATH!");
                        }
                        tempCur = ((DomImpl.Dom) obj).tempCur();
                    }
                    cur.addToSelection(tempCur);
                    tempCur.release();
                }
                release();
                this._engine = null;
                return true;
            }

            private SchemaType getType(Object obj) {
                if (obj instanceof Integer) {
                    return XmlInteger.type;
                }
                if (obj instanceof Double) {
                    return XmlDouble.type;
                }
                if (obj instanceof Long) {
                    return XmlLong.type;
                }
                if (obj instanceof Float) {
                    return XmlFloat.type;
                }
                if (obj instanceof BigDecimal) {
                    return XmlDecimal.type;
                }
                if (obj instanceof Boolean) {
                    return XmlBoolean.type;
                }
                if (obj instanceof String) {
                    return XmlString.type;
                }
                if (obj instanceof Date) {
                    return XmlDate.type;
                }
                return XmlAnySimpleType.type;
            }

            @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
            public void release() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur.release();
                    this._cur = null;
                }
            }
        }
    }
}
