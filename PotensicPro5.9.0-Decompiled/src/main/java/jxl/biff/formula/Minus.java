package jxl.biff.formula;

/* loaded from: classes4.dex */
class Minus extends StringOperator {
    @Override // jxl.biff.formula.StringOperator
    Operator getBinaryOperator() {
        return new Subtract();
    }

    @Override // jxl.biff.formula.StringOperator
    Operator getUnaryOperator() {
        return new UnaryMinus();
    }
}
