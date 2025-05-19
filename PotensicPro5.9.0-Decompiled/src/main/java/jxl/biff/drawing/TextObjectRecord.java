package jxl.biff.drawing;

import common.Logger;
import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;
import jxl.read.biff.Record;
import org.apache.commons.net.ftp.FTPReply;

/* loaded from: classes4.dex */
public class TextObjectRecord extends WritableRecordData {
    static /* synthetic */ Class class$jxl$biff$drawing$TextObjectRecord;
    private static Logger logger;
    private byte[] data;
    private int textLength;

    static {
        Class cls = class$jxl$biff$drawing$TextObjectRecord;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.TextObjectRecord");
            class$jxl$biff$drawing$TextObjectRecord = cls;
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

    TextObjectRecord(String str) {
        super(Type.TXO);
        this.textLength = str.length();
    }

    public TextObjectRecord(Record record) {
        super(record);
        byte[] data = getRecord().getData();
        this.data = data;
        this.textLength = IntegerHelper.getInt(data[10], data[11]);
    }

    public TextObjectRecord(byte[] bArr) {
        super(Type.TXO);
        this.data = bArr;
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] bArr = this.data;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[18];
        this.data = bArr2;
        IntegerHelper.getTwoBytes(FTPReply.NOT_LOGGED_IN, bArr2, 0);
        IntegerHelper.getTwoBytes(this.textLength, this.data, 10);
        IntegerHelper.getTwoBytes(16, this.data, 12);
        return this.data;
    }
}
