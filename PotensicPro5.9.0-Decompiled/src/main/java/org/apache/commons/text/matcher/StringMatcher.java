package org.apache.commons.text.matcher;

import org.apache.commons.lang3.CharSequenceUtils;

/* loaded from: classes4.dex */
public interface StringMatcher {
    int isMatch(char[] cArr, int i, int i2, int i3);

    default int size() {
        return 0;
    }

    default StringMatcher andThen(StringMatcher stringMatcher) {
        return StringMatcherFactory.INSTANCE.andMatcher(this, stringMatcher);
    }

    default int isMatch(char[] cArr, int i) {
        return isMatch(cArr, i, 0, cArr.length);
    }

    default int isMatch(CharSequence charSequence, int i) {
        return isMatch(charSequence, i, 0, charSequence.length());
    }

    default int isMatch(CharSequence charSequence, int i, int i2, int i3) {
        return isMatch(CharSequenceUtils.toCharArray(charSequence), i, i3, i3);
    }
}
