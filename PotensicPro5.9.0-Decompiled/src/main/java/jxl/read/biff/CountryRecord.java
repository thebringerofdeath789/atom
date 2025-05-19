package jxl.read.biff;

import common.Logger;
import jxl.biff.IntegerHelper;
import jxl.biff.RecordData;

/* loaded from: classes4.dex */
public class CountryRecord extends RecordData {
    static /* synthetic */ Class class$jxl$read$biff$CountryRecord;
    private static Logger logger;
    private int language;
    private int regionalSettings;

    static {
        Class cls = class$jxl$read$biff$CountryRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.CountryRecord");
            class$jxl$read$biff$CountryRecord = cls;
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

    public CountryRecord(Record record) {
        super(record);
        byte[] data = record.getData();
        this.language = IntegerHelper.getInt(data[0], data[1]);
        this.regionalSettings = IntegerHelper.getInt(data[2], data[3]);
    }

    public int getLanguageCode() {
        return this.language;
    }

    public int getRegionalSettingsCode() {
        return this.regionalSettings;
    }
}
