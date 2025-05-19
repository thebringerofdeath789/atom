package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class BarRecord extends StandardRecord {
    public static final short sid = 4119;
    private short field_1_barSpace;
    private short field_2_categorySpace;
    private short field_3_formatFlags;
    private static final BitField horizontal = BitFieldFactory.getInstance(1);
    private static final BitField stacked = BitFieldFactory.getInstance(2);
    private static final BitField displayAsPercentage = BitFieldFactory.getInstance(4);
    private static final BitField shadow = BitFieldFactory.getInstance(8);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 6;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public BarRecord() {
    }

    public BarRecord(RecordInputStream recordInputStream) {
        this.field_1_barSpace = recordInputStream.readShort();
        this.field_2_categorySpace = recordInputStream.readShort();
        this.field_3_formatFlags = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[BAR]\n");
        stringBuffer.append("    .barSpace             = ").append("0x").append(HexDump.toHex(getBarSpace())).append(" (").append((int) getBarSpace()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .categorySpace        = ").append("0x").append(HexDump.toHex(getCategorySpace())).append(" (").append((int) getCategorySpace()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(getFormatFlags())).append(" (").append((int) getFormatFlags()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .horizontal               = ").append(isHorizontal()).append('\n');
        stringBuffer.append("         .stacked                  = ").append(isStacked()).append('\n');
        stringBuffer.append("         .displayAsPercentage      = ").append(isDisplayAsPercentage()).append('\n');
        stringBuffer.append("         .shadow                   = ").append(isShadow()).append('\n');
        stringBuffer.append("[/BAR]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_barSpace);
        littleEndianOutput.writeShort(this.field_2_categorySpace);
        littleEndianOutput.writeShort(this.field_3_formatFlags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        BarRecord barRecord = new BarRecord();
        barRecord.field_1_barSpace = this.field_1_barSpace;
        barRecord.field_2_categorySpace = this.field_2_categorySpace;
        barRecord.field_3_formatFlags = this.field_3_formatFlags;
        return barRecord;
    }

    public short getBarSpace() {
        return this.field_1_barSpace;
    }

    public void setBarSpace(short s) {
        this.field_1_barSpace = s;
    }

    public short getCategorySpace() {
        return this.field_2_categorySpace;
    }

    public void setCategorySpace(short s) {
        this.field_2_categorySpace = s;
    }

    public short getFormatFlags() {
        return this.field_3_formatFlags;
    }

    public void setFormatFlags(short s) {
        this.field_3_formatFlags = s;
    }

    public void setHorizontal(boolean z) {
        this.field_3_formatFlags = horizontal.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isHorizontal() {
        return horizontal.isSet(this.field_3_formatFlags);
    }

    public void setStacked(boolean z) {
        this.field_3_formatFlags = stacked.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isStacked() {
        return stacked.isSet(this.field_3_formatFlags);
    }

    public void setDisplayAsPercentage(boolean z) {
        this.field_3_formatFlags = displayAsPercentage.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isDisplayAsPercentage() {
        return displayAsPercentage.isSet(this.field_3_formatFlags);
    }

    public void setShadow(boolean z) {
        this.field_3_formatFlags = shadow.setShortBoolean(this.field_3_formatFlags, z);
    }

    public boolean isShadow() {
        return shadow.isSet(this.field_3_formatFlags);
    }
}
