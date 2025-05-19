package org.apache.xmlbeans.impl.config;

import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;

/* loaded from: classes5.dex */
public class PrePostExtensionImpl implements PrePostExtension {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static JClass[] PARAMTYPES_PREPOST;
    private static final String[] PARAMTYPES_STRING;
    private static final String SIGNATURE;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$config$PrePostExtensionImpl;
    private JClass _delegateToClass;
    private String _delegateToClassName;
    private JMethod _postSet;
    private JMethod _preSet;
    private NameSet _xbeanSet;

    static {
        if (class$org$apache$xmlbeans$impl$config$PrePostExtensionImpl == null) {
            class$org$apache$xmlbeans$impl$config$PrePostExtensionImpl = class$("org.apache.xmlbeans.impl.config.PrePostExtensionImpl");
        }
        $assertionsDisabled = true;
        PARAMTYPES_PREPOST = null;
        PARAMTYPES_STRING = new String[]{XmlErrorCodes.INT, "org.apache.xmlbeans.XmlObject", "javax.xml.namespace.QName", XmlErrorCodes.BOOLEAN, XmlErrorCodes.INT};
        int i = 0;
        String str = "(";
        while (true) {
            String[] strArr = PARAMTYPES_STRING;
            if (i < strArr.length) {
                String str2 = strArr[i];
                if (i != 0) {
                    str = new StringBuffer().append(str).append(", ").toString();
                }
                str = new StringBuffer().append(str).append(str2).toString();
                i++;
            } else {
                SIGNATURE = new StringBuffer().append(str).append(")").toString();
                return;
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

    static PrePostExtensionImpl newInstance(JamClassLoader jamClassLoader, NameSet nameSet, Extensionconfig.PrePostSet prePostSet) {
        if (prePostSet == null) {
            return null;
        }
        PrePostExtensionImpl prePostExtensionImpl = new PrePostExtensionImpl();
        prePostExtensionImpl._xbeanSet = nameSet;
        String staticHandler = prePostSet.getStaticHandler();
        prePostExtensionImpl._delegateToClassName = staticHandler;
        JClass validateClass = InterfaceExtensionImpl.validateClass(jamClassLoader, staticHandler, prePostSet);
        prePostExtensionImpl._delegateToClass = validateClass;
        if (validateClass == null) {
            BindingConfigImpl.warning(new StringBuffer().append("Handler class '").append(prePostSet.getStaticHandler()).append("' not found on classpath, skip validation.").toString(), prePostSet);
            return prePostExtensionImpl;
        }
        if (prePostExtensionImpl.lookAfterPreAndPost(jamClassLoader, prePostSet)) {
            return prePostExtensionImpl;
        }
        return null;
    }

    private boolean lookAfterPreAndPost(JamClassLoader jamClassLoader, XmlObject xmlObject) {
        if (!$assertionsDisabled && this._delegateToClass == null) {
            throw new AssertionError("Delegate to class handler expected.");
        }
        initParamPrePost(jamClassLoader);
        JMethod method = InterfaceExtensionImpl.getMethod(this._delegateToClass, "preSet", PARAMTYPES_PREPOST);
        this._preSet = method;
        if (method != null && !method.getReturnType().equals(jamClassLoader.loadClass(XmlErrorCodes.BOOLEAN))) {
            BindingConfigImpl.warning(new StringBuffer().append("Method '").append(this._delegateToClass.getSimpleName()).append(".preSet").append(SIGNATURE).append("' ").append("should return boolean to be considered for a preSet handler.").toString(), xmlObject);
            this._preSet = null;
        }
        JMethod method2 = InterfaceExtensionImpl.getMethod(this._delegateToClass, "postSet", PARAMTYPES_PREPOST);
        this._postSet = method2;
        if (this._preSet != null || method2 != null) {
            return true;
        }
        StringBuffer append = new StringBuffer().append("prePostSet handler specified '").append(this._delegateToClass.getSimpleName()).append("' but no preSet");
        String str = SIGNATURE;
        BindingConfigImpl.error(append.append(str).append(" or ").append("postSet").append(str).append(" methods found.").toString(), xmlObject);
        return false;
    }

    private void initParamPrePost(JamClassLoader jamClassLoader) {
        if (PARAMTYPES_PREPOST != null) {
            return;
        }
        PARAMTYPES_PREPOST = new JClass[PARAMTYPES_STRING.length];
        int i = 0;
        while (true) {
            JClass[] jClassArr = PARAMTYPES_PREPOST;
            if (i >= jClassArr.length) {
                return;
            }
            jClassArr[i] = jamClassLoader.loadClass(PARAMTYPES_STRING[i]);
            if (PARAMTYPES_PREPOST[i] == null) {
                throw new IllegalStateException(new StringBuffer().append("JAM should have access to the following types ").append(SIGNATURE).toString());
            }
            i++;
        }
    }

    public NameSet getNameSet() {
        return this._xbeanSet;
    }

    public boolean contains(String str) {
        return this._xbeanSet.contains(str);
    }

    @Override // org.apache.xmlbeans.PrePostExtension
    public boolean hasPreCall() {
        return this._preSet != null;
    }

    @Override // org.apache.xmlbeans.PrePostExtension
    public boolean hasPostCall() {
        return this._postSet != null;
    }

    @Override // org.apache.xmlbeans.PrePostExtension
    public String getStaticHandler() {
        return this._delegateToClassName;
    }

    public String getHandlerNameForJavaSource() {
        JClass jClass = this._delegateToClass;
        if (jClass == null) {
            return null;
        }
        return InterfaceExtensionImpl.emitType(jClass);
    }

    boolean hasNameSetIntersection(PrePostExtensionImpl prePostExtensionImpl) {
        return !NameSet.EMPTY.equals(this._xbeanSet.intersect(prePostExtensionImpl._xbeanSet));
    }
}
