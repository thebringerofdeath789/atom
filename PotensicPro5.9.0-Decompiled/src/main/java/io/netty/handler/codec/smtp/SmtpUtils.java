package io.netty.handler.codec.smtp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class SmtpUtils {
    static List<CharSequence> toUnmodifiableList(CharSequence... charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(Arrays.asList(charSequenceArr));
    }

    private SmtpUtils() {
    }
}
