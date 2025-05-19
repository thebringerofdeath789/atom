package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.store.QueryDelegate;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public abstract class Query {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String QUERY_DELEGATE_INTERFACE = "QUERY_DELEGATE_INTERFACE";
    private static String _delIntfName;
    public static String _useDelegateForXQuery;
    public static String _useXdkForXQuery;
    private static boolean _xdkAvailable;
    private static Method _xdkCompileQuery;
    private static HashMap _xdkQueryCache;
    private static boolean _xqrl2002Available;
    private static Method _xqrl2002CompileQuery;
    private static HashMap _xqrl2002QueryCache;
    private static boolean _xqrlAvailable;
    private static Method _xqrlCompileQuery;
    private static HashMap _xqrlQueryCache;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$Query;

    abstract XmlCursor cursorExecute(Cur cur, XmlOptions xmlOptions);

    abstract XmlObject[] objectExecute(Cur cur, XmlOptions xmlOptions);

    static {
        if (class$org$apache$xmlbeans$impl$store$Query == null) {
            class$org$apache$xmlbeans$impl$store$Query = class$("org.apache.xmlbeans.impl.store.Query");
        }
        $assertionsDisabled = true;
        _useDelegateForXQuery = "use delegate for xquery";
        _useXdkForXQuery = "use xdk for xquery";
        _xdkQueryCache = new HashMap();
        _xdkAvailable = true;
        _xqrlQueryCache = new HashMap();
        _xqrlAvailable = true;
        _xqrl2002QueryCache = new HashMap();
        _xqrl2002Available = true;
        Class cls = class$org$apache$xmlbeans$impl$store$Query;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.store.Query");
            class$org$apache$xmlbeans$impl$store$Query = cls;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cls.getClassLoader().getResourceAsStream("META-INF/services/org.apache.xmlbeans.impl.store.QueryDelegate.QueryInterface")));
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

    static XmlObject[] objectExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).objectExecute(cur, xmlOptions);
    }

    static XmlCursor cursorExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).cursorExecute(cur, xmlOptions);
    }

    public static synchronized Query getCompiledQuery(String str, XmlOptions xmlOptions) {
        Query compiledQuery;
        synchronized (Query.class) {
            compiledQuery = getCompiledQuery(str, Path.getCurrentNodeVar(xmlOptions), xmlOptions);
        }
        return compiledQuery;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:11:0x0010, B:13:0x001c, B:17:0x0028, B:19:0x002e, B:22:0x0035, B:23:0x003c, B:24:0x003d, B:28:0x0046, B:31:0x0084, B:33:0x008c, B:37:0x0098, B:39:0x009e, B:42:0x00a5, B:44:0x00ad, B:48:0x00b9, B:50:0x00bf, B:53:0x00c6, B:55:0x00ce, B:56:0x00d9, B:60:0x00e1, B:61:0x00e8, B:62:0x00d7, B:63:0x004f, B:64:0x0057, B:67:0x005d, B:70:0x0071, B:71:0x0066, B:72:0x0072, B:75:0x007b, B:27:0x0043), top: B:3:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ad A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:11:0x0010, B:13:0x001c, B:17:0x0028, B:19:0x002e, B:22:0x0035, B:23:0x003c, B:24:0x003d, B:28:0x0046, B:31:0x0084, B:33:0x008c, B:37:0x0098, B:39:0x009e, B:42:0x00a5, B:44:0x00ad, B:48:0x00b9, B:50:0x00bf, B:53:0x00c6, B:55:0x00ce, B:56:0x00d9, B:60:0x00e1, B:61:0x00e8, B:62:0x00d7, B:63:0x004f, B:64:0x0057, B:67:0x005d, B:70:0x0071, B:71:0x0066, B:72:0x0072, B:75:0x007b, B:27:0x0043), top: B:3:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ce A[Catch: all -> 0x00e9, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:11:0x0010, B:13:0x001c, B:17:0x0028, B:19:0x002e, B:22:0x0035, B:23:0x003c, B:24:0x003d, B:28:0x0046, B:31:0x0084, B:33:0x008c, B:37:0x0098, B:39:0x009e, B:42:0x00a5, B:44:0x00ad, B:48:0x00b9, B:50:0x00bf, B:53:0x00c6, B:55:0x00ce, B:56:0x00d9, B:60:0x00e1, B:61:0x00e8, B:62:0x00d7, B:63:0x004f, B:64:0x0057, B:67:0x005d, B:70:0x0071, B:71:0x0066, B:72:0x0072, B:75:0x007b, B:27:0x0043), top: B:3:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00df A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1 A[Catch: all -> 0x00e9, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:11:0x0010, B:13:0x001c, B:17:0x0028, B:19:0x002e, B:22:0x0035, B:23:0x003c, B:24:0x003d, B:28:0x0046, B:31:0x0084, B:33:0x008c, B:37:0x0098, B:39:0x009e, B:42:0x00a5, B:44:0x00ad, B:48:0x00b9, B:50:0x00bf, B:53:0x00c6, B:55:0x00ce, B:56:0x00d9, B:60:0x00e1, B:61:0x00e8, B:62:0x00d7, B:63:0x004f, B:64:0x0057, B:67:0x005d, B:70:0x0071, B:71:0x0066, B:72:0x0072, B:75:0x007b, B:27:0x0043), top: B:3:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7 A[Catch: all -> 0x00e9, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000a, B:9:0x000f, B:11:0x0010, B:13:0x001c, B:17:0x0028, B:19:0x002e, B:22:0x0035, B:23:0x003c, B:24:0x003d, B:28:0x0046, B:31:0x0084, B:33:0x008c, B:37:0x0098, B:39:0x009e, B:42:0x00a5, B:44:0x00ad, B:48:0x00b9, B:50:0x00bf, B:53:0x00c6, B:55:0x00ce, B:56:0x00d9, B:60:0x00e1, B:61:0x00e8, B:62:0x00d7, B:63:0x004f, B:64:0x0057, B:67:0x005d, B:70:0x0071, B:71:0x0066, B:72:0x0072, B:75:0x007b, B:27:0x0043), top: B:3:0x0003, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static synchronized org.apache.xmlbeans.impl.store.Query getCompiledQuery(java.lang.String r4, java.lang.String r5, org.apache.xmlbeans.XmlOptions r6) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.Query.getCompiledQuery(java.lang.String, java.lang.String, org.apache.xmlbeans.XmlOptions):org.apache.xmlbeans.impl.store.Query");
    }

    public static synchronized String compileQuery(String str, XmlOptions xmlOptions) {
        synchronized (Query.class) {
            getCompiledQuery(str, xmlOptions);
        }
        return str;
    }

    private static Query createXdkCompiledQuery(String str, String str2) {
        if (!_xdkAvailable) {
            return null;
        }
        if (_xdkCompileQuery == null) {
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
                _xdkCompileQuery = cls.getDeclaredMethod("compileQuery", clsArr);
            } catch (ClassNotFoundException unused) {
                _xdkAvailable = false;
                return null;
            } catch (Exception e) {
                _xdkAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xdkCompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Query createXqrlCompiledQuery(String str, String str2) {
        if (!_xqrlAvailable) {
            return null;
        }
        if (_xqrlCompileQuery == null) {
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
                _xqrlCompileQuery = cls.getDeclaredMethod("compileQuery", clsArr);
            } catch (ClassNotFoundException unused) {
                _xqrlAvailable = false;
                return null;
            } catch (Exception e) {
                _xqrlAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xqrlCompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Query getXqrl2002CompiledQuery(String str, String str2) {
        if (_xqrl2002Available && _xqrl2002CompileQuery == null) {
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
                _xqrl2002CompileQuery = cls.getDeclaredMethod("compileQuery", clsArr);
            } catch (ClassNotFoundException unused) {
                _xqrl2002Available = false;
                return null;
            } catch (Exception e) {
                _xqrl2002Available = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xqrl2002CompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static final class DelegateQueryImpl extends Query {
        static final /* synthetic */ boolean $assertionsDisabled;
        private QueryDelegate.QueryInterface _xqueryImpl;

        static {
            if (Query.class$org$apache$xmlbeans$impl$store$Query == null) {
                Query.class$org$apache$xmlbeans$impl$store$Query = Query.class$("org.apache.xmlbeans.impl.store.Query");
            } else {
                Class cls = Query.class$org$apache$xmlbeans$impl$store$Query;
            }
            $assertionsDisabled = true;
        }

        private DelegateQueryImpl(QueryDelegate.QueryInterface queryInterface) {
            this._xqueryImpl = queryInterface;
        }

        public static Query createDelegateCompiledQuery(String str, String str2, String str3, int i) {
            if (!$assertionsDisabled && (str3.startsWith(".") || str3.startsWith(".."))) {
                throw new AssertionError();
            }
            QueryDelegate.QueryInterface createInstance = QueryDelegate.createInstance(str, str2, str3, i);
            if (createInstance == null) {
                return null;
            }
            return new DelegateQueryImpl(createInstance);
        }

        @Override // org.apache.xmlbeans.impl.store.Query
        XmlObject[] objectExecute(Cur cur, XmlOptions xmlOptions) {
            return new DelegateQueryEngine(this._xqueryImpl, cur, xmlOptions).objectExecute();
        }

        @Override // org.apache.xmlbeans.impl.store.Query
        XmlCursor cursorExecute(Cur cur, XmlOptions xmlOptions) {
            return new DelegateQueryEngine(this._xqueryImpl, cur, xmlOptions).cursorExecute();
        }

        private static class DelegateQueryEngine {
            static final /* synthetic */ boolean $assertionsDisabled;
            private Cur _cur;
            private QueryDelegate.QueryInterface _engine;
            private XmlOptions _options;
            private long _version;

            static {
                if (Query.class$org$apache$xmlbeans$impl$store$Query == null) {
                    Query.class$org$apache$xmlbeans$impl$store$Query = Query.class$("org.apache.xmlbeans.impl.store.Query");
                } else {
                    Class cls = Query.class$org$apache$xmlbeans$impl$store$Query;
                }
                $assertionsDisabled = true;
            }

            public DelegateQueryEngine(QueryDelegate.QueryInterface queryInterface, Cur cur, XmlOptions xmlOptions) {
                this._engine = queryInterface;
                this._version = cur._locale.version();
                this._cur = cur.weakCur(this);
                this._options = xmlOptions;
            }

            public XmlObject[] objectExecute() {
                Cur loadNode;
                Cur cur = this._cur;
                if (cur != null) {
                    cur._locale.version();
                }
                List execQuery = this._engine.execQuery(this._cur.getDom(), (Map) XmlOptions.maskNull(this._options).get(XmlOptions.XQUERY_VARIABLE_MAP));
                if (!$assertionsDisabled && execQuery.size() <= -1) {
                    throw new AssertionError();
                }
                XmlObject[] xmlObjectArr = new XmlObject[execQuery.size()];
                for (int i = 0; i < execQuery.size(); i++) {
                    Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
                    locale.enter();
                    Object obj = execQuery.get(i);
                    try {
                        try {
                            if (!(obj instanceof Node)) {
                                loadNode = locale.load("<xml-fragment/>").tempCur();
                                loadNode.setValue(obj.toString());
                                Locale.autoTypeDocument(loadNode, getType(obj), null);
                                xmlObjectArr[i] = loadNode.getObject();
                            } else {
                                loadNode = loadNode(locale, (Node) obj);
                            }
                            xmlObjectArr[i] = loadNode.getObject();
                            locale.exit();
                            loadNode.release();
                        } catch (XmlException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (Throwable th) {
                        locale.exit();
                        throw th;
                    }
                }
                release();
                this._engine = null;
                return xmlObjectArr;
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

            public XmlCursor cursorExecute() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur._locale.version();
                }
                List execQuery = this._engine.execQuery(this._cur.getDom(), (Map) XmlOptions.maskNull(this._options).get(XmlOptions.XQUERY_VARIABLE_MAP));
                if (!$assertionsDisabled && execQuery.size() <= -1) {
                    throw new AssertionError();
                }
                Cursor cursor = null;
                this._engine = null;
                Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
                locale.enter();
                Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
                for (int i = 0; i < execQuery.size(); i++) {
                    try {
                        loadNodeHelper(locale, (Node) execQuery.get(i), curLoadContext);
                    } catch (Exception unused) {
                        locale.exit();
                    } catch (Throwable th) {
                        locale.exit();
                        throw th;
                    }
                }
                Cur finish = curLoadContext.finish();
                Locale.associateSourceName(finish, this._options);
                Locale.autoTypeDocument(finish, null, this._options);
                Cursor cursor2 = new Cursor(finish);
                locale.exit();
                cursor = cursor2;
                release();
                return cursor;
            }

            public void release() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur.release();
                    this._cur = null;
                }
            }

            private Cur loadNode(Locale locale, Node node) {
                Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
                try {
                    loadNodeHelper(locale, node, curLoadContext);
                    Cur finish = curLoadContext.finish();
                    Locale.associateSourceName(finish, this._options);
                    Locale.autoTypeDocument(finish, null, this._options);
                    return finish;
                } catch (Exception e) {
                    throw new XmlRuntimeException(e.getMessage(), e);
                }
            }

            private void loadNodeHelper(Locale locale, Node node, Locale.LoadContext loadContext) {
                if (node.getNodeType() == 2) {
                    loadContext.attr(new QName(node.getNamespaceURI(), node.getLocalName(), node.getPrefix()), node.getNodeValue());
                } else {
                    locale.loadNode(node, loadContext);
                }
            }
        }
    }
}
