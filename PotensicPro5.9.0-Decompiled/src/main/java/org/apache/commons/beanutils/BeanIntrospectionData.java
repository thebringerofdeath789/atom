package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
class BeanIntrospectionData {
    private final PropertyDescriptor[] descriptors;
    private final Map<String, String> writeMethodNames;

    public BeanIntrospectionData(PropertyDescriptor[] propertyDescriptorArr) {
        this(propertyDescriptorArr, setUpWriteMethodNames(propertyDescriptorArr));
    }

    BeanIntrospectionData(PropertyDescriptor[] propertyDescriptorArr, Map<String, String> map) {
        this.descriptors = propertyDescriptorArr;
        this.writeMethodNames = map;
    }

    public PropertyDescriptor[] getDescriptors() {
        return this.descriptors;
    }

    public PropertyDescriptor getDescriptor(String str) {
        for (PropertyDescriptor propertyDescriptor : getDescriptors()) {
            if (str.equals(propertyDescriptor.getName())) {
                return propertyDescriptor;
            }
        }
        return null;
    }

    public Method getWriteMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        String str;
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null && (str = this.writeMethodNames.get(propertyDescriptor.getName())) != null && (writeMethod = MethodUtils.getAccessibleMethod(cls, str, (Class<?>) propertyDescriptor.getPropertyType())) != null) {
            try {
                propertyDescriptor.setWriteMethod(writeMethod);
            } catch (IntrospectionException unused) {
            }
        }
        return writeMethod;
    }

    private static Map<String, String> setUpWriteMethodNames(PropertyDescriptor[] propertyDescriptorArr) {
        HashMap hashMap = new HashMap();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptorArr) {
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (writeMethod != null) {
                hashMap.put(propertyDescriptor.getName(), writeMethod.getName());
            }
        }
        return hashMap;
    }
}
