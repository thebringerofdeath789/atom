package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.EvaluationName;

/* loaded from: classes5.dex */
public final class ExternalNameEval implements ValueEval {
    private final EvaluationName _name;

    public ExternalNameEval(EvaluationName evaluationName) {
        this._name = evaluationName;
    }

    public EvaluationName getName() {
        return this._name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(this._name.getNameText());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
