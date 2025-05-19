package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* loaded from: classes5.dex */
final class ParseNode {
    public static final ParseNode[] EMPTY_ARRAY = new ParseNode[0];
    private final ParseNode[] _children;
    private boolean _isIf;
    private final Ptg _token;
    private final int _tokenCount;

    public ParseNode(Ptg ptg, ParseNode[] parseNodeArr) {
        if (ptg == null) {
            throw new IllegalArgumentException("token must not be null");
        }
        this._token = ptg;
        this._children = parseNodeArr;
        this._isIf = isIf(ptg);
        int i = 1;
        for (ParseNode parseNode : parseNodeArr) {
            i += parseNode.getTokenCount();
        }
        this._tokenCount = this._isIf ? i + parseNodeArr.length : i;
    }

    public ParseNode(Ptg ptg) {
        this(ptg, EMPTY_ARRAY);
    }

    public ParseNode(Ptg ptg, ParseNode parseNode) {
        this(ptg, new ParseNode[]{parseNode});
    }

    public ParseNode(Ptg ptg, ParseNode parseNode, ParseNode parseNode2) {
        this(ptg, new ParseNode[]{parseNode, parseNode2});
    }

    private int getTokenCount() {
        return this._tokenCount;
    }

    public int getEncodedSize() {
        Ptg ptg = this._token;
        int size = ptg instanceof ArrayPtg ? 8 : ptg.getSize();
        int i = 0;
        while (true) {
            ParseNode[] parseNodeArr = this._children;
            if (i >= parseNodeArr.length) {
                return size;
            }
            size += parseNodeArr[i].getEncodedSize();
            i++;
        }
    }

    public static Ptg[] toTokenArray(ParseNode parseNode) {
        TokenCollector tokenCollector = new TokenCollector(parseNode.getTokenCount());
        parseNode.collectPtgs(tokenCollector);
        return tokenCollector.getResult();
    }

    private void collectPtgs(TokenCollector tokenCollector) {
        if (isIf(this._token)) {
            collectIfPtgs(tokenCollector);
            return;
        }
        Ptg ptg = this._token;
        boolean z = (ptg instanceof MemFuncPtg) || (ptg instanceof MemAreaPtg);
        if (z) {
            tokenCollector.add(ptg);
        }
        for (int i = 0; i < getChildren().length; i++) {
            getChildren()[i].collectPtgs(tokenCollector);
        }
        if (z) {
            return;
        }
        tokenCollector.add(this._token);
    }

    private void collectIfPtgs(TokenCollector tokenCollector) {
        getChildren()[0].collectPtgs(tokenCollector);
        int createPlaceholder = tokenCollector.createPlaceholder();
        getChildren()[1].collectPtgs(tokenCollector);
        int createPlaceholder2 = tokenCollector.createPlaceholder();
        AttrPtg createIf = AttrPtg.createIf(tokenCollector.sumTokenSizes(createPlaceholder + 1, createPlaceholder2) + 4);
        if (getChildren().length > 2) {
            getChildren()[2].collectPtgs(tokenCollector);
            int createPlaceholder3 = tokenCollector.createPlaceholder();
            AttrPtg createSkip = AttrPtg.createSkip(((tokenCollector.sumTokenSizes(createPlaceholder2 + 1, createPlaceholder3) + 4) + 4) - 1);
            AttrPtg createSkip2 = AttrPtg.createSkip(3);
            tokenCollector.setPlaceholder(createPlaceholder, createIf);
            tokenCollector.setPlaceholder(createPlaceholder2, createSkip);
            tokenCollector.setPlaceholder(createPlaceholder3, createSkip2);
        } else {
            AttrPtg createSkip3 = AttrPtg.createSkip(3);
            tokenCollector.setPlaceholder(createPlaceholder, createIf);
            tokenCollector.setPlaceholder(createPlaceholder2, createSkip3);
        }
        tokenCollector.add(this._token);
    }

    private static boolean isIf(Ptg ptg) {
        return (ptg instanceof FuncVarPtg) && "IF".equals(((FuncVarPtg) ptg).getName());
    }

    public Ptg getToken() {
        return this._token;
    }

    public ParseNode[] getChildren() {
        return this._children;
    }

    private static final class TokenCollector {
        private int _offset = 0;
        private final Ptg[] _ptgs;

        public TokenCollector(int i) {
            this._ptgs = new Ptg[i];
        }

        public int sumTokenSizes(int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                i3 += this._ptgs[i].getSize();
                i++;
            }
            return i3;
        }

        public int createPlaceholder() {
            int i = this._offset;
            this._offset = i + 1;
            return i;
        }

        public void add(Ptg ptg) {
            if (ptg == null) {
                throw new IllegalArgumentException("token must not be null");
            }
            Ptg[] ptgArr = this._ptgs;
            int i = this._offset;
            ptgArr[i] = ptg;
            this._offset = i + 1;
        }

        public void setPlaceholder(int i, Ptg ptg) {
            Ptg[] ptgArr = this._ptgs;
            if (ptgArr[i] != null) {
                throw new IllegalStateException("Invalid placeholder index (" + i + ")");
            }
            ptgArr[i] = ptg;
        }

        public Ptg[] getResult() {
            return this._ptgs;
        }
    }
}
