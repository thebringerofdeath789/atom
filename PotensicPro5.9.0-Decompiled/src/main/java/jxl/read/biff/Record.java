package jxl.read.biff;

import common.Logger;
import java.util.ArrayList;
import jxl.biff.IntegerHelper;
import jxl.biff.Type;

/* loaded from: classes4.dex */
public final class Record {
    static /* synthetic */ Class class$jxl$read$biff$Record;
    private static final Logger logger;
    private int code;
    private ArrayList continueRecords;
    private byte[] data;
    private int dataPos;
    private File file;
    private int length;
    private Type type;

    static {
        Class cls = class$jxl$read$biff$Record;
        if (cls == null) {
            cls = class$("jxl.read.biff.Record");
            class$jxl$read$biff$Record = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    Record(byte[] bArr, int i, File file) {
        this.code = IntegerHelper.getInt(bArr[i], bArr[i + 1]);
        this.length = IntegerHelper.getInt(bArr[i + 2], bArr[i + 3]);
        this.file = file;
        file.skip(4);
        this.dataPos = file.getPos();
        this.file.skip(this.length);
        this.type = Type.getType(this.code);
    }

    public Type getType() {
        return this.type;
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getData() {
        if (this.data == null) {
            this.data = this.file.read(this.dataPos, this.length);
        }
        ArrayList arrayList = this.continueRecords;
        if (arrayList != null) {
            int size = arrayList.size();
            byte[][] bArr = new byte[size][];
            int i = 0;
            for (int i2 = 0; i2 < this.continueRecords.size(); i2++) {
                bArr[i2] = ((Record) this.continueRecords.get(i2)).getData();
                i += bArr[i2].length;
            }
            byte[] bArr2 = this.data;
            byte[] bArr3 = new byte[bArr2.length + i];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            int length = this.data.length;
            for (int i3 = 0; i3 < size; i3++) {
                byte[] bArr4 = bArr[i3];
                System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
                length += bArr4.length;
            }
            this.data = bArr3;
        }
        return this.data;
    }

    public int getCode() {
        return this.code;
    }

    void setType(Type type) {
        this.type = type;
    }

    public void addContinueRecord(Record record) {
        if (this.continueRecords == null) {
            this.continueRecords = new ArrayList();
        }
        this.continueRecords.add(record);
    }
}
