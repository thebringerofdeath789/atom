package jxl.biff.formula;

import common.Assert;
import common.Logger;
import jxl.biff.CellReferenceHelper;
import jxl.biff.IntegerHelper;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
class Area3d extends Operand implements ParsedThing {
    static /* synthetic */ Class class$jxl$biff$formula$Area3d;
    private static Logger logger;
    private int columnFirst;
    private boolean columnFirstRelative;
    private int columnLast;
    private boolean columnLastRelative;
    private int rowFirst;
    private boolean rowFirstRelative;
    private int rowLast;
    private boolean rowLastRelative;
    private int sheet;
    private ExternalSheet workbook;

    static {
        Class cls = class$jxl$biff$formula$Area3d;
        if (cls == null) {
            cls = class$("jxl.biff.formula.Area3d");
            class$jxl$biff$formula$Area3d = cls;
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

    Area3d(ExternalSheet externalSheet) {
        this.workbook = externalSheet;
    }

    Area3d(String str, ExternalSheet externalSheet) throws FormulaException {
        this.workbook = externalSheet;
        int lastIndexOf = str.lastIndexOf(":");
        Assert.verify(lastIndexOf != -1);
        String substring = str.substring(lastIndexOf + 1);
        int indexOf = str.indexOf(33);
        String substring2 = str.substring(indexOf + 1, lastIndexOf);
        this.columnFirst = CellReferenceHelper.getColumn(substring2);
        this.rowFirst = CellReferenceHelper.getRow(substring2);
        String substring3 = str.substring(0, indexOf);
        if (substring3.charAt(0) == '\'' && substring3.charAt(substring3.length() - 1) == '\'') {
            substring3 = substring3.substring(1, substring3.length() - 1);
        }
        int externalSheetIndex = externalSheet.getExternalSheetIndex(substring3);
        this.sheet = externalSheetIndex;
        if (externalSheetIndex < 0) {
            throw new FormulaException(FormulaException.SHEET_REF_NOT_FOUND, substring3);
        }
        this.columnLast = CellReferenceHelper.getColumn(substring);
        this.rowLast = CellReferenceHelper.getRow(substring);
        this.columnFirstRelative = true;
        this.rowFirstRelative = true;
        this.columnLastRelative = true;
        this.rowLastRelative = true;
    }

    int getFirstColumn() {
        return this.columnFirst;
    }

    int getFirstRow() {
        return this.rowFirst;
    }

    int getLastColumn() {
        return this.columnLast;
    }

    int getLastRow() {
        return this.rowLast;
    }

    @Override // jxl.biff.formula.ParsedThing
    public int read(byte[] bArr, int i) {
        this.sheet = IntegerHelper.getInt(bArr[i], bArr[i + 1]);
        this.rowFirst = IntegerHelper.getInt(bArr[i + 2], bArr[i + 3]);
        this.rowLast = IntegerHelper.getInt(bArr[i + 4], bArr[i + 5]);
        int i2 = IntegerHelper.getInt(bArr[i + 6], bArr[i + 7]);
        this.columnFirst = i2 & 255;
        this.columnFirstRelative = (i2 & 16384) != 0;
        this.rowFirstRelative = (i2 & 32768) != 0;
        int i3 = IntegerHelper.getInt(bArr[i + 8], bArr[i + 9]);
        this.columnLast = i3 & 255;
        this.columnLastRelative = (i3 & 16384) != 0;
        this.rowLastRelative = (i3 & 32768) != 0;
        return 10;
    }

    @Override // jxl.biff.formula.ParseItem
    public void getString(StringBuffer stringBuffer) {
        CellReferenceHelper.getCellReference(this.sheet, this.columnFirst, this.rowFirst, this.workbook, stringBuffer);
        stringBuffer.append(NameUtil.COLON);
        CellReferenceHelper.getCellReference(this.columnLast, this.rowLast, stringBuffer);
    }

    @Override // jxl.biff.formula.ParseItem
    byte[] getBytes() {
        byte[] bArr = new byte[11];
        bArr[0] = Token.AREA3D.getCode();
        IntegerHelper.getTwoBytes(this.sheet, bArr, 1);
        IntegerHelper.getTwoBytes(this.rowFirst, bArr, 3);
        IntegerHelper.getTwoBytes(this.rowLast, bArr, 5);
        int i = this.columnFirst;
        if (this.rowFirstRelative) {
            i |= 32768;
        }
        if (this.columnFirstRelative) {
            i |= 16384;
        }
        IntegerHelper.getTwoBytes(i, bArr, 7);
        int i2 = this.columnLast;
        if (this.rowLastRelative) {
            i2 |= 32768;
        }
        if (this.columnLastRelative) {
            i2 |= 16384;
        }
        IntegerHelper.getTwoBytes(i2, bArr, 9);
        return bArr;
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    public void adjustRelativeCellReferences(int i, int i2) {
        if (this.columnFirstRelative) {
            this.columnFirst += i;
        }
        if (this.columnLastRelative) {
            this.columnLast += i;
        }
        if (this.rowFirstRelative) {
            this.rowFirst += i2;
        }
        if (this.rowLastRelative) {
            this.rowLast += i2;
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    public void columnInserted(int i, int i2, boolean z) {
        if (i != this.sheet) {
            return;
        }
        int i3 = this.columnFirst;
        if (i3 >= i2) {
            this.columnFirst = i3 + 1;
        }
        int i4 = this.columnLast;
        if (i4 >= i2) {
            this.columnLast = i4 + 1;
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    void columnRemoved(int i, int i2, boolean z) {
        if (i != this.sheet) {
            return;
        }
        int i3 = this.columnFirst;
        if (i2 < i3) {
            this.columnFirst = i3 - 1;
        }
        int i4 = this.columnLast;
        if (i2 <= i4) {
            this.columnLast = i4 - 1;
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    void rowInserted(int i, int i2, boolean z) {
        int i3;
        if (i == this.sheet && (i3 = this.rowLast) != 65535) {
            int i4 = this.rowFirst;
            if (i2 <= i4) {
                this.rowFirst = i4 + 1;
            }
            if (i2 <= i3) {
                this.rowLast = i3 + 1;
            }
        }
    }

    @Override // jxl.biff.formula.Operand, jxl.biff.formula.ParseItem
    void rowRemoved(int i, int i2, boolean z) {
        int i3;
        if (i == this.sheet && (i3 = this.rowLast) != 65535) {
            int i4 = this.rowFirst;
            if (i2 < i4) {
                this.rowFirst = i4 - 1;
            }
            if (i2 <= i3) {
                this.rowLast = i3 - 1;
            }
        }
    }

    protected void setRangeData(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4) {
        this.sheet = i;
        this.columnFirst = i2;
        this.columnLast = i3;
        this.rowFirst = i4;
        this.rowLast = i5;
        this.columnFirstRelative = z;
        this.columnLastRelative = z2;
        this.rowFirstRelative = z3;
        this.rowLastRelative = z4;
    }
}
