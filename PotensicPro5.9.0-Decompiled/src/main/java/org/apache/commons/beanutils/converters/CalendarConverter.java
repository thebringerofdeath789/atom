package org.apache.commons.beanutils.converters;

import java.util.Calendar;

/* loaded from: classes4.dex */
public final class CalendarConverter extends DateTimeConverter {
    public CalendarConverter() {
    }

    public CalendarConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return Calendar.class;
    }
}
