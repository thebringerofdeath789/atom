package org.apache.commons.beanutils.converters;

import java.math.BigDecimal;

/* loaded from: classes4.dex */
public final class BigDecimalConverter extends NumberConverter {
    public BigDecimalConverter() {
        super(true);
    }

    public BigDecimalConverter(Object obj) {
        super(true, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<BigDecimal> getDefaultType() {
        return BigDecimal.class;
    }
}
