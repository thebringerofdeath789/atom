package org.apache.commons.beanutils.converters;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class BigIntegerConverter extends NumberConverter {
    public BigIntegerConverter() {
        super(false);
    }

    public BigIntegerConverter(Object obj) {
        super(false, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<BigInteger> getDefaultType() {
        return BigInteger.class;
    }
}
