package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ValueRangeRecord extends StandardRecord {
    public static final short sid = 4127;
    private double field_1_minimumAxisValue;
    private double field_2_maximumAxisValue;
    private double field_3_majorIncrement;
    private double field_4_minorIncrement;
    private double field_5_categoryAxisCross;
    private short field_6_options;
    private static final BitField automaticMinimum = BitFieldFactory.getInstance(1);
    private static final BitField automaticMaximum = BitFieldFactory.getInstance(2);
    private static final BitField automaticMajor = BitFieldFactory.getInstance(4);
    private static final BitField automaticMinor = BitFieldFactory.getInstance(8);
    private static final BitField automaticCategoryCrossing = BitFieldFactory.getInstance(16);
    private static final BitField logarithmicScale = BitFieldFactory.getInstance(32);
    private static final BitField valuesInReverse = BitFieldFactory.getInstance(64);
    private static final BitField crossCategoryAxisAtMaximum = BitFieldFactory.getInstance(128);
    private static final BitField reserved = BitFieldFactory.getInstance(256);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 42;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ValueRangeRecord() {
    }

    public ValueRangeRecord(RecordInputStream recordInputStream) {
        this.field_1_minimumAxisValue = recordInputStream.readDouble();
        this.field_2_maximumAxisValue = recordInputStream.readDouble();
        this.field_3_majorIncrement = recordInputStream.readDouble();
        this.field_4_minorIncrement = recordInputStream.readDouble();
        this.field_5_categoryAxisCross = recordInputStream.readDouble();
        this.field_6_options = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[VALUERANGE]\n");
        stringBuffer.append("    .minimumAxisValue     = ").append(" (").append(getMinimumAxisValue()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .maximumAxisValue     = ").append(" (").append(getMaximumAxisValue()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .majorIncrement       = ").append(" (").append(getMajorIncrement()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .minorIncrement       = ").append(" (").append(getMinorIncrement()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .categoryAxisCross    = ").append(" (").append(getCategoryAxisCross()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append((int) getOptions()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .automaticMinimum         = ").append(isAutomaticMinimum()).append('\n');
        stringBuffer.append("         .automaticMaximum         = ").append(isAutomaticMaximum()).append('\n');
        stringBuffer.append("         .automaticMajor           = ").append(isAutomaticMajor()).append('\n');
        stringBuffer.append("         .automaticMinor           = ").append(isAutomaticMinor()).append('\n');
        stringBuffer.append("         .automaticCategoryCrossing     = ").append(isAutomaticCategoryCrossing()).append('\n');
        stringBuffer.append("         .logarithmicScale         = ").append(isLogarithmicScale()).append('\n');
        stringBuffer.append("         .valuesInReverse          = ").append(isValuesInReverse()).append('\n');
        stringBuffer.append("         .crossCategoryAxisAtMaximum     = ").append(isCrossCategoryAxisAtMaximum()).append('\n');
        stringBuffer.append("         .reserved                 = ").append(isReserved()).append('\n');
        stringBuffer.append("[/VALUERANGE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeDouble(this.field_1_minimumAxisValue);
        littleEndianOutput.writeDouble(this.field_2_maximumAxisValue);
        littleEndianOutput.writeDouble(this.field_3_majorIncrement);
        littleEndianOutput.writeDouble(this.field_4_minorIncrement);
        littleEndianOutput.writeDouble(this.field_5_categoryAxisCross);
        littleEndianOutput.writeShort(this.field_6_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        ValueRangeRecord valueRangeRecord = new ValueRangeRecord();
        valueRangeRecord.field_1_minimumAxisValue = this.field_1_minimumAxisValue;
        valueRangeRecord.field_2_maximumAxisValue = this.field_2_maximumAxisValue;
        valueRangeRecord.field_3_majorIncrement = this.field_3_majorIncrement;
        valueRangeRecord.field_4_minorIncrement = this.field_4_minorIncrement;
        valueRangeRecord.field_5_categoryAxisCross = this.field_5_categoryAxisCross;
        valueRangeRecord.field_6_options = this.field_6_options;
        return valueRangeRecord;
    }

    public double getMinimumAxisValue() {
        return this.field_1_minimumAxisValue;
    }

    public void setMinimumAxisValue(double d) {
        this.field_1_minimumAxisValue = d;
    }

    public double getMaximumAxisValue() {
        return this.field_2_maximumAxisValue;
    }

    public void setMaximumAxisValue(double d) {
        this.field_2_maximumAxisValue = d;
    }

    public double getMajorIncrement() {
        return this.field_3_majorIncrement;
    }

    public void setMajorIncrement(double d) {
        this.field_3_majorIncrement = d;
    }

    public double getMinorIncrement() {
        return this.field_4_minorIncrement;
    }

    public void setMinorIncrement(double d) {
        this.field_4_minorIncrement = d;
    }

    public double getCategoryAxisCross() {
        return this.field_5_categoryAxisCross;
    }

    public void setCategoryAxisCross(double d) {
        this.field_5_categoryAxisCross = d;
    }

    public short getOptions() {
        return this.field_6_options;
    }

    public void setOptions(short s) {
        this.field_6_options = s;
    }

    public void setAutomaticMinimum(boolean z) {
        this.field_6_options = automaticMinimum.setShortBoolean(this.field_6_options, z);
    }

    public boolean isAutomaticMinimum() {
        return automaticMinimum.isSet(this.field_6_options);
    }

    public void setAutomaticMaximum(boolean z) {
        this.field_6_options = automaticMaximum.setShortBoolean(this.field_6_options, z);
    }

    public boolean isAutomaticMaximum() {
        return automaticMaximum.isSet(this.field_6_options);
    }

    public void setAutomaticMajor(boolean z) {
        this.field_6_options = automaticMajor.setShortBoolean(this.field_6_options, z);
    }

    public boolean isAutomaticMajor() {
        return automaticMajor.isSet(this.field_6_options);
    }

    public void setAutomaticMinor(boolean z) {
        this.field_6_options = automaticMinor.setShortBoolean(this.field_6_options, z);
    }

    public boolean isAutomaticMinor() {
        return automaticMinor.isSet(this.field_6_options);
    }

    public void setAutomaticCategoryCrossing(boolean z) {
        this.field_6_options = automaticCategoryCrossing.setShortBoolean(this.field_6_options, z);
    }

    public boolean isAutomaticCategoryCrossing() {
        return automaticCategoryCrossing.isSet(this.field_6_options);
    }

    public void setLogarithmicScale(boolean z) {
        this.field_6_options = logarithmicScale.setShortBoolean(this.field_6_options, z);
    }

    public boolean isLogarithmicScale() {
        return logarithmicScale.isSet(this.field_6_options);
    }

    public void setValuesInReverse(boolean z) {
        this.field_6_options = valuesInReverse.setShortBoolean(this.field_6_options, z);
    }

    public boolean isValuesInReverse() {
        return valuesInReverse.isSet(this.field_6_options);
    }

    public void setCrossCategoryAxisAtMaximum(boolean z) {
        this.field_6_options = crossCategoryAxisAtMaximum.setShortBoolean(this.field_6_options, z);
    }

    public boolean isCrossCategoryAxisAtMaximum() {
        return crossCategoryAxisAtMaximum.isSet(this.field_6_options);
    }

    public void setReserved(boolean z) {
        this.field_6_options = reserved.setShortBoolean(this.field_6_options, z);
    }

    public boolean isReserved() {
        return reserved.isSet(this.field_6_options);
    }
}
