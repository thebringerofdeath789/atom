package org.apache.commons.lang3.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class MethodUtils {
    private static final Comparator<Method> METHOD_BY_SIGNATURE = Comparator.comparing($$Lambda$MethodUtils$f4V08ybZbKWgnlJBV31Le5OJCvE.INSTANCE);

    public static Object invokeMethod(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[]) null);
    }

    public static Object invokeMethod(Object obj, boolean z, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, z, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, z, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method matchingAccessibleMethod;
        String str2;
        Class<?>[] nullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = ArrayUtils.nullToEmpty(objArr);
        if (z) {
            matchingAccessibleMethod = getMatchingMethod(obj.getClass(), str, nullToEmpty);
            if (matchingAccessibleMethod != null && !matchingAccessibleMethod.isAccessible()) {
                matchingAccessibleMethod.setAccessible(true);
            }
            str2 = "No such method: ";
        } else {
            matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, nullToEmpty);
            str2 = "No such accessible method: ";
        }
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException(str2 + str + "() on object: " + obj.getClass().getName());
        }
        return matchingAccessibleMethod.invoke(obj, toVarArgs(matchingAccessibleMethod, nullToEmpty2));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, false, str, objArr, clsArr);
    }

    public static Object invokeExactMethod(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return accessibleMethod.invoke(obj, nullToEmpty);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return accessibleMethod.invoke(null, nullToEmpty);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
        }
        return matchingAccessibleMethod.invoke(null, toVarArgs(matchingAccessibleMethod, nullToEmpty));
    }

    private static Object[] toVarArgs(Method method, Object[] objArr) {
        return method.isVarArgs() ? getVarArgs(objArr, method.getParameterTypes()) : objArr;
    }

    static Object[] getVarArgs(Object[] objArr, Class<?>[] clsArr) {
        if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || objArr[objArr.length - 1].getClass().equals(clsArr[clsArr.length - 1]))) {
            return objArr;
        }
        Object[] objArr2 = new Object[clsArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, clsArr.length - 1);
        Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
        int length = (objArr.length - clsArr.length) + 1;
        Object newInstance = Array.newInstance(ClassUtils.primitiveToWrapper(componentType), length);
        System.arraycopy(objArr, clsArr.length - 1, newInstance, 0, length);
        if (componentType.isPrimitive()) {
            newInstance = ArrayUtils.toPrimitive(newInstance);
        }
        objArr2[clsArr.length - 1] = newInstance;
        return objArr2;
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getAccessibleMethod(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
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

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (Modifier.isPublic(cls2.getModifiers())) {
                    try {
                        return cls2.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls2, str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            MemberUtils.setAccessibleWorkaround(method);
            return method;
        } catch (NoSuchMethodException unused) {
            Method[] methods = cls.getMethods();
            ArrayList arrayList = new ArrayList();
            for (Method method2 : methods) {
                if (method2.getName().equals(str) && MemberUtils.isMatchingMethod(method2, clsArr)) {
                    arrayList.add(method2);
                }
            }
            arrayList.sort(METHOD_BY_SIGNATURE);
            Iterator it = arrayList.iterator();
            Method method3 = null;
            while (it.hasNext()) {
                Method accessibleMethod = getAccessibleMethod((Method) it.next());
                if (accessibleMethod != null && (method3 == null || MemberUtils.compareMethodFit(accessibleMethod, method3, clsArr) < 0)) {
                    method3 = accessibleMethod;
                }
            }
            if (method3 != null) {
                MemberUtils.setAccessibleWorkaround(method3);
            }
            if (method3 != null && method3.isVarArgs() && method3.getParameterTypes().length > 0 && clsArr.length > 0) {
                String name = ClassUtils.primitiveToWrapper(method3.getParameterTypes()[r5.length - 1].getComponentType()).getName();
                Class<?> cls2 = clsArr[clsArr.length - 1];
                String name2 = cls2 == null ? null : cls2.getName();
                String name3 = cls2 == null ? null : cls2.getSuperclass().getName();
                if (name2 != null && name3 != null && !name.equals(name2) && !name.equals(name3)) {
                    return null;
                }
            }
            return method3;
        }
    }

    public static Method getMatchingMethod(Class<?> cls, final String str, final Class<?>... clsArr) {
        Validate.notNull(cls, "cls", new Object[0]);
        Validate.notEmpty(str, "methodName", new Object[0]);
        final List<Method> list = (List) Arrays.stream(cls.getDeclaredMethods()).filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$rUpu4REV4kwEDocaLea2XdG5RF4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = ((Method) obj).getName().equals(str);
                return equals;
            }
        }).collect(Collectors.toList());
        Stream filter = ClassUtils.getAllSuperclasses(cls).stream().map(new Function() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$shF8saQsWFDsy9IE4443JR1Bxpk
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Method[] declaredMethods;
                declaredMethods = ((Class) obj).getDeclaredMethods();
                return declaredMethods;
            }
        }).flatMap(new Function() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$uM2j8evwjjmQQVhtwo3vwnhxyqU
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Stream stream;
                stream = Arrays.stream((Method[]) obj);
                return stream;
            }
        }).filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$-1ookzwnfacwGR7BMP8CLxqz1XQ
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = ((Method) obj).getName().equals(str);
                return equals;
            }
        });
        list.getClass();
        filter.forEach(new Consumer() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$lXoJa79nBg2yH17Zz1Wd2Vy6fYQ
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                list.add((Method) obj);
            }
        });
        for (Method method : list) {
            if (Arrays.deepEquals(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        final TreeMap treeMap = new TreeMap();
        list.stream().filter(new Predicate() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$Azulu6W6D5R6ddYtaXyavzDvaDc
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean isAssignable;
                isAssignable = ClassUtils.isAssignable((Class<?>[]) clsArr, ((Method) obj).getParameterTypes(), true);
                return isAssignable;
            }
        }).forEach(new Consumer() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$UhfO7oPFxfVuzKkxdEzab0jeiLw
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((List) treeMap.computeIfAbsent(Integer.valueOf(MethodUtils.distance(clsArr, r3.getParameterTypes())), new Function() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$Z9lKkP-0c1yuLjzdlWUXP4fKlr8
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return MethodUtils.lambda$null$3((Integer) obj2);
                    }
                })).add((Method) obj);
            }
        });
        if (treeMap.isEmpty()) {
            return null;
        }
        List list2 = (List) treeMap.values().iterator().next();
        if (list2.size() == 1) {
            return (Method) list2.get(0);
        }
        throw new IllegalStateException(String.format("Found multiple candidates for method %s on class %s : %s", str + ((String) Arrays.stream(clsArr).map(new Function() { // from class: org.apache.commons.lang3.reflect.-$$Lambda$MethodUtils$vi-D6JA565cZpwvDOJNlIgTc0uw
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String valueOf;
                valueOf = String.valueOf((Class) obj);
                return valueOf;
            }
        }).collect(Collectors.joining(",", "(", ")"))), cls.getName(), list2.stream().map($$Lambda$MethodUtils$f4V08ybZbKWgnlJBV31Le5OJCvE.INSTANCE).collect(Collectors.joining(",", "[", "]"))));
    }

    static /* synthetic */ List lambda$null$3(Integer num) {
        return new ArrayList();
    }

    private static int distance(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (!ClassUtils.isAssignable(clsArr, clsArr2, true)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            Class<?> cls = clsArr[i2];
            Class<?> cls2 = clsArr2[i2];
            if (cls != null && !cls.equals(cls2)) {
                i = (!ClassUtils.isAssignable(cls, cls2, true) || ClassUtils.isAssignable(cls, cls2, false)) ? i + 2 : i + 1;
            }
        }
        return i;
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Validate.notNull(method);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
        it.next();
        while (it.hasNext()) {
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(it.next(), method.getName(), parameterTypes);
            if (matchingAccessibleMethod != null) {
                if (Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                    linkedHashSet.add(matchingAccessibleMethod);
                } else {
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                    int i = 0;
                    while (true) {
                        if (i < parameterTypes.length) {
                            if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i]))) {
                                break;
                            }
                            i++;
                        } else {
                            linkedHashSet.add(matchingAccessibleMethod);
                            break;
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsWithAnnotation(cls, cls2, false, false);
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsListWithAnnotation(cls, cls2, false, false);
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        return (Method[]) getMethodsListWithAnnotation(cls, cls2, z, z2).toArray(ArrayUtils.EMPTY_METHOD_ARRAY);
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        Validate.notNull(cls, "cls", new Object[0]);
        Validate.notNull(cls2, "annotationCls", new Object[0]);
        List<Class> allSuperclassesAndInterfaces = z ? getAllSuperclassesAndInterfaces(cls) : new ArrayList();
        allSuperclassesAndInterfaces.add(0, cls);
        ArrayList arrayList = new ArrayList();
        for (Class cls3 : allSuperclassesAndInterfaces) {
            for (Method method : z2 ? cls3.getDeclaredMethods() : cls3.getMethods()) {
                if (method.getAnnotation(cls2) != null) {
                    arrayList.add(method);
                }
            }
        }
        return arrayList;
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls, boolean z, boolean z2) {
        Method matchingAccessibleMethod;
        Validate.notNull(method, "method", new Object[0]);
        Validate.notNull(cls, "annotationCls", new Object[0]);
        if (!z2 && !MemberUtils.isAccessible(method)) {
            return null;
        }
        A a = (A) method.getAnnotation(cls);
        if (a == null && z) {
            for (Class<?> cls2 : getAllSuperclassesAndInterfaces(method.getDeclaringClass())) {
                if (z2) {
                    matchingAccessibleMethod = getMatchingMethod(cls2, method.getName(), method.getParameterTypes());
                } else {
                    matchingAccessibleMethod = getMatchingAccessibleMethod(cls2, method.getName(), method.getParameterTypes());
                }
                if (matchingAccessibleMethod != null && (a = (A) matchingAccessibleMethod.getAnnotation(cls)) != null) {
                    break;
                }
            }
        }
        return a;
    }

    private static List<Class<?>> getAllSuperclassesAndInterfaces(Class<?> cls) {
        Class<?> cls2;
        int i;
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(cls);
        List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(cls);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= allInterfaces.size() && i3 >= allSuperclasses.size()) {
                return arrayList;
            }
            if (i2 >= allInterfaces.size()) {
                i = i3 + 1;
                cls2 = allSuperclasses.get(i3);
            } else if (i3 >= allSuperclasses.size() || i2 < i3 || i3 >= i2) {
                int i4 = i3;
                cls2 = allInterfaces.get(i2);
                i2++;
                i = i4;
            } else {
                i = i3 + 1;
                cls2 = allSuperclasses.get(i3);
            }
            arrayList.add(cls2);
            i3 = i;
        }
    }
}
