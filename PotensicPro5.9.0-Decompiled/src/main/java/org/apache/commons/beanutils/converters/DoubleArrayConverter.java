package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class DoubleArrayConverter extends AbstractArrayConverter {
    private static final double[] MODEL = new double[0];

    public DoubleArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public DoubleArrayConverter(Object obj) {
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
                double[] dArr = new double[strArr.length];
                while (i < strArr.length) {
                    dArr[i] = Double.parseDouble(strArr[i]);
                    i++;
                }
                return dArr;
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
            double[] dArr2 = new double[size];
            while (i < size) {
                dArr2[i] = Double.parseDouble((String) parseElements.get(i));
                i++;
            }
            return dArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
