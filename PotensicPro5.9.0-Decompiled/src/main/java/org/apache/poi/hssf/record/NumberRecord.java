package org.apache.poi.hssf.record;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class NumberRecord extends CellRecord {
    public static final short sid = 515;
    private double field_4_value;

    @Override // org.apache.poi.hssf.record.CellRecord
    protected String getRecordName() {
        return "NUMBER";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 515;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected int getValueDataSize() {
        return 8;
    }

    public NumberRecord() {
    }

    public NumberRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this.field_4_value = recordInputStream.readDouble();
    }

    public void setValue(double d) {
        this.field_4_value = d;
    }

    public double getValue() {
        return this.field_4_value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void appendValueText(StringBuilder sb) {
        sb.append("  .value= ").append(NumberToTextConverter.toText(this.field_4_value));
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeDouble(getValue());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        NumberRecord numberRecord = new NumberRecord();
        copyBaseFields(numberRecord);
        numberRecord.field_4_value = this.field_4_value;
        return numberRecord;
    }
}
