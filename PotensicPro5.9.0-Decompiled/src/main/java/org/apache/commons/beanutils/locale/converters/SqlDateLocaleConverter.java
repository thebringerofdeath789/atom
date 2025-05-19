package org.apache.commons.beanutils.locale.converters;

import java.sql.Date;
import java.text.ParseException;
import java.util.Locale;

/* loaded from: classes4.dex */
public class SqlDateLocaleConverter extends DateLocaleConverter {
    public SqlDateLocaleConverter() {
        this(false);
    }

    public SqlDateLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public SqlDateLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public SqlDateLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public SqlDateLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public SqlDateLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public SqlDateLocaleConverter(Object obj) {
        this(obj, false);
    }

    public SqlDateLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DateLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        return new Date(((java.util.Date) super.parse(obj, str)).getTime());
    }
}
