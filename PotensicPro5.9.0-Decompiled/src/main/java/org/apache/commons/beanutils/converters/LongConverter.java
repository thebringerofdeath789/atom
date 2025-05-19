package org.apache.commons.beanutils.converters;

/* loaded from: classes4.dex */
public final class LongConverter extends NumberConverter {
    public LongConverter() {
        super(false);
    }

    public LongConverter(Object obj) {
        super(false, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<Long> getDefaultType() {
        return Long.class;
    }
}
