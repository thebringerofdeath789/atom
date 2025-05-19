package io.netty.handler.codec.compression;

/* loaded from: classes.dex */
final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;
    private final int[] SA;
    private final byte[] T;
    private final int n;

    private static int BUCKET_B(int i, int i2) {
        return i | (i2 << 8);
    }

    private static int BUCKET_BSTAR(int i, int i2) {
        return (i << 8) | i2;
    }

    private static int getIDX(int i) {
        return i >= 0 ? i : ~i;
    }

    Bzip2DivSufSort(byte[] bArr, int[] iArr, int i) {
        this.T = bArr;
        this.SA = iArr;
        this.n = i;
    }

    private static void swapElements(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr2[i2];
        iArr2[i2] = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return (r1[r5] & 255) - (r1[r7] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (r7 >= r3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ssCompare(int r5, int r6, int r7) {
        /*
            r4 = this;
            int[] r0 = r4.SA
            byte[] r1 = r4.T
            int r2 = r5 + 1
            r2 = r0[r2]
            int r2 = r2 + 2
            int r3 = r6 + 1
            r3 = r0[r3]
            int r3 = r3 + 2
            r5 = r0[r5]
            int r5 = r5 + r7
            r6 = r0[r6]
            int r7 = r7 + r6
        L16:
            if (r5 >= r2) goto L25
            if (r7 >= r3) goto L25
            r6 = r1[r5]
            r0 = r1[r7]
            if (r6 != r0) goto L25
            int r5 = r5 + 1
            int r7 = r7 + 1
            goto L16
        L25:
            if (r5 >= r2) goto L35
            if (r7 >= r3) goto L33
            r5 = r1[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r5 = r5 - r6
            goto L3a
        L33:
            r5 = 1
            goto L3a
        L35:
            if (r7 >= r3) goto L39
            r5 = -1
            goto L3a
        L39:
            r5 = 0
        L3a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.ssCompare(int, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        return (r1[r7] & 255) - (r1[r9] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        if (r9 >= r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return (r1[r7] & 255) - (r1[r9] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r9 >= r8) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ssCompareLast(int r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            int[] r0 = r5.SA
            byte[] r1 = r5.T
            r7 = r0[r7]
            int r7 = r7 + r9
            r2 = r0[r8]
            int r9 = r9 + r2
            r2 = 1
            int r8 = r8 + r2
            r8 = r0[r8]
            int r8 = r8 + 2
        L10:
            if (r7 >= r10) goto L1f
            if (r9 >= r8) goto L1f
            r3 = r1[r7]
            r4 = r1[r9]
            if (r3 != r4) goto L1f
            int r7 = r7 + 1
            int r9 = r9 + 1
            goto L10
        L1f:
            if (r7 >= r10) goto L2e
            if (r9 >= r8) goto L2d
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = r1[r9]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r2 = r6 - r7
        L2d:
            return r2
        L2e:
            if (r9 != r8) goto L31
            return r2
        L31:
            int r7 = r7 % r10
            r6 = r0[r6]
            int r6 = r6 + 2
        L36:
            if (r7 >= r6) goto L45
            if (r9 >= r8) goto L45
            r10 = r1[r7]
            r0 = r1[r9]
            if (r10 != r0) goto L45
            int r7 = r7 + 1
            int r9 = r9 + 1
            goto L36
        L45:
            if (r7 >= r6) goto L54
            if (r9 >= r8) goto L59
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = r1[r9]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r2 = r6 - r7
            goto L59
        L54:
            if (r9 >= r8) goto L58
            r2 = -1
            goto L59
        L58:
            r2 = 0
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.ssCompareLast(int, int, int, int, int):int");
    }

    private void ssInsertionSort(int i, int i2, int i3, int i4) {
        int ssCompare;
        int[] iArr = this.SA;
        for (int i5 = i3 - 2; i2 <= i5; i5--) {
            int i6 = iArr[i5];
            int i7 = i5 + 1;
            do {
                ssCompare = ssCompare(i + i6, iArr[i7] + i, i4);
                if (ssCompare <= 0) {
                    break;
                }
                do {
                    iArr[i7 - 1] = iArr[i7];
                    i7++;
                    if (i7 >= i3) {
                        break;
                    }
                } while (iArr[i7] < 0);
            } while (i3 > i7);
            if (ssCompare == 0) {
                iArr[i7] = ~iArr[i7];
            }
            iArr[i7 - 1] = i6;
        }
    }

    private void ssFixdown(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = iArr[i3 + i4];
        int i7 = bArr[iArr[i2 + i6] + i] & 255;
        while (true) {
            int i8 = (i4 * 2) + 1;
            if (i8 >= i5) {
                break;
            }
            int i9 = i8 + 1;
            int i10 = bArr[iArr[iArr[i3 + i8] + i2] + i] & 255;
            int i11 = bArr[iArr[iArr[i3 + i9] + i2] + i] & 255;
            if (i10 < i11) {
                i8 = i9;
                i10 = i11;
            }
            if (i10 <= i7) {
                break;
            }
            iArr[i4 + i3] = iArr[i3 + i8];
            i4 = i8;
        }
        iArr[i3 + i4] = i6;
    }

    private void ssHeapSort(int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = i4 % 2;
        if (i6 == 0) {
            int i7 = i4 - 1;
            int i8 = (i7 / 2) + i3;
            int i9 = i3 + i7;
            if ((bArr[iArr[iArr[i8] + i2] + i] & 255) < (bArr[iArr[iArr[i9] + i2] + i] & 255)) {
                swapElements(iArr, i9, iArr, i8);
            }
            i5 = i7;
        } else {
            i5 = i4;
        }
        for (int i10 = (i5 / 2) - 1; i10 >= 0; i10--) {
            ssFixdown(i, i2, i3, i10, i5);
        }
        if (i6 == 0) {
            swapElements(iArr, i3, iArr, i3 + i5);
            ssFixdown(i, i2, i3, 0, i5);
        }
        for (int i11 = i5 - 1; i11 > 0; i11--) {
            int i12 = iArr[i3];
            int i13 = i3 + i11;
            iArr[i3] = iArr[i13];
            ssFixdown(i, i2, i3, 0, i11);
            iArr[i13] = i12;
        }
    }

    private int ssMedian3(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = bArr[iArr[iArr[i3] + i2] + i] & 255;
        int i7 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        int i8 = bArr[i + iArr[i2 + iArr[i5]]] & 255;
        if (i6 <= i7) {
            i4 = i3;
            i3 = i4;
            i7 = i6;
            i6 = i7;
        }
        return i6 > i8 ? i7 > i8 ? i4 : i5 : i3;
    }

    private int ssMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i17 = bArr[iArr[iArr[i3] + i2] + i] & 255;
        int i18 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        int i19 = bArr[iArr[iArr[i5] + i2] + i] & 255;
        int i20 = bArr[iArr[iArr[i6] + i2] + i] & 255;
        int i21 = bArr[iArr[iArr[i7] + i2] + i] & 255;
        if (i18 > i19) {
            i8 = i5;
            i9 = i18;
            i10 = i4;
        } else {
            i8 = i4;
            i9 = i19;
            i19 = i18;
            i10 = i5;
        }
        if (i20 > i21) {
            i12 = i21;
            i11 = i20;
            i14 = i6;
            i13 = i7;
        } else {
            i11 = i21;
            i12 = i20;
            i13 = i6;
            i14 = i7;
        }
        if (i19 > i12) {
            int i22 = i10;
            i10 = i14;
            i14 = i22;
            int i23 = i11;
            i11 = i9;
            i9 = i23;
        } else {
            i8 = i13;
            i19 = i12;
        }
        if (i17 > i9) {
            i15 = i17;
            i16 = i3;
        } else {
            i15 = i9;
            i9 = i17;
            i16 = i10;
            i10 = i3;
        }
        if (i9 > i19) {
            i8 = i10;
            i19 = i9;
        } else {
            i14 = i16;
            i11 = i15;
        }
        return i11 > i19 ? i8 : i14;
    }

    private int ssPivot(int i, int i2, int i3, int i4) {
        int i5 = i4 - i3;
        int i6 = i3 + (i5 / 2);
        if (i5 <= 512) {
            if (i5 <= 32) {
                return ssMedian3(i, i2, i3, i6, i4 - 1);
            }
            int i7 = i5 >> 2;
            int i8 = i4 - 1;
            return ssMedian5(i, i2, i3, i3 + i7, i6, i8 - i7, i8);
        }
        int i9 = i5 >> 3;
        int i10 = i9 << 1;
        int i11 = i4 - 1;
        return ssMedian3(i, i2, ssMedian3(i, i2, i3, i3 + i9, i3 + i10), ssMedian3(i, i2, i6 - i9, i6, i6 + i9), ssMedian3(i, i2, i11 - i10, i11 - i9, i11));
    }

    private static int ssLog(int i) {
        return (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int ssSubstringPartition(int i, int i2, int i3, int i4) {
        int[] iArr = this.SA;
        int i5 = i2 - 1;
        while (true) {
            i5++;
            if (i5 < i3 && iArr[iArr[i5] + i] + i4 >= iArr[iArr[i5] + i + 1] + 1) {
                iArr[i5] = ~iArr[i5];
            } else {
                do {
                    i3--;
                    if (i5 >= i3) {
                        break;
                    }
                } while (iArr[iArr[i3] + i] + i4 < iArr[iArr[i3] + i + 1] + 1);
                if (i3 <= i5) {
                    break;
                }
                int i6 = ~iArr[i3];
                iArr[i3] = iArr[i5];
                iArr[i5] = i6;
            }
        }
        if (i2 < i5) {
            iArr[i2] = ~iArr[i2];
        }
        return i5;
    }

    private static class StackEntry {
        final int a;
        final int b;
        final int c;
        final int d;

        StackEntry(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    private void ssMultiKeyIntroSort(int i, int i2, int i3, int i4) {
        int ssLog;
        int i5;
        int i6;
        int i7;
        int i8;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int[] iArr = bzip2DivSufSort.SA;
        byte[] bArr = bzip2DivSufSort.T;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i9 = -1;
        int i10 = i4;
        int ssLog2 = ssLog(i3 - i2);
        int i11 = 0;
        int i12 = 0;
        int i13 = i2;
        int i14 = i3;
        while (true) {
            int i15 = i14 - i13;
            if (i15 <= 8) {
                if (1 < i15) {
                    bzip2DivSufSort.ssInsertionSort(i, i13, i14, i10);
                }
                if (i11 == 0) {
                    return;
                }
                i11--;
                StackEntry stackEntry = stackEntryArr[i11];
                int i16 = stackEntry.a;
                int i17 = stackEntry.b;
                int i18 = stackEntry.c;
                ssLog2 = stackEntry.d;
                i13 = i16;
                i14 = i17;
                i10 = i18;
            } else {
                int i19 = ssLog2 - 1;
                if (ssLog2 == 0) {
                    bzip2DivSufSort.ssHeapSort(i10, i, i13, i15);
                }
                if (i19 < 0) {
                    int i20 = bArr[iArr[iArr[i13] + i] + i10] & 255;
                    int i21 = i13;
                    i13++;
                    while (i13 < i14) {
                        i12 = bArr[iArr[iArr[i13] + i] + i10] & 255;
                        if (i12 != i20) {
                            if (1 < i13 - i21) {
                                break;
                            }
                            i21 = i13;
                            i20 = i12;
                        }
                        i13++;
                    }
                    if ((bArr[(iArr[iArr[i21] + i] + i10) - 1] & 255) < i20) {
                        i21 = bzip2DivSufSort.ssSubstringPartition(i, i21, i13, i10);
                    }
                    int i22 = i13 - i21;
                    int i23 = i14 - i13;
                    if (i22 <= i23) {
                        if (1 < i22) {
                            stackEntryArr[i11] = new StackEntry(i13, i14, i10, i9);
                            i10++;
                            ssLog = ssLog(i22);
                            i11++;
                            int i24 = ssLog;
                            i14 = i13;
                            i13 = i21;
                            ssLog2 = i24;
                        } else {
                            ssLog2 = i9;
                        }
                    } else if (1 < i23) {
                        stackEntryArr[i11] = new StackEntry(i21, i13, i10 + 1, ssLog(i22));
                        ssLog2 = i9;
                        i11++;
                    } else {
                        i10++;
                        ssLog = ssLog(i22);
                        int i242 = ssLog;
                        i14 = i13;
                        i13 = i21;
                        ssLog2 = i242;
                    }
                } else {
                    int ssPivot = bzip2DivSufSort.ssPivot(i10, i, i13, i14);
                    int i25 = bArr[iArr[iArr[ssPivot] + i] + i10] & 255;
                    swapElements(iArr, i13, iArr, ssPivot);
                    int i26 = i13 + 1;
                    while (i26 < i14) {
                        i12 = bArr[iArr[iArr[i26] + i] + i10] & 255;
                        if (i12 != i25) {
                            break;
                        } else {
                            i26++;
                        }
                    }
                    if (i26 < i14 && i12 < i25) {
                        i5 = i12;
                        i6 = i26;
                        while (true) {
                            i26++;
                            if (i26 >= i14 || (i5 = bArr[iArr[iArr[i26] + i] + i10] & 255) > i25) {
                                break;
                            } else if (i5 == i25) {
                                swapElements(iArr, i26, iArr, i6);
                                i6++;
                            }
                        }
                    } else {
                        i5 = i12;
                        i6 = i26;
                    }
                    int i27 = i14 - 1;
                    while (i26 < i27) {
                        i5 = bArr[iArr[iArr[i27] + i] + i10] & 255;
                        if (i5 != i25) {
                            break;
                        } else {
                            i27--;
                        }
                    }
                    if (i26 < i27 && i5 > i25) {
                        int i28 = i5;
                        int i29 = i27;
                        while (true) {
                            i27 += i9;
                            if (i26 >= i27) {
                                i7 = i29;
                                i5 = i28;
                                break;
                            }
                            int i30 = bArr[i10 + iArr[i + iArr[i27]]] & 255;
                            if (i30 < i25) {
                                int i31 = i29;
                                i5 = i30;
                                i7 = i31;
                                break;
                            } else {
                                if (i30 == i25) {
                                    swapElements(iArr, i27, iArr, i29);
                                    i29--;
                                }
                                i28 = i30;
                                i9 = -1;
                            }
                        }
                    } else {
                        i7 = i27;
                    }
                    while (i26 < i27) {
                        swapElements(iArr, i26, iArr, i27);
                        while (true) {
                            i26++;
                            if (i26 >= i27 || (i5 = bArr[iArr[iArr[i26] + i] + i10] & 255) > i25) {
                                break;
                            } else if (i5 == i25) {
                                swapElements(iArr, i26, iArr, i6);
                                i6++;
                            }
                        }
                        while (true) {
                            i27--;
                            if (i26 < i27 && (i5 = bArr[iArr[iArr[i27] + i] + i10] & 255) >= i25) {
                                if (i5 == i25) {
                                    swapElements(iArr, i27, iArr, i7);
                                    i7--;
                                }
                            }
                        }
                    }
                    if (i6 <= i7) {
                        int i32 = i26 - 1;
                        int i33 = i5;
                        int i34 = i6 - i13;
                        int i35 = i26 - i6;
                        if (i34 > i35) {
                            i34 = i35;
                        }
                        int i36 = i13;
                        int i37 = i26;
                        int i38 = i26 - i34;
                        while (i34 > 0) {
                            swapElements(iArr, i36, iArr, i38);
                            i34--;
                            i36++;
                            i38++;
                        }
                        int i39 = i7 - i32;
                        int i40 = (i14 - i7) - 1;
                        if (i39 <= i40) {
                            i40 = i39;
                        }
                        int i41 = i14 - i40;
                        int i42 = i37;
                        while (i40 > 0) {
                            swapElements(iArr, i42, iArr, i41);
                            i40--;
                            i42++;
                            i41++;
                        }
                        int i43 = i13 + i35;
                        int i44 = i14 - i39;
                        int ssSubstringPartition = i25 <= (bArr[(iArr[iArr[i43] + i] + i10) + (-1)] & 255) ? i43 : bzip2DivSufSort.ssSubstringPartition(i, i43, i44, i10);
                        int i45 = i43 - i13;
                        int i46 = i14 - i44;
                        if (i45 <= i46) {
                            int i47 = i44 - ssSubstringPartition;
                            if (i46 <= i47) {
                                int i48 = i11 + 1;
                                stackEntryArr[i11] = new StackEntry(ssSubstringPartition, i44, i10 + 1, ssLog(i47));
                                i11 = i48 + 1;
                                i8 = i19;
                                stackEntryArr[i48] = new StackEntry(i44, i14, i10, i8);
                            } else {
                                i8 = i19;
                                if (i45 <= i47) {
                                    int i49 = i11 + 1;
                                    stackEntryArr[i11] = new StackEntry(i44, i14, i10, i8);
                                    i11 = i49 + 1;
                                    stackEntryArr[i49] = new StackEntry(ssSubstringPartition, i44, i10 + 1, ssLog(i47));
                                } else {
                                    int i50 = i11 + 1;
                                    stackEntryArr[i11] = new StackEntry(i44, i14, i10, i8);
                                    i11 = i50 + 1;
                                    stackEntryArr[i50] = new StackEntry(i13, i43, i10, i8);
                                    i10++;
                                    i14 = i44;
                                    i9 = -1;
                                    ssLog2 = ssLog(i47);
                                    i13 = ssSubstringPartition;
                                    i12 = i33;
                                }
                            }
                            i12 = i33;
                            i14 = i43;
                            ssLog2 = i8;
                        } else {
                            i8 = i19;
                            int i51 = i44 - ssSubstringPartition;
                            if (i45 <= i51) {
                                int i52 = i11 + 1;
                                stackEntryArr[i11] = new StackEntry(ssSubstringPartition, i44, i10 + 1, ssLog(i51));
                                i11 = i52 + 1;
                                stackEntryArr[i52] = new StackEntry(i13, i43, i10, i8);
                            } else if (i46 <= i51) {
                                int i53 = i11 + 1;
                                stackEntryArr[i11] = new StackEntry(i13, i43, i10, i8);
                                i11 = i53 + 1;
                                stackEntryArr[i53] = new StackEntry(ssSubstringPartition, i44, i10 + 1, ssLog(i51));
                            } else {
                                int i54 = i11 + 1;
                                stackEntryArr[i11] = new StackEntry(i13, i43, i10, i8);
                                i11 = i54 + 1;
                                stackEntryArr[i54] = new StackEntry(i44, i14, i10, i8);
                                i10++;
                                i14 = i44;
                                i13 = ssSubstringPartition;
                                i9 = -1;
                                i12 = i33;
                                ssLog2 = ssLog(i51);
                                bzip2DivSufSort = this;
                            }
                            bzip2DivSufSort = this;
                            i12 = i33;
                            i13 = i44;
                            ssLog2 = i8;
                        }
                    } else {
                        int i55 = i5;
                        int i56 = i19 + 1;
                        if ((bArr[(iArr[iArr[i13] + i] + i10) - 1] & 255) < i25) {
                            bzip2DivSufSort = this;
                            i13 = bzip2DivSufSort.ssSubstringPartition(i, i13, i14, i10);
                            ssLog2 = ssLog(i14 - i13);
                        } else {
                            bzip2DivSufSort = this;
                            ssLog2 = i56;
                        }
                        i10++;
                        i12 = i55;
                    }
                    i9 = -1;
                }
            }
        }
    }

    private static void ssBlockSwap(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        while (i3 > 0) {
            swapElements(iArr, i, iArr2, i2);
            i3--;
            i++;
            i2++;
        }
    }

    private void ssMergeForward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int[] iArr2 = this.SA;
        int i8 = i4 - i3;
        int i9 = (i2 + i8) - 1;
        ssBlockSwap(iArr, i2, iArr2, i3, i8);
        int i10 = iArr2[i3];
        while (true) {
            int ssCompare = ssCompare(iArr[i2] + i, iArr2[i4] + i, i6);
            if (ssCompare < 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i11 = i2 + 1;
                    iArr[i2] = iArr2[i7];
                    if (iArr[i11] >= 0) {
                        i2 = i11;
                        break;
                    } else {
                        i2 = i11;
                        i3 = i7;
                    }
                }
            } else if (ssCompare > 0) {
                while (true) {
                    i7 = i3 + 1;
                    iArr2[i3] = iArr2[i4];
                    int i12 = i4 + 1;
                    iArr2[i4] = iArr2[i7];
                    if (i5 <= i12) {
                        while (i2 < i9) {
                            int i13 = i7 + 1;
                            iArr2[i7] = iArr[i2];
                            iArr[i2] = iArr2[i13];
                            i7 = i13;
                            i2++;
                        }
                        iArr2[i7] = iArr[i2];
                        iArr[i2] = i10;
                        return;
                    }
                    if (iArr2[i12] >= 0) {
                        i4 = i12;
                        break;
                    } else {
                        i4 = i12;
                        i3 = i7;
                    }
                }
            } else {
                iArr2[i4] = ~iArr2[i4];
                while (true) {
                    int i14 = i3 + 1;
                    iArr2[i3] = iArr[i2];
                    if (i9 <= i2) {
                        iArr[i2] = i10;
                        return;
                    }
                    int i15 = i2 + 1;
                    iArr[i2] = iArr2[i14];
                    if (iArr[i15] >= 0) {
                        while (true) {
                            int i16 = i14 + 1;
                            iArr2[i14] = iArr2[i4];
                            int i17 = i4 + 1;
                            iArr2[i4] = iArr2[i16];
                            if (i5 <= i17) {
                                while (i15 < i9) {
                                    int i18 = i16 + 1;
                                    iArr2[i16] = iArr[i15];
                                    iArr[i15] = iArr2[i18];
                                    i15++;
                                    i16 = i18;
                                }
                                iArr2[i16] = iArr[i15];
                                iArr[i15] = i10;
                                return;
                            }
                            if (iArr2[i17] >= 0) {
                                i4 = i17;
                                i3 = i16;
                                i2 = i15;
                                break;
                            }
                            i4 = i17;
                            i14 = i16;
                        }
                    } else {
                        i2 = i15;
                        i3 = i14;
                    }
                }
            }
            i3 = i7;
        }
    }

    private void ssMergeBackward(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
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
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int[] iArr2 = this.SA;
        int i23 = i5 - i4;
        ssBlockSwap(iArr, i2, iArr2, i4, i23);
        int i24 = (i2 + i23) - 1;
        if (iArr[i24] < 0) {
            i7 = i + (~iArr[i24]);
            i8 = 1;
        } else {
            i7 = i + iArr[i24];
            i8 = 0;
        }
        int i25 = i4 - 1;
        if (iArr2[i25] < 0) {
            i8 |= 2;
            i9 = ~iArr2[i25];
        } else {
            i9 = iArr2[i25];
        }
        int i26 = i + i9;
        int i27 = i5 - 1;
        int i28 = iArr2[i27];
        while (true) {
            int ssCompare = ssCompare(i7, i26, i6);
            if (ssCompare > 0) {
                if ((i8 & 1) != 0) {
                    while (true) {
                        i11 = i27 - 1;
                        iArr2[i27] = iArr[i24];
                        i12 = i24 - 1;
                        iArr[i24] = iArr2[i11];
                        if (iArr[i12] >= 0) {
                            break;
                        }
                        i24 = i12;
                        i27 = i11;
                    }
                    i8 ^= 1;
                    i24 = i12;
                    i27 = i11;
                }
                int i29 = i27 - 1;
                iArr2[i27] = iArr[i24];
                if (i24 <= i2) {
                    iArr[i24] = i28;
                    return;
                }
                int i30 = i24 - 1;
                iArr[i24] = iArr2[i29];
                if (iArr[i30] < 0) {
                    i8 |= 1;
                    i10 = ~iArr[i30];
                } else {
                    i10 = iArr[i30];
                }
                int i31 = i + i10;
                i24 = i30;
                i27 = i29;
                i7 = i31;
            } else if (ssCompare < 0) {
                if ((i8 & 2) != 0) {
                    while (true) {
                        i14 = i27 - 1;
                        iArr2[i27] = iArr2[i25];
                        i15 = i25 - 1;
                        iArr2[i25] = iArr2[i14];
                        if (iArr2[i15] >= 0) {
                            break;
                        }
                        i25 = i15;
                        i27 = i14;
                    }
                    i8 ^= 2;
                    i25 = i15;
                    i27 = i14;
                }
                int i32 = i27 - 1;
                iArr2[i27] = iArr2[i25];
                int i33 = i25 - 1;
                iArr2[i25] = iArr2[i32];
                if (i33 < i3) {
                    while (i2 < i24) {
                        int i34 = i32 - 1;
                        iArr2[i32] = iArr[i24];
                        iArr[i24] = iArr2[i34];
                        i32 = i34;
                        i24--;
                    }
                    iArr2[i32] = iArr[i24];
                    iArr[i24] = i28;
                    return;
                }
                if (iArr2[i33] < 0) {
                    i8 |= 2;
                    i13 = ~iArr2[i33];
                } else {
                    i13 = iArr2[i33];
                }
                i26 = i + i13;
                i25 = i33;
                i27 = i32;
            } else {
                if ((i8 & 1) != 0) {
                    while (true) {
                        i21 = i27 - 1;
                        iArr2[i27] = iArr[i24];
                        i22 = i24 - 1;
                        iArr[i24] = iArr2[i21];
                        if (iArr[i22] >= 0) {
                            break;
                        }
                        i24 = i22;
                        i27 = i21;
                    }
                    i8 ^= 1;
                    i24 = i22;
                    i27 = i21;
                }
                int i35 = i27 - 1;
                iArr2[i27] = ~iArr[i24];
                if (i24 <= i2) {
                    iArr[i24] = i28;
                    return;
                }
                int i36 = i24 - 1;
                iArr[i24] = iArr2[i35];
                if ((i8 & 2) != 0) {
                    while (true) {
                        i19 = i35 - 1;
                        iArr2[i35] = iArr2[i25];
                        i20 = i25 - 1;
                        iArr2[i25] = iArr2[i19];
                        if (iArr2[i20] >= 0) {
                            break;
                        }
                        i25 = i20;
                        i35 = i19;
                    }
                    i8 ^= 2;
                    i25 = i20;
                    i35 = i19;
                }
                int i37 = i35 - 1;
                iArr2[i35] = iArr2[i25];
                int i38 = i25 - 1;
                iArr2[i25] = iArr2[i37];
                if (i38 < i3) {
                    while (i2 < i36) {
                        int i39 = i37 - 1;
                        iArr2[i37] = iArr[i36];
                        iArr[i36] = iArr2[i39];
                        i37 = i39;
                        i36--;
                    }
                    iArr2[i37] = iArr[i36];
                    iArr[i36] = i28;
                    return;
                }
                if (iArr[i36] < 0) {
                    i17 = i8 | 1;
                    i16 = i + (~iArr[i36]);
                } else {
                    int i40 = i8;
                    i16 = i + iArr[i36];
                    i17 = i40;
                }
                if (iArr2[i38] < 0) {
                    i17 |= 2;
                    i18 = ~iArr2[i38];
                } else {
                    i18 = iArr2[i38];
                }
                i26 = i + i18;
                int i41 = i16;
                i8 = i17;
                i25 = i38;
                i7 = i41;
                i24 = i36;
                i27 = i37;
            }
        }
    }

    private void ssMergeCheckEqual(int i, int i2, int i3) {
        int[] iArr = this.SA;
        if (iArr[i3] < 0 || ssCompare(getIDX(iArr[i3 - 1]) + i, i + iArr[i3], i2) != 0) {
            return;
        }
        iArr[i3] = ~iArr[i3];
    }

    private void ssMerge(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = i15 - i14;
            if (i18 <= i6) {
                if (i13 >= i14 || i14 >= i15) {
                    i8 = i15;
                } else {
                    i8 = i15;
                    ssMergeBackward(i, iArr, i5, i13, i14, i15, i7);
                }
                if ((i16 & 1) != 0) {
                    ssMergeCheckEqual(i, i7, i13);
                }
                if ((i16 & 2) != 0) {
                    ssMergeCheckEqual(i, i7, i8);
                }
                if (i17 == 0) {
                    return;
                }
                i17--;
                StackEntry stackEntry = stackEntryArr[i17];
                i13 = stackEntry.a;
                i14 = stackEntry.b;
                i15 = stackEntry.c;
                i9 = stackEntry.d;
            } else {
                int i19 = i15;
                int i20 = i14 - i13;
                if (i20 <= i6) {
                    if (i13 < i14) {
                        ssMergeForward(i, iArr, i5, i13, i14, i19, i7);
                    }
                    if ((i16 & 1) != 0) {
                        ssMergeCheckEqual(i, i7, i13);
                    }
                    if ((i16 & 2) != 0) {
                        ssMergeCheckEqual(i, i7, i19);
                    }
                    if (i17 == 0) {
                        return;
                    }
                    i17--;
                    StackEntry stackEntry2 = stackEntryArr[i17];
                    i13 = stackEntry2.a;
                    i14 = stackEntry2.b;
                    i15 = stackEntry2.c;
                    i9 = stackEntry2.d;
                } else {
                    int min = Math.min(i20, i18);
                    int i21 = min >> 1;
                    int i22 = 0;
                    while (min > 0) {
                        if (ssCompare(getIDX(iArr2[i14 + i22 + i21]) + i, getIDX(iArr2[((i14 - i22) - i21) - 1]) + i, i7) < 0) {
                            i22 += i21 + 1;
                            i21 -= (min & 1) ^ 1;
                        }
                        min = i21;
                        i21 = min >> 1;
                    }
                    if (i22 > 0) {
                        int i23 = i14 - i22;
                        ssBlockSwap(iArr2, i23, iArr2, i14, i22);
                        int i24 = i14 + i22;
                        if (i24 < i19) {
                            if (iArr2[i24] < 0) {
                                i12 = i14;
                                while (iArr2[i12 - 1] < 0) {
                                    i12--;
                                }
                                iArr2[i24] = ~iArr2[i24];
                            } else {
                                i12 = i14;
                            }
                            i10 = i14;
                            while (iArr2[i10] < 0) {
                                i10++;
                            }
                            i15 = i12;
                            i11 = 1;
                        } else {
                            i10 = i14;
                            i15 = i10;
                            i11 = 0;
                        }
                        if (i15 - i13 <= i19 - i10) {
                            stackEntryArr[i17] = new StackEntry(i10, i24, i19, (i11 & 1) | (i16 & 2));
                            i16 &= 1;
                            i14 = i23;
                            i17++;
                        } else {
                            if (i15 == i14 && i14 == i10) {
                                i11 <<= 1;
                            }
                            stackEntryArr[i17] = new StackEntry(i13, i23, i15, (i16 & 1) | (i11 & 2));
                            i16 = (i16 & 2) | (i11 & 1);
                            i14 = i24;
                            i17++;
                            i13 = i10;
                            i15 = i19;
                        }
                    } else {
                        if ((i16 & 1) != 0) {
                            ssMergeCheckEqual(i, i7, i13);
                        }
                        ssMergeCheckEqual(i, i7, i14);
                        if ((i16 & 2) != 0) {
                            ssMergeCheckEqual(i, i7, i19);
                        }
                        if (i17 == 0) {
                            return;
                        }
                        i17--;
                        StackEntry stackEntry3 = stackEntryArr[i17];
                        i13 = stackEntry3.a;
                        i14 = stackEntry3.b;
                        i15 = stackEntry3.c;
                        i9 = stackEntry3.d;
                    }
                }
            }
            i16 = i9;
        }
    }

    private void subStringSort(int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, boolean z, int i7) {
        int i8;
        int i9;
        int[] iArr2;
        int[] iArr3 = this.SA;
        int i10 = z ? i2 + 1 : i2;
        int i11 = 0;
        int i12 = i10;
        while (true) {
            int i13 = i12 + 1024;
            if (i13 >= i3) {
                break;
            }
            ssMultiKeyIntroSort(i, i12, i13, i6);
            int i14 = i3 - i13;
            if (i14 <= i5) {
                iArr2 = iArr;
                i9 = i4;
                i8 = i5;
            } else {
                i8 = i14;
                i9 = i13;
                iArr2 = iArr3;
            }
            int i15 = i12;
            int i16 = 1024;
            int i17 = i11;
            while ((i17 & 1) != 0) {
                int i18 = i15 - i16;
                ssMerge(i, i18, i15, i15 + i16, iArr2, i9, i8, i6);
                i16 <<= 1;
                i17 >>>= 1;
                i15 = i18;
                i13 = i13;
            }
            i11++;
            i12 = i13;
        }
        ssMultiKeyIntroSort(i, i12, i3, i6);
        int i19 = i12;
        int i20 = 1024;
        for (int i21 = i11; i21 != 0; i21 >>= 1) {
            if ((i21 & 1) != 0) {
                int i22 = i19 - i20;
                ssMerge(i, i22, i19, i3, iArr, i4, i5, i6);
                i19 = i22;
            }
            i20 <<= 1;
        }
        if (z) {
            int i23 = iArr3[i10 - 1];
            int i24 = 1;
            while (i10 < i3 && (iArr3[i10] < 0 || (i24 = ssCompareLast(i, i + i23, i + iArr3[i10], i6, i7)) > 0)) {
                iArr3[i10 - 1] = iArr3[i10];
                i10++;
            }
            if (i24 == 0) {
                iArr3[i10] = ~iArr3[i10];
            }
            iArr3[i10 - 1] = i23;
        }
    }

    private int trGetC(int i, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        return i5 < i3 ? this.SA[i5] : this.SA[i + (((i2 - i) + i4) % (i3 - i))];
    }

    private void trFixdown(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.SA;
        int i7 = iArr[i4 + i5];
        int trGetC = trGetC(i, i2, i3, i7);
        while (true) {
            int i8 = (i5 * 2) + 1;
            if (i8 >= i6) {
                break;
            }
            int i9 = i8 + 1;
            int trGetC2 = trGetC(i, i2, i3, iArr[i4 + i8]);
            int trGetC3 = trGetC(i, i2, i3, iArr[i4 + i9]);
            if (trGetC2 < trGetC3) {
                i8 = i9;
                trGetC2 = trGetC3;
            }
            if (trGetC2 <= trGetC) {
                break;
            }
            iArr[i5 + i4] = iArr[i4 + i8];
            i5 = i8;
        }
        iArr[i4 + i5] = i7;
    }

    private void trHeapSort(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int[] iArr = this.SA;
        int i7 = i5 % 2;
        if (i7 == 0) {
            int i8 = i5 - 1;
            int i9 = (i8 / 2) + i4;
            int i10 = i4 + i8;
            if (trGetC(i, i2, i3, iArr[i9]) < trGetC(i, i2, i3, iArr[i10])) {
                swapElements(iArr, i10, iArr, i9);
            }
            i6 = i8;
        } else {
            i6 = i5;
        }
        for (int i11 = (i6 / 2) - 1; i11 >= 0; i11--) {
            trFixdown(i, i2, i3, i4, i11, i6);
        }
        if (i7 == 0) {
            swapElements(iArr, i4, iArr, i4 + i6);
            trFixdown(i, i2, i3, i4, 0, i6);
        }
        for (int i12 = i6 - 1; i12 > 0; i12--) {
            int i13 = iArr[i4];
            int i14 = i4 + i12;
            iArr[i4] = iArr[i14];
            trFixdown(i, i2, i3, i4, 0, i12);
            iArr[i14] = i13;
        }
    }

    private void trInsertionSort(int i, int i2, int i3, int i4, int i5) {
        int trGetC;
        int[] iArr = this.SA;
        for (int i6 = i4 + 1; i6 < i5; i6++) {
            int i7 = iArr[i6];
            int i8 = i6 - 1;
            do {
                trGetC = trGetC(i, i2, i3, i7) - trGetC(i, i2, i3, iArr[i8]);
                if (trGetC >= 0) {
                    break;
                }
                do {
                    iArr[i8 + 1] = iArr[i8];
                    i8--;
                    if (i4 > i8) {
                        break;
                    }
                } while (iArr[i8] < 0);
            } while (i8 >= i4);
            if (trGetC == 0) {
                iArr[i8] = ~iArr[i8];
            }
            iArr[i8 + 1] = i7;
        }
    }

    private static int trLog(int i) {
        return ((-65536) & i) != 0 ? ((-16777216) & i) != 0 ? LOG_2_TABLE[(i >> 24) & 255] + 24 : LOG_2_TABLE[(i >> 16) & 271] : (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int trMedian3(int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i, i2, i3, iArr[i4]);
        int trGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int trGetC3 = trGetC(i, i2, i3, iArr[i6]);
        if (trGetC <= trGetC2) {
            i5 = i4;
            i4 = i5;
            trGetC2 = trGetC;
            trGetC = trGetC2;
        }
        return trGetC > trGetC3 ? trGetC2 > trGetC3 ? i5 : i6 : i4;
    }

    private int trMedian5(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i, i2, i3, iArr[i4]);
        int trGetC2 = trGetC(i, i2, i3, iArr[i5]);
        int trGetC3 = trGetC(i, i2, i3, iArr[i6]);
        int trGetC4 = trGetC(i, i2, i3, iArr[i7]);
        int trGetC5 = trGetC(i, i2, i3, iArr[i8]);
        if (trGetC2 > trGetC3) {
            i6 = i5;
            i5 = i6;
            trGetC3 = trGetC2;
            trGetC2 = trGetC3;
        }
        if (trGetC4 > trGetC5) {
            trGetC4 = trGetC5;
            trGetC5 = trGetC4;
        } else {
            i8 = i7;
            i7 = i8;
        }
        if (trGetC2 > trGetC4) {
            int i9 = trGetC3;
            trGetC3 = trGetC5;
            trGetC5 = i9;
            int i10 = i7;
            i7 = i6;
            i6 = i10;
        } else {
            i5 = i8;
            trGetC2 = trGetC4;
        }
        if (trGetC > trGetC3) {
            int i11 = i6;
            i6 = i4;
            i4 = i11;
            int i12 = trGetC3;
            trGetC3 = trGetC;
            trGetC = i12;
        }
        if (trGetC > trGetC2) {
            i5 = i4;
            trGetC2 = trGetC;
        } else {
            i7 = i6;
            trGetC5 = trGetC3;
        }
        return trGetC5 > trGetC2 ? i5 : i7;
    }

    private int trPivot(int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 - i4;
        int i7 = i4 + (i6 / 2);
        if (i6 <= 512) {
            if (i6 <= 32) {
                return trMedian3(i, i2, i3, i4, i7, i5 - 1);
            }
            int i8 = i6 >> 2;
            int i9 = i5 - 1;
            return trMedian5(i, i2, i3, i4, i4 + i8, i7, i9 - i8, i9);
        }
        int i10 = i6 >> 3;
        int i11 = i10 << 1;
        int i12 = i5 - 1;
        return trMedian3(i, i2, i3, trMedian3(i, i2, i3, i4, i4 + i10, i4 + i11), trMedian3(i, i2, i3, i7 - i10, i7, i7 + i10), trMedian3(i, i2, i3, i12 - i11, i12 - i10, i12));
    }

    private void lsUpdateGroup(int i, int i2, int i3) {
        int[] iArr = this.SA;
        while (i2 < i3) {
            if (iArr[i2] >= 0) {
                int i4 = i2;
                do {
                    iArr[iArr[i4] + i] = i4;
                    i4++;
                    if (i4 >= i3) {
                        break;
                    }
                } while (iArr[i4] >= 0);
                iArr[i2] = i2 - i4;
                if (i3 <= i4) {
                    return;
                } else {
                    i2 = i4;
                }
            }
            int i5 = i2;
            do {
                iArr[i5] = ~iArr[i5];
                i5++;
            } while (iArr[i5] < 0);
            do {
                iArr[iArr[i2] + i] = i5;
                i2++;
            } while (i2 <= i5);
            i2 = i5 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0128 -> B:54:0x00fc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void lsIntroSort(int r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.lsIntroSort(int, int, int, int, int):void");
    }

    private void lsSort(int i, int i2, int i3) {
        int i4;
        int[] iArr = this.SA;
        int i5 = i3 + i;
        while (true) {
            int i6 = 0;
            if ((-i2) >= iArr[0]) {
                return;
            }
            int i7 = 0;
            int i8 = 0;
            do {
                int i9 = iArr[i8];
                if (i9 < 0) {
                    i8 -= i9;
                    i7 += i9;
                } else {
                    if (i7 != 0) {
                        iArr[i8 + i7] = i7;
                        i4 = 0;
                    } else {
                        i4 = i7;
                    }
                    int i10 = iArr[i9 + i] + 1;
                    lsIntroSort(i, i5, i + i2, i8, i10);
                    i7 = i4;
                    i8 = i10;
                }
            } while (i8 < i2);
            if (i7 != 0) {
                iArr[i8 + i7] = i7;
            }
            int i11 = i5 - i;
            if (i2 < i11) {
                do {
                    int i12 = iArr[i6];
                    if (i12 < 0) {
                        i6 -= i12;
                    } else {
                        int i13 = iArr[i12 + i] + 1;
                        while (i6 < i13) {
                            iArr[iArr[i6] + i] = i6;
                            i6++;
                        }
                        i6 = i13;
                    }
                } while (i6 < i2);
                return;
            }
            i5 += i11;
        }
    }

    private static class PartitionResult {
        final int first;
        final int last;

        PartitionResult(int i, int i2) {
            this.first = i;
            this.last = i2;
        }
    }

    private PartitionResult trPartition(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int trGetC;
        int trGetC2;
        int trGetC3;
        int[] iArr = this.SA;
        int i9 = 0;
        int i10 = i4;
        while (i10 < i5) {
            i9 = trGetC(i, i2, i3, iArr[i10]);
            if (i9 != i6) {
                break;
            }
            i10++;
        }
        if (i10 < i5 && i9 < i6) {
            i7 = i10;
            while (true) {
                i10++;
                if (i10 >= i5 || (i9 = trGetC(i, i2, i3, iArr[i10])) > i6) {
                    break;
                }
                if (i9 == i6) {
                    swapElements(iArr, i10, iArr, i7);
                    i7++;
                }
            }
        } else {
            i7 = i10;
        }
        int i11 = i5 - 1;
        while (i10 < i11) {
            i9 = trGetC(i, i2, i3, iArr[i11]);
            if (i9 != i6) {
                break;
            }
            i11--;
        }
        if (i10 < i11 && i9 > i6) {
            i8 = i11;
            while (true) {
                i11--;
                if (i10 >= i11 || (trGetC3 = trGetC(i, i2, i3, iArr[i11])) < i6) {
                    break;
                }
                if (trGetC3 == i6) {
                    swapElements(iArr, i11, iArr, i8);
                    i8--;
                }
            }
        } else {
            i8 = i11;
        }
        while (i10 < i11) {
            swapElements(iArr, i10, iArr, i11);
            while (true) {
                i10++;
                if (i10 >= i11 || (trGetC2 = trGetC(i, i2, i3, iArr[i10])) > i6) {
                    break;
                }
                if (trGetC2 == i6) {
                    swapElements(iArr, i10, iArr, i7);
                    i7++;
                }
            }
            while (true) {
                i11--;
                if (i10 < i11 && (trGetC = trGetC(i, i2, i3, iArr[i11])) >= i6) {
                    if (trGetC == i6) {
                        swapElements(iArr, i11, iArr, i8);
                        i8--;
                    }
                }
            }
        }
        if (i7 <= i8) {
            int i12 = i10 - 1;
            int i13 = i7 - i4;
            int i14 = i10 - i7;
            if (i13 > i14) {
                i13 = i14;
            }
            int i15 = i10 - i13;
            int i16 = i4;
            while (i13 > 0) {
                swapElements(iArr, i16, iArr, i15);
                i13--;
                i16++;
                i15++;
            }
            int i17 = i8 - i12;
            int i18 = (i5 - i8) - 1;
            if (i17 <= i18) {
                i18 = i17;
            }
            int i19 = i5 - i18;
            while (i18 > 0) {
                swapElements(iArr, i10, iArr, i19);
                i18--;
                i10++;
                i19++;
            }
            i4 += i14;
            i5 -= i17;
        }
        return new PartitionResult(i4, i5);
    }

    private void trCopy(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = this.SA;
        int i8 = i5 - 1;
        int i9 = i4 - 1;
        while (i3 <= i9) {
            int i10 = iArr[i3] - i7;
            if (i10 < 0) {
                i10 += i2 - i;
            }
            int i11 = i + i10;
            if (iArr[i11] == i8) {
                i9++;
                iArr[i9] = i10;
                iArr[i11] = i9;
            }
            i3++;
        }
        int i12 = i6 - 1;
        int i13 = i9 + 1;
        while (i13 < i5) {
            int i14 = iArr[i12] - i7;
            if (i14 < 0) {
                i14 += i2 - i;
            }
            int i15 = i + i14;
            if (iArr[i15] == i8) {
                i5--;
                iArr[i5] = i14;
                iArr[i15] = i5;
            }
            i12--;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:207:0x04e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02fa  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x02ee -> B:138:0x02c1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trIntroSort(int r22, int r23, int r24, int r25, int r26, io.netty.handler.codec.compression.Bzip2DivSufSort.TRBudget r27, int r28) {
        /*
            Method dump skipped, instructions count: 1302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.trIntroSort(int, int, int, int, int, io.netty.handler.codec.compression.Bzip2DivSufSort$TRBudget, int):void");
    }

    private static class TRBudget {
        int budget;
        int chance;

        TRBudget(int i, int i2) {
            this.budget = i;
            this.chance = i2;
        }

        boolean update(int i, int i2) {
            int i3 = this.budget - i2;
            this.budget = i3;
            if (i3 <= 0) {
                int i4 = this.chance - 1;
                this.chance = i4;
                if (i4 == 0) {
                    return false;
                }
                this.budget = i3 + i;
            }
            return true;
        }
    }

    private void trSort(int i, int i2, int i3) {
        int[] iArr = this.SA;
        if ((-i2) < iArr[0]) {
            TRBudget tRBudget = new TRBudget(i2, ((trLog(i2) * 2) / 3) + 1);
            int i4 = 0;
            do {
                int i5 = iArr[i4];
                if (i5 < 0) {
                    i4 -= i5;
                } else {
                    int i6 = iArr[i + i5] + 1;
                    if (1 < i6 - i4) {
                        trIntroSort(i, i + i3, i + i2, i4, i6, tRBudget, i2);
                        if (tRBudget.chance == 0) {
                            if (i4 > 0) {
                                iArr[0] = -i4;
                            }
                            lsSort(i, i2, i3);
                            return;
                        }
                    }
                    i4 = i6;
                }
            } while (i4 < i2);
        }
    }

    private int sortTypeBstar(int[] iArr, int[] iArr2) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        byte[] bArr = this.T;
        int[] iArr4 = this.SA;
        int i14 = this.n;
        int[] iArr5 = new int[256];
        int i15 = 1;
        while (true) {
            z = false;
            i = 255;
            if (i15 >= i14) {
                break;
            }
            int i16 = i15 - 1;
            if (bArr[i16] == bArr[i15]) {
                i15++;
            } else if ((bArr[i16] & 255) > (bArr[i15] & 255)) {
                z2 = false;
            }
        }
        z2 = true;
        int i17 = i14 - 1;
        int i18 = bArr[i17] & 255;
        int i19 = bArr[0] & 255;
        if (i18 < i19 || (bArr[i17] == bArr[0] && z2)) {
            if (!z2) {
                int BUCKET_BSTAR = BUCKET_BSTAR(i18, i19);
                iArr2[BUCKET_BSTAR] = iArr2[BUCKET_BSTAR] + 1;
                i2 = i14 - 1;
                iArr4[i2] = i17;
            } else {
                int BUCKET_B = BUCKET_B(i18, i19);
                iArr2[BUCKET_B] = iArr2[BUCKET_B] + 1;
                i2 = i14;
            }
            i3 = i17 - 1;
            while (i3 >= 0) {
                int i20 = bArr[i3] & 255;
                int i21 = bArr[i3 + 1] & 255;
                if (i20 <= i21) {
                    int BUCKET_B2 = BUCKET_B(i20, i21);
                    iArr2[BUCKET_B2] = iArr2[BUCKET_B2] + 1;
                    i3--;
                }
            }
        } else {
            i2 = i14;
            i3 = i17;
        }
        while (i3 >= 0) {
            do {
                int i22 = bArr[i3] & 255;
                iArr[i22] = iArr[i22] + 1;
                i3--;
                if (i3 < 0) {
                    break;
                }
            } while ((bArr[i3] & 255) >= (bArr[i3 + 1] & 255));
            if (i3 >= 0) {
                int BUCKET_BSTAR2 = BUCKET_BSTAR(bArr[i3] & 255, bArr[i3 + 1] & 255);
                iArr2[BUCKET_BSTAR2] = iArr2[BUCKET_BSTAR2] + 1;
                i2--;
                iArr4[i2] = i3;
                while (true) {
                    i3--;
                    if (i3 >= 0 && (i12 = bArr[i3] & 255) <= (i13 = bArr[i3 + 1] & 255)) {
                        int BUCKET_B3 = BUCKET_B(i12, i13);
                        iArr2[BUCKET_B3] = iArr2[BUCKET_B3] + 1;
                    }
                }
            }
        }
        int i23 = i14 - i2;
        if (i23 == 0) {
            for (int i24 = 0; i24 < i14; i24++) {
                iArr4[i24] = i24;
            }
            return 0;
        }
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        while (i25 < 256) {
            int i28 = iArr[i25] + i27;
            iArr[i25] = i27 + i26;
            int i29 = i28 + iArr2[BUCKET_B(i25, i25)];
            int i30 = i25 + 1;
            for (int i31 = i30; i31 < 256; i31++) {
                i26 += iArr2[BUCKET_BSTAR(i25, i31)];
                iArr2[(i25 << 8) | i31] = i26;
                i29 += iArr2[BUCKET_B(i25, i31)];
            }
            i25 = i30;
            i27 = i29;
        }
        int i32 = i14 - i23;
        for (int i33 = i23 - 2; i33 >= 0; i33--) {
            int i34 = iArr4[i32 + i33];
            int BUCKET_BSTAR3 = BUCKET_BSTAR(bArr[i34] & 255, bArr[i34 + 1] & 255);
            int i35 = iArr2[BUCKET_BSTAR3] - 1;
            iArr2[BUCKET_BSTAR3] = i35;
            iArr4[i35] = i33;
        }
        int i36 = iArr4[(i32 + i23) - 1];
        int BUCKET_BSTAR4 = BUCKET_BSTAR(bArr[i36] & 255, bArr[i36 + 1] & 255);
        int i37 = iArr2[BUCKET_BSTAR4] - 1;
        iArr2[BUCKET_BSTAR4] = i37;
        int i38 = i23 - 1;
        iArr4[i37] = i38;
        int i39 = i14 - (i23 * 2);
        if (i39 <= 256) {
            i4 = 256;
            iArr3 = iArr5;
            i5 = 0;
        } else {
            i4 = i39;
            i5 = i23;
            iArr3 = iArr4;
        }
        int i40 = i23;
        int i41 = 255;
        while (i40 > 0) {
            int i42 = i40;
            int i43 = i;
            while (i41 < i43) {
                int i44 = iArr2[BUCKET_BSTAR(i41, i43)];
                if (1 < i42 - i44) {
                    boolean z3 = iArr4[i44] == i38 ? true : z;
                    i8 = i43;
                    i9 = i41;
                    i10 = i38;
                    i11 = i23;
                    subStringSort(i32, i44, i42, iArr3, i5, i4, 2, z3, i14);
                } else {
                    i8 = i43;
                    i9 = i41;
                    i10 = i38;
                    i11 = i23;
                }
                i43 = i8 - 1;
                i23 = i11;
                i42 = i44;
                i41 = i9;
                i38 = i10;
                z = false;
            }
            i41--;
            i40 = i42;
            i = 255;
            z = false;
        }
        int i45 = i38;
        int i46 = i23;
        while (i38 >= 0) {
            if (iArr4[i38] >= 0) {
                int i47 = i38;
                do {
                    iArr4[i46 + iArr4[i47]] = i47;
                    i47--;
                    if (i47 < 0) {
                        break;
                    }
                } while (iArr4[i47] >= 0);
                iArr4[i47 + 1] = i47 - i38;
                if (i47 <= 0) {
                    break;
                }
                i38 = i47;
            }
            int i48 = i38;
            do {
                int i49 = ~iArr4[i48];
                iArr4[i48] = i49;
                iArr4[i46 + i49] = i38;
                i48--;
            } while (iArr4[i48] < 0);
            iArr4[i46 + iArr4[i48]] = i38;
            i38 = i48 - 1;
        }
        trSort(i46, i46, 1);
        if ((bArr[i17] & 255) < (bArr[0] & 255) || (bArr[i17] == bArr[0] && z2)) {
            if (z2) {
                i6 = i46;
            } else {
                i6 = i46 - 1;
                iArr4[iArr4[i46 + i6]] = i17;
            }
            i7 = i17 - 1;
            while (i7 >= 0 && (bArr[i7] & 255) <= (bArr[i7 + 1] & 255)) {
                i7--;
            }
        } else {
            i6 = i46;
            i7 = i17;
        }
        while (i7 >= 0) {
            do {
                i7--;
                if (i7 < 0) {
                    break;
                }
            } while ((bArr[i7] & 255) >= (bArr[i7 + 1] & 255));
            if (i7 >= 0) {
                i6--;
                iArr4[iArr4[i46 + i6]] = i7;
                do {
                    i7--;
                    if (i7 >= 0) {
                    }
                } while ((bArr[i7] & 255) <= (bArr[i7 + 1] & 255));
            }
        }
        int i50 = i45;
        for (int i51 = 255; i51 >= 0; i51--) {
            for (int i52 = 255; i51 < i52; i52--) {
                int i53 = i17 - iArr2[BUCKET_B(i51, i52)];
                iArr2[BUCKET_B(i51, i52)] = i17 + 1;
                int i54 = iArr2[BUCKET_BSTAR(i51, i52)];
                i17 = i53;
                while (i54 <= i50) {
                    iArr4[i17] = iArr4[i50];
                    i17--;
                    i50--;
                }
            }
            int i55 = i17 - iArr2[BUCKET_B(i51, i51)];
            iArr2[BUCKET_B(i51, i51)] = i17 + 1;
            if (i51 < 255) {
                iArr2[BUCKET_BSTAR(i51, i51 + 1)] = i55 + 1;
            }
            i17 = iArr[i51];
        }
        return i46;
    }

    private int constructBWT(int[] iArr, int[] iArr2) {
        byte[] bArr = this.T;
        int[] iArr3 = this.SA;
        int i = this.n;
        int i2 = 254;
        int i3 = 0;
        int i4 = 0;
        while (i2 >= 0) {
            int i5 = i2 + 1;
            int i6 = iArr2[BUCKET_BSTAR(i2, i5)];
            int i7 = -1;
            int i8 = 0;
            for (int i9 = iArr[i5]; i6 <= i9; i9--) {
                int i10 = iArr3[i9];
                if (i10 >= 0) {
                    int i11 = i10 - 1;
                    if (i11 < 0) {
                        i11 = i - 1;
                    }
                    int i12 = bArr[i11] & 255;
                    if (i12 <= i2) {
                        iArr3[i9] = ~i10;
                        if (i11 > 0 && (bArr[i11 - 1] & 255) > i12) {
                            i11 = ~i11;
                        }
                        if (i7 == i12) {
                            i8--;
                            iArr3[i8] = i11;
                        } else {
                            if (i7 >= 0) {
                                iArr2[BUCKET_B(i7, i2)] = i8;
                            }
                            i8 = iArr2[BUCKET_B(i12, i2)] - 1;
                            iArr3[i8] = i11;
                            i7 = i12;
                        }
                    }
                } else {
                    iArr3[i9] = ~i10;
                }
            }
            i2--;
            i3 = i8;
            i4 = i7;
        }
        int i13 = -1;
        for (int i14 = 0; i14 < i; i14++) {
            int i15 = iArr3[i14];
            if (i15 >= 0) {
                int i16 = i15 - 1;
                if (i16 < 0) {
                    i16 = i - 1;
                }
                int i17 = bArr[i16] & 255;
                if (i17 >= (bArr[i16 + 1] & 255)) {
                    if (i16 > 0 && (bArr[i16 - 1] & 255) < i17) {
                        i16 = ~i16;
                    }
                    if (i17 == i4) {
                        i3++;
                        iArr3[i3] = i16;
                    } else {
                        if (i4 != -1) {
                            iArr[i4] = i3;
                        }
                        i3 = iArr[i17] + 1;
                        iArr3[i3] = i16;
                        i4 = i17;
                    }
                }
            } else {
                i15 = ~i15;
            }
            if (i15 == 0) {
                iArr3[i14] = bArr[i - 1];
                i13 = i14;
            } else {
                iArr3[i14] = bArr[i15 - 1];
            }
        }
        return i13;
    }

    public int bwt() {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i = this.n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            iArr[0] = bArr[0];
            return 0;
        }
        if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        }
        return 0;
    }
}
