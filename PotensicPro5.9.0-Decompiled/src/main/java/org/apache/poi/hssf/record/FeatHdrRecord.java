package org.apache.poi.hssf.record;

import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class FeatHdrRecord extends StandardRecord {
    public static final int SHAREDFEATURES_ISFFACTOID = 4;
    public static final int SHAREDFEATURES_ISFFEC2 = 3;
    public static final int SHAREDFEATURES_ISFLIST = 5;
    public static final int SHAREDFEATURES_ISFPROTECTION = 2;
    public static final short sid = 2151;
    private long cbHdrData;
    private FtrHeader futureHeader;
    private int isf_sharedFeatureType;
    private byte reserved;
    private byte[] rgbHdrData;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public FeatHdrRecord() {
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
    }

    public FeatHdrRecord(RecordInputStream recordInputStream) {
        this.futureHeader = new FtrHeader(recordInputStream);
        this.isf_sharedFeatureType = recordInputStream.readShort();
        this.reserved = recordInputStream.readByte();
        this.cbHdrData = recordInputStream.readInt();
        this.rgbHdrData = recordInputStream.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FEATURE HEADER]\n");
        stringBuffer.append("[/FEATURE HEADER]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this.futureHeader.serialize(littleEndianOutput);
        littleEndianOutput.writeShort(this.isf_sharedFeatureType);
        littleEndianOutput.writeByte(this.reserved);
        littleEndianOutput.writeInt((int) this.cbHdrData);
        littleEndianOutput.write(this.rgbHdrData);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this.rgbHdrData.length + 19;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return cloneViaReserialise();
    }
}
