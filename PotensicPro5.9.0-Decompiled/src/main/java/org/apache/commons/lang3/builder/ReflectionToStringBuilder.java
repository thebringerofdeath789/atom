package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class ReflectionToStringBuilder extends ToStringBuilder {
    private boolean appendStatics;
    private boolean appendTransients;
    protected String[] excludeFieldNames;
    private boolean excludeNullValues;
    private Class<?> upToClass;

    public static String toString(Object obj) {
        return toString(obj, null, false, false, null);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle) {
        return toString(obj, toStringStyle, false, false, null);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return toString(obj, toStringStyle, z, false, null);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z, boolean z2) {
        return toString(obj, toStringStyle, z, z2, null);
    }

    public static <T> String toString(T t, ToStringStyle toStringStyle, boolean z, boolean z2, Class<? super T> cls) {
        return new ReflectionToStringBuilder(t, toStringStyle, null, cls, z, z2).toString();
    }

    public static <T> String toString(T t, ToStringStyle toStringStyle, boolean z, boolean z2, boolean z3, Class<? super T> cls) {
        return new ReflectionToStringBuilder(t, toStringStyle, null, cls, z, z2, z3).toString();
    }

    public static String toStringExclude(Object obj, Collection<String> collection) {
        return toStringExclude(obj, toNoNullStringArray(collection));
    }

    static String[] toNoNullStringArray(Collection<String> collection) {
        if (collection == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return toNoNullStringArray(collection.toArray());
    }

    static String[] toNoNullStringArray(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj.toString());
            }
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String toStringExclude(Object obj, String... strArr) {
        return new ReflectionToStringBuilder(obj).setExcludeFieldNames(strArr).toString();
    }

    private static Object checkNotNull(Object obj) {
        return Validate.notNull(obj, "obj", new Object[0]);
    }

    public ReflectionToStringBuilder(Object obj) {
        super(checkNotNull(obj));
    }

    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        super(checkNotNull(obj), toStringStyle);
    }

    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        super(checkNotNull(obj), toStringStyle, stringBuffer);
    }

    public <T> ReflectionToStringBuilder(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2) {
        super(checkNotNull(t), toStringStyle, stringBuffer);
        setUpToClass(cls);
        setAppendTransients(z);
        setAppendStatics(z2);
    }

    public <T> ReflectionToStringBuilder(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2, boolean z3) {
        super(checkNotNull(t), toStringStyle, stringBuffer);
        setUpToClass(cls);
        setAppendTransients(z);
        setAppendStatics(z2);
        setExcludeNullValues(z3);
    }

    protected boolean accept(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !isAppendTransients()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !isAppendStatics()) {
            return false;
        }
        String[] strArr = this.excludeFieldNames;
        if (strArr == null || Arrays.binarySearch(strArr, field.getName()) < 0) {
            return !field.isAnnotationPresent(ToStringExclude.class);
        }
        return false;
    }

    protected void appendFieldsIn(Class<?> cls) {
        if (cls.isArray()) {
            reflectionAppendArray(getObject());
            return;
        }
        Field[] fieldArr = (Field[]) ArraySorter.sort(cls.getDeclaredFields(), Comparator.comparing(new Function() { // from class: org.apache.commons.lang3.builder.-$$Lambda$ReflectionToStringBuilder$MuwDFrbA3G-IcKVjEbH-HfGjxvU
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String name;
                name = ((Field) obj).getName();
                return name;
            }
        }));
        AccessibleObject.setAccessible(fieldArr, true);
        for (Field field : fieldArr) {
            String name = field.getName();
            if (accept(field)) {
                try {
                    Object value = getValue(field);
                    if (!this.excludeNullValues || value != null) {
                        append(name, value, !field.isAnnotationPresent(ToStringSummary.class));
                    }
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException: " + e.getMessage());
                }
            }
        }
    }

    public String[] getExcludeFieldNames() {
        return (String[]) this.excludeFieldNames.clone();
    }

    public Class<?> getUpToClass() {
        return this.upToClass;
    }

    protected Object getValue(Field field) throws IllegalAccessException {
        return field.get(getObject());
    }

    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    public boolean isExcludeNullValues() {
        return this.excludeNullValues;
    }

    public ReflectionToStringBuilder reflectionAppendArray(Object obj) {
        getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, obj);
        return this;
    }

    public void setAppendStatics(boolean z) {
        this.appendStatics = z;
    }

    public void setAppendTransients(boolean z) {
        this.appendTransients = z;
    }

    public void setExcludeNullValues(boolean z) {
        this.excludeNullValues = z;
    }

    public ReflectionToStringBuilder setExcludeFieldNames(String... strArr) {
        if (strArr == null) {
            this.excludeFieldNames = null;
        } else {
            this.excludeFieldNames = (String[]) ArraySorter.sort(toNoNullStringArray(strArr));
        }
        return this;
    }

    public void setUpToClass(Class<?> cls) {
        Object object;
        if (cls != null && (object = getObject()) != null && !cls.isInstance(object)) {
            throw new IllegalArgumentException("Specified class is not a superclass of the object");
        }
        this.upToClass = cls;
    }

    @Override // org.apache.commons.lang3.builder.ToStringBuilder
    public String toString() {
        if (getObject() == null) {
            return getStyle().getNullText();
        }
        Class<?> cls = getObject().getClass();
        appendFieldsIn(cls);
        while (cls.getSuperclass() != null && cls != getUpToClass()) {
            cls = cls.getSuperclass();
            appendFieldsIn(cls);
        }
        return super.toString();
    }
}
