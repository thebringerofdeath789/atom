package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class CharacterArrayConverter extends AbstractArrayConverter {
    private static final char[] MODEL = new char[0];

    public CharacterArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    public CharacterArrayConverter(Object obj) {
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
        if (strings.getClass() == obj.getClass()) {
            try {
                String[] strArr = (String[]) obj;
                char[] cArr = new char[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    cArr[i] = strArr[i].charAt(0);
                }
                return cArr;
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
            char[] cArr2 = new char[size];
            for (int i2 = 0; i2 < size; i2++) {
                cArr2[i2] = ((String) parseElements.get(i2)).charAt(0);
            }
            return cArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
