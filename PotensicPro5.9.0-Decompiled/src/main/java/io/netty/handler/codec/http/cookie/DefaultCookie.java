package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public class DefaultCookie implements Cookie {
    private String domain;
    private boolean httpOnly;
    private long maxAge = Long.MIN_VALUE;
    private final String name;
    private String path;
    private boolean secure;
    private String value;
    private boolean wrap;

    public DefaultCookie(String str, String str2) {
        String trim = ((String) ObjectUtil.checkNotNull(str, "name")).trim();
        if (trim.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        this.name = trim;
        setValue(str2);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String name() {
        return this.name;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String value() {
        return this.value;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setValue(String str) {
        this.value = (String) ObjectUtil.checkNotNull(str, "value");
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean wrap() {
        return this.wrap;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setWrap(boolean z) {
        this.wrap = z;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String domain() {
        return this.domain;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setDomain(String str) {
        this.domain = CookieUtil.validateAttributeValue("domain", str);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public String path() {
        return this.path;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setPath(String str) {
        this.path = CookieUtil.validateAttributeValue("path", str);
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public long maxAge() {
        return this.maxAge;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setMaxAge(long j) {
        this.maxAge = j;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean isSecure() {
        return this.secure;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setSecure(boolean z) {
        this.secure = z;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    @Override // io.netty.handler.codec.http.cookie.Cookie
    public void setHttpOnly(boolean z) {
        this.httpOnly = z;
    }

    public int hashCode() {
        return name().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (!name().equals(cookie.name())) {
            return false;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return false;
            }
        } else if (cookie.path() == null || !path().equals(cookie.path())) {
            return false;
        }
        if (domain() == null) {
            return cookie.domain() == null;
        }
        return domain().equalsIgnoreCase(cookie.domain());
    }

    @Override // java.lang.Comparable
    public int compareTo(Cookie cookie) {
        int compareTo = name().compareTo(cookie.name());
        if (compareTo != 0) {
            return compareTo;
        }
        if (path() == null) {
            if (cookie.path() != null) {
                return -1;
            }
        } else {
            if (cookie.path() == null) {
                return 1;
            }
            int compareTo2 = path().compareTo(cookie.path());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        if (domain() == null) {
            return cookie.domain() != null ? -1 : 0;
        }
        if (cookie.domain() == null) {
            return 1;
        }
        return domain().compareToIgnoreCase(cookie.domain());
    }

    @Deprecated
    protected String validateValue(String str, String str2) {
        return CookieUtil.validateAttributeValue(str, str2);
    }

    public String toString() {
        StringBuilder append = CookieUtil.stringBuilder().append(name()).append('=').append(value());
        if (domain() != null) {
            append.append(", domain=").append(domain());
        }
        if (path() != null) {
            append.append(", path=").append(path());
        }
        if (maxAge() >= 0) {
            append.append(", maxAge=").append(maxAge()).append('s');
        }
        if (isSecure()) {
            append.append(", secure");
        }
        if (isHttpOnly()) {
            append.append(", HTTPOnly");
        }
        return append.toString();
    }
}
