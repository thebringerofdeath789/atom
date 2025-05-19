package jxl.biff.formula;

/* loaded from: classes4.dex */
abstract class NumberValue extends Operand implements ParsedThing {
    public abstract double getValue();

    protected NumberValue() {
    }

    @Override // jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        stringBuffer.append(Double.toString(getValue()));
    }
}
