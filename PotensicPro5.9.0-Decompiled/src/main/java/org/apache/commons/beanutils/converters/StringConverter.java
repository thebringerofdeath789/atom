package org.apache.commons.beanutils.converters;

/* loaded from: classes4.dex */
public final class StringConverter extends AbstractConverter {
    public StringConverter() {
    }

    public StringConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return String.class;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (String.class.equals(cls) || Object.class.equals(cls)) {
            return cls.cast(obj.toString());
        }
        throw conversionException(cls, obj);
    }
}
