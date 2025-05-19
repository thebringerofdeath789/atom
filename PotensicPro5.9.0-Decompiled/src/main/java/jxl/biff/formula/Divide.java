package jxl.biff.formula;

import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
class Divide extends BinaryOperator implements ParsedThing {
    @Override // jxl.biff.formula.Operator
    int getPrecedence() {
        return 3;
    }

    @Override // jxl.biff.formula.BinaryOperator
    public String getSymbol() {
        return InternalZipConstants.ZIP_FILE_SEPARATOR;
    }

    @Override // jxl.biff.formula.BinaryOperator
    Token getToken() {
        return Token.DIVIDE;
    }
}
