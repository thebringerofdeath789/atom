package org.litepal.util;

import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.apache.xmlbeans.XmlErrorCodes;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.parser.LitePalAttr;
import org.litepal.util.Const;

/* loaded from: classes5.dex */
public class BaseUtility {
    private BaseUtility() {
    }

    public static String changeCase(String str) {
        if (str == null) {
            return null;
        }
        String cases = LitePalAttr.getInstance().getCases();
        if (Const.Config.CASES_KEEP.equals(cases)) {
            return str;
        }
        if (Const.Config.CASES_UPPER.equals(cases)) {
            return str.toUpperCase(Locale.US);
        }
        return str.toLowerCase(Locale.US);
    }

    public static boolean containsIgnoreCases(Collection<String> collection, String str) {
        if (collection == null) {
            return false;
        }
        if (str == null) {
            return collection.contains(null);
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String capitalize(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.substring(0, 1).toUpperCase(Locale.US) + str.substring(1);
        }
        if (str == null) {
            return null;
        }
        return "";
    }

    public static int count(String str, String str2) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(str2);
            while (indexOf != -1) {
                i++;
                str = str.substring(indexOf + str2.length());
                indexOf = str.indexOf(str2);
            }
        }
        return i;
    }

    public static void checkConditionsCorrect(String... strArr) {
        int length;
        if (strArr != null && (length = strArr.length) > 0 && length != count(strArr[0], "?") + 1) {
            throw new LitePalSupportException(LitePalSupportException.UPDATE_CONDITIONS_EXCEPTION);
        }
    }

    public static boolean isFieldTypeSupported(String str) {
        return XmlErrorCodes.BOOLEAN.equals(str) || "java.lang.Boolean".equals(str) || XmlErrorCodes.FLOAT.equals(str) || "java.lang.Float".equals(str) || XmlErrorCodes.DOUBLE.equals(str) || "java.lang.Double".equals(str) || XmlErrorCodes.INT.equals(str) || "java.lang.Integer".equals(str) || XmlErrorCodes.LONG.equals(str) || "java.lang.Long".equals(str) || "short".equals(str) || "java.lang.Short".equals(str) || "char".equals(str) || "java.lang.Character".equals(str) || "[B".equals(str) || "[Ljava.lang.Byte;".equals(str) || "java.lang.String".equals(str) || "java.util.Date".equals(str);
    }

    public static boolean isGenericTypeSupported(String str) {
        return "java.lang.String".equals(str) || "java.lang.Integer".equals(str) || "java.lang.Float".equals(str) || "java.lang.Double".equals(str) || "java.lang.Long".equals(str) || "java.lang.Short".equals(str) || "java.lang.Boolean".equals(str) || "java.lang.Character".equals(str);
    }

    public static boolean isLitePalXMLExists() {
        try {
            String[] list = LitePalApplication.getContext().getAssets().list("");
            if (list != null && list.length > 0) {
                for (String str : list) {
                    if (Const.Config.CONFIGURATION_FILE_NAME.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        } catch (IOException unused) {
        }
        return false;
    }

    public static boolean isClassAndMethodExist(String str, String str2) {
        try {
            for (Method method : Class.forName(str).getMethods()) {
                if (str2.equals(method.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
