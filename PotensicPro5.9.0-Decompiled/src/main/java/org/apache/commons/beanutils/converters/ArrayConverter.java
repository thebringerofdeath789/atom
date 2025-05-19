package org.apache.commons.beanutils.converters;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.text.StringSubstitutor;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public class ArrayConverter extends AbstractConverter {
    private char[] allowedChars;
    private int defaultSize;
    private final Class<?> defaultType;
    private char delimiter;
    private final Converter elementConverter;
    private boolean onlyFirstToString;

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Object convertArray(Object obj) {
        return obj;
    }

    public ArrayConverter(Class<?> cls, Converter converter) {
        this.delimiter = ',';
        this.allowedChars = new char[]{'.', NameUtil.HYPHEN};
        this.onlyFirstToString = true;
        if (cls == null) {
            throw new IllegalArgumentException("Default type is missing");
        }
        if (!cls.isArray()) {
            throw new IllegalArgumentException("Default type must be an array.");
        }
        if (converter == null) {
            throw new IllegalArgumentException("Component Converter is missing.");
        }
        this.defaultType = cls;
        this.elementConverter = converter;
    }

    public ArrayConverter(Class<?> cls, Converter converter, int i) {
        this(cls, converter);
        this.defaultSize = i;
        setDefaultValue(i >= 0 ? Array.newInstance(cls.getComponentType(), i) : null);
    }

    public void setDelimiter(char c) {
        this.delimiter = c;
    }

    public void setAllowedChars(char[] cArr) {
        this.allowedChars = cArr;
    }

    public void setOnlyFirstToString(boolean z) {
        this.onlyFirstToString = z;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<?> getDefaultType() {
        return this.defaultType;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected String convertToString(Object obj) throws Throwable {
        Iterator<?> it;
        int i;
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            i = Array.getLength(obj);
            it = null;
        } else {
            Collection<?> convertToCollection = convertToCollection(cls, obj);
            int size = convertToCollection.size();
            it = convertToCollection.iterator();
            i = size;
        }
        if (i == 0) {
            return (String) getDefault(String.class);
        }
        if (this.onlyFirstToString) {
            i = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(this.delimiter);
            }
            Object convert = this.elementConverter.convert(String.class, it == null ? Array.get(obj, i2) : it.next());
            if (convert != null) {
                sb.append(convert);
            }
        }
        return sb.toString();
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        int size;
        if (!cls.isArray()) {
            throw new ConversionException(toString(getClass()) + " cannot handle conversion to '" + toString(cls) + "' (not an array).");
        }
        Iterator<?> it = null;
        if (obj.getClass().isArray()) {
            size = Array.getLength(obj);
        } else {
            Collection<?> convertToCollection = convertToCollection(cls, obj);
            size = convertToCollection.size();
            it = convertToCollection.iterator();
        }
        Class<?> componentType = cls.getComponentType();
        T t = (T) Array.newInstance(componentType, size);
        for (int i = 0; i < size; i++) {
            Array.set(t, i, this.elementConverter.convert(componentType, it == null ? Array.get(obj, i) : it.next()));
        }
        return t;
    }

    protected Collection<?> convertToCollection(Class<?> cls, Object obj) {
        if (obj instanceof Collection) {
            return (Collection) obj;
        }
        if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Date)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(obj);
            return arrayList;
        }
        return parseElements(cls, obj.toString());
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Object getDefault(Class<?> cls) {
        Object obj;
        if (cls.equals(String.class) || (obj = super.getDefault(cls)) == null) {
            return null;
        }
        return obj.getClass().equals(cls) ? obj : Array.newInstance(cls.getComponentType(), this.defaultSize);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String toString() {
        return toString(getClass()) + "[UseDefault=" + isUseDefault() + ", " + this.elementConverter.toString() + PropertyUtils.INDEXED_DELIM2;
    }

    private List<String> parseElements(Class<?> cls, String str) {
        int nextToken;
        if (log().isDebugEnabled()) {
            log().debug("Parsing elements, delimiter=[" + this.delimiter + "], value=[" + str + "]");
        }
        String trim = str.trim();
        if (trim.startsWith("{") && trim.endsWith(StringSubstitutor.DEFAULT_VAR_END)) {
            trim = trim.substring(1, trim.length() - 1);
        }
        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(trim));
            char c = this.delimiter;
            streamTokenizer.whitespaceChars(c, c);
            streamTokenizer.ordinaryChars(48, 57);
            streamTokenizer.wordChars(48, 57);
            for (char c2 : this.allowedChars) {
                streamTokenizer.ordinaryChars(c2, c2);
                streamTokenizer.wordChars(c2, c2);
            }
            List<String> list = null;
            while (true) {
                nextToken = streamTokenizer.nextToken();
                if (nextToken != -3 && nextToken <= 0) {
                    break;
                }
                if (streamTokenizer.sval != null) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(streamTokenizer.sval);
                }
            }
            if (nextToken != -1) {
                throw new ConversionException("Encountered token of type " + nextToken + " parsing elements to '" + toString(cls) + ".");
            }
            if (list == null) {
                list = Collections.emptyList();
            }
            if (log().isDebugEnabled()) {
                log().debug(list.size() + " elements parsed");
            }
            return list;
        } catch (IOException e) {
            throw new ConversionException("Error converting from String to '" + toString(cls) + "': " + e.getMessage(), e);
        }
    }
}
