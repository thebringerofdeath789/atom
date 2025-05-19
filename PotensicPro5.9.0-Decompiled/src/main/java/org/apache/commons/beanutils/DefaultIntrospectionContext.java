package org.apache.commons.beanutils;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
class DefaultIntrospectionContext implements IntrospectionContext {
    private static final PropertyDescriptor[] EMPTY_DESCRIPTORS = new PropertyDescriptor[0];
    private final Class<?> currentClass;
    private final Map<String, PropertyDescriptor> descriptors = new HashMap();

    public DefaultIntrospectionContext(Class<?> cls) {
        this.currentClass = cls;
    }

    @Override // org.apache.commons.beanutils.IntrospectionContext
    public Class<?> getTargetClass() {
        return this.currentClass;
    }

    @Override // org.apache.commons.beanutils.IntrospectionContext
    public void addPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException("Property descriptor must not be null!");
        }
        this.descriptors.put(propertyDescriptor.getName(), propertyDescriptor);
    }

    @Override // org.apache.commons.beanutils.IntrospectionContext
    public void addPropertyDescriptors(PropertyDescriptor[] propertyDescriptorArr) {
        if (propertyDescriptorArr == null) {
            throw new IllegalArgumentException("Array with descriptors must not be null!");
        }
        for (PropertyDescriptor propertyDescriptor : propertyDescriptorArr) {
            addPropertyDescriptor(propertyDescriptor);
        }
    }

    @Override // org.apache.commons.beanutils.IntrospectionContext
    public boolean hasProperty(String str) {
        return this.descriptors.containsKey(str);
    }

    @Override // org.apache.commons.beanutils.IntrospectionContext
    public PropertyDescriptor getPropertyDescriptor(String str) {
        return this.descriptors.get(str);
    }

    @Override // org.apache.commons.beanutils.IntrospectionContext
    public void removePropertyDescriptor(String str) {
        this.descriptors.remove(str);
    }

    @Override // org.apache.commons.beanutils.IntrospectionContext
    public Set<String> propertyNames() {
        return this.descriptors.keySet();
    }

    public PropertyDescriptor[] getPropertyDescriptors() {
        return (PropertyDescriptor[]) this.descriptors.values().toArray(EMPTY_DESCRIPTORS);
    }
}
