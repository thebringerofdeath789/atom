package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* loaded from: classes4.dex */
public class FloatLocaleConverter extends DecimalLocaleConverter {
    public FloatLocaleConverter() {
        this(false);
    }

    public FloatLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public FloatLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public FloatLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public FloatLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public FloatLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public FloatLocaleConverter(Object obj) {
        this(obj, false);
    }

    public FloatLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public FloatLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public FloatLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public FloatLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public FloatLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        double doubleValue = number.doubleValue();
        if (doubleValue < 0.0d) {
            doubleValue *= -1.0d;
        }
        if (doubleValue != 0.0d && (doubleValue < 1.401298464324817E-45d || doubleValue > 3.4028234663852886E38d)) {
            throw new ConversionException("Supplied number is not of type Float: " + number);
        }
        return new Float(number.floatValue());
    }
}
