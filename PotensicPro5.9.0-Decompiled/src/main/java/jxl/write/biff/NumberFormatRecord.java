package jxl.write.biff;

import common.Logger;
import jxl.biff.FormatRecord;

/* loaded from: classes4.dex */
public class NumberFormatRecord extends FormatRecord {
    static /* synthetic */ Class class$jxl$write$biff$NumberFormatRecord;
    private static Logger logger;

    /* JADX INFO: Access modifiers changed from: protected */
    public static class NonValidatingFormat {
    }

    static {
        Class cls = class$jxl$write$biff$NumberFormatRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.NumberFormatRecord");
            class$jxl$write$biff$NumberFormatRecord = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected NumberFormatRecord(String str) {
        setFormatString(trimInvalidChars(replace(str, "E0", "E+0")));
    }

    protected NumberFormatRecord(String str, NonValidatingFormat nonValidatingFormat) {
        setFormatString(replace(str, "E0", "E+0"));
    }

    private String trimInvalidChars(String str) {
        int indexOf = str.indexOf(35);
        int indexOf2 = str.indexOf(48);
        if (indexOf == -1 && indexOf2 == -1) {
            return "#.###";
        }
        if (indexOf != 0 && indexOf2 != 0 && indexOf != 1 && indexOf2 != 1) {
            if (indexOf == -1) {
                indexOf = Integer.MAX_VALUE;
            }
            if (indexOf2 == -1) {
                indexOf2 = Integer.MAX_VALUE;
            }
            int min = Math.min(indexOf, indexOf2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.charAt(0));
            stringBuffer.append(str.substring(min));
            str = stringBuffer.toString();
        }
        int lastIndexOf = str.lastIndexOf(35);
        int lastIndexOf2 = str.lastIndexOf(48);
        if (lastIndexOf == str.length() || lastIndexOf2 == str.length()) {
            return str;
        }
        int max = Math.max(lastIndexOf, lastIndexOf2);
        while (true) {
            max++;
            if (str.length() <= max || (str.charAt(max) != ')' && str.charAt(max) != '%')) {
                break;
            }
        }
        return str.substring(0, max);
    }
}
