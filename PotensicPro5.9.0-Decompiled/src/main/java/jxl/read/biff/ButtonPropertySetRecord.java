package jxl.read.biff;

import common.Logger;
import jxl.biff.RecordData;

/* loaded from: classes4.dex */
public class ButtonPropertySetRecord extends RecordData {
    static /* synthetic */ Class class$jxl$read$biff$ButtonPropertySetRecord;
    private static Logger logger;

    static {
        Class cls = class$jxl$read$biff$ButtonPropertySetRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.ButtonPropertySetRecord");
            class$jxl$read$biff$ButtonPropertySetRecord = cls;
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

    ButtonPropertySetRecord(Record record) {
        super(record);
    }

    public byte[] getData() {
        return getRecord().getData();
    }
}
