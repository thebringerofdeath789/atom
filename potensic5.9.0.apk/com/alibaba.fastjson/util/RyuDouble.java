package com.alibaba.fastjson.util;

import com.google.android.exoplayer2.C0858C;
import com.ipotensic.baselib.netty.Constant;
import java.lang.reflect.Array;
import java.math.BigInteger;
import okhttp3.internal.connection.RealConnection;
import org.apache.poi.p043ss.util.IEEEDouble;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public final class RyuDouble {
    private static final int[][] POW5_SPLIT = (int[][]) Array.newInstance((Class<?>) int.class, 326, 4);
    private static final int[][] POW5_INV_SPLIT = (int[][]) Array.newInstance((Class<?>) int.class, 291, 4);

    static {
        BigInteger subtract = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        BigInteger subtract2 = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        int i = 0;
        while (i < 326) {
            BigInteger pow = BigInteger.valueOf(5L).pow(i);
            int bitLength = pow.bitLength();
            int i2 = i == 0 ? 1 : (int) ((((i * 23219280) + 10000000) - 1) / 10000000);
            if (i2 != bitLength) {
                throw new IllegalStateException(bitLength + " != " + i2);
            }
            if (i < POW5_SPLIT.length) {
                for (int i3 = 0; i3 < 4; i3++) {
                    POW5_SPLIT[i][i3] = pow.shiftRight((bitLength - 121) + ((3 - i3) * 31)).and(subtract).intValue();
                }
            }
            if (i < POW5_INV_SPLIT.length) {
                BigInteger add = BigInteger.ONE.shiftLeft(bitLength + 121).divide(pow).add(BigInteger.ONE);
                for (int i4 = 0; i4 < 4; i4++) {
                    if (i4 == 0) {
                        POW5_INV_SPLIT[i][i4] = add.shiftRight((3 - i4) * 31).intValue();
                    } else {
                        POW5_INV_SPLIT[i][i4] = add.shiftRight((3 - i4) * 31).and(subtract2).intValue();
                    }
                }
            }
            i++;
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    public static int toString(double d, char[] cArr, int i) {
        int i2;
        boolean z;
        boolean z2;
        long j;
        int i3;
        long j2;
        int i4;
        int i5;
        int i6;
        long j3;
        long j4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (!Double.isNaN(d)) {
            if (d == Double.POSITIVE_INFINITY) {
                int i17 = i + 1;
                cArr[i] = 'I';
                int i18 = i17 + 1;
                cArr[i17] = 'n';
                int i19 = i18 + 1;
                cArr[i18] = 'f';
                int i20 = i19 + 1;
                cArr[i19] = 'i';
                int i21 = i20 + 1;
                cArr[i20] = 'n';
                int i22 = i21 + 1;
                cArr[i21] = 'i';
                int i23 = i22 + 1;
                cArr[i22] = 't';
                i11 = i23 + 1;
                cArr[i23] = 'y';
            } else if (d == Double.NEGATIVE_INFINITY) {
                int i24 = i + 1;
                cArr[i] = NameUtil.HYPHEN;
                int i25 = i24 + 1;
                cArr[i24] = 'I';
                int i26 = i25 + 1;
                cArr[i25] = 'n';
                int i27 = i26 + 1;
                cArr[i26] = 'f';
                int i28 = i27 + 1;
                cArr[i27] = 'i';
                int i29 = i28 + 1;
                cArr[i28] = 'n';
                int i30 = i29 + 1;
                cArr[i29] = 'i';
                int i31 = i30 + 1;
                cArr[i30] = 't';
                i16 = i31 + 1;
                cArr[i31] = 'y';
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d);
                if (doubleToLongBits == 0) {
                    int i32 = i + 1;
                    cArr[i] = '0';
                    int i33 = i32 + 1;
                    cArr[i32] = '.';
                    i16 = i33 + 1;
                    cArr[i33] = '0';
                } else if (doubleToLongBits == Long.MIN_VALUE) {
                    int i34 = i + 1;
                    cArr[i] = NameUtil.HYPHEN;
                    int i35 = i34 + 1;
                    cArr[i34] = '0';
                    int i36 = i35 + 1;
                    cArr[i35] = '.';
                    i11 = i36 + 1;
                    cArr[i36] = '0';
                } else {
                    int i37 = (int) ((doubleToLongBits >>> 52) & 2047);
                    long j5 = doubleToLongBits & IEEEDouble.FRAC_MASK;
                    if (i37 == 0) {
                        i2 = -1074;
                    } else {
                        i2 = (i37 - 1023) - 52;
                        j5 |= IEEEDouble.FRAC_ASSUMED_HIGH_BIT;
                    }
                    boolean z3 = doubleToLongBits < 0;
                    boolean z4 = (j5 & 1) == 0;
                    long j6 = 4 * j5;
                    long j7 = j6 + 2;
                    int i38 = (j5 != IEEEDouble.FRAC_ASSUMED_HIGH_BIT || i37 <= 1) ? 1 : 0;
                    long j8 = (j6 - 1) - i38;
                    int i39 = i2 - 2;
                    int i40 = 3;
                    if (i39 >= 0) {
                        int max = Math.max(0, ((int) ((i39 * 3010299) / 10000000)) - 1);
                        int i41 = ((((-i39) + max) + (((max == 0 ? 1 : (int) ((((max * 23219280) + 10000000) - 1) / 10000000)) + 122) - 1)) - 93) - 21;
                        if (i41 < 0) {
                            throw new IllegalArgumentException("" + i41);
                        }
                        int[] iArr = POW5_INV_SPLIT[max];
                        long j9 = j6 >>> 31;
                        long j10 = j6 & 2147483647L;
                        long j11 = iArr[0] * j10;
                        z = z3;
                        long j12 = iArr[1] * j9;
                        long j13 = iArr[1] * j10;
                        z2 = z4;
                        long j14 = ((((((((((((j10 * iArr[3]) >>> 31) + (iArr[2] * j10)) + (j9 * iArr[3])) >>> 31) + j13) + (iArr[2] * j9)) >>> 31) + j11) + j12) >>> 21) + ((iArr[0] * j9) << 10)) >>> i41;
                        long j15 = j7 >>> 31;
                        long j16 = j7 & 2147483647L;
                        long j17 = iArr[0] * j16;
                        long j18 = iArr[1] * j15;
                        long j19 = iArr[1] * j16;
                        long j20 = ((((((((((((j16 * iArr[3]) >>> 31) + (iArr[2] * j16)) + (j15 * iArr[3])) >>> 31) + j19) + (iArr[2] * j15)) >>> 31) + j17) + j18) >>> 21) + ((iArr[0] * j15) << 10)) >>> i41;
                        long j21 = j8 >>> 31;
                        long j22 = j8 & 2147483647L;
                        long j23 = iArr[0] * j22;
                        long j24 = iArr[1] * j21;
                        j3 = j20;
                        long j25 = iArr[1] * j22;
                        j2 = ((((((((((((j22 * iArr[3]) >>> 31) + (iArr[2] * j22)) + (j21 * iArr[3])) >>> 31) + j25) + (iArr[2] * j21)) >>> 31) + j23) + j24) >>> 21) + ((iArr[0] * j21) << 10)) >>> i41;
                        if (max <= 21) {
                            long j26 = j6 % 5;
                            if (j26 == 0) {
                                if (j26 != 0) {
                                    i15 = 0;
                                } else if (j6 % 25 != 0) {
                                    i15 = 1;
                                } else if (j6 % 125 != 0) {
                                    i15 = 2;
                                } else if (j6 % 625 != 0) {
                                    i15 = 3;
                                } else {
                                    long j27 = j6 / 625;
                                    i15 = 4;
                                    for (long j28 = 0; j27 > j28 && j27 % 5 == j28; j28 = 0) {
                                        j27 /= 5;
                                        i15++;
                                    }
                                }
                                i5 = i15 >= max ? 1 : 0;
                                i12 = 0;
                                i6 = i12;
                                j = j14;
                                i4 = max;
                                i3 = 0;
                            } else if (z2) {
                                if (j8 % 5 != 0) {
                                    i14 = 0;
                                } else if (j8 % 25 != 0) {
                                    i14 = 1;
                                } else if (j8 % 125 != 0) {
                                    i14 = 2;
                                } else if (j8 % 625 != 0) {
                                    i14 = 3;
                                } else {
                                    long j29 = j8 / 625;
                                    i14 = 4;
                                    for (long j30 = 0; j29 > j30 && j29 % 5 == j30; j30 = 0) {
                                        j29 /= 5;
                                        i14++;
                                    }
                                }
                                if (i14 >= max) {
                                    i12 = 1;
                                    i5 = 0;
                                    i6 = i12;
                                    j = j14;
                                    i4 = max;
                                    i3 = 0;
                                }
                            } else {
                                if (j7 % 5 != 0) {
                                    i13 = 0;
                                } else if (j7 % 25 != 0) {
                                    i13 = 1;
                                } else if (j7 % 125 != 0) {
                                    i13 = 2;
                                } else if (j7 % 625 != 0) {
                                    i13 = 3;
                                } else {
                                    long j31 = j7 / 625;
                                    i13 = 4;
                                    for (long j32 = 0; j31 > j32 && j31 % 5 == j32; j32 = 0) {
                                        j31 /= 5;
                                        i13++;
                                    }
                                }
                                if (i13 >= max) {
                                    j3--;
                                }
                            }
                        }
                        i12 = 0;
                        i5 = 0;
                        i6 = i12;
                        j = j14;
                        i4 = max;
                        i3 = 0;
                    } else {
                        z = z3;
                        z2 = z4;
                        int i42 = -i39;
                        int max2 = Math.max(0, ((int) ((i42 * 6989700) / 10000000)) - 1);
                        int i43 = i42 - max2;
                        int i44 = ((max2 - ((i43 == 0 ? 1 : (int) ((((i43 * 23219280) + 10000000) - 1) / 10000000)) - 121)) - 93) - 21;
                        if (i44 < 0) {
                            throw new IllegalArgumentException("" + i44);
                        }
                        int[] iArr2 = POW5_SPLIT[i43];
                        long j33 = j6 >>> 31;
                        long j34 = j6 & 2147483647L;
                        long j35 = iArr2[0] * j34;
                        long j36 = iArr2[1] * j33;
                        int i45 = i38;
                        long j37 = iArr2[1] * j34;
                        long j38 = ((((((((((((j34 * iArr2[3]) >>> 31) + (iArr2[2] * j34)) + (j33 * iArr2[3])) >>> 31) + j37) + (iArr2[2] * j33)) >>> 31) + j35) + j36) >>> 21) + ((iArr2[0] * j33) << 10)) >>> i44;
                        long j39 = j7 >>> 31;
                        long j40 = j7 & 2147483647L;
                        long j41 = iArr2[0] * j40;
                        long j42 = iArr2[1] * j39;
                        long j43 = iArr2[1] * j40;
                        j = j38;
                        long j44 = ((((((((((((j40 * iArr2[3]) >>> 31) + (iArr2[2] * j40)) + (j39 * iArr2[3])) >>> 31) + j43) + (iArr2[2] * j39)) >>> 31) + j41) + j42) >>> 21) + ((iArr2[0] * j39) << 10)) >>> i44;
                        long j45 = j8 >>> 31;
                        long j46 = j8 & 2147483647L;
                        i3 = 0;
                        long j47 = iArr2[0] * j46;
                        long j48 = iArr2[1] * j45;
                        long j49 = iArr2[1] * j46;
                        j2 = ((((((((((((j46 * iArr2[3]) >>> 31) + (iArr2[2] * j46)) + (j45 * iArr2[3])) >>> 31) + j49) + (iArr2[2] * j45)) >>> 31) + j47) + j48) >>> 21) + ((iArr2[0] * j45) << 10)) >>> i44;
                        i4 = max2 + i39;
                        i5 = 1;
                        if (max2 > 1) {
                            if (max2 < 63) {
                                i5 = (j6 & ((1 << (max2 - 1)) - 1)) == 0 ? 1 : 0;
                                i6 = 0;
                            } else {
                                i5 = 0;
                                i6 = 0;
                            }
                            j3 = j44;
                        } else if (z2) {
                            j3 = j44;
                            i6 = i45 == 1 ? 1 : 0;
                        } else {
                            j3 = j44 - 1;
                            i6 = 0;
                        }
                    }
                    if (j3 >= 1000000000000000000L) {
                        i40 = 19;
                    } else if (j3 >= 100000000000000000L) {
                        i40 = 18;
                    } else if (j3 >= 10000000000000000L) {
                        i40 = 17;
                    } else if (j3 >= 1000000000000000L) {
                        i40 = 16;
                    } else if (j3 >= 100000000000000L) {
                        i40 = 15;
                    } else if (j3 >= 10000000000000L) {
                        i40 = 14;
                    } else if (j3 >= 1000000000000L) {
                        i40 = 13;
                    } else if (j3 >= 100000000000L) {
                        i40 = 12;
                    } else if (j3 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                        i40 = 11;
                    } else if (j3 >= C0858C.NANOS_PER_SECOND) {
                        i40 = 10;
                    } else if (j3 >= 100000000) {
                        i40 = 9;
                    } else if (j3 >= 10000000) {
                        i40 = 8;
                    } else if (j3 >= 1000000) {
                        i40 = 7;
                    } else if (j3 >= 100000) {
                        i40 = 6;
                    } else if (j3 >= Constant.DELAY_MILLIS) {
                        i40 = 5;
                    } else if (j3 >= 1000) {
                        i40 = 4;
                    } else if (j3 < 100) {
                        i40 = j3 >= 10 ? 2 : 1;
                    }
                    int i46 = (i4 + i40) - 1;
                    int i47 = (i46 < -3 || i46 >= 7) ? 1 : i3;
                    if (i6 == 0 && i5 == 0) {
                        int i48 = i3;
                        i7 = i48;
                        while (true) {
                            long j50 = j3 / 10;
                            long j51 = j2 / 10;
                            if (j50 <= j51 || (j3 < 100 && i47 != 0)) {
                                break;
                            }
                            i48 = (int) (j % 10);
                            j /= 10;
                            i7++;
                            j3 = j50;
                            j2 = j51;
                        }
                        j4 = j + ((j == j2 || i48 >= 5) ? 1 : i3);
                    } else {
                        int i49 = i3;
                        int i50 = i49;
                        while (true) {
                            long j52 = j3 / 10;
                            long j53 = j2 / 10;
                            if (j52 <= j53 || (j3 < 100 && i47 != 0)) {
                                break;
                            }
                            i6 &= j2 % 10 == 0 ? 1 : i3;
                            i5 &= i49 == 0 ? 1 : i3;
                            i49 = (int) (j % 10);
                            j /= 10;
                            i50++;
                            j3 = j52;
                            j2 = j53;
                        }
                        if (i6 != 0 && z2) {
                            while (j2 % 10 == 0 && (j3 >= 100 || i47 == 0)) {
                                i5 &= i49 == 0 ? 1 : i3;
                                i49 = (int) (j % 10);
                                j3 /= 10;
                                j /= 10;
                                j2 /= 10;
                                i50++;
                            }
                        }
                        if (i5 != 0 && i49 == 5 && j % 2 == 0) {
                            i49 = 4;
                        }
                        j4 = j + (((j != j2 || (i6 != 0 && z2)) && i49 < 5) ? i3 : 1);
                        i7 = i50;
                    }
                    int i51 = i40 - i7;
                    if (z) {
                        i8 = i + 1;
                        cArr[i] = NameUtil.HYPHEN;
                    } else {
                        i8 = i;
                    }
                    if (i47 == 0) {
                        char c = '0';
                        if (i46 < 0) {
                            int i52 = i8 + 1;
                            cArr[i8] = '0';
                            int i53 = i52 + 1;
                            cArr[i52] = '.';
                            int i54 = -1;
                            while (i54 > i46) {
                                cArr[i53] = c;
                                i54--;
                                i53++;
                                c = '0';
                            }
                            i9 = i53;
                            while (i3 < i51) {
                                cArr[((i53 + i51) - i3) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                                i9++;
                                i3++;
                            }
                        } else {
                            int i55 = i46 + 1;
                            if (i55 >= i51) {
                                while (i3 < i51) {
                                    cArr[((i8 + i51) - i3) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                    i3++;
                                }
                                int i56 = i8 + i51;
                                while (i51 < i55) {
                                    cArr[i56] = '0';
                                    i51++;
                                    i56++;
                                }
                                int i57 = i56 + 1;
                                cArr[i56] = '.';
                                cArr[i57] = '0';
                                i9 = i57 + 1;
                            } else {
                                int i58 = i8 + 1;
                                while (i3 < i51) {
                                    if ((i51 - i3) - 1 == i46) {
                                        cArr[((i58 + i51) - i3) - 1] = '.';
                                        i58--;
                                    }
                                    cArr[((i58 + i51) - i3) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                    i3++;
                                }
                                i9 = i8 + i51 + 1;
                            }
                        }
                        return i9 - i;
                    }
                    while (i3 < i51 - 1) {
                        int i59 = (int) (j4 % 10);
                        j4 /= 10;
                        cArr[(i8 + i51) - i3] = (char) (i59 + 48);
                        i3++;
                    }
                    cArr[i8] = (char) ((j4 % 10) + 48);
                    cArr[i8 + 1] = '.';
                    int i60 = i8 + i51 + 1;
                    if (i51 == 1) {
                        cArr[i60] = '0';
                        i60++;
                    }
                    int i61 = i60 + 1;
                    cArr[i60] = 'E';
                    if (i46 < 0) {
                        cArr[i61] = NameUtil.HYPHEN;
                        i46 = -i46;
                        i61++;
                    }
                    if (i46 >= 100) {
                        int i62 = i61 + 1;
                        i10 = 48;
                        cArr[i61] = (char) ((i46 / 100) + 48);
                        i46 %= 100;
                        i61 = i62 + 1;
                        cArr[i62] = (char) ((i46 / 10) + 48);
                    } else {
                        i10 = 48;
                        if (i46 >= 10) {
                            cArr[i61] = (char) ((i46 / 10) + 48);
                            i61++;
                        }
                    }
                    i11 = i61 + 1;
                    cArr[i61] = (char) ((i46 % 10) + i10);
                }
            }
            return i11 - i;
        }
        int i63 = i + 1;
        cArr[i] = 'N';
        int i64 = i63 + 1;
        cArr[i63] = 'a';
        i16 = i64 + 1;
        cArr[i64] = 'N';
        return i16 - i;
    }
}