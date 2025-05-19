package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class CRNCountRecord extends StandardRecord {
    private static final short DATA_SIZE = 4;
    public static final short sid = 89;
    private int field_1_number_crn_records;
    private int field_2_sheet_table_index;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 89;
    }

    public CRNCountRecord() {
        throw new RuntimeException("incomplete code");
    }

    public int getNumberOfCRNs() {
        return this.field_1_number_crn_records;
    }

    public CRNCountRecord(RecordInputStream recordInputStream) {
        short readShort = recordInputStream.readShort();
        this.field_1_number_crn_records = readShort;
        if (readShort < 0) {
            this.field_1_number_crn_records = (short) (-readShort);
        }
        this.field_2_sheet_table_index = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName()).append(" [XCT");
        stringBuffer.append(" nCRNs=").append(this.field_1_number_crn_records);
        stringBuffer.append(" sheetIx=").append(this.field_2_sheet_table_index);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort((short) this.field_1_number_crn_records);
        littleEndianOutput.writeShort((short) this.field_2_sheet_table_index);
    }
}
