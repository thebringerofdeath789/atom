package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class ByteArrayConverter extends AbstractArrayConverter {
    private static final byte[] MODEL = new byte[0];

    public ByteArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public ByteArrayConverter(Object obj) {
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
                byte[] bArr = new byte[strArr.length];
                while (i < strArr.length) {
                    bArr[i] = Byte.parseByte(strArr[i]);
                    i++;
                }
                return bArr;
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
            byte[] bArr2 = new byte[size];
            while (i < size) {
                bArr2[i] = Byte.parseByte((String) parseElements.get(i));
                i++;
            }
            return bArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
