package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DatRecord extends StandardRecord {
    public static final short sid = 4195;
    private short field_1_options;
    private static final BitField horizontalBorder = BitFieldFactory.getInstance(1);
    private static final BitField verticalBorder = BitFieldFactory.getInstance(2);
    private static final BitField border = BitFieldFactory.getInstance(4);
    private static final BitField showSeriesKey = BitFieldFactory.getInstance(8);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DatRecord() {
    }

    public DatRecord(RecordInputStream recordInputStream) {
        this.field_1_options = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[DAT]\n");
        stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append((int) getOptions()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .horizontalBorder         = ").append(isHorizontalBorder()).append('\n');
        stringBuffer.append("         .verticalBorder           = ").append(isVerticalBorder()).append('\n');
        stringBuffer.append("         .border                   = ").append(isBorder()).append('\n');
        stringBuffer.append("         .showSeriesKey            = ").append(isShowSeriesKey()).append('\n');
        stringBuffer.append("[/DAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        DatRecord datRecord = new DatRecord();
        datRecord.field_1_options = this.field_1_options;
        return datRecord;
    }

    public short getOptions() {
        return this.field_1_options;
    }

    public void setOptions(short s) {
        this.field_1_options = s;
    }

    public void setHorizontalBorder(boolean z) {
        this.field_1_options = horizontalBorder.setShortBoolean(this.field_1_options, z);
    }

    public boolean isHorizontalBorder() {
        return horizontalBorder.isSet(this.field_1_options);
    }

    public void setVerticalBorder(boolean z) {
        this.field_1_options = verticalBorder.setShortBoolean(this.field_1_options, z);
    }

    public boolean isVerticalBorder() {
        return verticalBorder.isSet(this.field_1_options);
    }

    public void setBorder(boolean z) {
        this.field_1_options = border.setShortBoolean(this.field_1_options, z);
    }

    public boolean isBorder() {
        return border.isSet(this.field_1_options);
    }

    public void setShowSeriesKey(boolean z) {
        this.field_1_options = showSeriesKey.setShortBoolean(this.field_1_options, z);
    }

    public boolean isShowSeriesKey() {
        return showSeriesKey.isSet(this.field_1_options);
    }
}
