package org.apache.commons.beanutils.locale.converters;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* loaded from: classes4.dex */
public class BigDecimalLocaleConverter extends DecimalLocaleConverter {
    public BigDecimalLocaleConverter() {
        this(false);
    }

    public BigDecimalLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public BigDecimalLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public BigDecimalLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public BigDecimalLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public BigDecimalLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public BigDecimalLocaleConverter(Object obj) {
        this(obj, false);
    }

    public BigDecimalLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        Object parse = super.parse(obj, str);
        if (parse == null || (parse instanceof BigDecimal)) {
            return parse;
        }
        try {
            return new BigDecimal(parse.toString());
        } catch (NumberFormatException unused) {
            throw new ConversionException("Suplied number is not of type BigDecimal: " + parse);
        }
    }
}
