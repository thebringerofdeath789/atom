package jxl.read.biff;

import common.Logger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import jxl.CellType;
import jxl.NumberCell;
import jxl.biff.FormattingRecords;
import jxl.biff.IntegerHelper;

/* loaded from: classes4.dex */
class RKRecord extends CellValue implements NumberCell {
    static /* synthetic */ Class class$jxl$read$biff$RKRecord;
    private static DecimalFormat defaultFormat;
    private static Logger logger;
    private NumberFormat format;
    private double value;

    static {
        Class cls = class$jxl$read$biff$RKRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.RKRecord");
            class$jxl$read$biff$RKRecord = cls;
        }
        logger = Logger.getLogger(cls);
        defaultFormat = new DecimalFormat("#.###");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public RKRecord(Record record, FormattingRecords formattingRecords, SheetImpl sheetImpl) {
        super(record, formattingRecords, sheetImpl);
        byte[] data = getRecord().getData();
        this.value = RKHelper.getDouble(IntegerHelper.getInt(data[6], data[7], data[8], data[9]));
        NumberFormat numberFormat = formattingRecords.getNumberFormat(getXFIndex());
        this.format = numberFormat;
        if (numberFormat == null) {
            this.format = defaultFormat;
        }
    }

    @Override // jxl.NumberCell
    public double getValue() {
        return this.value;
    }

    @Override // jxl.Cell
    public String getContents() {
        return this.format.format(this.value);
    }

    @Override // jxl.Cell
    public CellType getType() {
        return CellType.NUMBER;
    }

    @Override // jxl.NumberCell
    public NumberFormat getNumberFormat() {
        return this.format;
    }
}
