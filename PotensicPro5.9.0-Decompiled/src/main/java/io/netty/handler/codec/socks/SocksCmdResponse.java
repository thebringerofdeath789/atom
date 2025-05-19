package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.net.IDN;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class SocksCmdResponse extends SocksResponse {
    private static final byte[] DOMAIN_ZEROED = {0};
    private static final byte[] IPv4_HOSTNAME_ZEROED = {0, 0, 0, 0};
    private static final byte[] IPv6_HOSTNAME_ZEROED = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final SocksAddressType addressType;
    private final SocksCmdStatus cmdStatus;
    private final String host;
    private final int port;

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType) {
        this(socksCmdStatus, socksAddressType, null, 0);
    }

    public SocksCmdResponse(SocksCmdStatus socksCmdStatus, SocksAddressType socksAddressType, String str, int i) {
        super(SocksResponseType.CMD);
        Objects.requireNonNull(socksCmdStatus, "cmdStatus");
        Objects.requireNonNull(socksAddressType, "addressType");
        if (str != null) {
            int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    String ascii = IDN.toASCII(str);
                    if (ascii.length() > 255) {
                        throw new IllegalArgumentException(str + " IDN: " + ascii + " exceeds 255 char limit");
                    }
                    str = ascii;
                } else if (i2 == 3 && !NetUtil.isValidIpV6Address(str)) {
                    throw new IllegalArgumentException(str + " is not a valid IPv6 address");
                }
            } else if (!NetUtil.isValidIpV4Address(str)) {
                throw new IllegalArgumentException(str + " is not a valid IPv4 address");
            }
        }
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(i + " is not in bounds 0 <= x <= 65535");
        }
        this.cmdStatus = socksCmdStatus;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i;
    }

    /* renamed from: io.netty.handler.codec.socks.SocksCmdResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        static {
            int[] iArr = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr;
            try {
                iArr[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SocksCmdStatus cmdStatus() {
        return this.cmdStatus;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public String host() {
        return (this.host == null || this.addressType != SocksAddressType.DOMAIN) ? this.host : IDN.toUnicode(this.host);
    }

    public int port() {
        return this.port;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdStatus.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i == 1) {
            String str = this.host;
            byteBuf.writeBytes(str == null ? IPv4_HOSTNAME_ZEROED : NetUtil.createByteArrayFromIpAddressString(str));
            byteBuf.writeShort(this.port);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            String str2 = this.host;
            byteBuf.writeBytes(str2 == null ? IPv6_HOSTNAME_ZEROED : NetUtil.createByteArrayFromIpAddressString(str2));
            byteBuf.writeShort(this.port);
            return;
        }
        String str3 = this.host;
        if (str3 != null) {
            byteBuf.writeByte(str3.length());
            byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
        } else {
            byte[] bArr = DOMAIN_ZEROED;
            byteBuf.writeByte(bArr.length);
            byteBuf.writeBytes(bArr);
        }
        byteBuf.writeShort(this.port);
    }
}
