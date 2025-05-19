package org.apache.commons.beanutils.converters;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.SchemaType;

/* loaded from: classes4.dex */
public abstract class DateTimeConverter extends AbstractConverter {
    private String displayPatterns;
    private Locale locale;
    private String[] patterns;
    private TimeZone timeZone;
    private boolean useLocaleFormat;

    public DateTimeConverter() {
    }

    public DateTimeConverter(Object obj) {
        super(obj);
    }

    public void setUseLocaleFormat(boolean z) {
        this.useLocaleFormat = z;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        setUseLocaleFormat(true);
    }

    public void setPattern(String str) {
        setPatterns(new String[]{str});
    }

    public String[] getPatterns() {
        return this.patterns;
    }

    public void setPatterns(String[] strArr) {
        this.patterns = strArr;
        if (strArr != null && strArr.length > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(strArr[i]);
            }
            this.displayPatterns = sb.toString();
        }
        setUseLocaleFormat(true);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected String convertToString(Object obj) throws Throwable {
        Date date;
        String obj2;
        DateFormat format;
        if (obj instanceof Date) {
            date = (Date) obj;
        } else if (obj instanceof Calendar) {
            date = ((Calendar) obj).getTime();
        } else {
            date = obj instanceof Long ? new Date(((Long) obj).longValue()) : null;
        }
        if (this.useLocaleFormat && date != null) {
            String[] strArr = this.patterns;
            if (strArr != null && strArr.length > 0) {
                format = getFormat(strArr[0]);
            } else {
                format = getFormat(this.locale, this.timeZone);
            }
            logFormat("Formatting", format);
            obj2 = format.format(date);
            if (log().isDebugEnabled()) {
                log().debug("    Converted  to String using format '" + obj2 + "'");
            }
        } else {
            obj2 = obj.toString();
            if (log().isDebugEnabled()) {
                log().debug("    Converted  to String using toString() '" + obj2 + "'");
            }
        }
        return obj2;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Exception {
        Calendar parse;
        Class<?> cls2 = obj.getClass();
        if (obj instanceof Timestamp) {
            return (T) toDate(cls, ((((Timestamp) obj).getTime() / 1000) * 1000) + (r6.getNanos() / SchemaType.SIZE_BIG_INTEGER));
        }
        if (obj instanceof Date) {
            return (T) toDate(cls, ((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return (T) toDate(cls, ((Calendar) obj).getTime().getTime());
        }
        if (obj instanceof Long) {
            return (T) toDate(cls, ((Long) obj).longValue());
        }
        String trim = obj.toString().trim();
        if (trim.length() == 0) {
            return (T) handleMissing(cls);
        }
        if (this.useLocaleFormat) {
            String[] strArr = this.patterns;
            if (strArr != null && strArr.length > 0) {
                parse = parse(cls2, cls, trim);
            } else {
                parse = parse(cls2, cls, trim, getFormat(this.locale, this.timeZone));
            }
            if (Calendar.class.isAssignableFrom(cls)) {
                return cls.cast(parse);
            }
            return (T) toDate(cls, parse.getTime().getTime());
        }
        return (T) toDate(cls, trim);
    }

    private <T> T toDate(Class<T> cls, long j) {
        Calendar calendar;
        if (cls.equals(Date.class)) {
            return cls.cast(new Date(j));
        }
        if (cls.equals(java.sql.Date.class)) {
            return cls.cast(new java.sql.Date(j));
        }
        if (cls.equals(Time.class)) {
            return cls.cast(new Time(j));
        }
        if (cls.equals(Timestamp.class)) {
            return cls.cast(new Timestamp(j));
        }
        if (cls.equals(Calendar.class)) {
            Locale locale = this.locale;
            if (locale == null && this.timeZone == null) {
                calendar = Calendar.getInstance();
            } else if (locale == null) {
                calendar = Calendar.getInstance(this.timeZone);
            } else {
                TimeZone timeZone = this.timeZone;
                if (timeZone == null) {
                    calendar = Calendar.getInstance(locale);
                } else {
                    calendar = Calendar.getInstance(timeZone, locale);
                }
            }
            calendar.setTime(new Date(j));
            calendar.setLenient(false);
            return cls.cast(calendar);
        }
        String str = toString(getClass()) + " cannot handle conversion to '" + toString(cls) + "'";
        if (log().isWarnEnabled()) {
            log().warn("    " + str);
        }
        throw new ConversionException(str);
    }

    private <T> T toDate(Class<T> cls, String str) {
        if (cls.equals(java.sql.Date.class)) {
            try {
                return cls.cast(java.sql.Date.valueOf(str));
            } catch (IllegalArgumentException unused) {
                throw new ConversionException("String must be in JDBC format [yyyy-MM-dd] to create a java.sql.Date");
            }
        }
        if (cls.equals(Time.class)) {
            try {
                return cls.cast(Time.valueOf(str));
            } catch (IllegalArgumentException unused2) {
                throw new ConversionException("String must be in JDBC format [HH:mm:ss] to create a java.sql.Time");
            }
        }
        if (cls.equals(Timestamp.class)) {
            try {
                return cls.cast(Timestamp.valueOf(str));
            } catch (IllegalArgumentException unused3) {
                throw new ConversionException("String must be in JDBC format [yyyy-MM-dd HH:mm:ss.fffffffff] to create a java.sql.Timestamp");
            }
        }
        String str2 = toString(getClass()) + " does not support default String to '" + toString(cls) + "' conversion.";
        if (log().isWarnEnabled()) {
            log().warn("    " + str2);
            log().warn("    (N.B. Re-configure Converter or use alternative implementation)");
        }
        throw new ConversionException(str2);
    }

    protected DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat dateInstance;
        if (locale == null) {
            dateInstance = DateFormat.getDateInstance(3);
        } else {
            dateInstance = DateFormat.getDateInstance(3, locale);
        }
        if (timeZone != null) {
            dateInstance.setTimeZone(timeZone);
        }
        return dateInstance;
    }

    private DateFormat getFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat;
    }

    private Calendar parse(Class<?> cls, Class<?> cls2, String str) throws Exception {
        Exception exc = null;
        for (String str2 : this.patterns) {
            try {
                return parse(cls, cls2, str, getFormat(str2));
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.patterns.length > 1) {
            throw new ConversionException("Error converting '" + toString(cls) + "' to '" + toString(cls2) + "' using  patterns '" + this.displayPatterns + "'");
        }
        throw exc;
    }

    private Calendar parse(Class<?> cls, Class<?> cls2, String str, DateFormat dateFormat) {
        logFormat("Parsing", dateFormat);
        dateFormat.setLenient(false);
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = dateFormat.parse(str, parsePosition);
        if (parsePosition.getErrorIndex() >= 0 || parsePosition.getIndex() != str.length() || parse == null) {
            String str2 = "Error converting '" + toString(cls) + "' to '" + toString(cls2) + "'";
            if (dateFormat instanceof SimpleDateFormat) {
                str2 = str2 + " using pattern '" + ((SimpleDateFormat) dateFormat).toPattern() + "'";
            }
            if (log().isDebugEnabled()) {
                log().debug("    " + str2);
            }
            throw new ConversionException(str2);
        }
        return dateFormat.getCalendar();
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(getClass()));
        sb.append("[UseDefault=");
        sb.append(isUseDefault());
        sb.append(", UseLocaleFormat=");
        sb.append(this.useLocaleFormat);
        if (this.displayPatterns != null) {
            sb.append(", Patterns={");
            sb.append(this.displayPatterns);
            sb.append('}');
        }
        if (this.locale != null) {
            sb.append(", Locale=");
            sb.append(this.locale);
        }
        if (this.timeZone != null) {
            sb.append(", TimeZone=");
            sb.append(this.timeZone);
        }
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    private void logFormat(String str, DateFormat dateFormat) {
        if (log().isDebugEnabled()) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("    ");
            sb.append(str);
            sb.append(" with Format");
            if (dateFormat instanceof SimpleDateFormat) {
                sb.append("[");
                sb.append(((SimpleDateFormat) dateFormat).toPattern());
                sb.append("]");
            }
            sb.append(" for ");
            if (this.locale == null) {
                sb.append("default locale");
            } else {
                sb.append("locale[");
                sb.append(this.locale);
                sb.append("]");
            }
            if (this.timeZone != null) {
                sb.append(", TimeZone[");
                sb.append(this.timeZone);
                sb.append("]");
            }
            log().debug(sb.toString());
        }
    }
}
