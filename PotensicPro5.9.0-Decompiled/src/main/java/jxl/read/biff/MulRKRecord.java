package jxl.read.biff;

import common.Logger;
import jxl.biff.IntegerHelper;
import jxl.biff.RecordData;

/* loaded from: classes4.dex */
class MulRKRecord extends RecordData {
    static /* synthetic */ Class class$jxl$read$biff$MulRKRecord;
    private static Logger logger;
    private int colFirst;
    private int colLast;
    private int numrks;
    private int[] rknumbers;
    private int row;
    private int[] xfIndices;

    static {
        Class cls = class$jxl$read$biff$MulRKRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.MulRKRecord");
            class$jxl$read$biff$MulRKRecord = cls;
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

    public MulRKRecord(Record record) {
        super(record);
        byte[] data = getRecord().getData();
        int length = getRecord().getLength();
        this.row = IntegerHelper.getInt(data[0], data[1]);
        this.colFirst = IntegerHelper.getInt(data[2], data[3]);
        int i = IntegerHelper.getInt(data[length - 2], data[length - 1]);
        this.colLast = i;
        int i2 = (i - this.colFirst) + 1;
        this.numrks = i2;
        this.rknumbers = new int[i2];
        this.xfIndices = new int[i2];
        readRks(data);
    }

    private void readRks(byte[] bArr) {
        int i = 4;
        for (int i2 = 0; i2 < this.numrks; i2++) {
            this.xfIndices[i2] = IntegerHelper.getInt(bArr[i], bArr[i + 1]);
            this.rknumbers[i2] = IntegerHelper.getInt(bArr[i + 2], bArr[i + 3], bArr[i + 4], bArr[i + 5]);
            i += 6;
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getFirstColumn() {
        return this.colFirst;
    }

    public int getNumberOfColumns() {
        return this.numrks;
    }

    public int getRKNumber(int i) {
        return this.rknumbers[i];
    }

    public int getXFIndex(int i) {
        return this.xfIndices[i];
    }
}
