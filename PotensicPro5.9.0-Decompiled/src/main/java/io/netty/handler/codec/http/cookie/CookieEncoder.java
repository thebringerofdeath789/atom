package io.netty.handler.codec.http.cookie;

/* loaded from: classes3.dex */
public abstract class CookieEncoder {
    protected final boolean strict;

    protected CookieEncoder(boolean z) {
        this.strict = z;
    }

    protected void validateCookie(String str, String str2) {
        if (this.strict) {
            int firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str);
            if (firstInvalidCookieNameOctet >= 0) {
                throw new IllegalArgumentException("Cookie name contains an invalid char: " + str.charAt(firstInvalidCookieNameOctet));
            }
            CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
            if (unwrapValue == null) {
                throw new IllegalArgumentException("Cookie value wrapping quotes are not balanced: " + str2);
            }
            int firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue);
            if (firstInvalidCookieValueOctet >= 0) {
                throw new IllegalArgumentException("Cookie value contains an invalid char: " + str2.charAt(firstInvalidCookieValueOctet));
            }
        }
    }
}
