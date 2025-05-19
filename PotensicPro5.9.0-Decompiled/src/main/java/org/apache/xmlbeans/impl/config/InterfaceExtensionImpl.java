package org.apache.xmlbeans.impl.config;

import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;

/* loaded from: classes5.dex */
public class InterfaceExtensionImpl implements InterfaceExtension {
    private String _delegateToClassName;
    private String _interfaceClassName;
    private MethodSignatureImpl[] _methods;
    private NameSet _xbeanSet;

    static InterfaceExtensionImpl newInstance(JamClassLoader jamClassLoader, NameSet nameSet, Extensionconfig.Interface r5) {
        InterfaceExtensionImpl interfaceExtensionImpl = new InterfaceExtensionImpl();
        interfaceExtensionImpl._xbeanSet = nameSet;
        JClass validateInterface = validateInterface(jamClassLoader, r5.getName(), r5);
        if (validateInterface == null) {
            BindingConfigImpl.error(new StringBuffer().append("Interface '").append(r5.getStaticHandler()).append("' not found.").toString(), r5);
            return null;
        }
        interfaceExtensionImpl._interfaceClassName = validateInterface.getQualifiedName();
        String staticHandler = r5.getStaticHandler();
        interfaceExtensionImpl._delegateToClassName = staticHandler;
        JClass validateClass = validateClass(jamClassLoader, staticHandler, r5);
        if (validateClass == null) {
            BindingConfigImpl.warning(new StringBuffer().append("Handler class '").append(r5.getStaticHandler()).append("' not found on classpath, skip validation.").toString(), r5);
            return interfaceExtensionImpl;
        }
        if (interfaceExtensionImpl.validateMethods(validateInterface, validateClass, r5)) {
            return interfaceExtensionImpl;
        }
        return null;
    }

    private static JClass validateInterface(JamClassLoader jamClassLoader, String str, XmlObject xmlObject) {
        return validateJava(jamClassLoader, str, true, xmlObject);
    }

    static JClass validateClass(JamClassLoader jamClassLoader, String str, XmlObject xmlObject) {
        return validateJava(jamClassLoader, str, false, xmlObject);
    }

    static JClass validateJava(JamClassLoader jamClassLoader, String str, boolean z, XmlObject xmlObject) {
        if (jamClassLoader == null) {
            return null;
        }
        String str2 = z ? "Interface" : "Class";
        JClass loadClass = jamClassLoader.loadClass(str);
        if (loadClass == null || loadClass.isUnresolvedType()) {
            BindingConfigImpl.error(new StringBuffer().append(str2).append(" '").append(str).append("' not found.").toString(), xmlObject);
            return null;
        }
        if ((z && !loadClass.isInterface()) || (!z && loadClass.isInterface())) {
            BindingConfigImpl.error(new StringBuffer().append("'").append(str).append("' must be ").append(z ? "an interface" : "a class").append(".").toString(), xmlObject);
        }
        if (!loadClass.isPublic()) {
            BindingConfigImpl.error(new StringBuffer().append(str2).append(" '").append(str).append("' is not public.").toString(), xmlObject);
        }
        return loadClass;
    }

    private boolean validateMethods(JClass jClass, JClass jClass2, XmlObject xmlObject) {
        JMethod[] methods = jClass.getMethods();
        this._methods = new MethodSignatureImpl[methods.length];
        boolean z = true;
        for (int i = 0; i < methods.length; i++) {
            JMethod validateMethod = validateMethod(jClass, jClass2, methods[i], xmlObject);
            if (validateMethod != null) {
                this._methods[i] = new MethodSignatureImpl(getStaticHandler(), validateMethod);
            } else {
                z = false;
            }
        }
        return z;
    }

    private JMethod validateMethod(JClass jClass, JClass jClass2, JMethod jMethod, XmlObject xmlObject) {
        String simpleName = jMethod.getSimpleName();
        JParameter[] parameters = jMethod.getParameters();
        JClass returnType = jMethod.getReturnType();
        int length = parameters.length + 1;
        JClass[] jClassArr = new JClass[length];
        jClassArr[0] = returnType.forName("org.apache.xmlbeans.XmlObject");
        for (int i = 1; i < length; i++) {
            jClassArr[i] = parameters[i - 1].getType();
        }
        JMethod method = getMethod(jClass2, simpleName, jClassArr);
        if (method == null) {
            BindingConfigImpl.error(new StringBuffer().append("Handler class '").append(jClass2.getQualifiedName()).append("' does not contain method ").append(simpleName).append("(").append(listTypes(jClassArr)).append(")").toString(), xmlObject);
            return null;
        }
        JClass[] exceptionTypes = jMethod.getExceptionTypes();
        JClass[] exceptionTypes2 = method.getExceptionTypes();
        if (exceptionTypes2.length != exceptionTypes.length) {
            BindingConfigImpl.error(new StringBuffer().append("Handler method '").append(jClass2.getQualifiedName()).append(".").append(simpleName).append("(").append(listTypes(jClassArr)).append(")' must declare the same exceptions as the interface method '").append(jClass.getQualifiedName()).append(".").append(simpleName).append("(").append(listTypes(parameters)).toString(), xmlObject);
            return null;
        }
        for (int i2 = 0; i2 < exceptionTypes2.length; i2++) {
            if (exceptionTypes2[i2] != exceptionTypes[i2]) {
                BindingConfigImpl.error(new StringBuffer().append("Handler method '").append(jClass2.getQualifiedName()).append(".").append(simpleName).append("(").append(listTypes(jClassArr)).append(")' must declare the same exceptions as the interface method '").append(jClass.getQualifiedName()).append(".").append(simpleName).append("(").append(listTypes(parameters)).toString(), xmlObject);
                return null;
            }
        }
        if (!method.isPublic() || !method.isStatic()) {
            BindingConfigImpl.error(new StringBuffer().append("Method '").append(jClass2.getQualifiedName()).append(".").append(simpleName).append("(").append(listTypes(jClassArr)).append(")' must be declared public and static.").toString(), xmlObject);
            return null;
        }
        if (returnType.equals(method.getReturnType())) {
            return jMethod;
        }
        BindingConfigImpl.error(new StringBuffer().append("Return type for method '").append(method.getReturnType()).append(StringUtils.SPACE).append(jClass2.getQualifiedName()).append(".").append(simpleName).append("(").append(listTypes(jClassArr)).append(")' does not match the return type of the interface method :'").append(returnType).append("'.").toString(), xmlObject);
        return null;
    }

    static JMethod getMethod(JClass jClass, String str, JClass[] jClassArr) {
        for (JMethod jMethod : jClass.getMethods()) {
            if (str.equals(jMethod.getSimpleName())) {
                JParameter[] parameters = jMethod.getParameters();
                if (parameters.length == jClassArr.length) {
                    for (int i = 0; i < parameters.length; i++) {
                        parameters[i].getType().equals(jClassArr[i]);
                    }
                    return jMethod;
                }
            }
        }
        return null;
    }

    private static String listTypes(JClass[] jClassArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jClassArr.length; i++) {
            JClass jClass = jClassArr[i];
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(emitType(jClass));
        }
        return stringBuffer.toString();
    }

    private static String listTypes(JParameter[] jParameterArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jParameterArr.length; i++) {
            JClass type = jParameterArr[i].getType();
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(emitType(type));
        }
        return stringBuffer.toString();
    }

    public static String emitType(JClass jClass) {
        if (jClass.isArrayType()) {
            return new StringBuffer().append(emitType(jClass.getArrayComponentType())).append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI).toString();
        }
        return jClass.getQualifiedName().replace('$', '.');
    }

    public boolean contains(String str) {
        return this._xbeanSet.contains(str);
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public String getStaticHandler() {
        return this._delegateToClassName;
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public String getInterface() {
        return this._interfaceClassName;
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public InterfaceExtension.MethodSignature[] getMethods() {
        return this._methods;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("  static handler: ").append(this._delegateToClassName).append("\n");
        stringBuffer.append("  interface: ").append(this._interfaceClassName).append("\n");
        stringBuffer.append("  name set: ").append(this._xbeanSet).append("\n");
        for (int i = 0; i < this._methods.length; i++) {
            stringBuffer.append("  method[").append(i).append("]=").append(this._methods[i]).append("\n");
        }
        return stringBuffer.toString();
    }

    static class MethodSignatureImpl implements InterfaceExtension.MethodSignature {
        private final int NOTINITIALIZED = -1;
        private String[] _exceptions;
        private int _hashCode;
        private String _intfName;
        private String _name;
        private String[] _params;
        private String _return;
        private String _signature;

        MethodSignatureImpl(String str, JMethod jMethod) {
            this._hashCode = -1;
            if (str == null || jMethod == null) {
                throw new IllegalArgumentException(new StringBuffer().append("Interface: ").append(str).append(" method: ").append(jMethod).toString());
            }
            this._intfName = str;
            this._hashCode = -1;
            this._signature = null;
            this._name = jMethod.getSimpleName();
            this._return = jMethod.getReturnType().getQualifiedName().replace('$', '.');
            JParameter[] parameters = jMethod.getParameters();
            this._params = new String[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                this._params[i] = parameters[i].getType().getQualifiedName().replace('$', '.');
            }
            JClass[] exceptionTypes = jMethod.getExceptionTypes();
            this._exceptions = new String[exceptionTypes.length];
            for (int i2 = 0; i2 < exceptionTypes.length; i2++) {
                this._exceptions[i2] = exceptionTypes[i2].getQualifiedName().replace('$', '.');
            }
        }

        String getInterfaceName() {
            return this._intfName;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String getName() {
            return this._name;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String getReturnType() {
            return this._return;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getParameterTypes() {
            return this._params;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getExceptionTypes() {
            return this._exceptions;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodSignatureImpl)) {
                return false;
            }
            MethodSignatureImpl methodSignatureImpl = (MethodSignatureImpl) obj;
            if (!methodSignatureImpl.getName().equals(getName())) {
                return false;
            }
            String[] parameterTypes = getParameterTypes();
            String[] parameterTypes2 = methodSignatureImpl.getParameterTypes();
            if (parameterTypes2.length != parameterTypes.length) {
                return false;
            }
            for (int i = 0; i < parameterTypes.length; i++) {
                if (!parameterTypes2[i].equals(parameterTypes[i])) {
                    return false;
                }
            }
            return this._intfName.equals(methodSignatureImpl._intfName);
        }

        public int hashCode() {
            int i = this._hashCode;
            if (i != -1) {
                return i;
            }
            int hashCode = getName().hashCode();
            for (String str : getParameterTypes()) {
                hashCode = (hashCode * 19) + str.hashCode();
            }
            int hashCode2 = hashCode + (this._intfName.hashCode() * 21);
            this._hashCode = hashCode2;
            return hashCode2;
        }

        String getSignature() {
            String str = this._signature;
            if (str != null) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append(this._name).append("(");
            int i = 0;
            while (i < this._params.length) {
                stringBuffer.append(i == 0 ? "" : " ,").append(this._params[i]);
                i++;
            }
            stringBuffer.append(")");
            String stringBuffer2 = stringBuffer.toString();
            this._signature = stringBuffer2;
            return stringBuffer2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getReturnType()).append(StringUtils.SPACE).append(getSignature());
            return stringBuffer.toString();
        }
    }
}
