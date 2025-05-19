package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes.dex */
final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean z) throws IOException {
        return sniffInternal(extractorInput, false, z);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        long length = extractorInput.getLength();
        long j = -1;
        long j2 = 4096;
        if (length != -1 && length <= 4096) {
            j2 = length;
        }
        int i = (int) j2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z8 = false;
        int i2 = 0;
        boolean z9 = false;
        while (i2 < i) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), z8 ? 1 : 0, 8, true)) {
                break;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            int i3 = 16;
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                readUnsignedInt = parsableByteArray.readLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j) {
                        readUnsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                    }
                }
                i3 = 8;
            }
            long j3 = i3;
            if (readUnsignedInt < j3) {
                return z8;
            }
            i2 += i3;
            if (readInt == 1836019574) {
                i += (int) readUnsignedInt;
                if (length != -1 && i > length) {
                    i = (int) length;
                }
            } else {
                if (readInt == 1836019558 || readInt == 1836475768) {
                    z3 = z8 ? 1 : 0;
                    z4 = true;
                    z5 = true;
                    break;
                }
                long j4 = length;
                if ((i2 + readUnsignedInt) - j3 >= i) {
                    z3 = false;
                    z4 = true;
                    break;
                }
                int i4 = (int) (readUnsignedInt - j3);
                i2 += i4;
                if (readInt != 1718909296) {
                    z6 = false;
                    z9 = z9;
                    if (i4 != 0) {
                        extractorInput.advancePeekPosition(i4);
                        z9 = z9;
                    }
                } else {
                    if (i4 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i4);
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i4);
                    int i5 = i4 / 4;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i5) {
                            z7 = z9;
                            break;
                        }
                        if (i6 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt(), z2)) {
                            z7 = true;
                            break;
                        }
                        i6++;
                    }
                    if (!z7) {
                        return false;
                    }
                    z6 = false;
                    z9 = z7;
                }
                z8 = z6;
                length = j4;
            }
            j = -1;
            z9 = z9;
        }
        z3 = z8 ? 1 : 0;
        z4 = true;
        z5 = z3;
        return (z9 && z == z5) ? z4 : z3;
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
