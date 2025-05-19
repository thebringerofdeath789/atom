package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* loaded from: classes4.dex */
public class IntegerLocaleConverter extends DecimalLocaleConverter {
    public IntegerLocaleConverter() {
        this(false);
    }

    public IntegerLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public IntegerLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public IntegerLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public IntegerLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public IntegerLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public IntegerLocaleConverter(Object obj) {
        this(obj, false);
    }

    public IntegerLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public IntegerLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        if (number.longValue() != number.intValue()) {
            throw new ConversionException("Suplied number is not of type Integer: " + number.longValue());
        }
        return new Integer(number.intValue());
    }
}
