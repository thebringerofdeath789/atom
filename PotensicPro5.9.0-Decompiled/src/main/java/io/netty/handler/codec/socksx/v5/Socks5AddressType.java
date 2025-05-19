package io.netty.handler.codec.socksx.v5;

import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class Socks5AddressType implements Comparable<Socks5AddressType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5AddressType IPv4 = new Socks5AddressType(1, "IPv4");
    public static final Socks5AddressType DOMAIN = new Socks5AddressType(3, "DOMAIN");
    public static final Socks5AddressType IPv6 = new Socks5AddressType(4, "IPv6");

    public static Socks5AddressType valueOf(byte b) {
        if (b == 1) {
            return IPv4;
        }
        if (b == 3) {
            return DOMAIN;
        }
        if (b == 4) {
            return IPv6;
        }
        return new Socks5AddressType(b);
    }

    public Socks5AddressType(int i) {
        this(i, "UNKNOWN");
    }

    public Socks5AddressType(int i, String str) {
        Objects.requireNonNull(str, "name");
        this.byteValue = (byte) i;
        this.name = str;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public int hashCode() {
        return this.byteValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Socks5AddressType) && this.byteValue == ((Socks5AddressType) obj).byteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5AddressType socks5AddressType) {
        return this.byteValue - socks5AddressType.byteValue;
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
