package org.apache.poi.hssf.record;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class FileSharingRecord extends StandardRecord {
    public static final short sid = 91;
    private short field_1_readonly;
    private short field_2_password;
    private byte field_3_username_unicode_options;
    private String field_3_username_value;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 91;
    }

    public FileSharingRecord() {
    }

    public FileSharingRecord(RecordInputStream recordInputStream) {
        this.field_1_readonly = recordInputStream.readShort();
        this.field_2_password = recordInputStream.readShort();
        short readShort = recordInputStream.readShort();
        if (readShort > 0) {
            this.field_3_username_unicode_options = recordInputStream.readByte();
            this.field_3_username_value = recordInputStream.readCompressedUnicode(readShort);
        } else {
            this.field_3_username_value = "";
        }
    }

    public static short hashPassword(String str) {
        byte[] bytes = str.getBytes();
        int i = 0;
        if (bytes.length > 0) {
            int length = bytes.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    break;
                }
                i = bytes[i2] ^ (((i >> 14) & 1) | ((i << 1) & 32767));
                length = i2;
            }
            i = (bytes.length ^ (((i >> 14) & 1) | ((i << 1) & 32767))) ^ 52811;
        }
        return (short) i;
    }

    public void setReadOnly(short s) {
        this.field_1_readonly = s;
    }

    public short getReadOnly() {
        return this.field_1_readonly;
    }

    public void setPassword(short s) {
        this.field_2_password = s;
    }

    public short getPassword() {
        return this.field_2_password;
    }

    public String getUsername() {
        return this.field_3_username_value;
    }

    public void setUsername(String str) {
        this.field_3_username_value = str;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FILESHARING]\n");
        stringBuffer.append("    .readonly       = ").append(getReadOnly() == 1 ? BooleanUtils.TRUE : "false").append("\n");
        stringBuffer.append("    .password       = ").append(Integer.toHexString(getPassword())).append("\n");
        stringBuffer.append("    .username       = ").append(getUsername()).append("\n");
        stringBuffer.append("[/FILESHARING]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getReadOnly());
        littleEndianOutput.writeShort(getPassword());
        littleEndianOutput.writeShort(this.field_3_username_value.length());
        if (this.field_3_username_value.length() > 0) {
            littleEndianOutput.writeByte(this.field_3_username_unicode_options);
            StringUtil.putCompressedUnicode(getUsername(), littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        int length = this.field_3_username_value.length();
        if (length < 1) {
            return 6;
        }
        return length + 7;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        FileSharingRecord fileSharingRecord = new FileSharingRecord();
        fileSharingRecord.setReadOnly(this.field_1_readonly);
        fileSharingRecord.setPassword(this.field_2_password);
        fileSharingRecord.setUsername(this.field_3_username_value);
        return fileSharingRecord;
    }
}
