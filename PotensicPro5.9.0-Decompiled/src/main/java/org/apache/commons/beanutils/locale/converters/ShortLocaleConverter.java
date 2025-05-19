package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* loaded from: classes4.dex */
public class ShortLocaleConverter extends DecimalLocaleConverter {
    public ShortLocaleConverter() {
        this(false);
    }

    public ShortLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public ShortLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public ShortLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public ShortLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public ShortLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public ShortLocaleConverter(Object obj) {
        this(obj, false);
    }

    public ShortLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public ShortLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public ShortLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public ShortLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public ShortLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        Object parse = super.parse(obj, str);
        if (parse == null || (parse instanceof Short)) {
            return parse;
        }
        Number number = (Number) parse;
        if (number.longValue() != number.shortValue()) {
            throw new ConversionException("Supplied number is not of type Short: " + number.longValue());
        }
        return new Short(number.shortValue());
    }
}
