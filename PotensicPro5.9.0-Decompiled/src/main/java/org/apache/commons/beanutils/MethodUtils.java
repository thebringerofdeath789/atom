package org.apache.commons.beanutils;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class MethodUtils {
    private static boolean CACHE_METHODS = true;
    private static final Class<?>[] EMPTY_CLASS_PARAMETERS = new Class[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static final Map<MethodDescriptor, Reference<Method>> cache = Collections.synchronizedMap(new WeakHashMap());
    private static boolean loggedAccessibleWarning = false;

    private static Object[] toArray(Object obj) {
        if (obj != null) {
            return new Object[]{obj};
        }
        return null;
    }

    public static synchronized void setCacheMethods(boolean z) {
        synchronized (MethodUtils.class) {
            CACHE_METHODS = z;
            if (!z) {
                clearCache();
            }
        }
    }

    public static synchronized int clearCache() {
        int size;
        synchronized (MethodUtils.class) {
            Map<MethodDescriptor, Reference<Method>> map = cache;
            size = map.size();
            map.clear();
        }
        return size;
    }

    public static Object invokeMethod(Object obj, String str, Object obj2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, str, toArray(obj2));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, clsArr);
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return matchingAccessibleMethod.invoke(obj, objArr);
    }

    public static Object invokeExactMethod(Object obj, String str, Object obj2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactMethod(obj, str, toArray(obj2));
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeExactMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
        if (accessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return accessibleMethod.invoke(obj, objArr);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
        if (accessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return accessibleMethod.invoke(null, objArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeStaticMethod(cls, str, toArray(obj));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeStaticMethod(cls, str, objArr, clsArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return matchingAccessibleMethod.invoke(null, objArr);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactStaticMethod(cls, str, toArray(obj));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeExactStaticMethod(cls, str, objArr, clsArr);
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?> cls2) {
        return getAccessibleMethod(cls, str, (Class<?>[]) new Class[]{cls2});
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        try {
            MethodDescriptor methodDescriptor = new MethodDescriptor(cls, str, clsArr, true);
            Method cachedMethod = getCachedMethod(methodDescriptor);
            if (cachedMethod != null) {
                return cachedMethod;
            }
            Method accessibleMethod = getAccessibleMethod(cls, cls.getMethod(str, clsArr));
            cacheMethod(methodDescriptor, accessibleMethod);
            return accessibleMethod;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method getAccessibleMethod(Method method) {
        if (method == null) {
            return null;
        }
        return getAccessibleMethod(method.getDeclaringClass(), method);
    }

    public static Method getAccessibleMethod(Class<?> cls, Method method) {
        if (method == null || !Modifier.isPublic(method.getModifiers())) {
            return null;
        }
        boolean z = true;
        if (cls == null) {
            cls = method.getDeclaringClass();
        } else {
            z = cls.equals(method.getDeclaringClass());
            if (!method.getDeclaringClass().isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls.getName() + " is not assignable from " + method.getDeclaringClass().getName());
            }
        }
        if (Modifier.isPublic(cls.getModifiers())) {
            if (!z && !Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                setMethodAccessible(method);
            }
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(cls, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>[] clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        method = interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                    }
                    if (method != null) {
                        return method;
                    }
                    method = getAccessibleMethodFromInterfaceNest(interfaces[i], str, clsArr);
                    if (method != null) {
                        return method;
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        boolean z;
        String str2 = str;
        Log log = LogFactory.getLog(MethodUtils.class);
        if (log.isTraceEnabled()) {
            log.trace("Matching name=" + str2 + " on " + cls);
        }
        int i = 0;
        MethodDescriptor methodDescriptor = new MethodDescriptor(cls, str2, clsArr, false);
        try {
            Method cachedMethod = getCachedMethod(methodDescriptor);
            if (cachedMethod != null) {
                return cachedMethod;
            }
            Method method = cls.getMethod(str, clsArr);
            if (log.isTraceEnabled()) {
                log.trace("Found straight match: " + method);
                log.trace("isPublic:" + Modifier.isPublic(method.getModifiers()));
            }
            setMethodAccessible(method);
            cacheMethod(methodDescriptor, method);
            return method;
        } catch (NoSuchMethodException unused) {
            int length = clsArr.length;
            Method method2 = null;
            Method[] methods = cls.getMethods();
            float f = Float.MAX_VALUE;
            int length2 = methods.length;
            int i2 = 0;
            while (i2 < length2) {
                Method method3 = methods[i2];
                if (method3.getName().equals(str2)) {
                    if (log.isTraceEnabled()) {
                        log.trace("Found matching name:");
                        log.trace(method3);
                    }
                    Class<?>[] parameterTypes = method3.getParameterTypes();
                    int length3 = parameterTypes.length;
                    if (length3 == length) {
                        int i3 = i;
                        while (true) {
                            if (i3 >= length3) {
                                z = true;
                                break;
                            }
                            if (log.isTraceEnabled()) {
                                log.trace("Param=" + clsArr[i3].getName());
                                log.trace("Method=" + parameterTypes[i3].getName());
                            }
                            if (isAssignmentCompatible(parameterTypes[i3], clsArr[i3])) {
                                i3++;
                            } else {
                                if (log.isTraceEnabled()) {
                                    log.trace(parameterTypes[i3] + " is not assignable from " + clsArr[i3]);
                                }
                                z = false;
                            }
                        }
                        if (z) {
                            Method accessibleMethod = getAccessibleMethod(cls, method3);
                            if (accessibleMethod != null) {
                                if (log.isTraceEnabled()) {
                                    log.trace(accessibleMethod + " accessible version of " + method3);
                                }
                                setMethodAccessible(accessibleMethod);
                                float totalTransformationCost = getTotalTransformationCost(clsArr, accessibleMethod.getParameterTypes());
                                if (totalTransformationCost < f) {
                                    method2 = accessibleMethod;
                                    f = totalTransformationCost;
                                }
                            }
                            log.trace("Couldn't find accessible method.");
                        }
                    }
                }
                i2++;
                str2 = str;
                i = 0;
            }
            if (method2 != null) {
                cacheMethod(methodDescriptor, method2);
            } else {
                log.trace("No match found.");
            }
            return method2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        if (r2.charAt(2) == '3') goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void setMethodAccessible(java.lang.reflect.Method r8) {
        /*
            r0 = 1
            boolean r1 = r8.isAccessible()     // Catch: java.lang.SecurityException -> Lb
            if (r1 != 0) goto L53
            r8.setAccessible(r0)     // Catch: java.lang.SecurityException -> Lb
            goto L53
        Lb:
            r8 = move-exception
            java.lang.Class<org.apache.commons.beanutils.MethodUtils> r1 = org.apache.commons.beanutils.MethodUtils.class
            org.apache.commons.logging.Log r1 = org.apache.commons.logging.LogFactory.getLog(r1)
            boolean r2 = org.apache.commons.beanutils.MethodUtils.loggedAccessibleWarning
            if (r2 != 0) goto L4e
            java.lang.String r2 = "java.specification.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.SecurityException -> L44
            r3 = 0
            char r4 = r2.charAt(r3)     // Catch: java.lang.SecurityException -> L44
            r5 = 49
            if (r4 != r5) goto L45
            r4 = 2
            char r6 = r2.charAt(r4)     // Catch: java.lang.SecurityException -> L44
            r7 = 48
            if (r6 == r7) goto L44
            char r6 = r2.charAt(r4)     // Catch: java.lang.SecurityException -> L44
            if (r6 == r5) goto L44
            char r5 = r2.charAt(r4)     // Catch: java.lang.SecurityException -> L44
            r6 = 50
            if (r5 == r6) goto L44
            char r2 = r2.charAt(r4)     // Catch: java.lang.SecurityException -> L44
            r4 = 51
            if (r2 != r4) goto L45
        L44:
            r3 = r0
        L45:
            if (r3 == 0) goto L4c
            java.lang.String r2 = "Current Security Manager restricts use of workarounds for reflection bugs  in pre-1.4 JVMs."
            r1.warn(r2)
        L4c:
            org.apache.commons.beanutils.MethodUtils.loggedAccessibleWarning = r0
        L4e:
            java.lang.String r0 = "Cannot setAccessible on method. Therefore cannot use jvm access bug workaround."
            r1.debug(r0, r8)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.MethodUtils.setMethodAccessible(java.lang.reflect.Method):void");
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            f += getObjectTransformationCost(clsArr[i], clsArr2[i]);
        }
        return f;
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        Class<?> primitiveWrapper;
        float f = 0.0f;
        while (cls != null && !cls2.equals(cls)) {
            if ((cls2.isPrimitive() && (primitiveWrapper = getPrimitiveWrapper(cls2)) != null && primitiveWrapper.equals(cls)) || (cls2.isInterface() && isAssignmentCompatible(cls2, cls))) {
                f += 0.25f;
                break;
            }
            f += 1.0f;
            cls = cls.getSuperclass();
        }
        return cls == null ? f + 1.5f : f;
    }

    public static final boolean isAssignmentCompatible(Class<?> cls, Class<?> cls2) {
        Class<?> primitiveWrapper;
        if (cls.isAssignableFrom(cls2)) {
            return true;
        }
        if (!cls.isPrimitive() || (primitiveWrapper = getPrimitiveWrapper(cls)) == null) {
            return false;
        }
        return primitiveWrapper.equals(cls2);
    }

    public static Class<?> getPrimitiveWrapper(Class<?> cls) {
        if (Boolean.TYPE.equals(cls)) {
            return Boolean.class;
        }
        if (Float.TYPE.equals(cls)) {
            return Float.class;
        }
        if (Long.TYPE.equals(cls)) {
            return Long.class;
        }
        if (Integer.TYPE.equals(cls)) {
            return Integer.class;
        }
        if (Short.TYPE.equals(cls)) {
            return Short.class;
        }
        if (Byte.TYPE.equals(cls)) {
            return Byte.class;
        }
        if (Double.TYPE.equals(cls)) {
            return Double.class;
        }
        if (Character.TYPE.equals(cls)) {
            return Character.class;
        }
        return null;
    }

    public static Class<?> getPrimitiveType(Class<?> cls) {
        if (Boolean.class.equals(cls)) {
            return Boolean.TYPE;
        }
        if (Float.class.equals(cls)) {
            return Float.TYPE;
        }
        if (Long.class.equals(cls)) {
            return Long.TYPE;
        }
        if (Integer.class.equals(cls)) {
            return Integer.TYPE;
        }
        if (Short.class.equals(cls)) {
            return Short.TYPE;
        }
        if (Byte.class.equals(cls)) {
            return Byte.TYPE;
        }
        if (Double.class.equals(cls)) {
            return Double.TYPE;
        }
        if (Character.class.equals(cls)) {
            return Character.TYPE;
        }
        Log log = LogFactory.getLog(MethodUtils.class);
        if (!log.isDebugEnabled()) {
            return null;
        }
        log.debug("Not a known primitive wrapper class: " + cls);
        return null;
    }

    public static Class<?> toNonPrimitiveClass(Class<?> cls) {
        Class<?> primitiveWrapper;
        return (!cls.isPrimitive() || (primitiveWrapper = getPrimitiveWrapper(cls)) == null) ? cls : primitiveWrapper;
    }

    private static Method getCachedMethod(MethodDescriptor methodDescriptor) {
        Reference<Method> reference;
        if (!CACHE_METHODS || (reference = cache.get(methodDescriptor)) == null) {
            return null;
        }
        return reference.get();
    }

    private static void cacheMethod(MethodDescriptor methodDescriptor, Method method) {
        if (!CACHE_METHODS || method == null) {
            return;
        }
        cache.put(methodDescriptor, new WeakReference(method));
    }

    private static class MethodDescriptor {
        private final Class<?> cls;
        private final boolean exact;
        private final int hashCode;
        private final String methodName;
        private final Class<?>[] paramTypes;

        public MethodDescriptor(Class<?> cls, String str, Class<?>[] clsArr, boolean z) {
            if (cls == null) {
                throw new IllegalArgumentException("Class cannot be null");
            }
            if (str != null) {
                clsArr = clsArr == null ? MethodUtils.EMPTY_CLASS_PARAMETERS : clsArr;
                this.cls = cls;
                this.methodName = str;
                this.paramTypes = clsArr;
                this.exact = z;
                this.hashCode = str.length();
                return;
            }
            throw new IllegalArgumentException("Method Name cannot be null");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodDescriptor)) {
                return false;
            }
            MethodDescriptor methodDescriptor = (MethodDescriptor) obj;
            return this.exact == methodDescriptor.exact && this.methodName.equals(methodDescriptor.methodName) && this.cls.equals(methodDescriptor.cls) && Arrays.equals(this.paramTypes, methodDescriptor.paramTypes);
        }

        public int hashCode() {
            return this.hashCode;
        }
    }
}
