package org.apache.xmlbeans.impl.regex;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;
import okio.Utf8;
import org.apache.commons.text.StringSubstitutor;
import org.litepal.util.Const;

/* loaded from: classes5.dex */
class Token implements Serializable {
    static final int ANCHOR = 8;
    static final int BACKREFERENCE = 12;
    static final int CHAR = 0;
    static final int CHAR_FINAL_QUOTE = 30;
    static final int CHAR_INIT_QUOTE = 29;
    static final int CHAR_LETTER = 31;
    static final int CHAR_MARK = 32;
    static final int CHAR_NUMBER = 33;
    static final int CHAR_OTHER = 35;
    static final int CHAR_PUNCTUATION = 36;
    static final int CHAR_SEPARATOR = 34;
    static final int CHAR_SYMBOL = 37;
    static final int CLOSURE = 3;
    static final int CONCAT = 1;
    static final int CONDITION = 26;
    static final boolean COUNTTOKENS = true;
    static final int DOT = 11;
    static final int EMPTY = 7;
    static final int FC_ANY = 2;
    static final int FC_CONTINUE = 0;
    static final int FC_TERMINAL = 1;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIERGROUP = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    private static final int NONBMP_BLOCK_START = 84;
    static final int NONGREEDYCLOSURE = 9;
    static final int NRANGE = 5;
    static final int PAREN = 6;
    static final int RANGE = 4;
    static final int STRING = 10;
    static final int UNION = 2;
    static final int UTF16_MAX = 1114111;
    private static final String[] blockNames;
    static final String blockRanges = "\u0000\u007f\u0080ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ\u0530֏\u0590\u05ff\u0600ۿ܀ݏހ\u07bfऀॿঀ\u09ff\u0a00\u0a7f\u0a80૿\u0b00\u0b7f\u0b80\u0bffఀ౿ಀ\u0cffഀൿ\u0d80\u0dff\u0e00\u0e7f\u0e80\u0effༀ\u0fffက႟Ⴀჿᄀᇿሀ\u137fᎠ\u13ff᐀ᙿ\u1680\u169fᚠ\u16ffក\u17ff᠀\u18afḀỿἀ\u1fff\u2000\u206f⁰\u209f₠\u20cf⃐\u20ff℀⅏⅐\u218f←⇿∀⋿⌀⏿␀\u243f⑀\u245f①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀\u2eff⼀\u2fdf⿰⿿\u3000〿\u3040ゟ゠ヿ\u3100ㄯ\u3130\u318f㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ\ua48f꒐\ua4cf가힣\ue000\uf8ff豈\ufaffﬀﭏﭐ﷿︠︯︰﹏﹐\ufe6fﹰ\ufefe\ufeff\ufeff\uff00\uffef";
    private static final Hashtable categories;
    private static final Hashtable categories2;
    private static final String[] categoryNames;
    static final int[] nonBMPBlockRanges;
    static Hashtable nonxs = null;
    static Token token_0to9 = null;
    private static Token token_ccs = null;
    private static Token token_grapheme = null;
    static Token token_not_0to9 = null;
    static Token token_not_spaces = null;
    static Token token_not_wordchars = null;
    static Token token_spaces = null;
    static Token token_wordchars = null;
    static int tokens = 0;
    static final String viramaString = "्্੍્୍்్್്ฺ྄";
    int type;
    static Token token_empty = new Token(7);
    static Token token_linebeginning = createAnchor(94);
    static Token token_linebeginning2 = createAnchor(64);
    static Token token_lineend = createAnchor(36);
    static Token token_stringbeginning = createAnchor(65);
    static Token token_stringend = createAnchor(122);
    static Token token_stringend2 = createAnchor(90);
    static Token token_wordedge = createAnchor(98);
    static Token token_not_wordedge = createAnchor(66);
    static Token token_wordbeginning = createAnchor(60);
    static Token token_wordend = createAnchor(62);
    static Token token_dot = new Token(11);

    private static final boolean isSet(int i, int i2) {
        return (i & i2) == i2;
    }

    int getChar() {
        return -1;
    }

    Token getChild(int i) {
        return null;
    }

    int getMax() {
        return -1;
    }

    int getMin() {
        return -1;
    }

    int getParenNumber() {
        return 0;
    }

    int getReferenceNumber() {
        return 0;
    }

    String getString() {
        return null;
    }

    void setMax(int i) {
    }

    void setMin(int i) {
    }

    int size() {
        return 0;
    }

    static {
        RangeToken createRange = createRange();
        token_0to9 = createRange;
        createRange.addRange(48, 57);
        RangeToken createRange2 = createRange();
        token_wordchars = createRange2;
        createRange2.addRange(48, 57);
        token_wordchars.addRange(65, 90);
        token_wordchars.addRange(95, 95);
        token_wordchars.addRange(97, 122);
        RangeToken createRange3 = createRange();
        token_spaces = createRange3;
        createRange3.addRange(9, 9);
        token_spaces.addRange(10, 10);
        token_spaces.addRange(12, 12);
        token_spaces.addRange(13, 13);
        token_spaces.addRange(32, 32);
        token_not_0to9 = complementRanges(token_0to9);
        token_not_wordchars = complementRanges(token_wordchars);
        token_not_spaces = complementRanges(token_spaces);
        categories = new Hashtable();
        categories2 = new Hashtable();
        categoryNames = new String[]{"Cn", "Lu", "Ll", "Lt", "Lm", "Lo", "Mn", "Me", "Mc", "Nd", "Nl", "No", "Zs", "Zl", "Zp", "Cc", "Cf", null, "Co", "Cs", "Pd", "Ps", "Pe", "Pc", "Po", "Sm", "Sc", "Sk", "So", "Pi", "Pf", "L", "M", "N", "Z", "C", "P", "S"};
        blockNames = new String[]{"Basic Latin", "Latin-1 Supplement", "Latin Extended-A", "Latin Extended-B", "IPA Extensions", "Spacing Modifier Letters", "Combining Diacritical Marks", "Greek", "Cyrillic", "Armenian", "Hebrew", "Arabic", "Syriac", "Thaana", "Devanagari", "Bengali", "Gurmukhi", "Gujarati", "Oriya", "Tamil", "Telugu", "Kannada", "Malayalam", "Sinhala", "Thai", "Lao", "Tibetan", "Myanmar", "Georgian", "Hangul Jamo", "Ethiopic", "Cherokee", "Unified Canadian Aboriginal Syllabics", "Ogham", "Runic", "Khmer", "Mongolian", "Latin Extended Additional", "Greek Extended", "General Punctuation", "Superscripts and Subscripts", "Currency Symbols", "Combining Marks for Symbols", "Letterlike Symbols", "Number Forms", "Arrows", "Mathematical Operators", "Miscellaneous Technical", "Control Pictures", "Optical Character Recognition", "Enclosed Alphanumerics", "Box Drawing", "Block Elements", "Geometric Shapes", "Miscellaneous Symbols", "Dingbats", "Braille Patterns", "CJK Radicals Supplement", "Kangxi Radicals", "Ideographic Description Characters", "CJK Symbols and Punctuation", "Hiragana", "Katakana", "Bopomofo", "Hangul Compatibility Jamo", "Kanbun", "Bopomofo Extended", "Enclosed CJK Letters and Months", "CJK Compatibility", "CJK Unified Ideographs Extension A", "CJK Unified Ideographs", "Yi Syllables", "Yi Radicals", "Hangul Syllables", "Private Use", "CJK Compatibility Ideographs", "Alphabetic Presentation Forms", "Arabic Presentation Forms-A", "Combining Half Marks", "CJK Compatibility Forms", "Small Form Variants", "Arabic Presentation Forms-B", "Specials", "Halfwidth and Fullwidth Forms", "Old Italic", "Gothic", "Deseret", "Byzantine Musical Symbols", "Musical Symbols", "Mathematical Alphanumeric Symbols", "CJK Unified Ideographs Extension B", "CJK Compatibility Ideographs Supplement", "Tags"};
        nonBMPBlockRanges = new int[]{66304, 66351, 66352, 66383, 66560, 66639, 118784, 119039, 119040, 119295, 119808, 120831, 131072, 173782, 194560, 195103, 917504, 917631};
        nonxs = null;
        token_grapheme = null;
        token_ccs = null;
    }

    static ParenToken createLook(int i, Token token) {
        tokens++;
        return new ParenToken(i, token, 0);
    }

    static ParenToken createParen(Token token, int i) {
        tokens++;
        return new ParenToken(6, token, i);
    }

    static ClosureToken createClosure(Token token) {
        tokens++;
        return new ClosureToken(3, token);
    }

    static ClosureToken createNGClosure(Token token) {
        tokens++;
        return new ClosureToken(9, token);
    }

    static ConcatToken createConcat(Token token, Token token2) {
        tokens++;
        return new ConcatToken(token, token2);
    }

    static UnionToken createConcat() {
        tokens++;
        return new UnionToken(1);
    }

    static UnionToken createUnion() {
        tokens++;
        return new UnionToken(2);
    }

    static Token createEmpty() {
        return token_empty;
    }

    static RangeToken createRange() {
        tokens++;
        return new RangeToken(4);
    }

    static RangeToken createNRange() {
        tokens++;
        return new RangeToken(5);
    }

    static CharToken createChar(int i) {
        tokens++;
        return new CharToken(0, i);
    }

    private static CharToken createAnchor(int i) {
        tokens++;
        return new CharToken(8, i);
    }

    static StringToken createBackReference(int i) {
        tokens++;
        return new StringToken(12, null, i);
    }

    static StringToken createString(String str) {
        tokens++;
        return new StringToken(10, str, 0);
    }

    static ModifierToken createModifierGroup(Token token, int i, int i2) {
        tokens++;
        return new ModifierToken(token, i, i2);
    }

    static ConditionToken createCondition(int i, Token token, Token token2, Token token3) {
        tokens++;
        return new ConditionToken(i, token, token2, token3);
    }

    protected Token(int i) {
        this.type = i;
    }

    void addChild(Token token) {
        throw new RuntimeException("Not supported.");
    }

    protected void addRange(int i, int i2) {
        throw new RuntimeException("Not supported.");
    }

    protected void sortRanges() {
        throw new RuntimeException("Not supported.");
    }

    protected void compactRanges() {
        throw new RuntimeException("Not supported.");
    }

    protected void mergeRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    protected void subtractRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    protected void intersectRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    static Token complementRanges(Token token) {
        return RangeToken.complementRanges(token);
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i) {
        return this.type == 11 ? "." : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int getMinLength() {
        /*
            r3 = this;
            int r0 = r3.type
            r1 = 1
            r2 = 0
            switch(r0) {
                case 0: goto L86;
                case 1: goto L72;
                case 2: goto L4e;
                case 3: goto L39;
                case 4: goto L86;
                case 5: goto L86;
                case 6: goto L30;
                case 7: goto L2f;
                case 8: goto L2f;
                case 9: goto L39;
                case 10: goto L26;
                case 11: goto L86;
                case 12: goto L25;
                default: goto L7;
            }
        L7:
            switch(r0) {
                case 20: goto L25;
                case 21: goto L25;
                case 22: goto L25;
                case 23: goto L25;
                case 24: goto L30;
                case 25: goto L30;
                case 26: goto L4e;
                default: goto La;
            }
        La:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "Token#getMinLength(): Invalid Type: "
            java.lang.StringBuffer r1 = r1.append(r2)
            int r2 = r3.type
            java.lang.StringBuffer r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L25:
            return r2
        L26:
            java.lang.String r0 = r3.getString()
            int r0 = r0.length()
            return r0
        L2f:
            return r2
        L30:
            org.apache.xmlbeans.impl.regex.Token r0 = r3.getChild(r2)
            int r0 = r0.getMinLength()
            return r0
        L39:
            int r0 = r3.getMin()
            if (r0 < 0) goto L4d
            int r0 = r3.getMin()
            org.apache.xmlbeans.impl.regex.Token r1 = r3.getChild(r2)
            int r1 = r1.getMinLength()
            int r0 = r0 * r1
            return r0
        L4d:
            return r2
        L4e:
            int r0 = r3.size()
            if (r0 != 0) goto L55
            return r2
        L55:
            org.apache.xmlbeans.impl.regex.Token r0 = r3.getChild(r2)
            int r0 = r0.getMinLength()
        L5d:
            int r2 = r3.size()
            if (r1 >= r2) goto L71
            org.apache.xmlbeans.impl.regex.Token r2 = r3.getChild(r1)
            int r2 = r2.getMinLength()
            if (r2 >= r0) goto L6e
            r0 = r2
        L6e:
            int r1 = r1 + 1
            goto L5d
        L71:
            return r0
        L72:
            r0 = r2
        L73:
            int r1 = r3.size()
            if (r2 >= r1) goto L85
            org.apache.xmlbeans.impl.regex.Token r1 = r3.getChild(r2)
            int r1 = r1.getMinLength()
            int r0 = r0 + r1
            int r2 = r2 + 1
            goto L73
        L85:
            return r0
        L86:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.Token.getMinLength():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int getMaxLength() {
        /*
            r4 = this;
            int r0 = r4.type
            r1 = -1
            r2 = 1
            r3 = 0
            switch(r0) {
                case 0: goto L93;
                case 1: goto L7c;
                case 2: goto L52;
                case 3: goto L3d;
                case 4: goto L3b;
                case 5: goto L3b;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L31;
                case 9: goto L3d;
                case 10: goto L28;
                case 11: goto L3b;
                case 12: goto L27;
                default: goto L8;
            }
        L8:
            switch(r0) {
                case 20: goto L26;
                case 21: goto L26;
                case 22: goto L26;
                case 23: goto L26;
                case 24: goto L32;
                case 25: goto L32;
                case 26: goto L52;
                default: goto Lb;
            }
        Lb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "Token#getMaxLength(): Invalid Type: "
            java.lang.StringBuffer r1 = r1.append(r2)
            int r2 = r4.type
            java.lang.StringBuffer r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L26:
            return r3
        L27:
            return r1
        L28:
            java.lang.String r0 = r4.getString()
            int r0 = r0.length()
            return r0
        L31:
            return r3
        L32:
            org.apache.xmlbeans.impl.regex.Token r0 = r4.getChild(r3)
            int r0 = r0.getMaxLength()
            return r0
        L3b:
            r0 = 2
            return r0
        L3d:
            int r0 = r4.getMax()
            if (r0 < 0) goto L51
            int r0 = r4.getMax()
            org.apache.xmlbeans.impl.regex.Token r1 = r4.getChild(r3)
            int r1 = r1.getMaxLength()
            int r0 = r0 * r1
            return r0
        L51:
            return r1
        L52:
            int r0 = r4.size()
            if (r0 != 0) goto L59
            return r3
        L59:
            org.apache.xmlbeans.impl.regex.Token r0 = r4.getChild(r3)
            int r0 = r0.getMaxLength()
        L61:
            if (r0 < 0) goto L7a
            int r3 = r4.size()
            if (r2 >= r3) goto L7a
            org.apache.xmlbeans.impl.regex.Token r3 = r4.getChild(r2)
            int r3 = r3.getMaxLength()
            if (r3 >= 0) goto L74
            goto L7b
        L74:
            if (r3 <= r0) goto L77
            r0 = r3
        L77:
            int r2 = r2 + 1
            goto L61
        L7a:
            r1 = r0
        L7b:
            return r1
        L7c:
            r0 = r3
        L7d:
            int r2 = r4.size()
            if (r3 >= r2) goto L92
            org.apache.xmlbeans.impl.regex.Token r2 = r4.getChild(r3)
            int r2 = r2.getMaxLength()
            if (r2 >= 0) goto L8e
            return r1
        L8e:
            int r0 = r0 + r2
            int r3 = r3 + 1
            goto L7d
        L92:
            return r0
        L93:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.Token.getMaxLength():int");
    }

    final int analyzeFirstCharacter(RangeToken rangeToken, int i) {
        int i2 = this.type;
        switch (i2) {
            case 0:
                int i3 = getChar();
                rangeToken.addRange(i3, i3);
                if (i3 < 65536 && isSet(i, 2)) {
                    char upperCase = Character.toUpperCase((char) i3);
                    rangeToken.addRange(upperCase, upperCase);
                    char lowerCase = Character.toLowerCase(upperCase);
                    rangeToken.addRange(lowerCase, lowerCase);
                }
                return 1;
            case 1:
                int i4 = 0;
                for (int i5 = 0; i5 < size() && (i4 = getChild(i5).analyzeFirstCharacter(rangeToken, i)) == 0; i5++) {
                }
                return i4;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int i6 = 0;
                boolean z = false;
                for (int i7 = 0; i7 < size() && (i6 = getChild(i7).analyzeFirstCharacter(rangeToken, i)) != 2; i7++) {
                    if (i6 == 0) {
                        z = true;
                    }
                }
                if (z) {
                    return 0;
                }
                return i6;
            case 3:
            case 9:
                getChild(0).analyzeFirstCharacter(rangeToken, i);
                return 0;
            case 4:
                if (isSet(i, 2)) {
                    rangeToken.mergeRanges(((RangeToken) this).getCaseInsensitiveToken());
                } else {
                    rangeToken.mergeRanges(this);
                }
                return 1;
            case 5:
                if (isSet(i, 2)) {
                    rangeToken.mergeRanges(complementRanges(((RangeToken) this).getCaseInsensitiveToken()));
                } else {
                    rangeToken.mergeRanges(complementRanges(this));
                }
                return 1;
            case 6:
                break;
            case 7:
            case 8:
                return 0;
            case 10:
                int charAt = getString().charAt(0);
                if (REUtil.isHighSurrogate(charAt) && getString().length() >= 2) {
                    char charAt2 = getString().charAt(1);
                    if (REUtil.isLowSurrogate(charAt2)) {
                        charAt = REUtil.composeFromSurrogates(charAt, charAt2);
                    }
                }
                rangeToken.addRange(charAt, charAt);
                if (charAt < 65536 && isSet(i, 2)) {
                    char upperCase2 = Character.toUpperCase((char) charAt);
                    rangeToken.addRange(upperCase2, upperCase2);
                    char lowerCase2 = Character.toLowerCase(upperCase2);
                    rangeToken.addRange(lowerCase2, lowerCase2);
                }
                return 1;
            case 11:
                if (isSet(i, 4)) {
                }
                return 0;
            case 12:
                rangeToken.addRange(0, 1114111);
                return 2;
            default:
                switch (i2) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                        break;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        return getChild(0).analyzeFirstCharacter(rangeToken, (i | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                    case 26:
                        int analyzeFirstCharacter = getChild(0).analyzeFirstCharacter(rangeToken, i);
                        if (size() == 1) {
                            return 0;
                        }
                        if (analyzeFirstCharacter == 2) {
                            return analyzeFirstCharacter;
                        }
                        int analyzeFirstCharacter2 = getChild(1).analyzeFirstCharacter(rangeToken, i);
                        return analyzeFirstCharacter2 == 2 ? analyzeFirstCharacter2 : (analyzeFirstCharacter == 0 || analyzeFirstCharacter2 == 0) ? 0 : 1;
                    default:
                        throw new RuntimeException(new StringBuffer().append("Token#analyzeHeadCharacter(): Invalid Type: ").append(this.type).toString());
                }
        }
        return getChild(0).analyzeFirstCharacter(rangeToken, i);
    }

    private final boolean isShorterThan(Token token) {
        if (token == null) {
            return false;
        }
        if (this.type != 10) {
            throw new RuntimeException(new StringBuffer().append("Internal Error: Illegal type: ").append(this.type).toString());
        }
        int length = getString().length();
        if (token.type == 10) {
            return length < token.getString().length();
        }
        throw new RuntimeException(new StringBuffer().append("Internal Error: Illegal type: ").append(token.type).toString());
    }

    static class FixedStringContainer {
        Token token = null;
        int options = 0;

        FixedStringContainer() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void findFixedString(org.apache.xmlbeans.impl.regex.Token.FixedStringContainer r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.type
            r1 = 0
            r2 = 0
            switch(r0) {
                case 0: goto L72;
                case 1: goto L4b;
                case 2: goto L48;
                case 3: goto L48;
                case 4: goto L48;
                case 5: goto L48;
                case 6: goto L40;
                case 7: goto L48;
                case 8: goto L48;
                case 9: goto L48;
                case 10: goto L3b;
                case 11: goto L48;
                case 12: goto L48;
                default: goto L7;
            }
        L7:
            switch(r0) {
                case 20: goto L48;
                case 21: goto L48;
                case 22: goto L48;
                case 23: goto L48;
                case 24: goto L40;
                case 25: goto L25;
                case 26: goto L48;
                default: goto La;
            }
        La:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            java.lang.String r0 = "Token#findFixedString(): Invalid Type: "
            java.lang.StringBuffer r7 = r7.append(r0)
            int r0 = r5.type
            java.lang.StringBuffer r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L25:
            r0 = r5
            org.apache.xmlbeans.impl.regex.Token$ModifierToken r0 = (org.apache.xmlbeans.impl.regex.Token.ModifierToken) r0
            int r1 = r0.getOptions()
            r7 = r7 | r1
            int r0 = r0.getOptionsMask()
            int r0 = ~r0
            r7 = r7 & r0
            org.apache.xmlbeans.impl.regex.Token r0 = r5.getChild(r2)
            r0.findFixedString(r6, r7)
            return
        L3b:
            r6.token = r5
            r6.options = r7
            return
        L40:
            org.apache.xmlbeans.impl.regex.Token r0 = r5.getChild(r2)
            r0.findFixedString(r6, r7)
            return
        L48:
            r6.token = r1
            return
        L4b:
            r0 = r2
        L4c:
            int r3 = r5.size()
            if (r2 >= r3) goto L6d
            org.apache.xmlbeans.impl.regex.Token r3 = r5.getChild(r2)
            r3.findFixedString(r6, r7)
            if (r1 == 0) goto L63
            org.apache.xmlbeans.impl.regex.Token r3 = r6.token
            boolean r3 = r1.isShorterThan(r3)
            if (r3 == 0) goto L6a
        L63:
            org.apache.xmlbeans.impl.regex.Token r0 = r6.token
            int r1 = r6.options
            r4 = r1
            r1 = r0
            r0 = r4
        L6a:
            int r2 = r2 + 1
            goto L4c
        L6d:
            r6.token = r1
            r6.options = r0
            return
        L72:
            r6.token = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.Token.findFixedString(org.apache.xmlbeans.impl.regex.Token$FixedStringContainer, int):void");
    }

    boolean match(int i) {
        throw new RuntimeException(new StringBuffer().append("NFAArrow#match(): Internal error: ").append(this.type).toString());
    }

    protected static RangeToken getRange(String str, boolean z) {
        Hashtable hashtable = categories;
        if (hashtable.size() == 0) {
            synchronized (hashtable) {
                int length = categoryNames.length;
                Token[] tokenArr = new Token[length];
                for (int i = 0; i < length; i++) {
                    tokenArr[i] = createRange();
                }
                int i2 = 0;
                while (true) {
                    char c = '\"';
                    if (i2 < 65536) {
                        int type = Character.getType((char) i2);
                        if (type == 21 || type == 22) {
                            if (i2 == 171 || i2 == 8216 || i2 == 8219 || i2 == 8220 || i2 == 8223 || i2 == 8249) {
                                type = 29;
                            }
                            if (i2 == 187 || i2 == 8217 || i2 == 8221 || i2 == 8250) {
                                type = 30;
                            }
                        }
                        tokenArr[type].addRange(i2, i2);
                        switch (type) {
                            case 0:
                            case 15:
                            case 16:
                            case 18:
                            case 19:
                                c = '#';
                                break;
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                c = 31;
                                break;
                            case 6:
                            case 7:
                            case 8:
                                c = ' ';
                                break;
                            case 9:
                            case 10:
                            case 11:
                                c = '!';
                                break;
                            case 12:
                            case 13:
                            case 14:
                                break;
                            case 17:
                            default:
                                throw new RuntimeException(new StringBuffer().append("org.apache.xerces.utils.regex.Token#getRange(): Unknown Unicode category: ").append(type).toString());
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 29:
                            case 30:
                                c = '$';
                                break;
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                                c = '%';
                                break;
                        }
                        tokenArr[c].addRange(i2, i2);
                        i2++;
                    } else {
                        tokenArr[0].addRange(65536, 1114111);
                        for (int i3 = 0; i3 < length; i3++) {
                            String[] strArr = categoryNames;
                            if (strArr[i3] != null) {
                                if (i3 == 0) {
                                    tokenArr[i3].addRange(65536, 1114111);
                                }
                                categories.put(strArr[i3], tokenArr[i3]);
                                categories2.put(strArr[i3], complementRanges(tokenArr[i3]));
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer(50);
                        int i4 = 0;
                        while (true) {
                            String[] strArr2 = blockNames;
                            if (i4 < strArr2.length) {
                                RangeToken createRange = createRange();
                                if (i4 < 84) {
                                    int i5 = i4 * 2;
                                    createRange.addRange(blockRanges.charAt(i5), blockRanges.charAt(i5 + 1));
                                } else {
                                    int i6 = (i4 - 84) * 2;
                                    int[] iArr = nonBMPBlockRanges;
                                    createRange.addRange(iArr[i6], iArr[i6 + 1]);
                                }
                                String str2 = strArr2[i4];
                                if (str2.equals("Specials")) {
                                    createRange.addRange(65520, Utf8.REPLACEMENT_CODE_POINT);
                                }
                                if (str2.equals("Private Use")) {
                                    createRange.addRange(983040, 1048573);
                                    createRange.addRange(1048576, 1114109);
                                }
                                categories.put(str2, createRange);
                                categories2.put(str2, complementRanges(createRange));
                                stringBuffer.setLength(0);
                                stringBuffer.append("Is");
                                if (str2.indexOf(32) >= 0) {
                                    for (int i7 = 0; i7 < str2.length(); i7++) {
                                        if (str2.charAt(i7) != ' ') {
                                            stringBuffer.append(str2.charAt(i7));
                                        }
                                    }
                                } else {
                                    stringBuffer.append(str2);
                                }
                                setAlias(stringBuffer.toString(), str2, true);
                                i4++;
                            } else {
                                setAlias("ASSIGNED", "Cn", false);
                                setAlias("UNASSIGNED", "Cn", true);
                                RangeToken createRange2 = createRange();
                                createRange2.addRange(0, 1114111);
                                Hashtable hashtable2 = categories;
                                hashtable2.put("ALL", createRange2);
                                Hashtable hashtable3 = categories2;
                                hashtable3.put("ALL", complementRanges(createRange2));
                                registerNonXS("ASSIGNED");
                                registerNonXS("UNASSIGNED");
                                registerNonXS("ALL");
                                RangeToken createRange3 = createRange();
                                createRange3.mergeRanges(tokenArr[1]);
                                createRange3.mergeRanges(tokenArr[2]);
                                createRange3.mergeRanges(tokenArr[5]);
                                hashtable2.put("IsAlpha", createRange3);
                                hashtable3.put("IsAlpha", complementRanges(createRange3));
                                registerNonXS("IsAlpha");
                                RangeToken createRange4 = createRange();
                                createRange4.mergeRanges(createRange3);
                                createRange4.mergeRanges(tokenArr[9]);
                                hashtable2.put("IsAlnum", createRange4);
                                hashtable3.put("IsAlnum", complementRanges(createRange4));
                                registerNonXS("IsAlnum");
                                RangeToken createRange5 = createRange();
                                createRange5.mergeRanges(token_spaces);
                                createRange5.mergeRanges(tokenArr[34]);
                                hashtable2.put("IsSpace", createRange5);
                                hashtable3.put("IsSpace", complementRanges(createRange5));
                                registerNonXS("IsSpace");
                                RangeToken createRange6 = createRange();
                                createRange6.mergeRanges(createRange4);
                                createRange6.addRange(95, 95);
                                hashtable2.put("IsWord", createRange6);
                                hashtable3.put("IsWord", complementRanges(createRange6));
                                registerNonXS("IsWord");
                                RangeToken createRange7 = createRange();
                                createRange7.addRange(0, 127);
                                hashtable2.put("IsASCII", createRange7);
                                hashtable3.put("IsASCII", complementRanges(createRange7));
                                registerNonXS("IsASCII");
                                RangeToken createRange8 = createRange();
                                createRange8.mergeRanges(tokenArr[35]);
                                createRange8.addRange(32, 32);
                                hashtable2.put("IsGraph", complementRanges(createRange8));
                                hashtable3.put("IsGraph", createRange8);
                                registerNonXS("IsGraph");
                                RangeToken createRange9 = createRange();
                                createRange9.addRange(48, 57);
                                createRange9.addRange(65, 70);
                                createRange9.addRange(97, 102);
                                hashtable2.put("IsXDigit", complementRanges(createRange9));
                                hashtable3.put("IsXDigit", createRange9);
                                registerNonXS("IsXDigit");
                                setAlias("IsDigit", "Nd", true);
                                setAlias("IsUpper", "Lu", true);
                                setAlias("IsLower", "Ll", true);
                                setAlias("IsCntrl", "C", true);
                                setAlias("IsPrint", "C", false);
                                setAlias("IsPunct", "P", true);
                                registerNonXS("IsDigit");
                                registerNonXS("IsUpper");
                                registerNonXS("IsLower");
                                registerNonXS("IsCntrl");
                                registerNonXS("IsPrint");
                                registerNonXS("IsPunct");
                                setAlias("alpha", "IsAlpha", true);
                                setAlias("alnum", "IsAlnum", true);
                                setAlias("ascii", "IsASCII", true);
                                setAlias("cntrl", "IsCntrl", true);
                                setAlias("digit", "IsDigit", true);
                                setAlias("graph", "IsGraph", true);
                                setAlias(Const.Config.CASES_LOWER, "IsLower", true);
                                setAlias("print", "IsPrint", true);
                                setAlias("punct", "IsPunct", true);
                                setAlias("space", "IsSpace", true);
                                setAlias(Const.Config.CASES_UPPER, "IsUpper", true);
                                setAlias("word", "IsWord", true);
                                setAlias("xdigit", "IsXDigit", true);
                                registerNonXS("alpha");
                                registerNonXS("alnum");
                                registerNonXS("ascii");
                                registerNonXS("cntrl");
                                registerNonXS("digit");
                                registerNonXS("graph");
                                registerNonXS(Const.Config.CASES_LOWER);
                                registerNonXS("print");
                                registerNonXS("punct");
                                registerNonXS("space");
                                registerNonXS(Const.Config.CASES_UPPER);
                                registerNonXS("word");
                                registerNonXS("xdigit");
                            }
                        }
                    }
                }
            }
        }
        return (RangeToken) (z ? categories : categories2).get(str);
    }

    protected static RangeToken getRange(String str, boolean z, boolean z2) {
        RangeToken range = getRange(str, z);
        if (z2 && range != null && isRegisterNonXS(str)) {
            return null;
        }
        return range;
    }

    protected static void registerNonXS(String str) {
        if (nonxs == null) {
            nonxs = new Hashtable();
        }
        nonxs.put(str, str);
    }

    protected static boolean isRegisterNonXS(String str) {
        Hashtable hashtable = nonxs;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }

    private static void setAlias(String str, String str2, boolean z) {
        Hashtable hashtable = categories;
        Token token = (Token) hashtable.get(str2);
        Hashtable hashtable2 = categories2;
        Token token2 = (Token) hashtable2.get(str2);
        if (z) {
            hashtable.put(str, token);
            hashtable2.put(str, token2);
        } else {
            hashtable2.put(str, token);
            hashtable.put(str, token2);
        }
    }

    static synchronized Token getGraphemePattern() {
        synchronized (Token.class) {
            Token token = token_grapheme;
            if (token != null) {
                return token;
            }
            RangeToken createRange = createRange();
            createRange.mergeRanges(getRange("ASSIGNED", true));
            createRange.subtractRanges(getRange("M", true));
            createRange.subtractRanges(getRange("C", true));
            RangeToken createRange2 = createRange();
            for (int i = 0; i < 11; i++) {
                viramaString.charAt(i);
                createRange2.addRange(i, i);
            }
            RangeToken createRange3 = createRange();
            createRange3.mergeRanges(getRange("M", true));
            createRange3.addRange(4448, 4607);
            createRange3.addRange(65438, 65439);
            UnionToken createUnion = createUnion();
            createUnion.addChild(createRange);
            createUnion.addChild(token_empty);
            UnionToken createUnion2 = createUnion();
            createUnion2.addChild(createConcat(createRange2, getRange("L", true)));
            createUnion2.addChild(createRange3);
            ConcatToken createConcat = createConcat(createUnion, createClosure(createUnion2));
            token_grapheme = createConcat;
            return createConcat;
        }
    }

    static synchronized Token getCombiningCharacterSequence() {
        synchronized (Token.class) {
            Token token = token_ccs;
            if (token != null) {
                return token;
            }
            ConcatToken createConcat = createConcat(getRange("M", false), createClosure(getRange("M", true)));
            token_ccs = createConcat;
            return createConcat;
        }
    }

    static class StringToken extends Token implements Serializable {
        int refNumber;
        String string;

        StringToken(int i, String str, int i2) {
            super(i);
            this.string = str;
            this.refNumber = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getReferenceNumber() {
            return this.refNumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        String getString() {
            return this.string;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type == 12) {
                return new StringBuffer().append("\\").append(this.refNumber).toString();
            }
            return REUtil.quoteMeta(this.string);
        }
    }

    static class ConcatToken extends Token implements Serializable {
        Token child;
        Token child2;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 2;
        }

        ConcatToken(Token token, Token token2) {
            super(1);
            this.child = token;
            this.child2 = token2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return i == 0 ? this.child : this.child2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.child2.type == 3 && this.child2.getChild(0) == this.child) {
                return new StringBuffer().append(this.child.toString(i)).append("+").toString();
            }
            if (this.child2.type == 9 && this.child2.getChild(0) == this.child) {
                return new StringBuffer().append(this.child.toString(i)).append("+?").toString();
            }
            return new StringBuffer().append(this.child.toString(i)).append(this.child2.toString(i)).toString();
        }
    }

    static class CharToken extends Token implements Serializable {
        int chardata;

        CharToken(int i, int i2) {
            super(i);
            this.chardata = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getChar() {
            return this.chardata;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            int i2 = this.type;
            if (i2 != 0) {
                if (i2 != 8) {
                    return null;
                }
                if (this == Token.token_linebeginning || this == Token.token_lineend) {
                    return new StringBuffer().append("").append((char) this.chardata).toString();
                }
                return new StringBuffer().append("\\").append((char) this.chardata).toString();
            }
            int i3 = this.chardata;
            if (i3 == 9) {
                return "\\t";
            }
            if (i3 == 10) {
                return "\\n";
            }
            if (i3 == 12) {
                return "\\f";
            }
            if (i3 == 13) {
                return "\\r";
            }
            if (i3 == 27) {
                return "\\e";
            }
            if (i3 != 46 && i3 != 63 && i3 != 91 && i3 != 92 && i3 != 123 && i3 != 124) {
                switch (i3) {
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        break;
                    default:
                        if (i3 >= 65536) {
                            String stringBuffer = new StringBuffer().append(SessionDescription.SUPPORTED_SDP_VERSION).append(Integer.toHexString(this.chardata)).toString();
                            return new StringBuffer().append("\\v").append(stringBuffer.substring(stringBuffer.length() - 6, stringBuffer.length())).toString();
                        }
                        return new StringBuffer().append("").append((char) this.chardata).toString();
                }
            }
            return new StringBuffer().append("\\").append((char) this.chardata).toString();
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        boolean match(int i) {
            if (this.type == 0) {
                return i == this.chardata;
            }
            throw new RuntimeException(new StringBuffer().append("NFAArrow#match(): Internal error: ").append(this.type).toString());
        }
    }

    static class ClosureToken extends Token implements Serializable {
        Token child;
        int max;
        int min;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        ClosureToken(int i, Token token) {
            super(i);
            this.child = token;
            setMin(-1);
            setMax(-1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMin(int i) {
            this.min = i;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMax(int i) {
            this.max = i;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMin() {
            return this.min;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMax() {
            return this.max;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type == 3) {
                if (getMin() < 0 && getMax() < 0) {
                    return new StringBuffer().append(this.child.toString(i)).append(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD).toString();
                }
                if (getMin() == getMax()) {
                    return new StringBuffer().append(this.child.toString(i)).append("{").append(getMin()).append(StringSubstitutor.DEFAULT_VAR_END).toString();
                }
                if (getMin() >= 0 && getMax() >= 0) {
                    return new StringBuffer().append(this.child.toString(i)).append("{").append(getMin()).append(",").append(getMax()).append(StringSubstitutor.DEFAULT_VAR_END).toString();
                }
                if (getMin() >= 0 && getMax() < 0) {
                    return new StringBuffer().append(this.child.toString(i)).append("{").append(getMin()).append(",}").toString();
                }
                throw new RuntimeException(new StringBuffer().append("Token#toString(): CLOSURE ").append(getMin()).append(", ").append(getMax()).toString());
            }
            if (getMin() < 0 && getMax() < 0) {
                return new StringBuffer().append(this.child.toString(i)).append("*?").toString();
            }
            if (getMin() == getMax()) {
                return new StringBuffer().append(this.child.toString(i)).append("{").append(getMin()).append("}?").toString();
            }
            if (getMin() >= 0 && getMax() >= 0) {
                return new StringBuffer().append(this.child.toString(i)).append("{").append(getMin()).append(",").append(getMax()).append("}?").toString();
            }
            if (getMin() >= 0 && getMax() < 0) {
                return new StringBuffer().append(this.child.toString(i)).append("{").append(getMin()).append(",}?").toString();
            }
            throw new RuntimeException(new StringBuffer().append("Token#toString(): NONGREEDYCLOSURE ").append(getMin()).append(", ").append(getMax()).toString());
        }
    }

    static class ParenToken extends Token implements Serializable {
        Token child;
        int parennumber;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        ParenToken(int i, Token token, int i2) {
            super(i);
            this.child = token;
            this.parennumber = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getParenNumber() {
            return this.parennumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            int i2 = this.type;
            if (i2 == 6) {
                if (this.parennumber == 0) {
                    return new StringBuffer().append("(?:").append(this.child.toString(i)).append(")").toString();
                }
                return new StringBuffer().append("(").append(this.child.toString(i)).append(")").toString();
            }
            switch (i2) {
                case 20:
                    return new StringBuffer().append("(?=").append(this.child.toString(i)).append(")").toString();
                case 21:
                    return new StringBuffer().append("(?!").append(this.child.toString(i)).append(")").toString();
                case 22:
                    return new StringBuffer().append("(?<=").append(this.child.toString(i)).append(")").toString();
                case 23:
                    return new StringBuffer().append("(?<!").append(this.child.toString(i)).append(")").toString();
                case 24:
                    return new StringBuffer().append("(?>").append(this.child.toString(i)).append(")").toString();
                default:
                    return null;
            }
        }
    }

    static class ConditionToken extends Token implements Serializable {
        Token condition;
        Token no;
        int refNumber;
        Token yes;

        ConditionToken(int i, Token token, Token token2, Token token3) {
            super(26);
            this.refNumber = i;
            this.condition = token;
            this.yes = token2;
            this.no = token3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return this.no == null ? 1 : 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            if (i == 0) {
                return this.yes;
            }
            if (i == 1) {
                return this.no;
            }
            throw new RuntimeException(new StringBuffer().append("Internal Error: ").append(i).toString());
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            String stringBuffer;
            if (this.refNumber > 0) {
                stringBuffer = new StringBuffer().append("(?(").append(this.refNumber).append(")").toString();
            } else if (this.condition.type == 8) {
                stringBuffer = new StringBuffer().append("(?(").append(this.condition).append(")").toString();
            } else {
                stringBuffer = new StringBuffer().append("(?").append(this.condition).toString();
            }
            if (this.no == null) {
                return new StringBuffer().append(stringBuffer).append(this.yes).append(")").toString();
            }
            return new StringBuffer().append(stringBuffer).append(this.yes).append("|").append(this.no).append(")").toString();
        }
    }

    static class ModifierToken extends Token implements Serializable {
        int add;
        Token child;
        int mask;

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        ModifierToken(Token token, int i, int i2) {
            super(25);
            this.child = token;
            this.add = i;
            this.mask = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return this.child;
        }

        int getOptions() {
            return this.add;
        }

        int getOptionsMask() {
            return this.mask;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            StringBuffer append = new StringBuffer().append("(?");
            int i2 = this.add;
            StringBuffer append2 = append.append(i2 == 0 ? "" : REUtil.createOptionString(i2));
            int i3 = this.mask;
            return append2.append(i3 != 0 ? REUtil.createOptionString(i3) : "").append(":").append(this.child.toString(i)).append(")").toString();
        }
    }

    static class UnionToken extends Token implements Serializable {
        Vector children;

        UnionToken(int i) {
            super(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        void addChild(Token token) {
            StringBuffer stringBuffer;
            if (token == null) {
                return;
            }
            if (this.children == null) {
                this.children = new Vector();
            }
            if (this.type == 2) {
                this.children.addElement(token);
                return;
            }
            if (token.type == 1) {
                for (int i = 0; i < token.size(); i++) {
                    addChild(token.getChild(i));
                }
                return;
            }
            int size = this.children.size();
            if (size == 0) {
                this.children.addElement(token);
                return;
            }
            int i2 = size - 1;
            Token token2 = (Token) this.children.elementAt(i2);
            if ((token2.type != 0 && token2.type != 10) || (token.type != 0 && token.type != 10)) {
                this.children.addElement(token);
                return;
            }
            int length = token.type == 0 ? 2 : token.getString().length();
            if (token2.type == 0) {
                stringBuffer = new StringBuffer(length + 2);
                int i3 = token2.getChar();
                if (i3 >= 65536) {
                    stringBuffer.append(REUtil.decomposeToSurrogates(i3));
                } else {
                    stringBuffer.append((char) i3);
                }
                token2 = Token.createString(null);
                this.children.setElementAt(token2, i2);
            } else {
                stringBuffer = new StringBuffer(token2.getString().length() + length);
                stringBuffer.append(token2.getString());
            }
            if (token.type == 0) {
                int i4 = token.getChar();
                if (i4 >= 65536) {
                    stringBuffer.append(REUtil.decomposeToSurrogates(i4));
                } else {
                    stringBuffer.append((char) i4);
                }
            } else {
                stringBuffer.append(token.getString());
            }
            ((StringToken) token2).string = new String(stringBuffer);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            Vector vector = this.children;
            if (vector == null) {
                return 0;
            }
            return vector.size();
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int i) {
            return (Token) this.children.elementAt(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type == 1) {
                if (this.children.size() == 2) {
                    Token child = getChild(0);
                    Token child2 = getChild(1);
                    if (child2.type == 3 && child2.getChild(0) == child) {
                        return new StringBuffer().append(child.toString(i)).append("+").toString();
                    }
                    if (child2.type == 9 && child2.getChild(0) == child) {
                        return new StringBuffer().append(child.toString(i)).append("+?").toString();
                    }
                    return new StringBuffer().append(child.toString(i)).append(child2.toString(i)).toString();
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < this.children.size(); i2++) {
                    stringBuffer.append(((Token) this.children.elementAt(i2)).toString(i));
                }
                return new String(stringBuffer);
            }
            if (this.children.size() == 2 && getChild(1).type == 7) {
                return new StringBuffer().append(getChild(0).toString(i)).append("?").toString();
            }
            if (this.children.size() == 2 && getChild(0).type == 7) {
                return new StringBuffer().append(getChild(1).toString(i)).append("??").toString();
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(((Token) this.children.elementAt(0)).toString(i));
            for (int i3 = 1; i3 < this.children.size(); i3++) {
                stringBuffer2.append('|');
                stringBuffer2.append(((Token) this.children.elementAt(i3)).toString(i));
            }
            return new String(stringBuffer2);
        }
    }
}
