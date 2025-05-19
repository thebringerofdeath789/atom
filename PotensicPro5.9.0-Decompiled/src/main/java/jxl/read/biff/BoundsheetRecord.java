package jxl.read.biff;

import java.io.UnsupportedEncodingException;
import jxl.biff.IntegerHelper;
import jxl.biff.RecordData;

/* loaded from: classes4.dex */
class BoundsheetRecord extends RecordData {
    public static Biff7 biff7 = new Biff7();
    private int length;
    private String name;
    private int offset;
    private byte typeFlag;
    private byte visibilityFlag;

    /* JADX INFO: Access modifiers changed from: private */
    static class Biff7 {
        private Biff7() {
        }
    }

    public BoundsheetRecord(Record record) {
        super(record);
        byte[] data = getRecord().getData();
        this.offset = IntegerHelper.getInt(data[0], data[1], data[2], data[3]);
        this.typeFlag = data[5];
        this.visibilityFlag = data[4];
        int i = data[6];
        this.length = i;
        if (data[7] == 0) {
            byte[] bArr = new byte[i];
            System.arraycopy(data, 8, bArr, 0, i);
            this.name = new String(bArr);
        } else {
            byte[] bArr2 = new byte[i * 2];
            System.arraycopy(data, 8, bArr2, 0, i * 2);
            try {
                this.name = new String(bArr2, "UnicodeLittle");
            } catch (UnsupportedEncodingException unused) {
                this.name = "Error";
            }
        }
    }

    public BoundsheetRecord(Record record, Biff7 biff72) {
        super(record);
        byte[] data = getRecord().getData();
        this.offset = IntegerHelper.getInt(data[0], data[1], data[2], data[3]);
        this.typeFlag = data[5];
        this.visibilityFlag = data[4];
        int i = data[6];
        this.length = i;
        byte[] bArr = new byte[i];
        System.arraycopy(data, 7, bArr, 0, i);
        this.name = new String(bArr);
    }

    public String getName() {
        return this.name;
    }

    public boolean isHidden() {
        return this.visibilityFlag != 0;
    }

    public boolean isSheet() {
        return this.typeFlag == 0;
    }

    public boolean isChart() {
        return this.typeFlag == 2;
    }
}
