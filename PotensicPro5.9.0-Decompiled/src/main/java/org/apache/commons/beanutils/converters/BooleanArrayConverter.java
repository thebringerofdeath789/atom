package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

@Deprecated
/* loaded from: classes4.dex */
public final class BooleanArrayConverter extends AbstractArrayConverter {
    protected final BooleanConverter booleanConverter;
    public static final Class MODEL = new boolean[0].getClass();
    private static final BooleanConverter DEFAULT_CONVERTER = new BooleanConverter();

    public BooleanArrayConverter() {
        this.booleanConverter = DEFAULT_CONVERTER;
    }

    public BooleanArrayConverter(Object obj) {
        super(obj);
        this.booleanConverter = DEFAULT_CONVERTER;
    }

    public BooleanArrayConverter(BooleanConverter booleanConverter, Object obj) {
        super(obj);
        this.booleanConverter = booleanConverter;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractArrayConverter, org.apache.commons.beanutils.Converter
    public Object convert(Class cls, Object obj) {
        if (obj == null) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException("No value specified");
        }
        if (MODEL == obj.getClass()) {
            return obj;
        }
        int i = 0;
        if (strings.getClass() == obj.getClass()) {
            try {
                String[] strArr = (String[]) obj;
                boolean[] zArr = new boolean[strArr.length];
                while (i < strArr.length) {
                    zArr[i] = ((Boolean) this.booleanConverter.convert(Boolean.class, strArr[i])).booleanValue();
                    i++;
                }
                return zArr;
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
            boolean[] zArr2 = new boolean[size];
            while (i < size) {
                zArr2[i] = ((Boolean) this.booleanConverter.convert(Boolean.class, (String) parseElements.get(i))).booleanValue();
                i++;
            }
            return zArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }
}
