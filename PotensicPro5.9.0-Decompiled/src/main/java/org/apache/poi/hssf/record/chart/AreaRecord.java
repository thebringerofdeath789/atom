package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class AreaRecord extends StandardRecord {
    public static final short sid = 4122;
    private short field_1_formatFlags;
    private static final BitField stacked = BitFieldFactory.getInstance(1);
    private static final BitField displayAsPercentage = BitFieldFactory.getInstance(2);
    private static final BitField shadow = BitFieldFactory.getInstance(4);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AreaRecord() {
    }

    public AreaRecord(RecordInputStream recordInputStream) {
        this.field_1_formatFlags = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[AREA]\n");
        stringBuffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(getFormatFlags())).append(" (").append((int) getFormatFlags()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .stacked                  = ").append(isStacked()).append('\n');
        stringBuffer.append("         .displayAsPercentage      = ").append(isDisplayAsPercentage()).append('\n');
        stringBuffer.append("         .shadow                   = ").append(isShadow()).append('\n');
        stringBuffer.append("[/AREA]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        AreaRecord areaRecord = new AreaRecord();
        areaRecord.field_1_formatFlags = this.field_1_formatFlags;
        return areaRecord;
    }

    public short getFormatFlags() {
        return this.field_1_formatFlags;
    }

    public void setFormatFlags(short s) {
        this.field_1_formatFlags = s;
    }

    public void setStacked(boolean z) {
        this.field_1_formatFlags = stacked.setShortBoolean(this.field_1_formatFlags, z);
    }

    public boolean isStacked() {
        return stacked.isSet(this.field_1_formatFlags);
    }

    public void setDisplayAsPercentage(boolean z) {
        this.field_1_formatFlags = displayAsPercentage.setShortBoolean(this.field_1_formatFlags, z);
    }

    public boolean isDisplayAsPercentage() {
        return displayAsPercentage.isSet(this.field_1_formatFlags);
    }

    public void setShadow(boolean z) {
        this.field_1_formatFlags = shadow.setShortBoolean(this.field_1_formatFlags, z);
    }

    public boolean isShadow() {
        return shadow.isSet(this.field_1_formatFlags);
    }
}
