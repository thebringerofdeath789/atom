package org.apache.poi.ss.formula.eval;

/* loaded from: classes5.dex */
public final class BoolEval implements NumericValueEval, StringValueEval {
    public static final BoolEval FALSE = new BoolEval(false);
    public static final BoolEval TRUE = new BoolEval(true);
    private boolean _value;

    public static final BoolEval valueOf(boolean z) {
        return z ? TRUE : FALSE;
    }

    private BoolEval(boolean z) {
        this._value = z;
    }

    public boolean getBooleanValue() {
        return this._value;
    }

    @Override // org.apache.poi.ss.formula.eval.NumericValueEval
    public double getNumberValue() {
        return this._value ? 1.0d : 0.0d;
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        return this._value ? "TRUE" : "FALSE";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName()).append(" [");
        sb.append(getStringValue());
        sb.append("]");
        return sb.toString();
    }
}
