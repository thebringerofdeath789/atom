package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class CountryRecord extends StandardRecord {
    public static final short sid = 140;
    private short field_1_default_country;
    private short field_2_current_country;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 140;
    }

    public CountryRecord() {
    }

    public CountryRecord(RecordInputStream recordInputStream) {
        this.field_1_default_country = recordInputStream.readShort();
        this.field_2_current_country = recordInputStream.readShort();
    }

    public void setDefaultCountry(short s) {
        this.field_1_default_country = s;
    }

    public void setCurrentCountry(short s) {
        this.field_2_current_country = s;
    }

    public short getDefaultCountry() {
        return this.field_1_default_country;
    }

    public short getCurrentCountry() {
        return this.field_2_current_country;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[COUNTRY]\n");
        stringBuffer.append("    .defaultcountry  = ").append(Integer.toHexString(getDefaultCountry())).append("\n");
        stringBuffer.append("    .currentcountry  = ").append(Integer.toHexString(getCurrentCountry())).append("\n");
        stringBuffer.append("[/COUNTRY]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getDefaultCountry());
        littleEndianOutput.writeShort(getCurrentCountry());
    }
}
