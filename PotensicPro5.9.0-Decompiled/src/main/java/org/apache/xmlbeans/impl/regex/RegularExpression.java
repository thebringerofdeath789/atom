package org.apache.xmlbeans.impl.regex;

import java.io.Serializable;
import java.text.CharacterIterator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.impl.regex.Op;
import org.apache.xmlbeans.impl.regex.Token;

/* loaded from: classes5.dex */
public class RegularExpression implements Serializable {
    static final int CARRIAGE_RETURN = 13;
    static final boolean DEBUG = false;
    static final int EXTENDED_COMMENT = 16;
    static final int IGNORE_CASE = 2;
    static final int LINE_FEED = 10;
    static final int LINE_SEPARATOR = 8232;
    static final int MULTIPLE_LINES = 8;
    static final int PARAGRAPH_SEPARATOR = 8233;
    static final int PROHIBIT_FIXED_STRING_OPTIMIZATION = 256;
    static final int PROHIBIT_HEAD_CHARACTER_OPTIMIZATION = 128;
    static final int SINGLE_LINE = 4;
    static final int SPECIAL_COMMA = 1024;
    static final int UNICODE_WORD_BOUNDARY = 64;
    static final int USE_UNICODE_CATEGORY = 32;
    private static final int WT_IGNORE = 0;
    private static final int WT_LETTER = 1;
    private static final int WT_OTHER = 2;
    static final int XMLSCHEMA_MODE = 512;
    transient Context context;
    transient RangeToken firstChar;
    transient String fixedString;
    transient boolean fixedStringOnly;
    transient int fixedStringOptions;
    transient BMPattern fixedStringTable;
    boolean hasBackReferences;
    transient int minlength;
    int nofparen;
    transient int numberOfClosures;
    transient Op operations;
    int options;
    String regex;
    Token tokentree;

    private static final boolean isEOLChar(int i) {
        return i == 10 || i == 13 || i == LINE_SEPARATOR || i == PARAGRAPH_SEPARATOR;
    }

    private static final boolean isSet(int i, int i2) {
        return (i & i2) == i2;
    }

    private static final boolean isWordChar(int i) {
        if (i == 95) {
            return true;
        }
        if (i < 48 || i > 122) {
            return false;
        }
        if (i <= 57) {
            return true;
        }
        if (i < 65) {
            return false;
        }
        return i <= 90 || i >= 97;
    }

    private synchronized void compile(Token token) {
        if (this.operations != null) {
            return;
        }
        this.numberOfClosures = 0;
        this.operations = compile(token, null, false);
    }

    private Op compile(Token token, Op op, boolean z) {
        Op createChar;
        Op.ChildOp createClosure;
        Op op2;
        int i = token.type;
        int i2 = 0;
        switch (i) {
            case 0:
                createChar = Op.createChar(token.getChar());
                createChar.next = op;
                break;
            case 1:
                if (!z) {
                    for (int size = token.size() - 1; size >= 0; size--) {
                        op = compile(token.getChild(size), op, false);
                    }
                    return op;
                }
                while (i2 < token.size()) {
                    op = compile(token.getChild(i2), op, true);
                    i2++;
                }
                return op;
            case 2:
                Op.UnionOp createUnion = Op.createUnion(token.size());
                while (i2 < token.size()) {
                    createUnion.addElement(compile(token.getChild(i2), op, z));
                    i2++;
                }
                return createUnion;
            case 3:
            case 9:
                Token child = token.getChild(0);
                int min = token.getMin();
                int max = token.getMax();
                if (min >= 0 && min == max) {
                    while (i2 < min) {
                        op = compile(child, op, z);
                        i2++;
                    }
                    return op;
                }
                if (min > 0 && max > 0) {
                    max -= min;
                }
                if (max > 0) {
                    Op op3 = op;
                    int i3 = 0;
                    while (i3 < max) {
                        Op.ChildOp createQuestion = Op.createQuestion(token.type == 9);
                        createQuestion.next = op;
                        createQuestion.setChild(compile(child, op3, z));
                        i3++;
                        op3 = createQuestion;
                    }
                    op2 = op3;
                } else {
                    if (token.type == 9) {
                        createClosure = Op.createNonGreedyClosure();
                    } else if (child.getMinLength() == 0) {
                        int i4 = this.numberOfClosures;
                        this.numberOfClosures = i4 + 1;
                        createClosure = Op.createClosure(i4);
                    } else {
                        createClosure = Op.createClosure(-1);
                    }
                    createClosure.next = op;
                    createClosure.setChild(compile(child, createClosure, z));
                    op2 = createClosure;
                }
                if (min <= 0) {
                    return op2;
                }
                while (i2 < min) {
                    op2 = compile(child, op2, z);
                    i2++;
                }
                return op2;
            case 4:
            case 5:
                createChar = Op.createRange(token);
                createChar.next = op;
                break;
            case 6:
                if (token.getParenNumber() == 0) {
                    return compile(token.getChild(0), op, z);
                }
                if (z) {
                    return Op.createCapture(-token.getParenNumber(), compile(token.getChild(0), Op.createCapture(token.getParenNumber(), op), z));
                }
                return Op.createCapture(token.getParenNumber(), compile(token.getChild(0), Op.createCapture(-token.getParenNumber(), op), z));
            case 7:
                return op;
            case 8:
                createChar = Op.createAnchor(token.getChar());
                createChar.next = op;
                break;
            case 10:
                createChar = Op.createString(token.getString());
                createChar.next = op;
                break;
            case 11:
                createChar = Op.createDot();
                createChar.next = op;
                break;
            case 12:
                createChar = Op.createBackReference(token.getReferenceNumber());
                createChar.next = op;
                break;
            default:
                switch (i) {
                    case 20:
                        return Op.createLook(20, op, compile(token.getChild(0), null, false));
                    case 21:
                        return Op.createLook(21, op, compile(token.getChild(0), null, false));
                    case 22:
                        return Op.createLook(22, op, compile(token.getChild(0), null, true));
                    case 23:
                        return Op.createLook(23, op, compile(token.getChild(0), null, true));
                    case 24:
                        return Op.createIndependent(op, compile(token.getChild(0), null, z));
                    case 25:
                        Op compile = compile(token.getChild(0), null, z);
                        Token.ModifierToken modifierToken = (Token.ModifierToken) token;
                        return Op.createModifier(op, compile, modifierToken.getOptions(), modifierToken.getOptionsMask());
                    case 26:
                        Token.ConditionToken conditionToken = (Token.ConditionToken) token;
                        return Op.createCondition(op, conditionToken.refNumber, conditionToken.condition == null ? null : compile(conditionToken.condition, null, z), compile(conditionToken.yes, op, z), conditionToken.no != null ? compile(conditionToken.no, op, z) : null);
                    default:
                        throw new RuntimeException(new StringBuffer().append("Unknown token type: ").append(token.type).toString());
                }
        }
        return createChar;
    }

    public boolean matches(char[] cArr) {
        return matches(cArr, 0, cArr.length, (Match) null);
    }

    public boolean matches(char[] cArr, int i, int i2) {
        return matches(cArr, i, i2, (Match) null);
    }

    public boolean matches(char[] cArr, Match match) {
        return matches(cArr, 0, cArr.length, match);
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x01a6 A[EDGE_INSN: B:94:0x01a6->B:95:0x01a6 BREAK  A[LOOP:1: B:85:0x0129->B:97:0x0171], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0171 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean matches(char[] r12, int r13, int r14, org.apache.xmlbeans.impl.regex.Match r15) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(char[], int, int, org.apache.xmlbeans.impl.regex.Match):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x006f, code lost:
    
        if (r11.match.getEnd(r12.refNumber) >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x0098, code lost:
    
        if (matchCharArray(r11, r12.condition, r13, r14, r15) >= 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int matchCharArray(org.apache.xmlbeans.impl.regex.RegularExpression.Context r11, org.apache.xmlbeans.impl.regex.Op r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 1412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matchCharArray(org.apache.xmlbeans.impl.regex.RegularExpression$Context, org.apache.xmlbeans.impl.regex.Op, int, int, int):int");
    }

    private static final int getPreviousWordType(char[] cArr, int i, int i2, int i3, int i4) {
        int i5 = i3 - 1;
        int wordType = getWordType(cArr, i, i2, i5, i4);
        while (wordType == 0) {
            i5--;
            wordType = getWordType(cArr, i, i2, i5, i4);
        }
        return wordType;
    }

    private static final int getWordType(char[] cArr, int i, int i2, int i3, int i4) {
        if (i3 < i || i3 >= i2) {
            return 2;
        }
        return getWordType0(cArr[i3], i4);
    }

    private static final boolean regionMatches(char[] cArr, int i, int i2, String str, int i3) {
        if (i < 0 || i2 - i < i3) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i4 + 1;
            if (cArr[i] != str.charAt(i4)) {
                return false;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatches(char[] cArr, int i, int i2, int i3, int i4) {
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i3 + 1;
            if (cArr[i] != cArr[i3]) {
                return false;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    private static final boolean regionMatchesIgnoreCase(char[] cArr, int i, int i2, String str, int i3) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i3) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char c = cArr[i];
            int i7 = i4 + 1;
            char charAt = str.charAt(i4);
            if (c != charAt && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(charAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatchesIgnoreCase(char[] cArr, int i, int i2, int i3, int i4) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char c = cArr[i];
            int i7 = i3 + 1;
            char c2 = cArr[i3];
            if (c != c2 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    public boolean matches(String str) {
        return matches(str, 0, str.length(), (Match) null);
    }

    public boolean matches(String str, int i, int i2) {
        return matches(str, i, i2, (Match) null);
    }

    public boolean matches(String str, Match match) {
        return matches(str, 0, str.length(), match);
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x01b0 A[EDGE_INSN: B:94:0x01b0->B:95:0x01b0 BREAK  A[LOOP:1: B:85:0x012b->B:97:0x0177], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0177 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean matches(java.lang.String r12, int r13, int r14, org.apache.xmlbeans.impl.regex.Match r15) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(java.lang.String, int, int, org.apache.xmlbeans.impl.regex.Match):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x006f, code lost:
    
        if (r11.match.getEnd(r12.refNumber) >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x0098, code lost:
    
        if (matchString(r11, r12.condition, r13, r14, r15) >= 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int matchString(org.apache.xmlbeans.impl.regex.RegularExpression.Context r11, org.apache.xmlbeans.impl.regex.Op r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 1454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matchString(org.apache.xmlbeans.impl.regex.RegularExpression$Context, org.apache.xmlbeans.impl.regex.Op, int, int, int):int");
    }

    private static final int getPreviousWordType(String str, int i, int i2, int i3, int i4) {
        int i5 = i3 - 1;
        int wordType = getWordType(str, i, i2, i5, i4);
        while (wordType == 0) {
            i5--;
            wordType = getWordType(str, i, i2, i5, i4);
        }
        return wordType;
    }

    private static final int getWordType(String str, int i, int i2, int i3, int i4) {
        if (i3 < i || i3 >= i2) {
            return 2;
        }
        return getWordType0(str.charAt(i3), i4);
    }

    private static final boolean regionMatches(String str, int i, int i2, String str2, int i3) {
        if (i2 - i < i3) {
            return false;
        }
        return str.regionMatches(i, str2, 0, i3);
    }

    private static final boolean regionMatches(String str, int i, int i2, int i3, int i4) {
        if (i2 - i < i4) {
            return false;
        }
        return str.regionMatches(i, str, i3, i4);
    }

    private static final boolean regionMatchesIgnoreCase(String str, int i, int i2, String str2, int i3) {
        return str.regionMatches(true, i, str2, 0, i3);
    }

    private static final boolean regionMatchesIgnoreCase(String str, int i, int i2, int i3, int i4) {
        if (i2 - i < i4) {
            return false;
        }
        return str.regionMatches(true, i, str, i3, i4);
    }

    public boolean matches(CharacterIterator characterIterator) {
        return matches(characterIterator, (Match) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x01b8 A[EDGE_INSN: B:95:0x01b8->B:96:0x01b8 BREAK  A[LOOP:1: B:86:0x0133->B:98:0x017f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x017f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean matches(java.text.CharacterIterator r14, org.apache.xmlbeans.impl.regex.Match r15) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(java.text.CharacterIterator, org.apache.xmlbeans.impl.regex.Match):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x006f, code lost:
    
        if (r11.match.getEnd(r12.refNumber) >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x0098, code lost:
    
        if (matchCharacterIterator(r11, r12.condition, r13, r14, r15) >= 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int matchCharacterIterator(org.apache.xmlbeans.impl.regex.RegularExpression.Context r11, org.apache.xmlbeans.impl.regex.Op r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 1454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matchCharacterIterator(org.apache.xmlbeans.impl.regex.RegularExpression$Context, org.apache.xmlbeans.impl.regex.Op, int, int, int):int");
    }

    private static final int getPreviousWordType(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        int i5 = i3 - 1;
        int wordType = getWordType(characterIterator, i, i2, i5, i4);
        while (wordType == 0) {
            i5--;
            wordType = getWordType(characterIterator, i, i2, i5, i4);
        }
        return wordType;
    }

    private static final int getWordType(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        if (i3 < i || i3 >= i2) {
            return 2;
        }
        return getWordType0(characterIterator.setIndex(i3), i4);
    }

    private static final boolean regionMatches(CharacterIterator characterIterator, int i, int i2, String str, int i3) {
        if (i < 0 || i2 - i < i3) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i4 + 1;
            if (characterIterator.setIndex(i) != str.charAt(i4)) {
                return false;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatches(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            int i7 = i3 + 1;
            if (characterIterator.setIndex(i) != characterIterator.setIndex(i3)) {
                return false;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator characterIterator, int i, int i2, String str, int i3) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i3) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char index = characterIterator.setIndex(i);
            int i7 = i4 + 1;
            char charAt = str.charAt(i4);
            if (index != charAt && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(charAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator characterIterator, int i, int i2, int i3, int i4) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i + 1;
            char index = characterIterator.setIndex(i);
            int i7 = i3 + 1;
            char index2 = characterIterator.setIndex(i3);
            if (index != index2 && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(index2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i6;
            i3 = i7;
            i4 = i5;
        }
    }

    static final class Context {
        char[] charTarget;
        CharacterIterator ciTarget;
        boolean inuse = false;
        int length;
        int limit;
        Match match;
        int[] offsets;
        int start;
        String strTarget;

        Context() {
        }

        private void resetCommon(int i) {
            this.length = this.limit - this.start;
            this.inuse = true;
            this.match = null;
            int[] iArr = this.offsets;
            if (iArr == null || iArr.length != i) {
                this.offsets = new int[i];
            }
            for (int i2 = 0; i2 < i; i2++) {
                this.offsets[i2] = -1;
            }
        }

        void reset(CharacterIterator characterIterator, int i, int i2, int i3) {
            this.ciTarget = characterIterator;
            this.start = i;
            this.limit = i2;
            resetCommon(i3);
        }

        void reset(String str, int i, int i2, int i3) {
            this.strTarget = str;
            this.start = i;
            this.limit = i2;
            resetCommon(i3);
        }

        void reset(char[] cArr, int i, int i2, int i3) {
            this.charTarget = cArr;
            this.start = i;
            this.limit = i2;
            resetCommon(i3);
        }
    }

    void prepare() {
        compile(this.tokentree);
        this.minlength = this.tokentree.getMinLength();
        this.firstChar = null;
        if (!isSet(this.options, 128) && !isSet(this.options, 512)) {
            RangeToken createRange = Token.createRange();
            if (this.tokentree.analyzeFirstCharacter(createRange, this.options) == 1) {
                createRange.compactRanges();
                this.firstChar = createRange;
            }
        }
        Op op = this.operations;
        if (op != null && ((op.type == 6 || this.operations.type == 1) && this.operations.next == null)) {
            this.fixedStringOnly = true;
            if (this.operations.type == 6) {
                this.fixedString = this.operations.getString();
            } else if (this.operations.getData() >= 65536) {
                this.fixedString = REUtil.decomposeToSurrogates(this.operations.getData());
            } else {
                this.fixedString = new String(new char[]{(char) this.operations.getData()});
            }
            this.fixedStringOptions = this.options;
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
            return;
        }
        if (isSet(this.options, 256) || isSet(this.options, 512)) {
            return;
        }
        Token.FixedStringContainer fixedStringContainer = new Token.FixedStringContainer();
        this.tokentree.findFixedString(fixedStringContainer, this.options);
        this.fixedString = fixedStringContainer.token == null ? null : fixedStringContainer.token.getString();
        this.fixedStringOptions = fixedStringContainer.options;
        String str = this.fixedString;
        if (str != null && str.length() < 2) {
            this.fixedString = null;
        }
        if (this.fixedString != null) {
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
        }
    }

    public RegularExpression(String str) throws ParseException {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, (String) null);
    }

    public RegularExpression(String str, String str2) throws ParseException {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, str2);
    }

    RegularExpression(String str, Token token, int i, boolean z, int i2) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        this.regex = str;
        this.tokentree = token;
        this.nofparen = i;
        this.options = i2;
        this.hasBackReferences = z;
    }

    public void setPattern(String str) throws ParseException {
        setPattern(str, this.options);
    }

    private void setPattern(String str, int i) throws ParseException {
        this.regex = str;
        this.options = i;
        RegexParser parserForXMLSchema = isSet(i, 512) ? new ParserForXMLSchema() : new RegexParser();
        this.tokentree = parserForXMLSchema.parse(this.regex, this.options);
        this.nofparen = parserForXMLSchema.parennumber;
        this.hasBackReferences = parserForXMLSchema.hasBackReferences;
        this.operations = null;
        this.context = null;
    }

    public void setPattern(String str, String str2) throws ParseException {
        setPattern(str, REUtil.parseOptions(str2));
    }

    public String getPattern() {
        return this.regex;
    }

    public String toString() {
        return this.tokentree.toString(this.options);
    }

    public String getOptions() {
        return REUtil.createOptionString(this.options);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegularExpression)) {
            return false;
        }
        RegularExpression regularExpression = (RegularExpression) obj;
        return this.regex.equals(regularExpression.regex) && this.options == regularExpression.options;
    }

    boolean equals(String str, int i) {
        return this.regex.equals(str) && this.options == i;
    }

    public int hashCode() {
        return new StringBuffer().append(this.regex).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(getOptions()).toString().hashCode();
    }

    public int getNumberOfGroups() {
        return this.nofparen;
    }

    private static final int getWordType0(char c, int i) {
        if (!isSet(i, 64)) {
            return isSet(i, 32) ? Token.getRange("IsWord", true).match(c) ? 1 : 2 : isWordChar(c) ? 1 : 2;
        }
        int type = Character.getType(c);
        if (type == 15) {
            switch (c) {
            }
        }
        if (type != 16) {
            switch (type) {
            }
        }
        return 0;
    }

    private static final boolean matchIgnoreCase(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i > 65535 || i2 > 65535) {
            return false;
        }
        char upperCase = Character.toUpperCase((char) i);
        char upperCase2 = Character.toUpperCase((char) i2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}
