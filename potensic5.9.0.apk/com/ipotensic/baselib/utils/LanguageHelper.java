package com.ipotensic.baselib.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.ipotensic.baselib.C1819R;
import com.ipotensic.baselib.DDLog;
import java.util.Locale;

/* loaded from: classes2.dex */
public class LanguageHelper {

    public enum LANGUAGE_TYPE {
        ENGLISH("English"),
        CHINESE("Chinese"),
        FRENCH("French"),
        GERMANY("German"),
        SPANISH("Spain"),
        ITALY("Italy"),
        JAPAN("Japanese"),
        PORTUGUESE("Portuguese"),
        CHINESETAIWAN("ChineseTaiWan"),
        KOREA("Korea");

        private String languageStr;

        LANGUAGE_TYPE(String str) {
            this.languageStr = str;
        }

        public String getLanguageString() {
            return this.languageStr;
        }
    }

    public static LANGUAGE_TYPE getLanguage(Context context) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            locale = configuration.getLocales().get(0);
        } else {
            locale = configuration.locale;
        }
        if (equals(locale, Locale.CHINA) || equals(locale, Locale.CHINESE) || equals(locale, Locale.SIMPLIFIED_CHINESE) || equals(locale, Locale.TRADITIONAL_CHINESE)) {
            if (equalsCountry(locale, Locale.TRADITIONAL_CHINESE) || isTraditionalChinese(context)) {
                return LANGUAGE_TYPE.CHINESETAIWAN;
            }
            return LANGUAGE_TYPE.CHINESE;
        }
        if (equals(locale, Locale.ENGLISH)) {
            return LANGUAGE_TYPE.ENGLISH;
        }
        if (equals(locale, Locale.FRANCE)) {
            return LANGUAGE_TYPE.FRENCH;
        }
        if (equals(locale, Locale.GERMANY)) {
            return LANGUAGE_TYPE.GERMANY;
        }
        if (equals(locale, Locale.JAPAN)) {
            return LANGUAGE_TYPE.JAPAN;
        }
        if (equals(locale, Locale.ITALY)) {
            return LANGUAGE_TYPE.ITALY;
        }
        if (equals(locale, Locale.KOREA)) {
            return LANGUAGE_TYPE.KOREA;
        }
        if (locale.getLanguage().equalsIgnoreCase("pt")) {
            return LANGUAGE_TYPE.PORTUGUESE;
        }
        return isSpanish(context) ? LANGUAGE_TYPE.SPANISH : LANGUAGE_TYPE.ENGLISH;
    }

    /* renamed from: com.ipotensic.baselib.utils.LanguageHelper$1 */
    static /* synthetic */ class C19241 {

        /* renamed from: $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE */
        static final /* synthetic */ int[] f2118xa0b71515;

        static {
            int[] iArr = new int[LANGUAGE_TYPE.values().length];
            f2118xa0b71515 = iArr;
            try {
                iArr[LANGUAGE_TYPE.CHINESE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.FRENCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.ITALY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.GERMANY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.JAPAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.SPANISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.CHINESETAIWAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.PORTUGUESE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2118xa0b71515[LANGUAGE_TYPE.KOREA.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static String getLanguageType(Context context) {
        switch (C19241.f2118xa0b71515[getLanguage(context).ordinal()]) {
            case 1:
                return "Chinese";
            case 2:
                return "French";
            case 3:
                return "Italy";
            case 4:
                return "German";
            case 5:
                return "Japanese";
            case 6:
                return "Spain";
            case 7:
                return "ChineseTaiWan";
            case 8:
                return LANGUAGE_TYPE.PORTUGUESE.getLanguageString();
            case 9:
                return LANGUAGE_TYPE.KOREA.getLanguageString();
            default:
                return "English";
        }
    }

    private static boolean equals(Locale locale, Locale locale2) {
        try {
            return locale.getLanguage().equals(locale2.getLanguage());
        } catch (Exception e) {
            DDLog.m1684e("获取语言错误:" + e.getMessage());
            return false;
        }
    }

    private static boolean equalsCountry(Locale locale, Locale locale2) {
        try {
            return locale.getCountry().equals(locale2.getCountry());
        } catch (Exception e) {
            DDLog.m1684e("获取语言国家错误:" + e.getMessage());
            return false;
        }
    }

    public static int getPhoneLanguageType() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        if (language.equalsIgnoreCase("en")) {
            return 0;
        }
        if (language.equalsIgnoreCase("zh")) {
            return "TW".equalsIgnoreCase(country) ? 7 : 1;
        }
        if (language.equalsIgnoreCase("fr")) {
            return 2;
        }
        if (language.equalsIgnoreCase("de")) {
            return 3;
        }
        if (language.equalsIgnoreCase("es")) {
            return 4;
        }
        if (language.equalsIgnoreCase("it")) {
            return 5;
        }
        if (language.equalsIgnoreCase("ja")) {
            return 6;
        }
        if (language.equalsIgnoreCase("pt")) {
            return 8;
        }
        return language.equalsIgnoreCase("ko") ? 9 : 0;
    }

    public static boolean isTraditionalChinese(Context context) {
        return context.getResources().getBoolean(C1819R.bool.is_traditional_chinese);
    }

    public static boolean isSpanish(Context context) {
        return context.getResources().getBoolean(C1819R.bool.is_spanish);
    }
}