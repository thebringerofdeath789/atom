package jxl.read.biff;

import common.Logger;
import jxl.biff.IntegerHelper;
import jxl.biff.RecordData;

/* loaded from: classes4.dex */
class CodepageRecord extends RecordData {
    static /* synthetic */ Class class$jxl$read$biff$CodepageRecord;
    private static Logger logger;
    private int characterSet;

    static {
        Class cls = class$jxl$read$biff$CodepageRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.CodepageRecord");
            class$jxl$read$biff$CodepageRecord = cls;
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

    public CodepageRecord(Record record) {
        super(record);
        byte[] data = record.getData();
        this.characterSet = IntegerHelper.getInt(data[0], data[1]);
    }

    public int getCharacterSet() {
        return this.characterSet;
    }
}
