package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public final class XmlBeans {
    private static final String HOLDER_CLASS_NAME = "TypeSystemHolder";
    public static SchemaType NO_TYPE = null;
    private static final String TYPE_SYSTEM_FIELD = "typeSystem";
    private static String XMLBEANS_TITLE = "org.apache.xmlbeans";
    private static String XMLBEANS_VENDOR = "Apache Software Foundation";
    private static String XMLBEANS_VERSION = "2.6.0";
    private static final Method _compilationMethod;
    private static final Method _getBuiltinSchemaTypeSystemMethod;
    private static final Method _getContextTypeLoaderMethod;
    private static final Method _getNoTypeMethod;
    private static final Method _nodeToCursorMethod;
    private static final Method _nodeToXmlObjectMethod;
    private static final Method _nodeToXmlStreamMethod;
    private static final Constructor _pathResourceLoaderConstructor;
    private static final Method _streamToNodeMethod;
    private static final ThreadLocal _threadLocalLoaderQNameCache;
    private static final Method _typeLoaderBuilderMethod;
    static /* synthetic */ Class array$Ljava$io$File;
    static /* synthetic */ Class array$Lorg$apache$xmlbeans$SchemaTypeLoader;
    static /* synthetic */ Class array$Lorg$apache$xmlbeans$XmlObject;
    static /* synthetic */ Class class$java$lang$ClassLoader;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$javax$xml$stream$XMLStreamReader;
    static /* synthetic */ Class class$org$apache$xmlbeans$BindingConfig;
    static /* synthetic */ Class class$org$apache$xmlbeans$Filer;
    static /* synthetic */ Class class$org$apache$xmlbeans$ResourceLoader;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaTypeLoader;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaTypeSystem;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlBeans;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlObject;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlOptions;
    static /* synthetic */ Class class$org$w3c$dom$Node;

    static {
        Class cls = class$org$apache$xmlbeans$XmlBeans;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.XmlBeans");
            class$org$apache$xmlbeans$XmlBeans = cls;
        }
        Package r0 = cls.getPackage();
        if (r0 != null) {
            XMLBEANS_TITLE = r0.getImplementationTitle();
            XMLBEANS_VERSION = r0.getImplementationVersion();
            XMLBEANS_VENDOR = r0.getImplementationVendor();
        }
        _threadLocalLoaderQNameCache = new ThreadLocal() { // from class: org.apache.xmlbeans.XmlBeans.1
            @Override // java.lang.ThreadLocal
            protected Object initialValue() {
                return new SoftReference(new QNameCache(32));
            }
        };
        _getContextTypeLoaderMethod = buildGetContextTypeLoaderMethod();
        _getBuiltinSchemaTypeSystemMethod = buildGetBuiltinSchemaTypeSystemMethod();
        _getNoTypeMethod = buildGetNoTypeMethod();
        _typeLoaderBuilderMethod = buildTypeLoaderBuilderMethod();
        _compilationMethod = buildCompilationMethod();
        _nodeToCursorMethod = buildNodeToCursorMethod();
        _nodeToXmlObjectMethod = buildNodeToXmlObjectMethod();
        _nodeToXmlStreamMethod = buildNodeToXmlStreamMethod();
        _streamToNodeMethod = buildStreamToNodeMethod();
        _pathResourceLoaderConstructor = buildPathResourceLoaderConstructor();
        NO_TYPE = getNoType();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static final String getTitle() {
        return XMLBEANS_TITLE;
    }

    public static final String getVendor() {
        return XMLBEANS_VENDOR;
    }

    public static final String getVersion() {
        return XMLBEANS_VERSION;
    }

    public static QNameCache getQNameCache() {
        ThreadLocal threadLocal = _threadLocalLoaderQNameCache;
        QNameCache qNameCache = (QNameCache) ((SoftReference) threadLocal.get()).get();
        if (qNameCache != null) {
            return qNameCache;
        }
        QNameCache qNameCache2 = new QNameCache(32);
        threadLocal.set(new SoftReference(qNameCache2));
        return qNameCache2;
    }

    public static QName getQName(String str) {
        return getQNameCache().getName("", str);
    }

    public static QName getQName(String str, String str2) {
        return getQNameCache().getName(str, str2);
    }

    private static RuntimeException causedException(RuntimeException runtimeException, Throwable th) {
        runtimeException.initCause(th);
        return runtimeException;
    }

    private static XmlException wrappedException(Throwable th) {
        if (th instanceof XmlException) {
            return (XmlException) th;
        }
        return new XmlException(th.getMessage(), th);
    }

    private static final Constructor buildConstructor(String str, Class[] clsArr) {
        try {
            Class cls = class$org$apache$xmlbeans$XmlBeans;
            if (cls == null) {
                cls = class$("org.apache.xmlbeans.XmlBeans");
                class$org$apache$xmlbeans$XmlBeans = cls;
            }
            return Class.forName(str, false, cls.getClassLoader()).getConstructor(clsArr);
        } catch (Exception e) {
            throw causedException(new IllegalStateException(new StringBuffer().append("Cannot load constructor for ").append(str).append(": verify that xbean.jar is on the classpath").toString()), e);
        }
    }

    private static final Method buildMethod(String str, String str2, Class[] clsArr) {
        try {
            Class cls = class$org$apache$xmlbeans$XmlBeans;
            if (cls == null) {
                cls = class$("org.apache.xmlbeans.XmlBeans");
                class$org$apache$xmlbeans$XmlBeans = cls;
            }
            return Class.forName(str, false, cls.getClassLoader()).getMethod(str2, clsArr);
        } catch (Exception e) {
            throw causedException(new IllegalStateException(new StringBuffer().append("Cannot load ").append(str2).append(": verify that xbean.jar is on the classpath").toString()), e);
        }
    }

    private static final Method buildNoArgMethod(String str, String str2) {
        return buildMethod(str, str2, new Class[0]);
    }

    private static final Method buildNodeMethod(String str, String str2) {
        Class[] clsArr = new Class[1];
        Class cls = class$org$w3c$dom$Node;
        if (cls == null) {
            cls = class$("org.w3c.dom.Node");
            class$org$w3c$dom$Node = cls;
        }
        clsArr[0] = cls;
        return buildMethod(str, str2, clsArr);
    }

    private static Method buildGetContextTypeLoaderMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "getContextTypeLoader");
    }

    private static final Method buildGetBuiltinSchemaTypeSystemMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "get");
    }

    private static final Method buildGetNoTypeMethod() {
        return buildNoArgMethod("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem", "getNoType");
    }

    private static final Method buildTypeLoaderBuilderMethod() {
        Class[] clsArr = new Class[3];
        Class cls = array$Lorg$apache$xmlbeans$SchemaTypeLoader;
        if (cls == null) {
            cls = class$("[Lorg.apache.xmlbeans.SchemaTypeLoader;");
            array$Lorg$apache$xmlbeans$SchemaTypeLoader = cls;
        }
        clsArr[0] = cls;
        Class cls2 = class$org$apache$xmlbeans$ResourceLoader;
        if (cls2 == null) {
            cls2 = class$("org.apache.xmlbeans.ResourceLoader");
            class$org$apache$xmlbeans$ResourceLoader = cls2;
        }
        clsArr[1] = cls2;
        Class cls3 = class$java$lang$ClassLoader;
        if (cls3 == null) {
            cls3 = class$("java.lang.ClassLoader");
            class$java$lang$ClassLoader = cls3;
        }
        clsArr[2] = cls3;
        return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl", "build", clsArr);
    }

    private static final Method buildCompilationMethod() {
        Class[] clsArr = new Class[7];
        Class cls = class$java$lang$String;
        if (cls == null) {
            cls = class$("java.lang.String");
            class$java$lang$String = cls;
        }
        clsArr[0] = cls;
        Class cls2 = class$org$apache$xmlbeans$SchemaTypeSystem;
        if (cls2 == null) {
            cls2 = class$("org.apache.xmlbeans.SchemaTypeSystem");
            class$org$apache$xmlbeans$SchemaTypeSystem = cls2;
        }
        clsArr[1] = cls2;
        Class cls3 = array$Lorg$apache$xmlbeans$XmlObject;
        if (cls3 == null) {
            cls3 = class$("[Lorg.apache.xmlbeans.XmlObject;");
            array$Lorg$apache$xmlbeans$XmlObject = cls3;
        }
        clsArr[2] = cls3;
        Class cls4 = class$org$apache$xmlbeans$BindingConfig;
        if (cls4 == null) {
            cls4 = class$("org.apache.xmlbeans.BindingConfig");
            class$org$apache$xmlbeans$BindingConfig = cls4;
        }
        clsArr[3] = cls4;
        Class cls5 = class$org$apache$xmlbeans$SchemaTypeLoader;
        if (cls5 == null) {
            cls5 = class$("org.apache.xmlbeans.SchemaTypeLoader");
            class$org$apache$xmlbeans$SchemaTypeLoader = cls5;
        }
        clsArr[4] = cls5;
        Class cls6 = class$org$apache$xmlbeans$Filer;
        if (cls6 == null) {
            cls6 = class$("org.apache.xmlbeans.Filer");
            class$org$apache$xmlbeans$Filer = cls6;
        }
        clsArr[5] = cls6;
        Class cls7 = class$org$apache$xmlbeans$XmlOptions;
        if (cls7 == null) {
            cls7 = class$("org.apache.xmlbeans.XmlOptions");
            class$org$apache$xmlbeans$XmlOptions = cls7;
        }
        clsArr[6] = cls7;
        return buildMethod("org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler", "compile", clsArr);
    }

    private static final Method buildNodeToCursorMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToCursor");
    }

    private static final Method buildNodeToXmlObjectMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlObject");
    }

    private static final Method buildNodeToXmlStreamMethod() {
        return buildNodeMethod("org.apache.xmlbeans.impl.store.Locale", "nodeToXmlStream");
    }

    private static final Method buildStreamToNodeMethod() {
        Class[] clsArr = new Class[1];
        Class cls = class$javax$xml$stream$XMLStreamReader;
        if (cls == null) {
            cls = class$("aavax.xml.stream.XMLStreamReader");
            class$javax$xml$stream$XMLStreamReader = cls;
        }
        clsArr[0] = cls;
        return buildMethod("org.apache.xmlbeans.impl.store.Locale", "streamToNode", clsArr);
    }

    private static final Constructor buildPathResourceLoaderConstructor() {
        Class[] clsArr = new Class[1];
        Class cls = array$Ljava$io$File;
        if (cls == null) {
            cls = class$("[Ljava.io.File;");
            array$Ljava$io$File = cls;
        }
        clsArr[0] = cls;
        return buildConstructor("org.apache.xmlbeans.impl.schema.PathResourceLoader", clsArr);
    }

    public static String compilePath(String str) throws XmlException {
        return compilePath(str, null);
    }

    public static String compilePath(String str, XmlOptions xmlOptions) throws XmlException {
        return getContextTypeLoader().compilePath(str, xmlOptions);
    }

    public static String compileQuery(String str) throws XmlException {
        return compileQuery(str, null);
    }

    public static String compileQuery(String str, XmlOptions xmlOptions) throws XmlException {
        return getContextTypeLoader().compileQuery(str, xmlOptions);
    }

    public static SchemaTypeLoader getContextTypeLoader() {
        try {
            return (SchemaTypeLoader) _getContextTypeLoaderMethod.invoke(null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeSystem getBuiltinTypeSystem() {
        try {
            return (SchemaTypeSystem) _getBuiltinSchemaTypeSystemMethod.invoke(null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to BuiltinSchemaTypeSystem.get(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XmlCursor nodeToCursor(Node node) {
        try {
            return (XmlCursor) _nodeToCursorMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToCursor verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XmlObject nodeToXmlObject(Node node) {
        try {
            return (XmlObject) _nodeToXmlObjectMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToXmlObject verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static XMLStreamReader nodeToXmlStreamReader(Node node) {
        try {
            return (XMLStreamReader) _nodeToXmlStreamMethod.invoke(null, node);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to nodeToXmlStreamReader verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        try {
            return (Node) _streamToNodeMethod.invoke(null, xMLStreamReader);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to streamToNode verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader loadXsd(XmlObject[] xmlObjectArr) throws XmlException {
        return loadXsd(xmlObjectArr, null);
    }

    public static SchemaTypeLoader loadXsd(XmlObject[] xmlObjectArr, XmlOptions xmlOptions) throws XmlException {
        try {
            SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem) _compilationMethod.invoke(null, null, null, xmlObjectArr, null, getContextTypeLoader(), null, xmlOptions);
            if (schemaTypeSystem == null) {
                return null;
            }
            return typeLoaderUnion(new SchemaTypeLoader[]{schemaTypeSystem, getContextTypeLoader()});
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            throw wrappedException(e2.getCause());
        }
    }

    public static SchemaTypeSystem compileXsd(XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) throws XmlException {
        return compileXmlBeans(null, null, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static SchemaTypeSystem compileXsd(SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) throws XmlException {
        return compileXmlBeans(null, schemaTypeSystem, xmlObjectArr, null, schemaTypeLoader, null, xmlOptions);
    }

    public static SchemaTypeSystem compileXmlBeans(String str, SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, Filer filer, XmlOptions xmlOptions) throws XmlException {
        try {
            Method method = _compilationMethod;
            Object[] objArr = new Object[7];
            objArr[0] = str;
            objArr[1] = schemaTypeSystem;
            objArr[2] = xmlObjectArr;
            objArr[3] = bindingConfig;
            if (schemaTypeLoader == null) {
                schemaTypeLoader = getContextTypeLoader();
            }
            objArr[4] = schemaTypeLoader;
            objArr[5] = filer;
            objArr[6] = xmlOptions;
            return (SchemaTypeSystem) method.invoke(null, objArr);
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("No access to SchemaTypeLoaderImpl.forSchemaXml(): verify that version of xbean.jar is correct");
        } catch (InvocationTargetException e) {
            throw wrappedException(e.getCause());
        }
    }

    public static SchemaTypeLoader typeLoaderUnion(SchemaTypeLoader[] schemaTypeLoaderArr) {
        try {
            return schemaTypeLoaderArr.length == 1 ? schemaTypeLoaderArr[0] : (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, schemaTypeLoaderArr, null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader typeLoaderForClassLoader(ClassLoader classLoader) {
        try {
            return (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, null, null, classLoader);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeLoader typeLoaderForResource(ResourceLoader resourceLoader) {
        try {
            return (SchemaTypeLoader) _typeLoaderBuilderMethod.invoke(null, null, resourceLoader, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaTypeSystem typeSystemForClassLoader(ClassLoader classLoader, String str) {
        try {
            SchemaTypeSystem schemaTypeSystem = (SchemaTypeSystem) classLoader.loadClass(new StringBuffer().append(str).append(".").append("TypeSystemHolder").toString()).getDeclaredField(TYPE_SYSTEM_FIELD).get(null);
            if (schemaTypeSystem != null) {
                return schemaTypeSystem;
            }
            throw new RuntimeException(new StringBuffer().append("SchemaTypeSystem is null for field typeSystem on class with name ").append(str).append(".").append("TypeSystemHolder").append(". Please verify the version of xbean.jar is correct.").toString());
        } catch (ClassNotFoundException e) {
            throw causedException(new RuntimeException(new StringBuffer().append("Cannot load SchemaTypeSystem. Unable to load class with name ").append(str).append(".").append("TypeSystemHolder").append(". Make sure the generated binary files are on the classpath.").toString()), e);
        } catch (IllegalAccessException e2) {
            throw causedException(new RuntimeException(new StringBuffer().append("Field typeSystem on class ").append(str).append(".").append("TypeSystemHolder").append("is not accessible. Please verify the version of xbean.jar is correct.").toString()), e2);
        } catch (NoSuchFieldException e3) {
            throw causedException(new RuntimeException(new StringBuffer().append("Cannot find field typeSystem on class ").append(str).append(".").append("TypeSystemHolder").append(". Please verify the version of xbean.jar is correct.").toString()), e3);
        }
    }

    public static ResourceLoader resourceLoaderForPath(File[] fileArr) {
        try {
            return (ResourceLoader) _pathResourceLoaderConstructor.newInstance(fileArr);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl: verify that version of xbean.jar is correct"), e);
        } catch (InstantiationException e2) {
            throw causedException(new IllegalStateException(e2.getMessage()), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    public static SchemaType typeForClass(Class cls) {
        if (cls != null) {
            Class cls2 = class$org$apache$xmlbeans$XmlObject;
            if (cls2 == null) {
                cls2 = class$("org.apache.xmlbeans.XmlObject");
                class$org$apache$xmlbeans$XmlObject = cls2;
            }
            if (cls2.isAssignableFrom(cls)) {
                try {
                    Field field = cls.getField("type");
                    if (field == null) {
                        return null;
                    }
                    return (SchemaType) field.get(null);
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    private static SchemaType getNoType() {
        try {
            return (SchemaType) _getNoTypeMethod.invoke(null, null);
        } catch (IllegalAccessException e) {
            throw causedException(new IllegalStateException("No access to SchemaTypeLoaderImpl.getContextTypeLoader(): verify that version of xbean.jar is correct"), e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        }
    }

    private XmlBeans() {
    }
}
