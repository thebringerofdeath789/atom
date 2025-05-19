package org.apache.commons.beanutils.converters;

import java.lang.reflect.Array;
import java.util.Collection;
import okhttp3.HttpUrl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public abstract class AbstractConverter implements Converter {
    private static final String DEFAULT_CONFIG_MSG = "(N.B. Converters can be configured to use default values to avoid throwing exceptions)";
    private static final String PACKAGE = "org.apache.commons.beanutils.converters.";
    private transient Log log;
    private boolean useDefault = false;
    private Object defaultValue = null;

    protected abstract <T> T convertToType(Class<T> cls, Object obj) throws Throwable;

    protected abstract Class<?> getDefaultType();

    public AbstractConverter() {
    }

    public AbstractConverter(Object obj) {
        setDefaultValue(obj);
    }

    public boolean isUseDefault() {
        return this.useDefault;
    }

    @Override // org.apache.commons.beanutils.Converter
    public <T> T convert(Class<T> cls, Object obj) {
        if (cls == null) {
            return (T) convertToDefaultType(cls, obj);
        }
        Class<?> cls2 = obj == null ? null : obj.getClass();
        Class<T> primitiveToWrapper = ConvertUtils.primitiveToWrapper(cls);
        if (log().isDebugEnabled()) {
            log().debug("Converting" + (obj == null ? "" : " '" + toString(cls2) + "'") + " value '" + obj + "' to type '" + toString(primitiveToWrapper) + "'");
        }
        Object convertArray = convertArray(obj);
        if (convertArray == null) {
            return (T) handleMissing(primitiveToWrapper);
        }
        Class<?> cls3 = convertArray.getClass();
        try {
            if (primitiveToWrapper.equals(String.class)) {
                return primitiveToWrapper.cast(convertToString(convertArray));
            }
            if (primitiveToWrapper.equals(cls3)) {
                if (log().isDebugEnabled()) {
                    log().debug("    No conversion required, value is already a " + toString(primitiveToWrapper));
                }
                return primitiveToWrapper.cast(convertArray);
            }
            Object convertToType = convertToType(primitiveToWrapper, convertArray);
            if (log().isDebugEnabled()) {
                log().debug("    Converted to " + toString(primitiveToWrapper) + " value '" + convertToType + "'");
            }
            return primitiveToWrapper.cast(convertToType);
        } catch (Throwable th) {
            return (T) handleError(primitiveToWrapper, convertArray, th);
        }
    }

    protected String convertToString(Object obj) throws Throwable {
        return obj.toString();
    }

    protected Object convertArray(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) > 0) {
                return Array.get(obj, 0);
            }
            return null;
        }
        if (!(obj instanceof Collection)) {
            return obj;
        }
        Collection collection = (Collection) obj;
        if (collection.size() > 0) {
            return collection.iterator().next();
        }
        return null;
    }

    protected <T> T handleError(Class<T> cls, Object obj, Throwable th) {
        if (log().isDebugEnabled()) {
            if (th instanceof ConversionException) {
                log().debug("    Conversion threw ConversionException: " + th.getMessage());
            } else {
                log().debug("    Conversion threw " + th);
            }
        }
        if (this.useDefault) {
            return (T) handleMissing(cls);
        }
        if (th instanceof ConversionException) {
            ConversionException conversionException = (ConversionException) th;
            if (log().isDebugEnabled()) {
                log().debug("    Re-throwing ConversionException: " + conversionException.getMessage());
                log().debug("    (N.B. Converters can be configured to use default values to avoid throwing exceptions)");
                throw conversionException;
            }
            throw conversionException;
        }
        String str = "Error converting from '" + toString(obj.getClass()) + "' to '" + toString(cls) + "' " + th.getMessage();
        ConversionException conversionException2 = new ConversionException(str, th);
        if (log().isDebugEnabled()) {
            log().debug("    Throwing ConversionException: " + str);
            log().debug("    (N.B. Converters can be configured to use default values to avoid throwing exceptions)");
        }
        BeanUtils.initCause(conversionException2, th);
        throw conversionException2;
    }

    protected <T> T handleMissing(Class<T> cls) {
        if (this.useDefault || cls.equals(String.class)) {
            Object obj = getDefault(cls);
            if (this.useDefault && obj != null && !cls.equals(obj.getClass())) {
                try {
                    obj = convertToType(cls, this.defaultValue);
                } catch (Throwable th) {
                    throw new ConversionException("Default conversion to " + toString(cls) + " failed.", th);
                }
            }
            if (log().isDebugEnabled()) {
                log().debug("    Using default " + (obj == null ? "" : toString(obj.getClass()) + StringUtils.SPACE) + "value '" + this.defaultValue + "'");
            }
            return cls.cast(obj);
        }
        ConversionException conversionException = new ConversionException("No value specified for '" + toString(cls) + "'");
        if (log().isDebugEnabled()) {
            log().debug("    Throwing ConversionException: " + conversionException.getMessage());
            log().debug("    (N.B. Converters can be configured to use default values to avoid throwing exceptions)");
            throw conversionException;
        }
        throw conversionException;
    }

    protected void setDefaultValue(Object obj) {
        this.useDefault = false;
        if (log().isDebugEnabled()) {
            log().debug("Setting default value: " + obj);
        }
        if (obj == null) {
            this.defaultValue = null;
        } else {
            this.defaultValue = convert(getDefaultType(), obj);
        }
        this.useDefault = true;
    }

    protected Object getDefault(Class<?> cls) {
        if (cls.equals(String.class)) {
            return null;
        }
        return this.defaultValue;
    }

    public String toString() {
        return toString(getClass()) + "[UseDefault=" + this.useDefault + "]";
    }

    Log log() {
        if (this.log == null) {
            this.log = LogFactory.getLog(getClass());
        }
        return this.log;
    }

    String toString(Class<?> cls) {
        String name;
        if (cls == null) {
            name = "null";
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            int i = 1;
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
                i++;
            }
            name = componentType.getName();
            for (int i2 = 0; i2 < i; i2++) {
                name = name + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
        } else {
            name = cls.getName();
        }
        if (name.startsWith("java.lang.") || name.startsWith("java.util.") || name.startsWith("java.math.")) {
            return name.substring(10);
        }
        return name.startsWith(PACKAGE) ? name.substring(40) : name;
    }

    private <T> T convertToDefaultType(Class<T> cls, Object obj) {
        return (T) convert(getDefaultType(), obj);
    }

    protected ConversionException conversionException(Class<?> cls, Object obj) {
        return new ConversionException("Can't convert value '" + obj + "' to type " + cls);
    }
}
