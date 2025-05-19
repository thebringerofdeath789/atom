package org.apache.commons.beanutils.converters;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.text.StringSubstitutor;

@Deprecated
/* loaded from: classes4.dex */
public abstract class AbstractArrayConverter implements Converter {
    public static final Object NO_DEFAULT = new Object();
    protected static String[] strings = new String[0];
    protected Object defaultValue;
    protected boolean useDefault;

    @Override // org.apache.commons.beanutils.Converter
    public abstract Object convert(Class cls, Object obj);

    public AbstractArrayConverter() {
        this.defaultValue = null;
        this.useDefault = true;
        this.defaultValue = null;
        this.useDefault = false;
    }

    public AbstractArrayConverter(Object obj) {
        this.defaultValue = null;
        this.useDefault = true;
        if (obj == NO_DEFAULT) {
            this.useDefault = false;
        } else {
            this.defaultValue = obj;
            this.useDefault = true;
        }
    }

    protected List parseElements(String str) {
        int nextToken;
        Objects.requireNonNull(str);
        String trim = str.trim();
        if (trim.startsWith("{") && trim.endsWith(StringSubstitutor.DEFAULT_VAR_END)) {
            trim = trim.substring(1, trim.length() - 1);
        }
        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(trim));
            streamTokenizer.whitespaceChars(44, 44);
            streamTokenizer.ordinaryChars(48, 57);
            streamTokenizer.ordinaryChars(46, 46);
            streamTokenizer.ordinaryChars(45, 45);
            streamTokenizer.wordChars(48, 57);
            streamTokenizer.wordChars(46, 46);
            streamTokenizer.wordChars(45, 45);
            ArrayList arrayList = new ArrayList();
            while (true) {
                nextToken = streamTokenizer.nextToken();
                if (nextToken != -3 && nextToken <= 0) {
                    break;
                }
                arrayList.add(streamTokenizer.sval);
            }
            if (nextToken == -1) {
                return arrayList;
            }
            throw new ConversionException("Encountered token of type " + nextToken);
        } catch (IOException e) {
            throw new ConversionException(e);
        }
    }
}
