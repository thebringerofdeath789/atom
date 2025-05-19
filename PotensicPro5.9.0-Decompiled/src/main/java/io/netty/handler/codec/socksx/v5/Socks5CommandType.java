package io.netty.handler.codec.socksx.v5;

import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class Socks5CommandType implements Comparable<Socks5CommandType> {
    private final byte byteValue;
    private final String name;
    private String text;
    public static final Socks5CommandType CONNECT = new Socks5CommandType(1, "CONNECT");
    public static final Socks5CommandType BIND = new Socks5CommandType(2, "BIND");
    public static final Socks5CommandType UDP_ASSOCIATE = new Socks5CommandType(3, "UDP_ASSOCIATE");

    public static Socks5CommandType valueOf(byte b) {
        if (b == 1) {
            return CONNECT;
        }
        if (b == 2) {
            return BIND;
        }
        if (b == 3) {
            return UDP_ASSOCIATE;
        }
        return new Socks5CommandType(b);
    }

    public Socks5CommandType(int i) {
        this(i, "UNKNOWN");
    }

    public Socks5CommandType(int i, String str) {
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
        return (obj instanceof Socks5CommandType) && this.byteValue == ((Socks5CommandType) obj).byteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Socks5CommandType socks5CommandType) {
        return this.byteValue - socks5CommandType.byteValue;
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
