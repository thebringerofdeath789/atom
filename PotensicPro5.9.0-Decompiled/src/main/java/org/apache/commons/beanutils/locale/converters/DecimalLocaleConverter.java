package org.apache.commons.beanutils.locale.converters;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class DecimalLocaleConverter extends BaseLocaleConverter {
    private final Log log;

    public DecimalLocaleConverter() {
        this(false);
    }

    public DecimalLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public DecimalLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DecimalLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public DecimalLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DecimalLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
        this.log = LogFactory.getLog(DecimalLocaleConverter.class);
    }

    public DecimalLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DecimalLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public DecimalLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
        this.log = LogFactory.getLog(DecimalLocaleConverter.class);
    }

    @Override // org.apache.commons.beanutils.locale.BaseLocaleConverter
    protected Object parse(Object obj, String str) throws ParseException {
        if (obj instanceof Number) {
            return obj;
        }
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(this.locale);
        if (str != null) {
            if (this.locPattern) {
                decimalFormat.applyLocalizedPattern(str);
            } else {
                decimalFormat.applyPattern(str);
            }
        } else {
            this.log.debug("No pattern provided, using default.");
        }
        return decimalFormat.parse((String) obj);
    }
}
