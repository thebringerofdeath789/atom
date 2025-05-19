package org.apache.commons.lang3;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
class Charsets {
    Charsets() {
    }

    static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    static Charset toCharset(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    static String toCharsetName(String str) {
        return str == null ? Charset.defaultCharset().name() : str;
    }
}
