package com.wutka.dtd;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import java.util.Stack;
import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes3.dex */
class Scanner {
    protected boolean atEOF;
    protected Hashtable entityExpansion;
    protected char[] expandBuffer;
    protected int expandPos;
    protected EntityExpansion expander;
    protected StreamInfo in;
    protected Stack inputStreams;
    protected int nextChar;
    protected Token nextToken;
    protected boolean trace;
    public static final TokenType LTQUES = new TokenType(0, "LTQUES");
    public static final TokenType IDENTIFIER = new TokenType(1, "IDENTIFIER");
    public static final TokenType EQUAL = new TokenType(2, "EQUAL");
    public static final TokenType LPAREN = new TokenType(3, "LPAREN");
    public static final TokenType RPAREN = new TokenType(4, "RPAREN");
    public static final TokenType COMMA = new TokenType(5, "COMMA");
    public static final TokenType STRING = new TokenType(6, "STRING");
    public static final TokenType QUESGT = new TokenType(7, "QUESGT");
    public static final TokenType LTBANG = new TokenType(8, "LTBANG");
    public static final TokenType GT = new TokenType(9, "GT");
    public static final TokenType PIPE = new TokenType(10, "PIPE");
    public static final TokenType QUES = new TokenType(11, "QUES");
    public static final TokenType PLUS = new TokenType(12, "PLUS");
    public static final TokenType ASTERISK = new TokenType(13, "ASTERISK");
    public static final TokenType LT = new TokenType(14, "LT");
    public static final TokenType EOF = new TokenType(15, "EOF");
    public static final TokenType COMMENT = new TokenType(16, "COMMENT");
    public static final TokenType PERCENT = new TokenType(17, "PERCENT");
    public static final TokenType CONDITIONAL = new TokenType(18, "CONDITIONAL");
    public static final TokenType ENDCONDITIONAL = new TokenType(19, "ENDCONDITIONAL");
    public static final TokenType NMTOKEN = new TokenType(20, XmlErrorCodes.NMTOKEN);
    public static char[][] letterRanges = {new char[]{'A', 'Z'}, new char[]{'a', 'z'}, new char[]{192, 214}, new char[]{216, 246}, new char[]{248, 255}, new char[]{256, 305}, new char[]{308, 318}, new char[]{321, 328}, new char[]{330, 382}, new char[]{384, 451}, new char[]{461, 496}, new char[]{500, 501}, new char[]{506, 535}, new char[]{592, 680}, new char[]{699, 705}, new char[]{902, 902}, new char[]{904, 906}, new char[]{908, 908}, new char[]{910, 929}, new char[]{931, 974}, new char[]{976, 982}, new char[]{986, 986}, new char[]{988, 988}, new char[]{990, 990}, new char[]{992, 992}, new char[]{994, 1011}, new char[]{1025, 1036}, new char[]{1038, 1103}, new char[]{1105, 1116}, new char[]{1118, 1153}, new char[]{1168, 1220}, new char[]{1223, 1224}, new char[]{1227, 1228}, new char[]{1232, 1259}, new char[]{1262, 1269}, new char[]{1272, 1273}, new char[]{1329, 1366}, new char[]{1369, 1369}, new char[]{1377, 1414}, new char[]{1488, 1514}, new char[]{1520, 1522}, new char[]{1569, 1594}, new char[]{1601, 1610}, new char[]{1649, 1719}, new char[]{1722, 1726}, new char[]{1728, 1742}, new char[]{1744, 1747}, new char[]{1749, 1749}, new char[]{1765, 1766}, new char[]{2309, 2361}, new char[]{2365, 2365}, new char[]{2392, 2401}, new char[]{2437, 2444}, new char[]{2447, 2448}, new char[]{2451, 2472}, new char[]{2474, 2480}, new char[]{2482, 2482}, new char[]{2486, 2489}, new char[]{2524, 2525}, new char[]{2527, 2529}, new char[]{2544, 2545}, new char[]{2565, 2570}, new char[]{2575, 2576}, new char[]{2579, 2600}, new char[]{2602, 2608}, new char[]{2610, 2611}, new char[]{2613, 2614}, new char[]{2616, 2617}, new char[]{2649, 2652}, new char[]{2654, 2654}, new char[]{2674, 2676}, new char[]{2693, 2699}, new char[]{2701, 2701}, new char[]{2703, 2705}, new char[]{2707, 2728}, new char[]{2730, 2736}, new char[]{2738, 2739}, new char[]{2741, 2745}, new char[]{2749, 2749}, new char[]{2784, 2784}, new char[]{2821, 2828}, new char[]{2831, 2832}, new char[]{2835, 2856}, new char[]{2858, 2864}, new char[]{2866, 2867}, new char[]{2870, 2873}, new char[]{2877, 2877}, new char[]{2908, 2909}, new char[]{2911, 2913}, new char[]{2949, 2954}, new char[]{2958, 2960}, new char[]{2962, 2965}, new char[]{2969, 2970}, new char[]{2972, 2972}, new char[]{2974, 2975}, new char[]{2979, 2980}, new char[]{2984, 2986}, new char[]{2990, 2997}, new char[]{2999, 3001}, new char[]{3077, 3084}, new char[]{3086, 3088}, new char[]{3090, 3112}, new char[]{3114, 3123}, new char[]{3125, 3129}, new char[]{3168, 3169}, new char[]{3205, 3212}, new char[]{3214, 3216}, new char[]{3218, 3240}, new char[]{3242, 3251}, new char[]{3253, 3257}, new char[]{3294, 3294}, new char[]{3296, 3297}, new char[]{3333, 3340}, new char[]{3342, 3344}, new char[]{3346, 3368}, new char[]{3370, 3385}, new char[]{3424, 3425}, new char[]{3585, 3630}, new char[]{3632, 3632}, new char[]{3634, 3635}, new char[]{3648, 3653}, new char[]{3713, 3714}, new char[]{3716, 3716}, new char[]{3719, 3720}, new char[]{3722, 3722}, new char[]{3725, 3725}, new char[]{3732, 3735}, new char[]{3737, 3743}, new char[]{3745, 3747}, new char[]{3749, 3749}, new char[]{3751, 3751}, new char[]{3754, 3755}, new char[]{3757, 3758}, new char[]{3760, 3760}, new char[]{3762, 3763}, new char[]{3773, 3773}, new char[]{3776, 3780}, new char[]{3904, 3911}, new char[]{3913, 3945}, new char[]{4256, 4293}, new char[]{4304, 4342}, new char[]{4352, 4352}, new char[]{4354, 4355}, new char[]{4357, 4359}, new char[]{4361, 4361}, new char[]{4363, 4364}, new char[]{4366, 4370}, new char[]{4412, 4412}, new char[]{4414, 4414}, new char[]{4416, 4416}, new char[]{4428, 4428}, new char[]{4430, 4430}, new char[]{4432, 4432}, new char[]{4436, 4437}, new char[]{4441, 4441}, new char[]{4447, 4449}, new char[]{4451, 4451}, new char[]{4453, 4453}, new char[]{4455, 4455}, new char[]{4457, 4457}, new char[]{4461, 4462}, new char[]{4466, 4467}, new char[]{4469, 4469}, new char[]{4510, 4510}, new char[]{4520, 4520}, new char[]{4523, 4523}, new char[]{4526, 4527}, new char[]{4535, 4536}, new char[]{4538, 4538}, new char[]{4540, 4546}, new char[]{4587, 4587}, new char[]{4592, 4592}, new char[]{4601, 4601}, new char[]{7680, 7835}, new char[]{7840, 7929}, new char[]{7936, 7957}, new char[]{7960, 7965}, new char[]{7968, 8005}, new char[]{8008, 8013}, new char[]{8016, 8023}, new char[]{8025, 8025}, new char[]{8027, 8027}, new char[]{8029, 8029}, new char[]{8031, 8061}, new char[]{8064, 8116}, new char[]{8118, 8124}, new char[]{8126, 8126}, new char[]{8130, 8132}, new char[]{8134, 8140}, new char[]{8144, 8147}, new char[]{8150, 8155}, new char[]{8160, 8172}, new char[]{8178, 8180}, new char[]{8182, 8188}, new char[]{8486, 8486}, new char[]{8490, 8491}, new char[]{8494, 8494}, new char[]{8576, 8578}, new char[]{12353, 12436}, new char[]{12449, 12538}, new char[]{12549, 12588}, new char[]{44032, 55203}};

    public boolean isCombiningChar(char c) {
        if (c < 768) {
            return false;
        }
        if (c >= 768 && c <= 837) {
            return true;
        }
        if (c >= 864 && c <= 865) {
            return true;
        }
        if (c >= 1155 && c <= 1158) {
            return true;
        }
        if (c >= 1425 && c <= 1441) {
            return true;
        }
        if (c >= 1443 && c <= 1465) {
            return true;
        }
        if ((c >= 1467 && c <= 1469) || c == 1471) {
            return true;
        }
        if ((c >= 1473 && c <= 1474) || c == 1476) {
            return true;
        }
        if ((c >= 1611 && c <= 1618) || c == 1648) {
            return true;
        }
        if (c >= 1750 && c <= 1756) {
            return true;
        }
        if (c >= 1757 && c <= 1759) {
            return true;
        }
        if (c >= 1760 && c <= 1764) {
            return true;
        }
        if (c >= 1767 && c <= 1768) {
            return true;
        }
        if (c >= 1770 && c <= 1773) {
            return true;
        }
        if ((c >= 2305 && c <= 2307) || c == 2364) {
            return true;
        }
        if ((c >= 2366 && c <= 2380) || c == 2381) {
            return true;
        }
        if (c >= 2385 && c <= 2388) {
            return true;
        }
        if (c >= 2402 && c <= 2403) {
            return true;
        }
        if ((c >= 2433 && c <= 2435) || c == 2492 || c == 2494 || c == 2495) {
            return true;
        }
        if (c >= 2496 && c <= 2500) {
            return true;
        }
        if (c >= 2503 && c <= 2504) {
            return true;
        }
        if ((c >= 2507 && c <= 2509) || c == 2519) {
            return true;
        }
        if ((c >= 2530 && c <= 2531) || c == 2562 || c == 2620 || c == 2622 || c == 2623) {
            return true;
        }
        if (c >= 2624 && c <= 2626) {
            return true;
        }
        if (c >= 2631 && c <= 2632) {
            return true;
        }
        if (c >= 2635 && c <= 2637) {
            return true;
        }
        if (c >= 2672 && c <= 2673) {
            return true;
        }
        if ((c >= 2689 && c <= 2691) || c == 2748) {
            return true;
        }
        if (c >= 2750 && c <= 2757) {
            return true;
        }
        if (c >= 2759 && c <= 2761) {
            return true;
        }
        if (c >= 2763 && c <= 2765) {
            return true;
        }
        if ((c >= 2817 && c <= 2819) || c == 2876) {
            return true;
        }
        if (c >= 2878 && c <= 2883) {
            return true;
        }
        if (c >= 2887 && c <= 2888) {
            return true;
        }
        if (c >= 2891 && c <= 2893) {
            return true;
        }
        if (c >= 2902 && c <= 2903) {
            return true;
        }
        if (c >= 2946 && c <= 2947) {
            return true;
        }
        if (c >= 3006 && c <= 3010) {
            return true;
        }
        if (c >= 3014 && c <= 3016) {
            return true;
        }
        if ((c >= 3018 && c <= 3021) || c == 3031) {
            return true;
        }
        if (c >= 3073 && c <= 3075) {
            return true;
        }
        if (c >= 3134 && c <= 3140) {
            return true;
        }
        if (c >= 3142 && c <= 3144) {
            return true;
        }
        if (c >= 3146 && c <= 3149) {
            return true;
        }
        if (c >= 3157 && c <= 3158) {
            return true;
        }
        if (c >= 3202 && c <= 3203) {
            return true;
        }
        if (c >= 3262 && c <= 3268) {
            return true;
        }
        if (c >= 3270 && c <= 3272) {
            return true;
        }
        if (c >= 3274 && c <= 3277) {
            return true;
        }
        if (c >= 3285 && c <= 3286) {
            return true;
        }
        if (c >= 3330 && c <= 3331) {
            return true;
        }
        if (c >= 3390 && c <= 3395) {
            return true;
        }
        if (c >= 3398 && c <= 3400) {
            return true;
        }
        if ((c >= 3402 && c <= 3405) || c == 3415 || c == 3633) {
            return true;
        }
        if (c >= 3636 && c <= 3642) {
            return true;
        }
        if ((c >= 3655 && c <= 3662) || c == 3761) {
            return true;
        }
        if (c >= 3764 && c <= 3769) {
            return true;
        }
        if (c >= 3771 && c <= 3772) {
            return true;
        }
        if (c >= 3784 && c <= 3789) {
            return true;
        }
        if ((c >= 3864 && c <= 3865) || c == 3893 || c == 3895 || c == 3897 || c == 3902 || c == 3903) {
            return true;
        }
        if (c >= 3953 && c <= 3972) {
            return true;
        }
        if (c >= 3974 && c <= 3979) {
            return true;
        }
        if ((c >= 3984 && c <= 3989) || c == 3991) {
            return true;
        }
        if (c >= 3993 && c <= 4013) {
            return true;
        }
        if ((c >= 4017 && c <= 4023) || c == 4025) {
            return true;
        }
        if ((c < 8400 || c > 8412) && c != 8417) {
            return (c >= 12330 && c <= 12335) || c == 12441 || c == 12442;
        }
        return true;
    }

    public boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 1632) {
            return false;
        }
        if (c >= 1632 && c <= 1641) {
            return true;
        }
        if (c < 1776) {
            return false;
        }
        if (c >= 1776 && c <= 1785) {
            return true;
        }
        if (c < 2406) {
            return false;
        }
        if (c >= 2406 && c <= 2415) {
            return true;
        }
        if (c < 2534) {
            return false;
        }
        if (c >= 2534 && c <= 2543) {
            return true;
        }
        if (c < 2662) {
            return false;
        }
        if (c >= 2662 && c <= 2671) {
            return true;
        }
        if (c < 2790) {
            return false;
        }
        if (c >= 2790 && c <= 2799) {
            return true;
        }
        if (c < 2918) {
            return false;
        }
        if (c >= 2918 && c <= 2927) {
            return true;
        }
        if (c < 3047) {
            return false;
        }
        if (c >= 3047 && c <= 3055) {
            return true;
        }
        if (c < 3174) {
            return false;
        }
        if (c >= 3174 && c <= 3183) {
            return true;
        }
        if (c < 3302) {
            return false;
        }
        if (c >= 3302 && c <= 3311) {
            return true;
        }
        if (c < 3430) {
            return false;
        }
        if (c >= 3430 && c <= 3439) {
            return true;
        }
        if (c < 3664) {
            return false;
        }
        if (c >= 3664 && c <= 3673) {
            return true;
        }
        if (c < 3792) {
            return false;
        }
        if (c < 3792 || c > 3801) {
            return c >= 3872 && c >= 3872 && c <= 3881;
        }
        return true;
    }

    public boolean isExtender(char c) {
        if (c < 183) {
            return false;
        }
        if (c == 183 || c == 720 || c == 721 || c == 903 || c == 1600 || c == 3654) {
            return true;
        }
        if (c >= 12337 && c <= 12341) {
            return true;
        }
        if (c < 12445 || c > 12446) {
            return c >= 12540 && c <= 12542;
        }
        return true;
    }

    public boolean isIdeographic(char c) {
        if (c < 19968) {
            return false;
        }
        if ((c < 19968 || c > 40869) && c != 12295) {
            return c >= 12321 && c <= 12329;
        }
        return true;
    }

    protected class StreamInfo {
        String id;
        Reader in;
        int lineNumber = 1;
        int column = 1;

        StreamInfo(String str, Reader reader) {
            this.id = str;
            this.in = reader;
        }
    }

    public Scanner(Reader reader, EntityExpansion entityExpansion) {
        this(reader, false, entityExpansion);
    }

    public Scanner(Reader reader, boolean z, EntityExpansion entityExpansion) {
        this.in = new StreamInfo("", reader);
        this.atEOF = false;
        this.trace = z;
        this.expandBuffer = null;
        this.entityExpansion = new Hashtable();
        this.expander = entityExpansion;
    }

    public Token peek() throws IOException {
        if (this.nextToken == null) {
            this.nextToken = readNextToken();
        }
        return this.nextToken;
    }

    public Token get() throws IOException {
        if (this.nextToken == null) {
            this.nextToken = readNextToken();
        }
        Token token = this.nextToken;
        this.nextToken = null;
        return token;
    }

    protected int readNextChar() throws IOException {
        Stack stack;
        int read = this.in.in.read();
        if (read >= 0 || (stack = this.inputStreams) == null || stack.empty()) {
            return read;
        }
        this.in.in.close();
        this.in = (StreamInfo) this.inputStreams.pop();
        return readNextChar();
    }

    protected int peekChar() throws IOException {
        char[] cArr = this.expandBuffer;
        if (cArr != null) {
            return cArr[this.expandPos];
        }
        if (this.nextChar == 0) {
            this.nextChar = readNextChar();
            this.in.column++;
            if (this.nextChar == 10) {
                this.in.lineNumber++;
                this.in.column = 1;
            }
        }
        return this.nextChar;
    }

    protected int read() throws IOException {
        char[] cArr = this.expandBuffer;
        if (cArr != null) {
            int i = this.expandPos;
            int i2 = i + 1;
            this.expandPos = i2;
            char c = cArr[i];
            if (i2 >= cArr.length) {
                this.expandPos = -1;
                this.expandBuffer = null;
            }
            if (this.trace) {
                System.out.print(c);
            }
            return c;
        }
        if (this.nextChar == 0) {
            peekChar();
        }
        int i3 = this.nextChar;
        this.nextChar = 0;
        if (this.trace) {
            System.out.print((char) i3);
        }
        return i3;
    }

    public String getUntil(char c) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = read();
            if (read < 0) {
                return stringBuffer.toString();
            }
            if (read == c) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) read);
        }
    }

    public void skipUntil(char c) throws IOException {
        int read;
        do {
            read = read();
            if (read < 0) {
                return;
            }
        } while (read != c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x03a4, code lost:
    
        r1 = new java.lang.StringBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x03ad, code lost:
    
        if (peekChar() == r0) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03af, code lost:
    
        r2 = read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x03b5, code lost:
    
        if (r2 != 92) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03c0, code lost:
    
        if (r2 >= 0) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03c3, code lost:
    
        r1.append((char) r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03c8, code lost:
    
        read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03d6, code lost:
    
        return new com.wutka.dtd.Token(com.wutka.dtd.Scanner.STRING, r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03b7, code lost:
    
        r1.append((char) read());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.wutka.dtd.Token readNextToken() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 983
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wutka.dtd.Scanner.readNextToken():com.wutka.dtd.Token");
    }

    public void skipConditional() throws IOException {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i != 93) {
                i = read();
            }
            if (i == 93 && (i = read()) == 93 && (i = read()) == 62) {
                if (i2 == 0) {
                    return;
                } else {
                    i2--;
                }
            }
            if (i == 60 && (i = read()) == 33 && (i = read()) == 91) {
                i2++;
            }
        }
    }

    public String getUriId() {
        return this.in.id;
    }

    public int getLineNumber() {
        return this.in.lineNumber;
    }

    public int getColumn() {
        return this.in.column;
    }

    public boolean isIdentifierChar(char c) {
        return isLetter(c) || c == '_' || c == ':';
    }

    public boolean isNameChar(char c) {
        return isLetter(c) || isDigit(c) || c == '-' || c == '_' || c == '.' || c == ':' || isCombiningChar(c) || isExtender(c);
    }

    public boolean isLetter(char c) {
        return isBaseChar(c) || isIdeographic(c);
    }

    public boolean isBaseChar(char c) {
        int i = 0;
        while (true) {
            char[][] cArr = letterRanges;
            if (i >= cArr.length || c < cArr[i][0]) {
                return false;
            }
            if (c >= cArr[i][0] && c <= cArr[i][1]) {
                return true;
            }
            i++;
        }
    }

    public boolean expandEntity(String str) throws IOException {
        Reader reader;
        String str2 = (String) this.entityExpansion.get(str);
        if (str2 != null) {
            expand(str2.toCharArray());
            return true;
        }
        DTDEntity expandEntity = this.expander.expandEntity(str.substring(1, str.length() - 1));
        if (expandEntity == null || (reader = expandEntity.getReader()) == null) {
            return false;
        }
        if (this.inputStreams == null) {
            this.inputStreams = new Stack();
        }
        this.inputStreams.push(this.in);
        this.in = new StreamInfo(expandEntity.getExternalId(), reader);
        return true;
    }

    public void expand(char[] cArr) {
        char[] cArr2 = this.expandBuffer;
        if (cArr2 != null) {
            int length = cArr2.length - this.expandPos;
            char[] cArr3 = new char[cArr.length + length];
            System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
            System.arraycopy(this.expandBuffer, this.expandPos, cArr3, cArr.length, length);
            this.expandPos = 0;
            this.expandBuffer = cArr3;
            if (cArr3.length == 0) {
                this.expandBuffer = null;
                this.expandPos = -1;
                return;
            }
            return;
        }
        this.expandBuffer = cArr;
        this.expandPos = 0;
        if (cArr.length == 0) {
            this.expandBuffer = null;
            this.expandPos = -1;
        }
    }

    public void addEntity(String str, String str2) {
        this.entityExpansion.put(new StringBuffer().append("%").append(str).append(";").toString(), str2);
    }
}
