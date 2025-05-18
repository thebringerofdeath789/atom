package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '0' && c <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            }
            if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            }
            if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001d, code lost:
    
        if (r6 <= '4') goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto Lc
            if (r6 < r2) goto Lb
            if (r6 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r5 != r3) goto L15
            if (r6 < r2) goto L14
            if (r6 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r5 != r3) goto L42
            if (r6 < r2) goto L42
            r5 = 52
            if (r6 <= r5) goto L20
            goto L42
        L20:
            r5 = 53
            r6 = 54
            if (r7 < r2) goto L2d
            if (r7 > r5) goto L2d
            if (r8 < r2) goto L2c
            if (r8 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r7 != r6) goto L42
            if (r8 == r2) goto L32
            return r1
        L32:
            if (r9 < r2) goto L3b
            if (r9 > r5) goto L3b
            if (r10 < r2) goto L3a
            if (r10 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r9 != r6) goto L42
            if (r10 == r2) goto L40
            return r1
        L40:
            r5 = 1
            return r5
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.f79bp = -1;
        next();
        if (this.f80ch == 65279) {
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        return i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.f79bp + 1;
        this.f79bp = i;
        char charAt = i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
        this.f80ch = charAt;
        return charAt;
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.f79bp, cArr);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.f81np + 1;
            int i2 = this.f82sp;
            if (i2 % 2 != 0) {
                throw new JSONException("illegal state. " + i2);
            }
            int i3 = i2 / 2;
            byte[] bArr = new byte[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 2) + i;
                char charAt = this.text.charAt(i5);
                char charAt2 = this.text.charAt(i5 + 1);
                char c = '0';
                int i6 = charAt - (charAt <= '9' ? '0' : '7');
                if (charAt2 > '9') {
                    c = '7';
                }
                bArr[i4] = (byte) ((i6 << 4) | (charAt2 - c));
            }
            return bArr;
        }
        return IOUtils.decodeBase64(this.text, this.f81np + 1, this.f82sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.f81np + 1, this.f82sp);
        }
        return new String(this.sbuf, 0, this.f82sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            if (i2 < this.sbuf.length) {
                this.text.getChars(i, i + i2, this.sbuf, 0);
                return new String(this.sbuf, 0, i2);
            }
            char[] cArr = new char[i2];
            this.text.getChars(i, i2 + i, cArr, 0);
            return new String(cArr);
        }
        return this.text.substring(i, i2 + i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (ASMUtils.IS_ANDROID && i2 < this.sbuf.length) {
            this.text.getChars(i, i2 + i, this.sbuf, 0);
            return this.sbuf;
        }
        char[] cArr = new char[i2];
        this.text.getChars(i, i2 + i, cArr, 0);
        return cArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.f81np + this.f82sp) - 1);
        int i = this.f82sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.f81np, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.f81np + this.f82sp) - 1);
        int i = this.f82sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.f81np;
        if (i < this.sbuf.length) {
            this.text.getChars(i2, i2 + i, this.sbuf, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr = new char[i];
        this.text.getChars(i2, i + i2, cArr, 0);
        return new BigDecimal(cArr);
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.f79bp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e7, code lost:
    
        if (r6 != ' ') goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x021c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0583 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0584  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean scanISO8601DateIfMatch(boolean r35, int r36) {
        /*
            Method dump skipped, instructions count: 1789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    protected void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    protected void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    protected void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.f79bp != this.len) {
            return this.f80ch == 26 && this.f79bp + 1 == this.len;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r15 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        if (r3 >= 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0070, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        if (r6 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
    
        if (r15 == '\"') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
    
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007e, code lost:
    
        r11 = r15;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
    
        if (r15 == ',') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
    
        if (r15 != '}') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008d, code lost:
    
        if (isWhitespace(r15) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
    
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007e, code lost:
    
        r11 = r15;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0096, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0098, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
    
        r11 = r11 - 1;
        r14.f79bp = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009e, code lost:
    
        if (r15 != ',') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:
    
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
        r14.f80ch = charAt(r15);
        r14.matchStat = 3;
        r14.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
    
        if (r7 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
    
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b4, code lost:
    
        if (r15 != '}') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b6, code lost:
    
        r14.f79bp = r11;
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
        r15 = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c1, code lost:
    
        if (r15 != ',') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
    
        if (r15 != ']') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e5, code lost:
    
        if (r15 != '}') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f9, code lost:
    
        if (r15 != 26) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0107, code lost:
    
        if (isWhitespace(r15) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0109, code lost:
    
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
        r15 = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0113, code lost:
    
        r14.f79bp = r1;
        r14.f80ch = r2;
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0119, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00fb, code lost:
    
        r14.token = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ff, code lost:
    
        r14.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00e7, code lost:
    
        r14.token = 13;
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
        r14.f80ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00d5, code lost:
    
        r14.token = 15;
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
        r14.f80ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00c3, code lost:
    
        r14.token = 16;
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
        r14.f80ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x011a, code lost:
    
        if (r7 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x011d, code lost:
    
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
    
        return r3;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int scanFieldInt(char[] r15) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldInt(char[]):int");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.f79bp;
        char c = this.f80ch;
        while (!charArrayCompare(this.text, this.f79bp, cArr)) {
            if (isWhitespace(this.f80ch)) {
                next();
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.f79bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String subString = subString(i2, indexOf - i2);
        if (subString.indexOf(92) != -1) {
            while (true) {
                int i3 = 0;
                for (int i4 = indexOf - 1; i4 >= 0 && charAt(i4) == '\\'; i4--) {
                    i3++;
                }
                if (i3 % 2 == 0) {
                    break;
                }
                indexOf = indexOf('\"', indexOf + 1);
            }
            int length2 = indexOf - ((this.f79bp + cArr.length) + 1);
            subString = readString(sub_chars(this.f79bp + cArr.length + 1, length2), length2);
        }
        char charAt = charAt(indexOf + 1);
        while (charAt != ',' && charAt != '}') {
            if (isWhitespace(charAt)) {
                indexOf++;
                charAt = charAt(indexOf + 1);
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        this.f79bp = indexOf + 1;
        this.f80ch = charAt;
        if (charAt == ',') {
            int i5 = this.f79bp + 1;
            this.f79bp = i5;
            this.f80ch = charAt(i5);
            this.matchStat = 3;
            return subString;
        }
        int i6 = this.f79bp + 1;
        this.f79bp = i6;
        char charAt2 = charAt(i6);
        if (charAt2 == ',') {
            this.token = 16;
            int i7 = this.f79bp + 1;
            this.f79bp = i7;
            this.f80ch = charAt(i7);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i8 = this.f79bp + 1;
            this.f79bp = i8;
            this.f80ch = charAt(i8);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i9 = this.f79bp + 1;
            this.f79bp = i9;
            this.f80ch = charAt(i9);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.f79bp = i;
            this.f80ch = c;
            this.matchStat = -1;
            return stringDefaultValue();
        }
        this.matchStat = 4;
        return subString;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        char c;
        long j;
        char c2;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.f79bp;
        char c3 = this.f80ch;
        if (!charArrayCompare(this.text, this.f79bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.f79bp + cArr.length;
        int i3 = length + 1;
        char charAt = charAt(length);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i3);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.f79bp = i3;
            if (scanISO8601DateIfMatch(false, indexOf - i3)) {
                date = this.calendar.getTime();
                c2 = charAt(indexOf + 1);
                this.f79bp = i2;
                while (c2 != ',' && c2 != '}') {
                    if (isWhitespace(c2)) {
                        indexOf++;
                        c2 = charAt(indexOf + 1);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.f79bp = indexOf + 1;
                this.f80ch = c2;
            } else {
                this.f79bp = i2;
                this.matchStat = -1;
                return null;
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i3);
                i3++;
                z = true;
            }
            if (charAt < '0' || charAt > '9') {
                c = charAt;
                j = 0;
            } else {
                j = charAt - '0';
                while (true) {
                    i = i3 + 1;
                    c = charAt(i3);
                    if (c < c5 || c > c4) {
                        break;
                    }
                    j = (j * 10) + (c - '0');
                    i3 = i;
                    c4 = '9';
                    c5 = '0';
                }
                if (c == ',' || c == '}') {
                    this.f79bp = i - 1;
                }
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            c2 = c;
            date = new Date(j);
        }
        if (c2 == ',') {
            int i4 = this.f79bp + 1;
            this.f79bp = i4;
            this.f80ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i5 = this.f79bp + 1;
        this.f79bp = i5;
        char charAt2 = charAt(i5);
        if (charAt2 == ',') {
            this.token = 16;
            int i6 = this.f79bp + 1;
            this.f79bp = i6;
            this.f80ch = charAt(i6);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i7 = this.f79bp + 1;
            this.f79bp = i7;
            this.f80ch = charAt(i7);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i8 = this.f79bp + 1;
            this.f79bp = i8;
            this.f80ch = charAt(i8);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.f79bp = i2;
            this.f80ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.f79bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.f79bp + cArr.length;
        int i = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == '\"') {
                this.f79bp = i2;
                char charAt2 = charAt(this.f79bp);
                this.f80ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.f79bp + 1;
                            this.f79bp = i3;
                            this.f80ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.f79bp + 1;
                            this.f79bp = i4;
                            this.f80ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.f79bp + 1;
                            this.f79bp = i5;
                            this.f80ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j;
                    }
                    if (isWhitespace(charAt2)) {
                        int i6 = this.f79bp + 1;
                        this.f79bp = i6;
                        charAt2 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i7 = this.f79bp + 1;
                this.f79bp = i7;
                this.f80ch = charAt(i7);
                this.matchStat = 3;
                return j;
            }
            if (i2 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j = (j ^ charAt) * 1099511628211L;
            i = i2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00df, code lost:
    
        if (r1 != ']') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00e5, code lost:
    
        if (r3.size() != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00e7, code lost:
    
        r1 = r9 + 1;
        r2 = charAt(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00f1, code lost:
    
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00f4, code lost:
    
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r18, java.lang.Class<?> r19) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0114, code lost:
    
        r20.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0117, code lost:
    
        if (r11 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x011a, code lost:
    
        return -r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return r2;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long scanFieldLong(char[] r21) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldLong(char[]):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fd A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanFieldBoolean(char[] r11) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        if (r4 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0089, code lost:
    
        if (r7 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:
    
        if (r4 == '\"') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008f, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0090, code lost:
    
        r4 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0097, code lost:
    
        if (r3 >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0099, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009e, code lost:
    
        if (r4 != r17) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b7, code lost:
    
        if (isWhitespace(r4) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b9, code lost:
    
        r4 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c1, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c3, code lost:
    
        if (r8 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c6, code lost:
    
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a0, code lost:
    
        r16.f79bp = r13;
        r16.f80ch = charAt(r16.f79bp);
        r16.matchStat = 3;
        r16.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00af, code lost:
    
        if (r8 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b2, code lost:
    
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return r3;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int scanInt(char r17) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanInt(char):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c4 -> B:42:0x00b4). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double scanDouble(char r22) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanDouble(char):double");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.f79bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            i3 = i4;
            charAt2 = charAt3;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            int i5 = i3 + 1;
            char charAt4 = charAt(i3);
            i3 = i5;
            charAt2 = charAt4;
        }
        char c2 = '0';
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(i3);
                if (charAt < c2 || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i3 = i;
                c2 = '0';
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z2) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(i);
                i++;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z3)) {
                z = true;
            }
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.f79bp = i;
            this.f80ch = charAt(this.f79bp);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j : j;
        }
        if (charAt2 == 'n') {
            int i6 = i3 + 1;
            if (charAt(i3) == 'u') {
                int i7 = i6 + 1;
                if (charAt(i6) == 'l') {
                    int i8 = i7 + 1;
                    if (charAt(i7) == 'l') {
                        this.matchStat = 5;
                        int i9 = i8 + 1;
                        char charAt5 = charAt(i8);
                        if (z2 && charAt5 == '\"') {
                            int i10 = i9 + 1;
                            char charAt6 = charAt(i9);
                            i9 = i10;
                            charAt5 = charAt6;
                        }
                        while (charAt5 != ',') {
                            if (charAt5 == ']') {
                                this.f79bp = i9;
                                this.f80ch = charAt(this.f79bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            }
                            if (isWhitespace(charAt5)) {
                                int i11 = i9 + 1;
                                char charAt7 = charAt(i9);
                                i9 = i11;
                                charAt5 = charAt7;
                            } else {
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                        this.f79bp = i9;
                        this.f80ch = charAt(this.f79bp);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c) {
        char c2;
        long j;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.f79bp;
        char c3 = this.f80ch;
        int i3 = this.f79bp;
        int i4 = i3 + 1;
        char charAt = charAt(i3);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i4);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.f79bp = i4;
            if (scanISO8601DateIfMatch(false, indexOf - i4)) {
                date = this.calendar.getTime();
                c2 = charAt(indexOf + 1);
                this.f79bp = i2;
                while (c2 != ',' && c2 != ']') {
                    if (isWhitespace(c2)) {
                        indexOf++;
                        c2 = charAt(indexOf + 1);
                    } else {
                        this.f79bp = i2;
                        this.f80ch = c3;
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.f79bp = indexOf + 1;
                this.f80ch = c2;
            } else {
                this.f79bp = i2;
                this.f80ch = c3;
                this.matchStat = -1;
                return null;
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                if (charAt == 'n') {
                    int i5 = i4 + 1;
                    if (charAt(i4) == 'u') {
                        int i6 = i5 + 1;
                        if (charAt(i5) == 'l') {
                            int i7 = i6 + 1;
                            if (charAt(i6) == 'l') {
                                c2 = charAt(i7);
                                this.f79bp = i7;
                                date = null;
                            }
                        }
                    }
                }
                this.f79bp = i2;
                this.f80ch = c3;
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i4);
                i4++;
                z = true;
            }
            if (charAt < '0' || charAt > '9') {
                c2 = charAt;
                j = 0;
            } else {
                j = charAt - '0';
                while (true) {
                    i = i4 + 1;
                    c2 = charAt(i4);
                    if (c2 < c5 || c2 > c4) {
                        break;
                    }
                    j = (j * 10) + (c2 - '0');
                    i4 = i;
                    c4 = '9';
                    c5 = '0';
                }
                if (c2 == ',' || c2 == ']') {
                    this.f79bp = i - 1;
                }
            }
            if (j < 0) {
                this.f79bp = i2;
                this.f80ch = c3;
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (c2 == ',') {
            int i8 = this.f79bp + 1;
            this.f79bp = i8;
            this.f80ch = charAt(i8);
            this.matchStat = 3;
            return date;
        }
        int i9 = this.f79bp + 1;
        this.f79bp = i9;
        char charAt2 = charAt(i9);
        if (charAt2 == ',') {
            this.token = 16;
            int i10 = this.f79bp + 1;
            this.f79bp = i10;
            this.f80ch = charAt(i10);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i11 = this.f79bp + 1;
            this.f79bp = i11;
            this.f80ch = charAt(i11);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i12 = this.f79bp + 1;
            this.f79bp = i12;
            this.f80ch = charAt(i12);
        } else if (charAt2 == 26) {
            this.f80ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.f79bp = i2;
            this.f80ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.f79bp) {
            if (this.text.charAt(i) == '\n') {
                i2++;
                i3 = 1;
            }
            i++;
            i3++;
        }
        sb.append("pos ").append(this.f79bp).append(", line ").append(i2).append(", column ").append(i3);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, 65535));
        }
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        int i2;
        char c;
        int i3 = this.f79bp;
        char c2 = this.f80ch;
        while (isWhitespace(this.f80ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.f79bp + cArr.length;
            int i4 = length + 1;
            char charAt = this.text.charAt(length);
            while (isWhitespace(charAt)) {
                charAt = this.text.charAt(i4);
                i4++;
            }
            if (charAt == ':') {
                i2 = i4 + 1;
                c = this.text.charAt(i4);
                while (isWhitespace(c)) {
                    c = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.f79bp + 1;
            c = this.f80ch;
        }
        if (c == '[') {
            this.f79bp = i2;
            this.f80ch = this.text.charAt(this.f79bp);
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            int i5 = 0;
            while (true) {
                if (isWhitespace(this.f80ch)) {
                    next();
                } else {
                    if (this.f80ch != '\"') {
                        this.f79bp = i3;
                        this.f80ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = scanSymbol;
                    while (isWhitespace(this.f80ch)) {
                        next();
                    }
                    if (this.f80ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            String[] strArr3 = new String[i6];
                            System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (isWhitespace(this.f80ch)) {
                            next();
                        }
                        if (this.f80ch == ']') {
                            next();
                            return strArr;
                        }
                        this.f79bp = i3;
                        this.f80ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else {
            if (c == 'n' && this.text.startsWith("ull", this.f79bp + 1)) {
                this.f79bp += 4;
                this.f80ch = this.text.charAt(this.f79bp);
                return null;
            }
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (isWhitespace(this.f80ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.f79bp + cArr.length;
        int i = length + 1;
        char charAt = this.text.charAt(length);
        while (isWhitespace(charAt)) {
            charAt = this.text.charAt(i);
            i++;
        }
        if (charAt == ':') {
            this.f79bp = i;
            this.f80ch = charAt(this.f79bp);
            return true;
        }
        this.matchStat = -2;
        return false;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        skipObject(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z) {
        int i = this.f79bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i >= this.len - 1) {
                    this.f80ch = charAt;
                    this.f79bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt == '{') {
                if (!z2) {
                    i2++;
                }
            } else if (charAt == '}' && !z2 && i2 - 1 == -1) {
                this.f79bp = i + 1;
                int i3 = this.f79bp;
                int length = this.text.length();
                char c = JSONLexer.EOI;
                if (i3 == length) {
                    this.f80ch = JSONLexer.EOI;
                    this.token = 20;
                    return;
                }
                this.f80ch = this.text.charAt(this.f79bp);
                if (this.f80ch == ',') {
                    this.token = 16;
                    int i4 = this.f79bp + 1;
                    this.f79bp = i4;
                    if (i4 < this.text.length()) {
                        c = this.text.charAt(i4);
                    }
                    this.f80ch = c;
                    return;
                }
                if (this.f80ch == '}') {
                    this.token = 13;
                    next();
                    return;
                } else if (this.f80ch == ']') {
                    this.token = 15;
                    next();
                    return;
                } else {
                    nextToken(16);
                    return;
                }
            }
            i++;
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    public final void skipArray(boolean z) {
        int i = this.f79bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i >= this.len - 1) {
                    this.f80ch = charAt;
                    this.f79bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt != '[') {
                char c = JSONLexer.EOI;
                if (charAt == '{' && z) {
                    int i3 = this.f79bp + 1;
                    this.f79bp = i3;
                    if (i3 < this.text.length()) {
                        c = this.text.charAt(i3);
                    }
                    this.f80ch = c;
                    skipObject(z);
                } else if (charAt == ']' && !z2 && i2 - 1 == -1) {
                    this.f79bp = i + 1;
                    if (this.f79bp == this.text.length()) {
                        this.f80ch = JSONLexer.EOI;
                        this.token = 20;
                        return;
                    } else {
                        this.f80ch = this.text.charAt(this.f79bp);
                        nextToken(16);
                        return;
                    }
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i == this.text.length()) {
            throw new JSONException("illegal str, " + info());
        }
    }

    public final void skipString() {
        if (this.f80ch == '\"') {
            int i = this.f79bp;
            while (true) {
                i++;
                if (i < this.text.length()) {
                    char charAt = this.text.charAt(i);
                    if (charAt == '\\') {
                        if (i < this.len - 1) {
                            i++;
                        }
                    } else if (charAt == '\"') {
                        String str = this.text;
                        int i2 = i + 1;
                        this.f79bp = i2;
                        this.f80ch = str.charAt(i2);
                        return;
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index must > 0, but " + i);
        }
        if (this.token == 20) {
            return false;
        }
        if (this.token != 14) {
            throw new UnsupportedOperationException();
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < i) {
                skipWhitespace();
                if (this.f80ch == '\"' || this.f80ch == '\'') {
                    skipString();
                    if (this.f80ch == ',') {
                        next();
                    } else {
                        if (this.f80ch == ']') {
                            next();
                            nextToken(16);
                            return false;
                        }
                        throw new JSONException("illegal json.");
                    }
                } else {
                    if (this.f80ch == '{') {
                        next();
                        this.token = 12;
                        skipObject(false);
                    } else if (this.f80ch == '[') {
                        next();
                        this.token = 14;
                        skipArray(false);
                    } else {
                        int i3 = this.f79bp + 1;
                        while (true) {
                            if (i3 >= this.text.length()) {
                                z = false;
                                break;
                            }
                            char charAt = this.text.charAt(i3);
                            if (charAt == ',') {
                                this.f79bp = i3 + 1;
                                this.f80ch = charAt(this.f79bp);
                                break;
                            }
                            if (charAt == ']') {
                                this.f79bp = i3 + 1;
                                this.f80ch = charAt(this.f79bp);
                                nextToken();
                                return false;
                            }
                            i3++;
                        }
                        if (!z) {
                            throw new JSONException("illegal json.");
                        }
                    }
                    if (this.token != 16) {
                        if (this.token == 15) {
                            return false;
                        }
                        throw new UnsupportedOperationException();
                    }
                }
                i2++;
            } else {
                nextToken();
                return true;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long j, boolean z) {
        int i = -1;
        if (this.token == 20) {
            return -1;
        }
        if (this.token != 13) {
            int i2 = 15;
            if (this.token != 15) {
                int i3 = 16;
                if (this.token != 12 && this.token != 16) {
                    throw new UnsupportedOperationException(JSONToken.name(this.token));
                }
                while (this.f80ch != '}') {
                    if (this.f80ch == 26) {
                        return i;
                    }
                    if (this.f80ch != '\"') {
                        skipWhitespace();
                    }
                    if (this.f80ch == '\"') {
                        long j2 = -3750763034362895579L;
                        int i4 = this.f79bp + 1;
                        while (true) {
                            if (i4 >= this.text.length()) {
                                break;
                            }
                            char charAt = this.text.charAt(i4);
                            if (charAt == '\\') {
                                i4++;
                                if (i4 == this.text.length()) {
                                    throw new JSONException("unclosed str, " + info());
                                }
                                charAt = this.text.charAt(i4);
                            }
                            if (charAt == '\"') {
                                this.f79bp = i4 + 1;
                                this.f80ch = this.f79bp >= this.text.length() ? (char) 26 : this.text.charAt(this.f79bp);
                            } else {
                                j2 = (j2 ^ charAt) * 1099511628211L;
                                i4++;
                            }
                        }
                        if (j2 == j) {
                            if (this.f80ch != ':') {
                                skipWhitespace();
                            }
                            if (this.f80ch != ':') {
                                return 3;
                            }
                            int i5 = this.f79bp + 1;
                            this.f79bp = i5;
                            this.f80ch = i5 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i5);
                            if (this.f80ch == ',') {
                                int i6 = this.f79bp + 1;
                                this.f79bp = i6;
                                this.f80ch = i6 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i6);
                                this.token = i3;
                                return 3;
                            }
                            if (this.f80ch == ']') {
                                int i7 = this.f79bp + 1;
                                this.f79bp = i7;
                                this.f80ch = i7 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i7);
                                this.token = i2;
                                return 3;
                            }
                            if (this.f80ch == '}') {
                                int i8 = this.f79bp + 1;
                                this.f79bp = i8;
                                this.f80ch = i8 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i8);
                                this.token = 13;
                                return 3;
                            }
                            if (this.f80ch >= '0' && this.f80ch <= '9') {
                                this.f82sp = 0;
                                this.pos = this.f79bp;
                                scanNumber();
                                return 3;
                            }
                            nextToken(2);
                            return 3;
                        }
                        if (this.f80ch != ':') {
                            skipWhitespace();
                        }
                        if (this.f80ch == ':') {
                            int i9 = this.f79bp + 1;
                            this.f79bp = i9;
                            this.f80ch = i9 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i9);
                            if (this.f80ch != '\"' && this.f80ch != '\'' && this.f80ch != '{' && this.f80ch != '[' && this.f80ch != '0' && this.f80ch != '1' && this.f80ch != '2' && this.f80ch != '3' && this.f80ch != '4' && this.f80ch != '5' && this.f80ch != '6' && this.f80ch != '7' && this.f80ch != '8' && this.f80ch != '9' && this.f80ch != '+' && this.f80ch != '-') {
                                skipWhitespace();
                            }
                            if (this.f80ch == '-' || this.f80ch == '+' || (this.f80ch >= '0' && this.f80ch <= '9')) {
                                next();
                                while (this.f80ch >= '0' && this.f80ch <= '9') {
                                    next();
                                }
                                if (this.f80ch == '.') {
                                    next();
                                    while (this.f80ch >= '0' && this.f80ch <= '9') {
                                        next();
                                    }
                                }
                                if (this.f80ch == 'E' || this.f80ch == 'e') {
                                    next();
                                    if (this.f80ch == '-' || this.f80ch == '+') {
                                        next();
                                    }
                                    while (this.f80ch >= '0' && this.f80ch <= '9') {
                                        next();
                                    }
                                }
                                if (this.f80ch != ',') {
                                    skipWhitespace();
                                }
                                if (this.f80ch == ',') {
                                    next();
                                }
                            } else if (this.f80ch == '\"') {
                                skipString();
                                if (this.f80ch != ',' && this.f80ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.f80ch == ',') {
                                    next();
                                }
                            } else if (this.f80ch == 't') {
                                next();
                                if (this.f80ch == 'r') {
                                    next();
                                    if (this.f80ch == 'u') {
                                        next();
                                        if (this.f80ch == 'e') {
                                            next();
                                        }
                                    }
                                }
                                if (this.f80ch != ',' && this.f80ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.f80ch == ',') {
                                    next();
                                }
                            } else if (this.f80ch == 'n') {
                                next();
                                if (this.f80ch == 'u') {
                                    next();
                                    if (this.f80ch == 'l') {
                                        next();
                                        if (this.f80ch == 'l') {
                                            next();
                                        }
                                    }
                                }
                                if (this.f80ch != ',' && this.f80ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.f80ch == ',') {
                                    next();
                                }
                            } else if (this.f80ch == 'f') {
                                next();
                                if (this.f80ch == 'a') {
                                    next();
                                    if (this.f80ch == 'l') {
                                        next();
                                        if (this.f80ch == 's') {
                                            next();
                                            if (this.f80ch == 'e') {
                                                next();
                                            }
                                        }
                                    }
                                }
                                if (this.f80ch != ',' && this.f80ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.f80ch == ',') {
                                    next();
                                }
                            } else if (this.f80ch == '{') {
                                int i10 = this.f79bp + 1;
                                this.f79bp = i10;
                                this.f80ch = i10 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i10);
                                if (z) {
                                    this.token = 12;
                                    return 1;
                                }
                                skipObject(false);
                                if (this.token == 13) {
                                    return -1;
                                }
                            } else if (this.f80ch == '[') {
                                next();
                                if (z) {
                                    this.token = 14;
                                    return 2;
                                }
                                skipArray(false);
                                if (this.token == 13) {
                                    return -1;
                                }
                            } else {
                                throw new UnsupportedOperationException();
                            }
                            i = -1;
                            i2 = 15;
                            i3 = 16;
                        } else {
                            throw new JSONException("illegal json, " + info());
                        }
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
                next();
                nextToken();
                return i;
            }
        }
        nextToken();
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0249, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0251, code lost:
    
        if (r14.f80ch != '.') goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0253, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0258, code lost:
    
        if (r14.f80ch < '0') goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x025c, code lost:
    
        if (r14.f80ch > '9') goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x025e, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0266, code lost:
    
        if (r14.f80ch == 'E') goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x026c, code lost:
    
        if (r14.f80ch != 'e') goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x028a, code lost:
    
        if (r14.f80ch == ',') goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x028c, code lost:
    
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0291, code lost:
    
        if (r14.f80ch != ',') goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0293, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x026e, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0273, code lost:
    
        if (r14.f80ch == '-') goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0277, code lost:
    
        if (r14.f80ch != '+') goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027e, code lost:
    
        if (r14.f80ch < '0') goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0282, code lost:
    
        if (r14.f80ch > '9') goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0284, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0279, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01f3, code lost:
    
        if (r14.f80ch != '\"') goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x020e, code lost:
    
        if (r14.f80ch != '{') goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x022e, code lost:
    
        if (r14.f80ch != '[') goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0230, code lost:
    
        next();
        skipArray(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x023d, code lost:
    
        throw new java.lang.UnsupportedOperationException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0210, code lost:
    
        r2 = r14.f79bp + 1;
        r14.f79bp = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x021c, code lost:
    
        if (r2 < r14.text.length()) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x021f, code lost:
    
        r4 = r14.text.charAt(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0225, code lost:
    
        r14.f80ch = r4;
        skipObject(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01f5, code lost:
    
        skipString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01fa, code lost:
    
        if (r14.f80ch == ',') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01fe, code lost:
    
        if (r14.f80ch == '}') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0200, code lost:
    
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0205, code lost:
    
        if (r14.f80ch != ',') goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0207, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x017b, code lost:
    
        r3 = r14.text.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02b4, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illegal json, " + info());
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x00c5, code lost:
    
        if (r14.f80ch == ':') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x00c7, code lost:
    
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x00cc, code lost:
    
        if (r14.f80ch != ':') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x00ce, code lost:
    
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x00da, code lost:
    
        if (r15 < r14.text.length()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x00dc, code lost:
    
        r15 = 26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x00e4, code lost:
    
        r14.f80ch = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x00e8, code lost:
    
        if (r14.f80ch != ',') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00ea, code lost:
    
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x00f6, code lost:
    
        if (r15 < r14.text.length()) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x00f9, code lost:
    
        r4 = r14.text.charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x00ff, code lost:
    
        r14.f80ch = r4;
        r14.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0108, code lost:
    
        if (r14.f80ch != ']') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x010a, code lost:
    
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0116, code lost:
    
        if (r15 < r14.text.length()) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0119, code lost:
    
        r4 = r14.text.charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x011f, code lost:
    
        r14.f80ch = r4;
        r14.token = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0128, code lost:
    
        if (r14.f80ch != '}') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x012a, code lost:
    
        r15 = r14.f79bp + 1;
        r14.f79bp = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0136, code lost:
    
        if (r15 < r14.text.length()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0139, code lost:
    
        r4 = r14.text.charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x013f, code lost:
    
        r14.f80ch = r4;
        r14.token = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0148, code lost:
    
        if (r14.f80ch < '0') goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x014c, code lost:
    
        if (r14.f80ch > '9') goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x014e, code lost:
    
        r14.f82sp = 0;
        r14.pos = r14.f79bp;
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0158, code lost:
    
        nextToken(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x00de, code lost:
    
        r15 = r14.text.charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x015c, code lost:
    
        r14.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x015f, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x00b8, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
    
        if (r8 >= r15.length) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
    
        if (r6 != r15[r8]) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
    
        if (r8 == (-1)) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0162, code lost:
    
        if (r14.f80ch == ':') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0164, code lost:
    
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0169, code lost:
    
        if (r14.f80ch != ':') goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016b, code lost:
    
        r3 = r14.f79bp + 1;
        r14.f79bp = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0177, code lost:
    
        if (r3 < r14.text.length()) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0179, code lost:
    
        r3 = 26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0181, code lost:
    
        r14.f80ch = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x018d, code lost:
    
        if (r14.f80ch == '\"') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0193, code lost:
    
        if (r14.f80ch == '\'') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0197, code lost:
    
        if (r14.f80ch == '{') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x019b, code lost:
    
        if (r14.f80ch == '[') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x019f, code lost:
    
        if (r14.f80ch == '0') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01a5, code lost:
    
        if (r14.f80ch == '1') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ab, code lost:
    
        if (r14.f80ch == '2') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b1, code lost:
    
        if (r14.f80ch == '3') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b7, code lost:
    
        if (r14.f80ch == '4') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01bd, code lost:
    
        if (r14.f80ch == '5') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01c3, code lost:
    
        if (r14.f80ch == '6') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c9, code lost:
    
        if (r14.f80ch == '7') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01cf, code lost:
    
        if (r14.f80ch == '8') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01d3, code lost:
    
        if (r14.f80ch == '9') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d7, code lost:
    
        if (r14.f80ch == '+') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01db, code lost:
    
        if (r14.f80ch == '-') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01dd, code lost:
    
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e2, code lost:
    
        if (r14.f80ch == '-') goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e6, code lost:
    
        if (r14.f80ch == '+') goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ea, code lost:
    
        if (r14.f80ch < '0') goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ee, code lost:
    
        if (r14.f80ch > '9') goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x023e, code lost:
    
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0243, code lost:
    
        if (r14.f80ch < '0') goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0247, code lost:
    
        if (r14.f80ch > '9') goto L229;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int seekObjectToField(long[] r15) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.seekObjectToField(long[]):int");
    }
}