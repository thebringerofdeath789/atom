package org.apache.poi.ss.formula.eval;

/* loaded from: classes5.dex */
public final class FunctionNameEval implements ValueEval {
    private final String _functionName;

    public FunctionNameEval(String str) {
        this._functionName = str;
    }

    public String getFunctionName() {
        return this._functionName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(this._functionName);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
