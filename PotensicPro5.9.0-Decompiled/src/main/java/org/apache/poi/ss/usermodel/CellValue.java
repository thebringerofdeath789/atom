package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.formula.eval.ErrorEval;

/* loaded from: classes5.dex */
public final class CellValue {
    private final boolean _booleanValue;
    private final int _cellType;
    private final int _errorCode;
    private final double _numberValue;
    private final String _textValue;
    public static final CellValue TRUE = new CellValue(4, 0.0d, true, null, 0);
    public static final CellValue FALSE = new CellValue(4, 0.0d, false, null, 0);

    private CellValue(int i, double d, boolean z, String str, int i2) {
        this._cellType = i;
        this._numberValue = d;
        this._booleanValue = z;
        this._textValue = str;
        this._errorCode = i2;
    }

    public CellValue(double d) {
        this(0, d, false, null, 0);
    }

    public static CellValue valueOf(boolean z) {
        return z ? TRUE : FALSE;
    }

    public CellValue(String str) {
        this(1, 0.0d, false, str, 0);
    }

    public static CellValue getError(int i) {
        return new CellValue(5, 0.0d, false, null, i);
    }

    public boolean getBooleanValue() {
        return this._booleanValue;
    }

    public double getNumberValue() {
        return this._numberValue;
    }

    public String getStringValue() {
        return this._textValue;
    }

    public int getCellType() {
        return this._cellType;
    }

    public byte getErrorValue() {
        return (byte) this._errorCode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(formatAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public String formatAsString() {
        int i = this._cellType;
        if (i == 0) {
            return String.valueOf(this._numberValue);
        }
        if (i == 1) {
            return '\"' + this._textValue + '\"';
        }
        if (i == 4) {
            return this._booleanValue ? "TRUE" : "FALSE";
        }
        if (i == 5) {
            return ErrorEval.getText(this._errorCode);
        }
        return "<error unexpected cell type " + this._cellType + ">";
    }
}
