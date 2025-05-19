package io.netty.handler.codec.socksx.v4;

import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class Socks4CommandType implements Comparable<Socks4CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks4CommandType CONNECT = new Socks4CommandType(1, "CONNECT");
    public static final Socks4CommandType BIND = new Socks4CommandType(2, "BIND");

    public static Socks4CommandType valueOf(byte b) {
        if (b == 1) {
            return CONNECT;
        }
        if (b == 2) {
            return BIND;
        }
        return new Socks4CommandType(b);
    }

    public Socks4CommandType(int i) {
        this(i, "UNKNOWN");
    }

    public Socks4CommandType(int i, String str) {
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
        return (obj instanceof Socks4CommandType) && this.byteValue == ((Socks4CommandType) obj).byteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks4CommandType socks4CommandType) {
        return this.byteValue - socks4CommandType.byteValue;
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
