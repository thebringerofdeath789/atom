package org.apache.poi.ss.formula.atp;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;

/* loaded from: classes5.dex */
public class DateParser {
    public DateParser instance = new DateParser();

    private DateParser() {
    }

    public static Calendar parseDate(String str) throws EvaluationException {
        String[] split = Pattern.compile(InternalZipConstants.ZIP_FILE_SEPARATOR).split(str);
        if (split.length != 3) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        String str2 = split[2];
        int indexOf = str2.indexOf(32);
        if (indexOf > 0) {
            str2 = str2.substring(0, indexOf);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt < 0 || parseInt2 < 0 || parseInt3 < 0 || (parseInt > 12 && parseInt2 > 12 && parseInt3 > 12)) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            if (parseInt >= 1900 && parseInt < 9999) {
                return makeDate(parseInt, parseInt2, parseInt3);
            }
            throw new RuntimeException("Unable to determine date format for text '" + str + "'");
        } catch (NumberFormatException unused) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
    }

    private static Calendar makeDate(int i, int i2, int i3) throws EvaluationException {
        if (i2 < 1 || i2 > 12) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(i, i2 - 1, 1, 0, 0, 0);
        gregorianCalendar.set(14, 0);
        if (i3 < 1 || i3 > gregorianCalendar.getActualMaximum(5)) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        gregorianCalendar.set(5, i3);
        return gregorianCalendar;
    }
}
