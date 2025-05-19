package org.apache.commons.beanutils;

import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.beanutils.expression.DefaultResolver;
import org.apache.commons.beanutils.expression.Resolver;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class PropertyUtilsBean {
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private WeakFastHashMap<Class<?>, BeanIntrospectionData> descriptorsCache;
    private final List<BeanIntrospector> introspectors;
    private WeakFastHashMap<Class<?>, FastHashMap> mappedDescriptorsCache;
    private Resolver resolver = new DefaultResolver();
    private final Log log = LogFactory.getLog(PropertyUtils.class);

    protected static PropertyUtilsBean getInstance() {
        return BeanUtilsBean.getInstance().getPropertyUtils();
    }

    public PropertyUtilsBean() {
        this.descriptorsCache = null;
        this.mappedDescriptorsCache = null;
        WeakFastHashMap<Class<?>, BeanIntrospectionData> weakFastHashMap = new WeakFastHashMap<>();
        this.descriptorsCache = weakFastHashMap;
        weakFastHashMap.setFast(true);
        WeakFastHashMap<Class<?>, FastHashMap> weakFastHashMap2 = new WeakFastHashMap<>();
        this.mappedDescriptorsCache = weakFastHashMap2;
        weakFastHashMap2.setFast(true);
        this.introspectors = new CopyOnWriteArrayList();
        resetBeanIntrospectors();
    }

    public Resolver getResolver() {
        return this.resolver;
    }

    public void setResolver(Resolver resolver) {
        if (resolver == null) {
            this.resolver = new DefaultResolver();
        } else {
            this.resolver = resolver;
        }
    }

    public final void resetBeanIntrospectors() {
        this.introspectors.clear();
        this.introspectors.add(DefaultBeanIntrospector.INSTANCE);
        this.introspectors.add(SuppressPropertiesBeanIntrospector.SUPPRESS_CLASS);
    }

    public void addBeanIntrospector(BeanIntrospector beanIntrospector) {
        if (beanIntrospector == null) {
            throw new IllegalArgumentException("BeanIntrospector must not be null!");
        }
        this.introspectors.add(beanIntrospector);
    }

    public boolean removeBeanIntrospector(BeanIntrospector beanIntrospector) {
        return this.introspectors.remove(beanIntrospector);
    }

    public void clearDescriptors() {
        this.descriptorsCache.clear();
        this.mappedDescriptorsCache.clear();
        Introspector.flushCaches();
    }

    public void copyProperties(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No destination bean specified");
        }
        if (obj2 == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }
        int i = 0;
        if (obj2 instanceof DynaBean) {
            DynaProperty[] dynaProperties = ((DynaBean) obj2).getDynaClass().getDynaProperties();
            int length = dynaProperties.length;
            while (i < length) {
                String name = dynaProperties[i].getName();
                if (isReadable(obj2, name) && isWriteable(obj, name)) {
                    try {
                        Object obj3 = ((DynaBean) obj2).get(name);
                        if (obj instanceof DynaBean) {
                            ((DynaBean) obj).set(name, obj3);
                        } else {
                            setSimpleProperty(obj, name, obj3);
                        }
                    } catch (NoSuchMethodException e) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Error writing to '" + name + "' on class '" + obj.getClass() + "'", e);
                        }
                    }
                }
                i++;
            }
            return;
        }
        if (obj2 instanceof Map) {
            for (Map.Entry entry : ((Map) obj2).entrySet()) {
                String str = (String) entry.getKey();
                if (isWriteable(obj, str)) {
                    try {
                        if (obj instanceof DynaBean) {
                            ((DynaBean) obj).set(str, entry.getValue());
                        } else {
                            setSimpleProperty(obj, str, entry.getValue());
                        }
                    } catch (NoSuchMethodException e2) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Error writing to '" + str + "' on class '" + obj.getClass() + "'", e2);
                        }
                    }
                }
            }
            return;
        }
        PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(obj2);
        int length2 = propertyDescriptors.length;
        while (i < length2) {
            String name2 = propertyDescriptors[i].getName();
            if (isReadable(obj2, name2) && isWriteable(obj, name2)) {
                try {
                    Object simpleProperty = getSimpleProperty(obj2, name2);
                    if (obj instanceof DynaBean) {
                        ((DynaBean) obj).set(name2, simpleProperty);
                    } else {
                        setSimpleProperty(obj, name2, simpleProperty);
                    }
                } catch (NoSuchMethodException e3) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Error writing to '" + name2 + "' on class '" + obj.getClass() + "'", e3);
                    }
                }
            }
            i++;
        }
    }

    public Map<String, Object> describe(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        if (obj instanceof DynaBean) {
            DynaProperty[] dynaProperties = ((DynaBean) obj).getDynaClass().getDynaProperties();
            int length = dynaProperties.length;
            while (i < length) {
                String name = dynaProperties[i].getName();
                hashMap.put(name, getProperty(obj, name));
                i++;
            }
        } else {
            PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(obj);
            int length2 = propertyDescriptors.length;
            while (i < length2) {
                PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                String name2 = propertyDescriptor.getName();
                if (propertyDescriptor.getReadMethod() != null) {
                    hashMap.put(name2, getProperty(obj, name2));
                }
                i++;
            }
        }
        return hashMap;
    }

    public Object getIndexedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        try {
            int index = this.resolver.getIndex(str);
            if (index < 0) {
                throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            return getIndexedProperty(obj, this.resolver.getProperty(str), index);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "' " + e.getMessage());
        }
    }

    public Object getIndexedProperty(Object obj, String str, int i) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method accessibleMethod;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null || str.length() == 0) {
            if (obj.getClass().isArray()) {
                return Array.get(obj, i);
            }
            if (obj instanceof List) {
                return ((List) obj).get(i);
            }
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            return dynaBean.get(str, i);
        }
        IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if ((propertyDescriptor instanceof IndexedPropertyDescriptor) && (accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getIndexedReadMethod())) != null) {
            try {
                return invokeMethod(accessibleMethod, obj, new Object[]{new Integer(i)});
            } catch (InvocationTargetException e) {
                if (e.getTargetException() instanceof IndexOutOfBoundsException) {
                    throw ((IndexOutOfBoundsException) e.getTargetException());
                }
                throw e;
            }
        }
        Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
        if (readMethod == null) {
            throw new NoSuchMethodException("Property '" + str + "' has no getter method on bean class '" + obj.getClass() + "'");
        }
        Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
        if (!invokeMethod.getClass().isArray()) {
            if (!(invokeMethod instanceof List)) {
                throw new IllegalArgumentException("Property '" + str + "' is not indexed on bean class '" + obj.getClass() + "'");
            }
            return ((List) invokeMethod).get(i);
        }
        try {
            return Array.get(invokeMethod, i);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ArrayIndexOutOfBoundsException("Index: " + i + ", Size: " + Array.getLength(invokeMethod) + " for property '" + str + "'");
        }
    }

    public Object getMappedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        try {
            String key = this.resolver.getKey(str);
            if (key == null) {
                throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            return getMappedProperty(obj, this.resolver.getProperty(str), key);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "' " + e.getMessage());
        }
    }

    public Object getMappedProperty(Object obj, String str, String str2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("No key specified for property '" + str + "' on bean class " + obj.getClass() + "'");
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "'+ on bean class '" + obj.getClass() + "'");
            }
            return dynaBean.get(str, str2);
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException("Unknown property '" + str + "'+ on bean class '" + obj.getClass() + "'");
        }
        if (propertyDescriptor instanceof MappedPropertyDescriptor) {
            Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), ((MappedPropertyDescriptor) propertyDescriptor).getMappedReadMethod());
            if (accessibleMethod != null) {
                return invokeMethod(accessibleMethod, obj, new Object[]{str2});
            }
            throw new NoSuchMethodException("Property '" + str + "' has no mapped getter method on bean class '" + obj.getClass() + "'");
        }
        Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
        if (readMethod != null) {
            Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
            return invokeMethod instanceof Map ? ((Map) invokeMethod).get(str2) : null;
        }
        throw new NoSuchMethodException("Property '" + str + "' has no mapped getter method on bean class '" + obj.getClass() + "'");
    }

    @Deprecated
    public FastHashMap getMappedPropertyDescriptors(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this.mappedDescriptorsCache.get(cls);
    }

    @Deprecated
    public FastHashMap getMappedPropertyDescriptors(Object obj) {
        if (obj == null) {
            return null;
        }
        return getMappedPropertyDescriptors(obj.getClass());
    }

    public Object getNestedProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object simpleProperty;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            if (obj instanceof Map) {
                simpleProperty = getPropertyOfMapBean((Map) obj, next);
            } else if (this.resolver.isMapped(next)) {
                simpleProperty = getMappedProperty(obj, next);
            } else if (this.resolver.isIndexed(next)) {
                simpleProperty = getIndexedProperty(obj, next);
            } else {
                simpleProperty = getSimpleProperty(obj, next);
            }
            if (simpleProperty == null) {
                throw new NestedNullException("Null property value for '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            str = this.resolver.remove(str);
            obj = simpleProperty;
        }
        if (obj instanceof Map) {
            return getPropertyOfMapBean((Map) obj, str);
        }
        if (this.resolver.isMapped(str)) {
            return getMappedProperty(obj, str);
        }
        if (this.resolver.isIndexed(str)) {
            return getIndexedProperty(obj, str);
        }
        return getSimpleProperty(obj, str);
    }

    protected Object getPropertyOfMapBean(Map<?, ?> map, String str) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String property;
        if (this.resolver.isMapped(str) && ((property = this.resolver.getProperty(str)) == null || property.length() == 0)) {
            str = this.resolver.getKey(str);
        }
        if (this.resolver.isIndexed(str) || this.resolver.isMapped(str)) {
            throw new IllegalArgumentException("Indexed or mapped properties are not supported on objects of type Map: " + str);
        }
        return map.get(str);
    }

    public Object getProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getNestedProperty(obj, str);
    }

    public PropertyDescriptor getPropertyDescriptor(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            Object property = getProperty(obj, next);
            if (property == null) {
                throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
            }
            str = this.resolver.remove(str);
            obj = property;
        }
        String property2 = this.resolver.getProperty(str);
        if (property2 == null) {
            return null;
        }
        PropertyDescriptor descriptor = getIntrospectionData(obj.getClass()).getDescriptor(property2);
        if (descriptor != null) {
            return descriptor;
        }
        FastHashMap mappedPropertyDescriptors = getMappedPropertyDescriptors(obj);
        if (mappedPropertyDescriptors == null) {
            mappedPropertyDescriptors = new FastHashMap();
            mappedPropertyDescriptors.setFast(true);
            this.mappedDescriptorsCache.put(obj.getClass(), mappedPropertyDescriptors);
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) mappedPropertyDescriptors.get(property2);
        if (propertyDescriptor == null) {
            try {
                propertyDescriptor = new MappedPropertyDescriptor(property2, obj.getClass());
            } catch (IntrospectionException unused) {
            }
            if (propertyDescriptor != null) {
                mappedPropertyDescriptors.put(property2, propertyDescriptor);
            }
        }
        return propertyDescriptor;
    }

    public PropertyDescriptor[] getPropertyDescriptors(Class<?> cls) {
        return getIntrospectionData(cls).getDescriptors();
    }

    public PropertyDescriptor[] getPropertyDescriptors(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        return getPropertyDescriptors(obj.getClass());
    }

    public Class<?> getPropertyEditorClass(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor != null) {
            return propertyDescriptor.getPropertyEditorClass();
        }
        return null;
    }

    public Class<?> getPropertyType(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<?> type;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            Object property = getProperty(obj, next);
            if (property == null) {
                throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
            }
            str = this.resolver.remove(str);
            obj = property;
        }
        String property2 = this.resolver.getProperty(str);
        if (obj instanceof DynaBean) {
            DynaProperty dynaProperty = ((DynaBean) obj).getDynaClass().getDynaProperty(property2);
            if (dynaProperty == null || (type = dynaProperty.getType()) == null) {
                return null;
            }
            return type.isArray() ? type.getComponentType() : type;
        }
        IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
        if (propertyDescriptor == null) {
            return null;
        }
        if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
            return propertyDescriptor.getIndexedPropertyType();
        }
        if (propertyDescriptor instanceof MappedPropertyDescriptor) {
            return ((MappedPropertyDescriptor) propertyDescriptor).getMappedPropertyType();
        }
        return propertyDescriptor.getPropertyType();
    }

    public Method getReadMethod(PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(propertyDescriptor.getReadMethod());
    }

    Method getReadMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(cls, propertyDescriptor.getReadMethod());
    }

    public Object getSimpleProperty(Object obj, String str) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        if (this.resolver.hasNested(str)) {
            throw new IllegalArgumentException("Nested property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (this.resolver.isIndexed(str)) {
            throw new IllegalArgumentException("Indexed property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (this.resolver.isMapped(str)) {
            throw new IllegalArgumentException("Mapped property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "' on dynaclass '" + dynaBean.getDynaClass() + "'");
            }
            return dynaBean.get(str);
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException("Unknown property '" + str + "' on class '" + obj.getClass() + "'");
        }
        Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
        if (readMethod == null) {
            throw new NoSuchMethodException("Property '" + str + "' has no getter method in class '" + obj.getClass() + "'");
        }
        return invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
    }

    public Method getWriteMethod(PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(propertyDescriptor.getWriteMethod());
    }

    public Method getWriteMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        return MethodUtils.getAccessibleMethod(cls, getIntrospectionData(cls).getWriteMethod(cls, propertyDescriptor));
    }

    public boolean isReadable(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            try {
                Object property = getProperty(obj, next);
                if (property == null) {
                    throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
                }
                str = this.resolver.remove(str);
                obj = property;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        String property2 = this.resolver.getProperty(str);
        if (obj instanceof WrapDynaBean) {
            obj = ((WrapDynaBean) obj).getInstance();
        }
        if (obj instanceof DynaBean) {
            return ((DynaBean) obj).getDynaClass().getDynaProperty(property2) != null;
        }
        try {
            IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
            if (propertyDescriptor == null) {
                return false;
            }
            Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
            if (readMethod == null) {
                if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                    readMethod = propertyDescriptor.getIndexedReadMethod();
                } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                    readMethod = ((MappedPropertyDescriptor) propertyDescriptor).getMappedReadMethod();
                }
                readMethod = MethodUtils.getAccessibleMethod(obj.getClass(), readMethod);
            }
            return readMethod != null;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            return false;
        }
    }

    public boolean isWriteable(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            try {
                Object property = getProperty(obj, next);
                if (property == null) {
                    throw new NestedNullException("Null property value for '" + next + "' on bean class '" + obj.getClass() + "'");
                }
                str = this.resolver.remove(str);
                obj = property;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
        String property2 = this.resolver.getProperty(str);
        if (obj instanceof WrapDynaBean) {
            obj = ((WrapDynaBean) obj).getInstance();
        }
        if (obj instanceof DynaBean) {
            return ((DynaBean) obj).getDynaClass().getDynaProperty(property2) != null;
        }
        try {
            IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, property2);
            if (propertyDescriptor == null) {
                return false;
            }
            Method writeMethod = getWriteMethod(obj.getClass(), propertyDescriptor);
            if (writeMethod == null) {
                if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                    writeMethod = propertyDescriptor.getIndexedWriteMethod();
                } else if (propertyDescriptor instanceof MappedPropertyDescriptor) {
                    writeMethod = ((MappedPropertyDescriptor) propertyDescriptor).getMappedWriteMethod();
                }
                writeMethod = MethodUtils.getAccessibleMethod(obj.getClass(), writeMethod);
            }
            return writeMethod != null;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            return false;
        }
    }

    public void setIndexedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        try {
            int index = this.resolver.getIndex(str);
            if (index < 0) {
                throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            setIndexedProperty(obj, this.resolver.getProperty(str), index, obj2);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid indexed property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
    }

    public void setIndexedProperty(Object obj, String str, int i, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method accessibleMethod;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null || str.length() == 0) {
            if (obj.getClass().isArray()) {
                Array.set(obj, i, obj2);
                return;
            } else if (obj instanceof List) {
                toObjectList(obj).set(i, obj2);
                return;
            }
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            dynaBean.set(str, i, obj2);
            return;
        }
        IndexedPropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if ((propertyDescriptor instanceof IndexedPropertyDescriptor) && (accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), propertyDescriptor.getIndexedWriteMethod())) != null) {
            Object[] objArr = {new Integer(i), obj2};
            try {
                if (this.log.isTraceEnabled()) {
                    this.log.trace("setSimpleProperty: Invoking method " + accessibleMethod + " with index=" + i + ", value=" + obj2 + " (class " + (obj2 == null ? "<null>" : obj2.getClass().getName()) + ")");
                }
                invokeMethod(accessibleMethod, obj, objArr);
                return;
            } catch (InvocationTargetException e) {
                if (e.getTargetException() instanceof IndexOutOfBoundsException) {
                    throw ((IndexOutOfBoundsException) e.getTargetException());
                }
                throw e;
            }
        }
        Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
        if (readMethod == null) {
            throw new NoSuchMethodException("Property '" + str + "' has no getter method on bean class '" + obj.getClass() + "'");
        }
        Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
        if (!invokeMethod.getClass().isArray()) {
            if (invokeMethod instanceof List) {
                toObjectList(invokeMethod).set(i, obj2);
                return;
            }
            throw new IllegalArgumentException("Property '" + str + "' is not indexed on bean class '" + obj.getClass() + "'");
        }
        Array.set(invokeMethod, i, obj2);
    }

    public void setMappedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        try {
            String key = this.resolver.getKey(str);
            if (key == null) {
                throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            setMappedProperty(obj, this.resolver.getProperty(str), key, obj2);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Invalid mapped property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
    }

    public void setMappedProperty(Object obj, String str, String str2, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("No key specified for property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            dynaBean.set(str, str2, obj2);
            return;
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException("Unknown property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (propertyDescriptor instanceof MappedPropertyDescriptor) {
            Method accessibleMethod = MethodUtils.getAccessibleMethod(obj.getClass(), ((MappedPropertyDescriptor) propertyDescriptor).getMappedWriteMethod());
            if (accessibleMethod != null) {
                Object[] objArr = {str2, obj2};
                if (this.log.isTraceEnabled()) {
                    this.log.trace("setSimpleProperty: Invoking method " + accessibleMethod + " with key=" + str2 + ", value=" + obj2 + " (class " + (obj2 == null ? "<null>" : obj2.getClass().getName()) + ")");
                }
                invokeMethod(accessibleMethod, obj, objArr);
                return;
            }
            throw new NoSuchMethodException("Property '" + str + "' has no mapped setter methodon bean class '" + obj.getClass() + "'");
        }
        Method readMethod = getReadMethod(obj.getClass(), propertyDescriptor);
        if (readMethod != null) {
            Object invokeMethod = invokeMethod(readMethod, obj, EMPTY_OBJECT_ARRAY);
            if (invokeMethod instanceof Map) {
                toPropertyMap(invokeMethod).put(str2, obj2);
                return;
            }
            return;
        }
        throw new NoSuchMethodException("Property '" + str + "' has no mapped getter method on bean class '" + obj.getClass() + "'");
    }

    public void setNestedProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object simpleProperty;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        while (this.resolver.hasNested(str)) {
            String next = this.resolver.next(str);
            if (obj instanceof Map) {
                simpleProperty = getPropertyOfMapBean((Map) obj, next);
            } else if (this.resolver.isMapped(next)) {
                simpleProperty = getMappedProperty(obj, next);
            } else if (this.resolver.isIndexed(next)) {
                simpleProperty = getIndexedProperty(obj, next);
            } else {
                simpleProperty = getSimpleProperty(obj, next);
            }
            if (simpleProperty == null) {
                throw new NestedNullException("Null property value for '" + str + "' on bean class '" + obj.getClass() + "'");
            }
            str = this.resolver.remove(str);
            obj = simpleProperty;
        }
        if (obj instanceof Map) {
            setPropertyOfMapBean(toPropertyMap(obj), str, obj2);
            return;
        }
        if (this.resolver.isMapped(str)) {
            setMappedProperty(obj, str, obj2);
        } else if (this.resolver.isIndexed(str)) {
            setIndexedProperty(obj, str, obj2);
        } else {
            setSimpleProperty(obj, str, obj2);
        }
    }

    protected void setPropertyOfMapBean(Map<String, Object> map, String str, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String property;
        if (this.resolver.isMapped(str) && ((property = this.resolver.getProperty(str)) == null || property.length() == 0)) {
            str = this.resolver.getKey(str);
        }
        if (this.resolver.isIndexed(str) || this.resolver.isMapped(str)) {
            throw new IllegalArgumentException("Indexed or mapped properties are not supported on objects of type Map: " + str);
        }
        map.put(str, obj);
    }

    public void setProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        setNestedProperty(obj, str, obj2);
    }

    public void setSimpleProperty(Object obj, String str, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified");
        }
        if (str == null) {
            throw new IllegalArgumentException("No name specified for bean class '" + obj.getClass() + "'");
        }
        if (this.resolver.hasNested(str)) {
            throw new IllegalArgumentException("Nested property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (this.resolver.isIndexed(str)) {
            throw new IllegalArgumentException("Indexed property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (this.resolver.isMapped(str)) {
            throw new IllegalArgumentException("Mapped property names are not allowed: Property '" + str + "' on bean class '" + obj.getClass() + "'");
        }
        if (obj instanceof DynaBean) {
            DynaBean dynaBean = (DynaBean) obj;
            if (dynaBean.getDynaClass().getDynaProperty(str) == null) {
                throw new NoSuchMethodException("Unknown property '" + str + "' on dynaclass '" + dynaBean.getDynaClass() + "'");
            }
            dynaBean.set(str, obj2);
            return;
        }
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(obj, str);
        if (propertyDescriptor == null) {
            throw new NoSuchMethodException("Unknown property '" + str + "' on class '" + obj.getClass() + "'");
        }
        Method writeMethod = getWriteMethod(obj.getClass(), propertyDescriptor);
        if (writeMethod == null) {
            throw new NoSuchMethodException("Property '" + str + "' has no setter method in class '" + obj.getClass() + "'");
        }
        Object[] objArr = {obj2};
        if (this.log.isTraceEnabled()) {
            this.log.trace("setSimpleProperty: Invoking method " + writeMethod + " with value " + obj2 + " (class " + (obj2 == null ? "<null>" : obj2.getClass().getName()) + ")");
        }
        invokeMethod(writeMethod, obj, objArr);
    }

    private Object invokeMethod(Method method, Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        String str;
        String str2;
        String str3;
        if (obj == null) {
            throw new IllegalArgumentException("No bean specified - this should have been checked before reaching this method");
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalArgumentException e) {
            if (objArr != null) {
                str2 = "";
                str = str2;
                for (int i = 0; i < objArr.length; i++) {
                    if (i > 0) {
                        str2 = str2 + ", ";
                    }
                    if (objArr[i] == null) {
                        str3 = str2 + "<null>";
                    } else {
                        str3 = str2 + objArr[i].getClass().getName();
                    }
                    str2 = str3;
                }
            } else {
                str = "";
                str2 = str;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            String str4 = str;
            if (parameterTypes != null) {
                for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                    if (i2 > 0) {
                        str4 = str4 + ", ";
                    }
                    str4 = str4 + parameterTypes[i2].getName();
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot invoke " + method.getDeclaringClass().getName() + "." + method.getName() + " on bean class '" + obj.getClass() + "' - " + e.getMessage() + " - had objects of type \"" + str2 + "\" but expected signature \"" + str4 + "\"");
            if (!BeanUtils.initCause(illegalArgumentException, e)) {
                this.log.error("Method invocation failed", e);
            }
            throw illegalArgumentException;
        } catch (NullPointerException e2) {
            String str5 = "";
            if (objArr != null) {
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    if (i3 > 0) {
                        str5 = str5 + ", ";
                    }
                    if (objArr[i3] == null) {
                        str5 = str5 + "<null>";
                    } else {
                        str5 = str5 + objArr[i3].getClass().getName();
                    }
                }
            }
            Class<?>[] parameterTypes2 = method.getParameterTypes();
            String str6 = "";
            if (parameterTypes2 != null) {
                for (int i4 = 0; i4 < parameterTypes2.length; i4++) {
                    if (i4 > 0) {
                        str6 = str6 + ", ";
                    }
                    str6 = str6 + parameterTypes2[i4].getName();
                }
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Cannot invoke " + method.getDeclaringClass().getName() + "." + method.getName() + " on bean class '" + obj.getClass() + "' - " + e2.getMessage() + " - had objects of type \"" + str5 + "\" but expected signature \"" + str6 + "\"");
            if (!BeanUtils.initCause(illegalArgumentException2, e2)) {
                this.log.error("Method invocation failed", e2);
            }
            throw illegalArgumentException2;
        }
    }

    private BeanIntrospectionData getIntrospectionData(Class<?> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("No bean class specified");
        }
        BeanIntrospectionData beanIntrospectionData = this.descriptorsCache.get(cls);
        if (beanIntrospectionData != null) {
            return beanIntrospectionData;
        }
        BeanIntrospectionData fetchIntrospectionData = fetchIntrospectionData(cls);
        this.descriptorsCache.put(cls, fetchIntrospectionData);
        return fetchIntrospectionData;
    }

    private BeanIntrospectionData fetchIntrospectionData(Class<?> cls) {
        DefaultIntrospectionContext defaultIntrospectionContext = new DefaultIntrospectionContext(cls);
        Iterator<BeanIntrospector> it = this.introspectors.iterator();
        while (it.hasNext()) {
            try {
                it.next().introspect(defaultIntrospectionContext);
            } catch (IntrospectionException e) {
                this.log.error("Exception during introspection", e);
            }
        }
        return new BeanIntrospectionData(defaultIntrospectionContext.getPropertyDescriptors());
    }

    private static List<Object> toObjectList(Object obj) {
        return (List) obj;
    }

    private static Map<String, Object> toPropertyMap(Object obj) {
        return (Map) obj;
    }
}
