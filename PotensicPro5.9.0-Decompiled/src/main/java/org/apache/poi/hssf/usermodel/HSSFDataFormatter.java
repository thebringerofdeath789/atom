package org.apache.poi.hssf.usermodel;

import java.util.Locale;
import org.apache.poi.ss.usermodel.DataFormatter;

/* loaded from: classes5.dex */
public final class HSSFDataFormatter extends DataFormatter {
    public HSSFDataFormatter(Locale locale) {
        super(locale);
    }

    public HSSFDataFormatter() {
        this(Locale.getDefault());
    }
}
