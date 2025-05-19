package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class StringArrayConverter extends AbstractArrayConverter {
    private static final String[] MODEL = new String[0];
    private static final int[] INT_MODEL = new int[0];

    public StringArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public StringArrayConverter(Object obj) {
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
        if (INT_MODEL.getClass() == obj.getClass()) {
            int[] iArr = (int[]) obj;
            String[] strArr = new String[iArr.length];
            while (i < iArr.length) {
                strArr[i] = Integer.toString(iArr[i]);
                i++;
            }
            return strArr;
        }
        try {
            List parseElements = parseElements(obj.toString());
            int size = parseElements.size();
            String[] strArr2 = new String[size];
            while (i < size) {
                strArr2[i] = (String) parseElements.get(i);
                i++;
            }
            return strArr2;
        } catch (Exception e) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e);
        }
    }
}
