package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* loaded from: classes4.dex */
public class ByteLocaleConverter extends DecimalLocaleConverter {
    public ByteLocaleConverter() {
        this(false);
    }

    public ByteLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public ByteLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public ByteLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public ByteLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public ByteLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public ByteLocaleConverter(Object obj) {
        this(obj, false);
    }

    public ByteLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public ByteLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public ByteLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public ByteLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public ByteLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        if (number.longValue() != number.byteValue()) {
            throw new ConversionException("Supplied number is not of type Byte: " + number.longValue());
        }
        return new Byte(number.byteValue());
    }
}
