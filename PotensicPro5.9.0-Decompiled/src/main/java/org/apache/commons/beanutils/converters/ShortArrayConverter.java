package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class ShortArrayConverter extends AbstractArrayConverter {
    private static final short[] MODEL = new short[0];

    public ShortArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public ShortArrayConverter(Object obj) {
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
                short[] sArr = new short[strArr.length];
                while (i < strArr.length) {
                    sArr[i] = Short.parseShort(strArr[i]);
                    i++;
                }
                return sArr;
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
            short[] sArr2 = new short[size];
            while (i < size) {
                sArr2[i] = Short.parseShort((String) parseElements.get(i));
                i++;
            }
            return sArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
