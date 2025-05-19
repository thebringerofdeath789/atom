package org.apache.commons.beanutils.locale.converters;

import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
public class SqlTimeLocaleConverter extends DateLocaleConverter {
    public SqlTimeLocaleConverter() {
        this(false);
    }

    public SqlTimeLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public SqlTimeLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public SqlTimeLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public SqlTimeLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public SqlTimeLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public SqlTimeLocaleConverter(Object obj) {
        this(obj, false);
    }

    public SqlTimeLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), false);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public SqlTimeLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DateLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        return new Time(((Date) super.parse(obj, str)).getTime());
    }
}
