package jxl.read.biff;

import common.Logger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import jxl.CellType;
import jxl.NumberCell;
import jxl.biff.DoubleHelper;
import jxl.biff.FormattingRecords;

/* loaded from: classes4.dex */
class NumberRecord extends CellValue implements NumberCell {
    static /* synthetic */ Class class$jxl$read$biff$NumberRecord;
    private static DecimalFormat defaultFormat;
    private static Logger logger;
    private NumberFormat format;
    private double value;

    static {
        Class cls = class$jxl$read$biff$NumberRecord;
        if (cls == null) {
            cls = class$("jxl.read.biff.NumberRecord");
            class$jxl$read$biff$NumberRecord = cls;
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

    public NumberRecord(Record record, FormattingRecords formattingRecords, SheetImpl sheetImpl) {
        super(record, formattingRecords, sheetImpl);
        this.value = DoubleHelper.getIEEEDouble(getRecord().getData(), 6);
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
