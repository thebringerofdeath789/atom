package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes4.dex */
public class MappedPropertyDescriptor extends PropertyDescriptor {
    private static final Class<?>[] STRING_CLASS_PARAMETER = {String.class};
    private Reference<Class<?>> mappedPropertyTypeRef;
    private MappedMethodReference mappedReadMethodRef;
    private MappedMethodReference mappedWriteMethodRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MappedPropertyDescriptor(String str, Class<?> cls) throws IntrospectionException {
        super(str, (Method) null, (Method) null);
        Method method;
        Method method2 = null;
        if (str == null || str.length() == 0) {
            throw new IntrospectionException("bad property name: " + str + " on class: " + cls.getClass().getName());
        }
        setName(str);
        String capitalizePropertyName = capitalizePropertyName(str);
        try {
            try {
                method = getMethod(cls, "get" + capitalizePropertyName, STRING_CLASS_PARAMETER);
            } catch (IntrospectionException unused) {
                method = null;
            }
        } catch (IntrospectionException unused2) {
            method = getMethod(cls, "is" + capitalizePropertyName, STRING_CLASS_PARAMETER);
        }
        try {
            method2 = getMethod(cls, FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX + capitalizePropertyName, (Class<?>[]) new Class[]{String.class, method.getReturnType()});
        } catch (IntrospectionException unused3) {
        }
        method2 = method == null ? getMethod(cls, FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX + capitalizePropertyName, 2) : method2;
        if (method == null && method2 == null) {
            throw new IntrospectionException("Property '" + str + "' not found on " + cls.getName());
        }
        this.mappedReadMethodRef = new MappedMethodReference(method);
        this.mappedWriteMethodRef = new MappedMethodReference(method2);
        findMappedPropertyType();
    }

    public MappedPropertyDescriptor(String str, Class<?> cls, String str2, String str3) throws IntrospectionException {
        super(str, (Method) null, (Method) null);
        Method method;
        if (str == null || str.length() == 0) {
            throw new IntrospectionException("bad property name: " + str);
        }
        setName(str);
        Method method2 = getMethod(cls, str2, STRING_CLASS_PARAMETER);
        if (method2 != null) {
            method = getMethod(cls, str3, (Class<?>[]) new Class[]{String.class, method2.getReturnType()});
        } else {
            method = getMethod(cls, str3, 2);
        }
        this.mappedReadMethodRef = new MappedMethodReference(method2);
        this.mappedWriteMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    public MappedPropertyDescriptor(String str, Method method, Method method2) throws IntrospectionException {
        super(str, method, method2);
        if (str == null || str.length() == 0) {
            throw new IntrospectionException("bad property name: " + str);
        }
        setName(str);
        this.mappedReadMethodRef = new MappedMethodReference(method);
        this.mappedWriteMethodRef = new MappedMethodReference(method2);
        findMappedPropertyType();
    }

    public Class<?> getMappedPropertyType() {
        return this.mappedPropertyTypeRef.get();
    }

    public Method getMappedReadMethod() {
        return this.mappedReadMethodRef.get();
    }

    public void setMappedReadMethod(Method method) throws IntrospectionException {
        this.mappedReadMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    public Method getMappedWriteMethod() {
        return this.mappedWriteMethodRef.get();
    }

    public void setMappedWriteMethod(Method method) throws IntrospectionException {
        this.mappedWriteMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    private void findMappedPropertyType() throws IntrospectionException {
        try {
            Method mappedReadMethod = getMappedReadMethod();
            Method mappedWriteMethod = getMappedWriteMethod();
            Class<?> cls = null;
            if (mappedReadMethod != null) {
                if (mappedReadMethod.getParameterTypes().length != 1) {
                    throw new IntrospectionException("bad mapped read method arg count");
                }
                cls = mappedReadMethod.getReturnType();
                if (cls == Void.TYPE) {
                    throw new IntrospectionException("mapped read method " + mappedReadMethod.getName() + " returns void");
                }
            }
            if (mappedWriteMethod != null) {
                Class<?>[] parameterTypes = mappedWriteMethod.getParameterTypes();
                if (parameterTypes.length != 2) {
                    throw new IntrospectionException("bad mapped write method arg count");
                }
                if (cls != null && cls != parameterTypes[1]) {
                    throw new IntrospectionException("type mismatch between mapped read and write methods");
                }
                cls = parameterTypes[1];
            }
            this.mappedPropertyTypeRef = new SoftReference(cls);
        } catch (IntrospectionException e) {
            throw e;
        }
    }

    private static String capitalizePropertyName(String str) {
        if (str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }

    private static Method internalGetMethod(Class<?> cls, String str, int i) {
        Class<?> cls2 = cls;
        while (true) {
            int i2 = 0;
            if (cls2 != null) {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                int length = declaredMethods.length;
                while (i2 < length) {
                    Method method = declaredMethods[i2];
                    if (method != null) {
                        int modifiers = method.getModifiers();
                        if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers) && method.getName().equals(str) && method.getParameterTypes().length == i) {
                            return method;
                        }
                    }
                    i2++;
                }
                cls2 = cls2.getSuperclass();
            } else {
                Class<?>[] interfaces = cls.getInterfaces();
                int length2 = interfaces.length;
                while (i2 < length2) {
                    Method internalGetMethod = internalGetMethod(interfaces[i2], str, i);
                    if (internalGetMethod != null) {
                        return internalGetMethod;
                    }
                    i2++;
                }
                return null;
            }
        }
    }

    private static Method getMethod(Class<?> cls, String str, int i) throws IntrospectionException {
        if (str == null) {
            return null;
        }
        Method internalGetMethod = internalGetMethod(cls, str, i);
        if (internalGetMethod != null) {
            return internalGetMethod;
        }
        throw new IntrospectionException("No method \"" + str + "\" with " + i + " parameter(s)");
    }

    private static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) throws IntrospectionException {
        if (str == null) {
            return null;
        }
        Method matchingAccessibleMethod = MethodUtils.getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod;
        }
        throw new IntrospectionException("No method \"" + str + "\" with " + (clsArr == null ? 0 : clsArr.length) + " parameter(s) of matching types.");
    }

    private static class MappedMethodReference {
        private String className;
        private Reference<Class<?>> classRef;
        private String methodName;
        private Reference<Method> methodRef;
        private String[] writeParamClassNames;
        private Reference<Class<?>> writeParamTypeRef0;
        private Reference<Class<?>> writeParamTypeRef1;

        MappedMethodReference(Method method) {
            if (method != null) {
                this.className = method.getDeclaringClass().getName();
                this.methodName = method.getName();
                this.methodRef = new SoftReference(method);
                this.classRef = new WeakReference(method.getDeclaringClass());
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2) {
                    this.writeParamTypeRef0 = new WeakReference(parameterTypes[0]);
                    this.writeParamTypeRef1 = new WeakReference(parameterTypes[1]);
                    String[] strArr = new String[2];
                    this.writeParamClassNames = strArr;
                    strArr[0] = parameterTypes[0].getName();
                    this.writeParamClassNames[1] = parameterTypes[1].getName();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Method get() {
            Class<?>[] clsArr;
            Reference<Method> reference = this.methodRef;
            if (reference == null) {
                return null;
            }
            Method method = reference.get();
            if (method == null) {
                Class<?> cls = this.classRef.get();
                if (cls == null && (cls = reLoadClass()) != null) {
                    this.classRef = new WeakReference(cls);
                }
                if (cls == null) {
                    throw new RuntimeException("Method " + this.methodName + " for " + this.className + " could not be reconstructed - class reference has gone");
                }
                if (this.writeParamClassNames == null) {
                    clsArr = MappedPropertyDescriptor.STRING_CLASS_PARAMETER;
                } else {
                    clsArr = new Class[2];
                    clsArr[0] = this.writeParamTypeRef0.get();
                    if (clsArr[0] == null) {
                        clsArr[0] = reLoadClass(this.writeParamClassNames[0]);
                        if (clsArr[0] != null) {
                            this.writeParamTypeRef0 = new WeakReference(clsArr[0]);
                        }
                    }
                    clsArr[1] = this.writeParamTypeRef1.get();
                    if (clsArr[1] == null) {
                        clsArr[1] = reLoadClass(this.writeParamClassNames[1]);
                        if (clsArr[1] != null) {
                            this.writeParamTypeRef1 = new WeakReference(clsArr[1]);
                        }
                    }
                }
                try {
                    method = cls.getMethod(this.methodName, clsArr);
                    this.methodRef = new SoftReference(method);
                } catch (NoSuchMethodException unused) {
                    throw new RuntimeException("Method " + this.methodName + " for " + this.className + " could not be reconstructed - method not found");
                }
            }
            return method;
        }

        private Class<?> reLoadClass() {
            return reLoadClass(this.className);
        }

        private Class<?> reLoadClass(String str) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                try {
                    return contextClassLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            try {
                return MappedPropertyDescriptor.class.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
    }
}
