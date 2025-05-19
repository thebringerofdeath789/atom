package org.apache.commons.beanutils.converters;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes4.dex */
public final class SqlTimeConverter extends DateTimeConverter {
    public SqlTimeConverter() {
    }

    public SqlTimeConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return Time.class;
    }

    @Override // org.apache.commons.beanutils.converters.DateTimeConverter
    protected DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat timeInstance;
        if (locale == null) {
            timeInstance = DateFormat.getTimeInstance(3);
        } else {
            timeInstance = DateFormat.getTimeInstance(3, locale);
        }
        if (timeZone != null) {
            timeInstance.setTimeZone(timeZone);
        }
        return timeInstance;
    }
}
