package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class FloatArrayConverter extends AbstractArrayConverter {
    private static final float[] MODEL = new float[0];

    public FloatArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public FloatArrayConverter(Object obj) {
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
                float[] fArr = new float[strArr.length];
                while (i < strArr.length) {
                    fArr[i] = Float.parseFloat(strArr[i]);
                    i++;
                }
                return fArr;
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
            float[] fArr2 = new float[size];
            while (i < size) {
                fArr2[i] = Float.parseFloat((String) parseElements.get(i));
                i++;
            }
            return fArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
