package org.apache.commons.beanutils.converters;

import java.net.URL;

/* loaded from: classes4.dex */
public final class URLConverter extends AbstractConverter {
    public URLConverter() {
    }

    public URLConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return URL.class;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (URL.class.equals(cls)) {
            return cls.cast(new URL(obj.toString()));
        }
        throw conversionException(cls, obj);
    }
}
