package jxl.biff.drawing;

import common.Logger;
import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;
import jxl.read.biff.Record;

/* loaded from: classes4.dex */
public class NoteRecord extends WritableRecordData {
    static /* synthetic */ Class class$jxl$biff$drawing$NoteRecord;
    private static Logger logger;
    private int column;
    private byte[] data;
    private int objectId;
    private int row;

    static {
        Class cls = class$jxl$biff$drawing$NoteRecord;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.NoteRecord");
            class$jxl$biff$drawing$NoteRecord = cls;
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

    public NoteRecord(Record record) {
        super(record);
        byte[] data = getRecord().getData();
        this.data = data;
        this.row = IntegerHelper.getInt(data[0], data[1]);
        byte[] bArr = this.data;
        this.column = IntegerHelper.getInt(bArr[2], bArr[3]);
        byte[] bArr2 = this.data;
        this.objectId = IntegerHelper.getInt(bArr2[6], bArr2[7]);
    }

    public NoteRecord(byte[] bArr) {
        super(Type.NOTE);
        this.data = bArr;
    }

    public NoteRecord(int i, int i2, int i3) {
        super(Type.NOTE);
        this.row = i2;
        this.column = i;
        this.objectId = i3;
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] bArr = this.data;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[12];
        this.data = bArr2;
        IntegerHelper.getTwoBytes(this.row, bArr2, 0);
        IntegerHelper.getTwoBytes(this.column, this.data, 2);
        IntegerHelper.getTwoBytes(this.objectId, this.data, 6);
        IntegerHelper.getTwoBytes(0, this.data, 8);
        return this.data;
    }

    int getRow() {
        return this.row;
    }

    int getColumn() {
        return this.column;
    }

    public int getObjectId() {
        return this.objectId;
    }
}
