package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class IntegerArrayConverter extends AbstractArrayConverter {
    private static final int[] MODEL = new int[0];

    public IntegerArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public IntegerArrayConverter(Object obj) {
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
                int[] iArr = new int[strArr.length];
                while (i < strArr.length) {
                    iArr[i] = Integer.parseInt(strArr[i]);
                    i++;
                }
                return iArr;
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
            int[] iArr2 = new int[size];
            while (i < size) {
                iArr2[i] = Integer.parseInt((String) parseElements.get(i));
                i++;
            }
            return iArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
