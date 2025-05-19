package org.apache.commons.beanutils.converters;

import java.util.Date;

/* loaded from: classes4.dex */
public final class DateConverter extends DateTimeConverter {
    public DateConverter() {
    }

    public DateConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return Date.class;
    }
}
