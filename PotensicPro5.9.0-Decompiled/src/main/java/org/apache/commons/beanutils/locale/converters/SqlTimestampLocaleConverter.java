package org.apache.commons.beanutils.locale.converters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
public class SqlTimestampLocaleConverter extends DateLocaleConverter {
    public SqlTimestampLocaleConverter() {
        this(false);
    }

    public SqlTimestampLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public SqlTimestampLocaleConverter(Locale locale) {
        this(locale, (String) null);
    }

    public SqlTimestampLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null);
    }

    public SqlTimestampLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public SqlTimestampLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public SqlTimestampLocaleConverter(Object obj) {
        this(obj, false);
    }

    public SqlTimestampLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public SqlTimestampLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DateLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        return new Timestamp(((Date) super.parse(obj, str)).getTime());
    }
}
