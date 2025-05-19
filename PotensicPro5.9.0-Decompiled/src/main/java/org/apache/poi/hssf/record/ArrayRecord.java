package org.apache.poi.hssf.record;

import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ArrayRecord extends SharedValueRecordBase {
    private static final int OPT_ALWAYS_RECALCULATE = 1;
    private static final int OPT_CALCULATE_ON_OPEN = 2;
    public static final short sid = 545;
    private int _field3notUsed;
    private Formula _formula;
    private int _options;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ArrayRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this._options = recordInputStream.readUShort();
        this._field3notUsed = recordInputStream.readInt();
        this._formula = Formula.read(recordInputStream.readUShort(), recordInputStream, recordInputStream.available());
    }

    public ArrayRecord(Formula formula, CellRangeAddress8Bit cellRangeAddress8Bit) {
        super(cellRangeAddress8Bit);
        this._options = 0;
        this._field3notUsed = 0;
        this._formula = formula;
    }

    public boolean isAlwaysRecalculate() {
        return (this._options & 1) != 0;
    }

    public boolean isCalculateOnOpen() {
        return (this._options & 2) != 0;
    }

    public Ptg[] getFormulaTokens() {
        return this._formula.getTokens();
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected int getExtraDataSize() {
        return this._formula.getEncodedSize() + 6;
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected void serializeExtraData(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
        littleEndianOutput.writeInt(this._field3notUsed);
        this._formula.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName()).append(" [ARRAY]\n");
        stringBuffer.append(" range=").append(getRange().toString()).append("\n");
        stringBuffer.append(" options=").append(HexDump.shortToHex(this._options)).append("\n");
        stringBuffer.append(" notUsed=").append(HexDump.intToHex(this._field3notUsed)).append("\n");
        stringBuffer.append(" formula:").append("\n");
        for (Ptg ptg : this._formula.getTokens()) {
            stringBuffer.append(ptg.toString()).append(ptg.getRVAType()).append("\n");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        ArrayRecord arrayRecord = new ArrayRecord(this._formula.copy(), getRange());
        arrayRecord._options = this._options;
        arrayRecord._field3notUsed = this._field3notUsed;
        return arrayRecord;
    }
}
