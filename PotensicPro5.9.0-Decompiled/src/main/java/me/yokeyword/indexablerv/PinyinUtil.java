package me.yokeyword.indexablerv;

import com.github.promeg.pinyinhelper.Pinyin;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class PinyinUtil {
    private static final String PATTERN_LETTER = "^[a-zA-Z].*+";
    private static final String PATTERN_POLYPHONE = "^#[a-zA-Z]+#.+";

    public static String getPingYin(String str) {
        return str == null ? "" : Pinyin.toPinyin(str, "").toLowerCase();
    }

    static boolean matchingLetter(String str) {
        return Pattern.matches(PATTERN_LETTER, str);
    }

    static boolean matchingPolyphone(String str) {
        return Pattern.matches(PATTERN_POLYPHONE, str);
    }

    static String gePolyphoneInitial(String str) {
        return str.substring(1, 2);
    }

    static String getPolyphoneRealPinyin(String str) {
        return str.split("#")[1];
    }

    static String getPolyphoneRealHanzi(String str) {
        return str.split("#")[2];
    }
}
