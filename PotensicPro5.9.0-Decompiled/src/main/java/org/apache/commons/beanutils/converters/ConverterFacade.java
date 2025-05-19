package org.apache.commons.beanutils.converters;

import org.apache.commons.beanutils.Converter;

/* loaded from: classes4.dex */
public final class ConverterFacade implements Converter {
    private final Converter converter;

    public ConverterFacade(Converter converter) {
        if (converter == null) {
            throw new IllegalArgumentException("Converter is missing");
        }
        this.converter = converter;
    }

    @Override // org.apache.commons.beanutils.Converter
    public <T> T convert(Class<T> cls, Object obj) {
        return (T) this.converter.convert(cls, obj);
    }

    public String toString() {
        return "ConverterFacade[" + this.converter.toString() + "]";
    }
}
