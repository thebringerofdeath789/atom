package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;

/* loaded from: classes4.dex */
public class DoubleLocaleConverter extends DecimalLocaleConverter {
    public DoubleLocaleConverter() {
        this(false);
    }

    public DoubleLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public DoubleLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DoubleLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public DoubleLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DoubleLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public DoubleLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DoubleLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public DoubleLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        Number number = (Number) super.parse(obj, str);
        return number instanceof Long ? new Double(number.doubleValue()) : number;
    }
}
