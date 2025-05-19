package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DrawingRecord extends StandardRecord {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final short sid = 236;
    private byte[] contd;
    private byte[] recordData;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 236;
    }

    public DrawingRecord() {
        this.recordData = EMPTY_BYTE_ARRAY;
    }

    public DrawingRecord(RecordInputStream recordInputStream) {
        this.recordData = recordInputStream.readRemainder();
    }

    @Deprecated
    public void processContinueRecord(byte[] bArr) {
        this.contd = bArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this.recordData);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this.recordData.length;
    }

    @Deprecated
    public byte[] getData() {
        return this.recordData;
    }

    public byte[] getRecordData() {
        return this.recordData;
    }

    public void setData(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data must not be null");
        }
        this.recordData = bArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        DrawingRecord drawingRecord = new DrawingRecord();
        drawingRecord.recordData = (byte[]) this.recordData.clone();
        byte[] bArr = this.contd;
        if (bArr != null) {
            drawingRecord.contd = (byte[]) bArr.clone();
        }
        return drawingRecord;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "DrawingRecord[" + this.recordData.length + "]";
    }
}
