package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class LongArrayConverter extends AbstractArrayConverter {
    private static final long[] MODEL = new long[0];

    public LongArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public LongArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractArrayConverter, org.apache.commons.beanutils.Converter
    public Object convert(Class cls, Object obj) {
        if (obj == null) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException("No value specified");
        }
        if (MODEL.getClass() == obj.getClass()) {
            return obj;
        }
        int i = 0;
        if (strings.getClass() == obj.getClass()) {
            try {
                String[] strArr = (String[]) obj;
                long[] jArr = new long[strArr.length];
                while (i < strArr.length) {
                    jArr[i] = Long.parseLong(strArr[i]);
                    i++;
                }
                return jArr;
            } catch (Exception e) {
                if (this.useDefault) {
                    return this.defaultValue;
                }
                throw new ConversionException(obj.toString(), e);
            }
        }
        try {
            List parseElements = parseElements(obj.toString());
            int size = parseElements.size();
            long[] jArr2 = new long[size];
            while (i < size) {
                jArr2[i] = Long.parseLong((String) parseElements.get(i));
                i++;
            }
            return jArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
