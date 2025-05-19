package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AddPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ConcatPtg;
import org.apache.poi.ss.formula.ptg.DividePtg;
import org.apache.poi.ss.formula.ptg.EqualPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.FuncPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.apache.poi.ss.formula.ptg.LessThanPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.MultiplyPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.PowerPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.SubtractPtg;
import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public final class FormulaParser {
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Za-z]+)?(\\$?[0-9]+)?");
    private static final char CR = '\r';
    private static final char LF = '\n';
    private static final char TAB = '\t';
    private FormulaParsingWorkbook _book;
    private final int _formulaLength;
    private final String _formulaString;
    private int _pointer = 0;
    private ParseNode _rootNode;
    private int _sheetIndex;
    private SpreadsheetVersion _ssVersion;
    private char look;

    private static boolean IsWhite(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    private static boolean isArgumentDelimiter(char c) {
        return c == ',' || c == ')';
    }

    private FormulaParser(String str, FormulaParsingWorkbook formulaParsingWorkbook, int i) {
        this._formulaString = str;
        this._book = formulaParsingWorkbook;
        this._ssVersion = formulaParsingWorkbook == null ? SpreadsheetVersion.EXCEL97 : formulaParsingWorkbook.getSpreadsheetVersion();
        this._formulaLength = str.length();
        this._sheetIndex = i;
    }

    public static Ptg[] parse(String str, FormulaParsingWorkbook formulaParsingWorkbook, int i, int i2) {
        FormulaParser formulaParser = new FormulaParser(str, formulaParsingWorkbook, i2);
        formulaParser.parse();
        return formulaParser.getRPNPtg(i);
    }

    private void GetChar() {
        int i = this._pointer;
        int i2 = this._formulaLength;
        if (i > i2) {
            throw new RuntimeException("too far");
        }
        if (i < i2) {
            this.look = this._formulaString.charAt(i);
        } else {
            this.look = (char) 0;
        }
        this._pointer++;
    }

    private void resetPointer(int i) {
        this._pointer = i;
        if (i <= this._formulaLength) {
            this.look = this._formulaString.charAt(i - 1);
        } else {
            this.look = (char) 0;
        }
    }

    private RuntimeException expected(String str) {
        String str2;
        if (this.look == '=' && this._formulaString.substring(0, this._pointer - 1).trim().length() < 1) {
            str2 = "The specified formula '" + this._formulaString + "' starts with an equals sign which is not allowed.";
        } else {
            str2 = "Parse error near char " + (this._pointer - 1) + " '" + this.look + "' in specified formula '" + this._formulaString + "'. Expected " + str;
        }
        return new FormulaParseException(str2);
    }

    private static boolean IsAlpha(char c) {
        return Character.isLetter(c) || c == '$' || c == '_';
    }

    private static boolean IsDigit(char c) {
        return Character.isDigit(c);
    }

    private void SkipWhite() {
        while (IsWhite(this.look)) {
            GetChar();
        }
    }

    private void Match(char c) {
        if (this.look != c) {
            throw expected("'" + c + "'");
        }
        GetChar();
    }

    private String GetNum() {
        StringBuffer stringBuffer = new StringBuffer();
        while (IsDigit(this.look)) {
            stringBuffer.append(this.look);
            GetChar();
        }
        if (stringBuffer.length() == 0) {
            return null;
        }
        return stringBuffer.toString();
    }

    private ParseNode parseRangeExpression() {
        ParseNode parseRangeable = parseRangeable();
        boolean z = false;
        while (this.look == ':') {
            int i = this._pointer;
            GetChar();
            ParseNode parseRangeable2 = parseRangeable();
            checkValidRangeOperand("LHS", i, parseRangeable);
            checkValidRangeOperand("RHS", i, parseRangeable2);
            parseRangeable = new ParseNode(RangePtg.instance, new ParseNode[]{parseRangeable, parseRangeable2});
            z = true;
        }
        return z ? augmentWithMemPtg(parseRangeable) : parseRangeable;
    }

    private static ParseNode augmentWithMemPtg(ParseNode parseNode) {
        Ptg memAreaPtg;
        if (needsMemFunc(parseNode)) {
            memAreaPtg = new MemFuncPtg(parseNode.getEncodedSize());
        } else {
            memAreaPtg = new MemAreaPtg(parseNode.getEncodedSize());
        }
        return new ParseNode(memAreaPtg, parseNode);
    }

    private static boolean needsMemFunc(ParseNode parseNode) {
        Ptg token = parseNode.getToken();
        if ((token instanceof AbstractFunctionPtg) || (token instanceof ExternSheetReferenceToken) || (token instanceof NamePtg) || (token instanceof NameXPtg)) {
            return true;
        }
        boolean z = token instanceof OperationPtg;
        if (!z && !(token instanceof ParenthesisPtg)) {
            return !(token instanceof OperandPtg) && z;
        }
        for (ParseNode parseNode2 : parseNode.getChildren()) {
            if (needsMemFunc(parseNode2)) {
                return true;
            }
        }
        return false;
    }

    private static void checkValidRangeOperand(String str, int i, ParseNode parseNode) {
        if (!isValidRangeOperand(parseNode)) {
            throw new FormulaParseException("The " + str + " of the range operator ':' at position " + i + " is not a proper reference.");
        }
    }

    private static boolean isValidRangeOperand(ParseNode parseNode) {
        Ptg token = parseNode.getToken();
        if (token instanceof OperandPtg) {
            return true;
        }
        if (token instanceof AbstractFunctionPtg) {
            return ((AbstractFunctionPtg) token).getDefaultOperandClass() == 0;
        }
        if (token instanceof ValueOperatorPtg) {
            return false;
        }
        if (token instanceof OperationPtg) {
            return true;
        }
        if (token instanceof ParenthesisPtg) {
            return isValidRangeOperand(parseNode.getChildren()[0]);
        }
        return token == ErrPtg.REF_INVALID;
    }

    private ParseNode parseRangeable() {
        char c;
        SkipWhite();
        int i = this._pointer;
        SheetIdentifier parseSheetName = parseSheetName();
        if (parseSheetName == null) {
            resetPointer(i);
        } else {
            SkipWhite();
            i = this._pointer;
        }
        SimpleRangePart parseSimpleRangePart = parseSimpleRangePart();
        if (parseSimpleRangePart == null) {
            if (parseSheetName != null) {
                if (this.look == '#') {
                    return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
                }
                String parseAsName = parseAsName();
                if (parseAsName.length() == 0) {
                    throw new FormulaParseException("Cell reference or Named Range expected after sheet name at index " + this._pointer + ".");
                }
                Ptg nameXPtg = this._book.getNameXPtg(parseAsName, parseSheetName);
                if (nameXPtg == null) {
                    throw new FormulaParseException("Specified name '" + parseAsName + "' for sheet " + parseSheetName.asFormulaString() + " not found");
                }
                return new ParseNode(nameXPtg);
            }
            return parseNonRange(i);
        }
        boolean IsWhite = IsWhite(this.look);
        if (IsWhite) {
            SkipWhite();
        }
        char c2 = this.look;
        if (c2 == ':') {
            int i2 = this._pointer;
            GetChar();
            SkipWhite();
            SimpleRangePart parseSimpleRangePart2 = parseSimpleRangePart();
            SimpleRangePart simpleRangePart = (parseSimpleRangePart2 == null || parseSimpleRangePart.isCompatibleForArea(parseSimpleRangePart2)) ? parseSimpleRangePart2 : null;
            if (simpleRangePart == null) {
                resetPointer(i2);
                if (!parseSimpleRangePart.isCell()) {
                    throw new FormulaParseException((parseSheetName == null ? "" : "'" + parseSheetName.getSheetIdentifier().getName() + '!') + parseSimpleRangePart.getRep() + "' is not a proper reference.");
                }
                return createAreaRefParseNode(parseSheetName, parseSimpleRangePart, simpleRangePart);
            }
            return createAreaRefParseNode(parseSheetName, parseSimpleRangePart, simpleRangePart);
        }
        if (c2 == '.') {
            GetChar();
            int i3 = 1;
            while (true) {
                c = this.look;
                if (c != '.') {
                    break;
                }
                i3++;
                GetChar();
            }
            boolean IsWhite2 = IsWhite(c);
            SkipWhite();
            SimpleRangePart parseSimpleRangePart3 = parseSimpleRangePart();
            String substring = this._formulaString.substring(i - 1, this._pointer - 1);
            if (parseSimpleRangePart3 == null) {
                if (parseSheetName != null) {
                    throw new FormulaParseException("Complete area reference expected after sheet name at index " + this._pointer + ".");
                }
                return parseNonRange(i);
            }
            if (IsWhite || IsWhite2) {
                if (parseSimpleRangePart.isRowOrColumn() || parseSimpleRangePart3.isRowOrColumn()) {
                    throw new FormulaParseException("Dotted range (full row or column) expression '" + substring + "' must not contain whitespace.");
                }
                return createAreaRefParseNode(parseSheetName, parseSimpleRangePart, parseSimpleRangePart3);
            }
            if (i3 == 1 && parseSimpleRangePart.isRow() && parseSimpleRangePart3.isRow()) {
                return parseNonRange(i);
            }
            if ((parseSimpleRangePart.isRowOrColumn() || parseSimpleRangePart3.isRowOrColumn()) && i3 != 2) {
                throw new FormulaParseException("Dotted range (full row or column) expression '" + substring + "' must have exactly 2 dots.");
            }
            return createAreaRefParseNode(parseSheetName, parseSimpleRangePart, parseSimpleRangePart3);
        }
        if (parseSimpleRangePart.isCell() && isValidCellReference(parseSimpleRangePart.getRep())) {
            return createAreaRefParseNode(parseSheetName, parseSimpleRangePart, null);
        }
        if (parseSheetName != null) {
            throw new FormulaParseException("Second part of cell reference expected after sheet name at index " + this._pointer + ".");
        }
        return parseNonRange(i);
    }

    private ParseNode parseNonRange(int i) {
        resetPointer(i);
        if (Character.isDigit(this.look)) {
            return new ParseNode(parseNumber());
        }
        if (this.look == '\"') {
            return new ParseNode(new StringPtg(parseStringLiteral()));
        }
        String parseAsName = parseAsName();
        if (this.look == '(') {
            return function(parseAsName);
        }
        if (parseAsName.equalsIgnoreCase("TRUE") || parseAsName.equalsIgnoreCase("FALSE")) {
            return new ParseNode(BoolPtg.valueOf(parseAsName.equalsIgnoreCase("TRUE")));
        }
        FormulaParsingWorkbook formulaParsingWorkbook = this._book;
        if (formulaParsingWorkbook == null) {
            throw new IllegalStateException("Need book to evaluate name '" + parseAsName + "'");
        }
        EvaluationName name = formulaParsingWorkbook.getName(parseAsName, this._sheetIndex);
        if (name == null) {
            throw new FormulaParseException("Specified named range '" + parseAsName + "' does not exist in the current workbook.");
        }
        if (name.isRange()) {
            return new ParseNode(name.createPtg());
        }
        throw new FormulaParseException("Specified name '" + parseAsName + "' is not a range as expected.");
    }

    private String parseAsName() {
        StringBuilder sb = new StringBuilder();
        if (!Character.isLetter(this.look) && this.look != '_') {
            throw expected("number, string, or defined name");
        }
        while (isValidDefinedNameChar(this.look)) {
            sb.append(this.look);
            GetChar();
        }
        SkipWhite();
        return sb.toString();
    }

    private static boolean isValidDefinedNameChar(char c) {
        return Character.isLetterOrDigit(c) || c == '.' || c == '?' || c == '\\' || c == '_';
    }

    private ParseNode createAreaRefParseNode(SheetIdentifier sheetIdentifier, SimpleRangePart simpleRangePart, SimpleRangePart simpleRangePart2) throws FormulaParseException {
        Ptg ptg;
        if (simpleRangePart2 == null) {
            CellReference cellReference = simpleRangePart.getCellReference();
            if (sheetIdentifier == null) {
                ptg = new RefPtg(cellReference);
            } else {
                ptg = this._book.get3DReferencePtg(cellReference, sheetIdentifier);
            }
        } else {
            AreaReference createAreaRef = createAreaRef(simpleRangePart, simpleRangePart2);
            if (sheetIdentifier == null) {
                ptg = new AreaPtg(createAreaRef);
            } else {
                ptg = this._book.get3DReferencePtg(createAreaRef, sheetIdentifier);
            }
        }
        return new ParseNode(ptg);
    }

    private static AreaReference createAreaRef(SimpleRangePart simpleRangePart, SimpleRangePart simpleRangePart2) {
        if (!simpleRangePart.isCompatibleForArea(simpleRangePart2)) {
            throw new FormulaParseException("has incompatible parts: '" + simpleRangePart.getRep() + "' and '" + simpleRangePart2.getRep() + "'.");
        }
        if (simpleRangePart.isRow()) {
            return AreaReference.getWholeRow(simpleRangePart.getRep(), simpleRangePart2.getRep());
        }
        if (simpleRangePart.isColumn()) {
            return AreaReference.getWholeColumn(simpleRangePart.getRep(), simpleRangePart2.getRep());
        }
        return new AreaReference(simpleRangePart.getCellReference(), simpleRangePart2.getCellReference());
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
    
        if (r5 <= r8._ssVersion.getMaxRows()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.poi.ss.formula.FormulaParser.SimpleRangePart parseSimpleRangePart() {
        /*
            r8 = this;
            int r0 = r8._pointer
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
        L6:
            int r4 = r8._formulaLength
            if (r0 >= r4) goto L2b
            java.lang.String r4 = r8._formulaString
            char r4 = r4.charAt(r0)
            boolean r5 = java.lang.Character.isDigit(r4)
            if (r5 == 0) goto L18
            r2 = r1
            goto L28
        L18:
            boolean r5 = java.lang.Character.isLetter(r4)
            if (r5 == 0) goto L20
            r3 = r1
            goto L28
        L20:
            r5 = 36
            if (r4 == r5) goto L28
            r5 = 95
            if (r4 != r5) goto L2b
        L28:
            int r0 = r0 + 1
            goto L6
        L2b:
            int r4 = r8._pointer
            int r5 = r4 + (-1)
            r6 = 0
            if (r0 > r5) goto L33
            return r6
        L33:
            java.lang.String r5 = r8._formulaString
            int r4 = r4 - r1
            java.lang.String r4 = r5.substring(r4, r0)
            java.util.regex.Pattern r5 = org.apache.poi.ss.formula.FormulaParser.CELL_REF_PATTERN
            java.util.regex.Matcher r5 = r5.matcher(r4)
            boolean r5 = r5.matches()
            if (r5 != 0) goto L47
            return r6
        L47:
            if (r3 == 0) goto L52
            if (r2 == 0) goto L52
            boolean r5 = r8.isValidCellReference(r4)
            if (r5 != 0) goto L7a
            return r6
        L52:
            java.lang.String r5 = ""
            java.lang.String r7 = "$"
            if (r3 == 0) goto L65
            java.lang.String r5 = r4.replace(r7, r5)
            org.apache.poi.ss.SpreadsheetVersion r7 = r8._ssVersion
            boolean r5 = org.apache.poi.ss.util.CellReference.isColumnWithnRange(r5, r7)
            if (r5 != 0) goto L7a
            return r6
        L65:
            if (r2 == 0) goto L84
            java.lang.String r5 = r4.replace(r7, r5)     // Catch: java.lang.NumberFormatException -> L84
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L84
            if (r5 < r1) goto L84
            org.apache.poi.ss.SpreadsheetVersion r7 = r8._ssVersion
            int r7 = r7.getMaxRows()
            if (r5 <= r7) goto L7a
            goto L84
        L7a:
            int r0 = r0 + r1
            r8.resetPointer(r0)
            org.apache.poi.ss.formula.FormulaParser$SimpleRangePart r0 = new org.apache.poi.ss.formula.FormulaParser$SimpleRangePart
            r0.<init>(r4, r3, r2)
            return r0
        L84:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.FormulaParser.parseSimpleRangePart():org.apache.poi.ss.formula.FormulaParser$SimpleRangePart");
    }

    private static final class SimpleRangePart {
        private final String _rep;
        private final Type _type;

        private enum Type {
            CELL,
            ROW,
            COLUMN;

            public static Type get(boolean z, boolean z2) {
                if (z) {
                    return z2 ? CELL : COLUMN;
                }
                if (!z2) {
                    throw new IllegalArgumentException("must have either letters or numbers");
                }
                return ROW;
            }
        }

        public SimpleRangePart(String str, boolean z, boolean z2) {
            this._rep = str;
            this._type = Type.get(z, z2);
        }

        public boolean isCell() {
            return this._type == Type.CELL;
        }

        public boolean isRowOrColumn() {
            return this._type != Type.CELL;
        }

        public CellReference getCellReference() {
            if (this._type != Type.CELL) {
                throw new IllegalStateException("Not applicable to this type");
            }
            return new CellReference(this._rep);
        }

        public boolean isColumn() {
            return this._type == Type.COLUMN;
        }

        public boolean isRow() {
            return this._type == Type.ROW;
        }

        public String getRep() {
            return this._rep;
        }

        public boolean isCompatibleForArea(SimpleRangePart simpleRangePart) {
            return this._type == simpleRangePart._type;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append(getClass().getName()).append(" [");
            sb.append(this._rep);
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r10.look == '\'') goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
    
        if (r7 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        r2.append(r10.look);
        GetChar();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r10.look != '\'') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        Match('\'');
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r10.look == '\'') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r5 = new org.apache.poi.ss.formula.NameIdentifier(r2.toString(), true);
        SkipWhite();
        r2 = r10.look;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        if (r2 != '!') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        GetChar();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        return new org.apache.poi.ss.formula.SheetIdentifier(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
    
        if (r2 != ':') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
    
        return parseSheetRange(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0040, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0053 -> B:12:0x003d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.poi.ss.formula.SheetIdentifier parseSheetName() {
        /*
            r10 = this;
            char r0 = r10.look
            r1 = 0
            r2 = 91
            if (r0 != r2) goto L24
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r10.GetChar()
        Lf:
            char r2 = r10.look
            r3 = 93
            if (r2 == r3) goto L1c
            r0.append(r2)
            r10.GetChar()
            goto Lf
        L1c:
            r10.GetChar()
            java.lang.String r0 = r0.toString()
            goto L25
        L24:
            r0 = r1
        L25:
            char r2 = r10.look
            r3 = 58
            r4 = 33
            r5 = 0
            r6 = 39
            if (r2 != r6) goto L77
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r10.Match(r6)
            char r7 = r10.look
            r8 = 1
            if (r7 != r6) goto L3f
        L3d:
            r7 = r8
            goto L40
        L3f:
            r7 = r5
        L40:
            if (r7 != 0) goto L56
            char r9 = r10.look
            r2.append(r9)
            r10.GetChar()
            char r9 = r10.look
            if (r9 != r6) goto L40
            r10.Match(r6)
            char r7 = r10.look
            if (r7 == r6) goto L3f
            goto L3d
        L56:
            org.apache.poi.ss.formula.NameIdentifier r5 = new org.apache.poi.ss.formula.NameIdentifier
            java.lang.String r2 = r2.toString()
            r5.<init>(r2, r8)
            r10.SkipWhite()
            char r2 = r10.look
            if (r2 != r4) goto L6f
            r10.GetChar()
            org.apache.poi.ss.formula.SheetIdentifier r1 = new org.apache.poi.ss.formula.SheetIdentifier
            r1.<init>(r0, r5)
            return r1
        L6f:
            if (r2 != r3) goto L76
            org.apache.poi.ss.formula.SheetIdentifier r0 = r10.parseSheetRange(r0, r5)
            return r0
        L76:
            return r1
        L77:
            r6 = 95
            if (r2 == r6) goto L92
            boolean r2 = java.lang.Character.isLetter(r2)
            if (r2 == 0) goto L82
            goto L92
        L82:
            char r2 = r10.look
            if (r2 != r4) goto L91
            if (r0 == 0) goto L91
            r10.GetChar()
            org.apache.poi.ss.formula.SheetIdentifier r2 = new org.apache.poi.ss.formula.SheetIdentifier
            r2.<init>(r0, r1)
            return r2
        L91:
            return r1
        L92:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L97:
            char r6 = r10.look
            boolean r6 = isUnquotedSheetNameChar(r6)
            if (r6 == 0) goto La8
            char r6 = r10.look
            r2.append(r6)
            r10.GetChar()
            goto L97
        La8:
            org.apache.poi.ss.formula.NameIdentifier r6 = new org.apache.poi.ss.formula.NameIdentifier
            java.lang.String r2 = r2.toString()
            r6.<init>(r2, r5)
            r10.SkipWhite()
            char r2 = r10.look
            if (r2 != r4) goto Lc1
            r10.GetChar()
            org.apache.poi.ss.formula.SheetIdentifier r1 = new org.apache.poi.ss.formula.SheetIdentifier
            r1.<init>(r0, r6)
            return r1
        Lc1:
            if (r2 != r3) goto Lc8
            org.apache.poi.ss.formula.SheetIdentifier r0 = r10.parseSheetRange(r0, r6)
            return r0
        Lc8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.FormulaParser.parseSheetName():org.apache.poi.ss.formula.SheetIdentifier");
    }

    private SheetIdentifier parseSheetRange(String str, NameIdentifier nameIdentifier) {
        GetChar();
        SheetIdentifier parseSheetName = parseSheetName();
        if (parseSheetName != null) {
            return new SheetRangeIdentifier(str, nameIdentifier, parseSheetName.getSheetIdentifier());
        }
        return null;
    }

    private static boolean isUnquotedSheetNameChar(char c) {
        return Character.isLetterOrDigit(c) || c == '.' || c == '_';
    }

    private boolean isValidCellReference(String str) {
        boolean z = CellReference.classifyCellReference(str, this._ssVersion) == CellReference.NameType.CELL;
        if (!z) {
            return z;
        }
        if (!(FunctionMetadataRegistry.getFunctionByName(str.toUpperCase()) != null)) {
            return z;
        }
        int i = this._pointer;
        resetPointer(str.length() + i);
        SkipWhite();
        boolean z2 = this.look != '(';
        resetPointer(i);
        return z2;
    }

    private ParseNode function(String str) {
        Ptg ptg = null;
        if (!AbstractFunctionPtg.isBuiltInFunctionName(str)) {
            FormulaParsingWorkbook formulaParsingWorkbook = this._book;
            if (formulaParsingWorkbook == null) {
                throw new IllegalStateException("Need book to evaluate name '" + str + "'");
            }
            EvaluationName name = formulaParsingWorkbook.getName(str, this._sheetIndex);
            if (name == null) {
                ptg = this._book.getNameXPtg(str, null);
                if (ptg == null) {
                    throw new FormulaParseException("Name '" + str + "' is completely unknown in the current workbook");
                }
            } else {
                if (!name.isFunctionName()) {
                    throw new FormulaParseException("Attempt to use name '" + str + "' as a function, but defined name in workbook does not refer to a function");
                }
                ptg = name.createPtg();
            }
        }
        Match(PropertyUtils.MAPPED_DELIM);
        ParseNode[] Arguments = Arguments();
        Match(PropertyUtils.MAPPED_DELIM2);
        return getFunction(str, ptg, Arguments);
    }

    private ParseNode getFunction(String str, Ptg ptg, ParseNode[] parseNodeArr) {
        Ptg create;
        FunctionMetadata functionByName = FunctionMetadataRegistry.getFunctionByName(str.toUpperCase());
        int length = parseNodeArr.length;
        if (functionByName == null) {
            if (ptg == null) {
                throw new IllegalStateException("NamePtg must be supplied for external functions");
            }
            int i = length + 1;
            ParseNode[] parseNodeArr2 = new ParseNode[i];
            parseNodeArr2[0] = new ParseNode(ptg);
            System.arraycopy(parseNodeArr, 0, parseNodeArr2, 1, length);
            return new ParseNode(FuncVarPtg.create(str, i), parseNodeArr2);
        }
        if (ptg != null) {
            throw new IllegalStateException("NamePtg no applicable to internal functions");
        }
        boolean z = !functionByName.hasFixedArgsLength();
        int index = functionByName.getIndex();
        if (index == 4 && parseNodeArr.length == 1) {
            return new ParseNode(AttrPtg.getSumSingle(), parseNodeArr);
        }
        validateNumArgs(parseNodeArr.length, functionByName);
        if (z) {
            create = FuncVarPtg.create(str, length);
        } else {
            create = FuncPtg.create(index);
        }
        return new ParseNode(create, parseNodeArr);
    }

    private void validateNumArgs(int i, FunctionMetadata functionMetadata) {
        int maxParams;
        String str;
        String str2;
        if (i < functionMetadata.getMinParams()) {
            String str3 = "Too few arguments to function '" + functionMetadata.getName() + "'. ";
            if (functionMetadata.hasFixedArgsLength()) {
                str2 = str3 + "Expected " + functionMetadata.getMinParams();
            } else {
                str2 = str3 + "At least " + functionMetadata.getMinParams() + " were expected";
            }
            throw new FormulaParseException(str2 + " but got " + i + ".");
        }
        if (functionMetadata.hasUnlimitedVarags()) {
            FormulaParsingWorkbook formulaParsingWorkbook = this._book;
            if (formulaParsingWorkbook != null) {
                maxParams = formulaParsingWorkbook.getSpreadsheetVersion().getMaxFunctionArgs();
            } else {
                maxParams = functionMetadata.getMaxParams();
            }
        } else {
            maxParams = functionMetadata.getMaxParams();
        }
        if (i > maxParams) {
            String str4 = "Too many arguments to function '" + functionMetadata.getName() + "'. ";
            if (functionMetadata.hasFixedArgsLength()) {
                str = str4 + "Expected " + maxParams;
            } else {
                str = str4 + "At most " + maxParams + " were expected";
            }
            throw new FormulaParseException(str + " but got " + i + ".");
        }
    }

    private ParseNode[] Arguments() {
        ArrayList arrayList = new ArrayList(2);
        SkipWhite();
        if (this.look == ')') {
            return ParseNode.EMPTY_ARRAY;
        }
        while (true) {
            boolean z = true;
            do {
                SkipWhite();
                if (isArgumentDelimiter(this.look)) {
                    if (z) {
                        arrayList.add(new ParseNode(MissingArgPtg.instance));
                    }
                    if (this.look != ')') {
                        Match(',');
                    } else {
                        ParseNode[] parseNodeArr = new ParseNode[arrayList.size()];
                        arrayList.toArray(parseNodeArr);
                        return parseNodeArr;
                    }
                } else {
                    arrayList.add(comparisonExpression());
                    z = false;
                    SkipWhite();
                }
            } while (isArgumentDelimiter(this.look));
            throw expected("',' or ')'");
        }
    }

    private ParseNode powerFactor() {
        ParseNode percentFactor = percentFactor();
        while (true) {
            SkipWhite();
            if (this.look != '^') {
                return percentFactor;
            }
            Match('^');
            percentFactor = new ParseNode(PowerPtg.instance, percentFactor, percentFactor());
        }
    }

    private ParseNode percentFactor() {
        ParseNode parseSimpleFactor = parseSimpleFactor();
        while (true) {
            SkipWhite();
            if (this.look != '%') {
                return parseSimpleFactor;
            }
            Match('%');
            parseSimpleFactor = new ParseNode(PercentPtg.instance, parseSimpleFactor);
        }
    }

    private ParseNode parseSimpleFactor() {
        char c;
        SkipWhite();
        char c2 = this.look;
        if (c2 == '\"') {
            return new ParseNode(new StringPtg(parseStringLiteral()));
        }
        if (c2 == '#') {
            return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
        }
        if (c2 == '(') {
            Match(PropertyUtils.MAPPED_DELIM);
            ParseNode comparisonExpression = comparisonExpression();
            Match(PropertyUtils.MAPPED_DELIM2);
            return new ParseNode(ParenthesisPtg.instance, comparisonExpression);
        }
        if (c2 == '+') {
            Match('+');
            return parseUnary(true);
        }
        if (c2 == '-') {
            Match(NameUtil.HYPHEN);
            return parseUnary(false);
        }
        if (c2 == '{') {
            Match('{');
            ParseNode parseArray = parseArray();
            Match('}');
            return parseArray;
        }
        if (IsAlpha(c2) || Character.isDigit(this.look) || (c = this.look) == '\'' || c == '[') {
            return parseRangeExpression();
        }
        if (c == '.') {
            return new ParseNode(parseNumber());
        }
        throw expected("cell ref or constant literal");
    }

    private ParseNode parseUnary(boolean z) {
        boolean z2 = IsDigit(this.look) || this.look == '.';
        ParseNode powerFactor = powerFactor();
        if (z2) {
            Ptg token = powerFactor.getToken();
            if (token instanceof NumberPtg) {
                return z ? powerFactor : new ParseNode(new NumberPtg(-((NumberPtg) token).getValue()));
            }
            if (token instanceof IntPtg) {
                return z ? powerFactor : new ParseNode(new NumberPtg(-((IntPtg) token).getValue()));
            }
        }
        return new ParseNode(z ? UnaryPlusPtg.instance : UnaryMinusPtg.instance, powerFactor);
    }

    private ParseNode parseArray() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(parseArrayRow());
            char c = this.look;
            if (c == '}') {
                Object[][] objArr = new Object[arrayList.size()][];
                arrayList.toArray(objArr);
                checkRowLengths(objArr, objArr[0].length);
                return new ParseNode(new ArrayPtg(objArr));
            }
            if (c != ';') {
                throw expected("'}' or ';'");
            }
            Match(';');
        }
    }

    private void checkRowLengths(Object[][] objArr, int i) {
        for (int i2 = 0; i2 < objArr.length; i2++) {
            int length = objArr[i2].length;
            if (length != i) {
                throw new FormulaParseException("Array row " + i2 + " has length " + length + " but row 0 has length " + i);
            }
        }
    }

    private Object[] parseArrayRow() {
        char c;
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(parseArrayItem());
            SkipWhite();
            c = this.look;
            if (c != ',') {
                break;
            }
            Match(',');
        }
        if (c != ';' && c != '}') {
            throw expected("'}' or ','");
        }
        Object[] objArr = new Object[arrayList.size()];
        arrayList.toArray(objArr);
        return objArr;
    }

    private Object parseArrayItem() {
        SkipWhite();
        char c = this.look;
        if (c == '\"') {
            return parseStringLiteral();
        }
        if (c == '#') {
            return ErrorConstant.valueOf(parseErrorLiteral());
        }
        if (c == '-') {
            Match(NameUtil.HYPHEN);
            SkipWhite();
            return convertArrayNumber(parseNumber(), false);
        }
        if (c == 'F' || c == 'T' || c == 'f' || c == 't') {
            return parseBooleanLiteral();
        }
        return convertArrayNumber(parseNumber(), true);
    }

    private Boolean parseBooleanLiteral() {
        String parseUnquotedIdentifier = parseUnquotedIdentifier();
        if ("TRUE".equalsIgnoreCase(parseUnquotedIdentifier)) {
            return Boolean.TRUE;
        }
        if ("FALSE".equalsIgnoreCase(parseUnquotedIdentifier)) {
            return Boolean.FALSE;
        }
        throw expected("'TRUE' or 'FALSE'");
    }

    private static Double convertArrayNumber(Ptg ptg, boolean z) {
        double value;
        if (ptg instanceof IntPtg) {
            value = ((IntPtg) ptg).getValue();
        } else if (ptg instanceof NumberPtg) {
            value = ((NumberPtg) ptg).getValue();
        } else {
            throw new RuntimeException("Unexpected ptg (" + ptg.getClass().getName() + ")");
        }
        if (!z) {
            value = -value;
        }
        return new Double(value);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.poi.ss.formula.ptg.Ptg parseNumber() {
        /*
            r6 = this;
            java.lang.String r0 = r6.GetNum()
            char r1 = r6.look
            r2 = 0
            r3 = 46
            if (r1 != r3) goto L13
            r6.GetChar()
            java.lang.String r1 = r6.GetNum()
            goto L14
        L13:
            r1 = r2
        L14:
            char r3 = r6.look
            r4 = 69
            java.lang.String r5 = "Integer"
            if (r3 != r4) goto L52
            r6.GetChar()
            char r2 = r6.look
            r3 = 43
            if (r2 != r3) goto L29
            r6.GetChar()
            goto L33
        L29:
            r3 = 45
            if (r2 != r3) goto L33
            r6.GetChar()
            java.lang.String r2 = "-"
            goto L35
        L33:
            java.lang.String r2 = ""
        L35:
            java.lang.String r3 = r6.GetNum()
            if (r3 == 0) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L52
        L4d:
            java.lang.RuntimeException r0 = r6.expected(r5)
            throw r0
        L52:
            if (r0 != 0) goto L5c
            if (r1 == 0) goto L57
            goto L5c
        L57:
            java.lang.RuntimeException r0 = r6.expected(r5)
            throw r0
        L5c:
            org.apache.poi.ss.formula.ptg.Ptg r0 = getNumberPtgFromString(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.FormulaParser.parseNumber():org.apache.poi.ss.formula.ptg.Ptg");
    }

    private int parseErrorLiteral() {
        Match('#');
        String upperCase = parseUnquotedIdentifier().toUpperCase();
        if (upperCase == null) {
            throw expected("remainder of error constant literal");
        }
        char charAt = upperCase.charAt(0);
        if (charAt == 'D') {
            if (upperCase.equals("DIV")) {
                Match('/');
                Match('0');
                Match('!');
                return 7;
            }
            throw expected("#DIV/0!");
        }
        if (charAt != 'N') {
            if (charAt == 'R') {
                if (upperCase.equals("REF")) {
                    Match('!');
                    return 23;
                }
                throw expected("#REF!");
            }
            if (charAt == 'V') {
                if (upperCase.equals("VALUE")) {
                    Match('!');
                    return 15;
                }
                throw expected("#VALUE!");
            }
            throw expected("#VALUE!, #REF!, #DIV/0!, #NAME?, #NUM!, #NULL! or #N/A");
        }
        if (upperCase.equals("NAME")) {
            Match('?');
            return 29;
        }
        if (upperCase.equals("NUM")) {
            Match('!');
            return 36;
        }
        if (upperCase.equals("NULL")) {
            Match('!');
            return 0;
        }
        if (upperCase.equals("N")) {
            Match('/');
            char c = this.look;
            if (c != 'A' && c != 'a') {
                throw expected("#N/A");
            }
            Match(c);
            return 42;
        }
        throw expected("#NAME?, #NUM!, #NULL! or #N/A");
    }

    private String parseUnquotedIdentifier() {
        if (this.look == '\'') {
            throw expected("unquoted identifier");
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!Character.isLetterOrDigit(this.look) && this.look != '.') {
                break;
            }
            sb.append(this.look);
            GetChar();
        }
        if (sb.length() < 1) {
            return null;
        }
        return sb.toString();
    }

    private static Ptg getNumberPtgFromString(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str2 == null) {
            stringBuffer.append(str);
            if (str3 != null) {
                stringBuffer.append('E');
                stringBuffer.append(str3);
            }
            String stringBuffer2 = stringBuffer.toString();
            try {
                int parseInt = Integer.parseInt(stringBuffer2);
                if (IntPtg.isInRange(parseInt)) {
                    return new IntPtg(parseInt);
                }
                return new NumberPtg(stringBuffer2);
            } catch (NumberFormatException unused) {
                return new NumberPtg(stringBuffer2);
            }
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append('.');
        stringBuffer.append(str2);
        if (str3 != null) {
            stringBuffer.append('E');
            stringBuffer.append(str3);
        }
        return new NumberPtg(stringBuffer.toString());
    }

    private String parseStringLiteral() {
        Match('\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            if (this.look == '\"') {
                GetChar();
                if (this.look != '\"') {
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(this.look);
            GetChar();
        }
    }

    private ParseNode Term() {
        ValueOperatorPtg valueOperatorPtg;
        ParseNode powerFactor = powerFactor();
        while (true) {
            SkipWhite();
            char c = this.look;
            if (c == '*') {
                Match('*');
                valueOperatorPtg = MultiplyPtg.instance;
            } else {
                if (c != '/') {
                    return powerFactor;
                }
                Match('/');
                valueOperatorPtg = DividePtg.instance;
            }
            powerFactor = new ParseNode(valueOperatorPtg, powerFactor, powerFactor());
        }
    }

    private ParseNode unionExpression() {
        ParseNode comparisonExpression = comparisonExpression();
        boolean z = false;
        while (true) {
            SkipWhite();
            if (this.look != ',') {
                break;
            }
            GetChar();
            z = true;
            comparisonExpression = new ParseNode(UnionPtg.instance, comparisonExpression, comparisonExpression());
        }
        return z ? augmentWithMemPtg(comparisonExpression) : comparisonExpression;
    }

    private ParseNode comparisonExpression() {
        ParseNode concatExpression = concatExpression();
        while (true) {
            SkipWhite();
            switch (this.look) {
                case '<':
                case '=':
                case '>':
                    concatExpression = new ParseNode(getComparisonToken(), concatExpression, concatExpression());
                default:
                    return concatExpression;
            }
        }
    }

    private Ptg getComparisonToken() {
        char c = this.look;
        if (c == '=') {
            Match(c);
            return EqualPtg.instance;
        }
        boolean z = c == '>';
        Match(c);
        if (z) {
            if (this.look == '=') {
                Match('=');
                return GreaterEqualPtg.instance;
            }
            return GreaterThanPtg.instance;
        }
        char c2 = this.look;
        if (c2 == '=') {
            Match('=');
            return LessEqualPtg.instance;
        }
        if (c2 == '>') {
            Match(Typography.greater);
            return NotEqualPtg.instance;
        }
        return LessThanPtg.instance;
    }

    private ParseNode concatExpression() {
        ParseNode additiveExpression = additiveExpression();
        while (true) {
            SkipWhite();
            if (this.look != '&') {
                return additiveExpression;
            }
            Match(Typography.amp);
            additiveExpression = new ParseNode(ConcatPtg.instance, additiveExpression, additiveExpression());
        }
    }

    private ParseNode additiveExpression() {
        ValueOperatorPtg valueOperatorPtg;
        ParseNode Term = Term();
        while (true) {
            SkipWhite();
            char c = this.look;
            if (c == '+') {
                Match('+');
                valueOperatorPtg = AddPtg.instance;
            } else {
                if (c != '-') {
                    return Term;
                }
                Match(NameUtil.HYPHEN);
                valueOperatorPtg = SubtractPtg.instance;
            }
            Term = new ParseNode(valueOperatorPtg, Term, Term());
        }
    }

    private void parse() {
        this._pointer = 0;
        GetChar();
        this._rootNode = unionExpression();
        if (this._pointer <= this._formulaLength) {
            throw new FormulaParseException("Unused input [" + this._formulaString.substring(this._pointer - 1) + "] after attempting to parse the formula [" + this._formulaString + "]");
        }
    }

    private Ptg[] getRPNPtg(int i) {
        new OperandClassTransformer(i).transformFormula(this._rootNode);
        return ParseNode.toTokenArray(this._rootNode);
    }
}
