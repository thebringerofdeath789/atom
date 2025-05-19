package org.apache.poi.hpsf;

import org.apache.poi.util.HexDump;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public class ClassID {
    public static final int LENGTH = 16;
    protected byte[] bytes;
    public static final ClassID OLE10_PACKAGE = new ClassID("{0003000C-0000-0000-C000-000000000046}");
    public static final ClassID PPT_SHOW = new ClassID("{64818D10-4F9B-11CF-86EA-00AA00B929E8}");
    public static final ClassID XLS_WORKBOOK = new ClassID("{00020841-0000-0000-C000-000000000046}");
    public static final ClassID TXT_ONLY = new ClassID("{5e941d80-bf96-11cd-b579-08002b30bfeb}");
    public static final ClassID EXCEL97 = new ClassID("{00020820-0000-0000-C000-000000000046}");
    public static final ClassID EXCEL95 = new ClassID("{00020810-0000-0000-C000-000000000046}");
    public static final ClassID WORD97 = new ClassID("{00020906-0000-0000-C000-000000000046}");
    public static final ClassID WORD95 = new ClassID("{00020900-0000-0000-C000-000000000046}");
    public static final ClassID POWERPOINT97 = new ClassID("{64818D10-4F9B-11CF-86EA-00AA00B929E8}");
    public static final ClassID POWERPOINT95 = new ClassID("{EA7BAE70-FB3B-11CD-A903-00AA00510EA3}");
    public static final ClassID EQUATION30 = new ClassID("{0002CE02-0000-0000-C000-000000000046}");

    public int length() {
        return 16;
    }

    public ClassID(byte[] bArr, int i) {
        read(bArr, i);
    }

    public ClassID() {
        this.bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            this.bytes[i] = 0;
        }
    }

    public ClassID(String str) {
        this.bytes = new byte[16];
        String replaceAll = str.replaceAll("[{}-]", "");
        int i = 0;
        while (i < replaceAll.length()) {
            int i2 = i + 2;
            this.bytes[i / 2] = (byte) Integer.parseInt(replaceAll.substring(i, i2), 16);
            i = i2;
        }
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public void setBytes(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = this.bytes;
            if (i >= bArr2.length) {
                return;
            }
            bArr2[i] = bArr[i];
            i++;
        }
    }

    public byte[] read(byte[] bArr, int i) {
        this.bytes = new byte[]{bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i + 0], bArr[i + 5], bArr[i + 4], bArr[i + 7], bArr[i + 6], 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i2 = 8; i2 < 16; i2++) {
            this.bytes[i2] = bArr[i2 + i];
        }
        return this.bytes;
    }

    public void write(byte[] bArr, int i) throws ArrayStoreException {
        if (bArr.length < 16) {
            throw new ArrayStoreException("Destination byte[] must have room for at least 16 bytes, but has a length of only " + bArr.length + ".");
        }
        byte[] bArr2 = this.bytes;
        bArr[i + 0] = bArr2[3];
        bArr[i + 1] = bArr2[2];
        bArr[i + 2] = bArr2[1];
        bArr[i + 3] = bArr2[0];
        bArr[i + 4] = bArr2[5];
        bArr[i + 5] = bArr2[4];
        bArr[i + 6] = bArr2[7];
        bArr[i + 7] = bArr2[6];
        for (int i2 = 8; i2 < 16; i2++) {
            bArr[i2 + i] = this.bytes[i2];
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ClassID)) {
            return false;
        }
        ClassID classID = (ClassID) obj;
        if (this.bytes.length != classID.bytes.length) {
            return false;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i >= bArr.length) {
                return true;
            }
            if (bArr[i] != classID.bytes[i]) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        return new String(this.bytes).hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(38);
        stringBuffer.append('{');
        for (int i = 0; i < 16; i++) {
            stringBuffer.append(HexDump.toHex(this.bytes[i]));
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                stringBuffer.append(NameUtil.HYPHEN);
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
