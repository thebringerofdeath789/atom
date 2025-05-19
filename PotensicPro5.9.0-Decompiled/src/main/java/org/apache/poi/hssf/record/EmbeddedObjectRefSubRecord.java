package org.apache.poi.hssf.record;

import java.io.ByteArrayInputStream;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class EmbeddedObjectRefSubRecord extends SubRecord {
    public static final short sid = 9;
    private int field_1_unknown_int;
    private Ptg field_2_refPtg;
    private byte[] field_2_unknownFormulaData;
    private boolean field_3_unicode_flag;
    private String field_4_ole_classname;
    private Byte field_4_unknownByte;
    private Integer field_5_stream_id;
    private byte[] field_6_unknown;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) EmbeddedObjectRefSubRecord.class);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Override // org.apache.poi.hssf.record.SubRecord
    public Object clone() {
        return this;
    }

    public short getSid() {
        return (short) 9;
    }

    public EmbeddedObjectRefSubRecord() {
        this.field_2_unknownFormulaData = new byte[]{2, 108, 106, 22, 1};
        this.field_6_unknown = EMPTY_BYTE_ARRAY;
        this.field_4_ole_classname = null;
    }

    public EmbeddedObjectRefSubRecord(LittleEndianInput littleEndianInput, int i) {
        int readShort = (i - 2) - littleEndianInput.readShort();
        int readUShort = littleEndianInput.readUShort();
        this.field_1_unknown_int = littleEndianInput.readInt();
        byte[] readRawData = readRawData(littleEndianInput, readUShort);
        int i2 = ((r10 - 2) - 4) - readUShort;
        Ptg readRefPtg = readRefPtg(readRawData);
        this.field_2_refPtg = readRefPtg;
        if (readRefPtg == null) {
            this.field_2_unknownFormulaData = readRawData;
        } else {
            this.field_2_unknownFormulaData = null;
        }
        int i3 = 0;
        if (i2 >= readShort + 3) {
            if (littleEndianInput.readByte() != 3) {
                throw new RecordFormatException("Expected byte 0x03 here");
            }
            int readUShort2 = littleEndianInput.readUShort();
            if (readUShort2 > 0) {
                boolean z = (littleEndianInput.readByte() & 1) != 0;
                this.field_3_unicode_flag = z;
                if (z) {
                    this.field_4_ole_classname = StringUtil.readUnicodeLE(littleEndianInput, readUShort2);
                    readUShort2 *= 2;
                } else {
                    this.field_4_ole_classname = StringUtil.readCompressedUnicode(littleEndianInput, readUShort2);
                }
                i3 = readUShort2 + 4;
            } else {
                this.field_4_ole_classname = "";
                i3 = 3;
            }
        } else {
            this.field_4_ole_classname = null;
        }
        int i4 = i2 - i3;
        if ((i3 + readUShort) % 2 != 0) {
            byte readByte = littleEndianInput.readByte();
            i4--;
            if (this.field_2_refPtg != null && this.field_4_ole_classname == null) {
                this.field_4_unknownByte = Byte.valueOf(readByte);
            }
        }
        int i5 = i4 - readShort;
        if (i5 > 0) {
            logger.log(7, "Discarding " + i5 + " unexpected padding bytes ");
            readRawData(littleEndianInput, i5);
            i4 -= i5;
        }
        if (readShort >= 4) {
            this.field_5_stream_id = Integer.valueOf(littleEndianInput.readInt());
            i4 -= 4;
        } else {
            this.field_5_stream_id = null;
        }
        this.field_6_unknown = readRawData(littleEndianInput, i4);
    }

    private static Ptg readRefPtg(byte[] bArr) {
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(new ByteArrayInputStream(bArr));
        byte readByte = littleEndianInputStream.readByte();
        if (readByte == 36) {
            return new RefPtg(littleEndianInputStream);
        }
        if (readByte == 37) {
            return new AreaPtg(littleEndianInputStream);
        }
        if (readByte == 58) {
            return new Ref3DPtg(littleEndianInputStream);
        }
        if (readByte != 59) {
            return null;
        }
        return new Area3DPtg(littleEndianInputStream);
    }

    private static byte[] readRawData(LittleEndianInput littleEndianInput, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative size (" + i + ")");
        }
        if (i == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i];
        littleEndianInput.readFully(bArr);
        return bArr;
    }

    private int getStreamIDOffset(int i) {
        int i2 = i + 6;
        String str = this.field_4_ole_classname;
        if (str != null) {
            i2 += 3;
            int length = str.length();
            if (length > 0) {
                int i3 = i2 + 1;
                if (this.field_3_unicode_flag) {
                    length *= 2;
                }
                i2 = i3 + length;
            }
        }
        return i2 % 2 != 0 ? i2 + 1 : i2;
    }

    private int getDataSize(int i) {
        int i2 = i + 2;
        if (this.field_5_stream_id != null) {
            i2 += 4;
        }
        return i2 + this.field_6_unknown.length;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        Ptg ptg = this.field_2_refPtg;
        return getDataSize(getStreamIDOffset(ptg == null ? this.field_2_unknownFormulaData.length : ptg.getSize()));
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        Ptg ptg = this.field_2_refPtg;
        int length = ptg == null ? this.field_2_unknownFormulaData.length : ptg.getSize();
        int streamIDOffset = getStreamIDOffset(length);
        int dataSize = getDataSize(streamIDOffset);
        littleEndianOutput.writeShort(9);
        littleEndianOutput.writeShort(dataSize);
        littleEndianOutput.writeShort(streamIDOffset);
        littleEndianOutput.writeShort(length);
        littleEndianOutput.writeInt(this.field_1_unknown_int);
        Ptg ptg2 = this.field_2_refPtg;
        if (ptg2 == null) {
            littleEndianOutput.write(this.field_2_unknownFormulaData);
        } else {
            ptg2.write(littleEndianOutput);
        }
        int i = length + 12;
        if (this.field_4_ole_classname != null) {
            littleEndianOutput.writeByte(3);
            int length2 = this.field_4_ole_classname.length();
            littleEndianOutput.writeShort(length2);
            i = i + 1 + 2;
            if (length2 > 0) {
                littleEndianOutput.writeByte(this.field_3_unicode_flag ? 1 : 0);
                int i2 = i + 1;
                if (this.field_3_unicode_flag) {
                    StringUtil.putUnicodeLE(this.field_4_ole_classname, littleEndianOutput);
                    length2 *= 2;
                } else {
                    StringUtil.putCompressedUnicode(this.field_4_ole_classname, littleEndianOutput);
                }
                i = i2 + length2;
            }
        }
        int i3 = streamIDOffset - (i - 6);
        if (i3 != 0) {
            if (i3 == 1) {
                Byte b = this.field_4_unknownByte;
                littleEndianOutput.writeByte(b == null ? 0 : b.intValue());
            } else {
                throw new IllegalStateException("Bad padding calculation (" + streamIDOffset + ", " + i + ")");
            }
        }
        Integer num = this.field_5_stream_id;
        if (num != null) {
            littleEndianOutput.writeInt(num.intValue());
        }
        littleEndianOutput.write(this.field_6_unknown);
    }

    public Integer getStreamId() {
        return this.field_5_stream_id;
    }

    public String getOLEClassName() {
        return this.field_4_ole_classname;
    }

    public byte[] getObjectData() {
        return this.field_6_unknown;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ftPictFmla]\n");
        stringBuffer.append("    .f2unknown     = ").append(HexDump.intToHex(this.field_1_unknown_int)).append("\n");
        if (this.field_2_refPtg == null) {
            stringBuffer.append("    .f3unknown     = ").append(HexDump.toHex(this.field_2_unknownFormulaData)).append("\n");
        } else {
            stringBuffer.append("    .formula       = ").append(this.field_2_refPtg.toString()).append("\n");
        }
        if (this.field_4_ole_classname != null) {
            stringBuffer.append("    .unicodeFlag   = ").append(this.field_3_unicode_flag).append("\n");
            stringBuffer.append("    .oleClassname  = ").append(this.field_4_ole_classname).append("\n");
        }
        if (this.field_4_unknownByte != null) {
            stringBuffer.append("    .f4unknown   = ").append(HexDump.byteToHex(this.field_4_unknownByte.intValue())).append("\n");
        }
        if (this.field_5_stream_id != null) {
            stringBuffer.append("    .streamId      = ").append(HexDump.intToHex(this.field_5_stream_id.intValue())).append("\n");
        }
        if (this.field_6_unknown.length > 0) {
            stringBuffer.append("    .f7unknown     = ").append(HexDump.toHex(this.field_6_unknown)).append("\n");
        }
        stringBuffer.append("[/ftPictFmla]");
        return stringBuffer.toString();
    }

    public void setUnknownFormulaData(byte[] bArr) {
        this.field_2_unknownFormulaData = bArr;
    }

    public void setOleClassname(String str) {
        this.field_4_ole_classname = str;
    }

    public void setStorageId(int i) {
        this.field_5_stream_id = Integer.valueOf(i);
    }
}
