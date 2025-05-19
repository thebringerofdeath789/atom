package org.apache.commons.beanutils.locale.converters;

import java.text.ParseException;
import java.util.Locale;

/* loaded from: classes4.dex */
public class LongLocaleConverter extends DecimalLocaleConverter {
    public LongLocaleConverter() {
        this(false);
    }

    public LongLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public LongLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public LongLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public LongLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public LongLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public LongLocaleConverter(Object obj) {
        this(obj, false);
    }

    public LongLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public LongLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public LongLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public LongLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public LongLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        Object parse = super.parse(obj, str);
        return (parse == null || (parse instanceof Long)) ? parse : new Long(((Number) parse).longValue());
    }
}
