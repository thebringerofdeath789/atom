package org.apache.poi.ss.format;

import java.util.Locale;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public abstract class CellFormatter {
    public static final Locale LOCALE = Locale.US;
    static final Logger logger = Logger.getLogger(CellFormatter.class.getName());
    protected final String format;

    public abstract void formatValue(StringBuffer stringBuffer, Object obj);

    public abstract void simpleValue(StringBuffer stringBuffer, Object obj);

    public CellFormatter(String str) {
        this.format = str;
    }

    public String format(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        formatValue(stringBuffer, obj);
        return stringBuffer.toString();
    }

    public String simpleFormat(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        simpleValue(stringBuffer, obj);
        return stringBuffer.toString();
    }

    static String quote(String str) {
        return '\"' + str + '\"';
    }
}
