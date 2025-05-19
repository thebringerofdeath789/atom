package org.apache.poi.hssf.record;

import java.util.Arrays;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class WriteAccessRecord extends StandardRecord {
    private static final int DATA_SIZE = 112;
    private static final byte[] PADDING;
    private static final byte PAD_CHAR = 32;
    public static final short sid = 92;
    private String field_1_username;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 112;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 92;
    }

    static {
        byte[] bArr = new byte[112];
        PADDING = bArr;
        Arrays.fill(bArr, (byte) 32);
    }

    public WriteAccessRecord() {
        setUsername("");
    }

    public WriteAccessRecord(RecordInputStream recordInputStream) {
        String readUnicodeLE;
        if (recordInputStream.remaining() > 112) {
            throw new RecordFormatException("Expected data size (112) but got (" + recordInputStream.remaining() + ")");
        }
        int readUShort = recordInputStream.readUShort();
        int readUByte = recordInputStream.readUByte();
        if (readUShort > 112 || (readUByte & 254) != 0) {
            int remaining = recordInputStream.remaining() + 3;
            byte[] bArr = new byte[remaining];
            LittleEndian.putUShort(bArr, 0, readUShort);
            LittleEndian.putByte(bArr, 2, readUByte);
            recordInputStream.readFully(bArr, 3, remaining - 3);
            setUsername(new String(bArr).trim());
            return;
        }
        if ((readUByte & 1) == 0) {
            readUnicodeLE = StringUtil.readCompressedUnicode(recordInputStream, readUShort);
        } else {
            readUnicodeLE = StringUtil.readUnicodeLE(recordInputStream, readUShort);
        }
        this.field_1_username = readUnicodeLE.trim();
        for (int remaining2 = recordInputStream.remaining(); remaining2 > 0; remaining2--) {
            recordInputStream.readUByte();
        }
    }

    public void setUsername(String str) {
        if (112 - ((str.length() * (StringUtil.hasMultibyte(str) ? 2 : 1)) + 3) < 0) {
            throw new IllegalArgumentException("Name is too long: " + str);
        }
        this.field_1_username = str;
    }

    public String getUsername() {
        return this.field_1_username;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[WRITEACCESS]\n");
        stringBuffer.append("    .name = ").append(this.field_1_username).append("\n");
        stringBuffer.append("[/WRITEACCESS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        String username = getUsername();
        boolean hasMultibyte = StringUtil.hasMultibyte(username);
        littleEndianOutput.writeShort(username.length());
        littleEndianOutput.writeByte(hasMultibyte ? 1 : 0);
        if (hasMultibyte) {
            StringUtil.putUnicodeLE(username, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(username, littleEndianOutput);
        }
        littleEndianOutput.write(PADDING, 0, 112 - ((username.length() * (hasMultibyte ? 2 : 1)) + 3));
    }
}
