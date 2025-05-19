package jxl.biff;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes4.dex */
public class DoubleHelper {
    private DoubleHelper() {
    }

    public static double getIEEEDouble(byte[] bArr, int i) {
        int i2 = IntegerHelper.getInt(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3]);
        boolean z = (Integer.MIN_VALUE & IntegerHelper.getInt(bArr[i + 4], bArr[i + 5], bArr[i + 6], bArr[i + 7])) != 0;
        long j = (r7 & Integer.MAX_VALUE) * IjkMediaMeta.AV_CH_WIDE_RIGHT;
        long j2 = i2;
        if (i2 < 0) {
            j2 += IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        double longBitsToDouble = Double.longBitsToDouble(j + j2);
        return z ? -longBitsToDouble : longBitsToDouble;
    }

    public static void getIEEEBytes(double d, byte[] bArr, int i) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        bArr[i] = (byte) (255 & doubleToLongBits);
        bArr[i + 1] = (byte) ((65280 & doubleToLongBits) >> 8);
        bArr[i + 2] = (byte) ((16711680 & doubleToLongBits) >> 16);
        bArr[i + 3] = (byte) (((-16777216) & doubleToLongBits) >> 24);
        bArr[i + 4] = (byte) ((1095216660480L & doubleToLongBits) >> 32);
        bArr[i + 5] = (byte) ((280375465082880L & doubleToLongBits) >> 40);
        bArr[i + 6] = (byte) ((71776119061217280L & doubleToLongBits) >> 48);
        bArr[i + 7] = (byte) ((doubleToLongBits & (-72057594037927936L)) >> 56);
    }
}
