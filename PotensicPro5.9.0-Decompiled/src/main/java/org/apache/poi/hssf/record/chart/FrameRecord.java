package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class FrameRecord extends StandardRecord {
    public static final short BORDER_TYPE_REGULAR = 0;
    public static final short BORDER_TYPE_SHADOW = 1;
    public static final short sid = 4146;
    private short field_1_borderType;
    private short field_2_options;
    private static final BitField autoSize = BitFieldFactory.getInstance(1);
    private static final BitField autoPosition = BitFieldFactory.getInstance(2);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public FrameRecord() {
    }

    public FrameRecord(RecordInputStream recordInputStream) {
        this.field_1_borderType = recordInputStream.readShort();
        this.field_2_options = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FRAME]\n");
        stringBuffer.append("    .borderType           = ").append("0x").append(HexDump.toHex(getBorderType())).append(" (").append((int) getBorderType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append((int) getOptions()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .autoSize                 = ").append(isAutoSize()).append('\n');
        stringBuffer.append("         .autoPosition             = ").append(isAutoPosition()).append('\n');
        stringBuffer.append("[/FRAME]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_borderType);
        littleEndianOutput.writeShort(this.field_2_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        FrameRecord frameRecord = new FrameRecord();
        frameRecord.field_1_borderType = this.field_1_borderType;
        frameRecord.field_2_options = this.field_2_options;
        return frameRecord;
    }

    public short getBorderType() {
        return this.field_1_borderType;
    }

    public void setBorderType(short s) {
        this.field_1_borderType = s;
    }

    public short getOptions() {
        return this.field_2_options;
    }

    public void setOptions(short s) {
        this.field_2_options = s;
    }

    public void setAutoSize(boolean z) {
        this.field_2_options = autoSize.setShortBoolean(this.field_2_options, z);
    }

    public boolean isAutoSize() {
        return autoSize.isSet(this.field_2_options);
    }

    public void setAutoPosition(boolean z) {
        this.field_2_options = autoPosition.setShortBoolean(this.field_2_options, z);
    }

    public boolean isAutoPosition() {
        return autoPosition.isSet(this.field_2_options);
    }
}
