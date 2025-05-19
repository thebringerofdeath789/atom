package org.apache.poi.hpsf;

/* loaded from: classes4.dex */
public abstract class VariantTypeException extends HPSFException {
    private Object value;
    private long variantType;

    public VariantTypeException(long j, Object obj, String str) {
        super(str);
        this.variantType = j;
        this.value = obj;
    }

    public long getVariantType() {
        return this.variantType;
    }

    public Object getValue() {
        return this.value;
    }
}
