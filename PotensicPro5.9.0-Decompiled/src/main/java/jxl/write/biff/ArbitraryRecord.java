package jxl.write.biff;

import common.Logger;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class ArbitraryRecord extends WritableRecordData {
    static /* synthetic */ Class class$jxl$write$biff$ArbitraryRecord;
    private static Logger logger;
    private byte[] data;

    static {
        Class cls = class$jxl$write$biff$ArbitraryRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.ArbitraryRecord");
            class$jxl$write$biff$ArbitraryRecord = cls;
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

    public ArbitraryRecord(int i, byte[] bArr) {
        super(Type.createType(i));
        this.data = bArr;
        logger.warn(new StringBuffer().append("ArbitraryRecord of type ").append(i).append(" created").toString());
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
