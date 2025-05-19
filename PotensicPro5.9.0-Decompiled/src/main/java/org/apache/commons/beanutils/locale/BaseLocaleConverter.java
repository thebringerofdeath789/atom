package org.apache.commons.beanutils.locale;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public abstract class BaseLocaleConverter implements LocaleConverter {
    private Object defaultValue;
    protected boolean locPattern;
    protected Locale locale;
    private final Log log;
    protected String pattern;
    protected boolean useDefault;

    protected abstract Object parse(Object obj, String str) throws ParseException;

    protected BaseLocaleConverter(Locale locale, String str) {
        this(null, locale, str, false, false);
    }

    protected BaseLocaleConverter(Locale locale, String str, boolean z) {
        this(null, locale, str, false, z);
    }

    protected BaseLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    protected BaseLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        this(obj, locale, str, true, z);
    }

    private BaseLocaleConverter(Object obj, Locale locale, String str, boolean z, boolean z2) {
        this.log = LogFactory.getLog(BaseLocaleConverter.class);
        this.defaultValue = null;
        this.useDefault = false;
        this.locale = Locale.getDefault();
        this.pattern = null;
        this.locPattern = false;
        if (z) {
            this.defaultValue = obj;
            this.useDefault = true;
        }
        if (locale != null) {
            this.locale = locale;
        }
        this.pattern = str;
        this.locPattern = z2;
    }

    public Object convert(Object obj) {
        return convert(obj, (String) null);
    }

    public Object convert(Object obj, String str) {
        return convert(null, obj, str);
    }

    @Override // org.apache.commons.beanutils.Converter
    public <T> T convert(Class<T> cls, Object obj) {
        return (T) convert(cls, obj, null);
    }

    @Override // org.apache.commons.beanutils.locale.LocaleConverter
    public <T> T convert(Class<T> cls, Object obj, String str) {
        Class<T> primitiveToWrapper = ConvertUtils.primitiveToWrapper(cls);
        if (obj == null) {
            if (this.useDefault) {
                return (T) getDefaultAs(primitiveToWrapper);
            }
            this.log.debug("Null value specified for conversion, returing null");
            return null;
        }
        try {
            if (str != null) {
                return (T) checkConversionResult(primitiveToWrapper, parse(obj, str));
            }
            return (T) checkConversionResult(primitiveToWrapper, parse(obj, this.pattern));
        } catch (Exception e) {
            if (this.useDefault) {
                return (T) getDefaultAs(primitiveToWrapper);
            }
            if (e instanceof ConversionException) {
                throw ((ConversionException) e);
            }
            throw new ConversionException(e);
        }
    }

    private <T> T getDefaultAs(Class<T> cls) {
        return (T) checkConversionResult(cls, this.defaultValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T checkConversionResult(Class<T> cls, Object obj) {
        if (cls == null) {
            return obj;
        }
        if (obj == 0) {
            return null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new ConversionException("Unsupported target type: " + cls);
    }
}
