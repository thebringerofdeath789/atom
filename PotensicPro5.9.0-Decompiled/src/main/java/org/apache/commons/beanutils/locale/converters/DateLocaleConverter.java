package org.apache.commons.beanutils.locale.converters;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class DateLocaleConverter extends BaseLocaleConverter {
    private static final String DEFAULT_PATTERN_CHARS = initDefaultChars();
    boolean isLenient;
    private final Log log;

    public DateLocaleConverter() {
        this(false);
    }

    public DateLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public DateLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DateLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public DateLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DateLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
        this.log = LogFactory.getLog(DateLocaleConverter.class);
        this.isLenient = false;
    }

    public DateLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DateLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public DateLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DateLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public DateLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DateLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
        this.log = LogFactory.getLog(DateLocaleConverter.class);
        this.isLenient = false;
    }

    public boolean isLenient() {
        return this.isLenient;
    }

    public void setLenient(boolean z) {
        this.isLenient = z;
    }

    @Override // org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        if (obj instanceof Date) {
            return obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (this.locPattern) {
            str = convertLocalizedPattern(str, this.locale);
        }
        DateFormat dateInstance = str == null ? DateFormat.getDateInstance(3, this.locale) : new SimpleDateFormat(str, this.locale);
        dateInstance.setLenient(this.isLenient);
        ParsePosition parsePosition = new ParsePosition(0);
        String obj2 = obj.toString();
        Object parseObject = dateInstance.parseObject(obj2, parsePosition);
        if (parsePosition.getErrorIndex() > -1) {
            throw new ConversionException("Error parsing date '" + obj + "' at position=" + parsePosition.getErrorIndex());
        }
        if (parsePosition.getIndex() >= obj2.length()) {
            return parseObject;
        }
        throw new ConversionException("Date '" + obj + "' contains unparsed characters from position=" + parsePosition.getIndex());
    }

    private String convertLocalizedPattern(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        String localPatternChars = new DateFormatSymbols(locale).getLocalPatternChars();
        String str2 = DEFAULT_PATTERN_CHARS;
        if (str2.equals(localPatternChars)) {
            return str;
        }
        try {
            return convertPattern(str, localPatternChars, str2);
        } catch (Exception e) {
            this.log.debug("Converting pattern '" + str + "' for " + locale, e);
            return null;
        }
    }

    private String convertPattern(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (z) {
                if (charAt == '\'') {
                    z = false;
                }
            } else if (charAt == '\'') {
                z = true;
            } else if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                int indexOf = str2.indexOf(charAt);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Illegal pattern character '" + charAt + "'");
                }
                charAt = str3.charAt(indexOf);
            }
            sb.append(charAt);
        }
        if (z) {
            throw new IllegalArgumentException("Unfinished quote in pattern");
        }
        return sb.toString();
    }

    private static String initDefaultChars() {
        return new DateFormatSymbols(Locale.US).getLocalPatternChars();
    }
}
