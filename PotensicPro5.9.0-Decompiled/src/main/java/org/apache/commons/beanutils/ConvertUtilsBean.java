package org.apache.commons.beanutils;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.CalendarConverter;
import org.apache.commons.beanutils.converters.CharacterConverter;
import org.apache.commons.beanutils.converters.ClassConverter;
import org.apache.commons.beanutils.converters.ConverterFacade;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FileConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimeConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.commons.beanutils.converters.URLConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class ConvertUtilsBean {
    private final WeakFastHashMap<Class<?>, Converter> converters;

    @Deprecated
    private Boolean defaultBoolean;

    @Deprecated
    private Byte defaultByte;

    @Deprecated
    private Character defaultCharacter;

    @Deprecated
    private Double defaultDouble;

    @Deprecated
    private Float defaultFloat;

    @Deprecated
    private Integer defaultInteger;

    @Deprecated
    private Long defaultLong;
    private final Log log;
    private static final Integer ZERO = new Integer(0);
    private static final Character SPACE = new Character(' ');

    @Deprecated
    private static Short defaultShort = new Short((short) 0);

    protected static ConvertUtilsBean getInstance() {
        return BeanUtilsBean.getInstance().getConvertUtils();
    }

    public ConvertUtilsBean() {
        WeakFastHashMap<Class<?>, Converter> weakFastHashMap = new WeakFastHashMap<>();
        this.converters = weakFastHashMap;
        this.log = LogFactory.getLog(ConvertUtils.class);
        this.defaultBoolean = Boolean.FALSE;
        this.defaultByte = new Byte((byte) 0);
        this.defaultCharacter = new Character(' ');
        this.defaultDouble = new Double(0.0d);
        this.defaultFloat = new Float(0.0f);
        this.defaultInteger = new Integer(0);
        this.defaultLong = new Long(0L);
        weakFastHashMap.setFast(false);
        deregister();
        weakFastHashMap.setFast(true);
    }

    @Deprecated
    public boolean getDefaultBoolean() {
        return this.defaultBoolean.booleanValue();
    }

    @Deprecated
    public void setDefaultBoolean(boolean z) {
        this.defaultBoolean = z ? Boolean.TRUE : Boolean.FALSE;
        register(new BooleanConverter(this.defaultBoolean), Boolean.TYPE);
        register(new BooleanConverter(this.defaultBoolean), Boolean.class);
    }

    @Deprecated
    public byte getDefaultByte() {
        return this.defaultByte.byteValue();
    }

    @Deprecated
    public void setDefaultByte(byte b) {
        this.defaultByte = new Byte(b);
        register(new ByteConverter(this.defaultByte), Byte.TYPE);
        register(new ByteConverter(this.defaultByte), Byte.class);
    }

    @Deprecated
    public char getDefaultCharacter() {
        return this.defaultCharacter.charValue();
    }

    @Deprecated
    public void setDefaultCharacter(char c) {
        this.defaultCharacter = new Character(c);
        register(new CharacterConverter(this.defaultCharacter), Character.TYPE);
        register(new CharacterConverter(this.defaultCharacter), Character.class);
    }

    @Deprecated
    public double getDefaultDouble() {
        return this.defaultDouble.doubleValue();
    }

    @Deprecated
    public void setDefaultDouble(double d) {
        this.defaultDouble = new Double(d);
        register(new DoubleConverter(this.defaultDouble), Double.TYPE);
        register(new DoubleConverter(this.defaultDouble), Double.class);
    }

    @Deprecated
    public float getDefaultFloat() {
        return this.defaultFloat.floatValue();
    }

    @Deprecated
    public void setDefaultFloat(float f) {
        this.defaultFloat = new Float(f);
        register(new FloatConverter(this.defaultFloat), Float.TYPE);
        register(new FloatConverter(this.defaultFloat), Float.class);
    }

    @Deprecated
    public int getDefaultInteger() {
        return this.defaultInteger.intValue();
    }

    @Deprecated
    public void setDefaultInteger(int i) {
        this.defaultInteger = new Integer(i);
        register(new IntegerConverter(this.defaultInteger), Integer.TYPE);
        register(new IntegerConverter(this.defaultInteger), Integer.class);
    }

    @Deprecated
    public long getDefaultLong() {
        return this.defaultLong.longValue();
    }

    @Deprecated
    public void setDefaultLong(long j) {
        this.defaultLong = new Long(j);
        register(new LongConverter(this.defaultLong), Long.TYPE);
        register(new LongConverter(this.defaultLong), Long.class);
    }

    @Deprecated
    public short getDefaultShort() {
        return defaultShort.shortValue();
    }

    @Deprecated
    public void setDefaultShort(short s) {
        defaultShort = new Short(s);
        register(new ShortConverter(defaultShort), Short.TYPE);
        register(new ShortConverter(defaultShort), Short.class);
    }

    public String convert(Object obj) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) >= 1 && (obj2 = Array.get(obj, 0)) != null) {
                return (String) lookup(String.class).convert(String.class, obj2);
            }
            return null;
        }
        return (String) lookup(String.class).convert(String.class, obj);
    }

    public Object convert(String str, Class<?> cls) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Convert string '" + str + "' to class '" + cls.getName() + "'");
        }
        Converter lookup = lookup(cls);
        if (lookup == null) {
            lookup = lookup(String.class);
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("  Using converter " + lookup);
        }
        return lookup.convert(cls, str);
    }

    public Object convert(String[] strArr, Class<?> cls) {
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Convert String[" + strArr.length + "] to class '" + cls.getName() + "[]'");
        }
        Converter lookup = lookup(cls);
        if (lookup == null) {
            lookup = lookup(String.class);
        }
        if (this.log.isTraceEnabled()) {
            this.log.trace("  Using converter " + lookup);
        }
        Object newInstance = Array.newInstance(cls, strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            Array.set(newInstance, i, lookup.convert(cls, strArr[i]));
        }
        return newInstance;
    }

    public Object convert(Object obj, Class<?> cls) {
        Class<?> cls2 = obj == null ? null : obj.getClass();
        if (this.log.isDebugEnabled()) {
            if (obj == null) {
                this.log.debug("Convert null value to type '" + cls.getName() + "'");
            } else {
                this.log.debug("Convert type '" + cls2.getName() + "' value '" + obj + "' to type '" + cls.getName() + "'");
            }
        }
        Converter lookup = lookup(cls2, cls);
        if (lookup != null) {
            if (this.log.isTraceEnabled()) {
                this.log.trace("  Using converter " + lookup);
            }
            obj = lookup.convert(cls, obj);
        }
        if (!String.class.equals(cls) || obj == null || (obj instanceof String)) {
            return obj;
        }
        Converter lookup2 = lookup(String.class);
        if (lookup2 != null) {
            if (this.log.isTraceEnabled()) {
                this.log.trace("  Using converter " + lookup2);
            }
            obj = lookup2.convert(String.class, obj);
        }
        return (obj == null || (obj instanceof String)) ? obj : obj.toString();
    }

    public void deregister() {
        this.converters.clear();
        registerPrimitives(false);
        registerStandard(false, false);
        registerOther(true);
        registerArrays(false, 0);
        register(BigDecimal.class, new BigDecimalConverter());
        register(BigInteger.class, new BigIntegerConverter());
    }

    public void register(boolean z, boolean z2, int i) {
        registerPrimitives(z);
        registerStandard(z, z2);
        registerOther(z);
        registerArrays(z, i);
    }

    private void registerPrimitives(boolean z) {
        register(Boolean.TYPE, z ? new BooleanConverter() : new BooleanConverter(Boolean.FALSE));
        register(Byte.TYPE, z ? new ByteConverter() : new ByteConverter(ZERO));
        register(Character.TYPE, z ? new CharacterConverter() : new CharacterConverter(SPACE));
        register(Double.TYPE, z ? new DoubleConverter() : new DoubleConverter(ZERO));
        register(Float.TYPE, z ? new FloatConverter() : new FloatConverter(ZERO));
        register(Integer.TYPE, z ? new IntegerConverter() : new IntegerConverter(ZERO));
        register(Long.TYPE, z ? new LongConverter() : new LongConverter(ZERO));
        register(Short.TYPE, z ? new ShortConverter() : new ShortConverter(ZERO));
    }

    private void registerStandard(boolean z, boolean z2) {
        Integer num = z2 ? null : ZERO;
        BigDecimal bigDecimal = z2 ? null : new BigDecimal("0.0");
        BigInteger bigInteger = z2 ? null : new BigInteger(SessionDescription.SUPPORTED_SDP_VERSION);
        Boolean bool = z2 ? null : Boolean.FALSE;
        Character ch = z2 ? null : SPACE;
        String str = z2 ? null : "";
        register(BigDecimal.class, z ? new BigDecimalConverter() : new BigDecimalConverter(bigDecimal));
        register(BigInteger.class, z ? new BigIntegerConverter() : new BigIntegerConverter(bigInteger));
        register(Boolean.class, z ? new BooleanConverter() : new BooleanConverter(bool));
        register(Byte.class, z ? new ByteConverter() : new ByteConverter(num));
        register(Character.class, z ? new CharacterConverter() : new CharacterConverter(ch));
        register(Double.class, z ? new DoubleConverter() : new DoubleConverter(num));
        register(Float.class, z ? new FloatConverter() : new FloatConverter(num));
        register(Integer.class, z ? new IntegerConverter() : new IntegerConverter(num));
        register(Long.class, z ? new LongConverter() : new LongConverter(num));
        register(Short.class, z ? new ShortConverter() : new ShortConverter(num));
        register(String.class, z ? new StringConverter() : new StringConverter(str));
    }

    private void registerOther(boolean z) {
        register(Class.class, z ? new ClassConverter() : new ClassConverter(null));
        register(Date.class, z ? new DateConverter() : new DateConverter(null));
        register(Calendar.class, z ? new CalendarConverter() : new CalendarConverter(null));
        register(File.class, z ? new FileConverter() : new FileConverter(null));
        register(java.sql.Date.class, z ? new SqlDateConverter() : new SqlDateConverter(null));
        register(Time.class, z ? new SqlTimeConverter() : new SqlTimeConverter(null));
        register(Timestamp.class, z ? new SqlTimestampConverter() : new SqlTimestampConverter(null));
        register(URL.class, z ? new URLConverter() : new URLConverter(null));
    }

    private void registerArrays(boolean z, int i) {
        registerArrayConverter(Boolean.TYPE, new BooleanConverter(), z, i);
        registerArrayConverter(Byte.TYPE, new ByteConverter(), z, i);
        registerArrayConverter(Character.TYPE, new CharacterConverter(), z, i);
        registerArrayConverter(Double.TYPE, new DoubleConverter(), z, i);
        registerArrayConverter(Float.TYPE, new FloatConverter(), z, i);
        registerArrayConverter(Integer.TYPE, new IntegerConverter(), z, i);
        registerArrayConverter(Long.TYPE, new LongConverter(), z, i);
        registerArrayConverter(Short.TYPE, new ShortConverter(), z, i);
        registerArrayConverter(BigDecimal.class, new BigDecimalConverter(), z, i);
        registerArrayConverter(BigInteger.class, new BigIntegerConverter(), z, i);
        registerArrayConverter(Boolean.class, new BooleanConverter(), z, i);
        registerArrayConverter(Byte.class, new ByteConverter(), z, i);
        registerArrayConverter(Character.class, new CharacterConverter(), z, i);
        registerArrayConverter(Double.class, new DoubleConverter(), z, i);
        registerArrayConverter(Float.class, new FloatConverter(), z, i);
        registerArrayConverter(Integer.class, new IntegerConverter(), z, i);
        registerArrayConverter(Long.class, new LongConverter(), z, i);
        registerArrayConverter(Short.class, new ShortConverter(), z, i);
        registerArrayConverter(String.class, new StringConverter(), z, i);
        registerArrayConverter(Class.class, new ClassConverter(), z, i);
        registerArrayConverter(Date.class, new DateConverter(), z, i);
        registerArrayConverter(Calendar.class, new DateConverter(), z, i);
        registerArrayConverter(File.class, new FileConverter(), z, i);
        registerArrayConverter(java.sql.Date.class, new SqlDateConverter(), z, i);
        registerArrayConverter(Time.class, new SqlTimeConverter(), z, i);
        registerArrayConverter(Timestamp.class, new SqlTimestampConverter(), z, i);
        registerArrayConverter(URL.class, new URLConverter(), z, i);
    }

    private void registerArrayConverter(Class<?> cls, Converter converter, boolean z, int i) {
        ArrayConverter arrayConverter;
        Class<?> cls2 = Array.newInstance(cls, 0).getClass();
        if (z) {
            arrayConverter = new ArrayConverter(cls2, converter);
        } else {
            arrayConverter = new ArrayConverter(cls2, converter, i);
        }
        register(cls2, arrayConverter);
    }

    private void register(Class<?> cls, Converter converter) {
        register(new ConverterFacade(converter), cls);
    }

    public void deregister(Class<?> cls) {
        this.converters.remove(cls);
    }

    public Converter lookup(Class<?> cls) {
        return this.converters.get(cls);
    }

    public Converter lookup(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            throw new IllegalArgumentException("Target type is missing");
        }
        if (cls == null) {
            return lookup(cls2);
        }
        if (cls2 == String.class) {
            Converter lookup = lookup(cls);
            if (lookup == null && (cls.isArray() || Collection.class.isAssignableFrom(cls))) {
                lookup = lookup(String[].class);
            }
            return lookup == null ? lookup(String.class) : lookup;
        }
        if (cls2 == String[].class) {
            Converter lookup2 = (cls.isArray() || Collection.class.isAssignableFrom(cls)) ? lookup(cls) : null;
            return lookup2 == null ? lookup(String[].class) : lookup2;
        }
        return lookup(cls2);
    }

    public void register(Converter converter, Class<?> cls) {
        this.converters.put(cls, converter);
    }
}
