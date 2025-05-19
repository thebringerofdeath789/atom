package jxl.biff.formula;

/* loaded from: classes4.dex */
class Equal extends BinaryOperator implements ParsedThing {
    @Override // jxl.biff.formula.Operator
    int getPrecedence() {
        return 5;
    }

    @Override // jxl.biff.formula.BinaryOperator
    public String getSymbol() {
        return "=";
    }

    @Override // jxl.biff.formula.BinaryOperator
    Token getToken() {
        return Token.EQUAL;
    }
}
