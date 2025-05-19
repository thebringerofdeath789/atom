package org.apache.commons.beanutils.converters;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes4.dex */
public final class SqlTimestampConverter extends DateTimeConverter {
    public SqlTimestampConverter() {
    }

    public SqlTimestampConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return Timestamp.class;
    }

    @Override // org.apache.commons.beanutils.converters.DateTimeConverter
    protected DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat dateTimeInstance;
        if (locale == null) {
            dateTimeInstance = DateFormat.getDateTimeInstance(3, 3);
        } else {
            dateTimeInstance = DateFormat.getDateTimeInstance(3, 3, locale);
        }
        if (timeZone != null) {
            dateTimeInstance.setTimeZone(timeZone);
        }
        return dateTimeInstance;
    }
}
