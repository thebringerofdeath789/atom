package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public final class NetUtil {
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    private static boolean inRangeEndExclusive(int i, int i2, int i3) {
        return i >= i2 && i < i3;
    }

    private static boolean isValidHexChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private static boolean isValidIPv4MappedChar(char c) {
        return c == 'f' || c == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b, byte b2, boolean z) {
        return b == b2 && (b == 0 || (!z && b2 == -1));
    }

    private static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x012f, code lost:
    
        if (r10 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d9, code lost:
    
        r10 = r8.nextElement();
        r6 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Type inference failed for: r0v5, types: [io.netty.util.internal.logging.InternalLogger] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.net.InetAddress] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.net.Inet6Address] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.net.InetAddress] */
    static {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process start = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine.startsWith(str)) {
                    for (int length = readLine.length() - 1; length > str.length(); length--) {
                        if (!Character.isDigit(readLine.charAt(length))) {
                            return Integer.valueOf(readLine.substring(length + 1, readLine.length()));
                        }
                    }
                }
                if (start != null) {
                    start.destroy();
                }
                return null;
            } finally {
                bufferedReader.close();
            }
        } finally {
            if (start != null) {
                start.destroy();
            }
        }
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = str.substring(1, str.length() - 1);
        }
        int indexOf = str.indexOf(37);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return getIPv6ByName(str, true);
    }

    private static int decimalDigit(String str, int i) {
        return str.charAt(i) - '0';
    }

    private static byte ipv4WordToByte(String str, int i, int i2) {
        int decimalDigit = decimalDigit(str, i);
        int i3 = i + 1;
        if (i3 == i2) {
            return (byte) decimalDigit;
        }
        int decimalDigit2 = (decimalDigit * 10) + decimalDigit(str, i3);
        int i4 = i3 + 1;
        return i4 == i2 ? (byte) decimalDigit2 : (byte) ((decimalDigit2 * 10) + decimalDigit(str, i4));
    }

    static byte[] validIpV4ToBytes(String str) {
        int indexOf = str.indexOf(46, 1);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(46, indexOf + 2);
        int indexOf3 = str.indexOf(46, indexOf2 + 2);
        return new byte[]{ipv4WordToByte(str, 0, indexOf), ipv4WordToByte(str, i, indexOf2), ipv4WordToByte(str, indexOf2 + 1, indexOf3), ipv4WordToByte(str, indexOf3 + 1, str.length())};
    }

    public static String intToIpAddress(int i) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i >> 24) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append(i & 255);
        return sb.toString();
    }

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    public static String bytesToIpAddress(byte[] bArr, int i, int i2) {
        if (i2 == 4) {
            return new StringBuilder(15).append(bArr[i] & 255).append('.').append(bArr[i + 1] & 255).append('.').append(bArr[i + 2] & 255).append('.').append(bArr[i + 3] & 255).toString();
        }
        if (i2 == 16) {
            return toAddressString(bArr, i, false);
        }
        throw new IllegalArgumentException("length: " + i2 + " (expected: 4 or 16)");
    }

    public static boolean isValidIpV6Address(String str) {
        int i;
        int i2;
        int length = str.length();
        int i3 = 2;
        if (length < 2) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == '[') {
            length--;
            if (str.charAt(length) != ']') {
                return false;
            }
            charAt = str.charAt(1);
            i = 1;
        } else {
            i = 0;
        }
        if (charAt != ':') {
            i2 = -1;
            i3 = 0;
        } else {
            if (str.charAt(i + 1) != ':') {
                return false;
            }
            int i4 = i;
            i += 2;
            i2 = i4;
        }
        int i5 = 0;
        int i6 = i;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt2 = str.charAt(i6);
            if (!isValidHexChar(charAt2)) {
                if (charAt2 == '%') {
                    length = i6;
                    break;
                }
                if (charAt2 == '.') {
                    if ((i2 < 0 && i3 != 6) || ((i3 == 7 && i2 >= i) || i3 > 7)) {
                        return false;
                    }
                    int i7 = i6 - i5;
                    int i8 = i7 - 2;
                    if (isValidIPv4MappedChar(str.charAt(i8))) {
                        if (!isValidIPv4MappedChar(str.charAt(i8 - 1)) || !isValidIPv4MappedChar(str.charAt(i8 - 2)) || !isValidIPv4MappedChar(str.charAt(i8 - 3))) {
                            return false;
                        }
                        i8 -= 5;
                    }
                    while (i8 >= i) {
                        char charAt3 = str.charAt(i8);
                        if (charAt3 != '0' && charAt3 != ':') {
                            return false;
                        }
                        i8--;
                    }
                    int indexOf = str.indexOf(37, i7 + 7);
                    if (indexOf >= 0) {
                        length = indexOf;
                    }
                    return isValidIpV4Address(str, i7, length);
                }
                if (charAt2 != ':' || i3 > 7) {
                    return false;
                }
                int i9 = i6 - 1;
                if (str.charAt(i9) != ':') {
                    i5 = 0;
                } else {
                    if (i2 >= 0) {
                        return false;
                    }
                    i2 = i9;
                }
                i3++;
            } else {
                if (i5 >= 4) {
                    return false;
                }
                i5++;
            }
            i6++;
        }
        if (i2 < 0) {
            return i3 == 7 && i5 > 0;
        }
        if (i2 + 2 != length) {
            if (i5 <= 0) {
                return false;
            }
            if (i3 >= 8 && i2 > i) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i, int i2) {
        char charAt;
        char charAt2;
        int i3 = i2 - i;
        if (i3 < 1 || i3 > 3 || (charAt = charSequence.charAt(i)) < '0') {
            return false;
        }
        if (i3 != 3) {
            if (charAt <= '9') {
                return i3 == 1 || isValidNumericChar(charSequence.charAt(i + 1));
            }
            return false;
        }
        char charAt3 = charSequence.charAt(i + 1);
        if (charAt3 < '0' || (charAt2 = charSequence.charAt(i + 2)) < '0') {
            return false;
        }
        if (charAt > '1' || charAt3 > '9' || charAt2 > '9') {
            if (charAt != '2' || charAt3 > '5') {
                return false;
            }
            if (charAt2 > '5' && (charAt3 >= '5' || charAt2 > '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i, int i2, int i3) {
        boolean z = i3 + i2 >= 14;
        return i <= 12 && i >= 2 && (!z || i2 < 12) && isValidIPv4MappedSeparators(bArr[i + (-1)], bArr[i + (-2)], z) && PlatformDependent.isZero(bArr, 0, i + (-3));
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    private static boolean isValidIpV4Address(String str, int i, int i2) {
        int indexOf;
        int i3;
        int indexOf2;
        int i4;
        int indexOf3;
        int i5 = i2 - i;
        return i5 <= 15 && i5 >= 7 && (indexOf = str.indexOf(46, i + 1)) > 0 && isValidIpV4Word(str, i, indexOf) && (indexOf2 = str.indexOf(46, (i3 = indexOf + 2))) > 0 && isValidIpV4Word(str, i3 - 1, indexOf2) && (indexOf3 = str.indexOf(46, (i4 = indexOf2 + 2))) > 0 && isValidIpV4Word(str, i4 - 1, indexOf3) && isValidIpV4Word(str, indexOf3 + 1, i2);
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    public static Inet6Address getByName(CharSequence charSequence, boolean z) {
        byte[] iPv6ByName = getIPv6ByName(charSequence, z);
        if (iPv6ByName == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, iPv6ByName, -1);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0168, code lost:
    
        if ((r6 - r9) <= 3) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0186, code lost:
    
        if (r19.charAt(0) == ':') goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0199, code lost:
    
        if (r7 <= 2) goto L127;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] getIPv6ByName(java.lang.CharSequence r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getIPv6ByName(java.lang.CharSequence, boolean):byte[]");
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress) {
        StringBuilder newSocketAddressStringBuilder;
        String valueOf = String.valueOf(inetSocketAddress.getPort());
        if (inetSocketAddress.isUnresolved()) {
            newSocketAddressStringBuilder = newSocketAddressStringBuilder(PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName(), valueOf, !isValidIpV6Address(r3));
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            newSocketAddressStringBuilder = newSocketAddressStringBuilder(toAddressString(address), valueOf, address instanceof Inet4Address);
        }
        return newSocketAddressStringBuilder.append(NameUtil.COLON).append(valueOf).toString();
    }

    public static String toSocketAddressString(String str, int i) {
        String valueOf = String.valueOf(i);
        return newSocketAddressStringBuilder(str, valueOf, !isValidIpV6Address(str)).append(NameUtil.COLON).append(valueOf).toString();
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z) {
        int length = str.length();
        if (z) {
            return new StringBuilder(length + 1 + str2.length()).append(str);
        }
        StringBuilder sb = new StringBuilder(length + 3 + str2.length());
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            return sb.append(str);
        }
        return sb.append(PropertyUtils.INDEXED_DELIM).append(str).append(PropertyUtils.INDEXED_DELIM2);
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static String toAddressString(InetAddress inetAddress, boolean z) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (!(inetAddress instanceof Inet6Address)) {
            throw new IllegalArgumentException("Unhandled type: " + inetAddress);
        }
        return toAddressString(inetAddress.getAddress(), 0, z);
    }

    private static String toAddressString(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        int[] iArr = new int[8];
        int i4 = i + 8;
        while (true) {
            i2 = 1;
            if (i >= i4) {
                break;
            }
            int i5 = i << 1;
            iArr[i] = (bArr[i5 + 1] & 255) | ((bArr[i5] & 255) << 8);
            i++;
        }
        int i6 = -1;
        boolean z2 = false;
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < 8) {
            if (iArr[i9] == 0) {
                if (i7 < 0) {
                    i7 = i9;
                }
            } else if (i7 >= 0) {
                int i11 = i9 - i7;
                if (i11 > i10) {
                    i10 = i11;
                } else {
                    i7 = i8;
                }
                i8 = i7;
                i7 = -1;
            }
            i9++;
        }
        if (i7 < 0 || (i3 = i9 - i7) <= i10) {
            i7 = i8;
        } else {
            i10 = i3;
        }
        if (i10 == 1) {
            i10 = 0;
        } else {
            i6 = i7;
        }
        int i12 = i10 + i6;
        StringBuilder sb = new StringBuilder(39);
        if (i12 < 0) {
            sb.append(Integer.toHexString(iArr[0]));
            while (i2 < 8) {
                sb.append(NameUtil.COLON);
                sb.append(Integer.toHexString(iArr[i2]));
                i2++;
            }
        } else {
            if (inRangeEndExclusive(0, i6, i12)) {
                sb.append("::");
                if (z && i12 == 5 && iArr[5] == 65535) {
                    z2 = true;
                }
            } else {
                sb.append(Integer.toHexString(iArr[0]));
            }
            while (i2 < 8) {
                if (!inRangeEndExclusive(i2, i6, i12)) {
                    if (!inRangeEndExclusive(i2 - 1, i6, i12)) {
                        if (!z2 || i2 == 6) {
                            sb.append(NameUtil.COLON);
                        } else {
                            sb.append('.');
                        }
                    }
                    if (z2 && i2 > 5) {
                        sb.append(iArr[i2] >> 8);
                        sb.append('.');
                        sb.append(iArr[i2] & 255);
                    } else {
                        sb.append(Integer.toHexString(iArr[i2]));
                    }
                } else if (!inRangeEndExclusive(i2 - 1, i6, i12)) {
                    sb.append("::");
                }
                i2++;
            }
        }
        return sb.toString();
    }

    private NetUtil() {
    }
}
