package org.apache.xmlbeans.impl.regex;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.xmlbeans.impl.regex.Token;

/* loaded from: classes5.dex */
class RegexParser {
    protected static final int S_INBRACKETS = 1;
    protected static final int S_INXBRACKETS = 2;
    protected static final int S_NORMAL = 0;
    static final int T_BACKSOLIDUS = 10;
    static final int T_CARET = 11;
    static final int T_CHAR = 0;
    static final int T_COMMENT = 21;
    static final int T_CONDITION = 23;
    static final int T_DOLLAR = 12;
    static final int T_DOT = 8;
    static final int T_EOF = 1;
    static final int T_INDEPENDENT = 18;
    static final int T_LBRACKET = 9;
    static final int T_LOOKAHEAD = 14;
    static final int T_LOOKBEHIND = 16;
    static final int T_LPAREN = 6;
    static final int T_LPAREN2 = 13;
    static final int T_MODIFIERS = 22;
    static final int T_NEGATIVELOOKAHEAD = 15;
    static final int T_NEGATIVELOOKBEHIND = 17;
    static final int T_OR = 2;
    static final int T_PLUS = 4;
    static final int T_POSIX_CHARCLASS_START = 20;
    static final int T_QUESTION = 5;
    static final int T_RPAREN = 7;
    static final int T_SET_OPERATIONS = 19;
    static final int T_STAR = 3;
    static final int T_XMLSCHEMA_CC_SUBTRACTION = 24;
    int chardata;
    boolean hasBackReferences;
    int nexttoken;
    int offset;
    int options;
    String regex;
    int regexlen;
    ResourceBundle resources;
    int context = 0;
    int parennumber = 1;
    Vector references = null;

    private static final int hexChar(int i) {
        if (i < 48 || i > 102) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = 65;
        if (i < 65) {
            return -1;
        }
        if (i > 70) {
            i2 = 97;
            if (i < 97) {
                return -1;
            }
        }
        return (i - i2) + 10;
    }

    static class ReferencePosition {
        int position;
        int refNumber;

        ReferencePosition(int i, int i2) {
            this.refNumber = i;
            this.position = i2;
        }
    }

    public RegexParser() {
        setLocale(Locale.getDefault());
    }

    public RegexParser(Locale locale) {
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        try {
            this.resources = ResourceBundle.getBundle("org.apache.xmlbeans.impl.regex.message", locale);
        } catch (MissingResourceException e) {
            throw new RuntimeException(new StringBuffer().append("Installation Problem???  Couldn't load messages: ").append(e.getMessage()).toString());
        }
    }

    final ParseException ex(String str, int i) {
        return new ParseException(this.resources.getString(str), i);
    }

    private final boolean isSet(int i) {
        return (this.options & i) == i;
    }

    synchronized Token parse(String str, int i) throws ParseException {
        Token parseRegex;
        this.options = i;
        this.offset = 0;
        setContext(0);
        this.parennumber = 1;
        this.hasBackReferences = false;
        this.regex = str;
        if (isSet(16)) {
            this.regex = REUtil.stripExtendedComment(this.regex);
        }
        this.regexlen = this.regex.length();
        next();
        parseRegex = parseRegex();
        int i2 = this.offset;
        if (i2 != this.regexlen) {
            throw ex("parser.parse.1", i2);
        }
        if (this.references != null) {
            for (int i3 = 0; i3 < this.references.size(); i3++) {
                ReferencePosition referencePosition = (ReferencePosition) this.references.elementAt(i3);
                if (this.parennumber <= referencePosition.refNumber) {
                    throw ex("parser.parse.2", referencePosition.position);
                }
            }
            this.references.removeAllElements();
        }
        return parseRegex;
    }

    protected final void setContext(int i) {
        this.context = i;
    }

    final int read() {
        return this.nexttoken;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void next() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegexParser.next():void");
    }

    Token parseRegex() throws ParseException {
        Token parseTerm = parseTerm();
        Token.UnionToken unionToken = null;
        while (read() == 2) {
            next();
            if (unionToken == null) {
                unionToken = Token.createUnion();
                unionToken.addChild(parseTerm);
                parseTerm = unionToken;
            }
            parseTerm.addChild(parseTerm());
        }
        return parseTerm;
    }

    Token parseTerm() throws ParseException {
        int read = read();
        if (read == 2 || read == 7 || read == 1) {
            return Token.createEmpty();
        }
        Token parseFactor = parseFactor();
        Token.UnionToken unionToken = null;
        while (true) {
            int read2 = read();
            if (read2 == 2 || read2 == 7 || read2 == 1) {
                break;
            }
            if (unionToken == null) {
                unionToken = Token.createConcat();
                unionToken.addChild(parseFactor);
                parseFactor = unionToken;
            }
            unionToken.addChild(parseFactor());
        }
        return parseFactor;
    }

    Token processCaret() throws ParseException {
        next();
        return Token.token_linebeginning;
    }

    Token processDollar() throws ParseException {
        next();
        return Token.token_lineend;
    }

    Token processLookahead() throws ParseException {
        next();
        Token.ParenToken createLook = Token.createLook(20, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createLook;
    }

    Token processNegativelookahead() throws ParseException {
        next();
        Token.ParenToken createLook = Token.createLook(21, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createLook;
    }

    Token processLookbehind() throws ParseException {
        next();
        Token.ParenToken createLook = Token.createLook(22, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createLook;
    }

    Token processNegativelookbehind() throws ParseException {
        next();
        Token.ParenToken createLook = Token.createLook(23, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createLook;
    }

    Token processBacksolidus_A() throws ParseException {
        next();
        return Token.token_stringbeginning;
    }

    Token processBacksolidus_Z() throws ParseException {
        next();
        return Token.token_stringend2;
    }

    Token processBacksolidus_z() throws ParseException {
        next();
        return Token.token_stringend;
    }

    Token processBacksolidus_b() throws ParseException {
        next();
        return Token.token_wordedge;
    }

    Token processBacksolidus_B() throws ParseException {
        next();
        return Token.token_not_wordedge;
    }

    Token processBacksolidus_lt() throws ParseException {
        next();
        return Token.token_wordbeginning;
    }

    Token processBacksolidus_gt() throws ParseException {
        next();
        return Token.token_wordend;
    }

    Token processStar(Token token) throws ParseException {
        next();
        if (read() == 5) {
            next();
            return Token.createNGClosure(token);
        }
        return Token.createClosure(token);
    }

    Token processPlus(Token token) throws ParseException {
        next();
        if (read() == 5) {
            next();
            return Token.createConcat(token, Token.createNGClosure(token));
        }
        return Token.createConcat(token, Token.createClosure(token));
    }

    Token processQuestion(Token token) throws ParseException {
        next();
        Token.UnionToken createUnion = Token.createUnion();
        if (read() == 5) {
            next();
            createUnion.addChild(Token.createEmpty());
            createUnion.addChild(token);
        } else {
            createUnion.addChild(token);
            createUnion.addChild(Token.createEmpty());
        }
        return createUnion;
    }

    boolean checkQuestion(int i) {
        return i < this.regexlen && this.regex.charAt(i) == '?';
    }

    Token processParen() throws ParseException {
        next();
        int i = this.parennumber;
        this.parennumber = i + 1;
        Token.ParenToken createParen = Token.createParen(parseRegex(), i);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createParen;
    }

    Token processParen2() throws ParseException {
        next();
        Token.ParenToken createParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createParen;
    }

    Token processCondition() throws ParseException {
        Token parseFactor;
        int i = this.offset;
        if (i + 1 >= this.regexlen) {
            throw ex("parser.factor.4", i);
        }
        int i2 = -1;
        char charAt = this.regex.charAt(i);
        Token token = null;
        if ('1' <= charAt && charAt <= '9') {
            i2 = charAt - '0';
            this.hasBackReferences = true;
            if (this.references == null) {
                this.references = new Vector();
            }
            this.references.addElement(new ReferencePosition(i2, this.offset));
            int i3 = this.offset + 1;
            this.offset = i3;
            if (this.regex.charAt(i3) != ')') {
                throw ex("parser.factor.1", this.offset);
            }
            this.offset++;
            parseFactor = null;
        } else {
            if (charAt == '?') {
                this.offset--;
            }
            next();
            parseFactor = parseFactor();
            int i4 = parseFactor.type;
            if (i4 == 8) {
                if (read() != 7) {
                    throw ex("parser.factor.1", this.offset - 1);
                }
            } else {
                switch (i4) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ex("parser.factor.5", this.offset);
                }
            }
        }
        next();
        Token parseRegex = parseRegex();
        if (parseRegex.type == 2) {
            if (parseRegex.size() != 2) {
                throw ex("parser.factor.6", this.offset);
            }
            token = parseRegex.getChild(1);
            parseRegex = parseRegex.getChild(0);
        }
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return Token.createCondition(i2, parseFactor, parseRegex, token);
    }

    Token processModifiers() throws ParseException {
        int optionValue;
        int optionValue2;
        int i = 0;
        char c = 65535;
        int i2 = 0;
        while (true) {
            int i3 = this.offset;
            if (i3 >= this.regexlen || (optionValue2 = REUtil.getOptionValue((c = this.regex.charAt(i3)))) == 0) {
                break;
            }
            i2 |= optionValue2;
            this.offset++;
        }
        int i4 = this.offset;
        if (i4 >= this.regexlen) {
            throw ex("parser.factor.2", i4 - 1);
        }
        if (c == '-') {
            this.offset = i4 + 1;
            while (true) {
                int i5 = this.offset;
                if (i5 >= this.regexlen || (optionValue = REUtil.getOptionValue((c = this.regex.charAt(i5)))) == 0) {
                    break;
                }
                i |= optionValue;
                this.offset++;
            }
            int i6 = this.offset;
            if (i6 >= this.regexlen) {
                throw ex("parser.factor.2", i6 - 1);
            }
        }
        if (c != ':') {
            if (c == ')') {
                this.offset++;
                next();
                return Token.createModifierGroup(parseRegex(), i2, i);
            }
            throw ex("parser.factor.3", this.offset);
        }
        this.offset++;
        next();
        Token.ModifierToken createModifierGroup = Token.createModifierGroup(parseRegex(), i2, i);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createModifierGroup;
    }

    Token processIndependent() throws ParseException {
        next();
        Token.ParenToken createLook = Token.createLook(24, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return createLook;
    }

    Token processBacksolidus_c() throws ParseException {
        int i = this.offset;
        if (i < this.regexlen) {
            String str = this.regex;
            this.offset = i + 1;
            char charAt = str.charAt(i);
            if ((65504 & charAt) == 64) {
                next();
                return Token.createChar(charAt - '@');
            }
        }
        throw ex("parser.atom.1", this.offset - 1);
    }

    Token processBacksolidus_C() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_i() throws ParseException {
        Token.CharToken createChar = Token.createChar(105);
        next();
        return createChar;
    }

    Token processBacksolidus_I() throws ParseException {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_g() throws ParseException {
        next();
        return Token.getGraphemePattern();
    }

    Token processBacksolidus_X() throws ParseException {
        next();
        return Token.getCombiningCharacterSequence();
    }

    Token processBackreference() throws ParseException {
        int i = this.chardata - 48;
        Token.StringToken createBackReference = Token.createBackReference(i);
        this.hasBackReferences = true;
        if (this.references == null) {
            this.references = new Vector();
        }
        this.references.addElement(new ReferencePosition(i, this.offset - 2));
        next();
        return createBackReference;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    org.apache.xmlbeans.impl.regex.Token parseFactor() throws org.apache.xmlbeans.impl.regex.ParseException {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegexParser.parseFactor():org.apache.xmlbeans.impl.regex.Token");
    }

    Token parseAtom() throws ParseException {
        Token processBacksolidus_pP;
        int read = read();
        if (read == 0) {
            int i = this.chardata;
            if (i == 93 || i == 123 || i == 125) {
                throw ex("parser.atom.4", this.offset - 1);
            }
            Token.CharToken createChar = Token.createChar(i);
            int i2 = this.chardata;
            next();
            if (!REUtil.isHighSurrogate(i2) || read() != 0 || !REUtil.isLowSurrogate(this.chardata)) {
                return createChar;
            }
            Token.ParenToken createParen = Token.createParen(Token.createString(new String(new char[]{(char) i2, (char) this.chardata})), 0);
            next();
            return createParen;
        }
        if (read == 6) {
            return processParen();
        }
        if (read == 13) {
            return processParen2();
        }
        if (read == 18) {
            return processIndependent();
        }
        if (read == 19) {
            return parseSetOperations();
        }
        if (read == 22) {
            return processModifiers();
        }
        if (read == 23) {
            return processCondition();
        }
        switch (read) {
            case 8:
                next();
                return Token.token_dot;
            case 9:
                return parseCharacterClass(true);
            case 10:
                int i3 = this.chardata;
                if (i3 != 67) {
                    if (i3 != 68) {
                        if (i3 == 73) {
                            return processBacksolidus_I();
                        }
                        if (i3 != 80) {
                            if (i3 != 83) {
                                if (i3 != 105) {
                                    if (i3 != 110) {
                                        if (i3 != 112) {
                                            if (i3 != 87) {
                                                if (i3 == 88) {
                                                    return processBacksolidus_X();
                                                }
                                                switch (i3) {
                                                    case 49:
                                                    case 50:
                                                    case 51:
                                                    case 52:
                                                    case 53:
                                                    case 54:
                                                    case 55:
                                                    case 56:
                                                    case 57:
                                                        return processBackreference();
                                                    default:
                                                        switch (i3) {
                                                            case 99:
                                                                return processBacksolidus_c();
                                                            case 100:
                                                                break;
                                                            case 101:
                                                            case 102:
                                                                break;
                                                            case 103:
                                                                return processBacksolidus_g();
                                                            default:
                                                                switch (i3) {
                                                                    case 114:
                                                                    case 116:
                                                                    case 117:
                                                                    case 118:
                                                                    case 120:
                                                                        break;
                                                                    case 115:
                                                                    case 119:
                                                                        break;
                                                                    default:
                                                                        processBacksolidus_pP = Token.createChar(i3);
                                                                        break;
                                                                }
                                                                next();
                                                                return processBacksolidus_pP;
                                                        }
                                                }
                                            }
                                        }
                                    }
                                    int decodeEscaped = decodeEscaped();
                                    if (decodeEscaped < 65536) {
                                        processBacksolidus_pP = Token.createChar(decodeEscaped);
                                    } else {
                                        processBacksolidus_pP = Token.createString(REUtil.decomposeToSurrogates(decodeEscaped));
                                    }
                                    next();
                                    return processBacksolidus_pP;
                                }
                                return processBacksolidus_i();
                            }
                        }
                        int i4 = this.offset;
                        processBacksolidus_pP = processBacksolidus_pP(i3);
                        if (processBacksolidus_pP == null) {
                            throw ex("parser.atom.5", i4);
                        }
                        next();
                        return processBacksolidus_pP;
                    }
                    Token tokenForShorthand = getTokenForShorthand(i3);
                    next();
                    return tokenForShorthand;
                }
                return processBacksolidus_C();
            default:
                throw ex("parser.atom.4", this.offset - 1);
        }
    }

    protected RangeToken processBacksolidus_pP(int i) throws ParseException {
        next();
        if (read() != 0 || this.chardata != 123) {
            throw ex("parser.atom.2", this.offset - 1);
        }
        boolean z = i == 112;
        int i2 = this.offset;
        int indexOf = this.regex.indexOf(125, i2);
        if (indexOf < 0) {
            throw ex("parser.atom.3", this.offset);
        }
        String substring = this.regex.substring(i2, indexOf);
        this.offset = indexOf + 1;
        return Token.getRange(substring, z, isSet(512));
    }

    int processCIinCharacterClass(RangeToken rangeToken, int i) {
        return decodeEscaped();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x016d, code lost:
    
        if (read() == 1) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x016f, code lost:
    
        if (r17 != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0171, code lost:
    
        if (r6 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0173, code lost:
    
        r5.subtractRanges(r2);
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0177, code lost:
    
        r2.sortRanges();
        r2.compactRanges();
        setContext(0);
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0183, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x018a, code lost:
    
        throw ex("parser.cc.2", r16.offset);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00a6, code lost:
    
        if (r7 < 0) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected org.apache.xmlbeans.impl.regex.RangeToken parseCharacterClass(boolean r17) throws org.apache.xmlbeans.impl.regex.ParseException {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegexParser.parseCharacterClass(boolean):org.apache.xmlbeans.impl.regex.RangeToken");
    }

    protected RangeToken parseSetOperations() throws ParseException {
        RangeToken parseCharacterClass = parseCharacterClass(false);
        while (true) {
            int read = read();
            if (read != 7) {
                int i = this.chardata;
                if ((read == 0 && (i == 45 || i == 38)) || read == 4) {
                    next();
                    if (read() != 9) {
                        throw ex("parser.ope.1", this.offset - 1);
                    }
                    RangeToken parseCharacterClass2 = parseCharacterClass(false);
                    if (read == 4) {
                        parseCharacterClass.mergeRanges(parseCharacterClass2);
                    } else if (i == 45) {
                        parseCharacterClass.subtractRanges(parseCharacterClass2);
                    } else if (i == 38) {
                        parseCharacterClass.intersectRanges(parseCharacterClass2);
                    } else {
                        throw new RuntimeException("ASSERT");
                    }
                } else {
                    throw ex("parser.ope.2", this.offset - 1);
                }
            } else {
                next();
                return parseCharacterClass;
            }
        }
    }

    Token getTokenForShorthand(int i) {
        if (i == 68) {
            return isSet(32) ? Token.getRange("Nd", false) : Token.token_not_0to9;
        }
        if (i == 83) {
            return isSet(32) ? Token.getRange("IsSpace", false) : Token.token_not_spaces;
        }
        if (i == 87) {
            return isSet(32) ? Token.getRange("IsWord", false) : Token.token_not_wordchars;
        }
        if (i == 100) {
            return isSet(32) ? Token.getRange("Nd", true) : Token.token_0to9;
        }
        if (i == 115) {
            return isSet(32) ? Token.getRange("IsSpace", true) : Token.token_spaces;
        }
        if (i == 119) {
            return isSet(32) ? Token.getRange("IsWord", true) : Token.token_wordchars;
        }
        throw new RuntimeException(new StringBuffer().append("Internal Error: shorthands: \\u").append(Integer.toString(i, 16)).toString());
    }

    int decodeEscaped() throws ParseException {
        int hexChar;
        int hexChar2;
        int hexChar3;
        int hexChar4;
        int hexChar5;
        int hexChar6;
        int hexChar7;
        int hexChar8;
        int hexChar9;
        int hexChar10;
        int hexChar11;
        if (read() != 10) {
            throw ex("parser.next.1", this.offset - 1);
        }
        int i = this.chardata;
        if (i != 65 && i != 90) {
            if (i == 110) {
                return 10;
            }
            if (i == 114) {
                return 13;
            }
            if (i == 120) {
                next();
                if (read() != 0) {
                    throw ex("parser.descape.1", this.offset - 1);
                }
                if (this.chardata == 123) {
                    int i2 = 0;
                    while (true) {
                        next();
                        if (read() != 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int hexChar12 = hexChar(this.chardata);
                        if (hexChar12 < 0) {
                            if (this.chardata != 125) {
                                throw ex("parser.descape.3", this.offset - 1);
                            }
                            if (i2 <= 1114111) {
                                return i2;
                            }
                            throw ex("parser.descape.4", this.offset - 1);
                        }
                        int i3 = i2 * 16;
                        if (i2 > i3) {
                            throw ex("parser.descape.2", this.offset - 1);
                        }
                        i2 = i3 + hexChar12;
                    }
                } else {
                    if (read() != 0 || (hexChar = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                    next();
                    if (read() != 0 || (hexChar2 = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                }
            } else if (i != 122) {
                if (i == 101) {
                    return 27;
                }
                if (i == 102) {
                    return 12;
                }
                switch (i) {
                    case 116:
                        return 9;
                    case 117:
                        next();
                        if (read() != 0 || (hexChar3 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (hexChar4 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i4 = (hexChar3 * 16) + hexChar4;
                        next();
                        if (read() != 0 || (hexChar5 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        hexChar = (i4 * 16) + hexChar5;
                        next();
                        if (read() != 0 || (hexChar2 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        break;
                    case 118:
                        next();
                        if (read() != 0 || (hexChar6 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (hexChar7 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i5 = (hexChar6 * 16) + hexChar7;
                        next();
                        if (read() != 0 || (hexChar8 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i6 = (i5 * 16) + hexChar8;
                        next();
                        if (read() != 0 || (hexChar9 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i7 = (i6 * 16) + hexChar9;
                        next();
                        if (read() != 0 || (hexChar10 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i8 = (i7 * 16) + hexChar10;
                        next();
                        if (read() != 0 || (hexChar11 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i9 = hexChar11 + (i8 * 16);
                        if (i9 <= 1114111) {
                            return i9;
                        }
                        throw ex("parser.descappe.4", this.offset - 1);
                    default:
                        return i;
                }
            }
            return hexChar2 + (hexChar * 16);
        }
        throw ex("parser.descape.5", this.offset - 2);
    }
}
