package org.apache.commons.beanutils.converters;

/* loaded from: classes4.dex */
public final class CharacterConverter extends AbstractConverter {
    public CharacterConverter() {
    }

    public CharacterConverter(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return Character.class;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected String convertToString(Object obj) {
        String obj2 = obj.toString();
        return obj2.length() == 0 ? "" : obj2.substring(0, 1);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Exception {
        if (Character.class.equals(cls) || Character.TYPE.equals(cls)) {
            return cls.cast(new Character(obj.toString().charAt(0)));
        }
        throw conversionException(cls, obj);
    }
}
