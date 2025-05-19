package org.apache.commons.beanutils.converters;

import java.io.File;

/* loaded from: classes4.dex */
public final class FileConverter extends AbstractConverter {
    public FileConverter() {
    }

    public FileConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return File.class;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (File.class.equals(cls)) {
            return cls.cast(new File(obj.toString()));
        }
        throw conversionException(cls, obj);
    }
}
