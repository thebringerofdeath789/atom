package org.apache.commons.text.lookup;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
final class UrlDecoderStringLookup extends AbstractStringLookup {
    static final UrlDecoderStringLookup INSTANCE = new UrlDecoderStringLookup();

    UrlDecoderStringLookup() {
    }

    String decode(String str, String str2) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, str2);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String name = StandardCharsets.UTF_8.name();
        try {
            return decode(str, name);
        } catch (UnsupportedEncodingException e) {
            throw IllegalArgumentExceptions.format(e, "%s: source=%s, encoding=%s", e, str, name);
        }
    }
}
