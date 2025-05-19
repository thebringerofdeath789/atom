package org.apache.commons.beanutils;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class LazyDynaBean implements DynaBean, Serializable {
    protected MutableDynaClass dynaClass;
    private transient Log logger;
    private transient Map<String, Object> mapDecorator;
    protected Map<String, Object> values;
    protected static final BigInteger BigInteger_ZERO = new BigInteger(SessionDescription.SUPPORTED_SDP_VERSION);
    protected static final BigDecimal BigDecimal_ZERO = new BigDecimal(SessionDescription.SUPPORTED_SDP_VERSION);
    protected static final Character Character_SPACE = new Character(' ');
    protected static final Byte Byte_ZERO = new Byte((byte) 0);
    protected static final Short Short_ZERO = new Short((short) 0);
    protected static final Integer Integer_ZERO = new Integer(0);
    protected static final Long Long_ZERO = new Long(0);
    protected static final Float Float_ZERO = new Float(0.0f);
    protected static final Double Double_ZERO = new Double(0.0d);

    protected Object createNumberProperty(String str, Class<?> cls) {
        return null;
    }

    public LazyDynaBean() {
        this(new LazyDynaClass());
    }

    public LazyDynaBean(String str) {
        this(new LazyDynaClass(str));
    }

    public LazyDynaBean(DynaClass dynaClass) {
        this.logger = LogFactory.getLog(LazyDynaBean.class);
        this.values = newMap();
        if (dynaClass instanceof MutableDynaClass) {
            this.dynaClass = (MutableDynaClass) dynaClass;
        } else {
            this.dynaClass = new LazyDynaClass(dynaClass.getName(), dynaClass.getDynaProperties());
        }
    }

    public Map<String, Object> getMap() {
        if (this.mapDecorator == null) {
            this.mapDecorator = new DynaBeanPropertyMapDecorator(this);
        }
        return this.mapDecorator;
    }

    public int size(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof List) {
            return ((List) obj).size();
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        return 0;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public boolean contains(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj != null && (obj instanceof Map)) {
            return ((Map) obj).containsKey(str2);
        }
        return false;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj != null) {
            return obj;
        }
        if (!isDynaProperty(str)) {
            return null;
        }
        Object createProperty = createProperty(str, this.dynaClass.getDynaProperty(str).getType());
        if (createProperty != null) {
            set(str, createProperty);
        }
        return createProperty;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, int i) {
        if (!isDynaProperty(str)) {
            set(str, defaultIndexedProperty(str));
        }
        Object obj = get(str);
        if (!this.dynaClass.getDynaProperty(str).isIndexed()) {
            throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i + "]' " + this.dynaClass.getDynaProperty(str).getName());
        }
        Object growIndexedProperty = growIndexedProperty(str, obj, i);
        if (growIndexedProperty.getClass().isArray()) {
            return Array.get(growIndexedProperty, i);
        }
        if (growIndexedProperty instanceof List) {
            return ((List) growIndexedProperty).get(i);
        }
        throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i + "]' " + growIndexedProperty.getClass().getName());
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public Object get(String str, String str2) {
        if (!isDynaProperty(str)) {
            set(str, defaultMappedProperty(str));
        }
        Object obj = get(str);
        if (!this.dynaClass.getDynaProperty(str).isMapped()) {
            throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")' " + this.dynaClass.getDynaProperty(str).getType().getName());
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str2);
        }
        throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'" + obj.getClass().getName());
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public DynaClass getDynaClass() {
        return this.dynaClass;
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void remove(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        Object obj = this.values.get(str);
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            ((Map) obj).remove(str2);
            return;
        }
        throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'" + obj.getClass().getName());
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        if (!isDynaProperty(str)) {
            if (this.dynaClass.isRestricted()) {
                throw new IllegalArgumentException("Invalid property name '" + str + "' (DynaClass is restricted)");
            }
            if (obj == null) {
                this.dynaClass.add(str);
            } else {
                this.dynaClass.add(str, obj.getClass());
            }
        }
        DynaProperty dynaProperty = this.dynaClass.getDynaProperty(str);
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
        if (!isDynaProperty(str)) {
            set(str, defaultIndexedProperty(str));
        }
        Object obj2 = get(str);
        if (!this.dynaClass.getDynaProperty(str).isIndexed()) {
            throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i + "]'" + this.dynaClass.getDynaProperty(str).getType().getName());
        }
        Object growIndexedProperty = growIndexedProperty(str, obj2, i);
        if (growIndexedProperty.getClass().isArray()) {
            Array.set(growIndexedProperty, i, obj);
        } else {
            if (growIndexedProperty instanceof List) {
                ((List) growIndexedProperty).set(i, obj);
                return;
            }
            throw new IllegalArgumentException("Non-indexed property for '" + str + "[" + i + "]' " + growIndexedProperty.getClass().getName());
        }
    }

    @Override // org.apache.commons.beanutils.DynaBean
    public void set(String str, String str2, Object obj) {
        if (!isDynaProperty(str)) {
            set(str, defaultMappedProperty(str));
        }
        Object obj2 = get(str);
        if (!this.dynaClass.getDynaProperty(str).isMapped()) {
            throw new IllegalArgumentException("Non-mapped property for '" + str + "(" + str2 + ")'" + this.dynaClass.getDynaProperty(str).getType().getName());
        }
        ((Map) obj2).put(str2, obj);
    }

    protected Object growIndexedProperty(String str, Object obj, int i) {
        int length;
        if (obj instanceof List) {
            List list = (List) obj;
            while (i >= list.size()) {
                Class<?> contentType = getDynaClass().getDynaProperty(str).getContentType();
                Object obj2 = null;
                if (contentType != null) {
                    obj2 = createProperty(str + "[" + list.size() + "]", contentType);
                }
                list.add(obj2);
            }
        }
        if (!obj.getClass().isArray() || i < (length = Array.getLength(obj))) {
            return obj;
        }
        Class<?> componentType = obj.getClass().getComponentType();
        Object newInstance = Array.newInstance(componentType, i + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        set(str, newInstance);
        int length2 = Array.getLength(newInstance);
        while (length < length2) {
            Array.set(newInstance, length, createProperty(str + "[" + length + "]", componentType));
            length++;
        }
        return newInstance;
    }

    protected Object createProperty(String str, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isArray() || List.class.isAssignableFrom(cls)) {
            return createIndexedProperty(str, cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return createMappedProperty(str, cls);
        }
        if (DynaBean.class.isAssignableFrom(cls)) {
            return createDynaBeanProperty(str, cls);
        }
        if (cls.isPrimitive()) {
            return createPrimitiveProperty(str, cls);
        }
        if (Number.class.isAssignableFrom(cls)) {
            return createNumberProperty(str, cls);
        }
        return createOtherProperty(str, cls);
    }

    protected Object createIndexedProperty(String str, Class<?> cls) {
        if (cls == null) {
            return defaultIndexedProperty(str);
        }
        if (cls.isArray()) {
            return Array.newInstance(cls.getComponentType(), 0);
        }
        if (List.class.isAssignableFrom(cls)) {
            if (cls.isInterface()) {
                return defaultIndexedProperty(str);
            }
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("Error instantiating indexed property of type '" + cls.getName() + "' for '" + str + "' " + e);
            }
        }
        throw new IllegalArgumentException("Non-indexed property of type '" + cls.getName() + "' for '" + str + "'");
    }

    protected Object createMappedProperty(String str, Class<?> cls) {
        if (cls == null) {
            return defaultMappedProperty(str);
        }
        if (cls.isInterface()) {
            return defaultMappedProperty(str);
        }
        if (Map.class.isAssignableFrom(cls)) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("Error instantiating mapped property of type '" + cls.getName() + "' for '" + str + "' " + e);
            }
        }
        throw new IllegalArgumentException("Non-mapped property of type '" + cls.getName() + "' for '" + str + "'");
    }

    protected Object createDynaBeanProperty(String str, Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e) {
            if (!logger().isWarnEnabled()) {
                return null;
            }
            logger().warn("Error instantiating DynaBean property of type '" + cls.getName() + "' for '" + str + "' " + e);
            return null;
        }
    }

    protected Object createPrimitiveProperty(String str, Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Integer.TYPE) {
            return Integer_ZERO;
        }
        if (cls == Long.TYPE) {
            return Long_ZERO;
        }
        if (cls == Double.TYPE) {
            return Double_ZERO;
        }
        if (cls == Float.TYPE) {
            return Float_ZERO;
        }
        if (cls == Byte.TYPE) {
            return Byte_ZERO;
        }
        if (cls == Short.TYPE) {
            return Short_ZERO;
        }
        if (cls == Character.TYPE) {
            return Character_SPACE;
        }
        return null;
    }

    protected Object createOtherProperty(String str, Class<?> cls) {
        if (cls != Object.class && cls != String.class && cls != Boolean.class && cls != Character.class && !Date.class.isAssignableFrom(cls)) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                if (logger().isWarnEnabled()) {
                    logger().warn("Error instantiating property of type '" + cls.getName() + "' for '" + str + "' " + e);
                }
            }
        }
        return null;
    }

    protected Object defaultIndexedProperty(String str) {
        return new ArrayList();
    }

    protected Map<String, Object> defaultMappedProperty(String str) {
        return new HashMap();
    }

    protected boolean isDynaProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No property name specified");
        }
        MutableDynaClass mutableDynaClass = this.dynaClass;
        if (mutableDynaClass instanceof LazyDynaClass) {
            return ((LazyDynaClass) mutableDynaClass).isDynaProperty(str);
        }
        return mutableDynaClass.getDynaProperty(str) != null;
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

    protected Map<String, Object> newMap() {
        return new HashMap();
    }

    private Log logger() {
        if (this.logger == null) {
            this.logger = LogFactory.getLog(LazyDynaBean.class);
        }
        return this.logger;
    }
}
