package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class LinkedDataRecord extends StandardRecord {
    public static final byte LINK_TYPE_CATEGORIES = 2;
    public static final byte LINK_TYPE_TITLE_OR_TEXT = 0;
    public static final byte LINK_TYPE_VALUES = 1;
    public static final byte REFERENCE_TYPE_DEFAULT_CATEGORIES = 0;
    public static final byte REFERENCE_TYPE_DIRECT = 1;
    public static final byte REFERENCE_TYPE_ERROR_REPORTED = 4;
    public static final byte REFERENCE_TYPE_NOT_USED = 3;
    public static final byte REFERENCE_TYPE_WORKSHEET = 2;
    private static final BitField customNumberFormat = BitFieldFactory.getInstance(1);
    public static final short sid = 4177;
    private byte field_1_linkType;
    private byte field_2_referenceType;
    private short field_3_options;
    private short field_4_indexNumberFmtRecord;
    private Formula field_5_formulaOfLink;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public LinkedDataRecord() {
    }

    public LinkedDataRecord(RecordInputStream recordInputStream) {
        this.field_1_linkType = recordInputStream.readByte();
        this.field_2_referenceType = recordInputStream.readByte();
        this.field_3_options = recordInputStream.readShort();
        this.field_4_indexNumberFmtRecord = recordInputStream.readShort();
        this.field_5_formulaOfLink = Formula.read(recordInputStream.readUShort(), recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[AI]\n");
        stringBuffer.append("    .linkType             = ").append(HexDump.byteToHex(getLinkType())).append('\n');
        stringBuffer.append("    .referenceType        = ").append(HexDump.byteToHex(getReferenceType())).append('\n');
        stringBuffer.append("    .options              = ").append(HexDump.shortToHex(getOptions())).append('\n');
        stringBuffer.append("    .customNumberFormat   = ").append(isCustomNumberFormat()).append('\n');
        stringBuffer.append("    .indexNumberFmtRecord = ").append(HexDump.shortToHex(getIndexNumberFmtRecord())).append('\n');
        stringBuffer.append("    .formulaOfLink        = ").append('\n');
        for (Ptg ptg : this.field_5_formulaOfLink.getTokens()) {
            stringBuffer.append(ptg.toString()).append(ptg.getRVAType()).append('\n');
        }
        stringBuffer.append("[/AI]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.field_1_linkType);
        littleEndianOutput.writeByte(this.field_2_referenceType);
        littleEndianOutput.writeShort(this.field_3_options);
        littleEndianOutput.writeShort(this.field_4_indexNumberFmtRecord);
        this.field_5_formulaOfLink.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this.field_5_formulaOfLink.getEncodedSize() + 6;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        LinkedDataRecord linkedDataRecord = new LinkedDataRecord();
        linkedDataRecord.field_1_linkType = this.field_1_linkType;
        linkedDataRecord.field_2_referenceType = this.field_2_referenceType;
        linkedDataRecord.field_3_options = this.field_3_options;
        linkedDataRecord.field_4_indexNumberFmtRecord = this.field_4_indexNumberFmtRecord;
        linkedDataRecord.field_5_formulaOfLink = this.field_5_formulaOfLink.copy();
        return linkedDataRecord;
    }

    public byte getLinkType() {
        return this.field_1_linkType;
    }

    public void setLinkType(byte b) {
        this.field_1_linkType = b;
    }

    public byte getReferenceType() {
        return this.field_2_referenceType;
    }

    public void setReferenceType(byte b) {
        this.field_2_referenceType = b;
    }

    public short getOptions() {
        return this.field_3_options;
    }

    public void setOptions(short s) {
        this.field_3_options = s;
    }

    public short getIndexNumberFmtRecord() {
        return this.field_4_indexNumberFmtRecord;
    }

    public void setIndexNumberFmtRecord(short s) {
        this.field_4_indexNumberFmtRecord = s;
    }

    public Ptg[] getFormulaOfLink() {
        return this.field_5_formulaOfLink.getTokens();
    }

    public void setFormulaOfLink(Ptg[] ptgArr) {
        this.field_5_formulaOfLink = Formula.create(ptgArr);
    }

    public void setCustomNumberFormat(boolean z) {
        this.field_3_options = customNumberFormat.setShortBoolean(this.field_3_options, z);
    }

    public boolean isCustomNumberFormat() {
        return customNumberFormat.isSet(this.field_3_options);
    }
}
