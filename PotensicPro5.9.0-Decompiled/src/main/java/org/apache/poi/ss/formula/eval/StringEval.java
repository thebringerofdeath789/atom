package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.StringPtg;

/* loaded from: classes5.dex */
public final class StringEval implements StringValueEval {
    public static final StringEval EMPTY_INSTANCE = new StringEval("");
    private final String _value;

    public StringEval(Ptg ptg) {
        this(((StringPtg) ptg).getValue());
    }

    public StringEval(String str) {
        if (str == null) {
            throw new IllegalArgumentException("value must not be null");
        }
        this._value = str;
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        return this._value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName()).append(" [");
        sb.append(this._value);
        sb.append("]");
        return sb.toString();
    }
}
