package org.apache.commons.beanutils.converters;

/* loaded from: classes4.dex */
public final class IntegerConverter extends NumberConverter {
    public IntegerConverter() {
        super(false);
    }

    public IntegerConverter(Object obj) {
        super(false, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<Integer> getDefaultType() {
        return Integer.class;
    }
}
