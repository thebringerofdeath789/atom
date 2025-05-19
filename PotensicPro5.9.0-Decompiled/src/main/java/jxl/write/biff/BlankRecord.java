package jxl.write.biff;

import common.Logger;
import jxl.Cell;
import jxl.CellType;
import jxl.biff.Type;
import jxl.format.CellFormat;

/* loaded from: classes4.dex */
public abstract class BlankRecord extends CellValue {
    static /* synthetic */ Class class$jxl$write$biff$BlankRecord;
    private static Logger logger;

    @Override // jxl.Cell
    public String getContents() {
        return "";
    }

    static {
        Class cls = class$jxl$write$biff$BlankRecord;
        if (cls == null) {
            cls = class$("jxl.write.biff.BlankRecord");
            class$jxl$write$biff$BlankRecord = cls;
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

    protected BlankRecord(int i, int i2) {
        super(Type.BLANK, i, i2);
    }

    protected BlankRecord(int i, int i2, CellFormat cellFormat) {
        super(Type.BLANK, i, i2, cellFormat);
    }

    protected BlankRecord(Cell cell) {
        super(Type.BLANK, cell);
    }

    protected BlankRecord(int i, int i2, BlankRecord blankRecord) {
        super(Type.BLANK, i, i2, blankRecord);
    }

    @Override // jxl.Cell
    public CellType getType() {
        return CellType.EMPTY;
    }
}
