package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DefaultDataLabelTextPropertiesRecord extends StandardRecord {
    public static final short CATEGORY_DATA_TYPE_ALL_TEXT_CHARACTERISTIC = 2;
    public static final short CATEGORY_DATA_TYPE_SHOW_LABELS_CHARACTERISTIC = 0;
    public static final short CATEGORY_DATA_TYPE_VALUE_AND_PERCENTAGE_CHARACTERISTIC = 1;
    public static final short sid = 4132;
    private short field_1_categoryDataType;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DefaultDataLabelTextPropertiesRecord() {
    }

    public DefaultDataLabelTextPropertiesRecord(RecordInputStream recordInputStream) {
        this.field_1_categoryDataType = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[DEFAULTTEXT]\n");
        stringBuffer.append("    .categoryDataType     = ").append("0x").append(HexDump.toHex(getCategoryDataType())).append(" (").append((int) getCategoryDataType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/DEFAULTTEXT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_categoryDataType);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        DefaultDataLabelTextPropertiesRecord defaultDataLabelTextPropertiesRecord = new DefaultDataLabelTextPropertiesRecord();
        defaultDataLabelTextPropertiesRecord.field_1_categoryDataType = this.field_1_categoryDataType;
        return defaultDataLabelTextPropertiesRecord;
    }

    public short getCategoryDataType() {
        return this.field_1_categoryDataType;
    }

    public void setCategoryDataType(short s) {
        this.field_1_categoryDataType = s;
    }
}
