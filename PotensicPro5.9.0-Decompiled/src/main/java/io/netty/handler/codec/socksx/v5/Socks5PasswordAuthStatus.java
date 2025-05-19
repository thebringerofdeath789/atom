package io.netty.handler.codec.socksx.v5;

import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class Socks5PasswordAuthStatus implements Comparable<Socks5PasswordAuthStatus> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5PasswordAuthStatus SUCCESS = new Socks5PasswordAuthStatus(0, "SUCCESS");
    public static final Socks5PasswordAuthStatus FAILURE = new Socks5PasswordAuthStatus(255, "FAILURE");

    public static Socks5PasswordAuthStatus valueOf(byte b) {
        if (b == -1) {
            return FAILURE;
        }
        if (b == 0) {
            return SUCCESS;
        }
        return new Socks5PasswordAuthStatus(b);
    }

    public Socks5PasswordAuthStatus(int i) {
        this(i, "UNKNOWN");
    }

    public Socks5PasswordAuthStatus(int i, String str) {
        Objects.requireNonNull(str, "name");
        this.byteValue = (byte) i;
        this.name = str;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public boolean isSuccess() {
        return this.byteValue == 0;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5PasswordAuthStatus) && this.byteValue == ((Socks5PasswordAuthStatus) obj).byteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5PasswordAuthStatus socks5PasswordAuthStatus) {
        return this.byteValue - socks5PasswordAuthStatus.byteValue;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = this.name + PropertyUtils.MAPPED_DELIM + (this.byteValue & 255) + PropertyUtils.MAPPED_DELIM2;
        this.text = str2;
        return str2;
    }
}
