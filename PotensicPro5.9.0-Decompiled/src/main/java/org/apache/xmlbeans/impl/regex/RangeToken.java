package org.apache.xmlbeans.impl.regex;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.Serializable;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
final class RangeToken extends Token implements Serializable {
    private static final int MAPSIZE = 256;
    boolean compacted;
    RangeToken icaseCache;
    int[] map;
    int nonMapIndex;
    int[] ranges;
    boolean sorted;

    RangeToken(int i) {
        super(i);
        this.icaseCache = null;
        this.map = null;
        setSorted(false);
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void addRange(int i, int i2) {
        this.icaseCache = null;
        if (i > i2) {
            i2 = i;
            i = i2;
        }
        int[] iArr = this.ranges;
        if (iArr == null) {
            this.ranges = new int[]{i, i2};
            setSorted(true);
            return;
        }
        int length = iArr.length;
        int i3 = length - 1;
        if (iArr[i3] + 1 == i) {
            iArr[i3] = i2;
            return;
        }
        int[] iArr2 = new int[length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.ranges = iArr2;
        if (iArr2[i3] >= i) {
            setSorted(false);
        }
        int[] iArr3 = this.ranges;
        iArr3[length] = i;
        iArr3[length + 1] = i2;
        if (this.sorted) {
            return;
        }
        sortRanges();
    }

    private final boolean isSorted() {
        return this.sorted;
    }

    private final void setSorted(boolean z) {
        this.sorted = z;
        if (z) {
            return;
        }
        this.compacted = false;
    }

    private final boolean isCompacted() {
        return this.compacted;
    }

    private final void setCompacted() {
        this.compacted = true;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void sortRanges() {
        int[] iArr;
        if (isSorted() || (iArr = this.ranges) == null) {
            return;
        }
        for (int length = iArr.length - 4; length >= 0; length -= 2) {
            int i = 0;
            while (i <= length) {
                int[] iArr2 = this.ranges;
                int i2 = i + 2;
                if (iArr2[i] > iArr2[i2] || (iArr2[i] == iArr2[i2] && iArr2[i + 1] > iArr2[i + 3])) {
                    int i3 = iArr2[i2];
                    iArr2[i2] = iArr2[i];
                    iArr2[i] = i3;
                    int i4 = i + 3;
                    int i5 = iArr2[i4];
                    int i6 = i + 1;
                    iArr2[i4] = iArr2[i6];
                    iArr2[i6] = i5;
                }
                i = i2;
            }
        }
        setSorted(true);
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void compactRanges() {
        int i;
        int i2;
        int[] iArr = this.ranges;
        if (iArr == null || iArr.length <= 2 || isCompacted()) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr2 = this.ranges;
            if (i3 < iArr2.length) {
                if (i4 != i3) {
                    int i5 = i3 + 1;
                    iArr2[i4] = iArr2[i3];
                    i = i5 + 1;
                    iArr2[i4 + 1] = iArr2[i5];
                } else {
                    i = i3 + 2;
                }
                int i6 = i4 + 1;
                int i7 = iArr2[i6];
                while (true) {
                    int[] iArr3 = this.ranges;
                    if (i < iArr3.length && (i2 = i7 + 1) >= iArr3[i]) {
                        if (i2 == iArr3[i]) {
                            iArr3[i6] = iArr3[i + 1];
                            i7 = iArr3[i6];
                        } else {
                            int i8 = i + 1;
                            if (i7 >= iArr3[i8]) {
                                continue;
                            } else if (i7 < iArr3[i8]) {
                                iArr3[i6] = iArr3[i8];
                                i7 = iArr3[i6];
                            } else {
                                throw new RuntimeException(new StringBuffer().append("Token#compactRanges(): Internel Error: [").append(this.ranges[i4]).append(",").append(this.ranges[i6]).append("] [").append(this.ranges[i]).append(",").append(this.ranges[i8]).append("]").toString());
                            }
                        }
                        i += 2;
                    }
                }
                i4 += 2;
                i3 = i;
            } else {
                if (i4 != iArr2.length) {
                    int[] iArr4 = new int[i4];
                    System.arraycopy(iArr2, 0, iArr4, 0, i4);
                    this.ranges = iArr4;
                }
                setCompacted();
                return;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void mergeRanges(Token token) {
        RangeToken rangeToken = (RangeToken) token;
        sortRanges();
        rangeToken.sortRanges();
        if (rangeToken.ranges == null) {
            return;
        }
        this.icaseCache = null;
        setSorted(true);
        int[] iArr = this.ranges;
        int i = 0;
        if (iArr == null) {
            int[] iArr2 = new int[rangeToken.ranges.length];
            this.ranges = iArr2;
            int[] iArr3 = rangeToken.ranges;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            return;
        }
        int[] iArr4 = new int[iArr.length + rangeToken.ranges.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr5 = this.ranges;
            if (i < iArr5.length || i2 < rangeToken.ranges.length) {
                if (i >= iArr5.length) {
                    int i4 = i3 + 1;
                    int[] iArr6 = rangeToken.ranges;
                    int i5 = i2 + 1;
                    iArr4[i3] = iArr6[i2];
                    i3 = i4 + 1;
                    i2 = i5 + 1;
                    iArr4[i4] = iArr6[i5];
                } else {
                    int[] iArr7 = rangeToken.ranges;
                    if (i2 >= iArr7.length) {
                        int i6 = i3 + 1;
                        int i7 = i + 1;
                        iArr4[i3] = iArr5[i];
                        i3 = i6 + 1;
                        i = i7 + 1;
                        iArr4[i6] = iArr5[i7];
                    } else if (iArr7[i2] < iArr5[i] || (iArr7[i2] == iArr5[i] && iArr7[i2 + 1] < iArr5[i + 1])) {
                        int i8 = i3 + 1;
                        int i9 = i2 + 1;
                        iArr4[i3] = iArr7[i2];
                        i3 = i8 + 1;
                        i2 = i9 + 1;
                        iArr4[i8] = iArr7[i9];
                    } else {
                        int i10 = i3 + 1;
                        int i11 = i + 1;
                        iArr4[i3] = iArr5[i];
                        i3 = i10 + 1;
                        i = i11 + 1;
                        iArr4[i10] = iArr5[i11];
                    }
                }
            } else {
                this.ranges = iArr4;
                return;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    protected void subtractRanges(Token token) {
        if (token.type == 5) {
            intersectRanges(token);
            return;
        }
        RangeToken rangeToken = (RangeToken) token;
        if (rangeToken.ranges == null || this.ranges == null) {
            return;
        }
        this.icaseCache = null;
        sortRanges();
        compactRanges();
        rangeToken.sortRanges();
        rangeToken.compactRanges();
        int[] iArr = new int[this.ranges.length + rangeToken.ranges.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.ranges;
            if (i >= iArr2.length) {
                break;
            }
            int[] iArr3 = rangeToken.ranges;
            if (i2 >= iArr3.length) {
                break;
            }
            int i4 = iArr2[i];
            int i5 = i + 1;
            int i6 = iArr2[i5];
            int i7 = iArr3[i2];
            int i8 = i2 + 1;
            int i9 = iArr3[i8];
            if (i6 < i7) {
                int i10 = i3 + 1;
                iArr[i3] = iArr2[i];
                i3 = i10 + 1;
                i = i5 + 1;
                iArr[i10] = iArr2[i5];
            } else {
                if (i6 >= i7 && i4 <= i9) {
                    if (i7 > i4 || i6 > i9) {
                        if (i7 <= i4) {
                            iArr2[i] = i9 + 1;
                        } else if (i6 <= i9) {
                            int i11 = i3 + 1;
                            iArr[i3] = i4;
                            i3 = i11 + 1;
                            iArr[i11] = i7 - 1;
                        } else {
                            int i12 = i3 + 1;
                            iArr[i3] = i4;
                            i3 = i12 + 1;
                            iArr[i12] = i7 - 1;
                            iArr2[i] = i9 + 1;
                        }
                    }
                    i += 2;
                } else if (i9 >= i4) {
                    throw new RuntimeException(new StringBuffer().append("Token#subtractRanges(): Internal Error: [").append(this.ranges[i]).append(",").append(this.ranges[i5]).append("] - [").append(rangeToken.ranges[i2]).append(",").append(rangeToken.ranges[i8]).append("]").toString());
                }
                i2 += 2;
            }
        }
        while (true) {
            int[] iArr4 = this.ranges;
            if (i < iArr4.length) {
                int i13 = i3 + 1;
                int i14 = i + 1;
                iArr[i3] = iArr4[i];
                i3 = i13 + 1;
                i = i14 + 1;
                iArr[i13] = iArr4[i14];
            } else {
                int[] iArr5 = new int[i3];
                this.ranges = iArr5;
                System.arraycopy(iArr, 0, iArr5, 0, i3);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
    
        r13 = r12.ranges;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ce, code lost:
    
        if (r2 >= r13.length) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d0, code lost:
    
        r3 = r4 + 1;
        r5 = r2 + 1;
        r0[r4] = r13[r2];
        r4 = r3 + 1;
        r2 = r5 + 1;
        r0[r3] = r13[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e1, code lost:
    
        r13 = new int[r4];
        r12.ranges = r13;
        java.lang.System.arraycopy(r0, 0, r13, 0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e8, code lost:
    
        return;
     */
    @Override // org.apache.xmlbeans.impl.regex.Token
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void intersectRanges(org.apache.xmlbeans.impl.regex.Token r13) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RangeToken.intersectRanges(org.apache.xmlbeans.impl.regex.Token):void");
    }

    static Token complementRanges(Token token) {
        if (token.type != 4 && token.type != 5) {
            throw new IllegalArgumentException(new StringBuffer().append("Token#complementRanges(): must be RANGE: ").append(token.type).toString());
        }
        RangeToken rangeToken = (RangeToken) token;
        rangeToken.sortRanges();
        rangeToken.compactRanges();
        int[] iArr = rangeToken.ranges;
        int length = iArr.length + 2;
        int i = 0;
        if (iArr[0] == 0) {
            length -= 2;
        }
        int i2 = iArr[iArr.length - 1];
        if (i2 == 1114111) {
            length -= 2;
        }
        RangeToken createRange = Token.createRange();
        int[] iArr2 = new int[length];
        createRange.ranges = iArr2;
        int[] iArr3 = rangeToken.ranges;
        if (iArr3[0] > 0) {
            iArr2[0] = 0;
            iArr2[1] = iArr3[0] - 1;
            i = 2;
        }
        int i3 = 1;
        while (true) {
            int[] iArr4 = rangeToken.ranges;
            if (i3 >= iArr4.length - 2) {
                break;
            }
            int[] iArr5 = createRange.ranges;
            int i4 = i + 1;
            iArr5[i] = iArr4[i3] + 1;
            i = i4 + 1;
            iArr5[i4] = iArr4[i3 + 1] - 1;
            i3 += 2;
        }
        if (i2 != 1114111) {
            int[] iArr6 = createRange.ranges;
            iArr6[i] = i2 + 1;
            iArr6[i + 1] = 1114111;
        }
        createRange.setCompacted();
        return createRange;
    }

    synchronized RangeToken getCaseInsensitiveToken() {
        RangeToken rangeToken = this.icaseCache;
        if (rangeToken != null) {
            return rangeToken;
        }
        RangeToken createRange = this.type == 4 ? Token.createRange() : Token.createNRange();
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.ranges;
            if (i2 >= iArr.length) {
                break;
            }
            for (int i3 = iArr[i2]; i3 <= this.ranges[i2 + 1]; i3++) {
                if (i3 > 65535) {
                    createRange.addRange(i3, i3);
                } else {
                    char upperCase = Character.toUpperCase((char) i3);
                    createRange.addRange(upperCase, upperCase);
                }
            }
            i2 += 2;
        }
        RangeToken createRange2 = this.type == 4 ? Token.createRange() : Token.createNRange();
        while (true) {
            int[] iArr2 = createRange.ranges;
            if (i < iArr2.length) {
                for (int i4 = iArr2[i]; i4 <= createRange.ranges[i + 1]; i4++) {
                    if (i4 > 65535) {
                        createRange2.addRange(i4, i4);
                    } else {
                        char upperCase2 = Character.toUpperCase((char) i4);
                        createRange2.addRange(upperCase2, upperCase2);
                    }
                }
                i += 2;
            } else {
                createRange2.mergeRanges(createRange);
                createRange2.mergeRanges(this);
                createRange2.compactRanges();
                this.icaseCache = createRange2;
                return createRange2;
            }
        }
    }

    void dumpRanges() {
        System.err.print("RANGE: ");
        if (this.ranges == null) {
            System.err.println(" NULL");
        }
        for (int i = 0; i < this.ranges.length; i += 2) {
            System.err.print(new StringBuffer().append("[").append(this.ranges[i]).append(",").append(this.ranges[i + 1]).append("] ").toString());
        }
        System.err.println("");
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    boolean match(int i) {
        if (this.map == null) {
            createMap();
        }
        if (this.type == 4) {
            if (i < 256) {
                return ((1 << (i & 31)) & this.map[i / 32]) != 0;
            }
            int i2 = this.nonMapIndex;
            while (true) {
                int[] iArr = this.ranges;
                if (i2 >= iArr.length) {
                    return false;
                }
                if (iArr[i2] <= i && i <= iArr[i2 + 1]) {
                    return true;
                }
                i2 += 2;
            }
        } else {
            if (i < 256) {
                return ((1 << (i & 31)) & this.map[i / 32]) == 0;
            }
            int i3 = this.nonMapIndex;
            while (true) {
                int[] iArr2 = this.ranges;
                if (i3 >= iArr2.length) {
                    return true;
                }
                if (iArr2[i3] <= i && i <= iArr2[i3 + 1]) {
                    return false;
                }
                i3 += 2;
            }
        }
    }

    private void createMap() {
        int[] iArr = new int[8];
        int length = this.ranges.length;
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = 0;
        }
        while (true) {
            int[] iArr2 = this.ranges;
            if (i >= iArr2.length) {
                break;
            }
            int i3 = iArr2[i];
            int i4 = iArr2[i + 1];
            if (i3 >= 256) {
                break;
            }
            while (i3 <= i4 && i3 < 256) {
                int i5 = i3 / 32;
                iArr[i5] = iArr[i5] | (1 << (i3 & 31));
                i3++;
            }
            if (i4 >= 256) {
                break;
            } else {
                i += 2;
            }
        }
        length = i;
        this.nonMapIndex = length;
        this.map = iArr;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public String toString(int i) {
        int i2 = 0;
        if (this.type == 4) {
            if (this == Token.token_dot) {
                return ".";
            }
            if (this == Token.token_0to9) {
                return "\\d";
            }
            if (this == Token.token_wordchars) {
                return "\\w";
            }
            if (this == Token.token_spaces) {
                return "\\s";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            while (i2 < this.ranges.length) {
                if ((i & 1024) != 0 && i2 > 0) {
                    stringBuffer.append(",");
                }
                int[] iArr = this.ranges;
                int i3 = i2 + 1;
                if (iArr[i2] == iArr[i3]) {
                    stringBuffer.append(escapeCharInCharClass(iArr[i2]));
                } else {
                    stringBuffer.append(escapeCharInCharClass(iArr[i2]));
                    stringBuffer.append(NameUtil.HYPHEN);
                    stringBuffer.append(escapeCharInCharClass(this.ranges[i3]));
                }
                i2 += 2;
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
        if (this == Token.token_not_0to9) {
            return "\\D";
        }
        if (this == Token.token_not_wordchars) {
            return "\\W";
        }
        if (this == Token.token_not_spaces) {
            return "\\S";
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("[^");
        while (i2 < this.ranges.length) {
            if ((i & 1024) != 0 && i2 > 0) {
                stringBuffer2.append(",");
            }
            int[] iArr2 = this.ranges;
            int i4 = i2 + 1;
            if (iArr2[i2] == iArr2[i4]) {
                stringBuffer2.append(escapeCharInCharClass(iArr2[i2]));
            } else {
                stringBuffer2.append(escapeCharInCharClass(iArr2[i2]));
                stringBuffer2.append(NameUtil.HYPHEN);
                stringBuffer2.append(escapeCharInCharClass(this.ranges[i4]));
            }
            i2 += 2;
        }
        stringBuffer2.append("]");
        return stringBuffer2.toString();
    }

    private static String escapeCharInCharClass(int i) {
        if (i == 9) {
            return "\\t";
        }
        if (i == 10) {
            return "\\n";
        }
        if (i == 12) {
            return "\\f";
        }
        if (i == 13) {
            return "\\r";
        }
        if (i == 27) {
            return "\\e";
        }
        if (i != 44 && i != 45) {
            switch (i) {
                case 91:
                case 92:
                case 93:
                case 94:
                    break;
                default:
                    if (i < 32) {
                        String stringBuffer = new StringBuffer().append(SessionDescription.SUPPORTED_SDP_VERSION).append(Integer.toHexString(i)).toString();
                        return new StringBuffer().append("\\x").append(stringBuffer.substring(stringBuffer.length() - 2, stringBuffer.length())).toString();
                    }
                    if (i >= 65536) {
                        String stringBuffer2 = new StringBuffer().append(SessionDescription.SUPPORTED_SDP_VERSION).append(Integer.toHexString(i)).toString();
                        return new StringBuffer().append("\\v").append(stringBuffer2.substring(stringBuffer2.length() - 6, stringBuffer2.length())).toString();
                    }
                    return new StringBuffer().append("").append((char) i).toString();
            }
        }
        return new StringBuffer().append("\\").append((char) i).toString();
    }
}
