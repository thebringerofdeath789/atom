package org.apache.commons.beanutils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class BasicDynaBean implements DynaBean, Serializable {
    protected DynaClass dynaClass;
    private transient Map<String, Object> mapDecorator;
    protected HashMap<String, Object> values = new HashMap<>();

    public BasicDynaBean(DynaClass dynaClass) {
        this.dynaClass = null;
        this.dynaClass = dynaClass;
    }

    public Map<String, Object> getMap() {
        if (this.mapDecorator == null) {
            this.mapDecorator = new DynaBeanPropertyMapDecorator(this);
        }
        return this.mapDecorator;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public boolean contains(String str, String str2) {
        Object obj = this.values.get(str);
        if (obj == null) {
            throw new NullPointerException("No mapped value for '" + str + "(" + str2 + ")'");
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str2);
        }
        throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str) {
        Object obj = this.values.get(str);
        if (obj != null) {
            return obj;
        }
        Class<?> type = getDynaProperty(str).getType();
        if (!type.isPrimitive()) {
            return obj;
        }
        if (type == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (type == Byte.TYPE) {
            return new Byte((byte) 0);
        }
        if (type == Character.TYPE) {
            return new Character((char) 0);
        }
        if (type == Double.TYPE) {
            return new Double(0.0d);
        }
        if (type == Float.TYPE) {
            return new Float(0.0f);
        }
        if (type == Integer.TYPE) {
            return new Integer(0);
        }
        if (type == Long.TYPE) {
            return new Long(0L);
        }
        if (type == Short.TYPE) {
            return new Short((short) 0);
        }
        return null;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, int i) {
        Object obj = this.values.get(str);
        if (obj == null) {
            throw new NullPointerException("No indexed value for '" + str + "[" + i + "]'");
        }
        if (obj.getClass().isArray()) {
            return Array.get(obj, i);
        }
        if (obj instanceof List) {
            return ((List) obj).get(i);
        }
        throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i + "]'");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, String str2) {
        Object obj = this.values.get(str);
        if (obj == null) {
            throw new NullPointerException("No mapped value for '" + str + "(" + str2 + ")'");
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str2);
        }
        throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public DynaClass getDynaClass() {
        return this.dynaClass;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void remove(String str, String str2) {
        Object obj = this.values.get(str);
        if (obj == null) {
            throw new NullPointerException("No mapped value for '" + str + "(" + str2 + ")'");
        }
        if (obj instanceof Map) {
            ((Map) obj).remove(str2);
            return;
        }
        throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'");
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        DynaProperty dynaProperty = getDynaProperty(str);
        if (obj == null) {
            if (dynaProperty.getType().isPrimitive()) {
                throw new NullPointerException("Primitive value for '" + str + "'");
            }
        } else if (!isAssignable(dynaProperty.getType(), obj.getClass())) {
            throw new ConversionException("Cannot assign value of type '" + obj.getClass().getName() + "' to property '" + str + "' of type '" + dynaProperty.getType().getName() + "'");
        }
        this.values.put(str, obj);
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, int i, Object obj) {
        Object obj2 = this.values.get(str);
        if (obj2 == null) {
            throw new NullPointerException("No indexed value for '" + str + "[" + i + "]'");
        }
        if (obj2.getClass().isArray()) {
            Array.set(obj2, i, obj);
        } else {
            if (obj2 instanceof List) {
                try {
                    ((List) obj2).set(i, obj);
                    return;
                } catch (ClassCastException e) {
                    throw new ConversionException(e.getMessage());
                }
            }
            throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i + "]'");
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, String str2, Object obj) {
        Object obj2 = this.values.get(str);
        if (obj2 == null) {
            throw new NullPointerException("No mapped value for '" + str + "(" + str2 + ")'");
        }
        if (obj2 instanceof Map) {
            ((Map) obj2).put(str2, obj);
            return;
        }
        throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'");
    }

    protected DynaProperty getDynaProperty(String str) {
        DynaProperty dynaProperty = getDynaClass().getDynaProperty(str);
        if (dynaProperty != null) {
            return dynaProperty;
        }
        throw new IllegalArgumentException("Invalid property name '" + str + "'");
    }

    protected boolean isAssignable(Class<?> cls, Class<?> cls2) {
        if (cls.isAssignableFrom(cls2)) {
            return true;
        }
        if (cls == Boolean.TYPE && cls2 == Boolean.class) {
            return true;
        }
        if (cls == Byte.TYPE && cls2 == Byte.class) {
            return true;
        }
        if (cls == Character.TYPE && cls2 == Character.class) {
            return true;
        }
        if (cls == Double.TYPE && cls2 == Double.class) {
            return true;
        }
        if (cls == Float.TYPE && cls2 == Float.class) {
            return true;
        }
        if (cls == Integer.TYPE && cls2 == Integer.class) {
            return true;
        }
        if (cls == Long.TYPE && cls2 == Long.class) {
            return true;
        }
        return cls == Short.TYPE && cls2 == Short.class;
    }
}
