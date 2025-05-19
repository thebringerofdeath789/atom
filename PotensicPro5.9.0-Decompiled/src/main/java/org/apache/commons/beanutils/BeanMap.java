package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;

/* loaded from: classes4.dex */
public class BeanMap extends AbstractMap<Object, Object> implements Cloneable {
    private transient Object bean;
    public static final Object[] NULL_ARGUMENTS = new Object[0];
    private static final Map<Class<? extends Object>, Transformer> typeTransformers = Collections.unmodifiableMap(createTypeTransformers());

    @Deprecated
    public static HashMap defaultTransformers = new HashMap() { // from class: org.apache.commons.beanutils.BeanMap.1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return BeanMap.typeTransformers.containsKey(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return BeanMap.typeTransformers.containsValue(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return BeanMap.typeTransformers.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return BeanMap.typeTransformers.get(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return BeanMap.typeTransformers.keySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return BeanMap.typeTransformers.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Collection values() {
            return BeanMap.typeTransformers.values();
        }
    };
    private transient HashMap<String, Method> readMethods = new HashMap<>();
    private transient HashMap<String, Method> writeMethods = new HashMap<>();
    private transient HashMap<String, Class<? extends Object>> types = new HashMap<>();

    protected void firePropertyChange(Object obj, Object obj2, Object obj3) {
    }

    private static Map<Class<? extends Object>, Transformer> createTypeTransformers() {
        HashMap hashMap = new HashMap();
        hashMap.put(Boolean.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.2
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Boolean.valueOf(obj.toString());
            }
        });
        hashMap.put(Character.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.3
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return new Character(obj.toString().charAt(0));
            }
        });
        hashMap.put(Byte.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.4
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Byte.valueOf(obj.toString());
            }
        });
        hashMap.put(Short.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.5
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Short.valueOf(obj.toString());
            }
        });
        hashMap.put(Integer.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.6
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Integer.valueOf(obj.toString());
            }
        });
        hashMap.put(Long.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.7
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Long.valueOf(obj.toString());
            }
        });
        hashMap.put(Float.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.8
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Float.valueOf(obj.toString());
            }
        });
        hashMap.put(Double.TYPE, new Transformer() { // from class: org.apache.commons.beanutils.BeanMap.9
            @Override // org.apache.commons.collections.Transformer
            public Object transform(Object obj) {
                return Double.valueOf(obj.toString());
            }
        });
        return hashMap;
    }

    public BeanMap() {
    }

    public BeanMap(Object obj) {
        this.bean = obj;
        initialise();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return "BeanMap<" + String.valueOf(this.bean) + ">";
    }

    @Override // java.util.AbstractMap
    public Object clone() throws CloneNotSupportedException {
        BeanMap beanMap = (BeanMap) super.clone();
        Object obj = this.bean;
        if (obj == null) {
            return beanMap;
        }
        Class<?> cls = obj.getClass();
        try {
            try {
                beanMap.setBean(cls.newInstance());
                try {
                    for (String str : this.readMethods.keySet()) {
                        if (getWriteMethod((Object) str) != null) {
                            beanMap.put(str, get(str));
                        }
                    }
                    return beanMap;
                } catch (Exception e) {
                    CloneNotSupportedException cloneNotSupportedException = new CloneNotSupportedException("Unable to copy bean values to cloned bean map: " + e);
                    BeanUtils.initCause(cloneNotSupportedException, e);
                    throw cloneNotSupportedException;
                }
            } catch (Exception e2) {
                CloneNotSupportedException cloneNotSupportedException2 = new CloneNotSupportedException("Unable to set bean in the cloned bean map: " + e2);
                BeanUtils.initCause(cloneNotSupportedException2, e2);
                throw cloneNotSupportedException2;
            }
        } catch (Exception e3) {
            CloneNotSupportedException cloneNotSupportedException3 = new CloneNotSupportedException("Unable to instantiate the underlying bean \"" + cls.getName() + "\": " + e3);
            BeanUtils.initCause(cloneNotSupportedException3, e3);
            throw cloneNotSupportedException3;
        }
    }

    public void putAllWriteable(BeanMap beanMap) {
        for (String str : beanMap.readMethods.keySet()) {
            if (getWriteMethod((Object) str) != null) {
                put(str, beanMap.get(str));
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Object obj = this.bean;
        if (obj == null) {
            return;
        }
        Class<?> cls = null;
        try {
            cls = obj.getClass();
            this.bean = cls.newInstance();
        } catch (Exception e) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Could not create new instance of class: " + cls);
            BeanUtils.initCause(unsupportedOperationException, e);
            throw unsupportedOperationException;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return getReadMethod(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Method readMethod;
        if (this.bean == null || (readMethod = getReadMethod(obj)) == null) {
            return null;
        }
        try {
            return readMethod.invoke(this.bean, NULL_ARGUMENTS);
        } catch (IllegalAccessException e) {
            logWarn(e);
            return null;
        } catch (IllegalArgumentException e2) {
            logWarn(e2);
            return null;
        } catch (NullPointerException e3) {
            logWarn(e3);
            return null;
        } catch (InvocationTargetException e4) {
            logWarn(e4);
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) throws IllegalArgumentException, ClassCastException {
        if (this.bean == null) {
            return null;
        }
        Object obj3 = get(obj);
        Method writeMethod = getWriteMethod(obj);
        if (writeMethod == null) {
            throw new IllegalArgumentException("The bean of type: " + this.bean.getClass().getName() + " has no property called: " + obj);
        }
        try {
            writeMethod.invoke(this.bean, createWriteMethodArguments(writeMethod, obj2));
            firePropertyChange(obj, obj3, get(obj));
            return obj3;
        } catch (IllegalAccessException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e.getMessage());
            if (!BeanUtils.initCause(illegalArgumentException, e)) {
                logInfo(e);
                throw illegalArgumentException;
            }
            throw illegalArgumentException;
        } catch (InvocationTargetException e2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(e2.getMessage());
            if (!BeanUtils.initCause(illegalArgumentException2, e2)) {
                logInfo(e2);
                throw illegalArgumentException2;
            }
            throw illegalArgumentException2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.readMethods.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        return Collections.unmodifiableSet(this.readMethods.keySet());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return Collections.unmodifiableSet(new AbstractSet<Map.Entry<Object, Object>>() { // from class: org.apache.commons.beanutils.BeanMap.10
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<Object, Object>> iterator() {
                return BeanMap.this.entryIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return BeanMap.this.readMethods.size();
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<Object> values() {
        ArrayList arrayList = new ArrayList(this.readMethods.size());
        Iterator<Object> valueIterator = valueIterator();
        while (valueIterator.hasNext()) {
            arrayList.add(valueIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Class<?> getType(String str) {
        return this.types.get(str);
    }

    public Iterator<String> keyIterator() {
        return this.readMethods.keySet().iterator();
    }

    public Iterator<Object> valueIterator() {
        final Iterator<String> keyIterator = keyIterator();
        return new Iterator<Object>() { // from class: org.apache.commons.beanutils.BeanMap.11
            @Override // java.util.Iterator
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return BeanMap.this.get(keyIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }
        };
    }

    public Iterator<Map.Entry<Object, Object>> entryIterator() {
        final Iterator<String> keyIterator = keyIterator();
        return new Iterator<Map.Entry<Object, Object>>() { // from class: org.apache.commons.beanutils.BeanMap.12
            @Override // java.util.Iterator
            public boolean hasNext() {
                return keyIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<Object, Object> next() {
                Object next = keyIterator.next();
                return new Entry(BeanMap.this, next, BeanMap.this.get(next));
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove() not supported for BeanMap");
            }
        };
    }

    public Object getBean() {
        return this.bean;
    }

    public void setBean(Object obj) {
        this.bean = obj;
        reinitialise();
    }

    public Method getReadMethod(String str) {
        return this.readMethods.get(str);
    }

    public Method getWriteMethod(String str) {
        return this.writeMethods.get(str);
    }

    protected Method getReadMethod(Object obj) {
        return this.readMethods.get(obj);
    }

    protected Method getWriteMethod(Object obj) {
        return this.writeMethods.get(obj);
    }

    protected void reinitialise() {
        this.readMethods.clear();
        this.writeMethods.clear();
        this.types.clear();
        initialise();
    }

    private void initialise() {
        if (getBean() == null) {
            return;
        }
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(getBean().getClass()).getPropertyDescriptors();
            if (propertyDescriptors != null) {
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    if (propertyDescriptor != null) {
                        String name = propertyDescriptor.getName();
                        Method readMethod = propertyDescriptor.getReadMethod();
                        Method writeMethod = propertyDescriptor.getWriteMethod();
                        Class<? extends Object> propertyType = propertyDescriptor.getPropertyType();
                        if (readMethod != null) {
                            this.readMethods.put(name, readMethod);
                        }
                        if (writeMethod != null) {
                            this.writeMethods.put(name, writeMethod);
                        }
                        this.types.put(name, propertyType);
                    }
                }
            }
        } catch (IntrospectionException e) {
            logWarn(e);
        }
    }

    protected static class Entry extends AbstractMapEntry {
        private final BeanMap owner;

        protected Entry(BeanMap beanMap, Object obj, Object obj2) {
            super(obj, obj2);
            this.owner = beanMap;
        }

        @Override // org.apache.commons.collections.keyvalue.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object key = getKey();
            Object obj2 = this.owner.get(key);
            this.owner.put(key, obj);
            super.setValue(this.owner.get(key));
            return obj2;
        }
    }

    protected Object[] createWriteMethodArguments(Method method, Object obj) throws IllegalAccessException, ClassCastException {
        if (obj != null) {
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes != null && parameterTypes.length > 0) {
                    Class<?> cls = parameterTypes[0];
                    if (!cls.isAssignableFrom(obj.getClass())) {
                        obj = convertType(cls, obj);
                    }
                }
            } catch (InstantiationException e) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e.getMessage());
                if (!BeanUtils.initCause(illegalArgumentException, e)) {
                    logInfo(e);
                }
                BeanUtils.initCause(illegalArgumentException, e);
                throw illegalArgumentException;
            } catch (InvocationTargetException e2) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(e2.getMessage());
                if (!BeanUtils.initCause(illegalArgumentException2, e2)) {
                    logInfo(e2);
                    throw illegalArgumentException2;
                }
                throw illegalArgumentException2;
            }
        }
        return new Object[]{obj};
    }

    protected Object convertType(Class<?> cls, Object obj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            return cls.getConstructor(obj.getClass()).newInstance(obj);
        } catch (NoSuchMethodException unused) {
            Transformer typeTransformer = getTypeTransformer(cls);
            return typeTransformer != null ? typeTransformer.transform(obj) : obj;
        }
    }

    protected Transformer getTypeTransformer(Class<?> cls) {
        return typeTransformers.get(cls);
    }

    protected void logInfo(Exception exc) {
        System.out.println("INFO: Exception: " + exc);
    }

    protected void logWarn(Exception exc) {
        System.out.println("WARN: Exception: " + exc);
        exc.printStackTrace();
    }
}
