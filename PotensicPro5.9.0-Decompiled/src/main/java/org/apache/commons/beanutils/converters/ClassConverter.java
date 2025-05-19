package org.apache.commons.beanutils.converters;

/* loaded from: classes4.dex */
public final class ClassConverter extends AbstractConverter {
    public ClassConverter() {
    }

    public ClassConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return Class.class;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected String convertToString(Object obj) {
        return obj instanceof Class ? ((Class) obj).getName() : obj.toString();
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (Class.class.equals(cls)) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                try {
                    return cls.cast(contextClassLoader.loadClass(obj.toString()));
                } catch (ClassNotFoundException unused) {
                }
            }
            return cls.cast(ClassConverter.class.getClassLoader().loadClass(obj.toString()));
        }
        throw conversionException(cls, obj);
    }
}
